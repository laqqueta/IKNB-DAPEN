package id.go.ojk.reass.client.builder.field.sa.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reass.client.builder.field.EFormSelfAssessment;
import id.go.ojk.reass.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.reass.client.builder.field.sa.reference.ER4012PosSaReass0300;

public class Sa0300 extends BaseMetadata {

	public Sa0300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 21, 21, null, ER4012PosSaReass0300.genFieldSave(), ER4012PosSaReass0300.getRequiredPos());
		res.addSegmentValidations(ER4012PosSaReass0300.genValidationNumericDot());
		res.addSegmentValidations(ER4012PosSaReass0300.genValidationMaxLengthNumericDot());
		res.addSegmentValidations(ER4012PosSaReass0300.genValidationNumeric());
		res.addSegmentValidations(ER4012PosSaReass0300.genValidationMaxLengthNumeric1());
		res.addSegmentValidations(ER4012PosSaReass0300.genValidationMaxLengthNumeric2());
		res.addSegmentValidations(ER4012PosSaReass0300.genValidationPeringkat1());
		res.addSegmentValidations(ER4012PosSaReass0300.genValidationPeringkat2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataSa.R4012_SA0300.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis",
				sv(C, 1, 5000, all).confConditionalRequired(ER4012PosSaReass0300.genConditional2())));
		return res;
	}
}
