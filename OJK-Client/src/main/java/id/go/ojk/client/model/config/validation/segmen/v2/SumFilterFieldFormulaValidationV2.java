package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.BaseRowFormulaValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.context.ApplicationContextClient;
import id.go.ojk.client.service.validation.ValidationService;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@XStreamAlias("SumFilterFieldFormulaValidationV2")
public class SumFilterFieldFormulaValidationV2 extends BaseRowFormulaValidation {

    private String filterColumn;
    private String filterValues;
    private String formName;

    private final AtomicReference<String> filterVal = new AtomicReference<>();

    public SumFilterFieldFormulaValidationV2() {
        super();
    }

    public SumFilterFieldFormulaValidationV2(String parameter) {
        super(parameter);
    }

    @Override
    public SumFilterFieldFormulaValidationV2 initialized() {
        super.initialized();

        filterColumn = getStringParameter("filterColumn");
        filterValues = getStringParameter("filterValues");
        formName = getStringParameter("formName");

        return this;
    }

    @Override
    protected Object getComparatorValue(String idxSelectField) {
        return SubmissionFormat.
                getStreamOfFormSubMapFieldFilter(formName + comparatorPosCode, Character.MAX_VALUE, filterColumn, filterVal.get())
                .map(v -> v.getValue().get(idxSelectField))
                .filter(v -> !isInvalidNumeric(v))
                .map(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void validate(ProgressPreparationAndSending.SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        List<String> listSelectPosCode = Arrays.asList(StringUtils.split(selectPosCode, "|"));
        String posCode = validationResult.getColumn(1);

        if (StringUtils.isNotEmpty(posCode) && listSelectPosCode.contains(posCode)) {

            List<String> filters = Arrays.asList(StringUtils.split(filterValues, "|"));
            String filterFieldValue = validationResult.getColumn(Integer.parseInt(filterColumn));

            if (!filters.contains(filterFieldValue)) return;

            filterVal.set(filterFieldValue);

            String[] arrSelectField = StringUtils.split(selectField, "|");

            for (String s : arrSelectField) {
                engine = ApplicationContextClient.getInstance().getService(ValidationService.class).getScriptEngine();
                compare(engine, submissionFormat, validationResult, s);
            }
        }
    }

    @Override
    protected void compare(ScriptEngine engine, SubmissionFormat submissionFormat, ValidationResult validationResult,
                           String idxSelectField) {
        final Logger logger = LoggerFactory.getLogger(SumFilterFieldFormulaValidationV2.class);
        Object selectValue = getSelectValue(validationResult, idxSelectField);
        Object comparatorValue = getComparatorValue(idxSelectField);
        if (!compareValue(engine, selectValue, comparatorValue)) {
            logger.error("{}>{}?{}", parameter, selectValue, comparatorValue);
            List<SubmissionField> fields = submissionFormat.getFields();
            SubmissionField submissionField = fields.get(Integer.parseInt(idxSelectField));
            SubmissionField sfFilter = fields.get(Integer.parseInt(filterColumn));
            String err = StringUtils.replace(msgError, "|", " " + operatorFormula.replace("==", "=") + " ")
                    + " pada '" + sfFilter.getName() + "' = " + validationResult.getColumn(Integer.parseInt(filterColumn));
            validationResult.errors.add(new ValidationError(submissionField,
                    ValidationErrorCode.E50_02_FORMULA, String.valueOf(comparatorValue),
                    err));
        }
    }
}