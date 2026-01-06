package id.go.ojk.ppik.client.builder.field.sa.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.ppik.client.builder.field.EFormSelfAssessmentUus;
import id.go.ojk.ppik.client.builder.field.sa.uus.reference.EHeaderMetadataSaUus;
import id.go.ojk.ppik.client.builder.field.sa.uus.reference.ER3400PosSaPpiu060302;

public class Sa060302 extends BaseMetadata {

	public Sa060302(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessmentUus eEnum = EFormSelfAssessmentUus.SA_060302;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 9, 9);
		res.setRequiredPos(ER3400PosSaPpiu060302.getRequiredPos());
		res.setUniquePos(ER3400PosSaPpiu060302.getUniquePos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataSaUus.R3400_SA060302.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Individu - Peringkat Risiko Inheren", sv(M, 1, 1, numeric))
				.addFieldValidations(UtilFieldValidation.genBetween("1", "5")));
		fs.add(sf(3, null, "Individu - Peringkat Kualitas Penerapan Manajemen Risiko", sv(M, 1, 1, numeric))
				.addFieldValidations(UtilFieldValidation.genBetween("1", "5")));
		fs.add(sf(4, null, "Individu - Peringkat Tingkat Risiko", sv(M, 1, 1, numeric))
				.addFieldValidations(UtilFieldValidation.genBetween("1", "5")));
		fs.add(sf(5, null, "Analisis", sv(M, 1, 4000, all)));
		return res;
	}

}
