package id.go.ojk.client.model.config.validation.conditional;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

/**
 * If All "fieldNumbers" not empty will produce "trueCondition" otherwise
 * "falseCondition"
 *
 */
@XStreamAlias("IzinOjkConditional")
public class IzinOjkConditional extends MapParamConditionalRequired {
	private RequiredCondition defaultCondition;
	private RequiredCondition existPosCondition;
	private RequiredCondition comparatorCondition;
	private String refPosCode;
	private String comparatorField1;
	private String comparatorFixedValue1;
	private String comparatorField2;
	private String comparatorFixedValue2;
	private String comparatorField3;
	private String comparatorFixedValue3;
	private String errorMsg;
	
	public IzinOjkConditional() {
	}

	public IzinOjkConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public IzinOjkConditional initialized() {
		defaultCondition = getRequiredConditionParameter("defaultCondition");
		existPosCondition = getRequiredConditionParameter("existPosCondition");
		comparatorCondition = getRequiredConditionParameter("comparatorCondition");
		refPosCode = getStringParameter("refPosCode");
		comparatorField1 = getStringParameter("comparatorField1");
		comparatorFixedValue1 = getStringParameter("comparatorFixedValue1");
		comparatorField2 = getStringParameter("comparatorField2");
		comparatorFixedValue2 = getStringParameter("comparatorFixedValue2");
		comparatorField3 = getStringParameter("comparatorField3");
		comparatorFixedValue3 = getStringParameter("comparatorFixedValue3");
		errorMsg = getStringParameter("errorMsg");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		RequiredCondition result = defaultCondition;
		String posCode = validationResult.getColumn(1);
		String message = "";
		if (StringUtils.isNotEmpty(posCode) && refPosCode.contains(posCode)) {
			result = existPosCondition;
			message = StringUtils.isNotEmpty(posCode) ? ("kode baris " + posCode) : "";
		} else {
			String[] arrComparatorField1 = StringUtils.split(comparatorField1, "|");
			String[] arrComparatorField2 = StringUtils.split(comparatorField2, "|");
			String[] arrComparatorField3 = StringUtils.split(comparatorField3, "|");
			if (((checkComparator(arrComparatorField1, comparatorFixedValue1, validationResult) &&
					checkComparator2(arrComparatorField2, comparatorFixedValue2, validationResult)) ||
					checkComparator(arrComparatorField3, comparatorFixedValue3, validationResult))) {
				result = comparatorCondition;
				message = errorMsg;
			} else if (!comparatorIsAllEmpty(arrComparatorField1, validationResult) && 
					!comparatorIsAllEmpty(arrComparatorField2, validationResult) && 
					!comparatorIsAllEmpty(arrComparatorField3, validationResult)) {
				result = RequiredCondition.O;
			}
		}
		if (result.equals(RequiredCondition.N) && StringUtils.isNotEmpty(message)) {
			message = "jika " + message;
		}
		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}
	
	private boolean checkComparator(String[] arrComparatorField, String comparatorFixedValue, ValidationResult validationResult) {
		boolean res = true;
		if (arrComparatorField != null) {
			String[] arrExpectedValues = StringUtils.split(comparatorFixedValue, "|");
			for (int i = 0; i < arrComparatorField.length; i++) {
				String realValue = validationResult.getColumn(Integer.parseInt(arrComparatorField[i]));
				res = res && arrExpectedValues[i].equals(realValue);
			}
		}
		return res;
	}
	
	private boolean checkComparator2(String[] arrComparatorField, String comparatorFixedValue, ValidationResult validationResult) {
		boolean res = true;
		if (arrComparatorField != null) {
			String[] arrExpectedValues = StringUtils.split(comparatorFixedValue, "|");
			for (int i = 0; i < arrComparatorField.length; i++) {
				BigDecimal realValue = UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(arrComparatorField[i])), "0");
				BigDecimal expectedValue = UtilValidation.toBigDecimal(arrExpectedValues[i], "0");
				res = res && (realValue.compareTo(expectedValue) == 1);
			}
		}
		return res;
	}
	
	private boolean comparatorIsAllEmpty(String[] arrComparatorField, ValidationResult validationResult) {
		boolean res = true;
		if (arrComparatorField != null) {
			for (int i = 0; i < arrComparatorField.length; i++) {
				String realValue = validationResult.getColumn(Integer.parseInt(arrComparatorField[i]));
				if (StringUtils.isNotEmpty(realValue)) {
					res = false;
					break;
				}
			}
		}
		return res;
	}
}
