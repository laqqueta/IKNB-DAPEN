package id.go.ojk.pmvs.client.builder.field.rb.reference;

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
public enum ER2014PosRbPmvs100202 implements IObject<KeyValueString> {
//	R_10020201000000 ("10020201000000", "ASET"),
	R_10020201010000 ("10020201010000", "Kas dan Setara Kas "),
	R_10020201020000 ("10020201020000", "Aset Tagihan Derivatif  "),
	R_10020201030000 ("10020201030000", "Investasi Modal Ventura berdasarkan Prinsip Syariah - Neto "),
	R_10020201040000 ("10020201040000", "Penyertaan pada Dana Ventura"),
	R_10020201050000 ("10020201050000", "Piutang Pengelolaan Dana Ventura"),
	R_10020201060000 ("10020201060000", "Tagihan terkait Kegiatan Usaha Lain"),
	R_10020201070000 ("10020201070000", "Investasi Dalam Surat Berharga"),
	R_10020201080000 ("10020201080000", "Aset Tetap dan Inventaris – Neto"),
	R_10020201090000 ("10020201090000", "Aset Pajak Tangguhan"),
	R_10020201100000 ("10020201100000", "Rupa-Rupa Aset"),
	R_10020201110000 ("10020201110000", "Jumlah Aset"),
//	R_10020202000000 ("10020202000000", "LIABILITAS"),
	R_10020202010000 ("10020202010000", "Liabilitas Segera"),
	R_10020202020000 ("10020202020000", "Liabilitas Derivatif"),
	R_10020202030000 ("10020202030000", "Utang Pajak"),
	R_10020202040000 ("10020202040000", "Pendanaan yang Diterima"),
	R_10020202050000 ("10020202050000", "Surat Berharga yang Diterbitkan"),
	R_10020202060000 ("10020202060000", "Liabilitas Pajak Tangguhan"),
	R_10020202070000 ("10020202070000", "Pendanaan Subordinasi"),
	R_10020202080000 ("10020202080000", "Rupa-Rupa Liabilitas "),
	R_10020202090000 ("10020202090000", "Jumlah Liabilitas"),
//	R_10020203000000 ("10020203000000", "EKUITAS"),
	R_10020203010000 ("10020203010000", "Modal"),
	R_10020203010100 ("10020203010100", "Modal Disetor"),
	R_10020203010200 ("10020203010200", "Simpanan Pokok dan Simpanan Wajib"),
	R_10020203010300 ("10020203010300", "Tambahan Modal Disetor"),
	R_10020203010301 ("10020203010301", "Agio"),
	R_10020203010302 ("10020203010302", "Biaya Emisi Efek Ekuitas"),
	R_10020203010303 ("10020203010303", "Modal Hibah"),
	R_10020203010304 ("10020203010304", "Tambahan Modal Disetor Lainnya"),
	R_10020203010400 ("10020203010400", "Disagio"),
	R_10020203010500 ("10020203010500", "Modal Saham yang Diperoleh Kembali"),
	R_10020203010600 ("10020203010600", "Selisih Nilai Transaksi Restrukturisasi Entitas Sepengendali"),
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
		for (ER2014PosRbPmvs100202 eEnum : ER2014PosRbPmvs100202.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2014PosRbPmvs100202.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2014PosRbPmvs100202.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationJumlahAset() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020201110000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 9),
				"Total Aset|Penjumlahan Aset");
	}

	public static SegmentValidation genValidationJumlahAsetJumlahLiabilitasDanEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020201110000.key,
				R_10020204000000.key,
				"Jumlah Aset|Jumlah Liabilitas dan Ekuitas");
	}

	public static SegmentValidation genValidationJumlahLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020202090000.key,
				UtilMetadata.genPlusRow(getObjects(), 11, 18),
				"Total Liabilitas|Penjumlahan Liabilitas");
	}

	public static SegmentValidation genValidationModal() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020203010000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 21, 22, 23, 30 }) + "-" + R_10020203010400.key + "+" + R_10020203010500.key, 
				"Total Modal|Perhitungan Modal");
	}

	public static SegmentValidation genValidationTambahanModalDisetor() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020203010300.key,
				UtilMetadata.genPlusRow(getObjects(), 24, 27),
				"Total Tambahan Modal Disetor|Penjumlahan Tambahan Modal Disetor");
	}

	public static SegmentValidation genValidationCadangan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020203020000.key,
				UtilMetadata.genPlusRow(getObjects(), 32, 33), "Total Cadangan|Penjumlahan Cadangan");
	}

	public static SegmentValidation genValidationKomponenEkuitasLainnya() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020203050000.key,
				UtilMetadata.genPlusRow(getObjects(), 37, 38),
				"Total Komponen Ekuitas Lainnya|Penjumlahan Komponen Ekuitas Lainnya");
	}

	public static SegmentValidation genValidationJumlahEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020203060000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 20, 31, 34, 35, 36 }),
				"Total Ekuitas|Penjumlahan Ekuitas");
	}

	public static SegmentValidation genValidationJumlahLiabilitasDanEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_10020204000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 19, 39 }),
				"Total Liabilitas dan Ekuitas|Penjumlahan Liabilitas dan Ekuitas");
	}
}
