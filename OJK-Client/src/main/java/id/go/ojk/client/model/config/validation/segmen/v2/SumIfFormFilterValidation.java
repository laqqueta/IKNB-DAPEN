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
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@XStreamAlias("SumIfFormFilterValidation")
public class SumIfFormFilterValidation extends BaseSumIf<SumIfBaseParams> {

    private String multiRangeFieldErr;
    private String filterColumn;
    private String filterValues;

    private final AtomicReference<String> filterVal = new AtomicReference<>();

    public SumIfFormFilterValidation(String parameter) {
        super(parameter);
    }

    @Override
    public SumIfFormFilterValidation initialized() {
        super.initialized();

        multiRangeFieldErr = getStringParameter("multiRangeFieldErr");
        filterColumn = getStringParameter("filterColumn");
        filterValues = getStringParameter("filterValues");

        return this;
    }

    @Override
    public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        LinkedList<String> selectRowCodes = Arrays.stream(StringUtils.split(selectPosCode, "|"))
                .collect(Collectors.toCollection(LinkedList::new));

        if (selectRowCodes.contains(currentRowCode)) {
            final Logger logger = LoggerFactory.getLogger(SumIfFormFilterValidation.class);

            List<String> filters = Arrays.asList(StringUtils.split(filterValues, "|"));
            String filterFieldValue = validationResult.getColumn(Integer.parseInt(filterColumn));

            if (!filters.contains(filterFieldValue)) return;

            String[] arrRangeFields = StringUtils.split(rangeField, "|");
            String[] conds = StringUtils.split(criteriaCondition, "|");
            String[] condErrors = StringUtils.split(criteriaConditionError, "|");
            String[] arrColumn = StringUtils.split(selectField, "|");
            List<String> listCol = Arrays.asList(arrColumn);

            int rowIdx = arrRangeFields.length == 0 ? 0 : selectRowCodes.indexOf(currentRowCode);
            SumIfData formulaData;
            SumIfBaseParams param = new SumIfBaseParams(conds, arrRangeFields[rowIdx]);

            filterVal.set(filterFieldValue);

            if (sumCriteriaCondition == null) {
                formulaData = calculateCondition(param);
            } else {
                List<String> sumCriteria = Arrays.stream(StringUtils.split(sumCriteriaCondition, "|"))
                        .collect(Collectors.toList());

                formulaData = calculateCondition(sumCriteria, param);
            }

            String tmp = "";

            for (int i = 0; i < arrColumn.length; i++) {
                String idxField = arrColumn[i];
                BigDecimal selectValue = getCurrentValue(validationResult, idxField);
                BigDecimal condsValue;

                // g
                // e
                //  Iuran Sukarela Peserta
                // Iuran Tambahan

                if (sumField != null & idxField.equals(sumField)) {
                    condsValue = formulaData.getSum();
                } else {
                    if (sumField == null) condsValue = formulaData.getMappedData().get(conds[i]);
                    else {
                        // LPHU0604000000
                        condsValue = formulaData.getMappedData().get(conds[listCol.indexOf(arrColumn[i]) - 1]);
                        tmp = conds[listCol.indexOf(arrColumn[i]) - 1];
                    }
                }

                if (selectValue.compareTo(condsValue) != 0) {
                    String[] msgErrors = StringUtils.split(msgError, "|");
                    List<SubmissionField> fields = submissionFormat.getFields();
                    SubmissionField submissionField = fields.get(Integer.parseInt(idxField));
                    SubmissionField sfJenisProgram = fields.get(Integer.parseInt(filterColumn));
                    logger.error("{}>{}?{}", parameter, selectValue, condsValue);

                    String condError;

                    if (sumField != null & idxField.equals(sumField)) {
                        condError = slashFormatError(sumConditionError);
                    } else {
                        if (sumField == null) condError = condErrors[i];
                        else condError = condErrors[listCol.indexOf(arrColumn[i]) - 1];
                    }

                    String[] arrMultiRangeFieldErr = new String[0];
                    if (multiRangeFieldErr != null) {
                        arrMultiRangeFieldErr = StringUtils.split(multiRangeFieldErr, "|");
                    }

                    String columnErr = multiRangeFieldErr != null ? arrMultiRangeFieldErr[rowIdx]  : msgErrors[1];
                    String condColErr = multiRangeFieldErr != null ? msgErrors[1]  : msgErrors[2];
                    validationResult.errors.add(new ValidationError(submissionField,
                            ValidationErrorCode.E50_27_FORMULA_SUMIF_FILTER,
                            msgErrors[0], columnErr, condError, condColErr, sfJenisProgram.getName(), filterVal.get() ));
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

        final String[] key = new String[1];
        final String[] value = new String[1];

        Map<String, BigDecimal> accumulator = new HashMap<>();

        SubmissionFormat
                .getStreamOfFormSubMap(prefix, Character.MAX_VALUE)
                .forEach(entry -> {
                    if (entry.getValue().get(filterColumn) == null || !entry.getValue().get(filterColumn).equals(filterVal.get())) return;
                    if (entry.getValue().get(criteriaField).isEmpty()) return;

                    key[0] = entry.getValue().get(criteriaField);
                    if (!mapCriteria.containsKey(key[0])) return;
                    if (!mapCriteriaStatus.get(key[0])) return;

                    value[0] = entry.getValue().get(param.getRangeField());
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
