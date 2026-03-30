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

@XStreamAlias("SumIfMultiCriteriaFormValidation")
public class SumIfMultiCriteriaFormValidation extends BaseSumIf<SumIfMultiCriteriaParams> {

    private int criteriaAsKey; // 0 index based

    public SumIfMultiCriteriaFormValidation(String parameter) {
        super(parameter);
    }

    @Override
    public SumIfMultiCriteriaFormValidation initialized() {
        super.initialized();

        criteriaAsKey = getIntParameter("criteriaAsKey");

        return this;
    }

    /*
    * Note:
    * the multi criteria conditions only support row based,
    * there is no support for column based
    *
    * also only support 1 additional criteria (not sure about this)
    * just test with multiple criteria if curious
    *
    * */

    @Override
    public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        LinkedList<String> selectRowCodes = Arrays.stream(StringUtils.split(selectPosCode, "|"))
                .collect(Collectors.toCollection(LinkedList::new));

        if (selectRowCodes.contains(currentRowCode)) {
            final Logger logger = LoggerFactory.getLogger(SumIfMultiCriteriaFormValidation.class);

            if (comparatorForm.toLowerCase().contains("prop")) {
                System.out.println("dbg");
            }

            String[] arrRangeFields = StringUtils.split(rangeField, "|");
            String[] arrColumn = StringUtils.split(selectField, "|");
            String[] criterias = StringUtils.split(criteriaCondition, "$");
            String[] criteriasError = StringUtils.split(criteriaConditionError, "$");

            String[] criteriaKey = StringUtils.split(criterias[criteriaAsKey], "|");
            String[] criteriaKeyError = StringUtils.split(criteriasError[criteriaAsKey], "|");

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

                    validationResult.errors.add(new ValidationError(submissionField,
                            ValidationErrorCode.E50_23_FORMULA_MULTICRITERIASUMIF,
                            msgErrors[0], msgErrors[1], criteriaError, msgErrors[2],
                            criteriaConditionsError.get(criteriaRowIdx), msgErrors[3] ));
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
        Map<String, Map<String, String>> formsData = SubmissionFormat.getFormValues(prefix, Character.MAX_VALUE);

        outer:
        for (Map.Entry<String, Map<String, String>> entry : formsData.entrySet()) {
            if (entry.getValue().get(criteriaFields[criteriaAsKey]).isEmpty()) continue;

            String key = entry.getValue().get(criteriaFields[criteriaAsKey]);
            if (!mapCriteria.containsKey(key)) continue;
            if (!mapCriteriaStatus.get(key)) continue;

            for (int i = 0; i < criteriaFields.length; i++) {
                if (i != criteriaAsKey) {
                    String prior = entry.getValue().get(criteriaFields[i]);
                    if (!prior.equalsIgnoreCase(param.getAdditionalCriteria())) continue outer;
                }
            }

            String value = entry.getValue().get(param.getRangeField());
            if (this.isInvalidNumeric(value)) {
                mapCriteriaStatus.put(key, false);
                continue;
            }

            if (!mapCriteriaStatus.get(key)) continue;

            mapCriteria.computeIfPresent(key, (k, v) -> v.add(new BigDecimal(value)));
        }


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
