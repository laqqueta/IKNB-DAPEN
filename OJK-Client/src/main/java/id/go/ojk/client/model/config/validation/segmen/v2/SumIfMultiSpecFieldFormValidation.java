package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.model.SumIfData;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseSumIf;
import id.go.ojk.client.model.config.validation.segmen.v2.params.SumIfBaseParams;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@XStreamAlias("SumIfMultiSpecFieldFormValidation")
public class SumIfMultiSpecFieldFormValidation extends BaseSumIf<SumIfBaseParams> {

    private String fieldSpec;
    private String conditionSpec;

    public SumIfMultiSpecFieldFormValidation(String parameter) {
        super(parameter);
    }

    @Override
    public SumIfMultiSpecFieldFormValidation initialized() {
        super.initialized();

        fieldSpec = getStringParameter("fieldSpec");
        conditionSpec = getStringParameter("conditionSpec");

        return this;
    }

    @Override
    public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        LinkedList<String> selectRowCodes = Arrays.stream(StringUtils.split(selectPosCode, "|"))
                .collect(Collectors.toCollection(LinkedList::new));

        if (selectRowCodes.contains(currentRowCode)) {
            final Logger logger = LoggerFactory.getLogger(SumIfMultiSpecFieldFormValidation.class);

            String[] arrRangeFields = StringUtils.split(rangeField, "|");
            String[] arrColumn = StringUtils.split(selectField, "|");
            String[] conds = StringUtils.split(criteriaCondition, "|");
            String[] condErrors = StringUtils.split(criteriaConditionError, "|");
            List<String> specConds = Arrays.asList(StringUtils.split(conditionSpec, "|"));

            int rowIdx = arrRangeFields.length == 0 ? 0 : selectRowCodes.indexOf(currentRowCode);
            SumIfData formulaData;
            SumIfBaseParams param = new SumIfBaseParams(conds, arrRangeFields[rowIdx]);

            if (sumCriteriaCondition == null) {
                formulaData = calculateCondition(param);
            } else {
                List<String> sumCriteria = Arrays.stream(StringUtils.split(sumCriteriaCondition, "|"))
                        .collect(Collectors.toList());

                formulaData = calculateCondition(sumCriteria, param);
            }

            for (int i = 0; i < arrColumn.length; i++) {
                String idxField = arrColumn[i];
                BigDecimal selectValue = getCurrentValue(validationResult, idxField);
                BigDecimal condsValue = idxField.equals(sumField) ?
                        formulaData.getSum() :
                        formulaData.getMappedData().get(conds[i + (-1)]);

                if (selectValue.compareTo(condsValue) != 0) {
                    String[] msgErrors = StringUtils.split(msgError, "|");
                    List<SubmissionField> fields = submissionFormat.getFields();
                    SubmissionField submissionField = fields.get(Integer.parseInt(idxField));
                    logger.error("{}>{}?{}", parameter, selectValue, condsValue);

                    String condError = "";
                    String colErr = "";

                    if (idxField.equals(sumField)) {
                        condError = slashFormatError(sumConditionError);
                        colErr = msgErrors[1];
                    } else if (i > 0) {
                        condError = condErrors[i - 1];
                        colErr = msgErrors[1];

                        if (specConds.contains(conds[i-1])) {
                            colErr = msgErrors[2];
                        }
                    }

//                    String condError = idxField.equals(sumField) ?
//                            slashFormatError(sumConditionError) :
//                            condErrors[i - 1];

//                    String colErr = specConds.contains(conds[i + (-1)]) ? msgErrors[2] : msgErrors[1];

                    validationResult.errors.add(new ValidationError(submissionField,
                            ValidationErrorCode.E50_21_FORMULA_SUMIF,
                            msgErrors[0], colErr, condError, msgErrors[3]));
                }

            }
        }
    }

    @Override
    protected Map<String, BigDecimal> mappingCriteria(SumIfBaseParams param) {
        Map<String, BigDecimal> mapCriteria = new HashMap<>();
        for (String s : param.getCriteriaConditions()) mapCriteria.putIfAbsent(s, this.scaledDecimal(0.0));

        Map<String, Boolean> mapCriteriaStatus = new HashMap<>();
        for (String s : param.getCriteriaConditions()) mapCriteriaStatus.putIfAbsent(s, true);

        String prefix = comparatorForm + comparatorRow.split("-")[0];
        List<String> specConds = Arrays.asList(StringUtils.split(conditionSpec, "|"));

        final String[] key = new String[1];
        final String[] value = new String[1];

        Map<String, BigDecimal> accumulator = new HashMap<>();

        SubmissionFormat
                .getStreamOfFormSubMap(prefix, Character.MAX_VALUE)
                .forEach(entry -> {
                    if (entry.getValue().get(criteriaField).isEmpty()) return;

                    key[0] = entry.getValue().get(criteriaField);
                    if (!mapCriteria.containsKey(key[0])) return;
                    if (!mapCriteriaStatus.get(key[0])) return;

                    if (specConds.contains(key[0])) {
                        value[0] = entry.getValue().get(fieldSpec);
                    } else {
                        value[0] = entry.getValue().get(param.getRangeField());
                    }

                    if (this.isInvalidNumeric(value[0])) {
                        mapCriteriaStatus.put(key[0], false);
                        return;
                    }

                    if (!mapCriteriaStatus.get(key[0])) return;

                    // mapCriteria.computeIfPresent(key[0], (k, v) -> v.add(new BigDecimal(value[0])));
                    accumulator.merge(key[0], new BigDecimal(value[0]), BigDecimal::add);
                });

        accumulator.forEach((k, v) ->
                mapCriteria.computeIfPresent(k, (mk, mv) -> mv.add(v)));

        return mapCriteria;
    }
}
