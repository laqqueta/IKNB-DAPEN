package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.constant.Operator;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@XStreamAlias("ComparisonFormValidation4")
public class ComparisonFormValidation4 extends BaseRowFormulaValidation {
	protected String comparatorForm;
	protected String comparatorField;
    private Operator comparatorOperator;
    private Operator posOperator;
    private String showErrorOnPos;

    public ComparisonFormValidation4(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormValidation4 initialized() {
		super.initialized();
		comparatorForm = getStringParameter("comparatorForm");
		comparatorField = getStringParameter("comparatorField");
        comparatorOperator = getOperatorParameter("comparatorOperator");
        posOperator = getOperatorParameter("posOperator");
        showErrorOnPos = getStringParameter("showErrorOnPos");
		return this;
	}

	@Override
	protected BigDecimal getComparatorValue(String idxSelectField) {
		String[] arrComparatorField = StringUtils.split(comparatorField, '|');
        List<BigDecimal> arrRes = new ArrayList<>();
		for (String field : arrComparatorField) {
            arrRes.add(SubmissionFormat.getSumMapPosFormValue(comparatorForm, comparatorPosCode, field).setScale(scale, RoundingMode.HALF_UP));
		}

        BigDecimal res = BigDecimal.ZERO;

        for (int i = 0; i < arrRes.size(); i++) {
            if (i == 0) {
                res = res.add(arrRes.get(i));
                continue;
            }

            res = calculate(res, arrRes.get(i), comparatorOperator);
        }

		return res;
	}

    @Override
    protected Object getSelectValue(ValidationResult validationResult, String idxSelectField) {
        String[] arrSelectPos = StringUtils.split(selectPosCode, '|');
        BigDecimal res = BigDecimal.ZERO;

        for (String pos : arrSelectPos) {
            res = calculate(res,
                    new BigDecimal(SubmissionFormat.getMapPosValue(pos, idxSelectField)).setScale(scale, RoundingMode.HALF_UP),
                    posOperator);
        }

        return res;
    }

    @Override
	protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
			String idxSelectField) {
		final Logger logger = LoggerFactory.getLogger(ComparisonFormValidation4.class);
		Object selectValue = getSelectValue(validationResult, idxSelectField);
		Object comparatorValue = getComparatorValue(idxSelectField);
		if (!compareValue(engine, selectValue, comparatorValue)) {
			logger.error("{}>{}?{}", parameter, selectValue, comparatorValue);
            if (validationResult.rowSplited[1].equalsIgnoreCase(showErrorOnPos)) {
                validationResult.errors.add(new ValidationError(null, ValidationErrorCode.E99_00_OTHER,
                        msgError));
            }
		} else {
			logger.trace("{}>{}?{}", parameter, selectValue, comparatorValue);
		}
	}

    private BigDecimal calculate(BigDecimal result, BigDecimal val, Operator operator) {
        switch (operator) {
            case ADD:
                return result.add(val);
            case SUBTRACT:
                return result.subtract(val);
            case MULTIPLY:
                return result.multiply(val);
            case DIVIDE:
                return result.divide(val, RoundingMode.HALF_UP);
            default:
                return BigDecimal.ZERO;
        }
    }
}