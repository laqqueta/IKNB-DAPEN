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
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("deviationMaxValidation")
public class DeviationMaxValidation extends BaseDecimalValidation {
	private String refPosCode;
	private String fixedValue;
	private String multiplier;
	protected String operator;
	protected String msgError;
	protected String operatorFormula;

	public DeviationMaxValidation() {
		super();
	}

	public DeviationMaxValidation(String parameter) {
		super(parameter);
	}

	@Override
	public DeviationMaxValidation initialized() {
		super.initialized();
		refPosCode = getStringParameter("refPosCode");
		fixedValue = getStringParameter("fixedValue");
		multiplier = getStringParameter("multiplier");
		operator = getStringParameter("operator");
		msgError = getStringParameter("msgError");
		operatorFormula = initOperator(operator);
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(DeviationMaxValidation.class);
		List<SubmissionField> fields = submissionFormat.getFields();
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		if (selectPosCode.contains(validationResult.getColumn(1))) {
			String[] arrSelectField = StringUtils.split(selectField, "|");
			for (String field : arrSelectField) {
				int fieldNumber = Integer.valueOf(field);
				String fieldValueString = validationResult.getColumn(fieldNumber).replaceAll("\\s+", "");
				String compareValue = fieldValueString + operatorFormula + String.valueOf(getDeviation(fieldNumber));
				try {
					boolean result = (boolean) engine.eval(compareValue);
					if (!result) {
						SubmissionField submissionField = fields.get(fieldNumber);
						String[] arrMsgError = StringUtils.split(msgError, "|");
						String msg = UtilValidation.getArray(arrMsgError, 0, "") + " " + operatorFormula.replace("==", "=") + " " + UtilValidation.getArray(arrMsgError, 1, "");
						validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E50_10_FORMULA2, msg));
					}
				} catch (ScriptException e) {
					logger.error(compareValue, e);
				}
			}
		}
	}
	
	private List<BigDecimal> getValueList(int field) {
		List<BigDecimal> res = new ArrayList<>();
		String[] arrRefPosCode = StringUtils.split(refPosCode, "|");
		String[] arrFixedValue = StringUtils.split(fixedValue, "|");
		if (arrRefPosCode != null) {
			for (int i = 0; i < arrRefPosCode.length; i++) {
				List<String> list = SubmissionFormat.getAllMapPosValue(arrRefPosCode[i], String.valueOf(field));
				for (int j = 0; j < list.size(); j++) {
					res.add(toBigDecimal(list.get(j)));
				}
			}
		}
		if (arrFixedValue != null) {
			for (int i = 0; i < arrFixedValue.length; i++) {
				String tmp = arrFixedValue[0];
				if (StringUtils.isNotBlank(tmp)) {
					res.add(toBigDecimal(tmp));
				}
			}
		}
		return res;
	}

	private BigDecimal getMax(int field) {
		List<BigDecimal> list = getValueList(field);
		BigDecimal res = Collections.max(list);
		return res;
	}
	
	private BigDecimal getDeviation(int field) {
		BigDecimal multiplier = toBigDecimal(this.multiplier);
		BigDecimal res = multiplier.multiply(getMax(field));
		res = res.setScale(scale, RoundingMode.HALF_UP);
		return res;
	}
}