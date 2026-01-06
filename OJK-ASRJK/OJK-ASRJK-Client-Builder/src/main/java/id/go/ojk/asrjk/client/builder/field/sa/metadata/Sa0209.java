package id.go.ojk.asrjk.client.builder.field.sa.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormSelfAssessment;
import id.go.ojk.asrjk.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.asrjk.client.builder.field.sa.reference.ER4009PosSaAsrjk0209;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Sa0209 extends BaseMetadata {

	public Sa0209(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0209;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 11, 11, null, ER4009PosSaAsrjk0209.genFieldSave(),
				ER4009PosSaAsrjk0209.getRequiredPos());
		res.addSegmentValidations(ER4009PosSaAsrjk0209.genValidationNumericDotNegative());
		res.addSegmentValidations(ER4009PosSaAsrjk0209.genValidationMaxLengthNumericDotNegative());
		res.addSegmentValidations(ER4009PosSaAsrjk0209.genValidationNumeric());
		res.addSegmentValidations(ER4009PosSaAsrjk0209.genValidationMaxLengthNumeric1());
		res.addSegmentValidations(ER4009PosSaAsrjk0209.genValidationMaxLengthNumeric2());
		res.addSegmentValidations(ER4009PosSaAsrjk0209.genValidationPeringkat());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataSa.R4009_SA0209.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis", sv(M, 1, 5000, all)));
		return res;
	}
}
