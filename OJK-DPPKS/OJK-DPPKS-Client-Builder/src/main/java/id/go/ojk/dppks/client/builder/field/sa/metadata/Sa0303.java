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
import id.go.ojk.dppks.client.builder.field.sa.reference.ER4004PosSaDpps0303;

public class Sa0303 extends BaseMetadata {

	public Sa0303(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0303;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 9, 9, null, null, ER4004PosSaDpps0303.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataSa.R4004_SA0303.getObject())).confUnique(U));
		fs.add(sf(2, null, "Konsolidasi - Analisis Risiko Inheren", sv(O, 1, 4000, all)));
		fs.add(sf(3, null, "Konsolidasi - Analisis Kualitas Penerapan Manajemen Risiko", sv(O, 1, 4000, all)));
		fs.add(sf(4, null, "Konsolidasi - Analisis Tingkat Risiko", sv(O, 1, 4000, all)));
		return res;
	}
}
