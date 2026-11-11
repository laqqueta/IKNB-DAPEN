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
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@XStreamAlias("SumIfMultiCriteriaFilterFormValidation2")
public class SumIfMultiCriteriaFilterFormValidation2 extends SumIfMultiCriteriaFilterFormValidation {

    private int criteriaAsKey; // 0 index based
    private String filterColumn;
    private String filterValues;

    private final AtomicReference<String> filterVal = new AtomicReference<>();

    public SumIfMultiCriteriaFilterFormValidation2(String parameter) {
        super(parameter);
    }

    @Override
    public SumIfMultiCriteriaFilterFormValidation2 initialized() {
        super.initialized();

        criteriaAsKey = getIntParameter("criteriaAsKey");
        filterColumn = getStringParameter("filterColumn");
        filterValues = getStringParameter("filterValues");

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
            final Logger logger = LoggerFactory.getLogger(SumIfMultiCriteriaFilterFormValidation2.class);

            List<String> filters = Arrays.asList(StringUtils.split(filterValues, "|"));
            String filterFieldValue = validationResult.getColumn(Integer.parseInt(filterColumn));

            if (!filters.contains(filterFieldValue)) return;

            String[] arrRangeFields = StringUtils.split(rangeField, "|");
            String[] arrColumn = StringUtils.split(selectField, "|");
            String[] criterias = StringUtils.split(criteriaCondition, "$");
            String[] criteriasError = StringUtils.split(criteriaConditionError, "$");

            String[] criteriaKey = StringUtils.split(criterias[criteriaAsKey], "|");
            String[] criteriaKeyError = StringUtils.split(criteriasError[criteriaAsKey], "|");

            List<String> criteriaConditions = criteriaConditions(criterias);
            List<String> criteriaConditionsError = criteriaConditions(criteriasError);

            int rangeRowIdx = arrRangeFields.length == 1 ? 0 : selectRowCodes.indexOf(currentRowCode);
            filterVal.set(filterFieldValue);

            SumIfData formulaData;
            SumIfMultiCriteriaParams param = new SumIfMultiCriteriaParams(criteriaKey, arrRangeFields[rangeRowIdx],
                    criteriaConditions);

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
                    SubmissionField sfJenisProgram = fields.get(Integer.parseInt(filterColumn));
                    logger.error("{}>{}?{}", parameter, selectValue, condsValue);

                    String criteriaError = idxField.equals(sumField) ?
                            slashFormatError(sumConditionError) :
                            criteriaKeyError[i-1];

                    validationResult.errors.add(new ValidationError(submissionField,
                            ValidationErrorCode.E50_28_FORMULA_MULTICRITERIASUMIF,
                            msgErrors[0], msgErrors[1], criteriaError, msgErrors[2],
                            multiAddCriteriaError(criteriaConditionsError), msgErrors[3], sfJenisProgram.getName(), filterVal.get() ));
                }

            }
        }
    }

    private String multiAddCriteriaError(List<String> criteriaConditionsError) {
        StringBuilder sb = new StringBuilder();

        for (String err : criteriaConditionsError) {
            sb.append(err)
                    .append(" Atau ");
        }

        return sb.substring(0, sb.length()-6);
    }

}
