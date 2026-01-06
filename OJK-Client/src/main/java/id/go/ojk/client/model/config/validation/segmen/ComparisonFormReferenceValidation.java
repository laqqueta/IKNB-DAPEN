package id.go.ojk.client.model.config.validation.segmen;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.validation.ValidationErrorCode;

@XStreamAlias("ComparisonFormReferenceValidation")
public class ComparisonFormReferenceValidation extends BaseRowValidation {
	private final Logger logger = LoggerFactory.getLogger(ComparisonFormReferenceValidation.class);
	private String comparedForm;
	private String comparedPosCode;
	private int comparedReferenceNumber;
	private int comparedReferenceIndex;
	private String comparedReferenceKey;
	private int comparedField;
	private String errorMessage;

	public ComparisonFormReferenceValidation() {
		super();
	}

	public ComparisonFormReferenceValidation(String parameter) {
		super(parameter);
	}

	@Override
	public ComparisonFormReferenceValidation initialized() {
		super.initialized();
		this.comparedReferenceNumber = getIntParameter("comparedReferenceNumber");
		this.comparedReferenceKey = getStringParameter("comparedReferenceKey");
		this.comparedReferenceIndex = getIntParameter("comparedReferenceIndex");
		this.comparedForm = getStringParameter("comparedForm");
		this.comparedPosCode = getStringParameter("comparedPosCode");
		this.comparedField = getIntParameter("comparedField");
		this.errorMessage = getStringParameter("errorMessage","");
		return this;
	}

	@Override
	public void validate(SubmissionData submissionData, SubmissionFormat submissionFormat, ValidationResult validationResult) {
		ReferenceService referenceService = appCtx.getService(ReferenceService.class);
		String[] selectedFields = selectField.split("[|]");
		String[] selectedPosCodes = selectPosCode.split("[|]");
		String posCode = validationResult.getColumn(1);
		List<String> comparedReferenceKeys = Arrays.asList(StringUtils.split(this.comparedReferenceKey, "|"));

		List<SubmissionField> fields = submissionFormat.getFields();
		for (String field : selectedFields) {
			SubmissionField submissionField = fields.get(Integer.parseInt(field));
			for (int i = 0; i < selectedPosCodes.length; i++) {
				if (posCode.contains(selectedPosCodes[i])) {
					Map<String, String> referenceKeyValues = referenceService.getReference(this.comparedReferenceNumber);
					Map<String, String> validReferences = referenceKeyValues.entrySet().stream()
							.filter(x -> comparedReferenceKeys.contains(x.getKey()))
							.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

					if(validReferences.isEmpty()) {
						validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E12_00_REFERENCE,
								referenceService.getReferenceDescription(this.comparedReferenceNumber)));
					} else {
						BigDecimal sumReferenceValue = BigDecimal.ZERO;
						for (String comparedReferenceKey : comparedReferenceKeys) {
							sumReferenceValue = sumReferenceValue.add(SubmissionFormat.getSumMapPosFormValueFilterByReference(this.comparedForm,
									String.valueOf(this.comparedPosCode),
									String.valueOf(this.comparedField),
									String.valueOf(this.comparedReferenceIndex),
									Arrays.asList(comparedReferenceKey)).setScale(2, RoundingMode.HALF_UP));

						}

						BigDecimal selectedValue = BigDecimal.ZERO;
						try {
							selectedValue = new BigDecimal(validationResult.getColumn(Integer.parseInt(selectField)));
						} catch (NumberFormatException e) {
							logger.error(e.getMessage(), e);
							return; //handle oleh field validation
						}
						if(sumReferenceValue.compareTo(selectedValue) != 0) {
							logger.info("SelectedValue={}, sumReferenceValue={}", selectedValue, sumReferenceValue.toPlainString());
							validationResult.errors.add(new ValidationError(submissionField, ValidationErrorCode.E50_02_FORMULA,
									sumReferenceValue, genErrorMessage(validationResult, validReferences)));
						}
					}
				}
			}
		}
	}

	private String genErrorMessage(ValidationResult validationResult, Map<String, String> reference) {
		if(!StringUtils.isEmpty(errorMessage)) {
			return errorMessage;
		}

		StringBuilder sb = new StringBuilder(Comparation.e.getDesc())
				.append(" total nilai form ").append(comparedForm)
				.append(" kode baris ").append(comparedPosCode)
				.append(" kolom ").append( (comparedField + 1))
				.append(" yang bernilai '").append(reference.get(comparedReferenceKey))
				.append(" (").append(comparedReferenceKey).append(")").append("'")
				.append(" pada kolom ").append((comparedReferenceIndex + 1))
				;
		return sb.toString();
	}
}