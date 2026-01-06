package id.go.ojk.reask.client.builder.field.sa.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormSelfAssessmentUus;
import id.go.ojk.reask.client.builder.field.sa.uus.reference.EHeaderMetadataSaUus;
import id.go.ojk.reask.client.builder.field.sa.uus.reference.ER4104PosSaReasu0205;

public class Sa0205 extends BaseMetadata {

	public Sa0205(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessmentUus eEnum = EFormSelfAssessmentUus.SA_0205;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 24, 24, null, ER4104PosSaReasu0205.genFieldSave(), ER4104PosSaReasu0205.getRequiredPos());
		res.addSegmentValidations(ER4104PosSaReasu0205.genValidationNumericDot());
		res.addSegmentValidations(ER4104PosSaReasu0205.genValidationMaxLengthNumericDot());
		res.addSegmentValidations(ER4104PosSaReasu0205.genValidationNumeric());
		res.addSegmentValidations(ER4104PosSaReasu0205.genValidationMaxLengthNumeric());
		res.addSegmentValidations(ER4104PosSaReasu0205.genValidationPeringkat());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataSaUus.R4104_SA0205.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis", sv(M, 1, 5000, all)));
		return res;
	}
}
