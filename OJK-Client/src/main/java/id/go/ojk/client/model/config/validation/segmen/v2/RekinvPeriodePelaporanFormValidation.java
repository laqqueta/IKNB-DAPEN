package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseRowValidation;
import id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser;
import id.go.ojk.client.model.config.validation.segmen.v2.util.constant.MessageType;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.util.states.JenisProgramState;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser.ParsedFormula;
import static id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser.parse;

@XStreamAlias("FormulaParserPeriodePelaporanFormValidation")
public class RekinvPeriodePelaporanFormValidation extends BaseRowValidation {
    protected String comparatorForm;
    protected String operationForm;
    protected MessageType messageType;
    protected int scale;

    public RekinvPeriodePelaporanFormValidation() {
        super();
    }

    public RekinvPeriodePelaporanFormValidation(String parameter) {
        super(parameter);
    }

    @Override
    public RekinvPeriodePelaporanFormValidation initialized() {
        super.initialized();
        comparatorForm = getStringParameter("comparatorForm");
        operationForm = getStringParameter("operationForm");
        messageType = getMessageTypeParameter("messageType");
        scale = getIntParameter("scale");

        return this;
    }

    @Override
    public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        List<String> selectRowCodes = Arrays.stream(StringUtils.split(selectPosCode, "|"))
                .collect(Collectors.toList());

        if (!selectRowCodes.contains(currentRowCode)) return;

        final Logger logger = LoggerFactory.getLogger(RekinvPeriodePelaporanFormValidation.class);

        long fieldMonth = (JenisProgramState.periodePelaporan + 1);
        ParsedFormula parsed = parse(operationForm);
        StringBuilder errorBuilder = new StringBuilder();
        BigDecimal selectValue = getCurrentValue(validationResult, selectField);
        BigDecimal result = calculateFormula(parsed, errorBuilder, String.valueOf(fieldMonth));

        if (selectValue.compareTo(result) != 0) {
            List<SubmissionField> field = submissionFormat.getFields();
            SubmissionField submissionField = field.get(Integer.parseInt(selectField));
            logger.error("{}>{}?{}", parameter, selectValue, result);

            errorBuilder.append(" (Periode bulan laporan berjalan)");

            validationResult.errors.add(new ValidationError(submissionField,
                    ValidationErrorCode.E03_34_EQUAL_FORM, errorBuilder, comparatorForm));

        }

    }

    private BigDecimal getCurrentValue(ValidationResult validationResult, String idxField) {
        return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(idxField)));
    }

    private BigDecimal calculateFormula(ParsedFormula parsed, StringBuilder errBuilder, String fieldMonth) {
        BigDecimal formulaResult = BigDecimal.ZERO;
        Map<String, String> formValue;

        for (FormulaParser.Group g : parsed.getGroups()) {
            BigDecimal groupTotal = BigDecimal.ZERO;

            for (FormulaParser.RowToken t : g.getTokens()) {
                formValue = SubmissionFormat.getFormValue(comparatorForm + t.getRowCode());

                errBuilder.append("TOTAL INVESTASI");

                if (isInvalidNumeric(formValue.get(fieldMonth))) groupTotal = BigDecimal.ZERO;
                else groupTotal = new BigDecimal(formValue.get(fieldMonth));
            }

            formulaResult = calculateOperand(formulaResult, groupTotal, g.getOperator());
        }

        return formulaResult;
    }

    private BigDecimal calculateOperand(BigDecimal value, BigDecimal tmpVal, String operator) {
        if (operator.isEmpty()) {
            value = tmpVal;
        } else {
            switch (operator) {
                case "+":
                    value = value.add(tmpVal);
                    break;
                case "-":
                    value = value.subtract(tmpVal);
                    break;
                case "*":
                    value = value.multiply(tmpVal);
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        return value
                .setScale(scale, RoundingMode.HALF_UP);
    }
}