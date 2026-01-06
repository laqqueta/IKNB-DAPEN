package id.go.ojk.client.model.config.validation.field;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("EqualsDivisionValidationForm")
public class EqualsDivisionValidationForm extends MapParamFieldValidation {
	protected String selectedIndex;
	protected String selectedResultIndex;
	protected String comparedForm;
	protected String comparedCode;
	protected String comparedIndex;
	protected int scale;
	protected String errorMessage;
	protected int multiplier;

	private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
	private static final int DEFAULT_PRECISION = 10;
	private final Logger logger = LoggerFactory.getLogger(EqualsDivisionValidationForm.class);

	public EqualsDivisionValidationForm() { }

	public EqualsDivisionValidationForm(String parameter) {
		setParameter(parameter);
	}

	@Override
	public EqualsDivisionValidationForm initialized() {
		this.selectedIndex = getStringParameter("selectedIndex");
		this.selectedResultIndex = getStringParameter("selectedResultIndex");
		this.comparedForm = getStringParameter("comparedForm");
		this.comparedCode = getStringParameter("comparedCode");
		this.comparedIndex = getStringParameter("comparedIndex");
		this.errorMessage = getStringParameter("errorMessage");
		this.scale = getIntParameter("scale", 2);
		this.multiplier = getIntParameter("multiplier", 100);
		return this;
	};

	@Override
	public void validate(SubmissionFormat submissionFormat, SubmissionField field, ValidationResult validationResult) {
		BigDecimal dividedValue = this.getValueByIndex(validationResult, this.selectedIndex);
		BigDecimal divisorValue = this.getComparedValue(this.comparedForm, this.comparedCode, this.comparedIndex);
		BigDecimal resultValue = this.getValueByIndex(validationResult, this.selectedResultIndex);

		BigDecimal comparedResultValue = BigDecimal.ZERO.setScale(this.scale, ROUNDING_MODE);
		try {
			comparedResultValue = dividedValue.divide(divisorValue, DEFAULT_PRECISION, ROUNDING_MODE);
			comparedResultValue = comparedResultValue.multiply(new BigDecimal(this.multiplier), new MathContext(DEFAULT_PRECISION, ROUNDING_MODE));
			comparedResultValue = comparedResultValue.setScale(2, ROUNDING_MODE);
		} catch (ArithmeticException e) {
			logger.error(e.getMessage());
		}

		if(resultValue.compareTo(comparedResultValue) != 0) {
			logger.error("{{}} {}/{} == {} != {}", this.parameter, dividedValue, divisorValue, comparedResultValue, resultValue);
			List<SubmissionField> fields = submissionFormat.getFields();
			SubmissionField submissionField = fields.get(Integer.parseInt(selectedResultIndex));
			validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E50_02_FORMULA, resultValue, this.errorMessage));
		}
	}

	private BigDecimal getValueByIndex(ValidationResult validationResult, String index) {
		try {
			BigDecimal bd = new BigDecimal(validationResult.getColumn(Integer.parseInt(index)));
			bd.setScale(this.scale, ROUNDING_MODE);
			return bd;
		} catch (NumberFormatException e) {
			return BigDecimal.ZERO;
		}
	}

	private BigDecimal getComparedValue(String form, String code, String index) {
		for (Entry<String, Map<String, String>> entry : SubmissionFormat.mapPosValueForm.entrySet()) {
			if (entry.getKey().startsWith(form)) {
				String[] items = entry.getKey().split("-");
				if (items[0].endsWith(code)) {
					try {
						BigDecimal bd = new BigDecimal(entry.getValue().get(index));
						bd.setScale(this.scale, ROUNDING_MODE);
						return bd;
					} catch (NumberFormatException e) {
						return BigDecimal.ZERO;
					}
				}
			}
		}
		return BigDecimal.ZERO;
	}
}
