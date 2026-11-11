package id.go.ojk.client.module.lktb;

import id.go.ojk.client.ClientProperties;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.module.ValidationHandler;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.validation.IValidationContent;
import id.go.ojk.lib.client.TaskExecutorUtil;
import id.go.ojk.lib.client.ThreadUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.exception.ValidationErrorException;
import id.go.ojk.lib.client.model.Tupple3;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.util.CrLfType;
import javafx.scene.control.Alert;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class ValidationHandlerLktb extends ValidationHandler {
    public ValidationHandlerLktb(ProgressPreparationAndSending progressModel, ProgressSegment progressSegment,
                                 ThreadPoolExecutor executor) {
        super(progressModel, progressSegment, executor);
    }

    @Override
    protected void validatePreHeader(ProgressSegmentFile progressSegmentFile, ValidationResult validationResult,
                                     int reportFormGroupCode) throws IOException {

        IValidationContent validation = new ValidationPreHeaderLktb(progressSegmentFile.getFileIntegrity().getFile(),
                getSumRow(), reportFormGroupCode, submissionFormat, validationResult);
        validation.validate();
    }

    @Override
    protected void validateSingleFile(ProgressSegmentFile progressSegmentFile, int reportFormGroupCode, int fileSeq, boolean isLastFile) {
        ProgressPreparationAndSending.SubmissionData submissionData = progressModel.getSubmissionData();
        try {
            final int loopDelay = ClientProperties.getInstance().getValueAsInt(ClientProperties.VALIDATION_LOOP_DELAY, 50);
            final int maxErrorCount = ClientProperties.getInstance().getValueAsInt(ClientProperties.MAX_ERROR_COUNT, 100);
            initErrorFile(progressSegmentFile);

            String errorOpenReader = openReader(progressSegmentFile);
            if (!StringUtils.isEmpty(errorOpenReader)) {
                progressModel.setRequestStop(true, false);
                if (progressModel.getSubmissionData().isRunInJavaFx()) {
                    AlertUtil.showAlertSafe(Alert.AlertType.ERROR, "Kesalahan", "Kesalahan", errorOpenReader);
                }
                return;
            }

            if (progressSegmentFile.getFileIntegrity().getFileName().endsWith(".txt")) {
                // hitung jumlah baris dan simpan data rincian kantor
                Tupple3<Long, String, CrLfType> savePositionLine = null;
                SubmissionFormat.mapPosValue.clear();
                List<String> requiredRowCodes = new ArrayList<>();
                List<String> duplicateRowCodes = new ArrayList<>();
                List<String> tmpDuplicateRowCodes = new ArrayList<>();

                Map<String, List<String>> requiredSegmentRowCodes = new HashMap<>();
                List<String> invalidSegmentRowCode = new ArrayList<>();

                Map<String, Set<String>> tmpDuplicateSegmentRowCodes = new HashMap<>();
                Map<String, Set<String>> duplicateSegmentRowCodes = new HashMap<>();
                List<String> invalidSegmentUniquePos = new ArrayList<>();

                String[] validColValues;

                while ((savePositionLine = bufferedDummy.readLineWithStartPosition()) != null) {
                    int lineNumber = sumRow++;
                    ValidationResult validationResult = new ValidationResult(fileSeq, lineNumber, savePositionLine);
//					if (lineNumber > 0 && validationResult.rowSplited.length == columnAmount) {
                    if (lineNumber > 0) {
                        String code = validationResult.getColumn(1);

                        if (StringUtils.isNotEmpty(submissionFormat.getRequiredPos())) {
                            if (!requiredRowCodes.contains(code)) {
                                requiredRowCodes.add(code);
                            }
                        }

                        if (StringUtils.isNotEmpty(submissionFormat.getUniquePos())) {
                            if (!tmpDuplicateRowCodes.contains(code)) {
                                tmpDuplicateRowCodes.add(code);
                            } else {
                                if (!duplicateRowCodes.contains(code)) {
                                    duplicateRowCodes.add(code);
                                }
                            }
                        }

                        // For segmented form
                        if (submissionFormat.getSegmentRequireColumnLink() != null &&
                                StringUtils.isNotEmpty(submissionFormat.getSegmentColumnValue())) {
                            String colValue = validationResult.getColumn(submissionFormat.getSegmentRequireColumnLink());
                            validColValues = StringUtils.split(submissionFormat.getSegmentColumnValue(), "|");

                            if (StringUtils.isNotEmpty(submissionFormat.getSegmentReqiurePosCode())) {
                                if (isValidSegmentColumnValue(colValue, validColValues)) {
                                    requiredSegmentRowCodes.computeIfAbsent(colValue, k -> new ArrayList<>());

                                    if (!requiredSegmentRowCodes.get(colValue).contains(code)) {
                                        requiredSegmentRowCodes.get(colValue).add(code);
                                    }
                                } else {
                                    if (!invalidSegmentRowCode.contains(code)) {
                                        invalidSegmentRowCode.add(code);
                                    }
                                }
                            }

                            if (StringUtils.isNotEmpty(submissionFormat.getSegmentUniquePos())) {
                                if (isValidSegmentColumnValue(colValue, validColValues)) {
                                    tmpDuplicateSegmentRowCodes.computeIfAbsent(colValue, k -> new HashSet<>());
                                    boolean isAdded = tmpDuplicateSegmentRowCodes.get(colValue).add(code);

                                    if (!isAdded) {
                                        duplicateSegmentRowCodes.computeIfAbsent(colValue, k -> new HashSet<>());
                                        duplicateSegmentRowCodes.get(colValue).add(code);
                                    }
                                } else {
                                    if (!invalidSegmentUniquePos.contains(code)) {
                                        invalidSegmentUniquePos.add(code);
                                    }
                                }
                            }

                        }

                        saveMapPosValue(validationResult);
//						saveRincianKantor(validationResult);
                    }
                }
                submissionFormat.setTotalRow(sumRow);

                // validasi baris akhir untuk file multi
                boolean errorFooter = false;
                if (submissionFormat.getMaxRow() == null) {
                    String endLine = rlfr.readLine();
                    Tupple3<Long, String, CrLfType> footerPositionLine = new Tupple3<>(null,
                            endLine, null);
                    ValidationResult footerValidationResult = new ValidationResult(fileSeq, sumRow, footerPositionLine);
                    validatePreFooter(footerValidationResult, endLine);

                    if (footerValidationResult.isError()) {
                        progressSegmentFile.writeErrorSort(footerValidationResult);
                        errorFooter = true;
                    }
                }

                // validasi header
                SubmissionFormat.officeCodeErrorChecker.clear();
                SubmissionFormat.checkUniqueCustom.clear();
                SubmissionFormat.tempOtherValueList.clear();
                SubmissionFormat.segmentUniquePos.clear();
                ValidationResult headerValidationResult = new ValidationResult(fileSeq, rowCounter++,
                        bufferedReader.readLineWithStartPosition());

                boolean errorHeader = false;
                validatePreHeader(progressSegmentFile, headerValidationResult, reportFormGroupCode);
                if (headerValidationResult.isError()) {
                    progressSegmentFile.writeErrorSort(headerValidationResult);
                    errorHeader = true;
                } else {
                    validateRequireSegmentedRow(requiredSegmentRowCodes, invalidSegmentRowCode, headerValidationResult);
                    validateSegmentedUniqueRow(duplicateSegmentRowCodes, invalidSegmentUniquePos, headerValidationResult);

                    if (headerValidationResult.isError()) {
                        progressSegmentFile.writeErrorSort(headerValidationResult);
                        errorHeader = true;
                    }
                }

                // validate row
                // String line = null;
                Tupple3<Long, String, CrLfType> positionLine = null;
                if (executor == null) {
                    // Singgle Thread
                    log.trace("Single thread validation");
                    while ((positionLine = bufferedReader.readLineWithStartPosition()) != null) {
                        String line = positionLine.getB();

                        int lineNumber = rowCounter++;
                        ValidationResult validationResult = new ValidationResult(fileSeq, lineNumber, positionLine);
                        cachePosition(progressSegmentFile, validationResult);
                        addProcessedBytes += (line.length() + CrLfType.getLength(positionLine.getC()));
                        if (lineNumber % updateEveryRowNumber == 0) {
                            updateProgressProcessedBytes(progressSegmentFile, false);
                        }

                        if (!errorHeader && !errorFooter) {
                            validateRow(validationResult);
                            if (lineNumber <= getDetailRowCount(sumRow)) {
                                preValidateDetailRow(validationResult);
                                if (validationResult.stopValidation) {
                                    progressSegmentFile.writeErrorSort(validationResult);
                                } else {
                                    rowValidator.validateRow(submissionData, validationResult);
                                    if (validationResult.isError()) {
                                        progressSegmentFile.writeErrorSort(validationResult);
                                    }
                                }
                            } else {
                                validatePostFooter(validationResult, lineNumber);
                                if (validationResult.isError()) {
                                    try {
                                        progressSegmentFile.writeErrorSort(validationResult);
                                    } catch (IOException e) {
                                        log.error(e.getMessage(), e);
                                    }
                                }
                            }
                        }

                        if (progressModel.isRequestStop())
                            break;
                    }
                    log.trace("End of single thread validation");
                } else {
                    // Multi Thread
                    log.trace("Multi thread validation, max thread {}, active thread {}", executor.getMaximumPoolSize(), executor.getActiveCount());
                    Map<Integer, ValidationResult> unsortedMap = new ConcurrentHashMap<>();
                    int updateInterval = getUpdateInterval();
                    while ((positionLine = bufferedReader.readLineWithStartPosition()) != null) {
                        String line = positionLine.getB();
                        int lineNumber = rowCounter++;
                        ValidationResult validationResult = new ValidationResult(fileSeq, lineNumber, positionLine);
                        cachePosition(progressSegmentFile, validationResult);
                        addProcessedBytes += (line.length() + 1);
                        if (lineNumber % updateInterval == 0) {
                            updateProgressProcessedBytes(progressSegmentFile, false);
                        }

                        if (!errorHeader && !errorFooter) {
                            if (lineNumber <= getDetailRowCount(sumRow)) {
                                validateRow(validationResult);
                                preValidateDetailRow(validationResult);
                                if (validationResult.stopValidation) {
                                    unsortedMap.put(lineNumber, validationResult);
//									progressSegmentFile.writeErrorSort(validationResult);
                                } else {
                                    executor.execute(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                rowValidator.validateRow(submissionData, validationResult);
                                            } catch (Exception e) {
                                                progressModel.setSlikException(new SlikException(String.format(
                                                        "Error saat validasi formatCode %1$s file %2$s lineNumber %3$s data %4$s",
                                                        submissionFormat.getCode(),
                                                        progressSegmentFile.getFileIntegrity().getFile().getName(),
                                                        validationResult.lineNumber, validationResult.row), e));
                                            } finally {
                                                if (validationResult.isError()) {
                                                    unsortedMap.put(lineNumber, validationResult);
//													try {
//														progressSegmentFile.writeErrorSort(validationResult);
//													} catch (IOException e) {
//														log.error(e.getMessage(), e);
//													}
                                                }
                                            }
                                        }
                                    });
                                    if (unsortedMap.size() >= maxErrorCount) {
                                        log.warn("Validation stopped, error count exceed {}!!!", maxErrorCount);
                                        break;
                                    }
                                }
                            } else {
                                validatePostFooter(validationResult, lineNumber);
                                if (validationResult.isError()) {
                                    unsortedMap.put(lineNumber, validationResult);
//									try {
//										progressSegmentFile.writeErrorSort(validationResult);
//									} catch (IOException e) {
//										log.error("", e);
//									}
                                }
                            }
                        } else {
                            // System.out.println(line);
                        }

                        if (progressModel.isRequestStop()) {
                            break;
                        }
                        if (TaskExecutorUtil.isQueueFull(executor)) {
                            ThreadUtil.sleep(loopDelay);
                        }
//						if (TaskExecutorUtil.isThreadBusy(executor)) {
//							ThreadUtil.sleep(1);
//						}
                    } //-- end file loop
                    if (/* !allLineProcessed(onProgressCounter) && */TaskExecutorUtil.waitAllTaskFinish(executor) > 0) {
                        progressModel.writeProcessLog("Ada proses yang belum selesai", false);
                        ThreadUtil.sleep(3000);
                    } else {
                        ThreadUtil.sleep(30);
                        Map<Integer, ValidationResult> sortedMap = new TreeMap<>();
                        sortedMap.putAll(unsortedMap);
                        for (ValidationResult tmp : sortedMap.values()) {
                            try {
                                progressSegmentFile.writeErrorSort(tmp);
                            } catch (Exception e) {
                                log.error(e.getMessage(), e);
                            }
                        }
                    }
                    log.trace("End of multi thread validation");
                }

                // validate row match with header
                int totalData = rowCounter - 1;
                progressSegmentFile.setTotalRow(totalData);

                if (!errorHeader) {
                    if (submissionFormat.getMaxRow() != null) {
                        validatePostHeader(progressSegmentFile, headerValidationResult,
                                progressSegment.getSubmissionFormat().getMinRow(), isLastFile);
                    }
                    if (headerValidationResult.isError()) {
                        progressSegmentFile.writeErrorSort(headerValidationResult);
                    }
                }

            }

            int totalData2 = rowCounter - 1;
            progressSegmentFile.synchTotalError();
            progressSegmentFile.setTotal(totalData2);
            progressModel.recalcTotalErrorString();

            cacheRelation();
            updateProgressProcessedBytes(progressSegmentFile, true);

            progressModel.writeProcessLogFile(progressSegment.getSubmissionFormat().getCode(), progressSegmentFile);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ValidationErrorException("Kesalahan saat validasi : " + e.getMessage(), e);
        } finally {
            progressSegmentFile.closeErrorFile();
            closeInputStream();
        }

        // write header footer if no post validation
        if (isPostValidation) {
            if (isLastFile) {
                try {
                    for (SegmentValidation segmentValidation : postSegmentValidations) {
                        segmentValidation.validatePost(progressSegmentMap, submissionData, submissionFormat,
                                progressSegmentFile);
                    }
                } catch (IOException e) {
                    log.error("", e);
                    throw new ValidationErrorException("Kesalahan saat validasi : " + e.getMessage(), e);
                }
            }
        } else {
            progressSegmentFile.writeErrorHeaderAndFooter();
        }
    }

    private boolean isValidSegmentColumnValue(String value, String[] validValue) {
        int ctr = validValue.length;

        for (int i = 0; i < validValue.length; i++) {
            if (!value.equalsIgnoreCase(validValue[i])) ctr--;
        }

        return ctr > 0;
    }

    private boolean validateRequireSegmentedRow(Map<String, List<String>> requiredRowCodes, List<String> invalidRowCode, ValidationResult validationResult) {
        boolean res = true;
        String requiredPos = submissionFormat.getSegmentReqiurePosCode();
        SubmissionField fieldJenisProgram = submissionFormat.getFields().get(2);
        if (StringUtils.isNotEmpty(requiredPos)) {
            String[] colValidValues = StringUtils.split(submissionFormat.getSegmentColumnValue(), "|");
            String[] requiredPoss = StringUtils.split(requiredPos, "#");
            List<String> tmpSegmentPos;

            for (int i = 0; i < requiredPoss.length; i++) {
                String[] segmentRequiredPoss = StringUtils.split(requiredPoss[i], "|");
                tmpSegmentPos = requiredRowCodes.get(colValidValues[i]);

                for (String requiredRow : segmentRequiredPoss) {
                    if (tmpSegmentPos != null) {
                        if (!tmpSegmentPos.contains(requiredRow)) {
                            validationResult.errors
                                    .add(new ValidationError(null, ValidationErrorCode.E03_38_POS_SEGMENT_MUST_EXIST, false, requiredRow, fieldJenisProgram.getName(), colValidValues[i]));
                            res = false;
                        }
                    } else {
                        if (!invalidRowCode.contains(requiredRow)) {
                            // fallback to default err, if the pos is not exists and the segment col's value are invalid
                            // but still on required pos
                            validationResult.errors
                                    .add(new ValidationError(null, ValidationErrorCode.E50_03_POS_MUST_EXIST, false, requiredRow));
                            res = false;
                        }
                    }
                }
            }

        }
        return res;
    }

    private boolean validateSegmentedUniqueRow(Map<String, Set<String>> duplicateRowCodes, List<String> invalidDuplicateRow, ValidationResult validationResult) {
        boolean res = true;
        String metaUniquePos = submissionFormat.getSegmentUniquePos();
        if (StringUtils.isNotEmpty(metaUniquePos) && !duplicateRowCodes.isEmpty()) {
            SubmissionField fieldJenisProgram = submissionFormat.getFields().get(2);
            String[] colValidValues = StringUtils.split(submissionFormat.getSegmentColumnValue(), "|");
            String[] uniquePos = StringUtils.split(metaUniquePos, "#");
            Set<String> tmpUniquePos;

            for (int i = 0; i < duplicateRowCodes.size(); i++) {
                String[] tmpMetaUniquePos = StringUtils.split(uniquePos[i], "|");
                tmpUniquePos = duplicateRowCodes.get(colValidValues[i]);

                for (String uniqueRow : tmpMetaUniquePos) {
                    if (tmpUniquePos != null) {
                        if (tmpUniquePos.contains(uniqueRow)) {
                            validationResult.errors
                                    .add(new ValidationError(null, ValidationErrorCode.E03_39_POS_SEGMENT_MUST_UNIQUE, uniqueRow, fieldJenisProgram.getName(), colValidValues[i]));
                            res = false;
                        }
                    } else {
                        if (invalidDuplicateRow.contains(uniqueRow)) {
                            // fallback to default err, if the pos is duplicate and the segment col's value are invalid
                            // but still on unique pos condition
                            validationResult.errors
                                    .add(new ValidationError(null, ValidationErrorCode.E14_02_UNIQUE_POS_NOT_COMBINE, uniqueRow));
                            res = false;
                        }
                    }
                }
            }
        }
        return res;
    }
}
