package id.go.ojk.asruk.client.builder.field.sa.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormSelfAssessment;
import id.go.ojk.asruk.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.asruk.client.builder.field.sa.reference.ER4008PosSaAsruk0208;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Sa0208 extends BaseMetadata {

	public Sa0208(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0208;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 10, 10, null, ER4008PosSaAsruk0208.genFieldSave(),
				ER4008PosSaAsruk0208.getRequiredPos());
		res.addSegmentValidations(ER4008PosSaAsruk0208.genValidationNumeric());
		res.addSegmentValidations(ER4008PosSaAsruk0208.genValidationMaxLengthNumeric1());
		res.addSegmentValidations(ER4008PosSaAsruk0208.genValidationMaxLengthNumeric2());
		res.addSegmentValidations(ER4008PosSaAsruk0208.genValidationMaxLengthNumeric3());
		res.addSegmentValidations(ER4008PosSaAsruk0208.genValidationPeringkat());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataSa.R4008_SA0208.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis", sv(M, 1, 5000, all)));
		return res;
	}
}
