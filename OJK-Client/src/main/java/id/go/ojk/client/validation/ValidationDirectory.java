package id.go.ojk.client.validation;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.vc.ReadSubmissionDirController.ReadSubmissionDirModel;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.Getter;

public class ValidationDirectory extends BaseValidationFile<File> {
	private static final Logger logger = LoggerFactory.getLogger(ValidationDirectory.class);
	private File submissionDir;
	@Getter private List<File> listFile = new ArrayList<>();
	
	public ValidationDirectory(File submissionDir) {
		this.submissionDir = submissionDir;
	}
	
	public ValidationDirectory(File submissionDir, ReadSubmissionDirModel readDirModel) {
		this(submissionDir);
		this.readDirModel = readDirModel;
	}
	
	@Override
	public boolean validate() {
		boolean res = false;
		res = isExists() && isDirectory();
		if (res) {
			listFileFromDirectory();
			res = !isEmpty();
		}
		if (res) {
			logger.debug("Baca direktori Sukses");
		} else {
			logger.error("Baca direktori Gagal!!!");
		}
		return res;
	}
	
	private boolean isExists() {
		boolean res = submissionDir.exists();
		if (!res) {
			logError(new ValidationError(null, ValidationErrorCode.E01_02_DIR_NOT_FOUND, submissionDir.getAbsolutePath()));
		}
		return res;
	}
	
	private boolean isDirectory() {
		boolean res = submissionDir.isDirectory();
		if (!res) {
			logError(new ValidationError(null, ValidationErrorCode.E01_03_NOT_A_DIR, submissionDir.getAbsolutePath()));
		}
		return res;
	}
	
	private boolean isEmpty() {
		boolean res = listFile == null || listFile.size() == 0;
		if (res) {
			logError(new ValidationError(null, ValidationErrorCode.E01_04_DIR_EMPTY, submissionDir.getAbsolutePath()));
		}
		return res;
	}
	
	private void listFileFromDirectory() {
		listFile = Arrays.asList(submissionDir.listFiles()).stream().collect(Collectors.toList());
	}
}
