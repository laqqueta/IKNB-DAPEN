package id.go.ojk.client.model.config.validation.segmen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.config.validation.segmen.DateFieldCompare;
import id.go.ojk.lib.client.model.config.validation.segmen.DateFieldCompare.RightDateField;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("dateMatrixSegmentValidation")
public class DateMatrixSegmentValidation extends BaseSegmentValidation {

	private DateFieldCompare[] dateFieldCompares;

	public DateMatrixSegmentValidation(){
		super();
	}

	public DateMatrixSegmentValidation(String parameter){
		super(parameter);
	}

	@Override
	public DateMatrixSegmentValidation initialized() {
		String param = getParameter();
		String params[] = param.split("[\n]");
		List<DateFieldCompare> dateCompareList = new ArrayList<DateFieldCompare>();
		for (String string : params) {
			String[] details = string.split("[|]");
			DateFieldCompare dateFieldCompare = new DateFieldCompare(Integer.parseInt(details[0]), Comparation.valueOf(details[1]));
			List<RightDateField> compareRightFieldList = new ArrayList<DateFieldCompare.RightDateField>();
			for(int i=2 ; i<details.length ; i+=2 ){
				compareRightFieldList.add(new RightDateField(Comparation.valueOf(details[i]), Integer.parseInt(details[i+1])));
			}
			dateFieldCompare.setRightDateFields(compareRightFieldList.toArray(new RightDateField[0]));
			dateCompareList.add(dateFieldCompare);
		}
		dateFieldCompares = dateCompareList.toArray(new DateFieldCompare[dateCompareList.size()]);
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		for (DateFieldCompare dateCompare : dateFieldCompares) {
			SubmissionField leftField = submissionFormat.getFields().get(dateCompare.getLeftField());
			LocalDate leftValue = (LocalDate) validationResult.cacheParseObject.get(dateCompare.getLeftField());
			for (RightDateField compareRightField : dateCompare.getRightDateFields()) {
				Comparation comparation = compareRightField.getComparation();
				SubmissionField rightField = submissionFormat.getFields().get(compareRightField.getRightField());
				LocalDate rightValue = (LocalDate) validationResult.cacheParseObject.get(compareRightField.getRightField());

				compare(validationResult, leftField, leftValue, comparation, rightValue, rightField.getName());
			}

			compare(validationResult, leftField, leftValue, dateCompare.getComparationYearMonthData(), submissionData.getDataYearMonth(), "Periode Data Pelaporan");
		}
	}

	private void compare(ValidationResult validationResult, SubmissionField leftField, LocalDate leftValue, Comparation comparation, LocalDate rightValue, String rightFieldName){
		if( leftValue != null &&  rightValue != null ){
			if ( !comparation.testCompareDate(leftValue, rightValue) ){
				validationResult.errors.add(
					new ValidationError(
						leftField,
						ValidationErrorCode.E20_03_DATE_MATRIX,
						leftField.getName(), comparation.getCode(), rightFieldName
					)
				);
			}
		}

	}
	
	public DateFieldCompare[] getDateFieldCompares() {
		return dateFieldCompares;
	}
	public void setDateFieldCompares(DateFieldCompare[] dateFieldCompares) {
		this.dateFieldCompares = dateFieldCompares;
	}

}
