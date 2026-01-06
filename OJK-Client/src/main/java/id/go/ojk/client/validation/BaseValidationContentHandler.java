package id.go.ojk.client.validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.ReversedLinesFileReader;
import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.ClientProperties;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.FooterField;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.validation.RowValidatorDefault;
import id.go.ojk.client.service.validation.ValidationRelation;
import id.go.ojk.client.service.validation.ValidationUnique;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.TaskExecutorUtil;
import id.go.ojk.lib.client.ThreadUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.exception.ValidationErrorException;
import id.go.ojk.lib.client.model.Tupple3;
import id.go.ojk.lib.client.model.config.ConfigLocalDate;
import id.go.ojk.lib.client.model.config.UniqueCombineField;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.validation.ValidationCombineUnique;
import id.go.ojk.lib.client.service.validation.ValidationRelationModel;
import id.go.ojk.lib.client.util.CrLfType;
import id.go.ojk.lib.client.util.CustomBufferedReader;
import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseValidationContentHandler implements IValidationContentHandler {
	// ~ set by constructor
	protected ProgressPreparationAndSending progressModel;
	protected SubmissionFormat submissionFormat;
	protected ProgressSegment progressSegment;
	private ThreadPoolExecutor executor;
	private ValidationRelationModel validationRelationModel;
	private List<SegmentValidation> postSegmentValidations;
	// ~ initialized
	private RowValidatorDefault rowValidator;
	private List<SubmissionField> fields;
	private int columnAmount;
	private List<ValidationCombineUnique> validationCombineUniques;
	private List<ValidationUnique> validationUniques;
	private List<ValidationRelation> validationRelations;
	private Set<Integer> keysColumn; // kolom yang menjadi key akan divalidasi
										// saat cek key, dan tidak divalidasi
										// ulang
	protected ReferenceService referenceService;
//
//	List<String> modalInti = SubmissionFormat.modalInti;
//	List<String> noSurat = SubmissionFormat.noSurat;

	private Map<String, ProgressSegment> progressSegmentMap;

	private boolean isPostValidation = false;
	private boolean cacheRowPosition = false;

	// ~ process
	volatile private long addProcessedBytes = 0;

	// ~ process loop

//	@Getter
	private String errorFileNamePath;

//	@Getter
	private int sumRow;// RBB code
	private int rowCounter;
	private int updateEveryRowNumber = 10000;
	private InputStream inputStream;
	private InputStream inputStreamDummy;
	private CustomBufferedReader bufferedReader;
	private CustomBufferedReader bufferedDummy;
	private ReversedLinesFileReader rlfr;
//	protected int reportFormGroupCode;
//	protected ProgressSegmentFile progressSegmentFile;

	public BaseValidationContentHandler(ProgressPreparationAndSending progressModel, ProgressSegment progressSegment,
			ThreadPoolExecutor executor) {
		this.progressModel = progressModel;
		this.progressSegment = progressSegment;
		this.submissionFormat = progressSegment.getSubmissionFormat();
		this.executor = executor;
		this.validationRelationModel = progressModel.getSubmissionData().getValidationRelationModel();
		this.updateEveryRowNumber = progressModel.getUpdateEveryRowNumber();

		progressSegmentMap = new TreeMap<>();
		for (ProgressSegment itemPs : progressModel.getSegments()) {
			progressSegmentMap.put(itemPs.getSubmissionFormat().getCode(), itemPs);
		}

		this.postSegmentValidations = new ArrayList<>();
		for (SegmentValidation segmentValidation : submissionFormat.getSegmentValidations()) {
			switch (segmentValidation.getSegmentValidationType()) {
			case R:
				// segmentValidations.add(segmentValidation);
				break;
			case P:
				postSegmentValidations.add(segmentValidation);
				break;
			default:
				throw new SlikException(
						"Unsuported SegmentValidationType " + segmentValidation.getSegmentValidationType());
			}
		}

		isPostValidation = !postSegmentValidations.isEmpty();
		cacheRowPosition = isPostValidation && OjkClientConstant.postValidationShowDetailRow;
	}

	public int getSumRow() {
		return sumRow;
	}

	@Override
	public void startValidation(int reportFormGroupCode) {
//		this.reportFormGroupCode = reportFormGroupCode;
		int counter = 0;
		List<ProgressSegmentFile> progressSegmentFiles = this.progressSegment.getSegmentFiles();
		for (ProgressSegmentFile progressSegmentFile : progressSegmentFiles) {
			if (progressModel.isRequestStop())
				break;

			counter++;
//			this.progressSegmentFile = progressSegmentFile;
			validateSingleFile(progressSegmentFile, reportFormGroupCode, counter, counter == progressSegmentFiles.size());
		}

		// cleanUp
		rowValidator.cleanUp();
		for (SegmentValidation segmentValidation : postSegmentValidations) {
			segmentValidation.cleanUp();
		}
	}

	protected void initialized() {
		// ~
		this.fields = submissionFormat.getFields();
		this.columnAmount = submissionFormat.getFields().size();

		this.validationUniques = new ArrayList<>();
		this.validationRelations = new ArrayList<>();
		this.keysColumn = new HashSet<>();

		if (submissionFormat.getUniqueCombineFields() != null) {
			this.validationCombineUniques = new ArrayList<>();
			for (UniqueCombineField uniqueCombineField : submissionFormat.getUniqueCombineFields()) {
				this.validationCombineUniques.add(new ValidationCombineUnique(uniqueCombineField));
//				for (int column : uniqueCombineField.getColumns()) {
//					 keysColumn.add(column);
//				}
			}
		}

		for (SubmissionField field : fields) {
			if (field.isUnique()) {
				keysColumn.add(field.getNumber());
				String[] uniqueNames = field.getUniqueNames();
				if (uniqueNames == null || uniqueNames.length == 0) {
					this.validationUniques.add(new ValidationUnique(field.getUniqueType(), null, field, null));
				} else {
					int counter = 0;
					for (String uniqueName : uniqueNames) {
						HashSet<String> relations = validationRelationModel.getRelation(uniqueName);
						ValidationUnique validationUnique = new ValidationUnique(field.getUniqueType(), uniqueName,
								field, relations);
						if (counter != 0) {
							validationUnique.setOnlyPut(true);
						}
						this.validationUniques.add(validationUnique);
						counter++;
					}
				}
			}

			if (StringUtils.isNotEmpty(field.getRelationTo())) {
				HashSet<String> relations = validationRelationModel.getRelation(field.getRelationTo());
				if (relations == null) {
					String errorMessage = String.format("Validasi relasi untuk %1$s tidak ditemukan",
							field.getRelationTo());
					log.error(errorMessage);
					throw new SlikException(errorMessage);
				} else {
					ValidationRelation validationRelation = new ValidationRelation(field.getRelationTo(), field,
							relations);
					this.validationRelations.add(validationRelation);
				}
			}
		}

		rowValidator = RowValidatorDefault.builder().keysColumn(keysColumn).submissionFormat(submissionFormat)
				.validationRelations(validationRelations).referenceService(referenceService).build();

		rowValidator.initilized();
	}

	// ~ abstract method
	protected abstract void validatePreHeader(ProgressSegmentFile progressSegmentFile, ValidationResult validationResult, int reportFormGroupCode) throws IOException;

	protected abstract LocalDate getConfig(ConfigLocalDate minalldate2);

	protected abstract List<ValidationError> validateEntityTypeAndEntityCode(String entityTypeCode, String entityCode);

	protected abstract void validateReference(SubmissionField field, String code, List<Integer> referenceNumbers,
			List<ValidationError> errors);

	private void validateSingleFile(ProgressSegmentFile progressSegmentFile, int reportFormGroupCode, int fileSeq, boolean isLastFile) {
		SubmissionData submissionData = progressModel.getSubmissionData();
		try {
			final int loopDelay = ClientProperties.getInstance().getValueAsInt(ClientProperties.VALIDATION_LOOP_DELAY, 50);
			final int maxErrorCount = ClientProperties.getInstance().getValueAsInt(ClientProperties.MAX_ERROR_COUNT, 100);
			initErrorFile(progressSegmentFile);

			String errorOpenReader = openReader(progressSegmentFile);
			if (!StringUtils.isEmpty(errorOpenReader)) {
				progressModel.setRequestStop(true, false);
				if (progressModel.getSubmissionData().isRunInJavaFx()) {
					AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan", errorOpenReader);
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
				ValidationResult headerValidationResult = new ValidationResult(fileSeq, rowCounter++,
						bufferedReader.readLineWithStartPosition());

				boolean errorHeader = false;
				validatePreHeader(progressSegmentFile, headerValidationResult, reportFormGroupCode);
				if (headerValidationResult.isError()) {
					progressSegmentFile.writeErrorSort(headerValidationResult);
					errorHeader = true;
				} else {
					validateRequiredRow(requiredRowCodes, headerValidationResult);
					validateUniqueRow(duplicateRowCodes, headerValidationResult);
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
	
	private int getUpdateInterval() {
		if (sumRow > 10001 && sumRow < 100000) {
			return 1000;
		}
		if (sumRow > 100001 && sumRow < 1000000) {
			return 10000;
		}
		if (sumRow > 1000001) {
			return 50000;
		}
		return 10;
	}
		
	private int getDetailRowCount(int totalRow) {
		return totalRow - submissionFormat.getFooterCount() - 1;
	}

	private void cachePosition(ProgressSegmentFile progressSegmentFile, ValidationResult validationResult) {
		if (cacheRowPosition) {
			progressSegmentFile.cachePosition(validationResult);
		}
	}

	// ~ util

	private void cacheRelation() {
		for (ValidationUnique validationUnique : validationUniques) {
			if (StringUtils.isNotEmpty(validationUnique.getUniqueName())) {
				HashSet<String> values = validationUnique.getValues();
				if (validationUnique.getUniqueType() == UniqueType.D) {
					values.addAll(validationUnique.getTmpValues());
				}
				validationRelationModel.put(validationUnique.getUniqueName(), values);
			}
		}
	}

	/**
	 * not thread safe
	 */
	private void updateProgressProcessedBytes(ProgressSegmentFile progressSegmentFile, boolean finish) {
		Long tmp = new Long(addProcessedBytes);
		// Long tmp = bufferedReader.getByteCounter();
		progressSegmentFile.synchTotalError();
		progressModel.recalcTotalErrorString();

		if (progressModel.getSubmissionData().isRunInJavaFx()) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					progressSegmentFile.addProcessedSize(tmp, finish, isPostValidation);
				}
			});
		} else {
			progressSegmentFile.addProcessedSize(tmp, finish, isPostValidation);
		}

		addProcessedBytes = 0;
	}

	private void saveMapPosValue(ValidationResult validationResult) {
		if (submissionFormat.getSavePos() != null) {
			String[] parameter = submissionFormat.getSavePos().split("[&]");
			String[] selectField = parameter[0].split("[|]");
			Map<String, String> mapPosValue = new HashMap<>();
			String posCode = validationResult.getColumn(1);
			String keyCode = posCode;

			for (String fieldValue : selectField) {
				String value = UtilValidation.getArray(validationResult.rowSplited, Integer.parseInt(fieldValue), "0");
				mapPosValue.put(fieldValue, value);
			}

			if (parameter.length == 2) {
				String[] multiPos = parameter[1].split("[|]");
				for (String multiKeyCode : multiPos) {
					if (posCode.contains(multiKeyCode)) {
						keyCode = posCode + "-" + validationResult.lineNumber;
					}
				}
			}
			SubmissionFormat.mapPosValue.put(keyCode, mapPosValue);
		}
	}

	private void initErrorFile(ProgressSegmentFile progressSegmentFile) throws IOException {
		this.addProcessedBytes = 0;

		this.errorFileNamePath = progressModel.getValidationErrorDir().getAbsolutePath() + "/"
				+ progressSegmentFile.getFileIntegrity().getFile().getName()
				+ (progressModel.getSubmissionData().isRunInJavaFx() ? ".err" : ".valerr");

		File errorFile = new File(this.errorFileNamePath);
		progressSegmentFile.setErrorFile(errorFile);
		errorFile.getParentFile().mkdirs();

		this.rowCounter = 0;
		progressSegmentFile.openErrorFile(false);
		progressSegmentFile.writeReserveErrorHeader();
	}

	private void validatePreFooter(ValidationResult validationResult, String endLine) {
		if (endLine.isEmpty()) {
			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_09_MORE_ENTER));
			validationResult.stopValidation = true;
		}
	}

	private void validatePostFooter(ValidationResult validationResult, Integer positionLine) {
		int footerCount = submissionFormat.getFooterCount();
		for (int i = footerCount; i > 0; i--) {
			List<FooterField> listFooterField = null;
			if (footerCount == 1) {
				listFooterField = submissionFormat.getFooter01();
			} else {
				listFooterField = (i == 2) ? submissionFormat.getFooter01() : submissionFormat.getFooter02();
			}
			int columnCount = validationResult.getColumnLength();
			if (columnCount != listFooterField.size()) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_06_FOOTER_COLUMN_AMOUNT, columnCount, 2));
				validationResult.stopValidation = true;
			} else {
				FooterField field1 = listFooterField.get(0);
				FooterField field2 = listFooterField.get(1);
				String footerFlag = field1.getSimpleValidation().getConstant();
				String column1 = validationResult.getColumn(0);
				String column2 = validationResult.getColumn(1);
				if (!footerFlag.equals(column1)) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_10_FLAG_FOOTER, footerFlag));
				}
				int maxLength = field2.getSimpleValidation().getMaxLength();
				if (column2.length() > maxLength) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_11_MAX_LENGTH, maxLength));
				}
				if (CrLfType.crLf != validationResult.crLfType) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E04_01_CRLF));
				}
				if (field2.getSimpleValidation().getRequiredCondition() == RequiredCondition.M && column2.isEmpty()) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_05_MANDATORY));
				}
			}
		}
	}

	private void validatePostHeader(ProgressSegmentFile progressSegmentFile, ValidationResult validationResult,
			Integer realRowNumber, boolean isLastFile) throws IOException {
		if (realRowNumber != null) {
//			Integer sumDetailFooter = realRowNumber + 2; // RBB
			Integer sumDetailFooter = realRowNumber;
			Integer totalRow = (int) progressSegmentFile.getTotalRow();

			if (!sumDetailFooter.equals(totalRow)) {
				if (!"0008".equals(validationResult.getColumn(5))) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_25_FILE_ROWCOUNT,
							totalRow, sumDetailFooter));
				}
			}
		}
	}

	private boolean validateRequiredRow(List<String> requiredRowCodes, ValidationResult validationResult) {
		boolean res = true;
		String requiredPos = submissionFormat.getRequiredPos();
		if (StringUtils.isNotEmpty(requiredPos)) {
			String[] requiredRows = StringUtils.split(requiredPos, "|");
			for (int i = 0; i < requiredRows.length; i++) {
				String code = requiredRows[i];
				if (!requiredRowCodes.contains(code)) {
					validationResult.errors
							.add(new ValidationError(null, ValidationErrorCode.E50_03_POS_MUST_EXIST, false, code));
					res = false;
				}
			}
		}
		return res;
	}

	private boolean validateUniqueRow(List<String> duplicateRowCodes, ValidationResult validationResult) {
		boolean res = true;
		String requiredPos = submissionFormat.getUniquePos();
		if (StringUtils.isNotEmpty(requiredPos) && !duplicateRowCodes.isEmpty()) {
			List<String> requiredRows = Arrays.asList(StringUtils.split(requiredPos, "|"));
			for (int i = 0; i < duplicateRowCodes.size(); i++) {
				String code = duplicateRowCodes.get(i);
				if (requiredRows.contains(code)) {
					validationResult.errors
							.add(new ValidationError(null, ValidationErrorCode.E14_02_UNIQUE_POS_NOT_COMBINE, code));
					res = false;
				}
			}
		}
		return res;
	}

	private String openReader(ProgressSegmentFile progressSegmentFile) throws IOException {
		if (!progressSegmentFile.getFileIntegrity().getFile().exists()) {
			return "File " + progressSegmentFile.getFileIntegrity().getFile().getName() + " tidak ditemukan!";
		}
		File file = progressSegmentFile.getFileIntegrity().getFile();
		inputStream = new FileInputStream(file);
		inputStreamDummy = new FileInputStream(file);
		bufferedReader = new CustomBufferedReader(new InputStreamReader(inputStream));
		bufferedDummy = new CustomBufferedReader(new InputStreamReader(inputStreamDummy));

		rlfr = new ReversedLinesFileReader(file);

		return null;
	}

	private void closeInputStream() {
		IOUtils.closeQuietly(bufferedReader);
		IOUtils.closeQuietly(inputStream);
		IOUtils.closeQuietly(bufferedDummy);
    IOUtils.closeQuietly(inputStreamDummy);
		IOUtils.closeQuietly(rlfr);
	}
	
	private void validateRow(ValidationResult validationResult) {
		// validate crlf
		if (CrLfType.crLf != validationResult.crLfType) {
			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E04_01_CRLF));
		}
	}

	private void preValidateDetailRow(ValidationResult validationResult) {
		// validate row count
//		// validate crlf
//		if (CrLfType.crLf != validationResult.crLfType && (validationResult.lineNumber != (sumRow - 1))) {
//			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E04_01_CRLF));
//		}
		int rowLength = validationResult.getColumnLength();
		if (rowLength != columnAmount) {
			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E04_00_DETAIL_COLUMN_AMOUNT,
					rowLength, columnAmount));
			validationResult.stopValidation = true;
		} else {
			// validate crlf
//			if (CrLfType.crLf != validationResult.crLfType && (validationResult.lineNumber != (sumRow - 1))) {
//				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E04_01_CRLF));
//			}

			// validate unique
			Map<Integer, Boolean> validationResultCache = new HashMap<>();
			for (ValidationUnique validationUnique : validationUniques) {
				Integer fieldNumber = validationUnique.getSubmissionField().getNumber();
				Boolean valid = validationResultCache.get(fieldNumber);
				if (valid == null) {
					valid = rowValidator.validateField(validationUnique.getSubmissionField(), validationResult);
					validationResultCache.put(fieldNumber, valid);
				}
				if (valid) {
					if (!validationUnique.cekUniqueAndPut(validationResult.rowSplited)) {
						if (!validationUnique.isOnlyPut()) {
							validationResult.errors.add(new ValidationError(validationUnique.getSubmissionField(),
									ValidationErrorCode.E14_00_UNIQUE));
						}
					}
				}
			}
			// validate combine unique
			if (validationCombineUniques != null) {
				for (ValidationCombineUnique validationCombineUnique : validationCombineUniques) {
					if (rowValidator.validateFields(validationResultCache,
							validationCombineUnique.getCombineField().getColumns(), validationResult)) {
						if (!validationCombineUnique.cekUniqueAndPut(validationResult.rowSplited)) {
							validationResult.errors
									.add(new ValidationError(null, ValidationErrorCode.E14_01_UNIQUE_COMBINE,
											validationCombineUnique.getCombineField().getName()));
						}
					}
				}
			}
		}
	}
//	
//	private void saveRincianKantor(ValidationResult validationResult) {
//		if (submissionFormat.getCode().equals("0004")) {
//			SubmissionFormat.listRincianKantor.add(validationResult.rowSplited[1]);
//		}
//	}
}