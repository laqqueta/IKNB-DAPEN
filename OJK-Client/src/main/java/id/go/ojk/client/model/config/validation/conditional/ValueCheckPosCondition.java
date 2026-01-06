package id.go.ojk.client.model.config.validation.conditional;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;
import org.apache.commons.net.util.ToStringList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

@XStreamAlias("BetweenCondition")
public class ValueCheckPosCondition extends BaseFieldCondition {
	private int comparatorField;
	private String notBetweenRowCode;
	private BigDecimal notBetweenLowValue;
	private BigDecimal notBetweenHighValue;
	private String lessThanRowCode1;
	private BigDecimal lessThanValue1;
	private String lessThanRowCode2;
	private BigDecimal lessThanValue2;
	private String mustEmptyRowCode;

	public ValueCheckPosCondition() {
	}

	public ValueCheckPosCondition(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ValueCheckPosCondition initialized() {
		super.initialized();
		this.comparatorField = getIntParameter("comparatorField");
		this.notBetweenRowCode = getStringParameter("notBetweenRowCode");
		this.notBetweenLowValue = getAsBigDecimal("notBetweenLowValue");
		this.notBetweenHighValue = getAsBigDecimal("notBetweenHighValue");
		this.lessThanRowCode1 = getStringParameter("lessThanRowCode1");
		this.lessThanValue1 = getAsBigDecimal("lessThanValue1");
		this.lessThanRowCode2 = getStringParameter("lessThanRowCode2");
		this.lessThanValue2 = getAsBigDecimal("lessThanValue2");
		this.mustEmptyRowCode = getStringParameter("mustEmptyRowCode");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		RequiredCondition result = falseCondition;
		String rowValue = validationResult.getColumn(comparatorField);
		String rowCode = validationResult.getColumn(1);
		String message = "";
		if (isNotBetween(rowCode)) {
			result = notBetweenCondition(rowValue);
			message = notBetweenMessage(rowValue);
		} else if (isLessThan(rowCode, lessThanRowCode1)) {
			result = lessThanCondition(rowValue, lessThanValue1);
			message = lessThanMessage(rowValue, lessThanValue1);
		} else if (isLessThan(rowCode, lessThanRowCode2)) {
			result = lessThanCondition(rowValue, lessThanValue2);
			message = lessThanMessage(rowValue, lessThanValue2);
		} else if (isMustEmpty(rowCode)) {
			result = RequiredCondition.N;
		}
		
		if (result.equals(RequiredCondition.N) && StringUtils.isNotBlank(message)) {
			message = "jika " + message;
		}
		return Tupple2.<RequiredCondition, String>builder().a(result).b(message).build();
	}

	private boolean isNotBetween(String rowCode) {
		boolean res = false;
		if (StringUtils.isNoneEmpty(notBetweenRowCode, rowCode)) {
			res = ToStringList.convert(notBetweenRowCode, "|").contains(rowCode);
		}
		return res;
	}

	private RequiredCondition notBetweenCondition(String rowValue) {
		BigDecimal realValue = ToBigDecimal.convert(rowValue);
		boolean isBetween = realValue.compareTo(notBetweenLowValue) < 0 || realValue.compareTo(notBetweenHighValue) > 0;
		return isBetween ? trueCondition : falseCondition;
	}

	private String notBetweenMessage(String rowValue) {
		return StringUtils.isNotEmpty(rowValue)
				? ("nilai kolom " + (comparatorField + 1) + " < " + notBetweenLowValue + " atau > "
						+ notBetweenHighValue)
				: "";
	}

	private boolean isLessThan(String rowCode, String lessThanRowCode) {
		boolean res = false;
		if (StringUtils.isNoneEmpty(lessThanRowCode, rowCode)) {
			res = ToStringList.convert(lessThanRowCode, "|").contains(rowCode);
		}
		return res;
	}

	private RequiredCondition lessThanCondition(String rowValue, BigDecimal lessThanValue) {
		BigDecimal realValue = ToBigDecimal.convert(rowValue);
		return realValue.compareTo(lessThanValue) < 0 ? trueCondition : falseCondition;
	}

	private String lessThanMessage(String rowValue, BigDecimal lessThanValue) {
		return StringUtils.isNotEmpty(rowValue) ? ("nilai kolom " + (comparatorField + 1) + " < " + lessThanValue)
				: "";
	}

	private boolean isMustEmpty(String rowCode) {
		boolean res = false;
		if (StringUtils.isNoneEmpty(mustEmptyRowCode, rowCode)) {
			res = ToStringList.convert(mustEmptyRowCode, "|").contains(rowCode);
		}
		return res;
	}
}
