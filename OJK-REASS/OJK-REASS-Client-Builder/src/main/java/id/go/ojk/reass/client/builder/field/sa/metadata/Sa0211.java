package id.go.ojk.reass.client.builder.field.sa.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reass.client.builder.field.EFormSelfAssessment;
import id.go.ojk.reass.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.reass.client.builder.field.sa.reference.ER4011PosSaReass0211;

public class Sa0211 extends BaseMetadata {

	public Sa0211(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0211;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 10, 10, null, null, ER4011PosSaReass0211.getRequiredPos());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoStrategis2());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoStrategis3());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoStrategis4());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoStrategis5());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoStrategis6());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoStrategis7());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoStrategis8());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoOperasional2());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoOperasional3());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoOperasional4());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoOperasional5());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoOperasional6());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoOperasional7());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoOperasional8());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoAsuransi2());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoAsuransi3());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoAsuransi4());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoAsuransi5());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoAsuransi6());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoAsuransi7());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoAsuransi8());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKredit2());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKredit3());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKredit4());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKredit5());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKredit6());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKredit7());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKredit8());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoPasar2());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoPasar3());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoPasar4());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoPasar5());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoPasar6());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoPasar7());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoPasar8());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoLikuiditas2());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoLikuiditas3());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoLikuiditas4());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoLikuiditas5());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoLikuiditas6());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoLikuiditas7());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoLikuiditas8());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoHukum2());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoHukum3());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoHukum4());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoHukum5());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoHukum6());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoHukum7());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoHukum8());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKepatuhan2());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKepatuhan3());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKepatuhan4());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKepatuhan5());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKepatuhan6());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKepatuhan7());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoKepatuhan8());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoReputasi2());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoReputasi3());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoReputasi4());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoReputasi5());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoReputasi6());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoReputasi7());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationRisikoReputasi8());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationPeringkatKomposit4());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationPeringkatKomposit7());
		res.addSegmentValidations(ER4011PosSaReass0211.genValidationPeringkatKomposit8());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataSa.R4011_SA0211.getObject())).confUnique(U));
		fs.add(sf(2, null, "Tingkat Risiko Inheren Individu (1-5)",
				sv(C, 1, 1, numeric).confConditionalRequired(ER4011PosSaReass0211.genConditionalA()))
				.addFieldValidations(ER4011PosSaReass0211.genValidationPeringkatA()));
		fs.add(sf(3, null, "Tingkat Kualitas Penerapan Manajemen Risiko Individu (1-5)",
				sv(C, 1, 1, numeric).confConditionalRequired(ER4011PosSaReass0211.genConditionalA()))
				.addFieldValidations(ER4011PosSaReass0211.genValidationPeringkatA()));
		fs.add(sf(4, null, "Tingkat Risiko Individu (1-5)", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4011PosSaReass0211.genValidationPeringkatA()));
		fs.add(sf(5, null, "Tingkat Risiko Inheren Konsolidasi (1-5)",
				sv(C, 1, 1, numeric).confConditionalRequired(ER4011PosSaReass0211.genConditionalB()))
				.addFieldValidations(ER4011PosSaReass0211.genValidationPeringkatB()));
		fs.add(sf(6, null, "Tingkat Kualitas Penerapan Manajemen Risiko Konsolidasi (1-5)",
				sv(C, 1, 1, numeric).confConditionalRequired(ER4011PosSaReass0211.genConditionalB()))
				.addFieldValidations(ER4011PosSaReass0211.genValidationPeringkatB()));
		fs.add(sf(7, null, "Tingkat Risiko Konsolidasi (1-5)", sv(O, 1, 1, numeric))
				.addFieldValidations(ER4011PosSaReass0211.genValidationPeringkatB()));
		fs.add(sf(8, null, "Analisis", sv(M, 1, 5000, all)));
		return res;
	}
}
