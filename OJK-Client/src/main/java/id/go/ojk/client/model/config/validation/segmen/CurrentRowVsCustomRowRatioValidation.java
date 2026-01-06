package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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

@XStreamAlias("CurrentRowVsCustomRowRatioValidation")
public class CurrentRowVsCustomRowRatioValidation extends MapParamSegmentValidation {
	private String selectPosCode;
	private String ratioField;
	private String denominatorPosCode;
	private String operator;
	private String msgError;
	private String operatorFormula;	

	public CurrentRowVsCustomRowRatioValidation() {
		super();
	}

	public CurrentRowVsCustomRowRatioValidation(String parameter) {
		super(parameter);
	}

	@Override
	public CurrentRowVsCustomRowRatioValidation initialized() {
		selectPosCode = getStringParameter("selectPosCode");
		ratioField = getStringParameter("ratioField");
		denominatorPosCode = getStringParameter("denominatorPosCode");
		operator = getStringParameter("operator");
		msgError = getStringParameter("msgError");
		operatorFormula = UtilValidation.getFormulaOperator(operator);
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		List<String> listSelectPosCode = Arrays.asList(StringUtils.split(selectPosCode, "|"));
		String posCode = validationResult.getColumn(1);
		if (listSelectPosCode.contains(posCode)) {
			compareFormula(validationResult, submissionFormat.getFields(), operatorFormula);
		}
	}
	
	protected void compareFormula(ValidationResult validationResult, List<SubmissionField> submissionField,
			String operator) {
		Logger logger = LoggerFactory.getLogger(RatioValidation.class);
		String[] arrRatioField = StringUtils.split(ratioField, "|");
		int nominatorField = Integer.parseInt(UtilValidation.getArray(arrRatioField, 0, ""));
		int denominatorField = Integer.parseInt(UtilValidation.getArray(arrRatioField, 1, ""));
		int resultField = Integer.parseInt(UtilValidation.getArray(arrRatioField, 2, ""));
		BigDecimal nominator = UtilValidation.toBigDecimal(validationResult.getColumn(nominatorField));
		BigDecimal denominator = UtilValidation.calculateSavedValue(denominatorField, denominatorPosCode, SubmissionFormat.mapPosValue.entrySet());
		BigDecimal leftValue = UtilValidation.toBigDecimal(validationResult.getColumn(resultField), "0");
		BigDecimal rightValue = UtilValidation.calculateRatio(nominator, denominator, 2);
		String msg = msgError.replace("|", " " + UtilValidation.getFormulaDesc(operatorFormula) + " ");
		String compareValue = leftValue + operator + rightValue;
		if (leftValue != null && rightValue != null) {
			if (!UtilValidation.evaluateScript(compareValue)) {
				logger.error("ratioFields=" + ratioField + ";pos=" + validationResult.getColumn(1) + ";compare=" + compareValue);
				validationResult.errors.add(new ValidationError(submissionField.get(resultField),
						ValidationErrorCode.E50_02_FORMULA, compareValue, msg));
			}
		}
	}
}