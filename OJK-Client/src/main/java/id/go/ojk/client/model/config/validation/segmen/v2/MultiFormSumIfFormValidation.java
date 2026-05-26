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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@XStreamAlias("MultiFormSumIfFormValidation")
public class MultiFormSumIfFormValidation extends BaseSumIf<SumIfBaseParams> {

    public MultiFormSumIfFormValidation(String parameter) {
        super(parameter);
    }

    @Override
    public MultiFormSumIfFormValidation initialized() {
        super.initialized();
        return this;
    }

    @Override
    public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        LinkedList<String> selectRowCodes = Arrays.stream(StringUtils.split(selectPosCode, "|"))
                .collect(Collectors.toCollection(LinkedList::new));

        if (selectRowCodes.contains(currentRowCode)) {
            final Logger logger = LoggerFactory.getLogger(MultiFormSumIfFormValidation.class);

            String[] arrColumn = StringUtils.split(selectField, "|");
            String[] conds = StringUtils.split(criteriaCondition, "|");
            String[] condErrors = StringUtils.split(criteriaConditionError, "|");
            SumIfData formulaData;

            SumIfBaseParams param = new SumIfBaseParams(conds);

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

                    String condError = idxField.equals(sumField) ?
                            slashFormatError(sumConditionError) :
                            condErrors[i - 1];

                    validationResult.errors.add(new ValidationError(submissionField,
                            ValidationErrorCode.E50_24_FORMULA_MULTIFORMSUMIF,
                            getErrorMessage(msgErrors, condError)));
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

        String[] comparatorForms = StringUtils.split(comparatorForm, "|");
        String[] comparatorRows = StringUtils.split(comparatorRow, "|");
        String[] rangeFields = StringUtils.split(rangeField, "|");
        String[] criteriaFields = StringUtils.split(criteriaField, "|");

        if (comparatorForms.length != comparatorRows.length) throw new UnsupportedOperationException();

        final String[] key = new String[1];
        final String[] value = new String[1];

        Map<String, BigDecimal> accumulator = new HashMap<>();

        for (int i = 0; i < comparatorForms.length; i++) {
            String prefix = comparatorForms[i] + comparatorRows[i].split("-")[0];
            int finalI = i;
            SubmissionFormat
                    .getStreamOfFormSubMap(prefix, Character.MAX_VALUE)
                    .forEach(entry -> {
                        if (entry.getValue().get(criteriaFields[finalI]).isEmpty()) return;

                        key[0] = entry.getValue().get(criteriaFields[finalI]);
                        if (!mapCriteria.containsKey(key[0])) return;
                        if (!mapCriteriaStatus.get(key[0])) return;

                        value[0] = entry.getValue().get(rangeFields[finalI]);
                        if (isInvalidNumeric(value[0])) {
                            mapCriteriaStatus.put(key[0], false);
                            return;
                        }

                        if (!mapCriteriaStatus.get(key[0])) return;

                        // mapCriteria.computeIfPresent(key[0], (k, v) -> v.add(new BigDecimal(value[0])));
                        accumulator.merge(key[0], new BigDecimal(value[0]), BigDecimal::add);
                    });
        }

        accumulator.forEach((k, v) ->
                mapCriteria.computeIfPresent(k, (mk, mv) -> mv.add(v)));

        return mapCriteria;
    }

    private String getErrorMessage(String[] errMsg, String condition) {
        String msg = "form '%1$s' dan '%2$s' pada kolom '%3$s' dengan kriteria\n\t'%4$s' pada kolom '%5$s'";
        return String.format(msg, errMsg[0], errMsg[1], errMsg[2], condition, errMsg[3]);
    }
}
