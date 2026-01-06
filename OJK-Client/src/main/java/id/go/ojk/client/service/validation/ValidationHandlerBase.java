package id.go.ojk.client.service.validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.ReversedLinesFileReader;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.lib.client.TaskExecutorUtil;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.exception.ValidationErrorException;
import id.go.ojk.lib.client.instance.ValueByRowCode;
import id.go.ojk.lib.client.model.Tupple3;
import id.go.ojk.lib.client.model.config.ConfigLocalDate;
import id.go.ojk.lib.client.model.config.UniqueCombineField;
import id.go.ojk.lib.client.model.config.UniqueType;
import id.go.ojk.lib.client.model.constant.OjkClientConstant;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.validation.ValidationCombineUnique;
import id.go.ojk.lib.client.service.validation.ValidationRelationModel;
import id.go.ojk.lib.client.util.CrLfType;
import id.go.ojk.lib.client.util.CustomBufferedReader;
import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;
import lombok.Getter;

public abstract class ValidationHandlerBase {

	private Logger logger = LoggerFactory.getLogger(getClass());

	// ~ set by constructor
	private ProgressPreparationAndSending progressModel;
	private SubmissionData submissionData;
	private ProgressSegment progressSegment;
	private SubmissionFormat submissionFormat;
	private ThreadPoolExecutor executor;
	private ValidationRelationModel validationRelationModel;
	private List<SegmentValidation> postSegmentValidations;

	// ~ initialized
	private RowValidatorDefault rowValidator;
	private List<ProgressSegmentFile> progressSegmentFiles;
	private List<SubmissionField> fields;
	private int columnAmount;
	private List<ValidationCombineUnique> validationCombineUniques;
	private List<ValidationUnique> validationUniques;
	private List<ValidationRelation> validationRelations;
	private Set<Integer> keysColumn; // kolom yang menjadi key akan divalidasi
										// saat cek key, dan tidak divalidasi
										// ulang
	protected ReferenceService referenceService;

	List<String> modalInti = SubmissionFormat.modalInti;
	List<String> noSurat = SubmissionFormat.noSurat;

	private Map<String, ProgressSegment> progressSegmentMap;

	private boolean isPostValidation = false;
	private boolean cacheRowPosition = false;

	// ~ process
	volatile private long addProcessedBytes = 0;

	// ~ process loop
	private ProgressSegmentFile progressSegmentFile;

	@Getter
	private String errorFileNamePath;

	@Getter
	private int sumRow;// RBB code

	private int rowCounter;
	private int updateEveryRowNumber = 10000;
	private int reportFormGroupCode;

	public ValidationHandlerBase(ProgressPreparationAndSending progressModel, ProgressSegment progressSegment,
			ThreadPoolExecutor executor) {
		this.progressModel = progressModel;
		this.submissionData = progressModel.getSubmissionData();
		this.progressSegment = progressSegment;
		this.submissionFormat = progressSegment.getSubmissionFormat();
		this.executor = null;
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

		isPostValidation = postSegmentValidations.size() > 0;
		cacheRowPosition = isPostValidation && OjkClientConstant.postValidationShowDetailRow;
	}

	public void initialized() {
		// ~
		this.progressSegmentFiles = this.progressSegment.getSegmentFiles();
		this.fields = submissionFormat.getFields();
		this.columnAmount = submissionFormat.getFields().size();

		this.validationUniques = new ArrayList<ValidationUnique>();
		this.validationRelations = new ArrayList<ValidationRelation>();
		this.keysColumn = new HashSet<>();

		if (submissionFormat.getUniqueCombineFields() != null) {
			this.validationCombineUniques = new ArrayList<>();
			for (UniqueCombineField uniqueCombineField : submissionFormat.getUniqueCombineFields()) {
				this.validationCombineUniques.add(new ValidationCombineUnique(uniqueCombineField));
				for (int column : uniqueCombineField.getColumns()) {
					// keysColumn.add(column);
				}
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
					logger.error(errorMessage);
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

	public void startValidation(int reportFormGroupCode) {
		this.reportFormGroupCode = reportFormGroupCode;
		int counter = 0;
		for (ProgressSegmentFile progressSegmentFile : progressSegmentFiles) {
			if (progressModel.isRequestStop())
				break;

			counter++;
			this.progressSegmentFile = progressSegmentFile;
			validateSinggleFile(counter, counter == progressSegmentFiles.size());
		}

		// cleanUp
		rowValidator.cleanUp();
		for (SegmentValidation segmentValidation : postSegmentValidations) {
			segmentValidation.cleanUp();
		}
	}

	private void validateSinggleFile(int fileSeq, boolean isLastFile) {
		try {
			initErrorFile();

			String errorOpenReader = openReader();
			if (!StringUtils.isEmpty(errorOpenReader)) {
				progressModel.setRequestStop(true, false);
				if (progressModel.getSubmissionData().isRunInJavaFx()) {
					AlertUtil.showAlertSafe(AlertType.ERROR, "Kesalahan", "Kesalahan", errorOpenReader);
				}
				return;
			}

			if (progressSegmentFile.getFileIntegrity().getFileName().endsWith(".txt")) {

				// hitung jumlah baris dan simpan data sementara ke mapPosValue
				Tupple3<Long, String, CrLfType> savePositionLine = null;
				while ((savePositionLine = bufferedDummy.readLineWithStartPosition()) != null) {
					int lineNumber = sumRow++;
					ValidationResult validationResult = new ValidationResult(fileSeq, lineNumber, savePositionLine);

					if (lineNumber > 0 && validationResult.getColumnLength() == columnAmount) {
						saveMapPosValue(validationResult);
					}
				}
				submissionFormat.setTotalRow(sumRow);

				// validasi baris akhir untuk file multi
				boolean errorFooter = false;
				if (submissionFormat.getMaxRow() == null) {
					String endLine = rlfr.readLine();
					Tupple3<Long, String, CrLfType> footerPositionLine = new Tupple3<Long, String, CrLfType>(null,
							endLine, null);
					ValidationResult footerValidationResult = new ValidationResult(fileSeq, sumRow,
							footerPositionLine);
					validatePreFooter(footerValidationResult, endLine);

					if (footerValidationResult.isError()) {
						progressSegmentFile.writeErrorSort(footerValidationResult);
						errorFooter = true;
					}
				}

				// validasi header
				ValidationResult headerValidationResult = new ValidationResult(fileSeq, rowCounter++,
						bufferedReader.readLineWithStartPosition());
				validatePreHeader(headerValidationResult);

				boolean errorHeader = false;
				if (headerValidationResult.isError()) {
					progressSegmentFile.writeErrorSort(headerValidationResult);
					errorHeader = true;
				}

				// validate row
				// String line = null;
				Tupple3<Long, String, CrLfType> positionLine = null;
				if (executor == null) {
					// Singgle Thread
					while ((positionLine = bufferedReader.readLineWithStartPosition()) != null) {
						String line = positionLine.getB();
						int lineNumber = rowCounter++;
						ValidationResult validationResult = new ValidationResult(fileSeq, lineNumber, positionLine);
						cachePosition(validationResult);
						addProcessedBytes += (line.length() + CrLfType.getLength(positionLine.getC()));
						if (lineNumber % updateEveryRowNumber == 0) {
							updateProgressProcessedBytes(false);
						}

						if (!errorHeader && !errorFooter) {
							if (lineNumber <= (sumRow - 3)) {
								preValidateRow(validationResult);

								if (validationResult.stopValidation) {
									progressSegmentFile.writeError(validationResult);
								} else {
									rowValidator.validateRow(submissionData, validationResult);
									if (validationResult.isError()) {
										progressSegmentFile.writeError(validationResult);
									}
								}
							} else {
								validatePostFooter(validationResult, lineNumber);

								if (validationResult.isError()) {
									try {
										progressSegmentFile.writeErrorSort(validationResult);
									} catch (IOException e) {
										logger.error("", e);
									}
								}
							}
						}

						if (progressModel.isRequestStop())
							break;
					}
				} else {
					// Multi Thread
					while ((positionLine = bufferedReader.readLineWithStartPosition()) != null) {
						String line = positionLine.getB();

						int lineNumber = rowCounter++;
						ValidationResult validationResult = new ValidationResult(fileSeq, lineNumber, positionLine);
						cachePosition(validationResult);
						addProcessedBytes += (line.length() + 1);
						if (lineNumber % 10000 == 0) {
							updateProgressProcessedBytes(false);
						}

						if (!errorHeader) {
							// if (submissionFormat.getMaxRow() != null) {
							if (lineNumber <= (sumRow - 3)) {
								preValidateRow(validationResult);

								if (validationResult.stopValidation) {
									progressSegmentFile.writeError(validationResult);
								} else {
									executor.execute(new Runnable() {
										@Override
										public void run() {
											try {
												rowValidator.validateRow(submissionData, validationResult);

											} catch (Throwable t) {
												progressModel.setSlikException(new SlikException(String.format(
														"Error saat validasi formatCode %1$s file %2$s lineNumber %3$s data %4$s",
														submissionFormat.getCode(),
														progressSegmentFile.getFileIntegrity().getFile().getName(),
														validationResult.lineNumber, validationResult.row), t));
											}
											if (validationResult.isError()) {
												try {
													progressSegmentFile.writeErrorSort(validationResult);
												} catch (IOException e) {
													logger.error("", e);
												}
											}
										}
									});
								}
							} else {
								validatePostFooter(validationResult, lineNumber);

								if (validationResult.isError()) {
									try {
										progressSegmentFile.writeErrorSort(validationResult);
									} catch (IOException e) {
										logger.error("", e);
									}
								}
							}
						} else {
							// System.out.println(line);
						}

						if (progressModel.isRequestStop())
							break;
					}

					if (TaskExecutorUtil.waitAllTaskFinish(executor) > 0) {
						progressModel.writeProcessLog("Ada proses yang belum selesai", false);
					}
				}

				// validate row match with header
				int totalData = rowCounter - 1;
				progressSegmentFile.setTotalRow(totalData);

				if (!errorHeader && submissionFormat.getMaxRow() != null) {
					validatePostHeader(headerValidationResult, progressSegment.getSubmissionFormat().getMinRow(),
							isLastFile);
					if (headerValidationResult.isError()) {
						progressSegmentFile.writeError(headerValidationResult);
					}
				}

			}

			int totalData2 = rowCounter - 1;
			progressSegmentFile.synchTotalError();
			progressSegmentFile.setTotal(totalData2);
			progressModel.recalcTotalErrorString();

			cacheRelation();
			updateProgressProcessedBytes(true);

			progressModel.writeProcessLogFile(progressSegment.getSubmissionFormat().getCode(), progressSegmentFile);
		} catch (Exception e) {
			logger.error("", e);
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
					logger.error("", e);
					throw new ValidationErrorException("Kesalahan saat validasi : " + e.getMessage(), e);
				}
			}
		} else {
			progressSegmentFile.writeErrorHeaderAndFooter();
		}
	}

	private void cachePosition(ValidationResult validationResult) {
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
	private void updateProgressProcessedBytes(boolean finish) {
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

	private void initErrorFile() throws IOException {
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

	// validasi header txt
	private void validatePreHeader(ValidationResult validationResult) throws IOException {
		// validate crlf
//		if (CrLfType.crLf != validationResult.crLfType) {
//			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E04_01_CRLF));
//		}

		// validasi jumlah kolom header
		if (validationResult.getColumnLength() != 8) {
			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_01_COL_NUMBER, 8));
			validationResult.stopValidation = true;
			return;
		}

		// validasi kode header
		if (!"H01".equals(validationResult.getColumn(0))) {
			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_02_FLAG_H));
		}

		// validationResult.errors.addAll(validateEntityTypeAndEntityCode(rowSplited[1],
		// rowSplited[2]));

		String fileName = progressSegmentFile.getFileIntegrity().getFile().getName();
		String fileNameSplited[] = stripExtension(fileName).split("[-]");
		String sectorCode = "0102" + fileNameSplited[6];
		String periodeCode = fileNameSplited[4].subSequence(0, 4) + "-" + fileNameSplited[4].subSequence(4, 6) + "-"
				+ fileNameSplited[4].subSequence(6, 8);
		int rbbPeriode = Integer.parseInt((String) fileNameSplited[4].subSequence(0, 4));

		// validasi kode sektor
		String row1 = validationResult.getColumn(1);
		if (!sectorCode.equals(row1)) {
			validationResult.errors
					.add(new ValidationError(null, ValidationErrorCode.E02_02_SECTOR_CODE, row1, sectorCode));
		}

		// validasi kode LJK
		if (!fileNameSplited[5].equals(validationResult.getColumn(2))) {
			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E02_01_ENTITY_CODE));
		}

		// validasi tanggal pelaporan
		String row3 = validationResult.getColumn(3);
		if (!periodeCode.equals(row3)) {
			validationResult.errors
					.add(new ValidationError(null, ValidationErrorCode.E03_09_PERIOD_CODE, row3, periodeCode));
		}

		// validasi kode report
		String row4 = validationResult.getColumn(4);
		if (!fileNameSplited[0].equals(row4)) {
			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_10_REPORT_CODE, row4,
					fileNameSplited[0]));
		}

		// validasi kode form
		String row5 = validationResult.getColumn(5);
		if (!progressSegment.getSubmissionFormat().getCode().equals(row5)) {
			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_05_FORMCODE, row5,
					progressSegment.getSubmissionFormat().getCode()));
		}

		// validasi modal inti
		String row6 = validationResult.getColumn(6);
		if (!row6.matches(SimpleValidation.patternNumericNegatif.getPattern())) {
			validationResult.errors
					.add(new ValidationError(null, ValidationErrorCode.E03_11_FORMAT_MODAL_INTI, row6));
		} else if (row6.length() > 15) {
			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_14_MAX_LENGTH_MONTI, 15));
		} else {
			modalInti.add(row6);
			if (!row6.equals(modalInti.get(0))) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_12_VALUE_MODAL_INTI,
						row6, modalInti.get(0)));
			}
		}

		// validasi nomor surat
		String row7 = validationResult.getColumn(7);
		if (reportFormGroupCode == 3) {
			if (StringUtils.isEmpty(row7)) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_15_NO_SURAT));
			} else if (!row7.matches(SimpleValidation.patternProofOwnership.getPattern())) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_18_NO_SURAT_PATTERN));
			} else {
				noSurat.add(row7);
				if (!row7.equals(noSurat.get(0))) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_16_NO_SURAT_EQUAL,
							row7, noSurat.get(0)));
				}
			}
		} else {
			if (row7.length() > 0) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_17_NO_SURAT_EMPTY));
			}
		}

		// Validasi berdasarkan Periode RBB dan Modal Inti 



		// Khusus Form IX.3 Rencana Pemenuhan Modal Inti Minimum (0902) ADA yang TIDAK PERLU LAPOR
		
		if (submissionFormat.getFilterYearMI() == true) {
			// BPR hingga 31 Des 2019 (RBB 2019)
			// BPRS hingga 31 Des 2020 (RBB 2020)
			if (rbbPeriode >= submissionFormat.getMinYear1() && rbbPeriode <= submissionFormat.getMaxYear1()) {



				// SELAIN BPR yang memiliki modal inti >= 3M sampai < 6M dan <3 M
				if (!(ParseDouble(row6) <= submissionFormat.getMaxModalInti1())) {
					if (sumRow != 1) {
						validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_19_HEADER_ONLY));
					}
				} else {
					if (CrLfType.crLf != validationResult.crLfType) {
						validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E04_01_CRLF));
					}
					
					sumRow(validationResult);
				}
			} else {
				// BPR sejak 31 Des 2019 hingga 31 Des 2024 (RBB 2020 - 2024)
				// BPRS sejak 31 Des 2020 hingga 31 Des 2025 (RBB 2021 - 2025)
				if (rbbPeriode >= submissionFormat.getMinYear2() && rbbPeriode <= submissionFormat.getMaxYear2()) {
					// SELAIN BPR yang memiliki modal inti >= 3M sampai < 6M
//					if (!(Double.parseDouble(rowSplited[6]) >= submissionFormat.getMinModalInti2() && Double.parseDouble(rowSplited[6]) <= submissionFormat.getMaxModalInti2())) {
					if (!(ParseDouble(row6) >= submissionFormat.getMinModalInti2() && ParseDouble(row6) <= submissionFormat.getMaxModalInti2())) {
						if (sumRow != 1) {


							validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_19_HEADER_ONLY));
						}
					} else {
						if (CrLfType.crLf != validationResult.crLfType) {
							validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E04_01_CRLF));
						}
						
						sumRow(validationResult);
					}
				} else {
					if (sumRow != 1) {
						validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_19_HEADER_ONLY));
					}
					// validationResult.errors.add(new ValidationError(null,
					// ValidationErrorCode.E06_00_FORMAT_NOT_FOUND));
				}
			}
		} else {
			if (CrLfType.crLf != validationResult.crLfType) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E04_01_CRLF));
			}
			
			sumRow(validationResult);
		}

		// Integer totalFileRow = ValidationUtil.validateInteger(rowSplited[6],
		// validationResult.errors);
		// if (totalFileRow != null) {
		// progressSegmentFile.setTotalRow(totalFileRow);
		// }
		//
		// Long totalSegmenRow = ValidationUtil.validateLong(null,
		// rowSplited[7], validationResult.errors);
		// if (totalSegmenRow != null) {
		// Long privLong = progressSegment.getTotalRow();
		// if (privLong == null) {
		// progressSegment.setTotalRow(totalSegmenRow);
		// } else {
		// if (privLong.longValue() != totalSegmenRow.longValue()) {
		// validationResult.errors.add(new ValidationError(null,
		// ValidationErrorCode.E03_06_FORMAT_ROWCOUNT,
		// privLong, totalSegmenRow));
		// }
		// }
		// } else {
		// if (progressSegment.getTotalRow() == null) {
		// progressSegment.setTotalRow(0l);
		// }
		// }
	}

	private void sumRow(ValidationResult validationResult) {
		// validasi jumlah baris
		if (submissionFormat.getMaxRow() != null) {
			if (sumRow != (submissionFormat.getMinRow() + 3)) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_07_FILE_ROWCOUNT,
						(sumRow), (submissionFormat.getMinRow() + 3)));
			}
		} else {
			if (sumRow < (submissionFormat.getMinRow() + 3) && submissionFormat.getMinRow() > 0) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_13_MIN_ROWCOUNT,
						submissionFormat.getMinRow()));
			}
			if (sumRow < 3 && submissionFormat.getMinRow() == 0) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_07_FILE_ROWCOUNT,
						(sumRow), (submissionFormat.getMinRow() + 3)));
			}
		}
	}

	private void validatePreFooter(ValidationResult validationResult, String endLine) {
		if (endLine.isEmpty()) {
			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_07_MORE_ENTER));
			validationResult.stopValidation = true;
		} else {
			if(!endLine.startsWith("F02")) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_08_F02_FIRST_CHECK));
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_07_MORE_ENTER));
				validationResult.stopValidation = true;
			}
		}
	}
	
	private Double ParseDouble(String strNumber) {
		if (strNumber != null && strNumber.length() > 0) {
	       try {
	          return Double.parseDouble(strNumber);
	       } catch(Exception e) {
	          return (double) 0;   // or some value to mark this field is wrong. or make a function validates field first ...
	       }
	   } else return (double) 0;		
	}

	private void validatePostFooter(ValidationResult validationResult, Integer posisitionLine) throws IOException {
		if (posisitionLine.equals(sumRow - 2)) {
			int rowLength = validationResult.getColumnLength();
			if (rowLength != 2) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_06_FOOTER_COLUMN_AMOUNT,
						rowLength, 2));
				validationResult.stopValidation = true;
			} else {
				if (!"F01".equals(validationResult.getColumn(0))) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_00_FLAG_F01));
				}

				if (validationResult.getColumn(1).length() > 5000) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_02_MAX_LENGTH));
				}
				
				if (CrLfType.crLf != validationResult.crLfType) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E04_01_CRLF));
				}

				if (submissionFormat.getF01() == true) {
					if (validationResult.getColumn(1).isEmpty()) {
						validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_05_MANDATORY));
					}
				} else {
					if (!validationResult.getColumn(1).isEmpty()) {
						validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_04_MUST_EMPTY));
					}
				}
			}			

			// if
			// (!rowSplited[1].matches(SimpleValidation.patternAll.getPattern()))
			// {
			// validationResult.errors.add(new ValidationError(null,
			// ValidationErrorCode.E05_03_FORMAT_FOOTER));
			// }
		}

		if (posisitionLine.equals(sumRow - 1)) {
			// System.out.println(rowSplited.length);

			int rowLength = validationResult.getColumnLength();
			if (rowLength != 2) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_06_FOOTER_COLUMN_AMOUNT,
						rowLength, 2));
				validationResult.stopValidation = true;
			} else {
				if (validationResult.getColumn(1).length() > 5000) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_02_MAX_LENGTH));
				}

				if (!"F02".equals(validationResult.getColumn(0))) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_01_FLAG_F02));
				}

				if (submissionFormat.getF02() == true) {
					if (validationResult.getColumn(1).isEmpty()) {
						validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_05_MANDATORY));
					}
				} else {
					if (!validationResult.getColumn(1).isEmpty()) {
						validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E05_04_MUST_EMPTY));
					}
				}
			}

			// if
			// (!rowSplited[1].matches(SimpleValidation.patternAll.getPattern()))
			// {
			// validationResult.errors.add(new ValidationError(null,
			// ValidationErrorCode.E05_03_FORMAT_FOOTER));
			// }
		}

	}

	private void validatePostHeader(ValidationResult validationResult, Integer realRowNumber, boolean isLastFile)
			throws IOException {
		if (realRowNumber != null) {
			Integer sumDetailFooter = realRowNumber + 2;
			Integer totalRow = (int) progressSegmentFile.getTotalRow();

			if (!sumDetailFooter.equals(totalRow)) {
				if (!"0902".equals(validationResult.getColumn(5))) {
					validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E03_07_FILE_ROWCOUNT,
							totalRow, sumDetailFooter));
				}
			}
		}

		// if (isLastFile) {
		// long totalRowPerSegmen = progressSegment.getSegmentFiles().stream()
		// .mapToLong(ProgressSegmentFile::getTotalRow).sum();
		// if (progressSegment.getTotalRow() != totalRowPerSegmen) {
		// validationResult.errors.add(new ValidationError(null,
		// ValidationErrorCode.E03_08_FORMAT_ROWCOUNT,
		// progressSegment.getTotalRow(), totalRowPerSegmen));
		// }
		// }
	}

	private InputStream inputStream;
	private InputStream inputStreamDummy;
	private CustomBufferedReader bufferedReader;
	private CustomBufferedReader bufferedDummy;
	private ReversedLinesFileReader rlfr;

	private String openReader() throws IOException {
		if (!progressSegmentFile.getFileIntegrity().getFile().exists()) {
			return "File " + progressSegmentFile.getFileIntegrity().getFile().getName() + " tidak ditemukan!";
		}
		inputStream = new FileInputStream(progressSegmentFile.getFileIntegrity().getFile());
		inputStreamDummy = new FileInputStream(progressSegmentFile.getFileIntegrity().getFile());
		bufferedReader = new CustomBufferedReader(new InputStreamReader(inputStream));
		bufferedDummy = new CustomBufferedReader(new InputStreamReader(inputStreamDummy));

		rlfr = new ReversedLinesFileReader(progressSegmentFile.getFileIntegrity().getFile());

		return null;
	}

	private void closeInputStream() {
		IOUtils.closeQuietly(bufferedReader);
		IOUtils.closeQuietly(inputStream);
	}

	private void preValidateRow(ValidationResult validationResult) {

		// validate row count
		int rowLength = validationResult.getColumnLength();
		if (rowLength != columnAmount) {
			validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E04_00_DETAIL_COLUMN_AMOUNT,
					rowLength, columnAmount));
			validationResult.stopValidation = true;
		} else {
			// validate crlf
			if (CrLfType.crLf != validationResult.crLfType) {
				validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E04_01_CRLF));
			}

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

					int lengthPosArray = validationCombineUnique.getCombineField().getPos().length;
					int posCounter = 0;
					boolean posMatched = false;

					for (String pos : validationCombineUnique.getCombineField().getPos()) {
						// pengecekan Pos yang CombineUnique
						if (pos.equals(validationResult.rowSplited[1])) {
							posMatched = true;
							if (rowValidator.validateFields(validationResultCache,
									validationCombineUnique.getCombineField().getColumns(), validationResult)) {
								if (!validationCombineUnique.cekUniqueAndPut(validationResult.rowSplited)) {
									validationResult.errors
											.add(new ValidationError(null, ValidationErrorCode.E14_01_UNIQUE_COMBINE,
													validationCombineUnique.getCombineField().getName()));
								}
							} else {
								// System.out.println("XXX");
							}
						}

						posCounter++;

						// Pengecekan Pos yang SingleUnique dalam form yang
						// dinamis
						if (posMatched == false && lengthPosArray == posCounter) {
							Integer fieldNumber = Integer
									.parseInt(validationCombineUnique.getCombineField().getColumnForPosNotUCF());
							if (rowValidator.validateFields(validationResultCache, fieldNumber, validationResult)) {
								if (!validationCombineUnique.cekUniqueAndPut(validationResult.rowSplited)) {
									validationResult.errors.add(
											new ValidationError(null, ValidationErrorCode.E14_02_UNIQUE_POS_NOT_COMBINE,
													validationResult.rowSplited[1]));
								}
							}
						}
					}
				}
			}
		}
	}

	private void saveMapPosValue(ValidationResult validationResult) {
		if (submissionFormat.getSavePos() != null) {
			String[] parameter = submissionFormat.getSavePos().split("[&]");
			String[] selectField = parameter[0].split("[|]");
			Map<String, String> mapPosValue = new HashMap<>();
			String posCode = validationResult.getColumn(1);
			String keyCode = posCode;

			for (String fieldValue : selectField) {
				Double posValue = 0.00;
				try {
					posValue = Double.parseDouble(validationResult.getColumn(Integer.parseInt(fieldValue)));
				} catch (Exception e) {
				}
				mapPosValue.put(fieldValue, String.valueOf(posValue));
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

	private static String stripExtension(String str) {
		// Handle null case specially.
		if (str == null)
			return null;

		// Get position of last '.'.
		int pos = str.lastIndexOf(".");

		// If there wasn't any '.' just return the string as is.
		if (pos == -1)
			return str;

		// Otherwise return the string, up to the dot.
		return str.substring(0, pos);
	}

	// ~ abstract method

	protected abstract LocalDate getConfig(ConfigLocalDate minalldate2);

	protected abstract List<ValidationError> validateEntityTypeAndEntityCode(String entityTypeCode, String entityCode);

	protected abstract void validateReference(SubmissionField field, String code, List<Integer> referenceNumbers,
			List<ValidationError> errors);

}