package id.go.ojk.pps.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pps.client.builder.field.EFormRealisasiBisnis;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2269PosRePps100302 implements IObject<KeyValueString> {
	R_10030201000000000000 ("10030201000000000000", "PENDAPATAN"),
	R_10030201010000000000 ("10030201010000000000", "Pendapatan Operasional"),
	R_10030201010100000000 ("10030201010100000000", "Pendapatan dari Kegiatan Pembiayaan "),
	R_10030201010101000000 ("10030201010101000000", "Pendapatan Margin Pembiayaan Jual Beli"),
	R_10030201010101010000 ("10030201010101010000", "Pendapatan Margin Murabahah"),
	R_10030201010101020000 ("10030201010101020000", "Pendapatan Margin Salam"),
	R_10030201010101030000 ("10030201010101030000", "Pendapatan Margin Istishna"),
	R_10030201010101040000 ("10030201010101040000", "Pendapatan Margin dengan akad jual beli lainnya"),
	R_10030201010102000000 ("10030201010102000000", "Pendapatan Bagi Hasil Pembiayaan Investasi"),
	R_10030201010102010000 ("10030201010102010000", "Pendapatan Bagi Hasil Mudharabah"),
	R_10030201010102020000 ("10030201010102020000", "Pendapatan Bagi Hasil Musyarakah"),
	R_10030201010102030000 ("10030201010102030000", "Pendapatan Bagi Hasil Mudharabah Musytarakah"),
	R_10030201010102040000 ("10030201010102040000", "Pendapatan Bagi Hasil Musyarakah Mutanaqisah"),
	R_10030201010102050000 ("10030201010102050000", "Pendapatan Bagi Hasil dari akad investasi lainnya"),
	R_10030201010103000000 ("10030201010103000000", "Pendapatan Imbal Jasa Pembiayaan Jasa"),
	R_10030201010103010000 ("10030201010103010000", "Pendapatan Imbal Jasa Ijarah"),
	R_10030201010103020000 ("10030201010103020000", "Pendapatan Imbal Jasa Ijarah Muntahiyah Bittamlik (IMBT)"),
	R_10030201010103030000 ("10030201010103030000", "Pendapatan Imbal Jasa Hawalah bil ujrah"),
	R_10030201010103040000 ("10030201010103040000", "Pendapatan Imbal Jasa Wakalah bil ujrah"),
	R_10030201010103050000 ("10030201010103050000", "Pendapatan Imbal Jasa Kafalah bil ujrah"),
	R_10030201010103060000 ("10030201010103060000", "Pendapatan Imbal Jasa Ju'alah"),
	R_10030201010103070000 ("10030201010103070000", "Pendapatan Imbal Jasa dari akad pembiayaan jasa lainnya"),
	R_10030201010104000000 ("10030201010104000000", "Pendapatan dari Kegiatan Pembiayaan Penerusan (Channeling)"),
	R_10030201010105000000 ("10030201010105000000", "Pendapatan dari Kegiatan Pembiayaan Bersama (Joint Financing)"),
	R_10030201010200000000 ("10030201010200000000", "Pendapatan Operasional Lain Terkait Pembiayaan"),
	R_10030201010201000000 ("10030201010201000000", "Pendapatan administrasi"),
	R_10030201010202000000 ("10030201010202000000", "Pendapatan Provisi"),
	R_10030201010203000000 ("10030201010203000000", "Pendapatan Ganti Rugi (Ta'widh)"),
	R_10030201010204000000 ("10030201010204000000", "Diskon Asuransi"),
	R_10030201010205000000 ("10030201010205000000", "Pendapatan Operasional Terkait Pembiayaan Lainnya"),
	R_10030201020000000000 ("10030201020000000000", "Pendapatan Non-Operasional"),
	R_10030201020100000000 ("10030201020100000000", "Pendapatan Imbal Jasa/Jasa Giro"),
	R_10030201020200000000 ("10030201020200000000", "Pendapatan Non-Operasional Lainnya"),
	R_10030202000000000000 ("10030202000000000000", "BEBAN"),
	R_10030202010000000000 ("10030202010000000000", "Beban Operasional"),
	R_10030202010100000000 ("10030202010100000000", "Beban Margin/Bagi Hasil/Imbal Jasa"),
	R_10030202010101000000 ("10030202010101000000", "Beban Margin/Bagi Hasil/Imbal Jasa Akad Mudharabah"),
	R_10030202010102000000 ("10030202010102000000", "Beban Margin/Bagi Hasil/Imbal Jasa Akad Mudharabah Musytarakah"),
	R_10030202010103000000 ("10030202010103000000", "Beban Margin/Bagi Hasil/Imbal Jasa Akad Musyarakah"),
	R_10030202010104000000 ("10030202010104000000", "Beban Margin/Bagi Hasil/Imbal Jasa Akad Ijarah"),
	R_10030202010105000000 ("10030202010105000000", "Beban Margin/Bagi Hasil/Imbal Jasa Akad Wakalah bil Ujrah untuk kegiatan pembiayaan"),
	R_10030202010106000000 ("10030202010106000000", "Beban Margin/Bagi Hasil/Imbal Jasa Akad pendanaan lainnya"),
	R_10030202010200000000 ("10030202010200000000", "Beban Premi Swap"),
	R_10030202010300000000 ("10030202010300000000", "Beban Kontribusi Asuransi Syariah"),
	R_10030202010400000000 ("10030202010400000000", "Beban Tenaga Kerja"),
	R_10030202010401000000 ("10030202010401000000", "Beban Gaji, Upah, dan Tunjangan"),
	R_10030202010402000000 ("10030202010402000000", "Beban Pengembangan dan Pelatihan Tenaga Kerja"),
	R_10030202010403000000 ("10030202010403000000", "Beban Tenaga Kerja Lainnya"),
	R_10030202010500000000 ("10030202010500000000", "Beban Pemasaran"),
	R_10030202010501000000 ("10030202010501000000", "Beban Insentif Pihak Ketiga"),
	R_10030202010502000000 ("10030202010502000000", "Beban Pemasaran Lainnya"),
	R_10030202010600000000 ("10030202010600000000", "Beban Penyisihan/Penyusutan"),
	R_10030202010601000000 ("10030202010601000000", "Beban Penyisihan Piutang Ragu-Ragu:"),
	R_10030202010601010000 ("10030202010601010000", "Beban Penyisihan Piutang Ragu-ragu Pembiayaan Jual Beli"),
	R_10030202010601020000 ("10030202010601020000", "Beban Penyisihan Piutang Ragu-ragu Pembiayaan Investasi"),
	R_10030202010601030000 ("10030202010601030000", "Beban Penyisihan Piutang Ragu-ragu Pembiayaan Jasa"),
	R_10030202010602000000 ("10030202010602000000", "Beban Penyusutan Aset yang digunakan untuk kegiatan usaha pembiayaan (khusus ijarah) "),
	R_10030202010603000000 ("10030202010603000000", "Beban Penyusutan Aset Tetap dan Inventaris"),
	R_10030202010700000000 ("10030202010700000000", "Beban Sewa"),
	R_10030202010800000000 ("10030202010800000000", "Beban Pemeliharaan dan Perbaikan"),
	R_10030202010900000000 ("10030202010900000000", "Beban Administrasi dan Umum"),
	R_10030202011000000000 ("10030202011000000000", "Beban Operasional Lainnya"),
	R_10030202020000000000 ("10030202020000000000", "Beban Non-Operasional"),
	R_10030203000000000000 ("10030203000000000000", "LABA (RUGI) SEBELUM PAJAK"),
//	R_10030204000000000000 ("10030204000000000000", "TAKSIRAN PAJAK PENGHASILAN"),
	R_10030204010000000000 ("10030204010000000000", "Pajak Tahun Berjalan -/-"),
	R_10030204020000000000 ("10030204020000000000", "Pendapatan (Beban) Pajak Tangguhan"),
	R_10030205000000000000 ("10030205000000000000", "LABA (RUGI) BERSIH SETELAH PAJAK"),
	R_10030206000000000000 ("10030206000000000000", "KEUNTUNGAN (KERUGIAN) PENDAPATAN KOMPREHENSIF LAINNYA"),
	R_10030206010000000000 ("10030206010000000000", "Keuntungan (Kerugian) Akibat Perubahan dalam Surplus Revaluasi Aset Tetap"),
	R_10030206020000000000 ("10030206020000000000", "Selisih Lebih (Kurang) Kurs Karena Penjabaran Laporan Keuangan dalam Mata Uang Asing"),
	R_10030206030000000000 ("10030206030000000000", "Keuntungan (Kerugian) Akibat Pengukuran Kembali Aset Keuangan Tersedia untuk Dijual"),
	R_10030206040000000000 ("10030206040000000000", "Keuntungan (Kerugian) Akibat Bagian Efektif Instrumen Keuangan Lindung Nilai dalam Rangka Lindung Nilai Arus Kas"),
	R_10030206050000000000 ("10030206050000000000", "Keuntungan (Kerugian) Atas Komponen Ekuitas Lainnya Sesuai Prinsip Standar Akuntansi Keuangan "),
	R_10030207000000000000 ("10030207000000000000", "LABA (RUGI) BERSIH KOMPREHENSIF TAHUN BERJALAN"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2269PosRePps100302 eEnum : ER2269PosRePps100302.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2269PosRePps100302.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2269PosRePps100302.class.getSimpleName().substring(2, 6));
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
		String comparatorFormCode = EFormRealisasiBisnis.RE_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_10030205000000000000.key, comparatorFormCode, 
				ER2268PosRePps100202.R_10020203040000.getKey(), "Nilai Laba (Rugi) Bersih Setelah Pajak|Nilai Laba (Rugi) Bersih Setelah Pajak form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationFormKeuntunganPendapatanKomprehensifLainnya() {
		String comparatorFormCode = EFormRealisasiBisnis.RE_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3", R_10030206000000000000.key, comparatorFormCode, 
				ER2268PosRePps100202.R_10020203050200.getKey(), "Nilai Keuntungan (Kerugian) Pendapatan Komprehensif Lainnya|Nilai Keuntungan (Kerugian) Komperehensif Lainnya Periode Berjalan form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationPendapatan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030201000000000000.key,
				R_10030201010000000000.key + "+" + R_10030201020000000000.key, 
				"Total Pendapatan|Penjumlahan Pendapatan");
	}

	public static SegmentValidation genValidationPendapatanOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030201010000000000.key,
				R_10030201010100000000.key + "+" + R_10030201010200000000.key,
				"Total Pendapatan Operasional|Penjumlahan Pendapatan Operasional");
	}

	public static SegmentValidation genValidationPendapatanKegiatanPembiayaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030201010100000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 3, 8, 14, 22, 23 }),
				"Total Pendapatan dari Kegiatan Pembiayaan|Penjumlahan Pendapatan dari Kegiatan Pembiayaan");
	}

	public static SegmentValidation genValidationPendapatanMarginPembiayaanJualBeli() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030201010101000000.key,
				UtilMetadata.genPlusRow(getObjects(), 4, 7),
				"Total Pendapatan Margin Pembiayaan Jual Beli|Penjumlahan Pendapatan Margin Pembiayaan Jual Beli");
	}

	public static SegmentValidation genValidationPendapatanBagiHasilPembiayaanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030201010102000000.key,
				UtilMetadata.genPlusRow(getObjects(), 9, 13),
				"Total Pendapatan Bagi Hasil Pembiayaan Investasi|Penjumlahan Pendapatan Bagi Hasil Pembiayaan Investasi");
	}

	public static SegmentValidation genValidationPendapatanImbalJasaPembiayaanJasa() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030201010103000000.key,
				UtilMetadata.genPlusRow(getObjects(), 15, 21),
				"Total Pendapatan Imbal Jasa Pembiayaan Jasa|Penjumlahan Pendapatan Imbal Jasa Pembiayaan Jasa");
	}

	public static SegmentValidation genValidationPendapatanOperasionalLainTerkaitPembiayaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030201010200000000.key,
				UtilMetadata.genPlusRow(getObjects(), 25, 29),
				"Total Pendapatan Operasional Lain Terkait Pembiayaan|Penjumlahan Pendapatan Operasional Lain Terkait Pembiayaan");
	}

	public static SegmentValidation genValidationPendapatanNonOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030201020000000000.key,
				R_10030201020100000000.key + "+" + R_10030201020200000000.key,
				"Total Pendapatan Non-Operasional|Penjumlahan Pendapatan Non-Operasional");
	}

	public static SegmentValidation genValidationBeban() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030202000000000000.key,
				R_10030202010000000000.key + "+" + R_10030202020000000000.key, 
				"Total Beban|Penjumlahan Beban");
	}

	public static SegmentValidation genValidationBebanOperasional() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030202010000000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 35, 42, 43, 44, 48, 51, 58, 59, 60, 61 }),
				"Total Beban Operasional|Penjumlahan Beban Operasional");
	}

	public static SegmentValidation genValidationBebanMargin() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030202010100000000.key,
				UtilMetadata.genPlusRow(getObjects(), 36, 41),
				"Total Beban Margin/Bagi Hasil/Imbal Jasa|Penjumlahan Beban Margin/Bagi Hasil/Imbal Jasa");
	}

	public static SegmentValidation genValidationBebanTenagaKerja() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030202010400000000.key,
				UtilMetadata.genPlusRow(getObjects(), 45, 47),
				"Total Beban Tenaga Kerja|Penjumlahan Beban Tenaga Kerja");
	}

	public static SegmentValidation genValidationBebanPemasaran() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030202010500000000.key,
				R_10030202010501000000.key + "+" + R_10030202010502000000.key,
				"Total Beban Pemasaran|Penjumlahan Beban Pemasaran");
	}

	public static SegmentValidation genValidationBebanPenyisihan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030202010600000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 52, 56, 57 }),
				"Total Beban Penyisihan/Penyusutan|Penjumlahan Beban Penyisihan/Penyusutan");
	}

	public static SegmentValidation genValidationBebanPenyisihanPiutang() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030202010601000000.key,
				UtilMetadata.genPlusRow(getObjects(), 53, 55),
				"Total Beban Penyisihan Piutang Ragu-Ragu|Penjumlahan Beban Penyisihan Piutang Ragu-Ragu");
	}

	public static SegmentValidation genValidationLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030203000000000000.key,
				R_10030201000000000000.key + "-" + R_10030202000000000000.key,
				"Total Laba (Rugi) Sebelum Pajak|Penjumlahan Laba (Rugi) Sebelum Pajak");
	}

	public static SegmentValidation genValidationLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030205000000000000.key,
				R_10030203000000000000.key + "-" + R_10030204010000000000.key + "+" + R_10030204020000000000.key,
				"Total Laba (Rugi) Bersih Setelah Pajak|Penjumlahan Laba (Rugi) Bersih Setelah Pajak");
	}

	public static SegmentValidation genValidationKeuntunganPendapatanKomprehensifLainnya() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030206000000000000.key,
				UtilMetadata.genPlusRow(getObjects(), 68, 72),
				"Total Keuntungan (Kerugian) Pendapatan Komprehensif Lainnya|Penjumlahan Keuntungan (Kerugian) Pendapatan Komprehensif Lainnya");
	}

	public static SegmentValidation genValidationLabaBersihKomprehensifPeriodeBerjalan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10030207000000000000.key,
				R_10030205000000000000.key + "+" + R_10030206000000000000.key,
				"Total Laba (Rugi) Bersih Komprehensif Periode Berjalan|Penjumlahan Laba (Rugi) Bersih Komprehensif Periode Berjalan");
	}
}
