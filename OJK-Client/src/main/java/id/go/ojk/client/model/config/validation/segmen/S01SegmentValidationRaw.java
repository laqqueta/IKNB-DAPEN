package id.go.ojk.client.model.config.validation.segmen;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.YearMonth;
import id.go.ojk.lib.client.model.config.validation.segmen.model.SummaryRefRaw;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("s01SegmentValidationRaw")
public class S01SegmentValidationRaw extends MapParamSegmentValidation {
	
	@XStreamOmitField
	private YearMonth summaryStartYearMonth;

	private int cifField;
	private int accountNumberField;
	private int facilityTypeField;
	private int summaryStartField;
	private Set<String> noOverdueDayFacilityTypes;
	
	@XStreamOmitField
	private String noOverdueDayFacilityTypeConcate;
	
	public S01SegmentValidationRaw(){
		super();
	}
	
	public S01SegmentValidationRaw(String parameter){
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
		if ( appCtx != null ){
			this.referenceService = appCtx.getService(ReferenceService.class);
			this.noOverdueDayFacilityTypeConcate = StringUtils.join(noOverdueDayFacilityTypes, ", ");
			this.summaryStartYearMonth = YearMonth.from(referenceService.getConfig(ReferenceService.summaryStartYearMonth));
		}
	}

	@Override
	public S01SegmentValidationRaw initialized() {
		this.cifField 					= getIntParameter("cifField");
		this.accountNumberField 		= getIntParameter("accountNumberField");
		this.facilityTypeField			= getIntParameter("facilityTypeField");
		this.summaryStartField			= getIntParameter("summaryStartField");
		
		this.noOverdueDayFacilityTypes	= getStringSetParameter("noOverdueDayFacilityTypes");
		
		return this;
	}

	@XStreamOmitField
	private DateTimeFormatter yyyyMMFormater = DateTimeFormatter.ofPattern("yyyyMM"); 
	
	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		String accountNumber = validationResult.getColumn(accountNumberField);
		String cif = validationResult.getColumn(cifField);
		
		if ( StringUtils.isEmpty(accountNumber) ) {
			return;
		}
		
		SummaryRefRaw summaryRefRaw = getStartEndConditionalValidationAndRemove(submissionData, accountNumber, cif);
		if ( summaryRefRaw != null ){			
			String facilityType = validationResult.getColumn(facilityTypeField);
			if ( StringUtils.isNotEmpty(facilityType) && !StringUtils.equals(facilityType, summaryRefRaw.getFacilityType())){
				validationResult.errors.add(
					new ValidationError(
						fields.get(facilityTypeField), 
						ValidationErrorCode.E40_01_RELATION_MULTI, String.format("referensi Kode jenis fasilitas '%1$s' tidak valid, seharusnya '%2$s'", facilityType, summaryRefRaw.getFacilityType()) 
					)
				);
			}

			Tupple2<Integer, Integer> startEnd = calculateStartEnd(submissionData.getDataYearMonthInt(), summaryStartYearMonth, summaryRefRaw.getStartYearMonth(), summaryRefRaw.getEndYearMonth());
			int startField = startEnd.getA();
			int endField = startEnd.getB();

			for( int i = 0 ; i < 12 ; i++ ){
				int fieldNo = (i * 2) + summaryStartField;
				
				String errorReason = null;
				if ( summaryRefRaw.getEndYearMonth() == null ){
					errorReason = String.format(" bulan tahun data %1$s, bulan tahun mulai %2$s", submissionData.getDataYearMonthInt().toMMslashYYYY(), YearMonth.format(summaryRefRaw.getStartYearMonth()) );
				} else {
					errorReason = String.format(
						" bulan tahun data %1$s, bulan tahun mulai %2$s, bulan tahun kondisi tidak memiliki kewajiban %3$s", 
						submissionData.getDataYearMonthInt().toMMslashYYYY(), 
						YearMonth.format(summaryRefRaw.getStartYearMonth()), YearMonth.format(summaryRefRaw.getEndYearMonth())
					);
				}
				
				if ( i >= startField && i <= endField ){
					
					//Kode Kolektibilitas
					if ( StringUtils.isEmpty(validationResult.getColumn(fieldNo)) ){
						validationResult.errors.add(
							new ValidationError(
								fields.get(fieldNo), 
								ValidationErrorCode.E13_10_SUM_MANDATORY,  errorReason
							)
						);
					}
					
					//Jumlah Hari Tunggakan
					if (noOverdueDayFacilityTypes.contains(facilityType) ) {
						if ( StringUtils.isNotEmpty(validationResult.getColumn(fieldNo+1)) ){
							validationResult.errors.add(
								new ValidationError(
									fields.get(fieldNo + 1), 
									ValidationErrorCode.E13_12_SUM_MUSTEMPTY_FACI,
									noOverdueDayFacilityTypeConcate
								)
							);
						}					
					} else {
						if ( StringUtils.isEmpty(validationResult.getColumn(fieldNo+1)) ){
							validationResult.errors.add(
								new ValidationError(
									fields.get(fieldNo + 1), 
									ValidationErrorCode.E13_10_SUM_MANDATORY, errorReason
								)
							);
						}						
					}
					
				} else {
					
					//Kode Kolektibilitas
					if ( StringUtils.isNotEmpty(validationResult.getColumn(fieldNo)) ){
						validationResult.errors.add(
							new ValidationError(
								fields.get(fieldNo), 
								ValidationErrorCode.E13_11_SUM_MUSTEMPTY, errorReason
							)
						);
					}
					
					//Jumlah Hari Tunggakan 
					if ( StringUtils.isNotEmpty(validationResult.getColumn(fieldNo+1)) ){
						if (noOverdueDayFacilityTypes.contains(facilityType) ) {
							validationResult.errors.add(
								new ValidationError(
									fields.get(fieldNo + 1), 
									ValidationErrorCode.E13_12_SUM_MUSTEMPTY_FACI,
									noOverdueDayFacilityTypeConcate
								)
							);
						} else {
							validationResult.errors.add(
								new ValidationError(
									fields.get(fieldNo + 1), 
									ValidationErrorCode.E13_11_SUM_MUSTEMPTY, errorReason
								)
							);	
						}
					}
				}
			}			
		}  else {
			validationResult.errors.add(
				new ValidationError(
					fields.get(accountNumberField), 
					ValidationErrorCode.E40_01_RELATION_MULTI, String.format("referensi nomor rekening '%1$s' dan CIF '%2$s' tidak ditemukan di fasilitas", accountNumber, cif) 
				)
			);			

//			String cif = validationResult.rowSplited[cifField];
//			if ( StringUtils.isNotEmpty(cif) && !StringUtils.equals(cif, summaryRefRaw.getCif())){
//				validationResult.errors.add(
//					new ValidationError(
//						fields.get(cifField), 
//						ValidationErrorCode.E40_01_RELATION_MULTI, String.format("referensi CIF '%1$s' tidak valid, seharusnya '%2$s'", cif, summaryRefRaw.getCif()) 
//					)
//				);
//			}

		}
	}

	private SummaryRefRaw getStartEndConditionalValidationAndRemove(SubmissionData submissionData, String accountNumber, String cif){
		String key = accountNumber + "#" + cif;
		return submissionData.getValidationRelationModel().summaryRefRawMap.remove(key);
	}

	public Tupple2<Integer, Integer> calculateStartEnd(YearMonth dataYearMonth, YearMonth summaryStartYearMonth, String startYearMonthString, String conditionYearMonthString){
		YearMonth startYearMonth = YearMonth.from(startYearMonthString);
		YearMonth conditionYearMonth = StringUtils.isEmpty(conditionYearMonthString) ? null : YearMonth.from(conditionYearMonthString);
		return calculateStartEnd(dataYearMonth, summaryStartYearMonth, startYearMonth, conditionYearMonth);
	}

	public Tupple2<Integer, Integer> calculateStartEnd(YearMonth dataYearMonth, YearMonth summaryStartYearMonth, YearMonth startYearMonth, YearMonth conditionYearMonth){
		Integer start = 0;
		Integer end = 11;

		//calculate start
		if( startYearMonth.compareTo(dataYearMonth) > 0 ){
			start = 12;
		} else if ( startYearMonth.compareTo(summaryStartYearMonth) <= 0 ){
			start = 0;
		} else {
			start = startYearMonth.monthDifference(summaryStartYearMonth);
		}
		
		if (start > 12){
			start = 12;
		}

		//calculate end
		Integer end1 = 11;
		if ( conditionYearMonth != null) {
			end1 = conditionYearMonth.monthDifference(summaryStartYearMonth) -1;
		}
		
		Integer end2 = 11;
		if ( summaryStartYearMonth.addMonth(12).compareTo(dataYearMonth) > 0 ){
			int dif = summaryStartYearMonth.addMonth(12).monthDifference(dataYearMonth);
			end2 = 11 - dif;
		}			
		
		end = end1 > end2 ? end2 : end1;		
		
		if ( end > 11  )
			end = 11;

		if ( end < -1  )
			end = -1;


		return Tupple2.<Integer, Integer>builder().a(start).b(end).build();
	}

}

