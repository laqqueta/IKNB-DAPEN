package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.BaseRowFormulaValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@XStreamAlias("ComparisonFormulaFormValidationV2")
public class ComparisonFormulaFormValidationV2 extends BaseRowFormulaValidation {
    private String comparatorField;
    private String comparatorForm;

    public ComparisonFormulaFormValidationV2() {
        super();
    }

    public ComparisonFormulaFormValidationV2(String parameter) {
        super(parameter);
    }

    @Override
    public ComparisonFormulaFormValidationV2 initialized() {
        super.initialized();
        comparatorField = getStringParameter("comparatorField");
        comparatorForm = getStringParameter("comparatorForm");
        return this;
    }

    @Override
    protected Object getComparatorValue(String idxSelectField) {
        String formattedPosCode = Arrays.stream(comparatorPosCode.split("(?<=[-+/*])|(?=[-+/*])"))
                .map(v -> v.matches("^[a-zA-Z0-9]+$") ? comparatorForm + v : v)
                .collect(Collectors.joining());

        return arithmeticOperation(
                SubmissionFormat.getFormValues(comparatorForm, Character.MAX_VALUE), formattedPosCode,
                Integer.parseInt(comparatorField))
                .setScale(scale, RoundingMode.HALF_UP);
    }

    @Override
    protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
                           String idxSelectField) {
        final Logger logger = LoggerFactory.getLogger(ComparisonFormulaFormValidationV2.class);
        Object selectValue = getSelectValue(validationResult, idxSelectField);
        Object comparatorValue = getComparatorValue(idxSelectField);
        if (!compareValue(engine, selectValue, comparatorValue)) {
            logger.error("{}>{}?{}", parameter, selectValue, comparatorValue);
            List<SubmissionField> fields = submissionFormat.getFields();
            SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
            validationResult.errors.add(new ValidationError(submissionField,
                    ValidationErrorCode.E50_02_FORMULA, String.valueOf(comparatorValue),
                    StringUtils.replace(msgError, "|", " " + operatorFormula.replace("==", "=") + " ")));
        } else {
            logger.trace("{}>{}?{}", parameter, selectValue, comparatorValue);
        }
    }
}