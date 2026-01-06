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
import id.go.ojk.asruk.client.builder.field.sa.uus.reference.ER4100PosSaAsruu0201;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Sa0201 extends BaseMetadata {

	public Sa0201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessmentUus eEnum = EFormSelfAssessmentUus.SA_0201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 27, 27, null, ER4100PosSaAsruu0201.genFieldSave(),
				ER4100PosSaAsruu0201.getRequiredPos());
		res.addSegmentValidations(ER4100PosSaAsruu0201.genValidationNumericDot());
		res.addSegmentValidations(ER4100PosSaAsruu0201.genValidationMaxLengthNumericDot());
		res.addSegmentValidations(ER4100PosSaAsruu0201.genValidationNumeric());
		res.addSegmentValidations(ER4100PosSaAsruu0201.genValidationMaxLengthNumeric());
		res.addSegmentValidations(ER4100PosSaAsruu0201.genValidationPeringkat());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataSaUus.R4100_SA0201.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis", sv(M, 1, 5000, all)));
		return res;
	}
}
