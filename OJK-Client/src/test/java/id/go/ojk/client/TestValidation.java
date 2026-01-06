package id.go.ojk.client;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.module.rb.ValidationFileNameRb;
import id.go.ojk.client.validation.IValidationFile;
import id.go.ojk.client.validation.ValidationDirectory;

public class TestValidation {
	private static List<ValidationError> listValidationError = new ArrayList<>();

	public static void main(String[] args) {
		try {
			System.out.println("start...");
			List<File> listValidFile1 = testValidationDirectory();
			if (isNoError()) {
				ValidationFileNameRb validation = 
						new ValidationFileNameRb(listValidFile1, null, null);
				validation.setListSubmissionFormat(genListSubmissionFormat());
				validation.setMemberCode("2000000006");
				validation.setMemberTypeCode("01");
				validation.validate();
				listValidationError.addAll(validation.getListValidationError());
				showLog(validation.getListFile());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("end");
		}
	}

	private static List<File> testValidationDirectory() {
		System.out.println("validate directory...");
		String dir = "D:\\Tahunan 2019-03-31 R";
		IValidationFile<File> validation = new ValidationDirectory(new File(dir));
		validation.validate();
		List<File> listValidFile = validation.getListFile();
		listValidationError.addAll(validation.getListValidationError());
		showLog(listValidFile);
		return listValidFile;
	}
	
	private static void showLog(List<?> listValidFile) {
		System.out.println("file=" + listValidFile.size() + "|error=" + listValidationError.size());
		for (int i = 0; i < listValidationError.size(); i++) {
			System.err.println(listValidationError.get(i).toErrorString());
		}
	}
	
	private static boolean isNoError() {
		return listValidationError.isEmpty();
	}
	
	private static List<SubmissionFormat> genListSubmissionFormat() {
		List<SubmissionFormat> res = new ArrayList<>();
		List<String> listReportCode = Arrays.asList("0105", "0201", "0400", "0500", "0601", "0602", 
				"0702", "0900", "1002", "1003");
		for (int i = 0; i < listReportCode.size(); i++) {
			SubmissionFormat submissionFormat = new SubmissionFormat(listReportCode.get(i), "", "RB", null, "txt", 0, 0);
			res.add(submissionFormat);
		}
		return res;
	}
}
