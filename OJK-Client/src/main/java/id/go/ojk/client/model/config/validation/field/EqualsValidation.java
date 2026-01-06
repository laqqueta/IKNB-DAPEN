package id.go.ojk.client.model.config.validation.field;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("EqualsValidation")
public class EqualsValidation extends MapParamFieldValidation {
	protected String fieldComparator;

	public EqualsValidation() { }

	public EqualsValidation(String parameter) {
		setParameter(parameter);
	}

	@Override
	public EqualsValidation initialized() {
		fieldComparator = getStringParameter("fieldComparator");
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		Logger logger = LoggerFactory.getLogger(EqualsValidation.class);
		String[] arrFieldComparator = StringUtils.split(fieldComparator, "|");
		if (arrFieldComparator != null) {
			for (int i = 0; i < arrFieldComparator.length; i++) {
				String comparatorValue = validationResult.getColumn(Integer.parseInt(arrFieldComparator[i]));
				String realValue = validationResult.getColumn(field.getNumber());
				if (!realValue.equals(comparatorValue)) {
					logger.error("{}|{}?{}", parameter, realValue, comparatorValue);
					validationResult.errors.add(new ValidationError(field, ValidationErrorCode.E11_07_EQUAL,
							genMessage(arrFieldComparator)));
					break;
				}
			}
		}
	}
	
	private String genMessage(String[] arrFieldComparator) {
		StringBuilder res = new StringBuilder("nilai kolom ");
		int length = arrFieldComparator.length;
		for (int i = 0; i < length; i++) {
			res.append(Integer.parseInt(arrFieldComparator[i]) + 1);
			if (i + 1 < length) {
				res.append(" dan kolom ");
			}
		}
		return res.toString();
	}
}
