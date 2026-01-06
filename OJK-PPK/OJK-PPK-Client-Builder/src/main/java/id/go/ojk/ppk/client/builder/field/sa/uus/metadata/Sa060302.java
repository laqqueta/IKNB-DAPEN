package id.go.ojk.ppk.client.builder.field.sa.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppk.client.builder.field.EFormSelfAssessmentUus;
import id.go.ojk.ppk.client.builder.field.sa.uus.reference.EHeaderMetadataSaUus;
import id.go.ojk.ppk.client.builder.field.sa.uus.reference.ER4100PosSaPpu060302;

public class Sa060302 extends BaseMetadata {

	public Sa060302(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessmentUus eEnum = EFormSelfAssessmentUus.SA_060302;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 9, 9, null, null, ER4100PosSaPpu060302.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataSaUus.R4100_SA060302.getObject())).confUnique(U));
		fs.add(sf(2, null, "Individu - Peringkat Risiko Inheren", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4100PosSaPpu060302.genValidationPeringkat()));
		fs.add(sf(3, null, "Individu - Peringkat Kualitas Penerapan Manajemen Risiko", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4100PosSaPpu060302.genValidationPeringkat()));
		fs.add(sf(4, null, "Individu - Peringkat Tingkat Risiko", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4100PosSaPpu060302.genValidationPeringkat()));
		fs.add(sf(5, null, "Analisis", sv(M, 1, 4000, all)));
		return res;
	}
}
