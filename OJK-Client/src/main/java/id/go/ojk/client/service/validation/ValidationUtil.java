package id.go.ojk.client.service.validation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

public class ValidationUtil {

	public static Long validateLong(SubmissionField field, ValidationResult validationResult, boolean addError){
		return validateLong(field, validationResult.getColumn(field.getNumber()), addError ? validationResult.errors : null);
	}
	
	public static Double validateDouble(SubmissionField field, ValidationResult validationResult, boolean addError){
		return validateDouble(field, validationResult.getColumn(field.getNumber()), addError ? validationResult.errors : null);
	}

	public static Long validateLong(SubmissionField field, String value, List<ValidationError> errors){
		Long result = null;
		try {
			result = Long.parseLong(value);
		} catch (Exception e){
			if ( errors != null ){
				errors.add(new ValidationError(field, ValidationErrorCode.E11_04_NUMBER, value));
			}
		}
		return result;
	}

	public static Integer validateInteger(String value, List<ValidationError> errors){
		Integer result = null;
		try {
			result = Integer.parseInt(value);
		} catch (Exception e){
			if ( errors != null ){
				errors.add(new ValidationError(null, ValidationErrorCode.E11_04_NUMBER, value));
			}
		}
		return result;
	}

	public static Double validateDouble(SubmissionField field, String value, List<ValidationError> errors){
		Double result = null;
		try {
			result = Double.parseDouble(value.replaceAll(",", "."));
		} catch (Exception e){
			if ( errors != null ){
				errors.add(new ValidationError(field, ValidationErrorCode.E11_05_DECIMAL, value));
			}
		}
		return result;
	}
	
	public static BigDecimal validateBigDecimal(SubmissionField field, String value, List<ValidationError> errors){
		BigDecimal result = null;
		try {
			result = new BigDecimal(value.replaceAll(",", "."));
		} catch (Exception e){
			if ( errors != null ){
				errors.add(new ValidationError(field, ValidationErrorCode.E11_05_DECIMAL, value));
			}
		}
		return result;
	}
	
	public static Float validateFloat(SubmissionField field, String value, List<ValidationError> errors){
		Float result = null;
		try {
			result = Float.parseFloat(value.replaceAll(",", "."));
		} catch (Exception e){
			if ( errors != null ){
				errors.add(new ValidationError(field, ValidationErrorCode.E11_05_DECIMAL, value));
			}
		}
		return result;
	}

	public static DateTimeFormatter yyyyMMddDateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
	public static DateTimeFormatter yyyyMMDateFormat = DateTimeFormatter.ofPattern("yyyyMM");
	public static DateTimeFormatter dd_MM_yyyyDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static LocalDate validateDate(SubmissionField field, ValidationResult validationResult, boolean addError){
		return validateDate(field, validationResult, null, null, addError);
	}

	public static LocalDate validateDate(SubmissionField field, ValidationResult validationResult, LocalDate minDate, LocalDate maxDate, boolean addError){
		LocalDate result = (LocalDate) validationResult.cacheParseObject.get(field.getNumber());
		
		if( result != null ){
			if ( addError ){
				validateDate(field, result, validationResult.errors, minDate, maxDate);
//				if ( minDate != null && minDate.isAfter(result) ){
//					String minDateString = dd_MM_yyyyDateFormat.format(minDate);
//					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_04_ALL_DATE_MIN, minDateString));
//				} 						
//				if ( maxDate != null && maxDate.isBefore(result) ){
//					String maxDateString = dd_MM_yyyyDateFormat.format(maxDate);
//					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_05_ALL_DATE_MAX, maxDateString));
//				} 						
			}					

			return result;
		}
		
		String value = validationResult.getColumn(field.getNumber());
		result = validateDate(field, value, validationResult.errors, minDate, maxDate, addError);
		if ( result !=null )
			validationResult.cacheParseObject.put(field.getNumber(), result);
		return result;
	}
	
	public static LocalDate validateDate(SubmissionField field, String input, List<ValidationError> errors, LocalDate minDate, LocalDate maxDate, boolean addError){
					
		try {
			LocalDate result = LocalDate.parse(input, yyyyMMddDateFormat);
			if ( result != null ){
				int day = Integer.parseInt(input.substring(6, 8));
				if ( day > result.lengthOfMonth() ){
					
					if ( addError )
						errors.add(new ValidationError(field, ValidationErrorCode.E12_03_DATE));
					
					result = null;
				} else {
					if ( addError ){
						validateDate(field, result, errors, minDate, maxDate);
//						if ( minDate != null && minDate.isAfter(result) ){
//							String minDateString = dd_MM_yyyyDateFormat.format(minDate);
//							errors.add(new ValidationError(field, ValidationErrorCode.E12_04_ALL_DATE_MIN, minDateString));
//						} 						
//						if ( maxDate != null && maxDate.isBefore(result) ){
//							String maxDateString = dd_MM_yyyyDateFormat.format(maxDate);
//							errors.add(new ValidationError(field, ValidationErrorCode.E12_05_ALL_DATE_MAX, maxDateString));
//						} 						
					}					
				}
			}
			return result;
		} catch (Exception e){
			if ( addError )
				errors.add(new ValidationError(field, ValidationErrorCode.E12_03_DATE, input));
			return null;
		}
	}
	
	private static void validateDate(SubmissionField field, LocalDate value, List<ValidationError> errors, LocalDate minDate, LocalDate maxDate){
		if ( minDate != null && minDate.isAfter(value) ){
			String minDateString = dd_MM_yyyyDateFormat.format(minDate);
			errors.add(new ValidationError(field, ValidationErrorCode.E12_04_ALL_DATE_MIN, minDateString));
		} 						
		if ( maxDate != null && maxDate.isBefore(value) ){
			String maxDateString = dd_MM_yyyyDateFormat.format(maxDate);
			errors.add(new ValidationError(field, ValidationErrorCode.E12_05_ALL_DATE_MAX, maxDateString));
		} 						
	}

	//~ yearmonth
	
	public static LocalDate validateYearMonth(SubmissionField field, ValidationResult validationResult, boolean addError){
		return validateYearMonth(field, validationResult, null, null, addError);
	}

	public static LocalDate validateYearMonth(SubmissionField field, ValidationResult validationResult, LocalDate minDate, LocalDate maxDate, boolean addError){
		LocalDate result = (LocalDate) validationResult.cacheParseObject.get(field.getNumber());
		
		if( result != null ){
			if ( addError ){
				validateYearMonth(field, result, validationResult.errors, minDate, maxDate);
//				if ( minDate != null && minDate.isAfter(result) ){
//					String minDateString = dd_MM_yyyyDateFormat.format(minDate);
//					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_04_ALL_DATE_MIN, minDateString));
//				} 						
//				if ( maxDate != null && maxDate.isBefore(result) ){
//					String maxDateString = dd_MM_yyyyDateFormat.format(maxDate);
//					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_05_ALL_DATE_MAX, maxDateString));
//				} 						
			}					

			return result;
		}
		
		String value = validationResult.getColumn(field.getNumber());
		result = validateYearMonth(field, value, validationResult.errors, minDate, maxDate, addError);
		if ( result !=null )
			validationResult.cacheParseObject.put(field.getNumber(), result);
		return result;
	}
	
	public static LocalDate validateYearMonth(SubmissionField field, String input, List<ValidationError> errors, LocalDate minDate, LocalDate maxDate, boolean addError){
		
		input = input + "01";
		
		try {
			LocalDate result = LocalDate.parse(input, yyyyMMddDateFormat).with(TemporalAdjusters.lastDayOfMonth());
			if ( result != null ){
				int day = Integer.parseInt(input.substring(6, 8));
				if ( day > result.lengthOfMonth() ){
					
					if ( addError )
						errors.add(new ValidationError(field, ValidationErrorCode.E12_10_YEARMONTH));
					
					result = null;
				} else {
					if ( addError ){
						validateYearMonth(field, result, errors, minDate, maxDate);
//						if ( minDate != null && minDate.isAfter(result) ){
//							String minDateString = dd_MM_yyyyDateFormat.format(minDate);
//							errors.add(new ValidationError(field, ValidationErrorCode.E12_04_ALL_DATE_MIN, minDateString));
//						} 						
//						if ( maxDate != null && maxDate.isBefore(result) ){
//							String maxDateString = dd_MM_yyyyDateFormat.format(maxDate);
//							errors.add(new ValidationError(field, ValidationErrorCode.E12_05_ALL_DATE_MAX, maxDateString));
//						} 						
					}					
				}
			}
			return result;
		} catch (Exception e){
			if ( addError )
				errors.add(new ValidationError(field, ValidationErrorCode.E12_10_YEARMONTH, input));
			return null;
		}
	}
	
	private static void validateYearMonth(SubmissionField field, LocalDate value, List<ValidationError> errors, LocalDate minDate, LocalDate maxDate){
		if ( minDate != null && minDate.isAfter(value) ){
			String minDateString = dd_MM_yyyyDateFormat.format(minDate);
			errors.add(new ValidationError(field, ValidationErrorCode.E12_11_YEARMONTH_MIN, minDateString));
		} 						
		if ( maxDate != null && maxDate.isBefore(value) ){
			String maxDateString = dd_MM_yyyyDateFormat.format(maxDate);
			errors.add(new ValidationError(field, ValidationErrorCode.E12_12_YEARMONTH_MAX, maxDateString));
		} 								
	}
	
	//~ year
	
	public static LocalDate validateYear(SubmissionField field, ValidationResult validationResult, LocalDate minDate, LocalDate maxDate, boolean addError){
		LocalDate result = (LocalDate) validationResult.cacheParseObject.get(field.getNumber());
	
		if( result != null ){
			if ( addError ){
				validateYear(field, result, validationResult.errors, minDate, maxDate); 						
			}					

			return result;
		}
		
		String value = validationResult.getColumn(field.getNumber());
		result = validateYear(field, value, validationResult.errors, minDate, maxDate, addError);
		if ( result !=null )
			validationResult.cacheParseObject.put(field.getNumber(), result);
		return result;
	}
	
	public static LocalDate validateYear(SubmissionField field, String input, List<ValidationError> errors, LocalDate minDate, LocalDate maxDate, boolean addError){
		input = input + "0101";
		
		try {
			LocalDate result = LocalDate.parse(input, yyyyMMddDateFormat).with(TemporalAdjusters.lastDayOfMonth());
			if ( result != null ){
				int day = Integer.parseInt(input.substring(6, 8));
				if ( day > result.lengthOfMonth() ){
					
					if ( addError )
						errors.add(new ValidationError(field, ValidationErrorCode.E12_13_YEAR));
					
					result = null;
				} else {
					if ( addError ){
						validateYear(field, result, errors, minDate, maxDate);					
					}					
				}
			}
			return result;
		} catch (Exception e){
			if ( addError )
				errors.add(new ValidationError(field, ValidationErrorCode.E12_13_YEAR, input));
			return null;
		}
	}
	
	private static void validateYear(SubmissionField field, LocalDate value, List<ValidationError> errors, LocalDate minDate, LocalDate maxDate){
		if ( minDate != null && minDate.isAfter(value) ){
			String minDateString = dd_MM_yyyyDateFormat.format(minDate).substring(6);
			errors.add(new ValidationError(field, ValidationErrorCode.E12_14_YEAR_MIN, minDateString));
		} 						
		if ( maxDate != null && maxDate.isBefore(value) ){
			String maxDateString = dd_MM_yyyyDateFormat.format(maxDate).substring(6);
			errors.add(new ValidationError(field, ValidationErrorCode.E12_15_YEAR_MAX, maxDateString));
		} 								
	}
	
	//~ validateRequired

	public static void validateRequired(RequiredCondition requiredCondition, ValidationResult validationResult, SubmissionField field){
		String value = validationResult.getColumn(field.getNumber());
		switch (requiredCondition) {
		case M:
			if ( StringUtils.isEmpty(value) ){
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E13_00_MANDATORY));
			}
			break;
		case N:
			if ( StringUtils.isNotEmpty(value) ){
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E13_01_MUSTEMPTY));
			}
			break;
		default:
			break;
		}
	}
	
	public static int createHashCode(int[] fieldNums, String[] rowSplited){
		String concated = concateColumn(fieldNums, rowSplited);
		concated = concated.replaceAll("\\s+","");
		concated = concated.toUpperCase();
		return concated.hashCode();
	}
	
	public static String concateColumn(int[] fieldNums, String[] rowSplited){
		StringBuilder builder = new StringBuilder();
		if (rowSplited != null) {
			for (int fieldNum : fieldNums) {
				builder.append(rowSplited[fieldNum]).append("|");
			}
		}
		return builder.toString();
	}

	public static BigDecimal sumToBigDecimal(List<BigDecimal> datas){
		BigDecimal sum = BigDecimal.ZERO;
		for (BigDecimal bigDecimal : datas) {
			sum = sum.add(bigDecimal);
		}
		return sum;
	}
	
	public static double sumToDouble(List<BigDecimal> datas){
		return sumToBigDecimal(datas).doubleValue();
	}

	private ValidationUtil() {
	}

}
