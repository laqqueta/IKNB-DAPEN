package id.go.ojk.conf.client;

import id.go.ojk.client.model.config.validation.conditional.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UtilFieldConditional {

	public static ConditionalRequired genAllExist(String trueCondition, String falseCondition, String fieldNumber) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&fieldNumber=" + fieldNumber);
		return new AllExistConditional(builder.toString());
	}

	public static ConditionalRequired genAllExistPos(String trueCondition, String falseCondition, String fieldNumber,
			String selectPosCode) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&fieldNumber=" + fieldNumber);
		builder.append("&selectPosCode=" + selectPosCode);
		return new AllExistPosConditional(builder.toString());
	}

  public static ConditionalRequired genAllExistPosAndInReference(String trueCondition, String falseCondition,
      String fieldNumber, String selectPosCode, int referenceNumber) {
    return genAllExistPosAndInReference(trueCondition, falseCondition, fieldNumber, selectPosCode, referenceNumber,
        "O");
  }

  public static ConditionalRequired genAllExistPosAndInReference(String trueCondition, String falseCondition,
      String fieldNumber, String selectPosCode, int referenceNumber, String referenceFalseCondition) {
    StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
    builder.append("&falseCondition=" + falseCondition);
    builder.append("&fieldNumber=" + fieldNumber);
    builder.append("&selectPosCode=" + selectPosCode);
    builder.append("&referenceNumber=" + referenceNumber);
    builder.append("&referenceFalseCondition=" + referenceFalseCondition);
    return new AllExistPosConditionalAndInReference(builder.toString());
  }

	public static ConditionalRequired genExistPos(String trueCondition, String falseCondition, String refPosCode) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&refPosCode=" + refPosCode);
		return new ExistPosConditional(builder.toString());
	}

  public static ConditionalRequired genExistPosAndHasReference(String trueCondition, String falseCondition,
      String refPosCode, int referenceNumber, String referenceFalseCondition) {
    StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
    builder.append("&falseCondition=" + falseCondition);
    builder.append("&refPosCode=" + refPosCode);
    builder.append("&referenceNumber=" + referenceNumber);
    builder.append("&referenceFalseCondition=" + referenceFalseCondition);
    return new ExistPosAndInReferenceConditional(builder.toString());
  }

	public static ConditionalRequired genRow(String condition1, String posCode1, String condition2, String posCode2,
			String defaultCondition) {
		StringBuilder builder = new StringBuilder("condition1=" + condition1);
		builder.append("&posCode1=" + posCode1);
		builder.append("&condition2=" + condition2);
		builder.append("&posCode2=" + posCode2);
		builder.append("&defaultCondition=" + defaultCondition);
		return new RowCondition(builder.toString());
	}

	public static ConditionalRequired genExistPosOrComparatorNotEmpty(String defaultCondition, String existPosCondition,
			String comparatorCondition, String refPosCode, String comparatorFieldNumber) {
		StringBuilder builder = new StringBuilder("defaultCondition=" + defaultCondition);
		builder.append("&existPosCondition=" + existPosCondition);
		builder.append("&comparatorCondition=" + comparatorCondition);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&comparatorFieldNumber=" + comparatorFieldNumber);
		return new ExistPosOrComparatorNotEmptyConditional(builder.toString());
	}

	public static ConditionalRequired genExistPosAndComparatorNotEmpty(String trueCondition, String falseCondition, 
			String refPosCode, String comparatorFieldNumber) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&comparatorFieldNumber=" + comparatorFieldNumber);
		return new ExistPosAndComparatorNotEmptyConditional(builder.toString());
	}

    public static ConditionalRequired genExistPosAndComparatorNotEmptyExcept(String trueCondition, String falseCondition,
                                                                       String refPosCode, String comparatorFieldNumber, String exceptPos, String exceptPosCondition) {
        StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
        builder.append("&falseCondition=" + falseCondition);
        builder.append("&refPosCode=" + refPosCode);
        builder.append("&comparatorFieldNumber=" + comparatorFieldNumber);
        builder.append("&exceptPos=" + exceptPos);
        builder.append("&exceptPosCondition=" + exceptPosCondition);
        return new ExistPosAndComparatorNotEmptyExceptConditional(builder.toString());
    }

	public static ConditionalRequired genExistPosAndComparatorNotEmpty(String trueCondition, String falseCondition, String posFalseCondition, 
			String refPosCode, String comparatorFieldNumber) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&posFalseCondition=" + posFalseCondition);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&comparatorFieldNumber=" + comparatorFieldNumber);
		return new ExistPosAndComparatorNotEmptyConditional(builder.toString());
	}

	public static ConditionalRequired genExistPosAndComparatorNotEmptyDAPENVer(String trueCondition, String falseCondition, String posFalseCondition,
	                                                                   String refPosCode, String comparatorFieldNumber) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&posFalseCondition=" + posFalseCondition);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&comparatorFieldNumber=" + comparatorFieldNumber);
		return new ExistPosAndComparatorNotEmptyConditional2(builder.toString());
	}

	public static ConditionalRequired genExistPosAndComparatorHasValue(String trueCondition, String falseCondition, String posFalseCondition,
			String refPosCode, String comparatorField, String comparatorValue) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&posFalseCondition=" + posFalseCondition);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorValue=" + comparatorValue);
		return new ConditionalPosAndComparatorHasValue(builder.toString());
	}

	public static ConditionalRequired genExistPosAndComparatorHasValue2(String trueCondition, String falseCondition, String posFalseCondition,
	                                                                   String refPosCode, String comparatorField, String comparatorValue) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&posFalseCondition=" + posFalseCondition);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorValue=" + comparatorValue);
		return new ConditionalPosAndComparatorHasValue3(builder.toString());
	}

	public static ConditionalRequired genExistPosAndComparatorHasValue2(String trueCondition, String falseCondition, String posFalseCondition,
	                                                                    String refPosCode, String comparatorField, String comparatorValue, String comparatorTrueValue) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&posFalseCondition=" + posFalseCondition);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorValue=" + comparatorValue);
		builder.append("&comparatorTrueValue=" + comparatorTrueValue);
		return new ConditionalPosAndComparatorHasValue3(builder.toString());
	}

	public static ConditionalRequired genExistPosAndComparatorHasValueDapenVer(String trueCondition, String falseCondition, String posFalseCondition,
	                                                                   String refPosCode, String comparatorField, String comparatorValue) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&posFalseCondition=" + posFalseCondition);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorValue=" + comparatorValue);
		return new ConditionalPosAndComparatorHasValueSbn(builder.toString());
	}

	public static ConditionalRequired genExistPosAndComparatorHasValue(String trueCondition, String trueCondition2, String falseCondition, String posFalseCondition,
			String refPosCode, String comparatorField, String comparatorValue, String comparatorValue2) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&trueCondition2=" + trueCondition2);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&posFalseCondition=" + posFalseCondition);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorValue=" + comparatorValue);
		builder.append("&comparatorValue2=" + comparatorValue2);
		return new ConditionalPosAndComparatorHasValue(builder.toString());
	}

	public static ConditionalRequired genExistPosAndComparatorHasValue2(String trueCondition, String falseCondition, String posFalseCondition,
      String refPosCode, int referenceNumber, String comparatorField, String comparatorValue) {
    StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
    builder.append("&falseCondition=" + falseCondition);
    builder.append("&posFalseCondition=" + posFalseCondition);
    builder.append("&refPosCode=" + refPosCode);
    builder.append("&referenceNumber=" + referenceNumber);
    builder.append("&comparatorField=" + comparatorField);
    builder.append("&comparatorValue=" + comparatorValue);
    return new ConditionalPosAndComparatorHasValue2(builder.toString());
  }

	public static ConditionalRequired genExistPosOrComparatorHasValue(String defaultCondition, String existPosCondition,
			String comparatorCondition, String refPosCode, String comparatorFieldNumber, String comparatorFixedValue) {
		StringBuilder builder = new StringBuilder("defaultCondition=" + defaultCondition);
		builder.append("&existPosCondition=" + existPosCondition);
		builder.append("&comparatorCondition=" + comparatorCondition);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&comparatorFieldNumber=" + comparatorFieldNumber);
		builder.append("&comparatorFixedValue=" + comparatorFixedValue);
		return new ExistPosOrComparatorHasValueConditional(builder.toString());
	}

	public static ConditionalRequired genIzinOjkConditional(String defaultCondition, String existPosCondition,
			String comparatorCondition, String refPosCode, String comparatorField1, String comparatorFixedValue1,
			String comparatorField2, String comparatorFixedValue2, String comparatorField3,
			String comparatorFixedValue3, String errorMsg) {
		StringBuilder builder = new StringBuilder("defaultCondition=" + defaultCondition);
		builder.append("&existPosCondition=" + existPosCondition);
		builder.append("&comparatorCondition=" + comparatorCondition);
		builder.append("&refPosCode=" + refPosCode);
		builder.append("&comparatorField1=" + comparatorField1);
		builder.append("&comparatorFixedValue1=" + comparatorFixedValue1);
		builder.append("&comparatorField2=" + comparatorField2);
		builder.append("&comparatorFixedValue2=" + comparatorFixedValue2);
		builder.append("&comparatorField3=" + comparatorField3);
		builder.append("&comparatorFixedValue3=" + comparatorFixedValue3);
		builder.append("&errorMsg=" + errorMsg);
		return new IzinOjkConditional(builder.toString());
	}

	public static ConditionalRequired genNumericComparisonPos(String trueCondition, String falseCondition,
			String comparatorField, String comparatorValue, String comparation, String selectPosCode) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorValue=" + comparatorValue);
		builder.append("&comparation=" + comparation);
		builder.append("&selectPosCode=" + selectPosCode);
		return new NumericComparisonPosConditional(builder.toString());
	}

    public static ConditionalRequired genMustEmpty(String trueCondition, String falseCondition,
                                                            String selectField, String selectPosCode) {
        StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
        builder.append("&falseCondition=" + falseCondition);
        builder.append("&selectField=" + selectField);
        builder.append("&selectPosCode=" + selectPosCode);
        return new EmptyPosFieldValidation(builder.toString());
    }


	public static ConditionalRequired genComparatorHasValue(String trueCondition, String falseCondition,
			String emptyCondition, String comparatorField, String comparatorValue) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&emptyCondition=" + emptyCondition);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorValue=" + comparatorValue);
		return new ComparatorHasValueConditional(builder.toString());
	}

	public static ConditionalRequired genComparatorHasValue(String trueCondition, String falseCondition,
			String comparatorField, String comparatorValue) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&emptyCondition=N");
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorValue=" + comparatorValue);
		return new ComparatorHasValueConditional(builder.toString());
	}

	public static ConditionalRequired genEquals(String trueCondition, String falseCondition, String comparatorField,
			String comparatorValue) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorValue=" + comparatorValue);
		return new ConditionEquals(builder.toString());
	}

	public static ConditionalRequired genEqualsExceptPos(String trueCondition, String falseCondition, String comparatorField,
												String comparatorValue, String exceptPos) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorValue=" + comparatorValue);
		builder.append("&exceptPos=" + exceptPos);
		return new ConditionEqualsExceptPost(builder.toString());
	}

	public static ConditionalRequired genNotBetween(String trueCondition, String falseCondition, String comparatorField,
			int comparatorLowValue, int comparatorHighValue) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorLowValue=" + comparatorLowValue);
		builder.append("&comparatorHighValue=" + comparatorHighValue);
		return new NotBetweenCondition(builder.toString());
	}

	public static ConditionalRequired genNotBetweenPos(String trueCondition, String falseCondition,
			String comparatorField, int comparatorLowValue, int comparatorHighValue, String rowCode) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorLowValue=" + comparatorLowValue);
		builder.append("&comparatorHighValue=" + comparatorHighValue);
		builder.append("&rowCode=" + rowCode);
		return new NotBetweenPosCondition(builder.toString());
	}

	public static ConditionalRequired genLessThan(String trueCondition, String falseCondition, String comparatorField,
			int comparatorValue) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorValue=" + comparatorValue);
		return new LessThanCondition(builder.toString());
	}

	public static ConditionalRequired genLessThanPos(String trueCondition, String falseCondition,
			String comparatorField, int comparatorValue, String rowCode) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&comparatorValue=" + comparatorValue);
		builder.append("&rowCode=" + rowCode);
		return new LessThanPosCondition(builder.toString());
	}

	public static ConditionalRequired genValueCheckPos(String trueCondition, String falseCondition,
			String comparatorField, String notBetweenRowCode, int notBetweenLowValue, int notBetweenHighValue,
			String lessThanRowCode1, int lessThanValue1, String lessThanRowCode2, int lessThanValue2,
			String mustEmptyRowCode) {
		StringBuilder builder = new StringBuilder("trueCondition=" + trueCondition);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&comparatorField=" + comparatorField);
		builder.append("&notBetweenRowCode=" + notBetweenRowCode);
		builder.append("&notBetweenLowValue=" + notBetweenLowValue);
		builder.append("&notBetweenHighValue=" + notBetweenHighValue);
		builder.append("&lessThanRowCode1=" + lessThanRowCode1);
		builder.append("&lessThanValue1=" + lessThanValue1);
		builder.append("&lessThanRowCode2=" + lessThanRowCode2);
		builder.append("&lessThanValue2=" + lessThanValue2);
		builder.append("&mustEmptyRowCode=" + mustEmptyRowCode);
		return new ValueCheckPosCondition(builder.toString());
	}

	public static ConditionalRequired genFintech(String defaultCondition, String selectPosCode1,
			String conditionPosCode1, String selectPosCode2, String comparatorPosCode2, String valueComparatorPosCode2,
			String trueConditionPosCode2, String falseConditionPosCode2) {
		StringBuilder builder = new StringBuilder("defaultCondition=" + defaultCondition);
		builder.append("&selectPosCode1=" + selectPosCode1);
		builder.append("&conditionPosCode1=" + conditionPosCode1);
		builder.append("&selectPosCode2=" + selectPosCode2);
		builder.append("&comparatorPosCode2=" + comparatorPosCode2);
		builder.append("&valueComparatorPosCode2=" + valueComparatorPosCode2);
		builder.append("&trueConditionPosCode2=" + trueConditionPosCode2);
		builder.append("&falseConditionPosCode2=" + falseConditionPosCode2);
		return new FintechCondition(builder.toString());
	}

	public static ConditionalRequired genHasValue(String fieldComparator, String falseCondition, String trueCondition) {
		StringBuilder builder = new StringBuilder("comparatorField=" + fieldComparator);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&trueCondition=" + trueCondition);
		return new HasValueConditional(builder.toString());
	}

	public static ConditionalRequired genHasValueExceptPos(String fieldComparator, String falseCondition, String trueCondition, String exceptPos) {
		StringBuilder builder = new StringBuilder("comparatorField=" + fieldComparator);
		builder.append("&falseCondition=" + falseCondition);
		builder.append("&trueCondition=" + trueCondition);
		builder.append("&exceptPos=" + exceptPos);
		return new HasValueConditional(builder.toString());
	}
}
