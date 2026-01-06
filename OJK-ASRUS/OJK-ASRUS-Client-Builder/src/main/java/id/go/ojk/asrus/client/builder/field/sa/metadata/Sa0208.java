package id.go.ojk.asrus.client.builder.field.sa.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormSelfAssessment;
import id.go.ojk.asrus.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.asrus.client.builder.field.sa.reference.ER4008PosSaAsrus0208;
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
				new ArrayList<>(), extension, 18, 18, null, ER4008PosSaAsrus0208.genFieldSave(),
				ER4008PosSaAsrus0208.getRequiredPos());
		res.addSegmentValidations(ER4008PosSaAsrus0208.genValidationNumeric());
		res.addSegmentValidations(ER4008PosSaAsrus0208.genValidationMaxLengthNumeric1());
		res.addSegmentValidations(ER4008PosSaAsrus0208.genValidationMaxLengthNumeric2());
		res.addSegmentValidations(ER4008PosSaAsrus0208.genValidationMaxLengthNumeric3());
		res.addSegmentValidations(ER4008PosSaAsrus0208.genValidationPeringkat1());
		res.addSegmentValidations(ER4008PosSaAsrus0208.genValidationPeringkat2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataSa.R4008_SA0208.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis",
				sv(C, 1, 5000, all).confConditionalRequired(ER4008PosSaAsrus0208.genConditional2())));
		return res;
	}
}
