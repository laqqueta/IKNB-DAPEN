package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@XStreamAlias("RatioValidation3")
public class RatioValidation3 extends BaseFormulaValidation {
	protected Boolean roundFull;

	private String fieldFilter;
	private String filterValue;

	private final AtomicReference<String> filterVal = new AtomicReference<>();

	public RatioValidation3() {
		super();
	}

	@Override
	public BaseFormulaValidation initialized() {
		roundFull = getBooleanParameter("roundFull", false);

		fieldFilter = getStringParameter("fieldFilter");
		filterValue = getStringParameter("filterValue");

		return super.initialized();
	}

	public RatioValidation3(String parameter) {
		super(parameter);
	}

	@Override
	public void validate(ProgressPreparationAndSending.SubmissionData submissionData, SubmissionFormat submissionFormat,
						 ValidationResult validationResult) {
		String[] SelectField = StringUtils.split(selectField, "|");
		String posCode = UtilValidation.getArray(validationResult.rowSplited, 1, "");
		totalRow = submissionFormat.getTotalRow();
		if (StringUtils.isNotEmpty(posCode)) {
			if (selectPosCode.contains(posCode)) {

				List<String> filters = Arrays.asList(StringUtils.split(filterValue, "|"));
				String filterFieldValue = validationResult.getColumn(Integer.parseInt(fieldFilter));

				if (!filters.contains(filterFieldValue)) return;
				filterVal.set(filterFieldValue);

				for (int i = 0; i < SelectField.length; i++) {
					compareFormula(validationResult, submissionFormat.getFields(), SelectField[i],
							Integer.valueOf(SelectField[i]), leftFormula, operatorFormula, rightFormula);
				}
				posExist = true;
			} else {
				if (posExist == true && validationResult.lineNumber == 1) {
					posExist = false;
				}
				if (posExist == false) {
					if (validationResult.lineNumber == totalRow) {
						validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E50_03_POS_MUST_EXIST,
								posExist, leftFormula));
					}
				}
			}
		}
	}

	@Override
	protected void compareFormula(ValidationResult validationResult, List<SubmissionField> submissionField,
			String field, int seq, String leftFormula, String operator, String rightFormula) {
		Logger logger = LoggerFactory.getLogger(RatioValidation3.class);
		boolean result;
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		BigDecimal leftValue = arithmeticOperation(leftFormula, seq);
		BigDecimal rightValue = calculateRatio(rightFormula, seq);
		String compareValue = leftValue + operator + rightValue;

		if (leftValue != null && rightValue != null) {
			try {
				result = (boolean) engine.eval(compareValue);
				if (!result) {
					int idxField = Integer.parseInt(field);
					String errorMessage = msgError.replace("|", " " + operator.replace("==", "=") + " ");
					logger.error("leftFormula=" + leftFormula + ";rightFormula=" + rightFormula + ";compare=" + compareValue);
					validationResult.errors.add(new ValidationError(submissionField.get(idxField),
							ValidationErrorCode.E50_02_FORMULA, compareValue,
							errorMessage + " pada Jenis Program = " + filterVal.get()));
				}
			} catch (ScriptException e) {
				logger.error(compareValue, e);
			}
		}
	}

	@Override
	protected BigDecimal arithmeticOperation(String formula, int seq) {
		Logger logger = LoggerFactory.getLogger(RatioValidation3.class);
		BigDecimal res = super.arithmeticOperation(formula, seq, fieldFilter, filterVal.get());
		if (res != null) {
			res = res.setScale(roundFull ? 0 : 2, RoundingMode.HALF_UP);
		}
//		logger.debug("formula=" + formula + ";seq=" + seq + ";result=" + (res != null ? res : "null"));
		return res;
	}
	
	protected BigDecimal calculateRatio(String formula, int seq) {
		Logger logger = LoggerFactory.getLogger(RatioValidation3.class);
		BigDecimal res = BigDecimal.ZERO;
		try {
			String[] ratioFormulas = StringUtils.split(formula, "|");
			String formula1 = UtilValidation.getArray(ratioFormulas, 0, "");
			String formula2 = UtilValidation.getArray(ratioFormulas, 1, "");
			BigDecimal value1 = arithmeticOperation(formula1, seq);
			BigDecimal value2 = arithmeticOperation(formula2, seq);
			if (value2 != null && value2.compareTo(BigDecimal.ZERO) != 0) {
				res = value1.divide(value2, 4, RoundingMode.HALF_UP);
			}
			if (res != null) {
				res = res.multiply(new BigDecimal(100));
				res = res.setScale(roundFull.booleanValue() ? 0 : 2, RoundingMode.HALF_UP);
			}
		} catch (Exception e) {
			logger.error("formula=" + formula,  e);
		}
		return res;
	}
}