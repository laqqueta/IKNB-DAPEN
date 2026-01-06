package id.go.ojk.client.model.config.validation.conditional;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationError;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.validation.ValidationUtil;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

/**
 * comparation untuk string harus equal atau not equal <br/>
 * Membandingkan refField dengan comparationValue
 * Jika selain e, ne dan na maka akan membandingkan Long <br/>
 *
 */
@XStreamAlias("comparisonConditional")
public class ComparisonConditional extends MapParamConditionalRequired {

	@XStreamAsAttribute private RequiredCondition trueCondition;
	@XStreamAsAttribute private RequiredCondition falseCondition;

	@XStreamAsAttribute private int refFieldNumber;
	@XStreamAsAttribute private Comparation comparation;
	@XStreamAsAttribute private String comparationValue;

	public ComparisonConditional(){
	}

	public ComparisonConditional(String parameter){
		setParameter(parameter);
	}

	@Override
	public ComparisonConditional initialized() {
		this.trueCondition = getRequiredConditionParameter("trueCondition");
		this.falseCondition = getRequiredConditionParameter("falseCondition");
		this.refFieldNumber = getIntParameter("refFieldNumber");
		this.comparation = getComparationParameter("comparation");
		this.comparationValue = getStringParameter("comparationValue");

		return this;
	}


	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat, ValidationResult validationResult) {
		String refValue =  validationResult.getColumn(refFieldNumber);

		Tupple2<Boolean, String> tmp = evaluate(submissionFormat.getFields().get(refFieldNumber), refValue, comparation, comparationValue, validationResult.errors);

		RequiredCondition requiredCondition = tmp.getA() ? trueCondition : falseCondition;
		return Tupple2.<RequiredCondition, String>builder()
			.a(requiredCondition)
			.b(tmp.getB())
			.build();
	}

	private Tupple2<Boolean, String> evaluate(SubmissionField leftField, String leftValue, Comparation comparation, String rightValue, List<ValidationError> errors){
		if ( comparation == Comparation.e ) {
			boolean res = leftValue.equals(rightValue);
			return Tupple2.<Boolean, String>builder()
					.a(res)
					.b(eOrNeCondition(leftField, Comparation.e, res, rightValue))
					.build() ;
		} else if (comparation == Comparation.ne) {
			boolean res = !leftValue.equals(rightValue);
			return Tupple2.<Boolean, String>builder()
					.a(res)
					.b(eOrNeCondition(leftField, Comparation.ne, res, rightValue))
					.build() ;
		} else if (comparation == Comparation.na) {
			//shout not happen
			return Tupple2.<Boolean, String>builder()
					.a(true)
					.b("")
					.build();
		} else {
//			Long leftValueLong = ValidationUtil.validateLong(leftField, leftValue, errors);
//			Long rightValueLong = ValidationUtil.validateLong(null, rightValue, errors);
			
			Long leftValueLong = ValidationUtil.validateLong(leftField, leftValue, null);
			Long rightValueLong = ValidationUtil.validateLong(null, rightValue, null);


			if ( leftValueLong != null && rightValueLong != null ){
				boolean res = comparation.testCompareLong(leftValueLong, rightValueLong);
				return Tupple2.<Boolean, String>builder()
						.a(res)
						.b(eOrNeCondition(leftField, comparation, res, rightValue))
						.build() ;
			} else {
				return Tupple2.<Boolean, String>builder()
						.a(true)
						.b("")
						.build();
			}
		}
	}

	private String eOrNeCondition(SubmissionField leftField, Comparation comparation, boolean isTrue, String rightValue){
		return StringUtils.join(
			leftField.getName(),
			isTrue ? " " : " tidak ",
			comparation.getDesc(),
			" ",
			rightValue
			);
	}
}
