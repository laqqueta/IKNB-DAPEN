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
import id.go.ojk.reask.client.builder.field.sa.uus.reference.ER4105PosSaReasu0206;

public class Sa0206 extends BaseMetadata {

	public Sa0206(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessmentUus eEnum = EFormSelfAssessmentUus.SA_0206;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 19, 19, null, ER4105PosSaReasu0206.genFieldSave(), ER4105PosSaReasu0206.getRequiredPos());
		res.addSegmentValidations(ER4105PosSaReasu0206.genValidationNumericDot());
		res.addSegmentValidations(ER4105PosSaReasu0206.genValidationMaxLengthNumericDot());
		res.addSegmentValidations(ER4105PosSaReasu0206.genValidationNumeric());
		res.addSegmentValidations(ER4105PosSaReasu0206.genValidationMaxLengthNumeric());
		res.addSegmentValidations(ER4105PosSaReasu0206.genValidationPeringkat());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataSaUus.R4105_SA0206.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis", sv(M, 1, 5000, all)));
		return res;
	}
}
