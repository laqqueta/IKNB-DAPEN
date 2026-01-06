package id.go.ojk.lpei.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2150 extends BaseMetadata {

	public Lb2150(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2150;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R5014_LB2150.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Peminjam", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Nama Peminjam", sv(M, 1, 100, all)));
		fs.add(sf(4, null, "Nama Kelompok Peminjam", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R001.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Kategori Usaha Peminjam", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R012.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Kategori Usaha Keuangan Berkelanjutan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R013.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(7, null, "Golongan Peminjam", sv(M, 1, 100, all)));
		fs.add(sf(8, null, "Status Keterkaitan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R014.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(9, null, "Sektor Ekonomi Lapangan Usaha", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R022.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(10, null, "Lokasi Kabupaten/Kota Proyek", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R033.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(11, null, "Nomor Kontrak", sv(M, 1, 100, all)));
		fs.add(sf(12, null, "Jenis Pembiayaan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R053.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(13, null, "Akad yang Digunakan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R037.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(14, null, "Jangka Waktu - Tanggal Mulai", sv(M, 8, 8, date)));
		fs.add(sf(15, null, "Jangka Waktu - Tanggal Jatuh Tempo", sv(M, 8, 8, date)));
		fs.add(sf(16, null, "Nilai Awal", sv(M, 1, 20, numeric)));
		fs.add(sf(17, null, "Akumulasi Penyusutan", sv(M, 1, 20, numeric)));
		fs.add(sf(18, null, "Aset Ijarah Netto", sv(M, 1, 20, numeric)));
		fs.add(sf(19, null, "Jenis Valuta", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(20, null, "Ujrah - Nilai", sv(M, 1, 20, numeric)));
		fs.add(sf(21, null, "Ujrah - Tingkat", sv(M, 1, 10, DataType.numericDot)));
		fs.add(sf(22, null, "Pendapatan Administrasi", sv(M, 1, 20, numeric)));
		fs.add(sf(23, null, "Pendapatan Provisi", sv(M, 1, 20, numeric)));
		fs.add(sf(24, null, "Kualitas Aset", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R017.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(25, null, "Pembayaran Angsuran Terakhir - Tanggal", sv(M, 8, 8, date)));		
		fs.add(sf(26, null, "Pembayaran Angsuran Terakhir - Angsuran Ke-", sv(M, 1, 5, numeric)));
		fs.add(sf(27, null, "Pembayaran Angsuran Terakhir - Nilai Angsuran", sv(M, 1, 20, numeric)));
		fs.add(sf(28, null, "PPKA", sv(M, 1, 20, numeric)));
		fs.add(sf(29, null, "Proporsi Asuransi Kredit atau Penjaminan Kredit", sv(M, 1, 10, DataType.numericDot)));
		fs.add(sf(30, null, "Nama Perusahaan Asuransi/Penjaminan", sv(M, 1, 100, all)));
		fs.add(sf(31, null, "Jangka Waktu Asuransi/Penjaminan", sv(M, 1, 100, numeric)));
		fs.add(sf(32, null, "Informasi Agunan - Jenis Agunan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R034.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(33, null, "Informasi Agunan - Nilai Agunan", sv(M, 1, 20, numeric)));
		return res;
	}
}
