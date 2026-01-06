package id.go.ojk.ppk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.ER2759PosRePpu060200;
import id.go.ojk.ppk.client.builder.field.reference.EHeaderMetadataShared;

public class Re060200 extends BaseMetadata {

	public Re060200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_060200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 4, null, null, null, ER2759PosRePpu060200.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2759_RE060200.getObject())));
		fs.add(sf(2, null, "Nama Pemegang Saham",
				sv(C, 0, 200, all).confConditionalRequired(ER2759PosRePpu060200.genConditionalFieldOptional())));
		fs.add(sf(3, null, "Kategori Pemegang Saham",
				sv(C, 0, 5, refTable).confReference(EHeaderMetadataShared.R003.getObject())
						.confConditionalRequired(ER2759PosRePpu060200.genConditionalFieldOptional())));
		fs.add(sf(4, null, "Proyeksi", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(5, null, "Realisasi", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(6, null, "Deviasi", sv(M, 0, 16, numericNegatif))
				.addFieldValidations(ER2759PosRePpu060200.genValidationSum()));
		return res;
	}
}
