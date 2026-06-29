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
import java.util.Map;
import java.util.stream.Collectors;

import static id.go.ojk.client.model.config.validation.segmen.v2.util.FormulaParser.parse;

@XStreamAlias("FormulaParserRekinvPeriodPelaporanValidation")
public class FormulaParserRekinvPeriodPelaporanValidation extends BaseFormulaParserValidation {
    public FormulaParserRekinvPeriodPelaporanValidation() {
    }

    public FormulaParserRekinvPeriodPelaporanValidation(String parameter) {
        super(parameter);
    }

    @Override
    public void validate(ProgressPreparationAndSending.SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        List<String> selectRowCodes = Arrays.stream(StringUtils.split(selectPosCode, "|"))
                .collect(Collectors.toList());

        if (!selectRowCodes.contains(currentRowCode)) return;

        String[] fields = StringUtils.split(selectField, "|");
        String[] operations = StringUtils.split(formulaOperation, "|");
        String[] operationErrMsgs = StringUtils.split(formulaOperationErr, "|");
        String[] months = {"Januari", "Febuari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September",
                "Oktober", "November", "Desember"};

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
                String errMsg = operationErrMsgs[i].replaceFirst("(sama dengan)", "=")
                        .replace("kurang lebih atau sama dengan", "<=")
                        .replace("lebih dari atau sama dengan ", ">=")
                        .replace("{}", months[Math.toIntExact(JenisProgramState.periodePelaporan - 1)]);
                // = 'Total Investasi' pada form REKINV sesuai dengan Periode Bulan Laporan Berjalan ({})
                logger.error("{}>{}?{} :: Operation Idx > {}", parameter, selectValue, calculatedValue, i);
                validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E03_35_EQUAL_FORM, errMsg));

            }
        }
    }

    @Override
    protected BigDecimal calculateFieldStream(FormulaParser.RowToken rowToken) {
        BigDecimal[] fieldTotal = {BigDecimal.ZERO};
        boolean[] isInvalidValue = {false};
        String field = String.valueOf(JenisProgramState.periodePelaporan + 1);

        SubmissionFormat.getStreamOfFormSubMap(rowToken.getRowPrefix() + rowToken.getRowCode(), Character.MAX_VALUE)
                .map(Map.Entry::getValue)
                .forEach(v -> {
                    if (isInvalidValue[0]) return;
                    if (isInvalidNumeric(v.get(field))) isInvalidValue[0] = true;
                    else {
                        fieldTotal[0] = calculateOperand(fieldTotal[0],
                                new BigDecimal(v.get(field)),
                                rowToken.getMapOperands().get(field));
                    }

                    if (isInvalidValue[0]) fieldTotal[0] = BigDecimal.ZERO;
                });

        return fieldTotal[0];
    }
}