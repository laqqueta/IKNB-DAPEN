package id.go.ojk.client.model.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.module.bpjs.EReportBpjs;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.Tupple3;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.util.CrLfType;

public class ValidationResult {
	public int fileSeq;
	public int lineNumber;
	public Long bytePosition;
	public String row;
	public CrLfType crLfType;
	public String[] rowSplited;
	public List<ValidationError> errors = new ArrayList<ValidationError>();
	public boolean stopValidation = false;
	public List<Tupple2<RequiredCondition, String>> refRequiredConditions = new ArrayList<>();
	public Map<Integer, Object> cacheParseObject = new HashMap<>();

	public ValidationResult(int fileSeq, int lineNumber, Tupple3<Long, String, CrLfType> positionLine) {
		this.fileSeq = fileSeq;
		this.lineNumber = lineNumber;
		this.bytePosition = positionLine.getA();
		this.row = positionLine.getB();
		this.crLfType = positionLine.getC();
		this.rowSplited = row.split("[|]", -1);
	}

	public ValidationResult(int fileSeq, int lineNumber, String row) {
	  this.fileSeq = fileSeq;
	  this.lineNumber = lineNumber;
	  this.row = row;
	}

	public String getColumn(int idx) {
		String res = UtilValidation.getArray(rowSplited, idx, "");
//		if (StringUtils.isNotEmpty(res)) {
//			res = res.replaceAll("\\s+", "");
//		}
		return res;
	}

    public String getRawColumn(int idx) {
        return UtilValidation.getArray(rowSplited, idx, "");
    }

	public int getColumnLength() {
		return rowSplited != null ? rowSplited.length : 0;
	}

	public boolean isError() {
		return errors.size() > 0;
	}

	private static Comparator<ValidationError> comparator = new Comparator<ValidationError>() {
		@Override
		public int compare(ValidationError o1, ValidationError o2) {
			if (o1.columnNumber == null) {
				return 1;
			}
			if (o2.columnNumber == null) {
				return -1;
			}

			if (o1.columnNumber == o2.columnNumber) {
				return 0;
			} else if (o1.columnNumber > o2.columnNumber) {
				return 1;
			} else {
				return -1;
			}
		}
	};

	public void sortError() {
		Collections.sort(errors, comparator);
	}

	/*
	 * 12/11/2025 - Usulan UAT #49 BPJS Kesehatan
	 * ==========================================
	 * Usulan perubahan error message dari "nilai harus C = A + B" menjadi
	 * "nilai C harus = A + B".
	 * 
	 * Berlaku hanya untuk validation error E11_00_FORMAT.
	 * Agar dipastikan tidak mengganggu laporan lainnya (hanya untuk BPJS),
	 * toErrorString di filter berdasarkan report code.
	 */
	public String toErrorString(SubmissionFormat submissionFormat) {
	  if(submissionFormat == null)
	    return toErrorString();

	  EReportBpjs reportBpjs = EReportBpjs.getByReportCode(submissionFormat.getReportCode());
	  if(EReportBpjs.getByReportCode(submissionFormat.getReportCode()) == null) {
	    return toErrorString();
	  } else {
	    StringBuilder builder = new StringBuilder();
	    builder.append("\nBARIS ").append(lineNumber + 1).append("|").append(row);

	    for (ValidationError validationError : errors) {
	      ValidationErrorCode errorCode = validationError.getErrorCode();
	      builder.append("\nVALIDASI|").append(errorCode.code).append(errorCode.getSubCode()).append("|");
	      if ( StringUtils.isNotEmpty(validationError.columnName) ){
	        builder.append("Kesalahan di ")
	        .append("Kolom " + (validationError.columnNumber + 1) + " '" + validationError.columnName + "' ").append(", ");
	      }
	      builder.append(reportBpjs.formatErrorMessage(validationError, errorCode));
	    }
	    builder.append("\n");
	    return builder.toString();
	  }  
  }

	public String toErrorString() {
		StringBuilder builder = new StringBuilder();

		builder.append("\nBARIS ").append(lineNumber + 1).append("|").append(row);

		for (ValidationError validationError : errors) {
			validationError.appendErrorString(builder);
		}
		builder.append("\n");

		return builder.toString();
	}

	public boolean isHeader() {
		return getColumn(0).equals("H01");
	}

	public boolean isDetail() {
		return getColumn(0).equals("D01");
	}
}
