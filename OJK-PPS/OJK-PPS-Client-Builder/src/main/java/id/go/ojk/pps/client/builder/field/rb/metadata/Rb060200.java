package id.go.ojk.pps.client.builder.field.rb.metadata;

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
import id.go.ojk.pps.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.pps.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pps.client.builder.field.rb.reference.ER2009PosRbPps060200;
import id.go.ojk.pps.client.builder.field.reference.EHeaderMetadataShared;

public class Rb060200 extends BaseMetadata {

	public Rb060200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_060200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 4, null, null, null, ER2009PosRbPps060200.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2009_RB060200.getObject())));
		fs.add(sf(2, null, "Nama Pemegang Saham",
				sv(C, 0, 200, all).confConditionalRequired(ER2009PosRbPps060200.genConditionalFieldMustEmpty())));
		fs.add(sf(3, null, "Kategori Pemegang Saham",
				sv(C, 0, 5, refTable).confReference(EHeaderMetadataShared.R003.getObject())
						.confConditionalRequired(ER2009PosRbPps060200.genConditionalFieldMustEmpty())));
		fs.add(sf(4, null, "Kinerja Sept XX-1", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember XX-1", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(6, null, "Proyeksi - Juni xx", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(7, null, "Proyeksi - Desember xx", sv(M, 0, 16, numericNegatif)));
		return res;
	}
}
