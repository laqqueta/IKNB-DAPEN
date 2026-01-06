package id.go.ojk.client.service.readdir;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import id.go.ojk.client.model.SaveMapValue;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.bind.ProgressSegment;
import id.go.ojk.client.model.bind.ProgressSegmentFile;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.SubmissionMetadata;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.service.security.SecurityService;
import id.go.ojk.client.util.AlertUtil;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.EncryptionUtil;
import id.go.ojk.lib.client.TimeCounter;
import id.go.ojk.lib.client.model.MonthDate;
import id.go.ojk.lib.client.model.compression.FileIntegrity;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import javafx.scene.control.Alert.AlertType;

public class ReadDirectoryLBBPRK {

	private static SecurityService securityService;
	private static int reportFormGroupCode;

	public ReadDirectoryLBBPRK(SecurityService securityService, int reportFormGroupCode) {
		ReadDirectoryLBBPRK.securityService = securityService;
		ReadDirectoryLBBPRK.reportFormGroupCode = reportFormGroupCode;
	}
	
	public List<ValidationError> readDirectoryLBBPRK(ProgressPreparationAndSending progressModel,
			String memberTypeCode, String memberCode, File submissionDir, ReadSubmissionDirModel readDirModel,
			boolean runOnClient, int typeReport) {

		try {
			SubmissionMetadata metadata = progressModel.getMetadata();
			TimeCounter timeCounter = new TimeCounter();
			readDirModel.setProgress(0d);
			readDirModel.writeProcessLog("Baca direktori " + submissionDir.getAbsolutePath());

			progressModel.reset();
			ProgressPreparationAndSending tmpModel = new ProgressPreparationAndSending(metadata,
					progressModel.getSubmissionData().isRunInJavaFx());
			tmpModel.setSubmissionDirectory(submissionDir);

			List<ValidationError> errors = new ArrayList<ValidationError>();

			if (!submissionDir.exists()) {
				readDirectoryError(readDirModel, errors, new ValidationError(null,
						ValidationErrorCode.E01_02_DIR_NOT_FOUND, submissionDir.getAbsolutePath()));
				return readDirectoryReturn(errors, readDirModel);
			}

			if (!submissionDir.isDirectory()) {
				readDirectoryError(readDirModel, errors, new ValidationError(null, ValidationErrorCode.E01_03_NOT_A_DIR,
						submissionDir.getAbsolutePath()));
				return readDirectoryReturn(errors, readDirModel);
			}

			List<File> files = Arrays.asList(submissionDir.listFiles());
			if (!runOnClient) {
				files = files.stream().filter(e -> e.getAbsolutePath().toLowerCase().endsWith(".txt"))
						.collect(Collectors.toList());
			}

			if (files.size() == 0) {
				readDirectoryError(readDirModel, errors, new ValidationError(null, ValidationErrorCode.E01_04_DIR_EMPTY,
						submissionDir.getAbsolutePath()));
				return readDirectoryReturn(errors, readDirModel);
			}

			/*
			 * Validasi Penamaan File 1 :
			 * 1. Pengecekan extensi file
			 * 2. Format penulisan terdiri dari 7 segment 
			 * 3. Awalan nama file harus sesuai dengan jenis pelaporan (reportCode)
			 * 4. Isi file tidak boleh kosong
			 */
			List<String> fileErrorList = new ArrayList<String>();
			List<File> files2 = new ArrayList<>();
			String reportCode = securityService.getUserSession().getReportCode();
			String filePrefixStart = reportCode;

			for (File file : files) {
				List<String> errorList = new ArrayList<String>();
				String fileName = file.getName();
				if (file.isDirectory()) {
					errorList.add(String.format("Tidak boleh ada direktori '%S'", fileName));
				} else {
					if (!fileName.endsWith(".txt")) {
						errorList.add(String.format("File '%S' ekstensi harus .txt", fileName));
					}

					String fileNameSplited[] = stripExtension(fileName).split("[-]");

					if (fileNameSplited.length != 7) {
						errorList.add(String.format(
								"Nama file '%S' salah, harus <Kode Jenis Laporan>-<Kode Form Laporan>-<Kode Rutin/Koreksi>-<Kode Periode>-<Periode Data Pelaporan>-<Kode LJK>-<Kode Sektor LJK>.<Ekstensi>",
								fileName));
					}

					if (!fileName.startsWith(filePrefixStart) || fileNameSplited[0].length() != 6) {
						errorList.add("Nama file '" + fileName + "' harus berawalan " + filePrefixStart + "");
					}

					if (file.length() == 0) {
						errorList.add("File '" + fileName + "' tidak berisi data");
					}

				}

				if (errorList.size() == 0) {
					files2.add(file);
				} else {
					fileErrorList.add("Nama File '" + fileName + "', kesalahan : \n\t"
							+ errorList.stream().collect(Collectors.joining("\n\t")));
				}
			}

			if (fileErrorList.size() > 0) {
				for (String error : fileErrorList) {
					readDirectoryError(readDirModel, errors,
							new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE, error));
				}
			}

			if (files2.size() == 0) {
				return readDirectoryReturn(errors, readDirModel);
			}

			/* 
			 * Validasi Penamaan File 2 
			 * 1. Validasi segment ke-3 : kode Rutin/Koreksi (R/K)
			 * 2. Validasi segment ke-4 : kode periode (A/S/Q/M/W/D)
			 * 3. Validasi segment ke-5 : periode pelaporan format YYYYMMDD
			 * 4. Validasi segment ke-6 : kode LJK
			 * 5. Validasi segment ke-7 : Kode sektor Konvensional/Syariah (01/02)
			 */
			String firstFileName = files2.get(0).getName();
			String firstFileNameSplited[] = stripExtension(firstFileName).split("[-]");
			String firstPeriodReport = firstFileNameSplited[4];

			String periodType = "M";
			String reportFormTypeCode = reportFormGroupCode == 1 ? "R" : "K";

			MonthDate monthDate = null;
			if (firstPeriodReport.length() == 8) {
				monthDate = new MonthDate(firstPeriodReport.substring(0, 4));
			} else {
				monthDate = new MonthDate("");
			}

			List<String> fileErrorList2 = new ArrayList<String>();
			List<File> files3 = new ArrayList<>();
			for (File file : files2) {
				List<String> errorList = new ArrayList<String>();
				String fileName = file.getName();
				String fileNameSplited[] = stripExtension(fileName).split("[-]");

				if (!fileNameSplited[2].equals(reportFormTypeCode) || fileNameSplited[2].length() != 1) {
					errorList.add("Nama file '" + fileName + "', Kode Rutin/Koreksi harus " + reportFormTypeCode + "");
				}

				if (!fileNameSplited[3].equals(periodType) || fileNameSplited[3].length() != 1) {
					errorList.add("Nama file '" + fileName + "', Kode Jenis Periode harus " + periodType + "");
				}

				if (!fileNameSplited[5].equals(memberCode) || fileNameSplited[5].length() != 6) {
					errorList.add("Nama file '" + fileName + "', Kode LJK harus " + memberCode + "");
				}

				if (!fileNameSplited[6].equals(memberTypeCode) || fileNameSplited[6].length() != 2) {
					errorList.add("Nama file '" + fileName + "', Kode Sektor LJK harus " + memberTypeCode + "");
				}

				if (fileNameSplited[4].length() != 8) {
					errorList.add("Nama file '" + fileName + "', Periode Data Pelaporan '" + fileNameSplited[4]
							+ "' tidak valid. Gunakan format YYYYMMDD" + "");
				} else if (!firstPeriodReport.equals(fileNameSplited[4])) {
					errorList.add("Nama file '" + fileName
							+ "', Periode Data Pelaporan tidak boleh berbeda dengan lainnya" + "");
				} else if (!monthDate.yearsIsNumeric()) {
					errorList.add("Nama file '" + fileName + "', Periode Data Pelaporan '" + fileNameSplited[4]
							+ "' tidak valid. Gunakan format YYYYMMDD" + "");
				} else if (monthDate.getMapMonthDate().get(fileNameSplited[4].substring(4, 6)).equals("")) {
					errorList.add("Nama file '" + fileName + "', Periode Data Pelaporan '" + fileNameSplited[4]
							+ "' tidak valid. Gunakan format YYYYMMDD" + "");
				} else if (!monthDate.getMapMonthDate().get(fileNameSplited[4].substring(4, 6)).equals(fileNameSplited[4].substring(6, 8))) {
					errorList.add("Nama file '" + fileName + "', Tanggal Periode Data Pelaporan '" + fileNameSplited[4]
							+ "' tidak valid. Posisi tanggal harus sesuai dengan tanggal pada akhir bulan periode pelaporan" + "");
				}

				if (errorList.size() == 0) {
					tmpModel.getSubmissionData().setDataYearMonth(fileNameSplited[4].substring(0, 4),
							fileNameSplited[4].substring(4, 6));

					files3.add(file);
				} else {
					// fileErrorList2.add(errorList.stream().collect(Collectors.joining(",
					// ")));
					fileErrorList2.add("Nama File '" + fileName + "', kesalahan : \n\t"
							+ errorList.stream().collect(Collectors.joining("\n\t")));
				}
			}

			if (fileErrorList2.size() > 0) {
				// readDirectoryError(readDirModel, errors,
				// new ValidationError(null,
				// ValidationErrorCode.E01_05_INVALID_FILE,
				// fileErrorList2.stream().collect(Collectors.joining(", "))));
				for (String error : fileErrorList2) {
					readDirectoryError(readDirModel, errors,
							new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE, error));
				}
			}

			if (files3.size() == 0) {
				return readDirectoryReturn(errors, readDirModel);
			}

			
			/*
			 * Validasi Penamaan File 3 :
			 * 1. Validasi kelengkapan file pelaporan sesuai kode form
			 * 2. Validasi penamaan file secara lengkap
			 * 
			 */
			String submissionFTP = filePrefixStart + "-" + reportFormTypeCode + "-" + periodType + "-"
					+ firstPeriodReport + "-" + memberCode + "-" + memberTypeCode;
			progressModel.setSubmissionFTP(submissionFTP);
			List<File> validFiles = new ArrayList<>();
			for (SubmissionFormat submissionFormat : metadata.getFormats()) {
				submissionFormat.setReportFormGroupCode(reportFormGroupCode);
				String reportCodeFromMeta = submissionFormat.getReportCode() == null ? "" : submissionFormat.getReportCode();
				if (reportCodeFromMeta.equals(reportCode)) {
					// String filePrefixFormatCode = filePrefix +
					// submissionFormat.getCode() + ".";
					String filePrefixFormatCode = filePrefixStart + "-" + submissionFormat.getCode() + "-"
							+ reportFormTypeCode + "-" + periodType + "-" + firstPeriodReport + "-" + memberCode + "-"
							+ memberTypeCode;
	
					TreeMap<Integer, File> suspectFileMap = new TreeMap<>();
					for (File file : files3) {
						String fileName = file.getName();
						if (fileName.startsWith(filePrefixFormatCode)) {
							String fileNameSplited[] = fileName.split("[-]");
							Integer sequence = null;
							try {
								// sequence = Integer.parseInt(fileNameSplited[5]);
								sequence = 1;
							} catch (Exception e) {
								readDirectoryError(readDirModel, errors,
										new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE,
												"File '" + fileName + "' Nomor urut tidak valid!"));
							}
							if (sequence != null) {
								if (sequence <= 0) {
									readDirectoryError(readDirModel, errors,
											new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE,
													"File '" + fileName + "' Nomor urut harus > 0"));
								} else if (suspectFileMap.containsKey(sequence)) {
									readDirectoryError(readDirModel, errors, new ValidationError(null,
											ValidationErrorCode.E01_05_INVALID_FILE,
											"File form '" + submissionFormat.getCode() + "' sudah ada / ada yang sama"));
								} else if (!fileName.endsWith(submissionFormat.getExtention())) {
									readDirectoryError(readDirModel, errors,
											new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE,
													"Ekstensi file '" + fileName + "' tidak sesuai"));
								} else {
									suspectFileMap.put(sequence, file);
								}
							}
						}
					}
	
					if (suspectFileMap.size() == 0) {
						readDirectoryError(readDirModel, errors,
								new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE,
										"Form '" + submissionFormat.getCode() + "' tidak ditemukan / tidak sesuai format"));
						continue;
					}
	
					// validate sequence
					List<Integer> sequences = suspectFileMap.keySet().stream().sorted().collect(Collectors.toList());
					if (sequences.get(0) != 1) {
						readDirectoryError(readDirModel, errors,
								new ValidationError(null, ValidationErrorCode.E01_06_SEQUENCE, submissionFormat.getCode()));
						continue;
					}
					for (int i = 0; i < sequences.size(); i++) {
						if (i + 1 != sequences.get(i)) {
							readDirectoryError(readDirModel, errors, new ValidationError(null,
									ValidationErrorCode.E01_06_SEQUENCE, submissionFormat.getCode()));
							continue;
						}
					}
	
					// add to ProgressSegment
					ProgressSegment progressSegment = new ProgressSegment(submissionFormat,
							new ArrayList<ProgressSegmentFile>());
					tmpModel.addSegment(progressSegment);
					for (Entry<Integer, File> entry : suspectFileMap.entrySet()) {
						FileIntegrity fileIntegrity = new FileIntegrity(entry.getValue(), null);
						ProgressSegmentFile progressSegmentFile = new ProgressSegmentFile(fileIntegrity, progressModel);
						progressSegment.addSegmentFiles(progressSegmentFile);
						validFiles.add(entry.getValue());
					}
				}
			}

			files3.removeAll(validFiles);
			if (files3.size() != 0) {
				readDirectoryError(readDirModel, errors,
						new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE,
								"Nama file '"
										+ files3.stream().map(file -> file.getName()).collect(Collectors.joining(", "))
										+ "' tidak valid"));
			}

			if (errors.size() == 0) {
				// calculate checksum
				readDirModel.setTotalLength(tmpModel.getTotalFileSize());
				for (ProgressSegment progressSegment : tmpModel.getSegments()) {
					for (ProgressSegmentFile progressSegmentFile : progressSegment.getSegmentFiles()) {

						if (readDirModel.isStop()) {
							// Stop
							break;
						}

						FileIntegrity fileIntegrity = progressSegmentFile.getFileIntegrity();

						if (runOnClient) {
							readDirModel.writeProcessLog("Baca file " + fileIntegrity.getFile());
							// readDirModel.writeProcessLog("Baca checksum file
							// " + fileIntegrity.getFile());
							String checksum = EncryptionUtil.getFileChecksum(readDirModel, 1d, fileIntegrity.getFile());
							// readDirModel.writeProcessLog("Checksum " +
							// checksum);
							fileIntegrity.setChecksum(checksum);
						}
						
						// Save value sebelum validasi
						SaveMapValue smv = new SaveMapValue(progressSegment, fileIntegrity.getFile());
						smv.getMapping();
					}
				}

				if (!readDirModel.isStop()) {
					progressModel.readyToProcess(tmpModel);
				} else {
					String message = "Proses dihentikan";
					errors.add(new ValidationError(null, ValidationErrorCode.E01_01_DATA_NOT_READY));
					AlertUtil.showAlertSafe(AlertType.INFORMATION, "Informasi", "Informasi", message);
				}
			}

			if (errors.size() == 0) {
				readDirModel.writeProcessLog("Baca direktori Sukses dalam " + timeCounter.getTimeElapseFormated());
				progressModel.setReadDirectoryTimeElapse(timeCounter.getTimeElapse());
				progressModel.setReadyToProcess(true);

			} else {
				readDirModel.writeProcessLog("Baca direktori Gagal, detail cek tab Error");
			}
			return errors;
		} finally {
			readDirModel.setOnProcess(false);
		}
	}

	private static List<ValidationError> readDirectoryReturn(List<ValidationError> errors,
			ReadSubmissionDirModel readDirModel) {
		if (errors.size() == 0) {
			readDirModel.writeProcessLog("Baca direktori Sukses");
		} else {
			readDirModel.writeProcessLog("Baca direktori Gagal, detail cek tab Error");
		}
		return errors;
	}
	
	private static void readDirectoryError(ReadSubmissionDirModel readDirModel, List<ValidationError> errors,
			ValidationError validationError) {
		errors.add(validationError);
		readDirModel.logError(validationError);
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

}
