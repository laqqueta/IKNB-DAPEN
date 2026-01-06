package id.go.ojk.client.model.config.validation.field;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.util.ToBigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("MaxValueValidation")
public class MaxValueValidation extends BaseFieldFormulaValidation {
	protected String comparatorFixValue;

	public MaxValueValidation() { }

	public MaxValueValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public MaxValueValidation initialized() {
		super.initialized();
		comparatorFixValue = getStringParameter("comparatorFixValue");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(MaxValueValidation.class);
		BigDecimal fieldValue = ToBigDecimal.convert(validationResult.getColumn(field.getNumber()), 0);
		BigDecimal comparatorValue = getMax(validationResult);
		if (fieldValue != null && comparatorValue != null) {
			boolean result = compareValue(fieldValue, comparatorValue);
			if (!result) {
				logger.error("{" + parameter + "}>" + fieldValue + "?" + comparatorValue);
				validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_07_EQUAL,
						String.valueOf(comparatorValue)));
			} else {
				logger.trace("{" + parameter + "}>" + fieldValue + "?" + comparatorValue);
			}
		}
	}
	
	private List<BigDecimal> getValueList(ValidationResult validationResult) {
		List<BigDecimal> res = new ArrayList<>();
		if (StringUtils.isNotEmpty(comparatorFormula)) {
			String[] arrPosCodeFormula = StringUtils.split(comparatorFormula, "|");
			if (arrPosCodeFormula != null) {
				for (int i = 0; i < arrPosCodeFormula.length; i++) {
					BigDecimal comparatorValue = arithmeticOperation(comparatorFormula, validationResult.rowSplited);
					res.add(comparatorValue);
				}
			}
		}
		if (StringUtils.isNotEmpty(comparatorFixValue)) {
			String[] arrFixedValue = StringUtils.split(comparatorFixValue, "|");
			if (arrFixedValue != null) {
				for (int i = 0; i < arrFixedValue.length; i++) {
					String tmp = arrFixedValue[0];
					if (StringUtils.isNotBlank(tmp)) {
						res.add(ToBigDecimal.convert(tmp, 0));
					}
				}
			}
		}
		return res;
	}

	private BigDecimal getMax(ValidationResult validationResult) {
		List<BigDecimal> list = getValueList(validationResult);
		BigDecimal res = Collections.max(list);
		return res;
	}
}
