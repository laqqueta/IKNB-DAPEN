package id.go.ojk.pps.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pps.client.builder.field.EFormRencanaBisnis;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2020PosRbPps100402 implements IObject<KeyValueString> {
	R_10040201000000 ("10040201000000", "Arus Kas Bersih dari Kegiatan Operasi"),
	R_10040201010000 ("10040201010000", "Penerimaan Kas dari Kegiatan Operasi"),
	R_10040201010100 ("10040201010100", "Penerimaan dari Pembiayaan Jual Beli"),
	R_10040201010101 ("10040201010101", "Penerimaan dari Kegiatan Pembiayaan Murabahah"),
	R_10040201010102 ("10040201010102", "Penerimaan dari Kegiatan Pembiayaan Salam"),
	R_10040201010103 ("10040201010103", "Penerimaan dari Kegiatan Pembiayaan Istishna"),
	R_10040201010104 ("10040201010104", "Penerimaan dari Akad Pembiayaan Jual Beli Lainnya"),
	R_10040201010200 ("10040201010200", "Penerimaan dari Pembiayaan Investasi"),
	R_10040201010201 ("10040201010201", "Penerimaan dari Kegiatan Pembiayaan Mudharabah"),
	R_10040201010202 ("10040201010202", "Penerimaan dari Kegiatan Pembiayaan Musyarakah"),
	R_10040201010203 ("10040201010203", "Penerimaan dari Kegiatan Pembiayaan Mudharabah Musytarakah"),
	R_10040201010204 ("10040201010204", "Penerimaan dari Kegiatan Pembiayaan Musyarakah Muntanaqisah"),
	R_10040201010205 ("10040201010205", "Penerimaan dari Akad Pembiayaan Investasi Lainnya"),
	R_10040201010300 ("10040201010300", "Penerimaan dari Pembiayaan Jasa"),
	R_10040201010301 ("10040201010301", "Penerimaan dari Kegiatan Pembiayaan Ijarah"),
	R_10040201010302 ("10040201010302", "Penerimaan dari Kegiatan Pembiayaan IMBT"),
	R_10040201010303 ("10040201010303", "Penerimaan dari Kegiatan Pembiayaan Hawalah bil ujrah"),
	R_10040201010304 ("10040201010304", "Penerimaan dari Pembiayaan Wakalah bil ujrah"),
	R_10040201010305 ("10040201010305", "Penerimaan dari Pembiayaan Kafalah bil ujrah"),
	R_10040201010306 ("10040201010306", "Penerimaan dari Kegiatan Pembiayaan Ju'alah"),
	R_10040201010307 ("10040201010307", "Penerimaan dari Pembiayaan Qardh"),
	R_10040201010308 ("10040201010308", "Penerimaan dari Akad Pembiayaan Jasa Lainnya"),
	R_10040201010400 ("10040201010400", "Penerimaan dari Kegiatan Pembiayaan Penerusan (Channeling)"),
	R_10040201010500 ("10040201010500", "Penerimaan dari Kegiatan Pembiayaan Bersama (Joint Financing)"),
	R_10040201010600 ("10040201010600", "Penerimaan dari Surat Berharga yang Diperjualbelikan"),
	R_10040201010700 ("10040201010700", "Penerimaan dari Pendapatan Kegiatan operasi lainnya "),
	R_10040201020000 ("10040201020000", "Pembayaran Kas untuk Kegiatan Operasi"),
	R_10040201020100 ("10040201020100", "Pembayaran untuk Kegiatan Pembiayaan Jual Beli"),
	R_10040201020101 ("10040201020101", "Pembayaran untuk Kegiatan Pembiayaan Murabahah"),
	R_10040201020102 ("10040201020102", "Pembayaran untuk Kegiatan Pembiayaan Salam"),
	R_10040201020103 ("10040201020103", "Pembayaran untuk Kegiatan Pembiayaan Istishna"),
	R_10040201020104 ("10040201020104", "Pembayaran untuk Akad Jual Beli Lainnya"),
	R_10040201020200 ("10040201020200", "Pembayaran untuk Kegiatan Pembiayaan  Investasi"),
	R_10040201020201 ("10040201020201", "Pembayaran untuk Kegiatan Pembiayaan Mudharabah"),
	R_10040201020202 ("10040201020202", "Pembayaran untuk Kegiatan Pembiayaan Musyarakah"),
	R_10040201020203 ("10040201020203", "Pembayaran untuk Kegiatan Pembiayaan Mudharabah Musytarakah"),
	R_10040201020204 ("10040201020204", "Pembayaran untuk Kegiatan Pembiayaan Musyarakah Muntanaqisah"),
	R_10040201020205 ("10040201020205", "Pembayaran untuk Akad Investasi Lainnya"),
	R_10040201020300 ("10040201020300", "Pembayaran untuk Kegiatan Pembiayaan Jasa"),
	R_10040201020301 ("10040201020301", "Pembayaran untuk Kegiatan Pembiayaan Ijarah"),
	R_10040201020302 ("10040201020302", "Pembayaran untuk Kegiatan Pembiayaan IMBT"),
	R_10040201020303 ("10040201020303", "Pembayaran untuk Kegiatan Pembiayaan Hawalah bil ujrah"),
	R_10040201020304 ("10040201020304", "Pembayaran untuk Kegiatan Pembiayaan Wakalah bil ujrah"),
	R_10040201020305 ("10040201020305", "Pembayaran untuk Kegiatan Pembiayaan Kafalah bil ujrah"),
	R_10040201020306 ("10040201020306", "Pembayaran untuk Kegiatan Pembiayaan Ju'alah"),
	R_10040201020307 ("10040201020307", "Pembayaran untuk Kegiatan Pembiayaan Qardh"),
	R_10040201020308 ("10040201020308", "Pembayaran untuk Kegiatan Akad Pembiayaan Jasa Lainnya"),
	R_10040201020400 ("10040201020400", "Pembayaran untuk Beban Umum dan Administrasi"),
	R_10040201020500 ("10040201020500", "Pembayaran untuk Pajak Penghasilan "),
	R_10040201020600 ("10040201020600", "Pembayaran untuk Kegiatan Pembiayaan Penerusan (Channeling)"),
	R_10040201020700 ("10040201020700", "Pembayaran untuk Kegiatan Pembiayaan Bersama (Joint Financing)"),
	R_10040201020800 ("10040201020800", "Pembayaran untuk Perolehan Surat Berharga yang Diperjualbelikan"),
	R_10040201020900 ("10040201020900", "Pembayaran untuk Aktivitas Operasi Lainnya"),
	R_10040202000000 ("10040202000000", "Arus Kas Bersih dari Kegiatan Investasi"),
	R_10040202010000 ("10040202010000", "Penerimaan Kas dari Kegiatan Investasi "),
	R_10040202010100 ("10040202010100", "Penerimaan dari Pelepasan Anak Perusahaan "),
	R_10040202010200 ("10040202010200", "Penerimaan dari Penjualan Tanah, Bangunan, dan Peralatan "),
	R_10040202010300 ("10040202010300", "Penerimaan dari Penjualan Surat Berharga yang  Tidak Dimaksudkan untuk Diperjualbelikan"),
	R_10040202010400 ("10040202010400", "Penerimaan dividen "),
	R_10040202010500 ("10040202010500", "Penerimaan Bagi Hasil dari Kegiatan Investasi "),
	R_10040202010600 ("10040202010600", "Penerimaan dari Aktivitas Investasi Lainnya "),
	R_10040202020000 ("10040202020000", "Pembayaran Kas untuk Kegiatan Investasi "),
	R_10040202020100 ("10040202020100", "Pembayaran untuk Perolehan atas Anak Perusahaan"),
	R_10040202020200 ("10040202020200", "Pembayaran untuk Pembelian Tanah, Bangunan, dan Peralatan"),
	R_10040202020300 ("10040202020300", "Pembayaran untuk Perolehan Surat Berharga yang Tidak Diperjualbelikan "),
	R_10040202020400 ("10040202020400", "Pembayaran untuk Aktivitas Investasi Lainnya"),
	R_10040203000000 ("10040203000000", "Arus Kas bersih dari Aktivitas Pendanaan "),
	R_10040203010000 ("10040203010000", "Penerimaan Kas dari Kegiatan Pendanaan "),
	R_10040203010100 ("10040203010100", "Penerimaan dari Pendanaan Bank"),
	R_10040203010101 ("10040203010101", "Akad Mudharabah"),
	R_10040203010102 ("10040203010102", "Akad Mudharabah Musytarakah"),
	R_10040203010103 ("10040203010103", "Akad Musyarakah"),
	R_10040203010104 ("10040203010104", "Akad Lainnya"),
	R_10040203010200 ("10040203010200", "Penerimaan dari Pendanaan Nonbank"),
	R_10040203010201 ("10040203010201", "Akad Mudharabah"),
	R_10040203010202 ("10040203010202", "Akad Mudharabah Musytarakah"),
	R_10040203010203 ("10040203010203", "Akad Musyarakah"),
	R_10040203010204 ("10040203010204", "Akad Lainnya"),
	R_10040203010300 ("10040203010300", "Penerimaan dari Pinjaman (qardh) Subordinasi"),
	R_10040203010400 ("10040203010400", "Penerimaan dari Penerbitan Sukuk"),
	R_10040203010500 ("10040203010500", "Penerimaan dari Pendanaan Sekuritisasi dengan Prinsip Syariah"),
	R_10040203010600 ("10040203010600", "Penerimaan dari Pendanaan Lainnya Sesuai dengan Prinsip Syariah"),
	R_10040203010700 ("10040203010700", "Penerimaan dari Penerbitan Modal Saham "),
	R_10040203010800 ("10040203010800", "Penerimaan Setoran Modal Kerja (khusus UUS)"),
	R_10040203020000 ("10040203020000", "Pembayaran Kas untuk Kegiatan Pendanaan "),
	R_10040203020100 ("10040203020100", "Pengeluaran dari Pendanaan Bank"),
	R_10040203020101 ("10040203020101", "Akad Mudharabah"),
	R_10040203020102 ("10040203020102", "Akad Mudharabah Musytarakah"),
	R_10040203020103 ("10040203020103", "Akad Musyarakah"),
	R_10040203020104 ("10040203020104", "Akad Lainnya"),
	R_10040203020200 ("10040203020200", "Pengeluaran dari Pendanaan Nonbank"),
	R_10040203020201 ("10040203020201", "Akad Mudharabah"),
	R_10040203020202 ("10040203020202", "Akad Mudharabah Musytarakah"),
	R_10040203020203 ("10040203020203", "Akad Musyarakah"),
	R_10040203020204 ("10040203020204", "Akad Lainnya"),
	R_10040203020300 ("10040203020300", "Pengeluaran dari Pendanaan Pinjaman (qardh) Subordinasi"),
	R_10040203020400 ("10040203020400", "Pengeluaran dari Penerbitan Sukuk"),
	R_10040203020500 ("10040203020500", "Pengeluaran dari Pendanaan Sekuritisasi dengan Prinsip Syariah"),
	R_10040203020600 ("10040203020600", "Pengeluaran dari Pendanaan Lainnya Sesuai dengan Prinsip Syariah"),
	R_10040203020700 ("10040203020700", "Pembayaran untuk Penarikan Kembali Saham Perusahaan (treasury stock) "),
	R_10040203020800 ("10040203020800", "Pembayaran Dividen"),
	R_10040204000000 ("10040204000000", "Kenaikan (Penurunan)  dari Perubahan Kurs Valuta Kas dan Setara Kas "),
	R_10040205000000 ("10040205000000", "Kenaikan (Penurunan) Bersih Kas dan Setara Kas "),
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
		for (ER2020PosRbPps100402 eEnum : ER2020PosRbPps100402.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2020PosRbPps100402.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2020PosRbPps100402.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationFormKasDanSetaraKasPadaAkhirPeriode() {
		String comparatorFormCode = EFormRencanaBisnis.RB_100202.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_10040207000000.key, comparatorFormCode, 
				ER2018PosRbPps100202.R_10020201010000.getKey(), "Total Kas dan Setara Kas pada Akhir Periode|Total Kas dan Setara Kas pada Akhir Periode form " + comparatorFormCode + " #kolom#");
	}

	public static SegmentValidation genValidationArusKasBersihDariKegiatanOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201000000.key,
				R_10040201010000.key + "-" + R_10040201020000.key,
				"Total Arus Kas Bersih Dari Kegiatan Operasi|Perhitungan Arus Kas Bersih Dari Kegiatan Operasi");
	}

	public static SegmentValidation genValidationPenerimaanKasDariKegiatanOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201010000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 2, 7, 13, 22,23, 24, 25 }),
				"Total Penerimaan Kas Dari Kegiatan Operasi|Penjumlahan Penerimaan Kas Dari Kegiatan Operasi");
	}

	public static SegmentValidation genValidationPenerimaanDariPembiayaanJualBeli() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201010100.key,
				UtilMetadata.genPlusRow(getObjects(), 3, 6),
				"Total Penerimaan dari Pembiayaan Jual Beli|Penjumlahan Penerimaan dari Pembiayaan Jual Beli");
	}

	public static SegmentValidation genValidationPenerimaanDariPembiayaanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201010200.key,
				UtilMetadata.genPlusRow(getObjects(), 8, 12),
				"Total Penerimaan Dari Pembiayaan Investasi|Perhitungan Penerimaan Dari Pembiayaan Investasi");
	}

	public static SegmentValidation genValidationPenerimaanDariPembiayaanJasa() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201010300.key,
				UtilMetadata.genPlusRow(getObjects(), 14, 21),
				"Total Penerimaan Dari Pembiayaan Jasa|Penjumlahan Penerimaan Dari Pembiayaan Jasa");
	}

	public static SegmentValidation genValidationPembayaranKasUntukKegiatanOperasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201020000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 27, 32, 38, 47, 48,49,50, 51, 52 }),
				"Total Pembayaran Kas untuk Kegiatan Operasi|Penjumlahan Pembayaran Kas untuk Kegiatan Operasi");
	}

	public static SegmentValidation genValidationPembayaranUntukKegiatanPembiayaanJualBeli() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201020100.key,
				UtilMetadata.genPlusRow(getObjects(), 28, 31),
				"Total Pembayaran untuk Kegiatan Pembiayaan Jual Beli|Perhitungan Pembayaran untuk Kegiatan Pembiayaan Jual Beli");
	}

	public static SegmentValidation genValidationPembayaranUntukKegiatanPembiayaanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201020200.key,
				UtilMetadata.genPlusRow(getObjects(), 33, 37),
				"Total Pembayaran untuk Kegiatan Pembiayaan  Investasi|Penjumlahan Pembayaran untuk Kegiatan Pembiayaan  Investasi");
	}

	public static SegmentValidation genValidationPembayaranUntukKegiatanPembiayaanJasa() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040201020300.key,
				UtilMetadata.genPlusRow(getObjects(), 39, 46),
				"Total Pembayaran untuk Kegiatan Pembiayaan Jasa|Penjumlahan Pembayaran untuk Kegiatan Pembiayaan Jasa");
	}

	public static SegmentValidation genValidationArusKasBersihDariKegiatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040202000000.key,
				R_10040202010000.key + "-" + R_10040202020000.key,
				"Total Arus Kas Bersih dari Kegiatan Investasi|Perhitungan Arus Kas Bersih dari Kegiatan Investasi");
	}

	public static SegmentValidation genValidationPenerimaanKasDariKegiatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040202010000.key,
				UtilMetadata.genPlusRow(getObjects(), 55, 60),
				"Total Penerimaan Kas dari Kegiatan Investasi|Penjumlahan Penerimaan Kas dari Kegiatan Investasi");
	}

	public static SegmentValidation genValidationPembayaranKasUntukKegiatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040202020000.key,
				UtilMetadata.genPlusRow(getObjects(), 62, 65),
				"Total Pembayaran Kas untuk Kegiatan Investasi|Penjumlahan Pembayaran Kas untuk Kegiatan Investasi");
	}

	public static SegmentValidation genValidationArusKasBersihDariAktivitasPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040203000000.key,
				R_10040203010000.key + "-" + R_10040203020000.key,
				"Total Arus Kas bersih dari Aktivitas Pendanaan|Penjumlahan Arus Kas bersih dari Aktivitas Pendanaan");
	}

	public static SegmentValidation genValidationPenerimaanKasDariKegiatanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040203010000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 68, 73, 78, 79, 80, 81, 82, 83 }),
				"Total Penerimaan Kas dari Kegiatan Pendanaan|Penjumlahan Penerimaan Kas dari Kegiatan Pendanaan");
	}

	public static SegmentValidation genValidationPenerimaanDariPendanaanBank() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040203010100.key,
				UtilMetadata.genPlusRow(getObjects(), 69, 72),
				"Total Penerimaan dari Pendanaan Bank|Penjumlahan Penerimaan dari Pendanaan Bank");
	}

	public static SegmentValidation genValidationPenerimaanDariPendanaanNonbank() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040203010200.key,
				UtilMetadata.genPlusRow(getObjects(), 74, 77),
				"Total Penerimaan dari Pendanaan Nonbank|Penjumlahan Penerimaan dari Pendanaan Nonbank");
	}

	public static SegmentValidation genValidationPembayaranKasUntukKegiatanPendanaan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040203020000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 85, 90, 95, 96, 97, 98, 99, 100 }),
				"Total Pembayaran Kas untuk Kegiatan Pendanaan|Penjumlahan Pembayaran Kas untuk Kegiatan Pendanaan");
	}

	public static SegmentValidation genValidationPengeluaranDariPendanaanBank() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040203020100.key,
				UtilMetadata.genPlusRow(getObjects(), 86, 89),
				"Total Pengeluaran dari Pendanaan Bank|Penjumlahan Pengeluaran dari Pendanaan Bank");
	}

	public static SegmentValidation genValidationPengeluaranDariPendanaanNonbank() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040203020200.key,
				UtilMetadata.genPlusRow(getObjects(), 91, 94),
				"Total Pengeluaran dari Pendanaan Nonbank|Penjumlahan Pengeluaran dari Pendanaan Nonbank");
	}

	public static SegmentValidation genValidationKenaikanBersihKasDanSetaraKas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040205000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 53, 66, 101 }),
				"Total Kenaikan (Penurunan) Bersih Kas dan Setara Kas|Penjumlahan Kenaikan (Penurunan) Bersih Kas dan Setara Kas");
	}

	public static SegmentValidation genValidationKasDanSetaraKasPadaAkhirPeriode() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10040207000000.key,
				R_10040205000000.key + "+" + R_10040206000000.key,
				"Total Kas dan Setara Kas pada Akhir Periode|Penjumlahan Kas dan Setara Kas pada Akhir Periode");
	}
}
