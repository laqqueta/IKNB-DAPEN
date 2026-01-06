package id.go.ojk.reask.client.builder.field.sa.metadata;

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
import id.go.ojk.reask.client.builder.field.EFormSelfAssessment;
import id.go.ojk.reask.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.reask.client.builder.field.sa.reference.ER4006PosSaReask0206;

public class Sa0206 extends BaseMetadata {

	public Sa0206(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0206;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 15, 15, null, ER4006PosSaReask0206.genFieldSave(), ER4006PosSaReask0206.getRequiredPos());
		res.addSegmentValidations(ER4006PosSaReask0206.genValidationNumericDotNegative());
		res.addSegmentValidations(ER4006PosSaReask0206.genValidationMaxLengthNumericDotNegative());
		res.addSegmentValidations(ER4006PosSaReask0206.genValidationNumeric());
		res.addSegmentValidations(ER4006PosSaReask0206.genValidationMaxLengthNumeric());
		res.addSegmentValidations(ER4006PosSaReask0206.genValidationPeringkat());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataSa.R4006_SA0206.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis", sv(M, 1, 5000, all)));
		return res;
	}
}
