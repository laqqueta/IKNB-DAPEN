package id.go.ojk.client.model.config.validation.segmen.v2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.segmen.model.SumIfData;
import id.go.ojk.client.model.config.validation.segmen.v2.base.BaseSumIf;
import id.go.ojk.client.model.config.validation.segmen.v2.params.SumIfMultiCriteriaParams;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@XStreamAlias("SumIfMultiSpecFieldCriteriaFormValidation")
public class SumIfMultiSpecFieldCriteriaFormValidation extends BaseSumIf<SumIfMultiCriteriaParams> {

    private String fieldSpec;
    private String conditionSpec;

    private int criteriaAsKey; // 0 index based

    public SumIfMultiSpecFieldCriteriaFormValidation(String parameter) {
        super(parameter);
    }

    @Override
    public SumIfMultiSpecFieldCriteriaFormValidation initialized() {
        super.initialized();

        criteriaAsKey = getIntParameter("criteriaAsKey");
        fieldSpec = getStringParameter("fieldSpec");
        conditionSpec = getStringParameter("conditionSpec");

        return this;
    }

    /*
    * Note:
    * the multi criteria conditions are only support row based,
    * there is no support for column based
    *
    * also only support 1 additional criteria (not sure about this)
    *
    * need to additional testing for multi criteria support
    *
    * */

    @Override
    public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        LinkedList<String> selectRowCodes = Arrays.stream(StringUtils.split(selectPosCode, "|"))
                .collect(Collectors.toCollection(LinkedList::new));

        if (selectRowCodes.contains(currentRowCode)) {
            final Logger logger = LoggerFactory.getLogger(SumIfMultiSpecFieldCriteriaFormValidation.class);

            String[] arrRangeFields = StringUtils.split(rangeField, "|");
            String[] arrColumn = StringUtils.split(selectField, "|");
            String[] criterias = StringUtils.split(criteriaCondition, "$");
            String[] criteriasError = StringUtils.split(criteriaConditionError, "$");

            String[] criteriaKey = StringUtils.split(criterias[criteriaAsKey], "|");
            String[] criteriaKeyError = StringUtils.split(criteriasError[criteriaAsKey], "|");

            List<String> specConds = Arrays.asList(StringUtils.split(conditionSpec, "|"));

            List<String> criteriaConditions = criteriaConditions(criterias);
            List<String> criteriaConditionsError = criteriaConditions(criteriasError);

            int rangeRowIdx = arrRangeFields.length == 1 ? 0 : selectRowCodes.indexOf(currentRowCode);
            int criteriaRowIdx = selectRowCodes.indexOf(currentRowCode);

            SumIfData formulaData;
            SumIfMultiCriteriaParams param = new SumIfMultiCriteriaParams(criteriaKey, arrRangeFields[rangeRowIdx],
                    criteriaConditions.get(criteriaRowIdx));

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
                        formulaData.getMappedData().get(criteriaKey[i + (-1)]);

                if (selectValue.compareTo(condsValue) != 0) {
                    String[] msgErrors = StringUtils.split(msgError, "|");
                    List<SubmissionField> fields = submissionFormat.getFields();
                    SubmissionField submissionField = fields.get(Integer.parseInt(idxField));
                    logger.error("{}>{}?{}", parameter, selectValue, condsValue);

                    String criteriaError = idxField.equals(sumField) ?
                            slashFormatError(sumConditionError) :
                            criteriaKeyError[i-1];

                    String colErr = specConds.contains(criteriaKey[i + (-1)]) ? msgErrors[2] : msgErrors[1];

                    validationResult.errors.add(new ValidationError(submissionField,
                            ValidationErrorCode.E50_23_FORMULA_MULTICRITERIASUMIF,
                            msgErrors[0], colErr, criteriaError, msgErrors[3],
                            criteriaConditionsError.get(criteriaRowIdx), msgErrors[4] ));
                }

            }
        }
    }

    @Override
    protected Map<String, BigDecimal> mappingCriteria(SumIfMultiCriteriaParams param) {

        String[] criteriaFields = StringUtils.split(criteriaField, "|");

        Map<String, BigDecimal> mapCriteria = new HashMap<>();
        for (String s : param.getCriteriaConditions()) mapCriteria.putIfAbsent(s, this.scaledDecimal(0.0));

        Map<String, Boolean> mapCriteriaStatus = new HashMap<>();
        for (String s : param.getCriteriaConditions()) mapCriteriaStatus.putIfAbsent(s, true);

        String prefix = comparatorForm + comparatorRow.split("-")[0];

        List<String> specConds = Arrays.asList(StringUtils.split(conditionSpec, "|"));

        final String[] key = new String[1];
        final String[] value = new String[1];
        final String[] criteriaVal = new String[1];

        Map<String, BigDecimal> accumulator = new HashMap<>();

        SubmissionFormat
                .getStreamOfFormSubMap(prefix, Character.MAX_VALUE)
                .forEach(entry -> {
                    if (entry.getValue().get(criteriaFields[criteriaAsKey]).isEmpty()) return;

                    key[0] = entry.getValue().get(criteriaFields[criteriaAsKey]);
                    if (!mapCriteria.containsKey(key[0])) return;
                    if (!mapCriteriaStatus.get(key[0])) return;

                    for (int i = 0; i < criteriaFields.length; i++) {
                        if (i != criteriaAsKey) {
                            criteriaVal[0] = entry.getValue().get(criteriaFields[i]);
                            if (!criteriaVal[0].equalsIgnoreCase(param.getAdditionalCriteria())) return;
                        }
                    }

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

    private List<String> criteriaConditions(String[] criteriasCondition) {
        List<String> criterias = new ArrayList<>();
        for (int i = 0; i < criteriasCondition.length; i++) {
            if (i != criteriaAsKey) {
                criterias.addAll(Arrays.asList(StringUtils.split(criteriasCondition[i], "|")));
            }
        }

        return criterias;
    }

}
