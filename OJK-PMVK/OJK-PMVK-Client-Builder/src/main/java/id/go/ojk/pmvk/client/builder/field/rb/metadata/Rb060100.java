package id.go.ojk.pmvk.client.builder.field.rb.metadata;

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
import id.go.ojk.pmvk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.pmvk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvk.client.builder.field.rb.reference.ER2006PosRbPmvk060100;
import id.go.ojk.pmvk.client.builder.field.reference.EHeaderMetadataShared;

public class Rb060100 extends BaseMetadata {

	public Rb060100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_060100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 4, null, null, null, ER2006PosRbPmvk060100.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2006_RB060100.getObject())));
		fs.add(sf(2, null, "Nama Pemegang Saham",
				sv(C, 0, 160, all).confConditionalRequired(ER2006PosRbPmvk060100.genValidationMustEmpty())));
		fs.add(sf(3, null, "Kategori Pemegang Saham",
				sv(C, 0, 5, refTable).confReference(EHeaderMetadataShared.R001.getObject())
						.confConditionalRequired(ER2006PosRbPmvk060100.genValidationMustEmpty())));
		fs.add(sf(4, null, "Kinerja Sept XX-1", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember XX-1", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(6, null, "Proyeksi - Juni xx", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(7, null, "Proyeksi - Desember xx", sv(M, 0, 16, numericNegatif)));
		return res;
	}
}
