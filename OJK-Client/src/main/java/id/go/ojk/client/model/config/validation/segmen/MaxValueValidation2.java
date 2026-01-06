package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("MaxValueValidation2")
public class MaxValueValidation2 extends BaseDecimalValidation {
	private String posCodeFormula;
	private String multiplierFormula;
	private String fixedValue;
	private String operator;
	private String operatorFormula;
	private String errorMessage;

	public MaxValueValidation2() {
		super();
	}

	public MaxValueValidation2(String parameter) {
		super(parameter);
	}

	@Override
	public MaxValueValidation2 initialized() {
		super.initialized();
		posCodeFormula = getStringParameter("posCodeFormula");
		multiplierFormula = getStringParameter("multiplierFormula");
		fixedValue = getStringParameter("fixedValue");
		operator = getStringParameter("operator");
		errorMessage = getStringParameter("errorMessage");
		operatorFormula = initOperator(operator);
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(MaxValueValidation2.class);
		List<SubmissionField> fields = submissionFormat.getFields();
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		if (selectPosCode.contains(validationResult.getColumn(1))) {
			String[] arrSelectField = StringUtils.split(selectField, "|");
			for (String field : arrSelectField) {
				int fieldNumber = Integer.parseInt(field);
				String fieldValueString = validationResult.getColumn(fieldNumber);
				int scale = (fieldValueString.indexOf('.') == -1) ? 0 : 2;
				BigDecimal expectedMax = getMax(fieldNumber).setScale(scale, RoundingMode.HALF_UP);
				expectedMax = expectedMax.setScale(0, RoundingMode.HALF_UP);
				String compareValue = fieldValueString + operatorFormula + String.valueOf(expectedMax);
				try {
					boolean result = (boolean) engine.eval(compareValue);
					if (!result) {
						logger.error(compareValue);
						SubmissionField submissionField = fields.get(fieldNumber);
						validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E11_07_EQUAL, errorMessage));
					}
				} catch (ScriptException e) {
					logger.error(compareValue, e);
				}
			}
		}
	}
	
	private List<BigDecimal> getValueList(int field) {
		List<BigDecimal> res = new ArrayList<>();
		if (StringUtils.isNotEmpty(posCodeFormula)) {
			String[] arrPosCodeFormula = StringUtils.split(posCodeFormula, "|");
			String[] arrmultiplierFormula = StringUtils.split(multiplierFormula, "|");
			if (arrPosCodeFormula != null) {
				for (int i = 0; i < arrPosCodeFormula.length; i++) {
					BigDecimal multiplierValue = new BigDecimal(arrmultiplierFormula[i]);
					BigDecimal formulaValue = arithmeticOperation(arrPosCodeFormula[i], field);
					res.add(formulaValue.multiply(multiplierValue).setScale(0, RoundingMode.HALF_UP));
				}
			}
		}
		if (StringUtils.isNotEmpty(fixedValue)) {
			String[] arrFixedValue = StringUtils.split(fixedValue, "|");
			if (arrFixedValue != null) {
				for (int i = 0; i < arrFixedValue.length; i++) {
					String tmp = arrFixedValue[0];
					if (StringUtils.isNotBlank(tmp)) {
						res.add(toBigDecimal(tmp));
					}
				}
			}
		}
		return res;
	}

	private BigDecimal getMax(int field) {
		List<BigDecimal> list = getValueList(field);
		BigDecimal res = Collections.max(list).setScale(scale, RoundingMode.HALF_UP);
		return res;
	}
}