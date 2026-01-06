package id.go.ojk.pmvk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pmvk.client.builder.field.EFormRealisasiBisnisUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2765PosRePmvu100302 implements IObject<KeyValueString> {
//	R_10030201000000000000 ("10030201000000000000", "PENDAPATAN"),
	R_10030201010000000000 ("10030201010000000000", "Pendapatan Operasional"),
	R_10030201010100000000 ("10030201010100000000", "Pendapatan dari Kegiatan Operasi Berdasarkan Prinsip Syariah"),
	R_10030201010101000000 ("10030201010101000000", "Pendapatan Dividen dari Kegiatan Penyertaan Saham"),
	R_10030201010102000000 ("10030201010102000000", "Pendapatan dari keuntungan penjualan aset penyertaan atau surat berharga"),
	R_10030201010103000000 ("10030201010103000000", "Pendapatan Imbal Hasil dari Kegiatan Pembelian Sukuk atau Obligasi Syariah Konversi "),
	R_10030201010104000000 ("10030201010104000000", "Pendapatan Imbal Hasil dari Kegiatan Pembelian Sukuk atau Obligasi Syariah yang Diterbitkan Pasangan Usaha pada Tahap Rintisan Awal (Start-up dan/atau Pengembangan Usaha)"),
	R_10030201010105000000 ("10030201010105000000", "Pendapatan Bagi Hasil dari Kegiatan Pembiayaan Berdasarkan Prinsip Bagi Hasil "),
	R_10030201010200000000 ("10030201010200000000", "Pendapatan dari Penyertaan pada Dana Ventura"),
	R_10030201010300000000 ("10030201010300000000", "Pendapatan dari Kegiatan Pengelolaan Dana Ventura "),
	R_10030201010400000000 ("10030201010400000000", "Pendapatan dari Kegiatan Usaha Lain"),
	R_10030201010401000000 ("10030201010401000000", "Pendapatan dari Kegiatan Pelayanan Jasa "),
	R_10030201010402000000 ("10030201010402000000", "Pendapatan dari Kegiatan Usaha Lain dengan Persetujuan Otoritas Jasa Keuangan "),
	R_10030201010500000000 ("10030201010500000000", "Pendapatan Imbal Jasa dari Kegiatan Penerusan Pembiayaan (Channeling) "),
	R_10030201020000000000 ("10030201020000000000", "Pendapatan Operasional Lain Terkait Pembiayaan"),
	R_10030201020100000000 ("10030201020100000000", "Pendapatan Administrasi"),
	R_10030201020200000000 ("10030201020200000000", "Pendapatan Provisi"),
	R_10030201020300000000 ("10030201020300000000", "Pendapatan Operasional Lain Terkait Kegiatan Usaha PMV Lainnya"),
	R_10030201030000000000 ("10030201030000000000", "Pendapatan Operasional Lainnya"),
	R_10030201040000000000 ("10030201040000000000", "Pendapatan Non-Operasional"),
	R_10030201040100000000 ("10030201040100000000", "Pendapatan Jasa Giro"),
	R_10030201040200000000 ("10030201040200000000", "Pendapatan Non-Operasional Lainnya"),
	R_10030201050000000000 ("10030201050000000000", "Total Pendapatan"),
//	R_10030202000000000000 ("10030202000000000000", "BEBAN"),
	R_10030202010000000000 ("10030202010000000000", "Beban Operasional"),
	R_10030202010100000000 ("10030202010100000000", "Beban Imbal Hasil"),
	R_10030202010101000000 ("10030202010101000000", "Beban Bagi Hasil atas Pendanaan yang Diterima"),
	R_10030202010102000000 ("10030202010102000000", "Beban Imbal Hasil dari Surat Berharga yang Diterbitkan"),
	R_10030202010200000000 ("10030202010200000000", "Beban Premi atas Transaksi Swap"),
	R_10030202010300000000 ("10030202010300000000", "Beban Premi Asuransi"),
	R_10030202010400000000 ("10030202010400000000", "Beban Tenaga Kerja"),
	R_10030202010401000000 ("10030202010401000000", "Beban Gaji, Upah, dan Tunjangan"),
	R_10030202010402000000 ("10030202010402000000", "Beban Pengembangan dan Pelatihan Tenaga Kerja"),
	R_10030202010403000000 ("10030202010403000000", "Beban Tenaga Kerja Lainnya"),
	R_10030202010500000000 ("10030202010500000000", "Beban Pemasaran"),
	R_10030202010600000000 ("10030202010600000000", "Beban Penyisihan/Penyusutan"),
	R_10030202010601000000 ("10030202010601000000", "Beban Penyisihan Penghapusan Aset Produktif Investasi Berdasarkan Prinsip Syariah"),
	R_10030202010602000000 ("10030202010602000000", "Beban Penyusutan Aset Tetap dan Inventaris   "),
	R_10030202010700000000 ("10030202010700000000", "Beban Sewa"),
	R_10030202010800000000 ("10030202010800000000", "Beban Pemeliharaan dan Perbaikan"),
	R_10030202010900000000 ("10030202010900000000", "Beban Administrasi dan Umum"),
	R_10030202011000000000 ("10030202011000000000", "Beban Operasional Lainnya"),
	R_10030202020000000000 ("10030202020000000000", "Beban Non-Operasional"),
	R_10030202030000000000 ("10030202030000000000", "Total Beban"),
	R_10030203000000000000 ("10030203000000000000", "LABA (RUGI) SEBELUM PAJAK"),
//	R_10030204000000000000 ("10030204000000000000", "TAKSIRAN PAJAK PENGHASILAN"),
	R_10030204010000000000 ("10030204010000000000", "Pajak Tahun Berjalan -/-"),
	R_10030204020000000000 ("10030204020000000000", "Pendapatan (Beban) Pajak Tangguhan"),
	R_10030205000000000000 ("10030205000000000000", "LABA (RUGI) BERSIH SETELAH PAJAK"),
	R_10030206000000000000 ("10030206000000000000", "KEUNTUNGAN (KERUGIAN) PENDAPATAN KOMPREHENSIF LAINNYA"),
	R_10030206010000000000 ("10030206010000000000", "Keuntungan (Kerugian) Akibat Perubahan dalam Surplus Revaluasi Aset Tetap"),
	R_10030206020000000000 ("10030206020000000000", "Selisih Kurs Karena Penjabaran Laporan Keuangan dalam Mata Uang Asing"),
	R_10030206030000000000 ("10030206030000000000", "Keuntungan (Kerugian) Akibat Pengukuran Kembali Aset Keuangan Tersedia untuk Dijual "),
	R_10030206040000000000 ("10030206040000000000", "Keuntungan (Kerugian) Akibat Bagian Efektif Instrumen Keuangan Lindung Nilai dalam Rangka Lindung Nilai Arus Kas"),
	R_10030206050000000000 ("10030206050000000000", "Keuntungan (Kerugian) Atas Komponen Ekuitas Lainnya Sesuai Prinsip Standar Akuntansi Keuangan"),
	R_10030207000000000000 ("10030207000000000000", "LABA (RUGI) BERSIH KOMPREHENSIF PERIODE BERJALAN"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2765PosRePmvu100302 eEnum : ER2765PosRePmvu100302.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2765PosRePmvu100302.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2765PosRePmvu100302.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}
	
	public static FieldValidation genValidationSum() {
		return UtilFieldValidation.genEqualsPosFormula("3-2", 0, UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 1, 9, 13, 18, 21, 22, 23, 28, 33, 41, 42, 45, 46, 52 }));
	}

	public static SegmentValidation genValidationPendapatanOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030201010000000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 1, 7, 8, 9, 12 }),
				"Total Pendapatan Operasional|Penjumlahan Pendapatan Operasional");
	}

	public static SegmentValidation genValidationPendapatanDariKegiatanOperasiBerdasarkanPrinsipSyariah() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030201010100000000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 6),
				"Total Pendapatan dari Kegiatan Operasi Berdasarkan Prinsip Syariah|Penjumlahan Pendapatan dari Kegiatan Operasi Berdasarkan Prinsip Syariah");
	}

	public static SegmentValidation genValidationPendapatanDariKegiatanUsahaLain() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030201010400000000.key,
				UtilMetadata.genPlusRow(getObjects(), 10, 11),
				"Total Pendapatan dari Kegiatan Usaha Lain|Penjumlahan Pendapatan dari Kegiatan Usaha Lain");
	}

	public static SegmentValidation genValidationPendapatanOperasionalLainTerkaitPembiayaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030201020000000000.key,
				UtilMetadata.genPlusRow(getObjects(), 14, 16),
				"Total Pendapatan Operasional Lain Terkait Pembiayaan|Penjumlahan Pendapatan Operasional Lain Terkait Pembiayaan");
	}

	public static SegmentValidation genValidationPendapatanNonOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030201040000000000.key,
				UtilMetadata.genPlusRow(getObjects(), 19, 20),
				"Total Pendapatan Non-Operasional|Penjumlahan Pendapatan Non-Operasional");
	}

	public static SegmentValidation genValidationTotalPendapatan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030201050000000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 13, 17, 18 }),
				"Total Pendapatan|Penjumlahan Pendapatan");
	}

	public static SegmentValidation genValidationBebanOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030202010000000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 23, 26, 27, 28, 32, 33, 36, 37, 38, 39 }),
				"Total Beban Operasional|Penjumlahan Beban Operasional");
	}

	public static SegmentValidation genValidationBebanImbalHasil() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030202010100000000.key,
				UtilMetadata.genPlusRow(getObjects(), 24, 25),
				"Total Beban Imbal Hasil|Penjumlahan Beban Imbal Hasil");
	}

	public static SegmentValidation genValidationBebanTenagaKerja() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030202010400000000.key,
				UtilMetadata.genPlusRow(getObjects(), 29, 31),
				"Total Beban Tenaga Kerja|Penjumlahan Beban Tenaga Kerja");
	}

	public static SegmentValidation genValidationBebanPenyisihan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030202010600000000.key,
				UtilMetadata.genPlusRow(getObjects(), 34, 35),
				"Total Beban Penyisihan/Penyusutan|Penjumlahan Beban Penyisihan/Penyusutan");
	}

	public static SegmentValidation genValidationTotalBeban() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030202030000000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 22, 40 }),
				"Total Beban|Penjumlahan Beban");
	}

	public static SegmentValidation genValidationLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030203000000000000.key,
				UtilMetadata.genMinusRow(getObjects(), new int[] { 21, 41 }),
				"Total Laba (Rugi) Sebelum Pajak|Penjumlahan Laba (Rugi) Sebelum Pajak");
	}

	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030205000000000000.key,
				R_10030203000000000000.key + "-" + R_10030204010000000000.key + "+" + R_10030204020000000000.key,
				"Total Laba (Rugi) Bersih Setelah Pajak|Penjumlahan Laba (Rugi) Bersih Setelah Pajak");
	}

	public static SegmentValidation genValidationKeuntunganPendapatanKomprehensifLainnya() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030206000000000000.key,
				UtilMetadata.genPlusRow(getObjects(), 47, 51),
				"Total Keuntungan (Kerugian) Pendapatan Komprehensif Lainnya|Penjumlahan Keuntungan (Kerugian) Pendapatan Komprehensif Lainnya");
	}

	public static SegmentValidation genValidationLabaBersihKomprehensifPeriodeBerjalan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_10030207000000000000.key,
				UtilMetadata.genPlusRow(getObjects(), 45, 46),
				"Total Laba (Rugi) Bersih Komprehensif Periode Berjalan|Penjumlahan Laba (Rugi) Bersih Komprehensif Periode Berjalan");
	}

	public static SegmentValidation genValidationFormLabaSetelahPajak() {
		String comparatorFormCode = EFormRealisasiBisnisUus.RE_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_10030205000000000000.key, comparatorFormCode, 
				ER2764PosRePmvu100202.R_10020203040000.getKey(), 
				"Total Laba (Rugi) Bersih Setelah Pajak|Nilai Laba (Rugi) Bersih Setelah Pajak form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormKeuntunganPendapatanKomprehensifLainnya() {
		String comparatorFormCode = EFormRealisasiBisnisUus.RE_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_10030206000000000000.key, comparatorFormCode, 
				ER2764PosRePmvu100202.R_10020203050200.getKey(), 
				"Total Keuntungan (Kerugian) Pendapatan Komprehensif Lainnya|Nilai Keuntungan (Kerugian) Komperehensif Lainnya Periode Berjalan form " + comparatorFormCode + " #kolom#");
	}
}
