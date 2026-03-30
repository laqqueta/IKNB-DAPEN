package id.go.ojk.client.module;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import id.go.ojk.client.constant.EValidExtension;
import id.go.ojk.client.model.ReportInfo;
import id.go.ojk.client.model.ValidFile;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.validation.BaseValidationFile;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.util.FileUtil;
import id.go.ojk.lib.client.util.UtilPdf;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationFileName1 extends BaseValidationFile<ValidFile> {
	private List<File> files;
	protected ReportInfo reportInfo;
	private List<ValidFile> listFile = new ArrayList<>();

	public ValidationFileName1(List<File> files, ReportInfo reportInfo) {
		this.files = files;
		this.reportInfo = reportInfo;
	}

	public ValidationFileName1(List<File> files, ReportInfo reportInfo, ReadSubmissionDirModel readDirModel) {
		this(files, reportInfo);
		this.readDirModel = readDirModel;
	}

	@Override
	public List<ValidFile> getListFile() {
		return listFile;
	}

	@Override
	public boolean validate() {
		log.info("Validator=" + this.getClass().getName());
		if (files != null && !files.isEmpty()) {
			for (int i = 0; i < files.size(); i++) {
				List<String> listError = new ArrayList<>();
				ValidFile validFile = new ValidFile(files.get(i));
				if (validateFile(validFile, listError)) {
					validateExtention(validFile, listError);
					validatePartLength(validFile, listError);
					validateFileSize(validFile, listError);
				}
				if (listError.isEmpty()) {
					listFile.add(validFile);
				} else {
					System.out.println(files.get(i).getAbsolutePath() + " - " + files.get(i).getAbsoluteFile());
					String error = "Nama File '" + validFile.getFullFileName() + "', kesalahan : \n\t"
							+ listError.stream().collect(Collectors.joining("\n\t"));
					logError(new ValidationError(null, ValidationErrorCode.E01_05_INVALID_FILE, error));
				}
			}
		}
		boolean res = getListValidationError().isEmpty();
		if (!res) {
			log.error("Validation failed!!!");
		}
		return res;
	}

	protected boolean validateExtention(ValidFile validFile, List<String> listError) {
		boolean res = false;
		EValidExtension validExtension = reportInfo.getReportGroup().getValidExtension();
		if (validExtension != null) {
			String extension = validFile.getExtension();
			List<String> listExtension = validExtension.getExtension();
			for (int i = 0; i < listExtension.size(); i++) {
				if ((res = extension.equalsIgnoreCase(listExtension.get(i)))) {
					break;
				}
			}
		}
		if (!res) {
			listError.add(String.format("File '%S' ekstensi harus %S", validFile.getFullFileName(),
					validExtension.getExtensionAsString("atau")));
		}
		return res;
	}

	private boolean validateFile(ValidFile validFile, List<String> listError) {
		boolean res = validFile.getFile().isFile();
		if (!res) {
			listError.add(String.format("'%S' bukan file", validFile.getFullFileName()));
		}
		return res;
	}

	private boolean validatePartLength(ValidFile validFile, List<String> listError) {
		boolean res = validFile.getSplittedFilename() != null && validFile.getSplittedFilename().length == 7;
		if (!res) {
			listError.add(String.format(
					"Nama file '%S' salah, harus <Kode Jenis Laporan>-<Kode Form Laporan>-<Kode Rutin/Koreksi>-<Kode Jenis Periode>-<Periode Data Pelaporan>-<Kode LJK>-<Kode Sektor LJK>.<Ekstensi>",
					validFile.getFullFileName()));
		}
		return res;
	}

	protected boolean validateFileSize(ValidFile validFile, List<String> listError) {
		long fileSize = validFile.getFile().length();
		boolean res = (fileSize != 0);
		if (!res) {
			listError.add("File '" + validFile.getFullFileName() + "' tidak berisi data");
		} else {
			if (EValidExtension.PDF.validExtension(validFile.getExtension())) {
				if (!UtilPdf.isPdf(validFile.getFile().getAbsolutePath())) {
					listError.add("File '" + validFile.getFullFileName() + "' bukan file PDF");
				}
				res = (fileSize <= 20971520);
				if (!res) {
					listError.add("File '" + validFile.getFullFileName() + "' tidak boleh lebih dari 20 MB");
				}
			} else if (EValidExtension.ZIP.validExtension(validFile.getExtension())) {
				boolean isZipFile = FileUtil.isZipFile(validFile.getFile());

				if (!isZipFile) {
					listError.add("File '" + validFile.getFullFileName() + "' bukan file ZIP");
				}

				res = (fileSize <= 20971520);
				if (!res) {
					listError.add("File '" + validFile.getFullFileName() + "' tidak boleh lebih dari 20 MB");
				}
			}
		}
		return res;
	}
}
