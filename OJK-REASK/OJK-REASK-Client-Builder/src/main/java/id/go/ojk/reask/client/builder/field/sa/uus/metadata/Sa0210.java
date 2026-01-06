package id.go.ojk.reask.client.builder.field.sa.uus.metadata;

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
import id.go.ojk.reask.client.builder.field.EFormSelfAssessment;
import id.go.ojk.reask.client.builder.field.sa.uus.reference.EHeaderMetadataSaUus;
import id.go.ojk.reask.client.builder.field.sa.uus.reference.ER4109PosSaReasu0210;

public class Sa0210 extends BaseMetadata {

	public Sa0210(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0210;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 5, 5, null, ER4109PosSaReasu0210.genFieldSave(), ER4109PosSaReasu0210.getRequiredPos());
		res.addSegmentValidations(ER4109PosSaReasu0210.genValidationNumeric());
		res.addSegmentValidations(ER4109PosSaReasu0210.genValidationMaxLengthNumeric());
		res.addSegmentValidations(ER4109PosSaReasu0210.genValidationPeringkat());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataSaUus.R4109_SA0210.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis", sv(M, 1, 5000, all)));
		fs.add(sf(3, null, "Peringkat Resiko",
				sv(C, 1, 25, all).confConditionalRequired(ER4109PosSaReasu0210.genConditional3()))
				.addFieldValidations(ER4109PosSaReasu0210.genValidationPeringkat3()));
		return res;
	}
}
