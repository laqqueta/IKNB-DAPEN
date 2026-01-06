package id.go.ojk.dppks.client.builder.field.sa.metadata;

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
import id.go.ojk.dppks.client.builder.field.EFormSelfAssessment;
import id.go.ojk.dppks.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.dppks.client.builder.field.sa.reference.ER4002PosSaDpps0301;

public class Sa0301 extends BaseMetadata {

	public Sa0301(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0301;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 9, 9, null, null, ER4002PosSaDpps0301.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataSa.R4002_SA0301.getObject())).confUnique(U));
		fs.add(sf(2, null, "Individu - Peringkat Risiko Inheren", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4002PosSaDpps0301.genValidationPeringkat()));
		fs.add(sf(3, null, "Individu - Peringkat Kualitas Penerapan Manajemen Risiko", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4002PosSaDpps0301.genValidationPeringkat()));
		fs.add(sf(4, null, "Individu - Peringkat Tingkat Risiko", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4002PosSaDpps0301.genValidationPeringkat()));
		fs.add(sf(5, null, "Konsolidasi - Peringkat Risiko Inheren", sv(O, 1, 1, numeric))
				.addFieldValidations(ER4002PosSaDpps0301.genValidationPeringkat()));
		fs.add(sf(6, null, "Konsolidasi - Peringkat Kualitas Penerapan Manajemen Risiko", sv(O, 1, 1, numeric))
				.addFieldValidations(ER4002PosSaDpps0301.genValidationPeringkat()));
		fs.add(sf(7, null, "Konsolidasi - Peringkat Tingkat Risiko", sv(O, 1, 1, numeric))
				.addFieldValidations(ER4002PosSaDpps0301.genValidationPeringkat()));
		return res;
	}
}
