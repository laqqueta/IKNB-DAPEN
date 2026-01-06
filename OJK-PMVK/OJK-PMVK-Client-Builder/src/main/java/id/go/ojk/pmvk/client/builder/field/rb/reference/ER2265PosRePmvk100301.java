package id.go.ojk.pmvk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pmvk.client.builder.field.EFormRealisasiBisnis;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2265PosRePmvk100301 implements IObject<KeyValueString> {
//	R_10030101000000000000 ("10030101000000000000", "PENDAPATAN"),
	R_10030101010000000000 ("10030101010000000000", "Pendapatan Operasional"),
	R_10030101010100000000 ("10030101010100000000", "Pendapatan Kegiatan Operasi"),
	R_10030101010101000000 ("10030101010101000000", "Pendapatan Dividen dari Kegiatan Penyertaan Saham"),
	R_10030101010102000000 ("10030101010102000000", "Pendapatan dari keuntungan penjualan aset penyertaan atau surat berharga"),
	R_10030101010103000000 ("10030101010103000000", "Pendapatan   bunga dari kegiatan penyertaan melalui pembelian obligasi konversi "),
	R_10030101010104000000 ("10030101010104000000", "Pendapatan bunga dari kegiatan pembiayaan melalui pembelian surat utang yang diterbitkan pasangan usaha pada tahap rintisan awal (start-up) dan/atau pengembangan usaha"),
	R_10030101010105000000 ("10030101010105000000", "Pendapatan bunga dari kegiatan pembiayaan usaha produktif"),
	R_10030101010200000000 ("10030101010200000000", "Pendapatan Kegiatan Operasi Berdasarkan Prinsip Syariah"),
	R_10030101010201000000 ("10030101010201000000", "Pendapatan Dividen dari Kegiatan Penyertaan Saham "),
	R_10030101010202000000 ("10030101010202000000", "Pendapatan dari Keuntungan Penjualan Aset Penyertaan atau Surat Berharga "),
	R_10030101010203000000 ("10030101010203000000", "Pendapatan Imbal Hasil dari Kegiatan Pembelian Sukuk atau Obligasi Syariah Konversi "),
	R_10030101010204000000 ("10030101010204000000", "Pendapatan Imbal Hasil dari Kegiatan Pembelian Sukuk atau Obligasi Syariah yang Diterbitkan Pasangan Usaha pada Tahap Rintisan Awal (Start-up) dan/atau Pengembangan Usaha "),
	R_10030101010205000000 ("10030101010205000000", "Pendapatan Bagi Hasil dari Kegiatan Pembiayaan Berdasarkan Prinsip Bagi Hasil "),
	R_10030101010300000000 ("10030101010300000000", "Pendapatan dari Penyertaan pada Dana Ventura"),
	R_10030101010400000000 ("10030101010400000000", "Pendapatan dari Kegiatan Pengelolaan Dana Ventura "),
	R_10030101010500000000 ("10030101010500000000", "Pendapatan dari Kegiatan Usaha Lain"),
	R_10030101010501000000 ("10030101010501000000", "Pendapatan dari Kegiatan Jasa Berbasis Fee "),
	R_10030101010502000000 ("10030101010502000000", "Pendapatan dari Kegiatan Usaha Lain dengan Persetujuan Otoritas Jasa Keuangan "),
	R_10030101010600000000 ("10030101010600000000", "Pendapatan Fee/Imbal Jasa dari Kegiatan Penerusan Pembiayaan (Channeling) "),
	R_10030101020000000000 ("10030101020000000000", "Pendapatan Operasional Lain Terkait Pembiayaan"),
	R_10030101020100000000 ("10030101020100000000", "Pendapatan Administrasi"),
	R_10030101020200000000 ("10030101020200000000", "Pendapatan Provisi"),
	R_10030101020300000000 ("10030101020300000000", "Pendapatan Denda"),
	R_10030101020400000000 ("10030101020400000000", "Pendapatan Operasional Lain Terkait Kegiatan Usaha PMV Lainnya"),
	R_10030101030000000000 ("10030101030000000000", "Pendapatan Operasional Lainnya"),
	R_10030101040000000000 ("10030101040000000000", "Pendapatan Non-Operasional"),
	R_10030101040100000000 ("10030101040100000000", "Pendapatan Bunga/Jasa Giro"),
	R_10030101040200000000 ("10030101040200000000", "Pendapatan Non-Operasional Lainnya"),
	R_10030101050000000000 ("10030101050000000000", "Total Pendapatan"),
//	R_10030102000000000000 ("10030102000000000000", "BEBAN"),
	R_10030102010000000000 ("10030102010000000000", "Beban Operasional"),
	R_10030102010100000000 ("10030102010100000000", "Beban Bunga dan/atau Imbal Hasil"),
	R_10030102010101000000 ("10030102010101000000", "Beban Bunga dari Pinjaman yang Diterima"),
	R_10030102010102000000 ("10030102010102000000", "Beban Bunga dari Surat Berharga yang Diterbitkan"),
	R_10030102010103000000 ("10030102010103000000", "Beban Imbal Hasil atas Pendanaan yang Diterima Berdasarkan Prinsip Syariah"),
	R_10030102010200000000 ("10030102010200000000", "Beban Premi atas Transaksi Swap"),
	R_10030102010300000000 ("10030102010300000000", "Beban Premi Asuransi"),
	R_10030102010400000000 ("10030102010400000000", "Beban Tenaga Kerja"),
	R_10030102010401000000 ("10030102010401000000", "Beban Gaji, Upah, dan Tunjangan"),
	R_10030102010402000000 ("10030102010402000000", "Beban Pengembangan dan Pelatihan Tenaga Kerja"),
	R_10030102010403000000 ("10030102010403000000", "Beban Tenaga Kerja Lainnya"),
	R_10030102010500000000 ("10030102010500000000", "Beban Pemasaran"),
	R_10030102010600000000 ("10030102010600000000", "Beban Penyisihan/Penyusutan"),
	R_10030102010601000000 ("10030102010601000000", "Beban Penyisihan Penghapusan Aset Produktif Pembiayaan/Penyertaan"),
	R_10030102010602000000 ("10030102010602000000", "Beban Penyisihan Penghapusan Aset Produktif Investasi Berdasarkan Prinsip Syariah"),
	R_10030102010603000000 ("10030102010603000000", "Beban Penyusutan Aset Tetap dan Inventaris   "),
	R_10030102010700000000 ("10030102010700000000", "Beban Sewa"),
	R_10030102010800000000 ("10030102010800000000", "Beban Pemeliharaan dan Perbaikan"),
	R_10030102010900000000 ("10030102010900000000", "Beban Administrasi dan Umum"),
	R_10030102011000000000 ("10030102011000000000", "Beban Operasional Lainnya"),
	R_10030102020000000000 ("10030102020000000000", "Beban Non-Operasional"),
	R_10030102030000000000 ("10030102030000000000", "Total Beban"),
	R_10030103000000000000 ("10030103000000000000", "LABA (RUGI) SEBELUM PAJAK"),
//	R_10030104000000000000 ("10030104000000000000", "TAKSIRAN PAJAK PENGHASILAN"),
	R_10030104010000000000 ("10030104010000000000", "Pajak Tahun Berjalan -/-"),
	R_10030104020000000000 ("10030104020000000000", "Pendapatan (Beban) Pajak Tangguhan"),
	R_10030105000000000000 ("10030105000000000000", "LABA (RUGI) BERSIH SETELAH PAJAK"),
	R_10030106000000000000 ("10030106000000000000", "KEUNTUNGAN (KERUGIAN) PENDAPATAN KOMPREHENSIF LAINNYA"),
	R_10030106010000000000 ("10030106010000000000", "Keuntungan (Kerugian) Akibat Perubahan dalam Surplus Revaluasi Aset Tetap"),
	R_10030106020000000000 ("10030106020000000000", "Selisih Kurs Karena Penjabaran Laporan Keuangan dalam Mata Uang Asing"),
	R_10030106030000000000 ("10030106030000000000", "Keuntungan (Kerugian) Akibat Pengukuran Kembali Aset Keuangan Tersedia untuk Dijual "),
	R_10030106040000000000 ("10030106040000000000", "Keuntungan (Kerugian) Akibat Bagian Efektif Instrumen Keuangan Lindung Nilai dalam Rangka Lindung Nilai Arus Kas"),
	R_10030106050000000000 ("10030106050000000000", "Keuntungan (Kerugian) Atas Komponen Ekuitas Lainnya Sesuai Prinsip Standar Akuntansi Keuangan"),
	R_10030107000000000000 ("10030107000000000000", "LABA (RUGI) BERSIH KOMPREHENSIF PERIODE BERJALAN"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2265PosRePmvk100301 eEnum : ER2265PosRePmvk100301.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2265PosRePmvk100301.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2265PosRePmvk100301.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static FieldValidation genValidationSum() {
		return UtilFieldValidation.genEqualsFormula("3-2", 0);
	}

	public static SegmentValidation genValidationPendapatanOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010000000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 1, 7, 13, 14, 15, 18 }),
				"Total Pendapatan Operasional|Penjumlahan Pendapatan Operasional");
	}

	public static SegmentValidation genValidationPendapatanKegiatanOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010100000000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 6),
				"Total Pendapatan Kegiatan Operasi|Penjumlahan Pendapatan Kegiatan Operasi");
	}

	public static SegmentValidation genValidationPendapatanKegiatanOperasiBerdasarkanPrinsipSyariah() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010200000000.key,
				UtilMetadata.genPlusRow(getObjects(), 8, 12),
				"Total Pendapatan Kegiatan Operasi Berdasarkan Prinsip Syariah|Penjumlahan Pendapatan Kegiatan Operasi Berdasarkan Prinsip Syariah");
	}

	public static SegmentValidation genValidationPendapatanDariKegiatanUsahaLain() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010500000000.key,
				UtilMetadata.genPlusRow(getObjects(), 16, 17),
				"Total Pendapatan dari Kegiatan Usaha Lain|Penjumlahan Pendapatan dari Kegiatan Usaha Lain");
	}

	public static SegmentValidation genValidationPendapatanOperasionalLainTerkaitPembiayaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101020000000000.key,
				UtilMetadata.genPlusRow(getObjects(), 20, 23),
				"Total Pendapatan Operasional Lain Terkait Pembiayaan|Penjumlahan Pendapatan Operasional Lain Terkait Pembiayaan");
	}

	public static SegmentValidation genValidationPendapatanNonOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101040000000000.key,
				UtilMetadata.genPlusRow(getObjects(), 26, 27),
				"Total Pendapatan Non-Operasional|Penjumlahan Pendapatan Non-Operasional");
	}

	public static SegmentValidation genValidationTotalPendapatan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101050000000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 19, 24, 25 }),
				"Total Pendapatan|Penjumlahan Pendapatan");
	}

	public static SegmentValidation genValidationBebanOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030102010000000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 30, 34, 35, 36, 40, 41, 45, 46, 47, 48 }),
				"Total Beban Operasional|Penjumlahan Beban Operasional");
	}

	public static SegmentValidation genValidationBebanBunga() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030102010100000000.key,
				UtilMetadata.genPlusRow(getObjects(), 31, 33),
				"Total Beban Bunga dan/atau Imbal Hasil|Penjumlahan Beban Bunga dan/atau Imbal Hasil");
	}

	public static SegmentValidation genValidationBebanTenagaKerja() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030102010400000000.key,
				UtilMetadata.genPlusRow(getObjects(), 37, 39),
				"Total Beban Tenaga Kerja|Penjumlahan Beban Tenaga Kerja");
	}

	public static SegmentValidation genValidationBebanPenyisihan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030102010600000000.key,
				UtilMetadata.genPlusRow(getObjects(), 42, 44),
				"Total Beban Penyisihan/Penyusutan|Penjumlahan Beban Penyisihan/Penyusutan");
	}

	public static SegmentValidation genValidationTotalBeban() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030102030000000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 29, 49 }),
				"Total Beban|Penjumlahan Beban");
	}

	public static SegmentValidation genValidationLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030103000000000000.key,
				UtilMetadata.genMinusRow(getObjects(), new int[] { 28, 50 }),
				"Total Laba (Rugi) Sebelum Pajak|Penjumlahan Laba (Rugi) Sebelum Pajak");
	}

	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030105000000000000.key,
				R_10030103000000000000.key + "-" + R_10030104010000000000.key + "+" + R_10030104020000000000.key,
				"Total Laba (Rugi) Bersih Setelah Pajak|Penjumlahan Laba (Rugi) Bersih Setelah Pajak");
	}

	public static SegmentValidation genValidationKeuntunganPendapatanKomprehensifLainnya() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030106000000000000.key,
				UtilMetadata.genPlusRow(getObjects(), 56, 60),
				"Total Keuntungan (Kerugian) Pendapatan Komprehensif Lainnya|Penjumlahan Keuntungan (Kerugian) Pendapatan Komprehensif Lainnya");
	}

	public static SegmentValidation genValidationLabaBersihKomprehensifPeriodeBerjalan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030107000000000000.key,
				UtilMetadata.genPlusRow(getObjects(), 54, 55),
				"Total Laba (Rugi) Bersih Komprehensif Periode Berjalan|Penjumlahan Laba (Rugi) Bersih Komprehensif Periode Berjalan");
	}

	public static SegmentValidation genValidationFormLabaSetelahPajak() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_10030105000000000000.key, comparatorFormCode, 
				ER2264PosRePmvk100201.R_10020103040000.getKey(), 
				"Total Laba (Rugi) Bersih Setelah Pajak|Nilai Laba (Rugi) Bersih Setelah Pajak form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormKeuntunganPendapatanKomprehensifLainnya() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_10030106000000000000.key, comparatorFormCode, 
				ER2264PosRePmvk100201.R_10020103050200.getKey(), 
				"Total Keuntungan (Kerugian) Pendapatan Komprehensif Lainnya|Nilai Keuntungan (Kerugian) Komperehensif Lainnya Periode Berjalan form " + comparatorFormCode + " #kolom#");
	}
}
