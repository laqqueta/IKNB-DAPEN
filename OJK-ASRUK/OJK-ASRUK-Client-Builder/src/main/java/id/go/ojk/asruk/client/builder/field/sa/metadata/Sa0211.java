package id.go.ojk.asruk.client.builder.field.sa.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormSelfAssessment;
import id.go.ojk.asruk.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.asruk.client.builder.field.sa.reference.ER4011PosSaAsruk0211;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Sa0211 extends BaseMetadata {

	public Sa0211(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0211;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 10, 10, null, null, ER4011PosSaAsruk0211.getRequiredPos());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoStrategis2());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoStrategis3());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoOperasional2());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoOperasional3());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoAsuransi2());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoAsuransi2());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoKredit2());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoKredit3());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoPasar2());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoPasar3());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoLikuiditas2());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoLikuiditas3());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoHukum2());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoHukum3());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoKepatuhan2());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoKepatuhan3());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoReputasi2());
		res.addSegmentValidations(ER4011PosSaAsruk0211.genValidationRisikoReputasi3());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataSa.R4011_SA0211.getObject())).confUnique(U));
		fs.add(sf(2, null, "Tingkat Risiko Inheren (1-5)", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4011PosSaAsruk0211.genValidationPeringkat()));
		fs.add(sf(3, null, "Tingkat Kualitas Penerapan Manajemen Risiko (1-5)", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4011PosSaAsruk0211.genValidationPeringkat()));
		fs.add(sf(4, null, "Tingkat Risiko (1-5)", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4011PosSaAsruk0211.genValidationPeringkat()));
		return res;
	}
}
