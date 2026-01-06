package id.go.ojk.asrjs.client.builder.field.sa.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormSelfAssessment;
import id.go.ojk.asrjs.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.asrjs.client.builder.field.sa.reference.ER4010PosSaAsrjs0210;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Sa0210 extends BaseMetadata {

	public Sa0210(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0210;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 6, 6, null, ER4010PosSaAsrjs0210.genFieldSave(),
				ER4010PosSaAsrjs0210.getRequiredPos());
		res.addSegmentValidations(ER4010PosSaAsrjs0210.genValidationNumeric());
		res.addSegmentValidations(ER4010PosSaAsrjs0210.genValidationMaxLengthNumeric());
		res.addSegmentValidations(ER4010PosSaAsrjs0210.genValidationPeringkat1());
		res.addSegmentValidations(ER4010PosSaAsrjs0210.genValidationPeringkat2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataSa.R4010_SA0210.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis",
				sv(C, 1, 5000, all).confConditionalRequired(ER4010PosSaAsrjs0210.genConditional2())));
		fs.add(sf(3, null, "Peringkat Resiko",
				sv(C, 1, 25, all).confConditionalRequired(ER4010PosSaAsrjs0210.genConditional3()))
						.addFieldValidations(ER4010PosSaAsrjs0210.genValidationPeringkat3A())
						.addFieldValidations(ER4010PosSaAsrjs0210.genValidationPeringkat3B()));
		return res;
	}
}
