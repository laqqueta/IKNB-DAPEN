package id.go.ojk.client.model.config.validation.field;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.DateUtil;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("DateLessValidation")
public class DateLessValidation extends MapParamFieldValidation {
	protected String fieldComparator;

	public DateLessValidation() { }

	public DateLessValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public DateLessValidation initialized() {
		fieldComparator = getStringParameter("fieldComparator");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(DateLessValidation.class);
		try {
			int currentColumn = field.getNumber();
			String realValue = validationResult.getColumn(currentColumn);
			int comparatorColumn = Integer.parseInt(fieldComparator);
			String comparatorValue = validationResult.getColumn(comparatorColumn);
			if (StringUtils.isNoneEmpty(realValue, comparatorValue)) {
				LocalDate realDate = LocalDate.parse(realValue, DateUtil.dateTimeFormatterYYYYmmss);
				LocalDate comparatorDate = LocalDate.parse(comparatorValue, DateUtil.dateTimeFormatterYYYYmmss);
				if (!realDate.isBefore(comparatorDate)) {
					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E12_17_DATE_LESS,
							currentColumn + 1, comparatorColumn + 1));
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
