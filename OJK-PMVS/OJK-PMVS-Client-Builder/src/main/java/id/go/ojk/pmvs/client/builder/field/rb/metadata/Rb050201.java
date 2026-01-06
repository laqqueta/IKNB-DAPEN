package id.go.ojk.pmvs.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pmvs.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.pmvs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvs.client.builder.field.rb.reference.ER2005PosRbPmvs050201;
import id.go.ojk.pmvs.client.builder.field.reference.EHeaderMetadataShared;

public class Rb050201 extends BaseMetadata {

	public Rb050201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_050201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2005_RB050201.getObject())));
		fs.add(sf(2, null, "Jenis Kegiatan Usaha",
				sv(O, 0, 10, refTable).confReference(EHeaderMetadataShared.R004.getObject())));
		fs.add(sf(3, null, "Deskripsi Umum Kegiatan Usaha",
				sv(C, 0, 1000, all).confConditionalRequired(ER2005PosRbPmvs050201.genConditionalField())));
		fs.add(sf(4, null, "Waktu Pelaksanaan Kegiatan Usaha Baru",
				sv(C, 0, 8, date).confConditionalRequired(ER2005PosRbPmvs050201.genConditionalField())));
		fs.add(sf(5, null, "Tujuan Kegiatan Usaha Baru Bagi Perusahaan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2005PosRbPmvs050201.genConditionalField())));
		fs.add(sf(6, null, "Tujuan Kegiatan Usaha Baru Bagi Pasangan Usaha/Debitur",
				sv(C, 0, 1000, all).confConditionalRequired(ER2005PosRbPmvs050201.genConditionalField())));
		fs.add(sf(7, null, "Keterkaitan Kegiatan Usaha Baru dengan Strategi Bisnis Perusahaan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2005PosRbPmvs050201.genConditionalField())));
		return res;
	}
}
