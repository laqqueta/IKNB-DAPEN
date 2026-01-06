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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2267PosRePpk100201 implements IObject<KeyValueString> {
//	R_10020101000000 ("10020101000000", "ASET"),
	R_10020101010000 ("10020101010000", "Kas dan Setara Kas"), 
	R_10020101020000 ("10020101020000", "Tagihan Derivatif"),
	R_10020101030000 ("10020101030000", "Piutang Pembiayaan - Neto"),
	R_10020101040000 ("10020101040000", "Penyertaan Modal"),
	R_10020101050000 ("10020101050000", "Investasi dalam Surat Berharga"),
	R_10020101060000 ("10020101060000", "Aset yang Disewa operasikan (Operating Lease) – Neto"),
	R_10020101070000 ("10020101070000", "Aset Tetap dan Inventaris – Neto"),
	R_10020101080000 ("10020101080000", "Aset Pajak Tangguhan"), 
	R_10020101090000 ("10020101090000", "Rupa-Rupa Aset"),
	R_10020101100000 ("10020101100000", "Jumlah Aset"),
//	R_10020102000000 ("10020102000000", "LIABILITAS"),
	R_10020102010000 ("10020102010000", "Liabilitas Segera"), 
	R_10020102020000 ("10020102020000", "Liabilitas Derivatif"),
	R_10020102030000 ("10020102030000", "Utang Pajak"), 
	R_10020102040000 ("10020102040000", "Pinjaman yang Diterima"),
	R_10020102050000 ("10020102050000", "Surat Berharga yang Diterbitkan"),
	R_10020102060000 ("10020102060000", "Liabilitas Pajak Tangguhan"),
	R_10020102070000 ("10020102070000", "Pinjaman Subordinasi"),
	R_10020102080000 ("10020102080000", "Rupa-Rupa Liabilitas "), 
	R_10020102090000 ("10020102090000", "Jumlah Liabilitas"),
//	R_10020103000000 ("10020103000000", "EKUITAS"),
	R_10020103010000 ("10020103010000", "Modal"), 
	R_10020103010100 ("10020103010100", "Modal Disetor"),
	R_10020103010200 ("10020103010200", "Simpanan Pokok dan Simpanan Wajib"),
	R_10020103010300 ("10020103010300", "Tambahan Modal Disetor"), 
	R_10020103010301 ("10020103010301", "Agio"),
	R_10020103010302 ("10020103010302", "Disagio"),
	R_10020103010303 ("10020103010303", "Modal Saham yang Diperoleh Kembali"),
	R_10020103010304 ("10020103010304", "Biaya Emisi Efek Ekuitas"), 
	R_10020103010305 ("10020103010305", "Modal Hibah"),
	R_10020103010306 ("10020103010306", "Tambahan Modal Disetor Lainnya"),
	R_10020103010400 ("10020103010400", "Selisih Nilai Transaksi Restrukturisasi Entitas Sepengendali"),
	R_10020103020000 ("10020103020000", "Cadangan "), 
	R_10020103020100 ("10020103020100", "Cadangan Umum"),
	R_10020103020200 ("10020103020200", "Cadangan Tujuan"),
	R_10020103030000 ("10020103030000", "Saldo Laba (Rugi) Yang Ditahan"),
	R_10020103040000 ("10020103040000", "Laba (Rugi) Bersih Setelah Pajak"),
	R_10020103050000 ("10020103050000", "Komponen Ekuitas Lainnya"),
	R_10020103050100 ("10020103050100", "Saldo Komponen Ekuitas Lainnya"),
	R_10020103050200 ("10020103050200", "Keuntungan (Kerugian) Komperehensif Lainnya Periode Berjalan"),
	R_10020103060000 ("10020103060000", "Jumlah Ekuitas"),
	R_10020104000000 ("10020104000000", "Jumlah Liabilitas dan Ekuitas"),;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2267PosRePpk100201 eEnum : ER2267PosRePpk100201.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2267PosRePpk100201.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2267PosRePpk100201.class.getSimpleName().substring(2, 6));
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

	public static SegmentValidation genValidationJumlahAset() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020101100000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 8),
				"Total Aset|Penjumlahan Aset");
	}

	public static SegmentValidation genValidationJumlahLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020102090000.key,
				UtilMetadata.genPlusRow(getObjects(), 10, 17),
				"Total Liabilitas|Penjumlahan Liabilitas");
	}

	public static SegmentValidation genValidationModal() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020103010000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 20, 21, 22, 29 }), "Total Modal|Penjumlahan Modal");
	}

	public static SegmentValidation genValidationTambahanModalDisetor() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020103010300.key,
				R_10020103010301.key + "-" + R_10020103010302.key + "-" + R_10020103010303.key + "+" +
				R_10020103010304.key + "+" + R_10020103010305.key + "+" + R_10020103010306.key,
				"Total Tambahan Modal Disetor|Penjumlahan Tambahan Modal Disetor");
	}

	public static SegmentValidation genValidationCadangan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020103020000.key, 
				R_10020103020100.key + "+" + R_10020103020200.key, 
				"Total Cadangan|Penjumlahan Cadangan");
	}

	public static SegmentValidation genValidationKomponenEkuitasLainnya() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020103050000.key,
				R_10020103050100.key + "+" + R_10020103050200.key,
				"Total Komponen Ekuitas Lainnya|Penjumlahan Komponen Ekuitas Lainnya");
	}

	public static SegmentValidation genValidationJumlahEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020103060000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 19, 30, 33, 34, 35 }),
				"Total Ekuitas|Penjumlahan Ekuitas");
	}

	public static SegmentValidation genValidationJumlahLiabilitasDanEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020104000000.key,
				R_10020102090000.key + "+" + R_10020103060000.key,
				"Total Liabilitas dan Ekuitas|Penjumlahan Liabilitas dan Ekuitas");
	}
}
