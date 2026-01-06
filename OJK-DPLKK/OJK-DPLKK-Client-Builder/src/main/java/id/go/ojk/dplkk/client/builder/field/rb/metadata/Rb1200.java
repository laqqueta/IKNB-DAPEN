package id.go.ojk.dplkk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.DataType.yearMonth;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dplkk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dplkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dplkk.client.builder.field.rb.reference.ER2010PosRbDplkk1100;
import id.go.ojk.dplkk.client.builder.field.rb.reference.ER2011PosRbDplkk1200;

public class Rb1200 extends BaseMetadata {

	public Rb1200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2011_RB1200.getObject())));
		fs.add(sf(2, null, "Jenis Kegiatan Usaha", sv(O, 0, 1000, all)));
		fs.add(sf(3, null, "Deskripsi Umum Kegiatan Usaha",
				sv(C, 1, 300, all).confConditionalRequired(ER2011PosRbDplkk1200.genConditionalAllExist())));
		fs.add(sf(4, null, "Waktu Pelaksanaan Kegiatan Usaha",
				sv(C, 1, 6, yearMonth).confConditionalRequired(ER2010PosRbDplkk1100.genConditionalAllExist())));
		fs.add(sf(5, null, "Tujuan Kegiatan Usaha Baru",
				sv(C, 1, 300, all).confConditionalRequired(ER2010PosRbDplkk1100.genConditionalAllExist())));
		fs.add(sf(6, null, "Keterkaitan Kegiatan Usaha Baru dengan Strategi Bisnis Perusahaan",
				sv(C, 1, 300, all).confConditionalRequired(ER2010PosRbDplkk1100.genConditionalAllExist())));
		fs.add(sf(7, null, "Risiko atas Pelaksanaan Kegiatan Usaha Baru",
				sv(C, 1, 300, all).confConditionalRequired(ER2010PosRbDplkk1100.genConditionalAllExist())));
		fs.add(sf(8, null, "Mitigasi Risiko atas Pelaksanaan Kegiatan Usaha Baru",
				sv(C, 1, 300, all).confConditionalRequired(ER2010PosRbDplkk1100.genConditionalAllExist())));
		fs.add(sf(9, null, "Alasan dan Pertimbangan",
				sv(C, 1, 300, all).confConditionalRequired(ER2010PosRbDplkk1100.genConditionalAllExist())));
		fs.add(sf(10, null, "Strategi",
				sv(C, 1, 300, all).confConditionalRequired(ER2010PosRbDplkk1100.genConditionalAllExist())));
		return res;
	}
}
