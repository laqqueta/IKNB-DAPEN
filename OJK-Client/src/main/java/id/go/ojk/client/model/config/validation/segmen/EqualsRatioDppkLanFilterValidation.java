package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.config.validation.UtilValidation;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@XStreamAlias("EqualsRatioDppkLanFilterValidation")
@Slf4j
public class EqualsRatioDppkLanFilterValidation extends BaseDecimalValidation {
    private String comparator1RowCode;
    private String comparator2RowCode;
    private String fieldRow1;
    private String fieldRow2;
    private String message;

    private String filterField;
    private String filterValue;

    private final AtomicReference<String> filterVal = new AtomicReference<>();

    public EqualsRatioDppkLanFilterValidation() {
        super();
    }

    public EqualsRatioDppkLanFilterValidation(String parameter) {
        super(parameter);
    }

    @Override
    public EqualsRatioDppkLanFilterValidation initialized() {
        super.initialized();
        comparator1RowCode = getStringParameter("comparator1RowCode");
        comparator2RowCode = getStringParameter("comparator2RowCode");
        fieldRow1 = getStringParameter("fieldRow1");
        fieldRow2 = getStringParameter("fieldRow2");
        message = getStringParameter("message");
        filterField = getStringParameter("filterField");
        filterValue = getStringParameter("filterValue");
        return this;
    }

    private BigDecimal getComparator1Value(String column, String comparatorRow) {
        return UtilValidation.calculateColumn(SubmissionFormat.mapPosValue, comparatorRow, column, scale, filterField, filterVal.get());
    }

    private BigDecimal getComparator2Value(String column) {
        return UtilValidation.calculateColumn(SubmissionFormat.mapPosValue, comparator2RowCode, column, scale, filterField, filterVal.get());
    }

    private BigDecimal getComparatorValue(String column, String comparatorRow) {
        BigDecimal value1 = getComparator1Value(column, comparatorRow);
        BigDecimal value2 = getComparator2Value(fieldRow2);
        if (value1.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        return value2.compareTo(BigDecimal.ZERO) != 0 ?
                value1
                .divide(value2, MathContext.DECIMAL128) : BigDecimal.ZERO;
    }

    private BigDecimal getCurrentValue(ValidationResult validationResult, String column) {
        return UtilValidation.toBigDecimal(validationResult.getColumn(Integer.parseInt(column)), "0");
    }

    @Override
    public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat,
                         ValidationResult validationResult) {
        String currentRowCode = validationResult.getColumn(1);
        LinkedList<String> selectPosCodes = Arrays.stream(StringUtils.split(selectPosCode, "|"))
                .collect(Collectors.toCollection(LinkedList::new));

        if (selectPosCodes.contains(currentRowCode)) {

            List<String> filters = Arrays.asList(StringUtils.split(filterValue, "|"));
            String filterFieldValue = validationResult.getColumn(Integer.parseInt(filterField));

            if (!filters.contains(filterFieldValue)) return;

            filterVal.set(filterFieldValue);

            String[] arrColumn = StringUtils.split(selectField, "|");
            String[] dividends = StringUtils.split(fieldRow1, "|");

            int currentRowIndex = selectPosCodes.indexOf(currentRowCode);

            for (int i = 0; i < arrColumn.length; i++) {
                String column = arrColumn[i];
                String divCol = dividends[i];
                BigDecimal comparatorValue = getComparatorValue(divCol, selectPosCodes.get(currentRowIndex))
                        .multiply(BigDecimal.valueOf(100.00), MathContext.DECIMAL128)
                        .setScale(2, RoundingMode.HALF_UP);;

                BigDecimal currentValue = getCurrentValue(validationResult, column);

                if (currentValue.compareTo(comparatorValue) != 0) {
                    log.error("{}->{}?{}", parameter, currentValue, comparatorValue);
                    List<SubmissionField> fields = submissionFormat.getFields();
                    SubmissionField submissionField = fields.get(Integer.parseInt(column));
                    SubmissionField errJenisProgram = fields.get(Integer.parseInt(filterField));
                    SubmissionField errField = fields.get(Integer.parseInt(divCol));

                    validationResult.errors.add(new ValidationError(submissionField,
                            ValidationErrorCode.E99_00_OTHER,
                            String.format("nilai harus = kolom '%s' / kolom %s '%s' * 100 pada '%s' = %s ",
                                    errField.getName(), errField.getName(), message, errJenisProgram.getName(), filterVal.get())));
                }
            }
        }
    }
}