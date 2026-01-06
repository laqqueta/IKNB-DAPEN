package id.go.ojk.ppik.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.ER3112PosLbPpiu2100;
import id.go.ojk.ppik.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2100 extends BaseMetadata {

	public Lb2100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		res.setSavePosForm(ER3112PosLbPpiu2100.genFieldSave());
		res.addSegmentValidations(ER3112PosLbPpiu2100.genRowValidation2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R3113_LB2100.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Nasabah", sv(M, 1, 30, all)));
		fs.add(sf(3, null, "Nama Nasabah", sv(M, 1, 100, all)));
		fs.add(sf(4, null, "Nama Kelompok Nasabah", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R011.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Kategori Usaha Nasabah", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R012.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Kategori Usaha Keuangan Berkelanjutan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R013.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(7, null, "Golongan Nasabah", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R031.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(8, null, "Status Keterkaitan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R014.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(9, null, "Sektor Ekonomi Lapangan Usaha", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R022.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(10, null, "Lokasi Kabupaten/ Kota Proyek", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R033.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(11, null, "Objek Pembiayaan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R021.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(12, null, "Nomor Kontrak", sv(M, 1, 50, all)));
		fs.add(sf(13, null, "Jenis Pembiayaan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R039.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(14, null, "Akad Yang Digunakan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R041.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(15, null, "Jangka Waktu, Tanggal Mulai", sv(M, 8, 8, date))
				.addFieldValidations(ER3112PosLbPpiu2100.genFieldValidation15()));
		fs.add(sf(16, null, "Jangka Waktu, Tanggal Jatuh Tempo", sv(M, 8, 8, date)));
		fs.add(sf(17, null, "Nilai Awal Pembiayaan", sv(M, 1, 16, numeric)));
		fs.add(sf(18, null, "Tagihan Piutang Pembiayaan Bruto, Dalam Nilai Mata Uang Asal",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3112PosLbPpiu2100.genFieldCondition())));
		fs.add(sf(19, null, "Tagihan Piutang Pembiayaan Bruto, Dalam Ekuivalen Rupiah", sv(M, 1, 16, numeric)));
		fs.add(sf(20, null, "Tagihan Piutang Pembiayaan Pokok, Dalam Nilai Mata Uang Asal",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3112PosLbPpiu2100.genFieldCondition())));
		fs.add(sf(21, null, "Tagihan Piutang Pembiayaan Pokok, Dalam Ekuivalen Rupiah", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(22, null, "Jenis Valuta", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(23, null, "Margin/Ujrah/Bagi Hasil, Jenis", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R043.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(24, null, "Margin/Ujrah/Bagi Hasil, Nilai", sv(M, 1, 16, numeric)));
		fs.add(sf(25, null, "Margin/Ujrah/Bagi Hasil, Tingkat", sv(M, 1, 6, numericDot)));
		fs.add(sf(26, null, "Margin/Ujrah/Bagi Hasil yang Ditangguhkan, Dalam Mata Uang Asal",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3112PosLbPpiu2100.genFieldCondition())));
		fs.add(sf(27, null, "Bunga/Margin/Ujrah/Bagi Hasil yang Ditangguhkan, Dalam Ekuivalen Rupiah",
				sv(M, 1, 16, numeric)));
		fs.add(sf(28, null, "Pendapatan Administrasi", sv(M, 1, 16, numeric)));
		fs.add(sf(29, null, "Pendapatan Provisi", sv(M, 1, 16, numeric)));
		fs.add(sf(30, null, "Kategori Piutang", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R016.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(31, null, "Kualitas", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R017.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(32, null, "Kualitas berdasarkan POJK Penyelenggaraan Usaha", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R017.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(33, null, "Pembayaran Angsuran Terakhir, Tanggal", sv(M, 8, 8, date)));
		fs.add(sf(34, null, "Pembayaran Angsuran Terakhir, Angsuran Ke-", sv(M, 1, 3, numeric)));
		fs.add(sf(35, null, "Pembayaran Angsuran Terakhir, Nilai Angsuran", sv(M, 1, 16, numeric)));
		fs.add(sf(36, null, "Cadangan Kerugian Penurunan Nilai, Metode", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R018.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(37, null, "Cadangan Kerugian Penurunan Nilai, Aset Baik", sv(M, 1, 16, numeric)));
		fs.add(sf(38, null, "Cadangan Kerugian Penurunan Nilai, Aset Kurang Baik", sv(M, 1, 16, numeric)));
		fs.add(sf(39, null, "Cadangan Kerugian Penurunan Nilai, Aset Tidak Baik", sv(M, 1, 16, numeric)));
		fs.add(sf(40, null, "Proporsi Penjaminan Kredit atau Asuransi Kredit", sv(M, 1, 6, numericDot)));
		fs.add(sf(41, null, "Nama Perusahaan Asuransi/Penjaminan", sv(O, 1, 100, all).confRegex(PATTERN_NAME.c())));
		fs.add(sf(42, null, "Jangka Waktu Asuransi/Penjaminan",
				sv(C, 1, 3, numeric).confConditionalRequired(ER3112PosLbPpiu2100.genFieldCondition42())));
		fs.add(sf(43, null, "Informasi Agunan, Jenis Agunan", sv(O, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R034.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(44, null, "Informasi Agunan, Nilai Agunan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3112PosLbPpiu2100.genFieldCondition44())));
		return res;
	}
}
