package id.go.ojk.asruk.client.builder.field.sa.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormSelfAssessmentUus;
import id.go.ojk.asruk.client.builder.field.sa.uus.reference.EHeaderMetadataSaUus;
import id.go.ojk.asruk.client.builder.field.sa.uus.reference.ER4103PosSaAsruu0204;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Sa0204 extends BaseMetadata {

	public Sa0204(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessmentUus eEnum = EFormSelfAssessmentUus.SA_0204;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 18, 18, null, ER4103PosSaAsruu0204.genFieldSave(),
				ER4103PosSaAsruu0204.getRequiredPos());
		res.addSegmentValidations(ER4103PosSaAsruu0204.genValidationNumericDot());
		res.addSegmentValidations(ER4103PosSaAsruu0204.genValidationMaxLengthNumericDot());
		res.addSegmentValidations(ER4103PosSaAsruu0204.genValidationNumeric());
		res.addSegmentValidations(ER4103PosSaAsruu0204.genValidationMaxLengthNumeric());
		res.addSegmentValidations(ER4103PosSaAsruu0204.genValidationPeringkat());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataSaUus.R4103_SA0204.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis", sv(M, 1, 5000, all)));
		return res;
	}
}
