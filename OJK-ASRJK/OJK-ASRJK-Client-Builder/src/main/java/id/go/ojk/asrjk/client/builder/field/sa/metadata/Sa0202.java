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
import id.go.ojk.asrjk.client.builder.field.sa.reference.ER4002PosSaAsrjk0202;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Sa0202 extends BaseMetadata {

	public Sa0202(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0202;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 32, 32, null, ER4002PosSaAsrjk0202.genFieldSave(),
				ER4002PosSaAsrjk0202.getRequiredPos());
		res.addSegmentValidations(ER4002PosSaAsrjk0202.genValidationNumericDotNegative());
		res.addSegmentValidations(ER4002PosSaAsrjk0202.genValidationMaxLengthNumericDotNegative());
		res.addSegmentValidations(ER4002PosSaAsrjk0202.genValidationNumeric());
		res.addSegmentValidations(ER4002PosSaAsrjk0202.genValidationMaxLengthNumeric1());
		res.addSegmentValidations(ER4002PosSaAsrjk0202.genValidationMaxLengthNumeric2());
		res.addSegmentValidations(ER4002PosSaAsrjk0202.genValidationPeringkat());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataSa.R4002_SA0202.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis", sv(M, 1, 5000, all)));
		return res;
	}
}
