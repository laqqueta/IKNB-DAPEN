package id.go.ojk.lpei.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
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
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5013PosLbLpeig2100;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2100 extends BaseMetadata {

	public Lb2100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null);

		res.setRequiredPos(ER5013PosLbLpeig2100.getRequiredPos());
		res.setSavePos(ER5013PosLbLpeig2100.genFieldSave());
		res.setSavePosForm(ER5013PosLbLpeig2100.genFieldSave());

		// TODO - Yahya: validate Index 27 Outstanding Pembiayaan - Dalam Ekuivalen
		// Rupiah harus
		// jumlah total harus sama dengan Kolom Jumlah Pembiayaan dan Pembiayaan
		// Berdasarkan Prinsip Syariah pada form 1100
		// gunakan sum form validatin

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R5013_LB2100.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Kontrak", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Nomor Rekening", sv(M, 1, 20, all)));
		fs.add(sf(4, null, "Jumlah Rekening", sv(M, 1, 10, numeric)));
		fs.add(sf(5, null, "Nama Peminjam", sv(M, 1, 100, all)));
		fs.add(sf(6, null, "Nama Kelompok Usaha Peminjam", sv(M, 1, 100, all)));
		fs.add(sf(7, null, "Kategori Usaha Keuangan Berkelanjutan",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R052.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(8, null, "Golongan Peminjam", sv(M, 1, 100, all)));
		fs.add(sf(9, null, "Status Keterkaitan",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R014.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(10, null, "Kategori Usaha Peminjam",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R012.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(11, null, "Jenis Pembiayaan",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R053.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(12, null, "Jenis Penggunaan",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R054.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(13, null, "Jenis Valuta", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(14, null, "Sektor Ekonomi Lapangan Usaha",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R022.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(15, null, "Jangka Waktu - Tanggal Mulai", sv(M, 8, 8, date)));
		fs.add(sf(16, null, "Jangka Waktu - Tanggal Jatuh Tempo", sv(M, 8, 8, date)));
		fs.add(sf(17, null, "Kualitas Aset",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R017.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(18, null, "Suku Bunga Bagi Hasil - Jenis",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R015.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(19, null, "Suku Bunga Bagi Hasil - Nilai", sv(M, 1, 20, numeric)));
		fs.add(sf(20, null, "Suku Bunga Bagi Hasil - Tingkat", sv(M, 1, 10, DataType.numericDot)));
		fs.add(sf(21, null, "Nilai Awal Pembiayaan", sv(M, 1, 20, numeric)));
		fs.add(sf(22, null, "Persentase terhadap Modal", sv(M, 1, 10, DataType.numericDot)));
		fs.add(sf(23, null, "Kategori Pengukuran", sv(M, 1, 100, all)));
		fs.add(sf(24, null, "Kategori Piutang",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R016.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(25, null, "Lokasi Kabupaten/Kota Proyek",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R033.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(26, null, "Outstanding Pembiayaan - Dalam Mata Uang Asal", sv(M, 1, 20, DataType.numericDot)));
		fs.add(sf(27, null, "Outstanding Pembiayaan - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(28, null, "Tunggakan Bunga/Margin/Ujrah/Bagi Hasil - Dalam Mata Uang Asal",
				sv(M, 1, 20, DataType.numericDot)));
		fs.add(sf(29, null, "Tunggakan Bunga/Margin/Ujrah/Bagi Hasil - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(30, null, "Tunggakan Denda - Dalam Mata Uang Asal", sv(M, 1, 20, DataType.numericDot)));
		fs.add(sf(31, null, "Tunggakan Denda - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(32, null, "Bunga/Margin/Ujrah/Bagi Hasil yang Ditangguhkan - Dalam Mata Uang Asal",
				sv(M, 1, 20, DataType.numericDot)));
		fs.add(sf(33, null, "Bunga/Margin/Ujrah/Bagi Hasil yang Ditangguhkan - Dalam Ekuivalen Rupiah",
				sv(M, 1, 20, numeric)));
		fs.add(sf(34, null, "Pendapatan Administrasi", sv(M, 1, 20, numeric)));
		fs.add(sf(35, null, "Pendapatan Provisi", sv(M, 1, 20, numeric)));
		fs.add(sf(36, null, "Cadangan Kerugian Penurunan Nilai - Metode Secara Individual", sv(M, 1, 20, numeric)));
		// TODO: yahya - Test validasi form 2100 - 37
		fs.add(sf(37, null, "Cadangan Kerugian Penurunan Nilai - Metode Secara Kolektif",
				sv(C, 1, 20, numeric).confConditionalRequired(ER5013PosLbLpeig2100.genConditionalValidation37()))
				.addFieldValidations(ER5013PosLbLpeig2100.genFieldValidation37()));
		fs.add(sf(38, null, "Cadangan Kerugian Penurunan Nilai - Aset Baik", sv(M, 1, 20, numeric)));
		fs.add(sf(39, null, "Cadangan Kerugian Penurunan Nilai - Aset Kurang Baik", sv(M, 1, 20, numeric)));
		fs.add(sf(40, null, "Cadangan Kerugian Penurunan Nilai - Aset Tidak Baik", sv(M, 1, 20, numeric)));
		fs.add(sf(41, null, "Proporsi Penjaminan Kredit atau Asuransi Kredit", sv(M, 1, 10, DataType.numericDot)));
		fs.add(sf(42, null, "Nama Perusahaan Asuransi/Penjaminan", sv(M, 1, 100, all)));
		fs.add(sf(43, null, "Jangka Waktu Asuransi/Penjaminan", sv(M, 1, 100, numeric)));
		fs.add(sf(44, null, "Informasi Agunan - Jenis Agunan",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R034.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(45, null, "Informasi Agunan - Nilai Agunan", sv(M, 1, 20, numeric)));
		return res;
	}
}
