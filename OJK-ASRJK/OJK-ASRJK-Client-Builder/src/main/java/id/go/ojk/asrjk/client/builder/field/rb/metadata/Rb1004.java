package id.go.ojk.asrjk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrjk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjk.client.builder.field.rb.reference.ER2011PosRbAsrjk1004;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb1004 extends BaseMetadata {

	public Rb1004(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1004;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2011_RB1004.getObject())));
		fs.add(sf(2, null, "Nama Tenaga Kerja Asing (apabila ada) / Jumlah Tenaga Kerja Asing", sv(O, 0, 1000, all)));
		fs.add(sf(3, null, "Posisi Jabatan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2011PosRbAsrjk1004.genConditionalField())));
		fs.add(sf(4, null, "Bidang Kerja Penugasan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2011PosRbAsrjk1004.genConditionalField())));
		fs.add(sf(5, null, "Jangka Waktu",
				sv(C, 0, 1000, all).confConditionalRequired(ER2011PosRbAsrjk1004.genConditionalField())));
		fs.add(sf(6, null, "Nama Tenaga Pendamping",
				sv(C, 0, 1000, all).confConditionalRequired(ER2011PosRbAsrjk1004.genConditionalField())));
		fs.add(sf(7, null, "Rencana Program Alih Pengetahuan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2011PosRbAsrjk1004.genConditionalField())));
		fs.add(sf(8, null, "Alasan",
				sv(C, 0, 4000, all).confConditionalRequired(ER2011PosRbAsrjk1004.genConditionalField())));
		return res;
	}
}
