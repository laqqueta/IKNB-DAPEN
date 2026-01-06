package id.go.ojk.pmvk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pmvk.client.builder.field.EFormRencanaBisnisUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2516PosRbPmvu100402 implements IObject<KeyValueString> {
	R_10040201000000 ("10040201000000", "Arus Kas bersih dari Kegiatan Operasi"),
	R_10040201010000 ("10040201010000", "Arus Kas Masuk dari Kegiatan Operasi"),
	R_10040201010100 ("10040201010100", "Arus Kas Masuk dari Kegiatan Penyertaan Saham"),
	R_10040201010200 ("10040201010200", "Arus Kas Masuk dari Kegiatan Pembelian Sukuk atau Obligasi Syariah Konversi"),
	R_10040201010300 ("10040201010300", "Arus Kas Masuk dari Kegiatan Pembelian Sukuk atau Obligasi Syariah yang Diterbitkan Pasangan Usaha pada Tahap Rintisan Awal (Start-up) dan/atau Pengembangan Usaha"),
	R_10040201010400 ("10040201010400", "Arus Kas Masuk dari Kegiatan Pembiayaan Berdasarkan Prinsip Bagi Hasil"),
	R_10040201010500 ("10040201010500", "Arus Kas Masuk dari Kegiatan Pengelolaan Dana Ventura"),
	R_10040201010600 ("10040201010600", "Arus Kas Masuk dari Kegiatan Usaha Lain"),
	R_10040201010601 ("10040201010601", "Arus Kas Masuk dari Kegiatan Pelayanan Jasa Berbasis Imbal Hasil"),
	R_10040201010602 ("10040201010602", "Arus Kas Masuk dari Kegiatan Usaha Lain dengan Persetujuan Otoritas Jasa Keuangan"),
	R_10040201010700 ("10040201010700", "Arus Kas Masuk dari Kegiatan Pembiayaan Penerusan (Channeling)"),
	R_10040201010800 ("10040201010800", "Arus Kas Masuk dari Pendapatan Kegiatan Operasi Lainnya"),
	R_10040201020000 ("10040201020000", "Arus Kas Keluar untuk Kegiatan Operasi"),
	R_10040201020100 ("10040201020100", "Arus Kas Keluar untuk Kegiatan Penyertaan Saham"),
	R_10040201020200 ("10040201020200", "Arus Kas Keluar untuk Kegiatan Pembelian Sukuk atau Obligasi Syariah Konversi"),
	R_10040201020300 ("10040201020300", "Arus Kas Keluar untuk Kegiatan  Pembelian Sukuk atau Obligasi Syariah yang Diterbitkan Pasangan Usaha pada Tahap Rintisan Awal (Start-up) dan/atau Pengembangan Usaha"),
	R_10040201020400 ("10040201020400", "Arus Kas Keluar untuk Kegiatan Pembiayaan Berdasarkan Prinsip Bagi Hasil"),
	R_10040201020500 ("10040201020500", "Arus Kas Keluar untuk Kegiatan Pengelolaan Dana Ventura"),
	R_10040201020600 ("10040201020600", "Arus Kas Keluar untuk Kegiatan Usaha Lain"),
	R_10040201020601 ("10040201020601", "1)   Arus Kas Keluar untuk Kegiatan Pelayanan Jasa Berbasis Imbal Hasil"),
	R_10040201020602 ("10040201020602", "2)   Arus Kas Keluar untuk Kegiatan Usaha Lain dengan Persetujuan Otoritas Jasa Keuangan"),
	R_10040201020700 ("10040201020700", "Arus Kas Keluar untuk Pembayaran Imbal Hasil Operasional"),
	R_10040201020800 ("10040201020800", "Arus Kas Keluar untuk Pembayaran Beban Umum dan Administrasi"),
	R_10040201020900 ("10040201020900", "Arus Kas Keluar untuk Pembayaran Pajak Penghasilan"),
	R_10040201021000 ("10040201021000", "Arus Kas Keluar dari Kegiatan Pembiayaan Penerusan (Channeling)"),
	R_10040201021100 ("10040201021100", "Arus Kas Keluar untuk Pembayaran Kegiatan Operasi Lainnya"),
	R_10040202000000 ("10040202000000", "Arus Kas bersih dari Kegiatan Investasi"),
	R_10040202010000 ("10040202010000", "Arus Kas Masuk dari Kegiatan Investasi"),
	R_10040202010100 ("10040202010100", "Arus Kas Masuk dari Pelepasan Dana Ventura"),
	R_10040202010200 ("10040202010200", "Arus Kas Masuk dari Penjualan Tanah, Bangunan, dan Peralatan"),
	R_10040202010300 ("10040202010300", "Arus Kas Masuk dari Penjualan Surat Berharga "),
	R_10040202010400 ("10040202010400", "Arus Kas Masuk dari Dividen"),
	R_10040202010500 ("10040202010500", "Arus Kas Masuk dari Penerimaan Imbal Hasil Kegiatan Investasi"),
	R_10040202010600 ("10040202010600", "Arus Kas Masuk dari Kegiatan Investasi Lainnya"),
	R_10040202020000 ("10040202020000", "Arus Kas Keluar untuk Kegiatan Investasi"),
	R_10040202020100 ("10040202020100", "Arus Kas Keluar untuk Investasi pada Dana Ventura"),
	R_10040202020200 ("10040202020200", "Arus Kas Keluar untuk Pembelian Tanah, Bangunan, dan Peralatan"),
	R_10040202020300 ("10040202020300", "Arus Kas Keluar untuk Perolehan Surat Berharga "),
	R_10040202020400 ("10040202020400", "Arus Kas Keluar untuk Kegiatan Investasi Lainnya"),
	R_10040203000000 ("10040203000000", "Arus Kas Bersih dari Kegiatan Pendanaan "),
	R_10040203010000 ("10040203010000", "Arus Kas Masuk dari Kegiatan Pendanaan "),
	R_10040203010100 ("10040203010100", "Arus Kas Masuk dari Pendanaan dan Penerbitan Surat Berharga"),
	R_10040203010200 ("10040203010200", "Arus Kas Masuk dari Penerbitan Modal Saham"),
	R_10040203010300 ("10040203010300", "Arus Kas Masuk dari Pendanaan Lainnya"),
	R_10040203020000 ("10040203020000", "Arus Kas Keluar untuk Kegiatan Pendanaan"),
	R_10040203020100 ("10040203020100", "Arus Kas Keluar untuk Pembayaran Pokok Pendanaan dan Surat Berharga yang Diterbitkan "),
	R_10040203020200 ("10040203020200", "Arus Kas Keluar untuk Penarikan Kembali Modal Perusahaan (Treasury Stock)"),
	R_10040203020300 ("10040203020300", "Arus Kas Keluar untuk Pembayaran Dividen"),
	R_10040203020400 ("10040203020400", "Arus Kas Keluar untuk Pendanaan Lainnya"),
	R_10040204000000 ("10040204000000", "Surplus (Defisit) pada Kas dan Setara Kas Akibat Perubahan Kurs"),
	R_10040205000000 ("10040205000000", "Kenaikan (Penurunan) Bersih Kas dan Setara Kas"),
	R_10040206000000 ("10040206000000", "Kas dan Setara Kas pada Awal Periode"),
	R_10040207000000 ("10040207000000", "Kas dan Setara Kas pada Akhir Periode"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2516PosRbPmvu100402 eEnum : ER2516PosRbPmvu100402.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2516PosRbPmvu100402.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2516PosRbPmvu100402.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationArusKasBersihDariKegiatanOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201000000.key,
				UtilMetadata.genMinusRow(getObjects(), new int[] { 1, 12 }),
				"Total Arus Kas Bersih Dari Kegiatan Operasi|Perhitungan Arus Kas Bersih Dari Kegiatan Operasi");
	}

	public static SegmentValidation genValidationArusKasMasukDariKegiatanOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201010000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 2, 3, 4, 5, 6, 7, 10, 11 }),
				"Total Arus Kas Masuk dari Kegiatan Operasi|Penjumlahan Arus Kas Masuk dari Kegiatan Operasi");
	}

	public static SegmentValidation genValidationArusKasMasukDariKegiatanUsahaLain() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201010600.key,
				UtilMetadata.genPlusRow(getObjects(), 8, 9),
				"Total Arus Kas Masuk dari Kegiatan Usaha Lain|Penjumlahan Arus Kas Masuk dari Kegiatan Usaha Lain");
	}

	public static SegmentValidation genValidationArusKasKeluarUntukKegiatanOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201020000.key,
				UtilMetadata.genPlusRow(getObjects(), 13, 18) + "+" + UtilMetadata.genPlusRow(getObjects(), 21, 25),
				"Total Arus Kas Keluar untuk Kegiatan Operasi|Penjumlahan Arus Kas Keluar untuk Kegiatan Operasi");
	}

	public static SegmentValidation genValidationArusKasKeluarUntukKegiatanUsahaLain() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201020600.key,
				UtilMetadata.genPlusRow(getObjects(), 19, 20),
				"Total Arus Kas Keluar untuk Kegiatan Usaha Lain|Penjumlahan Arus Kas Keluar untuk Kegiatan Usaha Lain");
	}

	public static SegmentValidation genValidationArusKasBersihDariKegiatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040202000000.key,
				UtilMetadata.genMinusRow(getObjects(), new int[] { 27, 34 }),
				"Total Arus Kas bersih dari Kegiatan Investasi|Perhitungan Arus Kas bersih dari Kegiatan Investasi");
	}

	public static SegmentValidation genValidationArusKasMasukDariKegiatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040202010000.key,
				UtilMetadata.genPlusRow(getObjects(), 28, 33),
				"Total Arus Kas Masuk dari Kegiatan Investasi|Penjumlahan Arus Kas Masuk dari Kegiatan Investasi");
	}

	public static SegmentValidation genValidationArusKasKeluarUntukKegiatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040202020000.key,
				UtilMetadata.genPlusRow(getObjects(), 35, 38),
				"Total Arus Kas Keluar untuk Kegiatan Investasi|Penjumlahan Arus Kas Keluar untuk Kegiatan Investasi");
	}

	public static SegmentValidation genValidationArusKasBersihDariKegiatanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040203000000.key,
				UtilMetadata.genMinusRow(getObjects(), new int[] { 40, 44 }),
				"Total Arus Kas Bersih dari Kegiatan Pendanaan|Perhitungan Arus Kas Bersih dari Kegiatan Pendanaan");
	}

	public static SegmentValidation genValidationArusKasMasukDariKegiatanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040203010000.key,
				UtilMetadata.genPlusRow(getObjects(), 41, 43),
				"Total Arus Kas Masuk dari Kegiatan Pendanaan|Penjumlahan Arus Kas Masuk dari Kegiatan Pendanaan");
	}

	public static SegmentValidation genValidationArusKasKeluarUntukKegiatanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040203020000.key,
				UtilMetadata.genPlusRow(getObjects(), 45, 48),
				"Total Arus Kas Keluar untuk Kegiatan Pendanaan|Penjumlahan Arus Kas Keluar untuk Kegiatan Pendanaan");
	}

	public static SegmentValidation genValidationKenaikanBersihKasDanSetaraKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040205000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 26, 39, 49 }),
				"Total Kenaikan (Penurunan) Bersih Kas dan Setara Kas|Penjumlahan Kenaikan (Penurunan) Bersih Kas dan Setara Kas");
	}

	public static SegmentValidation genValidationKasDanSetaraKasPadaAkhirPeriode() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040207000000.key,
				UtilMetadata.genPlusRow(getObjects(), 50, 51),
				"Total Kas dan Setara Kas pada Akhir Periode|Penjumlahan Kas dan Setara Kas pada Akhir Periode");
	}

	public static SegmentValidation genValidationFormKasDanSetaraKasPadaAkhirPeriode() {
		String comparatorFormCode = EFormRencanaBisnisUus.RB_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_10040207000000.key, comparatorFormCode, 
				ER2514PosRbPmvu100202.R_10020201010000.getKey(), 
				"Total Kas dan Setara Kas pada Akhir Periode|Nilai Kas dan Setara Kas form " + comparatorFormCode + " #kolom#");
	}
}
