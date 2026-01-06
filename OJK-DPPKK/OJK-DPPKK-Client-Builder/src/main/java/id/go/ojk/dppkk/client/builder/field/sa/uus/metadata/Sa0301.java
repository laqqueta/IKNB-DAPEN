package id.go.ojk.dppkk.client.builder.field.sa.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormSelfAssessmentUus;
import id.go.ojk.dppkk.client.builder.field.sa.uus.reference.EHeaderMetadataSaUus;
import id.go.ojk.dppkk.client.builder.field.sa.uus.reference.ER4100PosSaDppu0301;

public class Sa0301 extends BaseMetadata {

	public Sa0301(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessmentUus eEnum = EFormSelfAssessmentUus.SA_0301;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 9, 9, null, null, ER4100PosSaDppu0301.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataSaUus.R4100_SA0301.getObject())).confUnique(U));
		fs.add(sf(2, null, "Peringkat Risiko Inheren", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4100PosSaDppu0301.genValidationPeringkat()));
		fs.add(sf(3, null, "Peringkat Kualitas Penerapan Manajemen Risiko", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4100PosSaDppu0301.genValidationPeringkat()));
		fs.add(sf(4, null, "Peringkat Tingkat Risiko", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4100PosSaDppu0301.genValidationPeringkat()));
		return res;
	}
}
