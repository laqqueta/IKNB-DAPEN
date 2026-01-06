package id.go.ojk.client.model.config.validation.conditional;

import java.util.List;
import java.util.Map;

import org.apache.commons.net.util.ToStringList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.client.service.ReferenceService;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

/*
 * Jika value tidak terdapat di referensi 'referenceNumber', maka return 'referenceFalseCondition'
 * sebagai trueCondition.
 * Jika value terdapat di referensi 'referenceNumber', atau 'referenceNumber' tidak ditemukan,
 * maka teruskan seperti validasi AllExistPosConditional
 */
@XStreamAlias("AllExistPosConditionalAndInReference")
public class AllExistPosConditionalAndInReference extends AllExistConditional {
	protected String selectPosCode;
	@XStreamOmitField
	protected List<String> listSelectPosCode;
  private int referenceNumber;
  private RequiredCondition referenceFalseCondition;
	
	public AllExistPosConditionalAndInReference() {
	}

	public AllExistPosConditionalAndInReference(String parameter) {
		setParameter(parameter);
	}

	@Override
	public AllExistPosConditionalAndInReference initialized() {
		super.initialized();
		this.selectPosCode = getStringParameter("selectPosCode");
		this.listSelectPosCode = ToStringList.convert(selectPosCode, "|");
    this.referenceNumber = getIntParameter("referenceNumber");
    this.referenceFalseCondition = getRequiredConditionParameter("referenceFalseCondition");
		return this;
	}
	
	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
    ReferenceService referenceService = appCtx.getService(ReferenceService.class);
    Map<String, String> referenceMap = referenceService.getReference(referenceNumber);

		String currentPosCode = validationResult.getColumn(1);
		if (referenceMap != null) {
      if (!referenceMap.containsKey(currentPosCode)) {
        return Tupple2.<RequiredCondition, String>builder().a(referenceFalseCondition == null ? 
            RequiredCondition.O : referenceFalseCondition).b("").build();
      }
    }

		return listSelectPosCode.contains(currentPosCode) ? super.analizeRequiredCondition(submissionFormat, validationResult) : 
			Tupple2.<RequiredCondition, String>builder().a(falseCondition).b("").build();
	}
}
