package id.go.ojk.conf.client;

import id.go.ojk.client.model.config.validation.field.*;
import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.db.validation.field.EqualsComparePosFormValidation;
import id.go.ojk.client.db.validation.field.EqualsPosLengthBetweenValidation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UtilFieldValidation {

	public static FieldValidation genEqualsFormula(String fieldFormula) {
		return genEqualsFormula(fieldFormula, 0);
	}

    public static FieldValidation genEqualsExceptPosFormula(String fieldFormula, String exceptPos) {
        return genEqualsExceptPosFormula(fieldFormula, exceptPos,  0);
    }

	public static FieldValidation genEqualsFormula(String fieldFormula, int scale) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&scale=" + scale);
		builder.append("&operator=e");
		return new FormulaValidation(builder.toString());
	}

    public static FieldValidation genEqualsExceptPosFormula(String fieldFormula, String exceptPos, int scale) {
        StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
        builder.append("&scale=" + scale);
        builder.append("&exceptPos=" + exceptPos);
        builder.append("&operator=e");
        return new FormulaExceptPosValidation(builder.toString());
    }

	public static FieldValidation genEqualsPercentageExceptPosFormula(String fieldFormula, String exceptPos) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&scale=" + 2);
		builder.append("&exceptPos=" + exceptPos);
		builder.append("&operator=e");
		return new PercentageEqualExceptPosValidation(builder.toString());
	}

  public static FieldValidation genEqualsFormula2(String fieldFormula, String msgError) {
    return genEqualsFormula2(fieldFormula, 0, msgError);
  }

  public static FieldValidation genEqualsFormula2(String fieldFormula, int scale, String msgError) {
    StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
    builder.append("&scale=" + scale);
    builder.append("&operator=e");
    builder.append("&msgError=" + msgError);
    return new FormulaValidation2(builder.toString());
  }

	public static FieldValidation genEqualsMaxValue(String fieldFormula, String comparatorFixValue) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&comparatorFixValue=" + comparatorFixValue);
		builder.append("&operator=e");
		return new MaxValueValidation(builder.toString());
	}

	public static FieldValidation genEqualsPosMaxValue(String fieldFormula, String comparatorFixValue, String refPosCode) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&comparatorFixValue=" + comparatorFixValue);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&operator=e");
		return new MaxValuePosValidation(builder.toString());
	}

	public static FieldValidation genEqualsPosFormula(String fieldFormula, int scale, String refPosCode) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&scale=" + scale);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&operator=e");
		return new FormulaPosValidation(builder.toString());
	}

	public static FieldValidation genEqualsPosFormula3(String fieldFormula, int scale, String refPosCode) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&scale=" + scale);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&operator=e");
		return new FormulaPosValidation3(builder.toString());
	}

	public static FieldValidation genEqualsPosFormula(String fieldFormula, String refPosCode) {
		return genEqualsPosFormula(fieldFormula, 0, refPosCode);
	}

  public static FieldValidation genEqualsPosFormula2(String fieldFormula, int scale, String refPosCode, String msgError) {
    StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
    builder.append("&scale=" + scale);
    builder.append("&refPosCode=" + refPosCode);
    builder.append("&msgError=" + msgError);
    builder.append("&operator=e");
    return new FormulaPosValidation2(builder.toString());
  }

	public static FieldValidation genEqualsPosFormulaFixedValue(String fieldFormula, String fixedValue, String refPosCode, int scale) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&fixedValue=" + fixedValue);
		builder.append("&scale=" + scale);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&operator=e");
		return new FormulaFixedRatioPosValidation(builder.toString());
	}

  public static FieldValidation genEqualsPosFormula2(String fieldFormula, String refPosCode, String msgError) {
    return genEqualsPosFormula2(fieldFormula, 0, refPosCode, msgError);
  }

	public static FieldValidation genEqualsPosFormulaFixedValue(String fieldFormula, String refPosCode, String fixedValue) {
		return genEqualsPosFormulaFixedValue(fieldFormula, fixedValue, refPosCode,2);
	}

	/**
	 * @deprecated
	 * Use {@link UtilFieldValidation#genEqualsPosByConst}
	 */
	@Deprecated
	public static FieldValidation genEqualsPosMultiplyConst(String fieldFormula, int scale, String refPosCode,
			String constValue) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&scale=" + scale);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&constValue=" + constValue);
		builder.append("&operator=e");
		return new FormulaPosValidationMultiplyConst(builder.toString());
	}

  public static FieldValidation genEqualsPosByConst(String fieldFormula, int scale, String refPosCode,
      String constValue, String constOper) {
    StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
    builder.append("&scale=" + scale);
    builder.append("&refPosCode=" + refPosCode);
    builder.append("&constValue=" + constValue);
    builder.append("&constOper=" + constOper);
    builder.append("&operator=e");
    return new FormulaPosValidationByConst(builder.toString());
  }

	public static FieldValidation genEqualsRatio(String fieldFormula) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&operator=e");
		return new RatioValidation(builder.toString());
	}
	
  public static FieldValidation genEqualsRatio(String fieldFormula, int scale) {
    StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
    builder.append("&operator=e");
    builder.append("&scale=" + scale);
    return new RatioValidation(builder.toString());
  }

	public static FieldValidation genEqualsPosRatio(String fieldFormula, String refPosCode) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&operator=e");
		return new RatioPosValidation(builder.toString());
	}

	public static FieldValidation genEqualsPosRatio(String fieldFormula, String refPosCode, int scale) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		return new RatioPosValidation(builder.toString());
	}

	public static FieldValidation genPercentage(String fieldFormula) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&scale=2");
		builder.append("&operator=e");
		return new PercentageValidation(builder.toString());
	}

	public static FieldValidation genPercentage(String fieldFormula, int scale) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&scale=" + scale);
		builder.append("&operator=e");
		return new PercentageValidation(builder.toString());
	}

	public static FieldValidation genPosPercentage(String fieldFormula, String refPosCode) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&operator=e");
		builder.append("&scale=0");
		return new PercentagePosValidation(builder.toString());
	}

	public static FieldValidation genPosPercentage(String fieldFormula, String refPosCode, int scale) {
		StringBuilder builder = new StringBuilder("comparatorFormula=" + fieldFormula);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&operator=e");
		builder.append("&scale=" + scale);
		return new PercentagePosValidation(builder.toString());
	}

	@Deprecated
	public static FieldValidation genUnique(String field) {
		return StringUtils.isNotEmpty(field) ? new UniqueChecker("selectPosCode=" + field) : new UniqueChecker();
	}

	public static FieldValidation genDuplicateWithConditionValidation(String fieldCondition,
			String trueConditionValue, String selectPosCode) {
		StringBuilder builder = new StringBuilder("fieldCondition=" + fieldCondition);
		builder.append("&trueConditionValue=" + trueConditionValue);
		builder.append("&selectPosCode=" + selectPosCode);
		return new DuplicateWithConditionValidation(builder.toString());
	}

	public static FieldValidation genIfEqualThen(String fieldCondition, String trueConditionValue,
			String trueValue) {
		StringBuilder builder = new StringBuilder("fieldCondition=" + fieldCondition);
		builder.append("&trueConditionValue=" + trueConditionValue);
		builder.append("&trueValue=" + trueValue);
		return new IfEqualThenValidation(builder.toString());
	}

	public static FieldValidation genIfNotEqualThen(String fieldCondition, String trueConditionValue,
			String trueValue) {
		StringBuilder builder = new StringBuilder("fieldCondition=" + fieldCondition);
		builder.append("&trueConditionValue=" + trueConditionValue);
		builder.append("&trueValue=" + trueValue);
		return new IfNotEqualThenValidation(builder.toString());
	}

	public static FieldValidation genPosIfEqualThen(String fieldCondition, String trueConditionValue,
			String trueValue, String rowCode) {
		StringBuilder builder = new StringBuilder("fieldCondition=" + fieldCondition);
		builder.append("&trueConditionValue=" + trueConditionValue);
		builder.append("&trueValue=" + trueValue);
		builder.append("&rowCode=" + rowCode);
		return new IfEqualThenPosValidation(builder.toString());
	}

	public static FieldValidation genIfComparatorEquals(String fieldComparator, String comparatorValue, String trueValue) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		builder.append("&comparatorValue=" + comparatorValue);
		builder.append("&trueValue=" + trueValue);
		return new IfComparatorEqualsValidation(builder.toString());
	}

	public static FieldValidation genIfComparatorEquals2(String fieldComparator, String comparatorValue, String trueValue) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		builder.append("&comparatorValue=" + comparatorValue);
		builder.append("&trueValue=" + trueValue);
		return new IfComparatorEqualsValidation2(builder.toString());
	}

	public static FieldValidation genLookup(String keyField, String lookup) {
		StringBuilder builder = new StringBuilder("keyField=" + keyField);
		builder.append("&lookup=" + lookup);
		return new LookupConditionValidation(builder.toString());
	}

	public static FieldValidation genPosLookup(String keyField, String refPosCode, String lookup) {
		StringBuilder builder = new StringBuilder("keyField=" + keyField);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&lookup=" + lookup);
		return new LookupConditionPosValidation(builder.toString());
	}

	public static FieldValidation genPosLookup(String keyField, String refPosCode, String lookup, String defaultValue) {
		StringBuilder builder = new StringBuilder("keyField=" + keyField);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&lookup=" + lookup);
		builder.append("&defaultValue=" + defaultValue);
		return new LookupConditionPosValidation(builder.toString());
	}

	public static FieldValidation genUniqueToOther(String checkField) {
		StringBuilder builder = new StringBuilder("checkField=" + checkField);
		return new UniqueToOtherFieldValidation(builder.toString());
	}

	public static FieldValidation genReferenceCondition(String fieldComparator, String referenceNumber) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		builder.append("&referenceNumber=" + referenceNumber);
		return new ReferenceConditionValidation(builder.toString());
	}

	public static FieldValidation genReferenceConditionPos(String fieldComparator, String referenceNumber, String refPosCode) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		builder.append("&referenceNumber=" + referenceNumber);
		builder.append("&refPosCode=" + refPosCode);
		return new ReferenceConditionPosValidation(builder.toString());
	}

	public static FieldValidation genReferenceCondition2(String fieldComparator, String valueComparator, 
			String referenceNumber) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		builder.append("&valueComparator=" + valueComparator);
		builder.append("&referenceNumber=" + referenceNumber);
		return new ReferenceConditionValidation2(builder.toString());
	}

	public static FieldValidation genPosReferenceCondition3(String refPosCode, String fieldParent, 
			String referenceNumber) {
		StringBuilder builder = new StringBuilder("refPosCode=" + refPosCode);
		builder.append("&fieldParent=" + fieldParent);
		builder.append("&referenceNumber=" + referenceNumber);
		return new ReferenceConditionPosValidation3(builder.toString());
	}

	public static FieldValidation genReferenceCondition4(String fieldComparator, String referenceNumber, String defaultValue) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		builder.append("&referenceNumber=" + referenceNumber);
		builder.append("&defaultValue=" + defaultValue);
		return new ReferenceConditionValidation4(builder.toString());
	}

	public static FieldValidation genEquals(String fieldComparator) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		return new EqualsValidation(builder.toString());
	}

	public static FieldValidation genEqualsJenisProgram(String selectPosCode) {
        return new EqualsJenisProgramValidation("selectPosCode=" + selectPosCode);
	}

	public static FieldValidation genGreaterValue(String valueComparator) {
		StringBuilder builder = new StringBuilder("valueComparator=" + valueComparator);
		return new GreaterValueValidation(builder.toString());
	}

	public static FieldValidation genPosGreaterValue(String refPosCode, String valueComparator) {
		StringBuilder builder = new StringBuilder("refPosCode=" + refPosCode);
		builder.append("&valueComparator=" + valueComparator);
		return new GreaterValuePosValidation(builder.toString());
	}

	public static FieldValidation genLessEquals(String fieldComparator) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		return new LessEqualsValidation(builder.toString());
	}

	public static FieldValidation genDateGreaterEquals(String fieldComparator) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		return new DateGreaterEqualsValidation(builder.toString());
	}

	public static FieldValidation genDateLessEquals(String fieldComparator) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		return new DateLessEqualsValidation(builder.toString());
	}

	public static FieldValidation genDateLess(String fieldComparator) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		return new DateLessValidation(builder.toString());
	}

	public static FieldValidation genDateLessPos(String fieldComparator, String refPosCode) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		builder.append("&refPosCode=" + refPosCode);
		return new DateLessValidation(builder.toString());
	}

	public static FieldValidation genDateGreater(String fieldComparator) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		return new DateGreaterValidation(builder.toString());
	}

	public static FieldValidation genDateGreaterPos(String fieldComparator, String refPosCode) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		builder.append("&refPosCode=" + refPosCode);
		return new DateGreaterValidation(builder.toString());
	}

	public static FieldValidation genEqualsFixedValue(String value) {
		StringBuilder builder = new StringBuilder("value=" + value);
		return new EqualsFixedValueValidation(builder.toString());
	}

	public static FieldValidation genNotEqualsFixedValue(String value) {
		StringBuilder builder = new StringBuilder("value=" + value);
		return new NotEqualsFixedValueValidation(builder.toString());
	}

	public static FieldValidation genNotEqualsPosFixedValue(String value, String posCode) {
		StringBuilder builder = new StringBuilder("value=" + value);
		builder.append("&posCode=" + posCode);
		return new NotEqualsPosFixedValueValidation(builder.toString());
	}

	public static FieldValidation genEqualsFixedValueOptional(String value) {
		StringBuilder builder = new StringBuilder("value=" + value);
		return new EqualsFixedValueOptionalValidation(builder.toString());
	}

	public static FieldValidation genPosEqualsFixedValue(String value, String refPosCode) {
		StringBuilder builder = new StringBuilder("value=" + value);
		builder.append("&refPosCode=" + refPosCode);
		return new EqualsFixedValuePosValidation(builder.toString());
	}

	public static FieldValidation genPosEquals(String fieldComparator, String posCode) {
		StringBuilder builder = new StringBuilder("fieldComparator=" + fieldComparator);
		builder.append("&posCode=" + posCode);
		return new EqualsPosValidation(builder.toString());
	}
	
	public static FieldValidation genMaxLength2(String fieldComparator1, String valueComparator1, 
			String fieldComparator2, String valueComparator2, String maxLength) {
		StringBuilder builder = new StringBuilder("fieldComparator1=" + fieldComparator1);
		builder.append("&valueComparator1=" + valueComparator1);
		builder.append("&fieldComparator2=" + fieldComparator2);
		builder.append("&valueComparator2=" + valueComparator2);
		builder.append("&maxLength=" + maxLength);
		return new MaxLengthValidation2(builder.toString());
	}

	public static FieldValidation genBetween(String minValue, String maxValue) {
		StringBuilder builder = new StringBuilder("minValue=" + minValue);
		builder.append("&maxValue=" + maxValue);
		return new BetweenValidation(builder.toString());
	}

	public static FieldValidation genEqualsDivisionForm(String selectedIndex, String selectedResultIndex, String comparedForm, String comparedCode, String comparedIndex, String errorMessage) {
		StringBuilder builder = new StringBuilder("selectedIndex=").append(selectedIndex)
				.append("&comparedForm=").append(comparedForm)
				.append("&comparedCode=").append(comparedCode)
				.append("&comparedIndex=").append(comparedIndex)
				.append("&selectedResultIndex=").append(selectedResultIndex)
				.append("&errorMessage=").append(errorMessage);
		return new EqualsDivisionValidationForm(builder.toString());
	}

	public static FieldValidation genDate(String dateFormat) {
		StringBuilder builder = new StringBuilder("dateFormat=" + dateFormat);
		return new DateValidation(builder.toString());
	}

	public static FieldValidation genEqualsPosLengthBetween(String selectPosCode, String fieldComparator, String comparatorValue, String minLength, String maxLength) {
	  StringBuilder sb = new StringBuilder()
	      .append("selectPosCode=").append(selectPosCode)
	      .append("&fieldComparator=").append(fieldComparator)
	      .append("&comparatorValue=").append(comparatorValue)
	      .append("&minLength=").append(minLength)
	      .append("&maxLength=").append(maxLength)
    ;
    return new EqualsPosLengthBetweenValidation(sb.toString());
	}

  public static FieldValidation genEqualsComparePosForm(String selectPosCode, String selectField, String comparatorForm, String fieldComparator1, String fieldComparator2) {
    StringBuilder sb = new StringBuilder()
        .append("selectPosCode=").append(selectPosCode)
        .append("&selectField=").append(selectField)
        .append("&comparatorForm=").append(comparatorForm)
        .append("&fieldComparator=").append(fieldComparator1)
        .append("&fieldComparator2=").append(fieldComparator2)
    ;
    return new EqualsComparePosFormValidation(sb.toString());
  }

  public static FieldValidation getEqualsDati2And1(String selectPosCode, int fieldDati1, int referenceNumberDati1, int referenceNumberDati2) {
    StringBuilder sb = new StringBuilder()
      .append("selectPosCode=").append(selectPosCode)
      .append("&fieldDati1=").append(fieldDati1)
      .append("&referenceNumberDati1=").append(referenceNumberDati1)
      .append("&referenceNumberDati2=").append(referenceNumberDati2)
    ;
    return new EqualsDati1And2Validation(sb.toString());
  }
}
