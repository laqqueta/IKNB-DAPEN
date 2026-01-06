package id.go.ojk.dppks.client.builder.field.rb.metadata;

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
import id.go.ojk.dppks.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dppks.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppks.client.builder.field.rb.reference.ER2015PosRbDppks1004;

public class Rb1004 extends BaseMetadata {

	public Rb1004(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1004;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2015_RB1004.getObject())));
		fs.add(sf(2, null, "Jenis/ Nama Aplikasi", sv(O, 0, 300, all)));
		fs.add(sf(3, null, "Kepemilikan (inhouse/ vendor)",
				sv(C, 1, 50, all).confConditionalRequired(ER2015PosRbDppks1004.genConditionalAllExist())));
		fs.add(sf(4, null, "Nama Vendor",
				sv(C, 1, 300, all).confConditionalRequired(ER2015PosRbDppks1004.genConditionalAllExist())));
		fs.add(sf(5, null, "Fungsi Aplikasi",
				sv(C, 1, 300, all).confConditionalRequired(ER2015PosRbDppks1004.genConditionalAllExist())));
		return res;
	}
}
