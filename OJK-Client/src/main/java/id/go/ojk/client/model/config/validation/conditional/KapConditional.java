package id.go.ojk.client.model.config.validation.conditional;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.client.model.validation.ValidationResult;
import id.go.ojk.lib.client.model.Tupple2;
import id.go.ojk.lib.client.model.constant.RequiredCondition;

@XStreamAlias("kapConditional")
public class KapConditional extends MapParamConditionalRequired {

	//private RequiredCondition trueCondition;
	//private RequiredCondition falseCondition;

	public KapConditional() {
	}

	public KapConditional(String parameter) {
		setParameter(parameter);
	}

	@Override
	public KapConditional initialized() {
		//this.trueCondition = getRequiredConditionParameter("trueCondition");
		//this.falseCondition = getRequiredConditionParameter("falseCondition");
		return this;
	}

	@Override
	public Tupple2<RequiredCondition, String> analizeRequiredCondition(SubmissionFormat submissionFormat,
			ValidationResult validationResult) {
		String conditionMessage = null;
		Integer reportFormGroupCode = submissionFormat.getReportFormGroupCode();

//		if (reportFormGroupCode != 4) {
//			conditionMessage = "karena jenis laporan selain Laporan Penyesuaian Pengawas atau atas Permintaan KAP";
//			return Tupple2.<RequiredCondition, String>builder().a(falseCondition).b(conditionMessage).build();
//		} else {
//			conditionMessage = "karena jenis laporan adalah Laporan Penyesuaian Pengawas atau atas Permintaan KAP";
//			return Tupple2.<RequiredCondition, String>builder().a(trueCondition).b(conditionMessage).build();
//		}
		
		if (reportFormGroupCode == 3) {
			conditionMessage = "karena jenis laporan adalah Laporan Penyesuaian Pengawas";
			return Tupple2.<RequiredCondition, String>builder().a(RequiredCondition.O).b(conditionMessage).build();
		} else if (reportFormGroupCode == 4) {
			conditionMessage = "karena jenis laporan adalah Laporan Penyesuaian atas Permintaan KAP";
			return Tupple2.<RequiredCondition, String>builder().a(RequiredCondition.M).b(conditionMessage).build();
		} else {
			conditionMessage = "karena jenis laporan selain Laporan Penyesuaian Pengawas atau atas Permintaan KAP";
			return Tupple2.<RequiredCondition, String>builder().a(RequiredCondition.N).b(conditionMessage).build();
		}
	}
}