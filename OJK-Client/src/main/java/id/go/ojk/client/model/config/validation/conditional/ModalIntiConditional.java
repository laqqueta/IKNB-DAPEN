package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

/**
 * Nilai Modal Inti < ModalIntiDelimiter : harus kosong Nilai Modal Inti >=
 * ModalIntiDelimiter : wajib diisi
 */
@XStreamAlias("modalIntiConditional")
public class ModalIntiConditional extends MapParamConditionalRequired {

	private RequiredCondition trueCondition;
	private RequiredCondition falseCondition;
	private Double modalIntiDelimiter;
	private String textMIDelimiter;

	public ModalIntiConditional() {
	}

	public ModalIntiConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public ModalIntiConditional initialized() {
		this.trueCondition = getRequiredConditionParameter("trueCondition");
		this.falseCondition = getRequiredConditionParameter("falseCondition");
		this.modalIntiDelimiter = getDoubleParameter("modalIntiDelimiter");
		this.textMIDelimiter = getStringParameter("textMIDelimiter");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		String conditionMessage = null;
		double modalIntiValue = Double.parseDouble(SubmissionFormat.modalInti.get(0));

		if (modalIntiValue < modalIntiDelimiter) {
			conditionMessage = "karena Modal Inti < " + textMIDelimiter;
			return Tupple2.<RequiredCondition, String>builder().a(falseCondition).b(conditionMessage).build();
		} else {
			conditionMessage = "karena Modal Inti >= " + textMIDelimiter;
			return Tupple2.<RequiredCondition, String>builder().a(trueCondition).b(conditionMessage).build();
		}
	}
}