package id.go.ojk.ppk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppk.client.builder.field.EFormRealisasiBisnis;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2268PosRePpk100301 implements IObject<KeyValueString> {
	R_10030101000000000000 ("10030101000000000000", "PENDAPATAN"),
	R_10030101010000000000 ("10030101010000000000", "Pendapatan Operasional"),
	R_10030101010100000000 ("10030101010100000000", "Pendapatan Kegiatan Operasi"),
	R_10030101010101000000 ("10030101010101000000", "Pendapatan Bunga dari Kegiatan Pembiayaan Konvensional"),
	R_10030101010101010000 ("10030101010101010000", "Pembiayaan Investasi"),
	R_10030101010101010100 ("10030101010101010100", "Sewa Pembiayaan "),
	R_10030101010101010200 ("10030101010101010200", "Jual dan Sewa-Balik "),
	R_10030101010101010300 ("10030101010101010300", "Anjak Piutang dengan Pemberian Jaminan dari Penjual Piutang"),
	R_10030101010101010400 ("10030101010101010400", "Anjak Piutang tanpa Pemberian Jaminan dari Penjual Piutang"),
	R_10030101010101010500 ("10030101010101010500", "Pembelian dengan Pembayaran Secara Angsuran            "),
	R_10030101010101010600 ("10030101010101010600", "Pembiayaan Proyek             "),
	R_10030101010101010700 ("10030101010101010700", "Pembiayaan Infrastruktur"),
	R_10030101010101010800 ("10030101010101010800", "Skema Lain dengan Persetujuan OJK"),
	R_10030101010101020000 ("10030101010101020000", "Pembiayaan Modal Kerja"),
	R_10030101010101020100 ("10030101010101020100", "Jual dan Sewa-Balik "),
	R_10030101010101020200 ("10030101010101020200", "Anjak Piutang dengan Pemberian Jaminan dari Penjual Piutang"),
	R_10030101010101020300 ("10030101010101020300", "Anjak Piutang tanpa Pemberian Jaminan dari Penjual Piutang"),
	R_10030101010101020400 ("10030101010101020400", "Fasilitas Modal Usaha         "),
	R_10030101010101020500 ("10030101010101020500", "Skema Lain dengan Persetujuan OJK"),
	R_10030101010101030000 ("10030101010101030000", "Pembiayaan Multiguna"),
	R_10030101010101030100 ("10030101010101030100", "Sewa Pembiayaan"),
	R_10030101010101030200 ("10030101010101030200", "Pembelian dengan Pembayaran Secara Angsuran             "),
	R_10030101010101030300 ("10030101010101030300", "Fasilitas Dana"),
	R_10030101010101030400 ("10030101010101030400", "Skema Lain dengan Persetujuan OJK            "),
	R_10030101010101040000 ("10030101010101040000", "Pembiayaan Lainnya Berdasarkan Persetujuan OJK"),
	R_10030101010102000000 ("10030101010102000000", "Pembiayaan Berdasarkan Prinsip Syariah"),
	R_10030101010102010000 ("10030101010102010000", "Pendapatan Margin dari Kegiatan Pembiayaan Jual Beli"),
	R_10030101010102020000 ("10030101010102020000", "Pendapatan Bagi Hasil dari Kegiatan Pembiayaan Investasi"),
	R_10030101010102030000 ("10030101010102030000", "Pendapatan Imbal Jasa dari Pembiayaan Jasa"),
	R_10030101010103000000 ("10030101010103000000", "Pendapatan dari Kegiatan Penerusan Pembiayaan "),
	R_10030101010104000000 ("10030101010104000000", "Pendapatan dari Kegiatan Pembiayaan Bersama"),
	R_10030101010200000000 ("10030101010200000000", "Pendapatan Operasional Lain Terkait Pembiayaan"),
	R_10030101010201000000 ("10030101010201000000", "Pendapatan Administrasi"),
	R_10030101010202000000 ("10030101010202000000", "Pendapatan Provisi"),
	R_10030101010203000000 ("10030101010203000000", "Pendapatan Denda"),
	R_10030101010204000000 ("10030101010204000000", "Diskon Asuransi"),
	R_10030101010205000000 ("10030101010205000000", "Pendapatan Operasional Lain Terkait Pembiayaan Lainnya"),
	R_10030101010300000000 ("10030101010300000000", "Pendapatan Operasional Tidak Terkait Pembiayaan"),
	R_10030101010301000000 ("10030101010301000000", "Pendapatan dari Sewa Operasi"),
	R_10030101010302000000 ("10030101010302000000", "Pendapatan dari Kegiatan Berbasis Fee"),
	R_10030101010302010000 ("10030101010302010000", "Pemasaran Produk Reksadana"),
	R_10030101010302020000 ("10030101010302020000", "Pemasaran Produk Asuransi"),
	R_10030101010302030000 ("10030101010302030000", "Pemasaran Produk Lainnya"),
	R_10030101010303000000 ("10030101010303000000", "Pendapatan Operasional Lainnya Tidak Terkait Pembiayaan"),
	R_10030101020000000000 ("10030101020000000000", "Pendapatan Non-Operasional"),
	R_10030101020100000000 ("10030101020100000000", "Pendapatan Bunga/Jasa Giro"),
	R_10030101020200000000 ("10030101020200000000", "Pendapatan Non-Operasional Lainnya"),
	R_10030102000000000000 ("10030102000000000000", "BEBAN"),
	R_10030102010000000000 ("10030102010000000000", "Beban Operasional"),
	R_10030102010100000000 ("10030102010100000000", "Beban Bunga"),
	R_10030102010101000000 ("10030102010101000000", "Beban Bunga dari Pinjaman yang Diterima"),
	R_10030102010102000000 ("10030102010102000000", "Beban Bunga dari Surat Berharga yang Diterbitkan"),
	R_10030102010103000000 ("10030102010103000000",
			"Beban Bagi Hasil atas Pendanaan yang Diterima Berdasarkan Prinsip Syariah"),
	R_10030102010200000000 ("10030102010200000000", "Beban Kontribusi (Premi) atas Transaksi Swap"),
	R_10030102010300000000 ("10030102010300000000", "Beban Premi Asuransi/Kontribusi Asuransi Syariah"),
	R_10030102010400000000 ("10030102010400000000", "Beban Tenaga Kerja"),
	R_10030102010401000000 ("10030102010401000000", "Beban Gaji, Upah, dan Tunjangan"),
	R_10030102010402000000 ("10030102010402000000", "Beban Pendidikan dan Pelatihan Tenaga Kerja"),
	R_10030102010403000000 ("10030102010403000000", "Beban Tenaga Kerja Lainnya"),
	R_10030102010500000000 ("10030102010500000000", "Beban Pemasaran"),
	R_10030102010501000000 ("10030102010501000000", "Beban Insentif Pihak Ketiga"),
	R_10030102010502000000 ("10030102010502000000", "Beban Pemasaran Lainnya"),
	R_10030102010600000000 ("10030102010600000000", "Beban Penyisihan/Penyusutan"),
	R_10030102010601000000 ("10030102010601000000", "Beban Penyisihan Piutang Ragu-Ragu:"),
	R_10030102010601010000 ("10030102010601010000", "Beban Operasional Pembiayaan Investasi"),
	R_10030102010601020000 ("10030102010601020000", "Beban Pembiayaan Modal Kerja"),
	R_10030102010601030000 ("10030102010601030000", "Beban Pembiayaan Multiguna"),
	R_10030102010601040000 ("10030102010601040000", "Beban Pembiayaan Lainnya Berdasarkan Persetujuan OJK"),
	R_10030102010601050000 ("10030102010601050000", "Beban Pembiayaan Berdasarkan Prinsip Syariah"),
	R_10030102010602000000 ("10030102010602000000", "Beban Penyusutan Aset Tetap yang Di Sewa Operasikan"),
	R_10030102010603000000 ("10030102010603000000", "Beban Penyusutan Aset Tetap dan Inventaris"),
	R_10030102010700000000 ("10030102010700000000", "Beban Sewa"),
	R_10030102010800000000 ("10030102010800000000", "Beban Pemeliharaan dan Perbaikan"),
	R_10030102010900000000 ("10030102010900000000", "Beban Administrasi dan Umum"),
	R_10030102011000000000 ("10030102011000000000", "Beban Operasional Lainnya"),
	R_10030102020000000000 ("10030102020000000000", "Beban Non-Operasional"),
	R_10030103000000000000 ("10030103000000000000", "LABA (RUGI) SEBELUM PAJAK"),
//	R_10030104000000000000 ("10030104000000000000", "TAKSIRAN PAJAK PENGHASILAN"),
	R_10030104010000000000 ("10030104010000000000", "Pajak Tahun Berjalan -/-"),
	R_10030104020000000000 ("10030104020000000000", "Pendapatan (Beban) Pajak Tangguhan"),
	R_10030105000000000000 ("10030105000000000000", "LABA (RUGI) SETELAH PAJAK"),
	R_10030106000000000000 ("10030106000000000000", "KEUNTUNGAN (KERUGIAN) PENDAPATAN KOMPREHENSIF LAINNYA"),
	R_10030106010000000000 ("10030106010000000000",
			"Keuntungan (Kerugian) Akibat Perubahan dalam Surplus Revaluasi Aset Tetap"),
	R_10030106020000000000 ("10030106020000000000",
			"Selisih Kurs Karena Penjabaran Laporan Keuangan dalam Mata Uang Asing"),
	R_10030106030000000000 ("10030106030000000000",
			"Keuntungan (Kerugian) Akibat Pengukuran Kembali Aset Keuangan Tersedia untuk Dijual "),
	R_10030106040000000000 ("10030106040000000000",
			"Keuntungan (Kerugian) Akibat Bagian Efektif Instrumen Keuangan Lindung Nilai dalam Rangka Lindung Nilai Arus Kas"),
	R_10030106050000000000 ("10030106050000000000",
			"Keuntungan (Kerugian) Atas Komponen Ekuitas Lainnya Sesuai Prinsip Standar Akuntansi Keuangan"),
	R_10030107000000000000 ("10030107000000000000", "LABA (RUGI) BERSIH KOMPREHENSIF PERIODE BERJALAN"),;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2268PosRePpk100301 eEnum : ER2268PosRePpk100301.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2268PosRePpk100301.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2268PosRePpk100301.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static FieldValidation genValidationSum() {
		return UtilFieldValidation.genEqualsFormula("3-2", 2);
	}

	public static SegmentValidation genValidationFormLabaSetelahPajak() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_10030105000000000000.key, comparatorFormCode, 
				ER2267PosRePpk100201.R_10020103040000.getKey(), 
				"Nilai Laba (Rugi) Setelah Pajak|Nilai Laba (Rugi) Bersih Setelah Pajak form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormKeuntunganPendapatanKomprehensifLainnya() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_10030106000000000000.key, comparatorFormCode, 
				ER2267PosRePpk100201.R_10020103050200.getKey(), 
				"Nilai Keuntungan Pendapatan Komprehensif Lainnya|Nilai Keuntungan Pendapatan Komprehensif Lainnya form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationPendapatan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101000000000000.key,
				R_10030101010000000000.key + "+" + R_10030101020000000000.key, 
				"Total Pendapatan|Penjumlahan Pendapatan");
	}

	public static SegmentValidation genValidationPendapatanOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010000000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 2, 31, 37 }),
				"Total Pendapatan Operasional|Penjumlahan Pendapatan Operasional");
	}

	public static SegmentValidation genValidationPendapatanKegiatanOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010100000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 3, 25, 29, 30 }),
				"Total Pendapatan Kegiatan Operasi|Penjumlahan Pendapatan Kegiatan Operasi");
	}

	public static SegmentValidation genValidationPendapatanBungaDariKegiatanPembiayaanKonvensional() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010101000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 4, 13, 19, 24 }),
				"Total Pendapatan Bunga dari Kegiatan Pembiayaan Konvensional|Penjumlahan Pendapatan Bunga dari Kegiatan Pembiayaan Konvensional");
	}

	public static SegmentValidation genValidationPembiayaanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010101010000.key,
				UtilMetadata.genPlusRow(getObjects(), 5, 12),
				"Total Pembiayaan Investasi|Penjumlahan Pembiayaan Investasi");
	}

	public static SegmentValidation genValidationPembiayaanModalKerja() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010101020000.key,
				UtilMetadata.genPlusRow(getObjects(), 14, 18),
				"Total Pembiayaan Modal Kerja|Penjumlahan Pembiayaan Modal Kerja");
	}

	public static SegmentValidation genValidationPembiayaanMultiguna() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010101030000.key,
				UtilMetadata.genPlusRow(getObjects(), 20, 23),
				"Total Pembiayaan Multiguna|Penjumlahan Pembiayaan Multiguna");
	}

	public static SegmentValidation genValidationPembiayaanBerdasarkanPrinsipSyariah() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010102000000.key,
				UtilMetadata.genPlusRow(getObjects(), 26, 28),
				"Total Pembiayaan Berdasarkan Prinsip Syariah|Penjumlahan Pembiayaan Berdasarkan Prinsip Syariah");
	}

	public static SegmentValidation genValidationPendapatanOperasionalLainTerkaitPembiayaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010200000000.key,
				UtilMetadata.genPlusRow(getObjects(), 32, 36),
				"Total Pendapatan Operasional Lain Terkait Pembiayaan|Penjumlahan Pendapatan Operasional Lain Terkait Pembiayaan");
	}

	public static SegmentValidation genValidationPendapatanOperasionalTidakTerkaitPembiayaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010300000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 38, 39, 43 }),
				"Total Pendapatan Operasional Tidak Terkait Pembiayaan|Penjumlahan Pendapatan Operasional Tidak Terkait Pembiayaan");
	}

	public static SegmentValidation genValidationPendapatanDariKegiatanBerbasisFee() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101010302000000.key,
				UtilMetadata.genPlusRow(getObjects(), 40, 42),
				"Total Pendapatan dari Kegiatan Berbasis Fee|Penjumlahan Pendapatan dari Kegiatan Berbasis Fee");
	}

	public static SegmentValidation genValidationPendapatanNonOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030101020000000000.key,
				R_10030101020100000000.key + "+" + R_10030101020200000000.key,
				"Total Pendapatan Non-Operasional|Penjumlahan Pendapatan Non-Operasional");
	}

	public static SegmentValidation genValidationBeban() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030102000000000000.key,
				R_10030102010000000000.key + "+" + R_10030102020000000000.key, 
				"Total Beban|Penjumlahan Beban");
	}

	public static SegmentValidation genValidationBebanOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030102010000000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 49, 53, 54, 55, 59, 62, 71, 72, 73, 74 }),
				"Total Beban Operasional|Penjumlahan Beban Operasional");
	}

	public static SegmentValidation genValidationBebanBunga() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030102010100000000.key,
				UtilMetadata.genPlusRow(getObjects(), 50, 52),
				"Total Beban Bunga|Penjumlahan Beban Bunga");
	}

	public static SegmentValidation genValidationBebanTenagaKerja() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030102010400000000.key,
				UtilMetadata.genPlusRow(getObjects(), 56, 58),
				"Total Beban Tenaga Kerja|Penjumlahan Beban Tenaga Kerja");
	}

	public static SegmentValidation genValidationBebanPemasaran() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030102010500000000.key,
				R_10030102010501000000.key + "+" + R_10030102010502000000.key,
				"Total Beban Pemasaran|Penjumlahan Beban Pemasaran");
	}

	public static SegmentValidation genValidationBebanPenyisihan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030102010600000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 63, 69, 70 }),
				"Total Beban Penyisihan/Penyusutan|Penjumlahan Beban Penyisihan/Penyusutan");
	}

	public static SegmentValidation genValidationBebanPenyisihanPiutang() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030102010601000000.key,
				UtilMetadata.genPlusRow(getObjects(), 64, 68),
				"Total Beban Penyisihan Piutang Ragu-Ragu|Penjumlahan Beban Penyisihan Piutang Ragu-Ragu");
	}

	public static SegmentValidation genValidationLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030103000000000000.key,
				R_10030101000000000000.key + "-" + R_10030102000000000000.key,
				"Total Laba (Rugi) Sebelum Pajak|Penjumlahan Laba (Rugi) Sebelum Pajak");
	}

	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030105000000000000.key,
				R_10030103000000000000.key + "-" + R_10030104010000000000.key + "+" + R_10030104020000000000.key,
				"Total Laba (Rugi) Setelah Pajak|Penjumlahan Laba (Rugi) Setelah Pajak");
	}

	public static SegmentValidation genValidationKeuntunganPendapatanKomprehensifLainnya() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030106000000000000.key,
				UtilMetadata.genPlusRow(getObjects(), 81, 85),
				"Total Keuntungan (Kerugian) Pendapatan Komprehensif Lainnya|Penjumlahan Keuntungan (Kerugian) Pendapatan Komprehensif Lainnya");
	}

	public static SegmentValidation genValidationLabaBersihKomprehensifPeriodeBerjalan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030107000000000000.key,
				R_10030105000000000000.key + "+" + R_10030106000000000000.key,
				"Total Laba (Rugi) Bersih Komprehensif Periode Berjalan|Penjumlahan Laba (Rugi) Bersih Komprehensif Periode Berjalan");
	}
}
