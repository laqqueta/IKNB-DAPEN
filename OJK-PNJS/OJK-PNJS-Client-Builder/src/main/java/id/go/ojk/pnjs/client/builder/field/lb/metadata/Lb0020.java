package id.go.ojk.pnjs.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternPhoneNumber;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjs.client.builder.field.lb.reference.ER3001PosLbPnjs0020;
import id.go.ojk.pnjs.client.builder.field.reference.EHeaderMetadataShared;

public class Lb0020 extends BaseMetadata {

	public Lb0020(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0020;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, null, ER3001PosLbPnjs0020.genFieldSave(), null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3001_LB0020.getObject())));
		fs.add(sf(2, null, "Jenis Kantor", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Nomor Surat Pencatatan", sv(O, 0, 35, all)));
		fs.add(sf(4, null, "Tanggal Surat Pencatatan", sv(O, 8, 8, date)));
		fs.add(sf(5, null, "Alamat", sv(M, 1, 200, all)));
		fs.add(sf(6, null, "Kecamatan", sv(O, 1, 50, all)));
		fs.add(sf(7, null, "Kabupaten/ Kota", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R033.getObject())));
		fs.add(sf(8, null, "Kode Pos", sv(M, 5, 5, numeric)));
		fs.add(sf(9, null, "Nomor Telepon", sv(M, 1, 15, all).confRegex(patternPhoneNumber)));
		fs.add(sf(10, null, "Jumlah Tenaga Kerja", sv(M, 1, 10, numeric)));
		fs.add(sf(11, null, "Nama Penanggung Jawab Kantor", sv(M, 1, 100, all)));
		fs.add(sf(12, null, "Tanggal Mulai Operasional", sv(M, 8, 8, date)));
		fs.add(sf(13, null, "Kepemilikan Gedung Kantor", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R032.getObject())));
		fs.add(sf(14, null, "Jumlah Pegawai Laki-Laki", sv(M, 1, 10, numeric)));
		fs.add(sf(15, null, "Jumlah Pegawai Perempuan", sv(M, 1, 10, numeric)));
		return res;
	}
}
