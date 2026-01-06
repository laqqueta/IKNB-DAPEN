package id.go.ojk.client.model.validation;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public class ValidationError {

	public Integer columnNumber;
	public String columnName;
	public ValidationErrorCode errorCode;
	public String description;
	private Object[] args;

	public ValidationError(SubmissionField field, ValidationErrorCode errorCode, Object ...args){
		if ( field != null ){
			this.columnNumber = field.getNumber();
			this.columnName = field.getName();
		}
		this.errorCode = errorCode;
		this.args = args;
		formatDescription(args);
	}

	public String formatDescription(Object ...args){
		this.description = errorCode.constructDescription(args);
		return this.description;
	}

	public ValidationErrorCode getErrorCode() {
		return errorCode;
	}

	public String getDescription() {
		return description;
	}
	
	//12/11/2025 - Usulan UAT #49 BPJS Kesehatan
	public Object[] getErrorArgs() {
	  return args;
	}

	public void appendErrorString(StringBuilder builder) {
		builder.append("\nVALIDASI|").append(errorCode.code).append(errorCode.subCode).append("|");
		if ( StringUtils.isNotEmpty(columnName) ){
			builder.append("Kesalahan di ")
			//.append(columnNumber).append("-")
			.append("Kolom " + (columnNumber + 1) + " '" + columnName + "' ").append(", ");
		}
		builder.append(description);
	}
	
	public String toErrorString() {
		return toErrorString("", "");
	}

	public String toSinggleErrorString() {
		return toErrorString("\nRECORD||\nVALIDASI|", "\n");
	}
	
	public String toSinggleErrorString(int rowNumber) {
		return toErrorString(
			"\nRECORD|" + rowNumber + "|\nVALIDASI|", 
			"\n"
		);
	}

	public String toErrorString(String pre, String post) {
		StringBuilder builder = new StringBuilder();
		builder.append(pre).append(errorCode.code).append(errorCode.subCode).append("|");
		if ( StringUtils.isNotEmpty(columnName) ){
			builder.append("Kesalahan di ").append(columnName).append(", ");
		}
		builder.append(description).append(post);
		return builder.toString();
	}
	
	@Override
	public String toString() {
		return toErrorString();
	}
	
	public static String errorToString( int lineNumber, String row, List<ValidationError> errors ){
		StringBuilder builder = new StringBuilder();

		builder.append("\nRECORD|").append(lineNumber).append("|").append(row);

		for (ValidationError validationError : errors) {
			validationError.appendErrorString(builder);
		}
		builder.append("\n");

		return builder.toString();
	}

}
