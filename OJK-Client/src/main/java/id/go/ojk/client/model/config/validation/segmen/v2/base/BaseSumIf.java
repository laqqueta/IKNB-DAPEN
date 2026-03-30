package id.go.ojk.client.model.config.validation.segmen.v2.base;

import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.config.validation.segmen.model.SumIfData;
import id.go.ojk.client.model.config.validation.segmen.v2.params.SumIfBaseParams;
import id.go.ojk.client.model.validation.ValidationResult;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public abstract class BaseSumIf<T extends SumIfBaseParams> extends BaseRowValidation {

    protected String comparatorForm;
    protected String comparatorRow;
    protected String rangeField;
    protected String criteriaField;
    protected String criteriaCondition;
    protected String sumCriteriaCondition;
    protected String msgError;
    protected String criteriaConditionError;
    protected String sumConditionError;
    protected String sumField;

    /*
     * for sum field, criteria, and error are optional
     *
     * criteriaAsKey are 0 based index
     * */

    public BaseSumIf() {
    }

    public BaseSumIf(String parameter) {
        super(parameter);
    }

    @Override
    public BaseSumIf<T> initialized() {
        super.initialized();

        comparatorForm = getStringParameter("comparatorForm");
        comparatorRow = getStringParameter("comparatorRow");
        rangeField = getStringParameter("rangeField");
        criteriaField = getStringParameter("criteriaField");
        sumField = getStringParameter("sumField");
        criteriaCondition = getStringParameter("criteriaCondition");
        sumCriteriaCondition = getStringParameter("sumCriteriaCondition");
        msgError = getStringParameter("msgError");
        criteriaConditionError = getStringParameter("criteriaConditionError");
        sumConditionError = getStringParameter("sumConditionError");

        return this;
    }

    protected abstract Map<String, BigDecimal> mappingCriteria(T params);

    protected SumIfData calculateCondition(List<String> sumConditions, T params) {
        SumIfData data = new SumIfData();

        List<String> tmp = new ArrayList<>();
        Set<String> ext = new HashSet<>(Arrays.asList(params.getCriteriaConditions()));

        sumConditions.forEach(s -> {
            if (ext.add(s)) {
                tmp.add(s);
            }
        });

        params.setCriteriaConditions(ext.toArray(new String[0]));

        Map<String, BigDecimal> mappedCriteria = mappingCriteria(params);

        data.setSum(mappedCriteria.entrySet()
                .stream()
                .filter(e -> sumConditions.contains(e.getKey()))
                .map(Map.Entry::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add));


        for (String s : tmp) {
            mappedCriteria.remove(s);
        }

        data.setMappedData(mappedCriteria);

        return data;
    }

    protected SumIfData calculateCondition(T params) {
        Map<String, BigDecimal> mappedCriteria = mappingCriteria(params);

        SumIfData data = new SumIfData();
        data.setMappedData(mappedCriteria);

        return data;
    }

    protected BigDecimal scaledDecimal(double d) {
        return BigDecimal.valueOf(d)
                .setScale(2, RoundingMode.HALF_UP);
    }

    protected boolean isInvalidNumeric(String s) {
        return super.isInvalidNumeric(s);
    }

    protected BigDecimal getCurrentValue(ValidationResult validationResult, String idxField) {
        return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(idxField)));
    }

    protected String slashFormatError(String errorData) {
        String[] errs = StringUtils.split(errorData, "|");

        if (errs.length == 0) return errorData;
        return String.join(" / ", errs);
    }

}
