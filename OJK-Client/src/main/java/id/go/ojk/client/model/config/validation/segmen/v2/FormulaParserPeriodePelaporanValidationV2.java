package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseFormulaParserValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.util.states.JenisProgramState;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser.parse;

@XStreamAlias("FormulaParserPeriodePelaporanValidationV2")
public class FormulaParserPeriodePelaporanValidationV2 extends BaseFormulaParserValidation {

    private String filterColumn;
    private String filterValues;

    private final AtomicReference<String> filterVal = new AtomicReference<>();

    public FormulaParserPeriodePelaporanValidationV2(String parameter) {
        super(parameter);
    }

    @Override
    public BaseFormulaParserValidation initialized() {

        filterColumn = getStringParameter("filterColumn");
        filterValues = getStringParameter("filterValues");

        return super.initialized();
    }

    @Override
    public void validate(ProgressPreparationAndSending.SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        List<String> selectRowCodes = Arrays.stream(StringUtils.split(selectPosCode, "|"))
                .collect(Collectors.toList());

        if (!selectRowCodes.contains(currentRowCode)) return;

        List<String> filters = Arrays.asList(StringUtils.split(filterValues, "|"));
        String filterFieldValue = validationResult.getColumn(Integer.parseInt(filterColumn));

        if (!filters.contains(filterFieldValue)) return;
        filterVal.set(filterFieldValue);

        String[] fields = StringUtils.split(selectField, "|");
        String[] operations = StringUtils.split(formulaOperation, "|");
        String[] operationErrMsgs = StringUtils.split(formulaOperationErr, "|");

        if (fields.length != operations.length || operationErrMsgs.length != operations.length)
            throw new IllegalStateException();

        final Logger logger = LoggerFactory.getLogger(BaseFormulaParserValidation.class);

        for (int i = 0; i < fields.length; i++) {
            FormulaParser.ParsedFormula parsed = parse(operations[i]);
            BigDecimal selectValue = getCurrentValue(validationResult, fields[i]);
            BigDecimal calculatedValue = calculateFormula(parsed);

            if (selectValue.compareTo(calculatedValue) != 0) {
                List<SubmissionField> field = submissionFormat.getFields();
                SubmissionField submissionField = field.get(Integer.parseInt(fields[i]));
//				String err = "= " + operationErrMsg + " pada Form " + comparatorForm;
                logger.error("{}>{}?{} :: Operation Idx > {}", parameter, selectValue, calculatedValue, i);
                validationResult.errors.add(new ValidationError(submissionField,
                        ValidationErrorCode.E03_35_EQUAL_FORM,
                        operationErrMsgs[i].replaceFirst("(sama dengan)", "=")
                                .replace("kurang lebih atau sama dengan", "<=")
                                .replace("lebih dari atau sama dengan ", ">=")
                                + " pada Jenis Program = " + filterVal.get() ));

            }
        }
    }

    @Override
    protected BigDecimal calculateFormula(FormulaParser.ParsedFormula parsed) {
        BigDecimal formulaResult = BigDecimal.ZERO;
        for (FormulaParser.Group g : parsed.getGroups()) {
            BigDecimal groupTotal = BigDecimal.ZERO;
            for (FormulaParser.RowToken t : g.getTokens()) {
                groupTotal = calculateOperand(groupTotal, calculateFieldStream(t, filterColumn, filterVal.get()), t.getOperator());
            }
            formulaResult = calculateOperand(formulaResult, groupTotal, g.getOperator());
        }

        return formulaResult;

    }

}