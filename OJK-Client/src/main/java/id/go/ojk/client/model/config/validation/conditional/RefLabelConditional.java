package id.go.ojk.client.model.config.validation.conditional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.Comparation;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.lib.client.service.context.ApplicationContext;

/**
 * hanya membandingkan String
 * satu cocok langsung trueCondition
 *
 */
@XStreamAlias("refLabelConditional")
public class RefLabelConditional extends MapParamConditionalRequired {

	private RequiredCondition trueCondition;
	private RequiredCondition falseCondition;
	private int refFieldNumber;
	private int referenceNumber;
	private int referenceLabelNumber;
	private String referenceLabelName;
	private Comparation comparation;
	private List<String> comparationValues;
	

	public RefLabelConditional(){
	}

	public RefLabelConditional(String parameter){
		setParameter(parameter);
	}

	@XStreamOmitField
	private String label1ListDesc;
	
	@Override
	public ConditionalRequired initialized() {
		this.trueCondition = getRequiredConditionParameter("trueCondition");
		this.falseCondition = getRequiredConditionParameter("falseCondition");
		this.refFieldNumber = getIntParameter("refFieldNumber");
		this.referenceNumber = getIntParameter("referenceNumber");
		this.referenceLabelNumber = getIntParameter("referenceLabelNumber");
		this.referenceLabelName = getStringParameter("referenceLabelName");
		this.comparation = getComparationParameter("comparation");
		this.comparationValues = Arrays.asList(getStringArrayParameter("comparationValues"));
		
		return this;
	}
	
	private ReferenceService referenceService;
	@Override
	public void setApplicationContext(ApplicationContext appCtx) {
		super.setApplicationContext(appCtx);
		referenceService = appCtx.getService(ReferenceService.class);
		label1ListDesc = comparationValues.stream().map( e -> referenceService.getLabel1Description(referenceNumber, e)).collect(Collectors.joining(", "));
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat, ValidationResult validationResult) {
		String refValue =  validationResult.getColumn(refFieldNumber);
		SubmissionField leftField = submissionFormat.getFields().get(refFieldNumber);
		String refLabel = referenceService.getLabel(referenceNumber, referenceLabelNumber, refValue);
		if ( refLabel == null ) {
			//refLabel == null means reference not complete
			return Tupple2.<RequiredCondition, String>builder()
					.a(RequiredCondition.O)
					.b("")
					.build();
		}
		boolean evaluateResult = false;
		String conditionMessage = null;
		for (String comparationValue : comparationValues) {
			if ( evaluate(refLabel, comparation, comparationValue) ){
				String label1Desc = referenceService.getLabel1Description(referenceNumber, comparationValue);
				conditionMessage = eOrNeCondition(leftField, comparation, true, label1Desc);
				//conditionMessage = eOrNeCondition(leftField, comparation, true, comparationValue);
				evaluateResult = true;
				break;
			}

		}
		if ( !evaluateResult ){
			//String label1Desc = comparationValues.stream().map( e -> referenceService.getLabel1Description(referenceNumber, e)).collect(Collectors.joining(", "));
			conditionMessage = eOrNeCondition(leftField, comparation, false, label1ListDesc );
			//conditionMessage = eOrNeCondition(leftField, comparation, false, StringUtils.join(comparationValues, ", ") );
		}

		RequiredCondition requiredCondition = evaluateResult ? trueCondition : falseCondition ;

		return Tupple2.<RequiredCondition, String>builder()
			.a(requiredCondition)
			.b(conditionMessage)
			.build();
	}

	private boolean evaluate(String lefValue, Comparation comparation, String rightValue){
		if ( comparation == Comparation.e ) {
			return lefValue.equals(rightValue);
		} else if (comparation == Comparation.ne) {
			return !lefValue.equals(rightValue);
		} else {
			return false;
		}
	}

	private String eOrNeCondition(SubmissionField leftField, Comparation comparation, boolean isTrue, String rightValue){
		return StringUtils.join(
			leftField.getName(),
			(StringUtils.isEmpty(referenceLabelName) ? "" : " " + referenceLabelName),  
			isTrue ? " " : " tidak ",
			comparation.getDesc(),
			" ",
			rightValue
			);
	}


}
