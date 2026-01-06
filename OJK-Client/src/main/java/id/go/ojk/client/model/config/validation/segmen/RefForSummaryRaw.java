package id.go.ojk.client.model.config.validation.segmen;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.YearMonth;
import id.go.ojk.lib.client.model.config.validation.segmen.model.SummaryRefRaw;
import id.go.ojk.lib.client.model.constant.FormatCategoryFlag;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.service.context.ApplicationContext;

/**
 * summaryStartYearMonth => konfigurasi start year month summary  
 * 
 * cifField=?&accountNumberField=?&otherFacilityTypeField=?&facilityTypeValue=?&startDateField=?&conditionCodeField=?&conditionDateField=?
 *
 */
@XStreamAlias("refForSummaryRaw")
public class RefForSummaryRaw extends MapParamSegmentValidation {

	@XStreamOmitField
	private YearMonth summaryStartYearMonth;
	private int cifField;
	private int accountNumberField;
	
	private int otherFacilityTypeField;
	private String facilityTypeValue;
	private boolean isOtherFacilityType;
	
	private int startDateField;
	private int conditionCodeField;
	private int conditionDateField;

	public RefForSummaryRaw(){
		super();
	}

	public RefForSummaryRaw(String parameter){
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
		if ( appCtx != null ) {
			this.referenceService = appCtx.getService(ReferenceService.class);
			this.summaryStartYearMonth = YearMonth.from(referenceService.getConfig(ReferenceService.summaryStartYearMonth));
		}
	}

	@Override
	public RefForSummaryRaw initialized() {
		this.cifField 				= getIntParameter("cifField");
		this.accountNumberField 	= getIntParameter("accountNumberField");
		this.otherFacilityTypeField = getIntParameter("otherFacilityTypeField");
		this.facilityTypeValue 		= getStringParameter("facilityTypeValue");
		if ( StringUtils.isEmpty(facilityTypeValue) ){
			isOtherFacilityType = false;
		}

		this.startDateField 		= getIntParameter("startDateField");
		this.conditionCodeField 	= getIntParameter("conditionCodeField");
		this.conditionDateField 	= getIntParameter("conditionDateField");
				
		return this;
	}
	
	public final static DateTimeFormatter dateTimeFormatterYYYYmm = DateTimeFormatter.ofPattern("yyyyMM");

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		if ( !submissionData.isValidateBetweenRow() ){
			return;
		}

		LocalDate startDate = (LocalDate) validationResult.cacheParseObject.get(startDateField);		
		if ( startDate == null )
			return;
		
		String startYearMonth = dateTimeFormatterYYYYmm.format(startDate);
		
		String conditionCode = validationResult.getColumn(conditionCodeField);
		LocalDate conditionDate = (LocalDate) validationResult.cacheParseObject.get(conditionDateField);
		String conditionYearMonth = null;
		
		if ( StringUtils.isNotEmpty(conditionCode) && conditionDate != null) {
			String label = referenceService.getLabel(ReferenceMetadata.R24Condition.getNumber(), 0, conditionCode);
			if ( ReferenceMetadata.R24_Category_T.equals(label) ){
				conditionYearMonth = dateTimeFormatterYYYYmm.format(conditionDate);
			} 
		} 
		
		String cif = validationResult.getColumn(cifField);
		String facilityType = isOtherFacilityType ? validationResult.getColumn(otherFacilityTypeField) : facilityTypeValue;
		String accountNumber = validationResult.getColumn(accountNumberField);
		if ( StringUtils.isNotEmpty(cif) && StringUtils.isNotEmpty(accountNumber) && StringUtils.isNotEmpty(facilityType) ){
			String operation = validationResult.getColumn(validationResult.getColumnLength() - 1);
			submissionData.getValidationRelationModel().summaryRefRawMap.put(
				accountNumber + "#" + cif, 
				SummaryRefRaw.builder()
				.facilityType(facilityType)
				.startYearMonth(startYearMonth)
				.endYearMonth(conditionYearMonth)
				.operation(operation)
				.build()
			);
		}		
	}
	
	@Override
	public FormatCategoryFlag getFormatCategoryFlag() {
		return FormatCategoryFlag.N;
	}

}
