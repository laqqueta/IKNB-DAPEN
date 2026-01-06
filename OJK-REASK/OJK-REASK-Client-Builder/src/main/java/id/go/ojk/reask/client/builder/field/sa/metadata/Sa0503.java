package id.go.ojk.reask.client.builder.field.sa.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormSelfAssessment;
import id.go.ojk.reask.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.reask.client.builder.field.sa.reference.ER4016PosSaReask0503;

public class Sa0503 extends BaseMetadata {

	public Sa0503(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0503;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 2, 2, null, null, ER4016PosSaReask0503.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataSa.R4016_SA0503.getObject())).confUnique(U));
		fs.add(sf(2, null, "Individu", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4016PosSaReask0503.genValidationPeringkat()));
		fs.add(sf(3, null, "Konsolidasi", sv(O, 1, 1, numeric))
				.addFieldValidations(ER4016PosSaReask0503.genValidationPeringkat()));
		return res;
	}
}
