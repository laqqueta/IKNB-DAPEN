package id.go.ojk.client.model.config.validation.segmen;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.bind.ProgressPreparationAndSending.SubmissionData;

@XStreamAlias("PeriodeYearValidation")
public class PeriodeYearValidation extends BasePeriodValidation {
	
	public PeriodeYearValidation() {
		super();
	}
	
	public PeriodeYearValidation(String parameter) {
		super(parameter);
	}
	
	@Override
	public PeriodeYearValidation initialized() {
		super.initialized();
		return this;
	}

	@Override
	protected String getPeriod(SubmissionData submissionData) {
		return submissionData.getDataYear();
	}
}