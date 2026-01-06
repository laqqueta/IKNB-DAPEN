package id.go.ojk.conf.client;

import id.go.ojk.client.model.config.validation.segmen.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UtilSegmentValidation {

	public static SegmentValidation genPeriodValidation(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new PeriodValidation(builder.toString());
	}

	public static SegmentValidation genRegexNumericDotOpt(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexNumericDotOptNegativeValidation(builder.toString());
	}

	public static SegmentValidation genRegexNumericDotNegative(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexNumericDotNegativeValidation(builder.toString());
	}

	public static SegmentValidation genRegexNumericDot(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexNumericDotValidation(builder.toString());
	}

	public static SegmentValidation genRegexNumericNegative(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexNumericNegativeValidation(builder.toString());
	}

	public static SegmentValidation genRegexNumericMustNegative(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexNumericMustNegativeValidation(builder.toString());
	}

	public static SegmentValidation genRegexNumeric(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexNumericValidation(builder.toString());
	}

	public static SegmentValidation genRegexAlfaNumericSpace(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexAlfaNumericSpaceValidation(builder.toString());
	}

	public static SegmentValidation genRegexAlfaNumeric(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexAlfaNumericValidation(builder.toString());
	}

	public static SegmentValidation genRegexAlfaSpace(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexAlfaSpaceValidation(builder.toString());
	}

	public static SegmentValidation genRegexAlfa(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexAlfaValidation(builder.toString());
	}

	public static SegmentValidation genRegexDate(String selectField, String selectPosCode, String dateFormat) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&dateFormat=" + dateFormat);
		return new RegexDateValidation(builder.toString());
	}

	public static SegmentValidation genRegexYear(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexYearValidation(builder.toString());
	}

	public static SegmentValidation genRegexCompanyName(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexCompanyNameValidation(builder.toString());
	}

	public static SegmentValidation genRegexCompanyAddress(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexCompanyAddressValidation(builder.toString());
	}

	public static SegmentValidation genRegexPhone(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexPhoneValidation(builder.toString());
	}

	public static SegmentValidation genRegexPhone2(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexPhone2Validation(builder.toString());
	}

	public static SegmentValidation genRegexEmail(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexEmailValidation(builder.toString());
	}

	public static SegmentValidation genRegexWebAddress(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexWebAddressValidation(builder.toString());
	}

	public static SegmentValidation genRegexNpwp(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexNpwpValidation(builder.toString());
	}

	public static SegmentValidation genRegexSkNumber(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexSkNumberValidation(builder.toString());
	}

	public static SegmentValidation genRegexLjkName(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexLjkNameValidation(builder.toString());
	}

	public static SegmentValidation genRegexLjkAddress(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexLjkAddressValidation(builder.toString());
	}

	public static SegmentValidation genRegexDate(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexDateValidation(builder.toString());
	}

	public static SegmentValidation genRegexReference1(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexReference1Validation(builder.toString());
	}

	public static SegmentValidation genRegexName2(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexName2Validation(builder.toString());
	}

	public static SegmentValidation genRegexName4(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new RegexName4Validation(builder.toString());
	}
	
  public static SegmentValidation genRegexAll(String selectField, String selectPosCode) {
    StringBuilder builder = new StringBuilder("selectField=" + selectField);
    builder.append("&selectPosCode=" + selectPosCode);
    return new RegexAllValidation(builder.toString());
  }

	public static SegmentValidation genReference(String selectField, String selectPosCode, String referenceNumber) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&referenceNumber=" + referenceNumber);
		return new ReferenceValidation(builder.toString());
	}

	public static SegmentValidation genReference(String selectField, String selectPosCode, int referenceNumber) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&referenceNumber=" + referenceNumber);
		return new ReferenceValidation(builder.toString());
	}

	public static SegmentValidation genReferenceCondition(String selectField, String selectPosCode,
			String referenceNumber, String parentPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&referenceNumber=" + referenceNumber);
		builder.append("&parentPosCode=" + parentPosCode);
		return new ReferenceConditionValidation(builder.toString());
	}

	public static SegmentValidation genMaxLength(String selectField, String selectPosCode, int maxLength) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&maxLength=" + maxLength);
		return new MaxLengthValidation(builder.toString());
	}

	public static SegmentValidation genLength(String selectField, String selectPosCode, int minLength, int maxLength) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&minLength=" + minLength);
		builder.append("&maxLength=" + maxLength);
		return new LengthValidation(builder.toString());
	}

	public static SegmentValidation genFixedValue(String selectField, String selectPosCode, String value) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&value=" + value);
		return new FixedValueValidation(builder.toString());
	}

	public static SegmentValidation genFixedValueOptional(String selectField, String selectPosCode, String value) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&value=" + value);
		return new FixedValueOptionalValidation(builder.toString());
	}

	public static SegmentValidation genNotZeroField(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new NotZeroFieldValidation(builder.toString());
	}

	@Deprecated
	public static SegmentValidation genSum(String selectField, String fieldResult, String rightFormula,
			String msgError) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + fieldResult);
		builder.append("&leftFormula=" + fieldResult);
		builder.append("&rightFormula=" + rightFormula);
		builder.append("&operator=e");
		builder.append("&msgError=" + msgError);
		return new SumValidation(builder.toString());
	}

	public static SegmentValidation genSumPrecision(String selectField, String fieldResult, String rightFormula,
			String precision, String msgError) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + fieldResult);
		builder.append("&leftFormula=" + fieldResult);
		builder.append("&rightFormula=" + rightFormula);
		builder.append("&precision=" + precision);
		builder.append("&operator=e");
		builder.append("&msgError=" + msgError);
		return new SumPrecisionValidation(builder.toString());
	}

	public static SegmentValidation genEqualsRatio(String selectField, String fieldResult, String rightFormula,
			String msgError) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + fieldResult);
		builder.append("&leftFormula=" + fieldResult);
		builder.append("&rightFormula=" + rightFormula);
		builder.append("&operator=e");
		builder.append("&msgError=" + msgError);
		return new RatioValidation(builder.toString());
	}

  public static SegmentValidation genEqualsRatio2(String selectField, String fieldResult, String rightFormula,
      String msgError) {
    StringBuilder builder = new StringBuilder("selectField=" + selectField);
    builder.append("&selectPosCode=" + fieldResult);
    builder.append("&leftFormula=" + fieldResult);
    builder.append("&rightFormula=" + rightFormula);
    builder.append("&operator=e");
    builder.append("&msgError=" + msgError);
    return new RatioValidation2(builder.toString());
  }

  public static SegmentValidation genEqualsRatio2(String selectField, String fieldResult, String rightFormula,
      String msgError, boolean divByPeriod) {
    StringBuilder builder = new StringBuilder("selectField=" + selectField);
    builder.append("&selectPosCode=" + fieldResult);
    builder.append("&leftFormula=" + fieldResult);
    builder.append("&rightFormula=" + rightFormula);
    builder.append("&operator=e");
    builder.append("&msgError=" + msgError);
    builder.append("&divByPeriod=" + divByPeriod);
    return new RatioValidation2(builder.toString());
  }

  public static SegmentValidation genEqualsRatio2(String selectField, String fieldResult, String rightFormula,
      String msgError, String leftConstFormula, String rightConstFormula) {
    StringBuilder builder = new StringBuilder("selectField=" + selectField);
    builder.append("&selectPosCode=" + fieldResult);
    builder.append("&leftFormula=" + fieldResult);
    builder.append("&rightFormula=" + rightFormula);
    builder.append("&operator=e");
    if(leftConstFormula != null) {
      builder.append("&leftConstFormula=" + leftConstFormula);
    }
    if(rightConstFormula != null) {
      builder.append("&rightConstFormula=" + rightConstFormula);
    }
    builder.append("&msgError=" + msgError);
    return new RatioValidation2(builder.toString());
  }

	public static SegmentValidation genPercentage(String selectField, String fieldResult, String rightFormula,
			String msgError) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + fieldResult);
		builder.append("&leftFormula=" + fieldResult);
		builder.append("&rightFormula=" + rightFormula);
		builder.append("&operator=e");
		builder.append("&msgError=" + msgError);
		return new PercentageValidation(builder.toString());
	}

	public static SegmentValidation genCurrentRowVsCustomRowRatio(String ratioFields, String selectPosCodes,
			String denominatorPosCode, String msgError) {
		StringBuilder builder = new StringBuilder();
		builder.append("ratioField=" + ratioFields);
		builder.append("&selectPosCode=" + selectPosCodes);
		builder.append("&denominatorPosCode=" + denominatorPosCode);
		builder.append("&operator=e");
		builder.append("&msgError=" + msgError);
		return new CurrentRowVsCustomRowRatioValidation(builder.toString());
	}

	public static SegmentValidation genEqualRowColumn(String selectField, String selectPosCode, String comparatorField,
			String comparatorPosCode, String msgError) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&operator=e");
		builder.append("&msgError=" + msgError);
		return new WithRowColumnValidation(builder.toString());
	}

	public static SegmentValidation genDeviationMax(String selectField, String selectPosCode, String refPosCode,
			String fixedValue, String multiplier, String msgError) {
		return genDeviationMax(selectField, selectPosCode, refPosCode, fixedValue, multiplier, msgError, 2);
	}

	public static SegmentValidation genDeviationMax(String selectField, String selectPosCode, String refPosCode,
			String fixedValue, String multiplier, String msgError, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&fixedValue=" + fixedValue);
		builder.append("&multiplier=" + multiplier);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&msgError=" + msgError);
		return new DeviationMaxValidation(builder.toString());
	}

	public static SegmentValidation genMaxValue(String selectField, String selectPosCode, String posCodeFormula,
			String fixedValue, String errorMessage) {
		return genMaxValue(selectField, selectPosCode, posCodeFormula, fixedValue, errorMessage, 2);
	}

	public static SegmentValidation genMaxValue(String selectField, String selectPosCode, String posCodeFormula,
			String fixedValue, String errorMessage, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&posCodeFormula=" + posCodeFormula);
		builder.append("&fixedValue=" + fixedValue);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&errorMessage=" + errorMessage);
		return new MaxValueValidation(builder.toString());
	}

	public static SegmentValidation genFactorSeMmbr2017Validation(String selectField, String selectPosCode,
			String posCodeSelisihAset, String posCodeJumlahLiabilitas) {
		return genFactorSeMmbr2017Validation(selectField, selectPosCode, posCodeSelisihAset, posCodeJumlahLiabilitas,
				2);
	}

	public static SegmentValidation genFactorSeMmbr2017Validation(String selectField, String selectPosCode,
			String posCodeSelisihAset, String posCodeJumlahLiabilitas, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&posCodeSelisihAset=" + posCodeSelisihAset);
		builder.append("&posCodeJumlahLiabilitas=" + posCodeJumlahLiabilitas);
		builder.append("&scale=" + scale);
		return new FactorSeMmbr2017Validation(builder.toString());
	}

	public static SegmentValidation genFactorValidation(String selectField, String selectPosCode,
			String posCodeJumlahAset, String posCodeJumlahLiabilitas) {
		return genFactorValidation(selectField, selectPosCode, posCodeJumlahAset, posCodeJumlahLiabilitas, 2);
	}

	public static SegmentValidation genFactorValidation(String selectField, String selectPosCode,
			String posCodeJumlahAset, String posCodeJumlahLiabilitas, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&posCodeJumlahAset=" + posCodeJumlahAset);
		builder.append("&posCodeJumlahLiabilitas=" + posCodeJumlahLiabilitas);
		builder.append("&scale=" + scale);
		return new FactorValidation(builder.toString());
	}

	public static SegmentValidation genDeviationFactorSeMmbr2017Validation(String selectField, String selectPosCode,
			String posCodeFactor, String posCodeJumlahAset, String posCodeJumlahLiabilitas) {
		return genDeviationFactorSeMmbr2017Validation(selectField, selectPosCode, posCodeFactor, posCodeJumlahAset,
				posCodeJumlahLiabilitas, 2);
	}

	public static SegmentValidation genDeviationFactorSeMmbr2017Validation(String selectField, String selectPosCode,
			String posCodeFactor, String posCodeJumlahAset, String posCodeJumlahLiabilitas, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&posCodeFactor=" + posCodeFactor);
		builder.append("&posCodeJumlahAset=" + posCodeJumlahAset);
		builder.append("&posCodeJumlahLiabilitas=" + posCodeJumlahLiabilitas);
		builder.append("&scale=" + scale);
		return new DeviationFactorSeMmbr2017Validation(builder.toString());
	}

	public static SegmentValidation genDeviationValidation(String selectField, String selectPosCode,
			String posCodeJumlahAset, String posCodeJumlahLiabilitas, String posCodeSelisihAset, String posCodeFactor,
			String errorMessage) {
		return genDeviationValidation(selectField, selectPosCode, posCodeJumlahAset, posCodeJumlahLiabilitas,
				posCodeSelisihAset, posCodeFactor, errorMessage, 2);
	}

	public static SegmentValidation genDeviationValidation(String selectField, String selectPosCode,
			String posCodeJumlahAset, String posCodeJumlahLiabilitas, String posCodeSelisihAset, String posCodeFactor,
			String errorMessage, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&posCodeJumlahAset=" + posCodeJumlahAset);
		builder.append("&posCodeJumlahLiabilitas=" + posCodeJumlahLiabilitas);
		builder.append("&posCodeSelisihAset=" + posCodeSelisihAset);
		builder.append("&posCodeFactor=" + posCodeFactor);
		builder.append("&errorMessage=" + errorMessage);
		builder.append("&scale=" + scale);
		return new DeviationValidation(builder.toString());
	}

	public static SegmentValidation genRisikoOperasionalPerusahaan(String selectField, String selectPosCode,
			String posCodeBebanUmumDanAdministrasi, String posCodeBebanPendidikanDanPelatihan,
			String posCodeSaldoBiayaAkuisisiYangDitangguhkan) {
		return genRisikoOperasionalPerusahaan(selectField, selectPosCode, posCodeBebanUmumDanAdministrasi,
				posCodeBebanPendidikanDanPelatihan, posCodeSaldoBiayaAkuisisiYangDitangguhkan, 2);
	}

	public static SegmentValidation genRisikoOperasionalPerusahaan(String selectField, String selectPosCode,
			String posCodeBebanUmumDanAdministrasi, String posCodeBebanPendidikanDanPelatihan,
			String posCodeSaldoBiayaAkuisisiYangDitangguhkan, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&posCodeBebanUmumDanAdministrasi=" + posCodeBebanUmumDanAdministrasi);
		builder.append("&posCodeBebanPendidikanDanPelatihan=" + posCodeBebanPendidikanDanPelatihan);
		builder.append("&posCodeSaldoBiayaAkuisisiYangDitangguhkan=" + posCodeSaldoBiayaAkuisisiYangDitangguhkan);
		builder.append("&scale=" + scale);
		return new RisikoOperasionalPerusahaanValidation(builder.toString());
	}

	public static SegmentValidation genMultiply(String selectField, String selectPosCode, String posCode,
			String fixedValue, String errorMessage) {
		return genMultiply(selectField, selectPosCode, posCode, fixedValue, 2, errorMessage);
	}

	public static SegmentValidation genMultiply(String selectField, String selectPosCode, String posCode,
			String fixedValue, int scale, String errorMessage) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&posCode=" + posCode);
		builder.append("&fixedValue=" + fixedValue);
		builder.append("&scale=" + scale);
		builder.append("&errorMessage=" + errorMessage);
		return new MultiplyValidation(builder.toString());
	}

	public static SegmentValidation genSumMultiply(String selectField, String selectPosCode, String posCode,
			String fixedValue, String errorMessage) {
		return genSumMultiply(selectField, selectPosCode, posCode, fixedValue, errorMessage, 2);
	}

	public static SegmentValidation genSumMultiply(String selectField, String selectPosCode, String posCode,
			String fixedValue, String errorMessage, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&posCode=" + posCode);
		builder.append("&fixedValue=" + fixedValue);
		builder.append("&errorMessage=" + errorMessage);
		builder.append("&scale=" + scale);
		return new SumMultiplyValidation(builder.toString());
	}

	public static SegmentValidation genSumMultiply3(String selectField, String selectPosCode, String posCode,
			String fixedValue, String posCode2, String fixedValue2, String posCode3, String fixedValue3,
			String errorMessage) {
		return genSumMultiply3(selectField, selectPosCode, posCode, fixedValue, posCode2, fixedValue2, posCode3,
				fixedValue3, errorMessage, 2);
	}

	public static SegmentValidation genSumMultiply3(String selectField, String selectPosCode, String posCode,
			String fixedValue, String posCode2, String fixedValue2, String posCode3, String fixedValue3,
			String errorMessage, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&posCode=" + posCode);
		builder.append("&fixedValue=" + fixedValue);
		builder.append("&posCode2=" + posCode2);
		builder.append("&fixedValue2=" + fixedValue2);
		builder.append("&posCode3=" + posCode3);
		builder.append("&fixedValue3=" + fixedValue3);
		builder.append("&errorMessage=" + errorMessage);
		builder.append("&scale=" + scale);
		return new SumMultiplyValidation3(builder.toString());
	}

	public static SegmentValidation genSumForm(String selectField, String selectPosCode, String leftFormula,
			String rightFormula, String msgError) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&leftFormula=" + leftFormula);
		builder.append("&rightFormula=" + rightFormula);
		builder.append("&operator=e");
		builder.append("&msgError=" + msgError);
		return new SumFormValidation(builder.toString());
	}

    public static SegmentValidation genEqualsForm4(String selectField, String selectPosCode, String comparatorForm,
                                                  String comparatorField, String comparatorPosCode, String comperatorOperator, String posOperator, String errMsg, String posErrorMsg) {
        return genEqualsForm4(selectField, selectPosCode, comparatorForm, comparatorField, comparatorPosCode, comperatorOperator, posOperator, errMsg, posErrorMsg, 2);
    }


    public static SegmentValidation genEqualsForm(String selectField, String selectPosCode, String comparatorForm,
			String comparatorField, String comparatorPosCode) {
		return genEqualsForm(selectField, selectPosCode, comparatorForm, comparatorField, comparatorPosCode, "", 2);
	}

	public static SegmentValidation genEqualsForm(String selectField, String selectPosCode, String comparatorForm,
			String comparatorField, String comparatorPosCode, String msgError) {
		return genEqualsForm(selectField, selectPosCode, comparatorForm, comparatorField, comparatorPosCode, msgError,
				2);
	}

	public static SegmentValidation genEqualsForm(String selectField, String selectPosCode, String comparatorForm,
			String comparatorField, String comparatorPosCode, int scale) {
		return genEqualsForm(selectField, selectPosCode, comparatorForm, comparatorField, comparatorPosCode, "", scale);
	}

	public static SegmentValidation genEqualsForm(String selectField, String selectPosCode, String comparatorForm,
			String comparatorField, String comparatorPosCode, String msgError, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorForm=" + comparatorForm);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&msgError=" + msgError);
		return new ComparisonFormValidation(builder.toString());
	}

    public static SegmentValidation genEqualsForm4(String selectField, String selectPosCode, String comparatorForm, String comparatorField,
                                                   String comparatorPosCode, String comparatorOperator, String posOperator, String msgError,
                                                   String showErrorOnPos, int scale) {
        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorField=" + comparatorField);
        builder.append("&comparatorPosCode=" + comparatorPosCode);
        builder.append("&operator=e");
        builder.append("&posOperator=" + posOperator);
        builder.append("&comparatorOperator=" + comparatorOperator);
        builder.append("&scale=" + scale);
        builder.append("&msgError=" + msgError);
        builder.append("&showErrorOnPos=" + showErrorOnPos);
        return new ComparisonFormValidation4(builder.toString());
    }

  public static SegmentValidation genEqualsForm(String selectField, String selectPosCode, String comparatorForm,
      String comparatorField, String comparatorPosCode, String operator, String msgError, int scale) {
    StringBuilder builder = new StringBuilder("selectField=" + selectField);
    builder.append("&selectPosCode=" + selectPosCode);
    builder.append("&comparatorForm=" + comparatorForm);
    builder.append("&comparatorField=" + comparatorField);
    builder.append("&comparatorPosCode=" + comparatorPosCode);
    builder.append("&operator=" + operator);
    builder.append("&scale=" + scale);
    builder.append("&msgError=" + msgError);
    return new ComparisonFormValidation(builder.toString());
  }

	public static SegmentValidation genEqualsFormTotalRow(String selectField, String selectPosCode,
			String comparatorForm, String msgError) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorForm=" + comparatorForm);
		builder.append("&msgError=" + msgError);
		return new EqualsFormTotalDetailRowValidation(builder.toString());
	}

    public static SegmentValidation genEqualsFormTotalRowExpectPos(String selectField, String selectPosCode,
                                                          String comparatorForm, String expectPos, String msgError) {
        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&expectPos=" + expectPos);
        builder.append("&msgError=" + msgError);
        return new EqualsFormTotalDetailRowExceptPosValidation(builder.toString());
    }

	public static SegmentValidation genEqualsFormTotalRow(String selectField, String selectPosCode,
			String comparatorForm, String filterField, String filterValue, String msgError) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorForm=" + comparatorForm);
		builder.append("&comparatorFilterField=" + filterField);
		builder.append("&comparatorFilterValue=" + filterValue);
		builder.append("&msgError=" + msgError);
		return new EqualsFormTotalDetailRowFilterValidation(builder.toString());
	}

    public static SegmentValidation genEqualsFormTotalRowExpectPos(String selectField, String selectPosCode,
                                                          String comparatorForm, String filterField, String filterValue, String expectPos, String msgError) {
        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorFilterField=" + filterField);
        builder.append("&comparatorFilterValue=" + filterValue);
        builder.append("&expectPos=" + expectPos);
        builder.append("&msgError=" + msgError);
        return new EqualsFormTotalDetailRowFilterValidation(builder.toString());
    }

	public static SegmentValidation genEqualsFormTotalRowNotIn(String selectField, String selectPosCode,
			String comparatorForm, String filterField, String filterValue, String msgError) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorForm=" + comparatorForm);
		builder.append("&comparatorFilterField=" + filterField);
		builder.append("&comparatorFilterValue=" + filterValue);
		builder.append("&msgError=" + msgError);
		return new EqualsFormTotalDetailRowFilterNotInValidation(builder.toString());
	}

    public static SegmentValidation genEqualsFormTotalRowNotInExpectPos(String selectField, String selectPosCode,
                                                               String comparatorForm, String filterField, String filterValue, String expectPos, String msgError) {
        StringBuilder builder = new StringBuilder("selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        builder.append("&comparatorForm=" + comparatorForm);
        builder.append("&comparatorFilterField=" + filterField);
        builder.append("&comparatorFilterValue=" + filterValue);
        builder.append("&expectPos=" + expectPos);
        builder.append("&msgError=" + msgError);
        return new EqualsFormTotalDetailRowFilterNotInExpectPosValidation(builder.toString());
    }

	public static SegmentValidation genEqualsFormString(String selectField, String selectPosCode, String comparatorForm,
			String comparatorField, String comparatorPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorForm=" + comparatorForm);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&operator=e");
		builder.append("&msgError=");
		return new StringComparisonFormValidation(builder.toString());
	}

	public static SegmentValidation genEqualsForm2(String selectField, String selectPosCode, String comparatorForm,
			String comparatorPosCode, String msgError) {
		return genEqualsForm2(selectField, selectPosCode, comparatorForm, comparatorPosCode, msgError, 2);
	}

	public static SegmentValidation genEqualsForm2(String selectField, String selectPosCode, String comparatorForm,
			String comparatorPosCode, String msgError, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorForm=" + comparatorForm);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&msgError=" + msgError);
		return new ComparisonFormValidation2(builder.toString());
	}

	public static SegmentValidation genEqualsForm3(String selectField, String selectPosCode, String comparatorForm,
			String comparatorField, String comparatorPosCode, String comparatorBaseValue, String msgError) {
		return genEqualsForm3(selectField, selectPosCode, comparatorField, comparatorForm, comparatorPosCode,
				comparatorBaseValue, msgError, 2);
	}

	public static SegmentValidation genEqualsForm3(String selectField, String selectPosCode, String comparatorField,
			String comparatorForm, String comparatorPosCode, String comparatorBaseValue, String msgError, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorForm=" + comparatorForm);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&comparatorBaseValue=" + comparatorBaseValue);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&msgError=" + msgError);
		return new ComparisonFormValidation3(builder.toString());
	}

	public static SegmentValidation genEqualsForm5(String selectField, String selectPosCode, String comparatorField,
      String comparatorForm, String comparatorPosCode, String leftExpr, String rightExpr) {
	  return genEqualsForm5(selectField, selectPosCode, comparatorField, comparatorForm, comparatorPosCode, leftExpr, rightExpr, "", 2);
	}

  public static SegmentValidation genEqualsForm5(String selectField, String selectPosCode, String comparatorField,
      String comparatorForm, String comparatorPosCode, String leftExpr, String rightExpr, String msgError, int scale) {
    StringBuilder builder = new StringBuilder("selectField=" + selectField);
    builder.append("&selectPosCode=" + selectPosCode);
    builder.append("&comparatorField=" + comparatorField);
    builder.append("&comparatorForm=" + comparatorForm);
    builder.append("&comparatorPosCode=" + comparatorPosCode);

    if(leftExpr != null) {
      builder.append("&leftExpr=" + leftExpr);
    }

    if(rightExpr != null) {
      builder.append("&rightExpr=" + rightExpr);
    }

    builder.append("&operator=e");
    builder.append("&scale=" + scale);
    builder.append("&msgError=" + msgError);
    return new ComparisonFormValidation5(builder.toString());
  }

	public static SegmentValidation genEqualsFormulaForm2(String selectField, String selectPosCode,
			String comparatorField, String comparatorPosCode, String comparatorFilterField,
			String comparatorFilterValue, String msgError) {
		return genEqualsFormulaForm2(selectField, selectPosCode, comparatorField, comparatorPosCode,
				comparatorFilterField, comparatorFilterValue, msgError, 2);
	}

	public static SegmentValidation genEqualsFormulaForm2(String selectField, String selectPosCode,
			String comparatorField, String comparatorPosCode, String comparatorFilterField,
			String comparatorFilterValue, String msgError, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&comparatorFilterField=" + comparatorFilterField);
		builder.append("&comparatorFilterValue=" + comparatorFilterValue);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&msgError=" + msgError);
		return new ComparisonFormulaFormValidation2(builder.toString());
	}

  public static SegmentValidation genEqualsFormulaForm4(String selectField, String selectPosCode,
      String comparatorField, String comparatorPosCode, String msgError, int scale) {
    StringBuilder builder = new StringBuilder("selectField=" + selectField);
    builder.append("&selectPosCode=" + selectPosCode);
    builder.append("&comparatorField=" + comparatorField);
    builder.append("&comparatorPosCode=" + comparatorPosCode);
    builder.append("&operator=e");
    builder.append("&scale=" + scale);
    builder.append("&msgError=" + msgError);
    return new ComparisonFormulaFormValidation4(builder.toString());
  }

	public static SegmentValidation genEqualsFormulaForm(String selectField, String selectPosCode,
			String comparatorField, String comparatorPosCode, String msgError) {
		return genEqualsFormulaForm(selectField, selectPosCode, comparatorField, comparatorPosCode, msgError, 2);
	}

	public static SegmentValidation genEqualsFormulaForm(String selectField, String selectPosCode,
			String comparatorField, String comparatorPosCode, String msgError, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&msgError=" + msgError);
		return new ComparisonFormulaFormValidation(builder.toString());
	}

	public static SegmentValidation genEqualsFormColumCalculation(String selectField, String selectPosCode,
			String comparatorColumn, String comparatorRowCode, String message, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorColumn=" + comparatorColumn);
		builder.append("&comparatorRowCode=" + comparatorRowCode);
		builder.append("&scale=" + scale);
		builder.append("&message=" + message);
		return new EqualsFormColumnCalculate(builder.toString());
	}

	public static SegmentValidation genEqualsFormAdd(String selectField, String selectPosCode,
			String comparatorField, String comparatorRowCode, String message) {
		return genEqualsFormAdd(selectField, selectPosCode, comparatorField, comparatorRowCode, message, 2);
	}
	
	public static SegmentValidation genEqualsFormAdd(String selectField, String selectPosCode,
			String comparatorField, String comparatorRowCode, String message, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorRowCode=" + comparatorRowCode);
		builder.append("&scale=" + scale);
		builder.append("&message=" + message);
		return new EqualsFormAddValidation(builder.toString());
	}

	public static SegmentValidation genEqualsFormulaFormNotEquals(String selectField, String selectPosCode,
			String comparatorField, String comparatorPosCode, String comparatorFilterField,
			String comparatorFilterValueNotEquals, String msgError) {
		return genEqualsFormulaFormNotEquals(selectField, selectPosCode, comparatorField, comparatorPosCode,
				comparatorFilterField, comparatorFilterValueNotEquals, msgError, 2);
	}

	public static SegmentValidation genEqualsFormulaFormNotEquals(String selectField, String selectPosCode,
			String comparatorField, String comparatorPosCode, String comparatorFilterField,
			String comparatorFilterValueNotEquals, String msgError, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&comparatorFilterField=" + comparatorFilterField);
		builder.append("&comparatorFilterValue=" + comparatorFilterValueNotEquals);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&msgError=" + msgError);
		return new ComparisonFormulaFormNotEqualsValidation(builder.toString());
	}

	public static SegmentValidation genEqualsFormulaFormMultiFilter(String selectField, String selectPosCode,
			String comparatorField, String comparatorPosCode, String comparatorFilterFieldEquals,
			String comparatorFilterValueEquals, String msgError) {
		return genEqualsFormulaFormMultiFilter(selectField, selectPosCode, comparatorField, comparatorPosCode,
				comparatorFilterFieldEquals, comparatorFilterValueEquals, msgError, 2);
	}

	public static SegmentValidation genEqualsFormulaFormMultiFilter(String selectField, String selectPosCode,
			String comparatorField, String comparatorPosCode, String comparatorFilterField,
			String comparatorFilterValue, String msgError, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&comparatorFilterField=" + comparatorFilterField);
		builder.append("&comparatorFilterValue=" + comparatorFilterValue);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&msgError=" + msgError);
		return new ComparisonFormulaFormValidation3(builder.toString());
	}

	public static SegmentValidation genEqualsFormulaFormMultiFilterNotEquals(String selectField, String selectPosCode,
			String comparatorField, String comparatorPosCode, String comparatorFilterField,
			String comparatorFilterValue, String comparatorFilterFieldNotEquals, String comparatorFilterValueNotEquals,
			String msgError) {
		return genEqualsFormulaFormMultiFilterNotEquals(selectField, selectPosCode, comparatorField, comparatorPosCode,
				comparatorFilterField, comparatorFilterValue, comparatorFilterFieldNotEquals,
				comparatorFilterValueNotEquals, msgError, 2);
	}

	public static SegmentValidation genEqualsFormulaFormMultiFilterNotEquals(String selectField, String selectPosCode,
			String comparatorField, String comparatorPosCode, String comparatorFilterField,
			String comparatorFilterValue, String comparatorFilterFieldNotEquals, String comparatorFilterValueNotEquals,
			String msgError, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&comparatorFilterField=" + comparatorFilterField);
		builder.append("&comparatorFilterValue=" + comparatorFilterValue);
		builder.append("&comparatorFilterFieldNotEquals=" + comparatorFilterFieldNotEquals);
		builder.append("&comparatorFilterValueNotEquals=" + comparatorFilterValueNotEquals);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&msgError=" + msgError);
		return new ComparisonFormulaFormNotEqualsValidation2(builder.toString());
	}

	public static SegmentValidation genEqualsFormula(String selectField, String selectPosCode, String comparatorPosCode,
			String msgError) {
		return genEqualsFormula(selectField, selectPosCode, comparatorPosCode, msgError, 2);
	}

	public static SegmentValidation genEqualsFormula(String selectField, String selectPosCode, String comparatorPosCode,
			String msgError, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&msgError=" + msgError);
		return new ComparisonFormulaValidation(builder.toString());
	}

	public static SegmentValidation genEqualsFormula(String selectField, String selectPosCode, String comparatorField, 
			String comparatorRow, String msgError, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorRow=" + comparatorRow);
		builder.append("&scale=" + scale);
		builder.append("&msgError=" + msgError);
		return new EqualsFormulaValidation(builder.toString());
	}

	public static SegmentValidation genEqualsFormula3(String selectField, String selectPosCode, String comparatorPosCode,
			String deviation, String total, String msgError) {
		return genEqualsFormula3(selectField, selectPosCode, comparatorPosCode, deviation, total, msgError, 2);
	}

	public static SegmentValidation genEqualsFormula3(String selectField, String selectPosCode, String comparatorPosCode,
			String deviation, String total, String msgError, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&deviation=" + deviation);
		builder.append("&total=" + total);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&msgError=" + msgError);
		return new ComparisonFormulaValidation3(builder.toString());
	}

	public static SegmentValidation genEqualsFormula2(String selectField, String selectPosCode, String leftFormula, String comparatorPosCode,
			String msgError, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&leftFormula=" + leftFormula);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&msgError=" + msgError);
		return new ComparisonFormulaValidation2(builder.toString());
	}

	public static SegmentValidation genUnique(String selectField, String selectPosCode, String uniqueValue,
			String conditionField, String conditionFieldValue) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&uniqueValue=" + uniqueValue);
		builder.append("&conditionField=" + conditionField);
		builder.append("&conditionFieldValue=" + conditionFieldValue);
		return new UniqueValidation(builder.toString());
	}

	public static SegmentValidation genPeriodYear(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new PeriodeYearValidation(builder.toString());
	}

	public static SegmentValidation genMaxValue2(String selectField, String selectPosCode, String posCodeFormula,
			String multiplierFormula, String fixedValue, String errorMessage) {
		return genMaxValue2(selectField, selectPosCode, posCodeFormula, multiplierFormula, fixedValue, errorMessage, 2);
	}

	public static SegmentValidation genMaxValue2(String selectField, String selectPosCode, String posCodeFormula,
			String multiplierFormula, String fixedValue, String errorMessage, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&posCodeFormula=" + posCodeFormula);
		builder.append("&multiplierFormula=" + multiplierFormula);
		builder.append("&fixedValue=" + fixedValue);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		builder.append("&errorMessage=" + errorMessage);
		return new MaxValueValidation2(builder.toString());
	}

	public static SegmentValidation genUniqueValueByRowCode(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new UniqueValueByRowCodeValidation(builder.toString());
	}

	public static SegmentValidation genUniqueRowCode(String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectPosCode=" + selectPosCode);
		return new UniqueRowCodeValidation(builder.toString());
	}

	public static SegmentValidation genSumEqualsValue(String selectField, String selectPosCode, String value) {
		return genSumEqualsValue(selectField, selectPosCode, value, 2);
	}

	public static SegmentValidation genSumEqualsValue(String selectField, String selectPosCode, String value,
			int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&value=" + value);
		builder.append("&scale=" + scale);
		return new SumEqualsValueValidation(builder.toString());
	}

	public static SegmentValidation genHeaderPeriod(String selectField, String selectPosCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		return new HeaderPeriodValidation(builder.toString());
	}

	public static SegmentValidation genEqualsRatioForm(String selectField, String selectPosCode,
			String comparator1RowCode, String comparator2Form, String comparator2RowCode, String message, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparator1RowCode=" + comparator1RowCode);
		builder.append("&comparator2Form=" + comparator2Form);
		builder.append("&comparator2RowCode=" + comparator2RowCode);
		builder.append("&scale=" + scale);
		builder.append("&message=" + message);
		return new EqualsRatioFormValidation(builder.toString());
	}

	public static SegmentValidation genEqualsRatio(String selectField, String selectPosCode,
			String comparator1RowCode, String comparator2RowCode, String message, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparator1RowCode=" + comparator1RowCode);
		builder.append("&comparator2RowCode=" + comparator2RowCode);
		builder.append("&scale=" + scale);
		builder.append("&message=" + message);
		return new EqualsRatioValidation(builder.toString());
	}

	public static SegmentValidation genEqualsPercentageForm(String selectField, String selectPosCode,
			String comparator1Form, String comparator1Field, String comparator1RowCode, String comparator2Form,
			String comparator2Field, String comparator2RowCode, String message, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparator1Form=" + comparator1Form);
		builder.append("&comparator1Field=" + comparator1Field);
		builder.append("&comparator1RowCode=" + comparator1RowCode);
		builder.append("&comparator2Form=" + comparator2Form);
		builder.append("&comparator2Field=" + comparator2Field);
		builder.append("&comparator2RowCode=" + comparator2RowCode);
		builder.append("&scale=" + scale);
		builder.append("&message=" + message);
		return new EqualsPercentageFormValidation(builder.toString());
	}

	public static SegmentValidation genLessEquals(String selectField, String selectPosCode,
			String comparatorRowCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorRowCode=" + comparatorRowCode);
		return new LessEqualsValidation(builder.toString());
	}

	public static SegmentValidation genGreaterEquals(String selectField, String selectPosCode,
			String comparatorRowCode) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparatorRowCode=" + comparatorRowCode);
		return new GreaterEqualsValidation(builder.toString());
	}
	
	public static SegmentValidation genValueDeviation(String selectField, String selectPosCode,
			String value, String deviation) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&value=" + value);
		builder.append("&deviation=" + deviation);
		return new ValueDeviationValidation(builder.toString());
	}
	
	public static SegmentValidation genPendanaanQuality(String selectField, String selectPosCode, String comparatorPosCode,
			String value, String deviation, String conditionPosCode, String conditionValue, String msgError) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&value=" + value);
		builder.append("&comparatorPosCode=" + comparatorPosCode);
		builder.append("&deviation=" + deviation);
		builder.append("&conditionPosCode=" + conditionPosCode);
		builder.append("&conditionValue=" + conditionValue);
		builder.append("&msgError=" + msgError);
		return new PendanaanQualityValidation(builder.toString());
	}
	
	public static SegmentValidation genComparisonFormReferenceValidation(String selectedField, String selectedPosCode, String comparedForm, int comparedField, int comparedReferenceIndex, int comparedReferenceNumber, String comparedReferenceKey, String comparedPosCode) {
		return UtilSegmentValidation.genComparisonFormReferenceValidation(selectedField, selectedPosCode, comparedForm, comparedField, comparedReferenceIndex, comparedReferenceNumber, comparedReferenceKey, comparedPosCode, "");
	}

	public static SegmentValidation genComparisonFormReferenceValidation(String selectedField, String selectedPosCode, String comparedForm, int comparedField, int comparedReferenceIndex, int comparedReferenceNumber, String comparedReferenceKey, String comparedPosCode, String errorMessage) {
		StringBuilder builder = new StringBuilder("selectField=" + selectedField);
		builder.append("&selectPosCode=" + selectedPosCode);
		builder.append("&comparedForm=" + comparedForm);
		builder.append("&comparedReferenceNumber=" + comparedReferenceNumber);
		builder.append("&comparedReferenceIndex=" + comparedReferenceIndex);
		builder.append("&comparedReferenceKey=" + comparedReferenceKey);
		builder.append("&comparedPosCode=" + comparedPosCode);
		builder.append("&comparedField=" + comparedField);
		builder.append("&errorMessage=" + errorMessage);
		return new ComparisonFormReferenceValidation(builder.toString());
	}

	public static SegmentValidation genEqualsPercentage(String selectField, String selectPosCode,
			String comparator1RowCode, String comparator2RowCode, String message, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectField);
		builder.append("&selectPosCode=" + selectPosCode);
		builder.append("&comparator1RowCode=" + comparator1RowCode);
		builder.append("&comparator2RowCode=" + comparator2RowCode);
		builder.append("&scale=" + scale);
		builder.append("&message=" + message);
		return new EqualsToPercentageValidation(builder.toString());
	}
	
	public static SegmentValidation genLookup(String selectedField, String selectedPosCode, String comparatorField, 
			String comparatorRowCode, String lookupKey, String lookupValue, String defaultValue) {
		StringBuilder builder = new StringBuilder("selectField=" + selectedField);
		builder.append("&selectPosCode=" + selectedPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorRowCode=" + comparatorRowCode);
		builder.append("&lookupKey=" + lookupKey);
		builder.append("&lookupValue=" + lookupValue);
		builder.append("&defaultValue=" + defaultValue);
		return new LookupValidation(builder.toString());
	}
	
	public static SegmentValidation genLookupGreaterEquals(String selectedField, String selectedPosCode, String comparatorField, 
			String comparatorRowCode, String lookupKey, String lookupValue, String defaultValue, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectedField);
		builder.append("&selectPosCode=" + selectedPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorRowCode=" + comparatorRowCode);
		builder.append("&lookupKey=" + lookupKey);
		builder.append("&lookupValue=" + lookupValue);
		builder.append("&defaultValue=" + defaultValue);
		builder.append("&scale=" + scale);
		return new LookupGreaterEqualsValidation(builder.toString());
	}
	
	public static SegmentValidation genLookupRasioLikuiditas(String selectedField, String selectedPosCode, String comparatorField, 
			String comparatorRowCode, String lookupKey, String lookupValue, String defaultValue, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectedField);
		builder.append("&selectPosCode=" + selectedPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorRowCode=" + comparatorRowCode);
		builder.append("&lookupKey=" + lookupKey);
		builder.append("&lookupValue=" + lookupValue);
		builder.append("&defaultValue=" + defaultValue);
		builder.append("&scale=" + scale);
		return new LookupRasioLikuiditasValidation(builder.toString());
	}
	
	public static SegmentValidation genLookupGearingRatio(String selectedField, String selectedPosCode, String comparatorField, 
			String comparatorRowCode, String lookupKey, String lookupValue, String defaultValue, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectedField);
		builder.append("&selectPosCode=" + selectedPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorRowCode=" + comparatorRowCode);
		builder.append("&lookupKey=" + lookupKey);
		builder.append("&lookupValue=" + lookupValue);
		builder.append("&defaultValue=" + defaultValue);
		builder.append("&scale=" + scale);
		return new LookupGearingRatioValidation(builder.toString());
	}
	
	public static SegmentValidation genLookupLess(String selectedField, String selectedPosCode, String comparatorField, 
			String comparatorRowCode, String lookupKey, String lookupValue, String defaultValue, int scale) {
		StringBuilder builder = new StringBuilder("selectField=" + selectedField);
		builder.append("&selectPosCode=" + selectedPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorRowCode=" + comparatorRowCode);
		builder.append("&lookupKey=" + lookupKey);
		builder.append("&lookupValue=" + lookupValue);
		builder.append("&defaultValue=" + defaultValue);
		builder.append("&scale=" + scale);
		return new LookupLessValidation(builder.toString());
	}
	
	public static SegmentValidation genIsExistsForm(String column, String rowCode, String comparatorForm, String comparatorColumn) {
		StringBuilder builder = new StringBuilder("column=" + column);
		builder.append("&rowCode=" + rowCode);
		builder.append("&comparatorForm=" + comparatorForm);
		builder.append("&comparatorColumn=" + comparatorColumn);
		return new IsExistsFormValidation(builder.toString());
	}
	
  public static SegmentValidation genIsExistsFormDb(String column, String rowCode, String comparatorForm, String comparatorCode, String comparatorColumn) {
    StringBuilder builder = new StringBuilder("column=" + column);
    builder.append("&rowCode=" + rowCode);
    builder.append("&comparatorForm=" + comparatorForm);
    builder.append("&comparatorCode=" + comparatorCode);
    builder.append("&comparatorColumn=" + comparatorColumn);
    return new IsExistsFormValidationJdbc(builder.toString());
  }
}
