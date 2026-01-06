package id.go.ojk.ppk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.ER2523PosRbPpu120100;

public class Rb120100 extends BaseMetadata {

	public Rb120100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_120100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2523_RB120100.getObject())));
		fs.add(sf(2, null, "Nama Perusahaan Anak", sv(O, 0, 255, all)));
		fs.add(sf(3, null, "Kinerja Sept XX-1",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2523PosRbPpu120100.genConditionalField())));
		fs.add(sf(4, null, "Proyeksi - Desember XX-1",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2523PosRbPpu120100.genConditionalField())));
		fs.add(sf(5, null, "Proyeksi - Juni xx",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2523PosRbPpu120100.genConditionalField())));
		fs.add(sf(6, null, "Proyeksi - Desember xx",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER2523PosRbPpu120100.genConditionalField())));
		return res;
	}
}
