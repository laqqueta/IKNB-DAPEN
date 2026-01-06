package id.go.ojk.dppkk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.reference.ER2112PosRbDppu1001;

public class Rb1001 extends BaseMetadata {

	public Rb1001(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_1001;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER2112PosRbDppu1001.genFieldSave(), null, ER2112PosRbDppu1001.getRequiredPos());
		res.addSegmentValidations(ER2112PosRbDppu1001.genTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRbUus.R2112_RB1001.getObject())));
		fs.add(sf(2, null, "Bidang Tugas",
				sv(C, 1, 100, all).confConditionalRequired(ER2112PosRbDppu1001.genConditional1())));
		fs.add(sf(3, null, "Alasan Pemanfaatan Tenaga Alih Daya",
				sv(C, 1, 300, all).confConditionalRequired(ER2112PosRbDppu1001.genConditional2())));
		fs.add(sf(4, null, "Jumlah Tenaga Kerja Alih Daya",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2112PosRbDppu1001.genConditional3())));
		fs.add(sf(5, null, "Nama Perusahaan Penyedia Tenaga Kerja Alih Daya (apabila ada)",
				sv(C, 1, 100, all).confConditionalRequired(ER2112PosRbDppu1001.genConditional2())));
		fs.add(sf(6, null, "Jangka Waktu Perjanjian dengan Perusahaan Tenaga Kerja Alih Daya",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2112PosRbDppu1001.genConditional3())));
		return res;
	}
}
