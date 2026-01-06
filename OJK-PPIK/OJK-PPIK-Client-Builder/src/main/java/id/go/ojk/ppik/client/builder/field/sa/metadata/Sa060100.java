package id.go.ojk.ppik.client.builder.field.sa.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.ppik.client.builder.field.EFormSelfAssessment;
import id.go.ojk.ppik.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.ppik.client.builder.field.sa.reference.ER3200PosSaPpik060100;

public class Sa060100 extends BaseMetadata {

	public Sa060100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_060100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 5, 5);
		res.setRequiredPos(ER3200PosSaPpik060100.getRequiredPos());
		res.setUniquePos(ER3200PosSaPpik060100.getUniquePos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataSa.R3200_SA060100.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Peringkat - Individu", sv(M, 1, 1, numeric))
				.addFieldValidations(UtilFieldValidation.genBetween("1", "5")));
		fs.add(sf(3, null, "Peringkat - Konsolidasi", sv(O, 1, 1, numeric))
				.addFieldValidations(UtilFieldValidation.genBetween("1", "5")));
		fs.add(sf(4, null, "Analisis", sv(M, 1, 4000, all)));
		return res;
	}

}
