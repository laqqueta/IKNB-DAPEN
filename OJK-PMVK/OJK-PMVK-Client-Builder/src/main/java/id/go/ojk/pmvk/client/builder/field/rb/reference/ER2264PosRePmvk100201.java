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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2264PosRePmvk100201 implements IObject<KeyValueString> {
//	R_10020101000000 ("10020101000000", "ASET"),
	R_10020101010000 ("10020101010000", "Kas dan Setara Kas "),
	R_10020101020000 ("10020101020000", "Aset Tagihan Derivatif  "),
	R_10020101030000 ("10020101030000", "Pembiayaan/Penyertaan Modal Ventura - Neto "),
	R_10020101040000 ("10020101040000", "Investasi Modal Ventura berdasarkan Prinsip Syariah "),
	R_10020101050000 ("10020101050000", "Penyertaan pada Dana Ventura"),
	R_10020101060000 ("10020101060000", "Piutang Pengelolaan Dana Ventura"),
	R_10020101070000 ("10020101070000", "Tagihan terkait Kegiatan Usaha Lain"),
	R_10020101080000 ("10020101080000", "Investasi Dalam Surat Berharga"),
	R_10020101090000 ("10020101090000", "Aset Tetap dan Inventaris – Neto"),
	R_10020101100000 ("10020101100000", "Aset Pajak Tangguhan"),
	R_10020101110000 ("10020101110000", "Rupa-Rupa Aset"),
	R_10020101120000 ("10020101120000", "Jumlah Aset"),
//	R_10020102000000 ("10020102000000", "LIABILITAS"),
	R_10020102010000 ("10020102010000", "Liabilitas Segera"),
	R_10020102020000 ("10020102020000", "Liabilitas Derivatif"),
	R_10020102030000 ("10020102030000", "Utang Pajak"),
	R_10020102040000 ("10020102040000", "Pinjaman/Pendanaan yang Diterima"),
	R_10020102050000 ("10020102050000", "Surat Berharga yang Diterbitkan"),
	R_10020102060000 ("10020102060000", "Liabilitas Pajak Tangguhan"),
	R_10020102070000 ("10020102070000", "Pinjaman/Pendanaan Subordinasi"),
	R_10020102080000 ("10020102080000", "Rupa-Rupa Liabilitas "),
	R_10020102090000 ("10020102090000", "Jumlah Liabilitas"),
//	R_10020103000000 ("10020103000000", "EKUITAS"),
	R_10020103010000 ("10020103010000", "Modal"),
	R_10020103010100 ("10020103010100", "Modal Disetor"),
	R_10020103010200 ("10020103010200", "Simpanan Pokok dan Simpanan Wajib"),
	R_10020103010300 ("10020103010300", "Tambahan Modal Disetor"),
	R_10020103010301 ("10020103010301", "Agio"),
	R_10020103010302 ("10020103010302", "Biaya Emisi Efek Ekuitas"),
	R_10020103010303 ("10020103010303", "Modal Hibah"),
	R_10020103010304 ("10020103010304", "Tambahan Modal Disetor Lainnya"),
	R_10020203010400 ("10020203010400", "     Disagio"),
	R_10020203010500 ("10020203010500", "     Modal Saham yang Diperoleh Kembali"),
	R_10020203010600 ("10020203010600", "Selisih Nilai Transaksi Restrukturisasi Entitas Sepengendali"),
	R_10020103020000 ("10020103020000", "Cadangan "),
	R_10020103020100 ("10020103020100", "Cadangan Umum"),
	R_10020103020200 ("10020103020200", "Cadangan Tujuan"),
	R_10020103030000 ("10020103030000", "Saldo Laba (Rugi) Yang Ditahan"),
	R_10020103040000 ("10020103040000", "Laba (Rugi) Bersih Setelah Pajak"),
	R_10020103050000 ("10020103050000", "Komponen Ekuitas Lainnya"),
	R_10020103050100 ("10020103050100", "Saldo Komponen Ekuitas Lainnya"),
	R_10020103050200 ("10020103050200", "Keuntungan (Kerugian) Komperehensif Lainnya Periode Berjalan"),
	R_10020103060000 ("10020103060000", "Jumlah Ekuitas"),
	R_10020104000000 ("10020104000000", "Jumlah Liabilitas dan Ekuitas"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2264PosRePmvk100201 eEnum : ER2264PosRePmvk100201.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2264PosRePmvk100201.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2264PosRePmvk100201.class.getSimpleName().substring(2, 6));
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

	public static SegmentValidation genValidationJumlahAset() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020101120000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 10),
				"Jumlah Aset|Penjumlahan Aset");
	}

	public static SegmentValidation genValidationJumlahAsetJumlahLiabilitasDanEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020101120000.key,
				R_10020104000000.key,
				"Jumlah Aset|Jumlah Liabilitas dan Ekuitas");
	}

	public static SegmentValidation genValidationJumlahLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020102090000.key,
				UtilMetadata.genPlusRow(getObjects(), 12, 19),
				"Total Liabilitas|Penjumlahan Liabilitas");
	}

	public static SegmentValidation genValidationModal() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020103010000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 22, 23, 24, 31 }) + "-" + R_10020203010400.key + "+" + R_10020203010500.key, 
				"Total Modal|Penjumlahan Modal");
	}

	public static SegmentValidation genValidationTambahanModalDisetor() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020103010300.key,
				UtilMetadata.genPlusRow(getObjects(), 25, 28),
				"Total Tambahan Modal Disetor|Penjumlahan Tambahan Modal Disetor");
	}

	public static SegmentValidation genValidationCadangan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020103020000.key, 
				UtilMetadata.genPlusRow(getObjects(), 33, 34), 
				"Total Cadangan|Penjumlahan Cadangan");
	}

	public static SegmentValidation genValidationKomponenEkuitasLainnya() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020103050000.key,
				UtilMetadata.genPlusRow(getObjects(), 38, 39), 
				"Total Komponen Ekuitas Lainnya|Penjumlahan Komponen Ekuitas Lainnya");
	}

	public static SegmentValidation genValidationJumlahEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020103060000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 21, 32, 35, 36, 37 }),
				"Jumlah Ekuitas|Penjumlahan Ekuitas");
	}

	public static SegmentValidation genValidationJumlahLiabilitasDanEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_10020104000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 20, 40 }),
				"Total Liabilitas dan Ekuitas|Penjumlahan Liabilitas dan Ekuitas");
	}
}
