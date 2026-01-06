package id.go.ojk.pmvk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pmvk.client.builder.field.EFormRencanaBisnis;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2016PosRbPmvk100401 implements IObject<KeyValueString> {
	R_10040101000000 ("10040101000000", "Arus Kas bersih dari Kegiatan Operasi"),
	R_10040101010000 ("10040101010000", "Arus Kas Masuk dari Kegiatan Operasi"),
	R_10040101010100 ("10040101010100", "Arus Kas Masuk dari Kegiatan Penyertaan Saham"),
	R_10040101010200 ("10040101010200", "Arus Kas Masuk dari Kegiatan Penyertaan Melalui Pembelian Obligasi Konversi"),
	R_10040101010300 ("10040101010300", "Arus Kas Masuk dari Kegiatan Pembiayaan Melalui Pembelian Surat Utang yang Diterbitkan Pasangan Usaha pada Tahap Rintisan Awal (Start-up) dan/atau Pengembangan Usaha"),
	R_10040101010400 ("10040101010400", "Arus Kas Masuk dari Kegiatan Pembiayaan Usaha Produktif"),
	R_10040101010500 ("10040101010500", "Arus Kas Masuk dari Kegiatan Investasi Berdasarkan Prinsip Syariah"),
	R_10040101010600 ("10040101010600", "Arus Kas Masuk dari Kegiatan Pengelolaan Dana Ventura"),
	R_10040101010700 ("10040101010700", "Arus Kas Masuk dari Kegiatan Usaha Lain"),
	R_10040101010701 ("10040101010701", "Arus Kas Masuk dari Kegiatan Jasa Berbasis Fee"),
	R_10040101010702 ("10040101010702", "Arus Kas Masuk dari Kegiatan Usaha Lain dengan Persetujuan Otoritas Jasa Keuangan"),
	R_10040101010800 ("10040101010800", "Arus Kas Masuk dari Kegiatan Pembiayaan Penerusan (Channeling)"),
	R_10040101010900 ("10040101010900", "Arus Kas Masuk dari Pendapatan Kegiatan Operasi Lainnya"),
	R_10040101020000 ("10040101020000", "Arus Kas Keluar untuk Kegiatan Operasi"),
	R_10040101020100 ("10040101020100", "Arus Kas Keluar untuk Kegiatan Penyertaan Saham"),
	R_10040101020200 ("10040101020200", "Arus Kas Keluar untuk Kegiatan Penyertaan Melalui Pembelian Obligasi Konversi"),
	R_10040101020300 ("10040101020300", "Arus Kas Keluar untuk Kegiatan Pembiayaan Melalui Pembelian Surat Utang yang Diterbitkan Pasangan Usaha pada Tahap Rintisan Awal (Start-up) dan/atau Pengembangan Usaha"),
	R_10040101020400 ("10040101020400", "Arus Kas Keluar untuk Kegiatan Pembiayaan Usaha Produktif"),
	R_10040101020500 ("10040101020500", "Arus Kas Keluar untuk Kegiatan Investasi Berdasarkan Prinsip Syariah "),
	R_10040101020600 ("10040101020600", "Arus Kas Keluar untuk Kegiatan Pengelolaan Dana Ventura"),
	R_10040101020700 ("10040101020700", "Arus Kas Keluar untuk Kegiatan Usaha Lain"),
	R_10040101020701 ("10040101020701", "1)   Arus Kas Keluar untuk Kegiatan Jasa Berbasis Fee"),
	R_10040101020702 ("10040101020702", "2)   Arus Kas Keluar untuk Kegiatan Usaha Lain dengan Persetujuan Otoritas Jasa Keuangan"),
	R_10040101020800 ("10040101020800", "Arus Kas Keluar untuk Pembayaran Bunga Operasional"),
	R_10040101020900 ("10040101020900", "Arus Kas Keluar untuk Pembayaran Beban Umum dan Administrasi"),
	R_10040101021000 ("10040101021000", "Arus Kas Keluar untuk Pembayaran Pajak Penghasilan"),
	R_10040101021100 ("10040101021100", "Arus Kas Keluar dari Kegiatan Pembiayaan Penerusan (Channeling)"),
	R_10040101021200 ("10040101021200", "Arus Kas Keluar untuk Pembayaran Kegiatan Operasi Lainnya"),
	R_10040102000000 ("10040102000000", "Arus Kas bersih dari Kegiatan Investasi"),
	R_10040102010000 ("10040102010000", "Arus Kas Masuk dari Kegiatan Investasi"),
	R_10040102010100 ("10040102010100", "Arus Kas Masuk dari Pelepasan Dana Ventura"),
	R_10040102010200 ("10040102010200", "Arus Kas Masuk dari Penjualan Tanah, Bangunan, dan Peralatan"),
	R_10040102010300 ("10040102010300", "Arus Kas Masuk dari Penjualan Surat Berharga "),
	R_10040102010400 ("10040102010400", "Arus Kas Masuk dari Dividen"),
	R_10040102010500 ("10040102010500", "Arus Kas Masuk dari Penerimaan Bunga Kegiatan Investasi"),
	R_10040102010600 ("10040102010600", "Arus Kas Masuk dari Kegiatan Investasi Lainnya"),
	R_10040102020000 ("10040102020000", "Arus Kas Keluar untuk Kegiatan Investasi"),
	R_10040102020100 ("10040102020100", "Arus Kas Keluar untuk Investasi pada Dana Ventura"),
	R_10040102020200 ("10040102020200", "Arus Kas Keluar untuk Pembelian Tanah, Bangunan, dan Peralatan"),
	R_10040102020300 ("10040102020300", "Arus Kas Keluar untuk Perolehan Surat Berharga "),
	R_10040102020400 ("10040102020400", "Arus Kas Keluar untuk Kegiatan Investasi Lainnya"),
	R_10040103000000 ("10040103000000", "Arus Kas Bersih dari Kegiatan Pendanaan "),
	R_10040103010000 ("10040103010000", "Arus Kas Masuk dari Kegiatan Pendanaan "),
	R_10040103010100 ("10040103010100", "Arus Kas Masuk dari Pinjaman dan Penerbitan Surat Berharga"),
	R_10040103010200 ("10040103010200", "Arus Kas Masuk dari Penerbitan Modal Saham"),
	R_10040103010300 ("10040103010300", "Arus Kas Masuk dari Pendanaan Berdasarkan Prinsip Syariah"),
	R_10040103010400 ("10040103010400", "Arus Kas Masuk dari Pendanaan Lainnya"),
	R_10040103020000 ("10040103020000", "Arus Kas Keluar untuk Kegiatan Pendanaan"),
	R_10040103020100 ("10040103020100", "Arus Kas Keluar untuk Pembayaran Pokok Pinjaman dan Surat Berharga yang Diterbitkan "),
	R_10040103020200 ("10040103020200", "Arus Kas Keluar untuk Penarikan Kembali Modal Perusahaan (Treasury Stock)"),
	R_10040103020300 ("10040103020300", "Arus Kas Keluar untuk Pembayaran Dividen"),
	R_10040103020400 ("10040103020400", "Arus Kas Keluar untuk Pendanaan Berdasarkan Prinsip Syariah"),
	R_10040103020500 ("10040103020500", "Arus Kas Keluar untuk Pendanaan Lainnya"),
	R_10040104000000 ("10040104000000", "Surplus (Defisit) pada Kas dan Setara Kas Akibat Perubahan Kurs"),
	R_10040105000000 ("10040105000000", "Kenaikan (Penurunan) Bersih Kas dan Setara Kas"),
	R_10040106000000 ("10040106000000", "Kas dan Setara Kas pada Awal Periode"),
	R_10040107000000 ("10040107000000", "Kas dan Setara Kas pada Akhir Periode"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2016PosRbPmvk100401 eEnum : ER2016PosRbPmvk100401.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2016PosRbPmvk100401.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2016PosRbPmvk100401.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationArusKasBersihDariKegiatanOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040101000000.key,
				UtilMetadata.genMinusRow(getObjects(), new int[] { 1, 13 }),
				"Total Arus Kas Bersih Dari Kegiatan Operasi|Perhitungan Arus Kas Bersih Dari Kegiatan Operasi");
	}

	public static SegmentValidation genValidationArusKasMasukDariKegiatanOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040101010000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 2, 3, 4, 5, 6, 7, 8, 11, 12 }),
				"Total Arus Kas Masuk dari Kegiatan Operasi|Penjumlahan Arus Kas Masuk dari Kegiatan Operasi");
	}

	public static SegmentValidation genValidationArusKasMasukDariKegiatanUsahaLain() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040101010700.key,
				UtilMetadata.genPlusRow(getObjects(), 9, 10),
				"Total Arus Kas Masuk dari Kegiatan Usaha Lain|Penjumlahan Arus Kas Masuk dari Kegiatan Usaha Lain");
	}

	public static SegmentValidation genValidationArusKasKeluarUntukKegiatanOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040101020000.key,
				UtilMetadata.genPlusRow(getObjects(), 14, 20) + "+" + UtilMetadata.genPlusRow(getObjects(), 23, 27),
				"Total Arus Kas Keluar untuk Kegiatan Operasi|Penjumlahan Arus Kas Keluar untuk Kegiatan Operasi");
	}

	public static SegmentValidation genValidationArusKasKeluarUntukKegiatanUsahaLain() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040101020700.key,
				UtilMetadata.genPlusRow(getObjects(), 21, 22),
				"Total Arus Kas Keluar untuk Kegiatan Usaha Lain|Penjumlahan Arus Kas Keluar untuk Kegiatan Usaha Lain");
	}

	public static SegmentValidation genValidationArusKasBersihDariKegiatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040102000000.key,
				UtilMetadata.genMinusRow(getObjects(), new int[] { 29, 36 }),
				"Total Arus Kas bersih dari Kegiatan Investasi|Perhitungan Arus Kas bersih dari Kegiatan Investasi");
	}

	public static SegmentValidation genValidationArusKasMasukDariKegiatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040102010000.key,
				UtilMetadata.genPlusRow(getObjects(), 30, 35),
				"Total Arus Kas Masuk dari Kegiatan Investasi|Penjumlahan Arus Kas Masuk dari Kegiatan Investasi");
	}

	public static SegmentValidation genValidationArusKasKeluarUntukKegiatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040102020000.key,
				UtilMetadata.genPlusRow(getObjects(), 37, 40),
				"Total Arus Kas Keluar untuk Kegiatan Investasi|Penjumlahan Arus Kas Keluar untuk Kegiatan Investasi");
	}

	public static SegmentValidation genValidationArusKasBersihDariKegiatanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040103000000.key,
				UtilMetadata.genMinusRow(getObjects(), new int[] { 42, 47 }),
				"Total Arus Kas Bersih dari Kegiatan Pendanaan|Perhitungan Arus Kas Bersih dari Kegiatan Pendanaan");
	}

	public static SegmentValidation genValidationArusKasMasukDariKegiatanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040103010000.key,
				UtilMetadata.genPlusRow(getObjects(), 43, 46),
				"Total Arus Kas Masuk dari Kegiatan Pendanaan|Penjumlahan Arus Kas Masuk dari Kegiatan Pendanaan");
	}

	public static SegmentValidation genValidationArusKasKeluarUntukKegiatanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040103020000.key,
				UtilMetadata.genPlusRow(getObjects(), 48, 52),
				"Total Arus Kas Keluar untuk Kegiatan Pendanaan|Penjumlahan Arus Kas Keluar untuk Kegiatan Pendanaan");
	}

	public static SegmentValidation genValidationKenaikanBersihKasDanSetaraKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040105000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 28, 41, 53 }),
				"Total Kenaikan (Penurunan) Bersih Kas dan Setara Kas|Penjumlahan Kenaikan (Penurunan) Bersih Kas dan Setara Kas");
	}

	public static SegmentValidation genValidationKasDanSetaraKasPadaAkhirPeriode() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040107000000.key,
				UtilMetadata.genPlusRow(getObjects(), 54, 55),
				"Total Kas dan Setara Kas pada Akhir Periode|Penjumlahan Kas dan Setara Kas pada Akhir Periode");
	}

	public static SegmentValidation genValidationFormKasDanSetaraKasPadaAkhirPeriode() {
		String comparatorFormCode = EFormRencanaBisnis.RB_100201.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_10040107000000.key, comparatorFormCode, 
				ER2014PosRbPmvk100201.R_10020101010000.getKey(), 
				"Total Kas dan Setara Kas pada Akhir Periode|Total Kas dan Setara Kas pada Akhir Periode form " + comparatorFormCode + " #kolom#");
	}
}
