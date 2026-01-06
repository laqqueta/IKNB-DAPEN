package id.go.ojk.pps.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2018PosRbPps100202 implements IObject<KeyValueString> {
//	R_10020201000000 ("10020201000000", "ASET"),
	R_10020201010000 ("10020201010000", "Kas dan Setara Kas"),
	R_10020201020000 ("10020201020000", "Tagihan Derivatif"),
	R_10020201030000 ("10020201030000", "Piutang Pembiayaan - Neto"),
	R_10020201040000 ("10020201040000", "Penyertaan Modal"),
	R_10020201050000 ("10020201050000", "Investasi dalam Surat Berharga Syariah"),
	R_10020201060000 ("10020201060000", "Aset yang Digunakan untuk Kegiatan Usaha Pembiayaan – Neto"),
	R_10020201070000 ("10020201070000", "Aset Tetap dan Inventaris – Neto"),
	R_10020201080000 ("10020201080000", "Aset Pajak Tangguhan"),
	R_10020201090000 ("10020201090000", "Rupa-Rupa Aset"),
	R_10020201100000 ("10020201100000", "Jumlah Aset"),
//	R_10020202000000 ("10020202000000", "LIABILITAS"),
	R_10020202010000 ("10020202010000", "Liabilitas Segera"),
	R_10020202020000 ("10020202020000", "Liabilitas Derivatif"),
	R_10020202030000 ("10020202030000", "Utang Pajak"),
	R_10020202040000 ("10020202040000", "Pendanaan yang Diterima"),
	R_10020202050000 ("10020202050000", "Surat Berharga Syariah yang Diterbitkan"),
	R_10020202060000 ("10020202060000", "Liabilitas Pajak Tangguhan"),
	R_10020202070000 ("10020202070000", "Pinjaman (Qardh) Subordinasi"),
	R_10020202080000 ("10020202080000", "Rupa-Rupa Liabilitas "),
	R_10020202090000 ("10020202090000", "Jumlah Liabilitas"),
//	R_10020203000000 ("10020203000000", "EKUITAS"),
	R_10020203010000 ("10020203010000", "Modal"),
	R_10020203010100 ("10020203010100", "Modal Disetor / Modal Kerja"),
	R_10020203010200 ("10020203010200", "Simpanan Pokok dan Simpanan Wajib"),
	R_10020203010300 ("10020203010300", "Tambahan Modal Disetor"),
	R_10020203010301 ("10020203010301", "Agio"),
	R_10020203010302 ("10020203010302", "Disagio"),
	R_10020203010303 ("10020203010303", "Modal Saham yang Diperoleh Kembali"),
	R_10020203010304 ("10020203010304", "Biaya Emisi Efek Ekuitas"),
	R_10020203010305 ("10020203010305", "Modal Hibah"),
	R_10020203010306 ("10020203010306", "Tambahan Modal Disetor Lainnya"),
	R_10020203010400 ("10020203010400", "Selisih Nilai Transaksi Restrukturisasi Entitas Sepengendali"),
	R_10020203020000 ("10020203020000", "Cadangan "),
	R_10020203020100 ("10020203020100", "Cadangan Umum"),
	R_10020203020200 ("10020203020200", "Cadangan Tujuan"),
	R_10020203030000 ("10020203030000", "Saldo Laba (Rugi) Yang Ditahan"),
	R_10020203040000 ("10020203040000", "Laba (Rugi) Bersih Setelah Pajak"),
	R_10020203050000 ("10020203050000", "Komponen Ekuitas Lainnya"),
	R_10020203050100 ("10020203050100", "Saldo Komponen Ekuitas Lainnya"),
	R_10020203050200 ("10020203050200", "Keuntungan (Kerugian) Komperehensif Lainnya Periode Berjalan"),
	R_10020203060000 ("10020203060000", "Jumlah Ekuitas"),
	R_10020204000000 ("10020204000000", "Jumlah Liabilitas dan Ekuitas"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2018PosRbPps100202 eEnum : ER2018PosRbPps100202.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2018PosRbPps100202.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2018PosRbPps100202.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationJumlahAset() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020201100000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 8),
				"Total Aset|Penjumlahan Aset");
	}

	public static SegmentValidation genValidationJumlahLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020202090000.key,
				UtilMetadata.genPlusRow(getObjects(), 10, 17),
				"Total Liabilitas|Penjumlahan Liabilitas");
	}

	public static SegmentValidation genValidationModal() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020203010000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 20, 21, 22, 29 }), 
				"Total Modal|Penjumlahan Modal");
	}

	public static SegmentValidation genValidationTambahanModalDisetor() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020203010300.key,
				R_10020203010301.key + "-" + R_10020203010302.key + "-" + R_10020203010303.key + "+" +
				R_10020203010304.key + "+" + R_10020203010305.key + "+" + R_10020203010306.key,
				"Total Tambahan Modal Disetor|Perhitungan Tambahan Modal Disetor");
	}

	public static SegmentValidation genValidationCadangan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020203020000.key,
				R_10020203020100.key + "+" + R_10020203020200.key, "Total Cadangan|Penjumlahan Cadangan");
	}

	public static SegmentValidation genValidationKomponenEkuitasLainnya() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020203050000.key,
				R_10020203050100.key + "+" + R_10020203050200.key,
				"Total Komponen Ekuitas Lainnya|Penjumlahan Komponen Ekuitas Lainnya");
	}

	public static SegmentValidation genValidationJumlahEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020203060000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 19, 30, 33, 34, 35 }),
				"Total Ekuitas|Penjumlahan Ekuitas");
	}

	public static SegmentValidation genValidationJumlahLiabilitasDanEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020204000000.key,
				R_10020202090000.key + "+" + R_10020203060000.key,
				"Total Liabilitas dan Ekuitas|Penjumlahan Liabilitas dan Ekuitas");
	}
}
