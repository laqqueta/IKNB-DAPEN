package id.go.ojk.reask.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.ER2118PosRbReasu1005;

public class Rb1005 extends BaseMetadata {

	public Rb1005(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_1005;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRbUus.R2118_RB1005.getObject())));
		fs.add(sf(2, null, "Jenis/ Nama Aplikasi", sv(O, 0, 1000, all)));
		fs.add(sf(3, null, "Kepemilikan (inhouse/ vendor)",
				sv(C, 0, 1000, all).confConditionalRequired(ER2118PosRbReasu1005.genConditionalField())));
		fs.add(sf(4, null, "Nama Vendor",
				sv(C, 0, 1000, all).confConditionalRequired(ER2118PosRbReasu1005.genConditionalField())));
		fs.add(sf(5, null, "Fungsi Aplikasi",
				sv(C, 0, 1000, all).confConditionalRequired(ER2118PosRbReasu1005.genConditionalField())));
		return res;
	}
}
