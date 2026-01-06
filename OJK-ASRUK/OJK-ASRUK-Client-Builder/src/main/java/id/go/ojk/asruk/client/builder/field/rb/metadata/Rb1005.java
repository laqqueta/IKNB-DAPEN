package id.go.ojk.asruk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asruk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asruk.client.builder.field.rb.reference.ER2012PosRbAsruk1005;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb1005 extends BaseMetadata {

	public Rb1005(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1005;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<SubmissionField>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2012_RB1005.getObject())));
		fs.add(sf(2, null, "Bidang Tugas", sv(O, 0, 1000, all)));
		fs.add(sf(3, null, "Alasan Pemanfaatan Tenaga Alih Daya",
				sv(C, 0, 1000, all).confConditionalRequired(ER2012PosRbAsruk1005.genConditionalField())));
		fs.add(sf(4, null, "Jumlah Tenaga Kerja Alih Daya",
				sv(C, 0, 10, numeric).confConditionalRequired(ER2012PosRbAsruk1005.genConditionalField())));
		fs.add(sf(5, null, "Nama Perusahaan Penyedia Tenaga Kerja Alih Daya (apabila ada)",
				sv(C, 0, 1000, all).confConditionalRequired(ER2012PosRbAsruk1005.genConditionalField())));
		fs.add(sf(6, null, "Jangka Waktu Perjanjian dengan Perusahaan Tenaga Kerja Alih Daya",
				sv(C, 0, 1000, all).confConditionalRequired(ER2012PosRbAsruk1005.genConditionalField())));
		return res;
	}
}
