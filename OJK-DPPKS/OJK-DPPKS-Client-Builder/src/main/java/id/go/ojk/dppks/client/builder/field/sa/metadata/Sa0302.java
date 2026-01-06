package id.go.ojk.dppks.client.builder.field.sa.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
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
import id.go.ojk.dppks.client.builder.field.sa.reference.ER4003PosSaDpps0302;

public class Sa0302 extends BaseMetadata {

	public Sa0302(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0302;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 9, 9, null, null, ER4003PosSaDpps0302.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataSa.R4003_SA0302.getObject())).confUnique(U));
		fs.add(sf(2, null, "Individu - Analisis Risiko Inheren", sv(O, 1, 4000, all)));
		fs.add(sf(3, null, "Individu - Analisis Kualitas Penerapan Manajemen Risiko", sv(O, 1, 4000, all)));
		fs.add(sf(4, null, "Individu - Analisis Tingkat Risiko", sv(O, 1, 4000, all)));
		return res;
	}
}
