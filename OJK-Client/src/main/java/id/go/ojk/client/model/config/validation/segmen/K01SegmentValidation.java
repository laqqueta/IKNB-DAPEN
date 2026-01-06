package id.go.ojk.client.model.config.validation.segmen;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import id.go.ojk.lib.client.service.context.ApplicationContext;

@XStreamAlias("k01SegmentValidation")
public class K01SegmentValidation extends MapParamSegmentValidation {

	private int assetField;								//ASET
	
	private int currentAssetField;						//ASET LANCAR
	private int caCashField;							//KAS DAN SETARA KAS (AL)
	private int caAccountReceivableField;				//PIUTANG USAHA (AL)
	private int caInvestmentField;						//INVESTASI (AL)
	private int caOtherAssetField;						//ASET LANCAR LAINNYA (AL)
	
	private int nonCurrentAssetField;					//ASET TIDAK LANCAR
	private int ncaAccountReceivableField;				//PIUTANG USAHA (ATL)
	private int ncaInvestmentField;						//INVESTASI (ATL)
	private int ncaOtherAssetField;						//ASET TIDAK LANCAR LAINNYA (ATL)
	
	private int liabilitiesField;						//LIABILITAS
	private int shortTermLiabilitiesField;				//LIABILITAS JANGKA PENDEK
	private int stlShortTermLoanField;					//PINJAMAN JANGKA PENDEK
	private int stlAccountPayablesField;				//UTANG USAHA JANGKA PENDEK
	private int stlOtherShortTermLiabField;				//LIABILITAS JANGKA PENDEK LAINNYA
	private int longTermLiabilitiesField;				//LIABILITAS JANGKA PANJANG
	private int ltlLongTermLoanField;					//PINJAMAN JANGKA PANJANG
	private int ltlLongTermPayablesField;				//UTANG USAHA JANGKA PANJANG
	private int ltlOtherField;							//LIABILITAS JANGKA PANJANG LAINNYA
	
	private int equityField;							//EKUITAS
	
	private int revenueField;							//PENDAPATAN USAHA
	private int expenseField;							//BEBAN POKOK PENDAPATAN
	private int grossProfitField;						//LABA/RUGI BRUTO
	private int otherIncomeField;						//PENDAPATAN LAIN-LAIN
	private int otherExpenseField;						//BEBAN LAIN-LAIN
	private int profitBeforeTaxField;					//LABA/RUGI SEBELUM PAJAK
	private int netIncomeField;							//LABA/RUGI TAHUN BERJALAN
	
	public K01SegmentValidation(){
		super();
	}

	public K01SegmentValidation(String parameter){
		super(parameter);
	}

	@XStreamOmitField
	private ReferenceService referenceService = null;
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		this.appCtx = appCtx;
		if ( appCtx != null ){
			this.referenceService = appCtx.getService(ReferenceService.class);
		}
	}

	@Override
	public K01SegmentValidation initialized() {
		assetField = 3;								//ASET 										- ASSET
		
		currentAssetField = 4;						//ASET LANCAR 								- CURRENT_ASSET
		caCashField = 5;							//KAS DAN SETARA KAS (AL)					- CA_CASH
		caAccountReceivableField = 6;				//PIUTANG USAHA (AL)						- CA_ACCOUNT_RECEIVABLE
		caInvestmentField = 7;						//INVESTASI (AL)							- CA_INVESTMENT
		caOtherAssetField = 8;						//ASET LANCAR LAINNYA (AL)					- CA_OTHER_ASSET
		
		nonCurrentAssetField = 9;					//ASET TIDAK LANCAR							- NON_CURRENT_ASSET
		ncaAccountReceivableField = 10;				//PIUTANG USAHA (ATL)						- NCA_ACCOUNT_RECEIVABLE
		ncaInvestmentField = 11;					//INVESTASI (ATL)							- NCA_INVESTMENT
		ncaOtherAssetField = 12;					//ASET TIDAK LANCAR LAINNYA (ATL)			- NCA_OTHER_ASSET
		
		liabilitiesField = 13;						//LIABILITAS								- LIABILITIES
		
		shortTermLiabilitiesField = 14;				//LIABILITAS JANGKA PENDEK					- SHORT_TERM_LIABILITIES
		stlShortTermLoanField = 15;					//PINJAMAN JANGKA PENDEK					- STL_SHORT_TERM_LOAN
		stlAccountPayablesField = 16;				//UTANG USAHA JANGKA PENDEK					- STL_ACCOUNT_PAYABLES * 
		stlOtherShortTermLiabField = 17;			//LIABILITAS JANGKA PENDEK LAINNYA			- STL_OTHER_SHORT_TERM_LIAB
		
		longTermLiabilitiesField = 18;				//LIABILITAS JANGKA PANJANG					- LONG_TERM_LIABILITIES
		ltlLongTermLoanField = 19;					//PINJAMAN JANGKA PANJANG					- LTL_LONG_TERM_LOAN
		ltlLongTermPayablesField = 20;				//UTANG USAHA JANGKA PANJANG				- LTL_LONG_TERM_PAYABLES
		ltlOtherField = 21;							//LIABILITAS JANGKA PANJANG LAINNYA			- LTL_OTHER
		
		equityField = 22;							//EKUITAS									- EQUITY
		
		revenueField = 23;							//PENDAPATAN USAHA							- REVENUE
		expenseField = 24;							//BEBAN POKOK PENDAPATAN					- EXPENSE
		grossProfitField = 25;						//LABA/RUGI BRUTO							- GROSS_PROFIT
		
		otherIncomeField = 26;						//PENDAPATAN LAIN-LAIN						- OTHER_INCOME
		otherExpenseField = 27;						//BEBAN LAIN-LAIN							- OTHER_EXPENSE
		profitBeforeTaxField = 28;					//LABA/RUGI SEBELUM PAJAK					- PROFIT_BEFORE_TAX
		netIncomeField = 29;						//LABA/RUGI TAHUN BERJALAN					- NET_INCOME

		return this;
	}

	@XStreamOmitField
	private DateTimeFormatter yyyyMMFormater = DateTimeFormatter.ofPattern("yyyyMM"); 
	
	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		List<SubmissionField> fields = submissionFormat.getFields();
		
		validateJumlah(validationResult, fields, assetField, currentAssetField, nonCurrentAssetField);
		validateJumlah(validationResult, fields, assetField, liabilitiesField, equityField);
		validateJumlah(validationResult, fields, currentAssetField, caCashField, caAccountReceivableField, caInvestmentField, caOtherAssetField);		
		validateJumlah(validationResult, fields, nonCurrentAssetField, ncaAccountReceivableField, ncaInvestmentField, ncaOtherAssetField);
		validateJumlah(validationResult, fields, liabilitiesField, shortTermLiabilitiesField, longTermLiabilitiesField);
		validateJumlah(validationResult, fields, shortTermLiabilitiesField, stlShortTermLoanField, stlAccountPayablesField, stlOtherShortTermLiabField);
		validateJumlah(validationResult, fields, longTermLiabilitiesField, ltlLongTermLoanField, ltlLongTermPayablesField, ltlOtherField);

		//Validasi K01 kolom Laba/Rugi Bruto: The subtract of Pendapatan Usaha/Operasional and Beban Pokok Pendapatan/Beban Operasional should be equal to Laba/Rugi Bruto
		Long revenue = ValidationUtil.validateLong(fields.get(revenueField), validationResult, false);
		Long expense = ValidationUtil.validateLong(fields.get(expenseField), validationResult, false);
		Long grossProfit = ValidationUtil.validateLong(fields.get(grossProfitField), validationResult, false);
		
		if ( revenue != null && expense != null && grossProfit != null ){
			if ( grossProfit.longValue() != (revenue.longValue() - expense.longValue()) ) {
				validationResult.errors.add(
					new ValidationError(
						fields.get(grossProfitField), 
						ValidationErrorCode.E20_26_FIN_RPT_REVENUE
					)
				);
			}
		}
		
		//Validasi K01 kolom Laba/Rugi Sebelum Pajak: (Laba/Rugi Bruto+Pendapatan Lain-lain/Non Operasional)-Beban Lain-lain/Non Operasional should be equal to Laba/Rugi sebelum pajak
		Long otherIncome = ValidationUtil.validateLong(fields.get(otherIncomeField), validationResult, false);  				//PENDAPATAN LAIN-LAIN
		Long otherExpense = ValidationUtil.validateLong(fields.get(otherExpenseField), validationResult, false);				//BEBAN LAIN-LAIN
		Long profitBeforeTax = ValidationUtil.validateLong(fields.get(profitBeforeTaxField), validationResult, false);			//LABA/RUGI SEBELUM PAJAK

		if ( grossProfit != null && otherIncome != null && otherExpense != null && profitBeforeTax != null ){
			if ( profitBeforeTax.longValue() != (grossProfit.longValue() + otherIncome.longValue() - otherExpense.longValue()) ) {
				validationResult.errors.add(
					new ValidationError(
						fields.get(profitBeforeTaxField), 
						ValidationErrorCode.E20_27_FIN_RPT_PROFITBEFORETAX,
						StringUtils.join("")
					)
				);
			}
		}
	}
	
	private void validateJumlah(ValidationResult validationResult, List<SubmissionField> fields, int sumFieldNumber, int ...  fieldNumbers){
		SubmissionField sumField = fields.get(sumFieldNumber);
		Long sum = ValidationUtil.validateLong(sumField, validationResult, false);
		
		if ( sum == null )
			return;
		
		List<SubmissionField> detailFields = new ArrayList<>();
		List<Long> detailValues = new ArrayList<>();
		
		for (int fieldNumber : fieldNumbers) {
			SubmissionField submissionField = fields.get(fieldNumber);
			detailFields.add(submissionField);
			Long detailValue = ValidationUtil.validateLong(submissionField, validationResult, false);
			detailValues.add(detailValue);
			if ( detailValue == null )
				return;
		}
		
		long sumReal = detailValues.stream().mapToLong(e -> e.longValue()).sum();
		if ( sumReal != sum ){
			validationResult.errors.add(
				new ValidationError(
					sumField, 
					ValidationErrorCode.E20_25_FIN_RPT_SUM,
					StringUtils.join(
						"Jumlah ", 
						detailFields.stream().map( e -> e.getName() ).collect(Collectors.joining(", ")),
						" harus sama dengan ", sumField.getName()
					)
				)
			);
		}
		
	}
	
}
