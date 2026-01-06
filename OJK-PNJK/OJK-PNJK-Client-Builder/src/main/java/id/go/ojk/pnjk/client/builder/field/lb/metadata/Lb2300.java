package id.go.ojk.pnjk.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjk.client.builder.field.lb.reference.ER3017PosLbPnjk2300;
import id.go.ojk.pnjk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2300 extends BaseMetadata {

	public Lb2300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, null, ER3017PosLbPnjk2300.genFieldSave(), null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3017_LB2300.getObject())));
		fs.add(sf(2, null, "Nama", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Nomor Sertifikat Penjaminan", sv(M, 1, 50, all)));
		fs.add(sf(4, null, "Tanggal Sertifikat Penjaminan", sv(M, 8, 8, date)));
		fs.add(sf(5, null, "Jenis Penjaminan", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R042.getObject())));
		fs.add(sf(6, null, "Produk Penjaminan", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R043.getObject())));
		fs.add(sf(7, null, "Nilai Kredit/Proyek", sv(M, 1, 16, numeric)));
		fs.add(sf(8, null, "Nilai Penjaminan", sv(M, 1, 16, numeric)));
		fs.add(sf(9, null, "Nilai Penjaminan Porsi Mitra", sv(M, 1, 16, numeric)));
		fs.add(sf(10, null, "Nama Mitra", sv(M, 1, 100, all)));
		fs.add(sf(11, null, "Skim", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R044.getObject())));
		fs.add(sf(12, null, "Jumlah Klaim", sv(M, 1, 16, numeric)));
		fs.add(sf(13, null, "Tanggal Klaim", sv(M, 8, 8, date)));
		fs.add(sf(14, null, "Piutang Klaim", sv(M, 1, 16, numeric)));
		fs.add(sf(15, null, "Jumlah Hari Menunggak", sv(M, 1, 8, numeric)));
		fs.add(sf(16, null, "CKPN", sv(M, 1, 16, numeric)));
		return res;
	}
}
