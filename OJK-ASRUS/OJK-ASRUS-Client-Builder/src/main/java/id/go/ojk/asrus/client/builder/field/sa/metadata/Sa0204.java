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
import id.go.ojk.asrus.client.builder.field.sa.reference.ER4004PosSaAsrus0204;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Sa0204 extends BaseMetadata {

	public Sa0204(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0204;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 21, 21, null, ER4004PosSaAsrus0204.genFieldSave(),
				ER4004PosSaAsrus0204.getRequiredPos());
		res.addSegmentValidations(ER4004PosSaAsrus0204.genValidationNumericDot());
		res.addSegmentValidations(ER4004PosSaAsrus0204.genValidationMaxLengthNumericDot());
		res.addSegmentValidations(ER4004PosSaAsrus0204.genValidationNumeric());
		res.addSegmentValidations(ER4004PosSaAsrus0204.genValidationMaxLengthNumeric());
		res.addSegmentValidations(ER4004PosSaAsrus0204.genValidationPeringkat1());
		res.addSegmentValidations(ER4004PosSaAsrus0204.genValidationPeringkat2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataSa.R4004_SA0204.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis",
				sv(C, 1, 5000, all).confConditionalRequired(ER4004PosSaAsrus0204.genConditional2())));
		return res;
	}
}
