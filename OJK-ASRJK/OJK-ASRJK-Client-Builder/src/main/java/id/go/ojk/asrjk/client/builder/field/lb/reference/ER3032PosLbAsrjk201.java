package id.go.ojk.asrjk.client.builder.field.lb.reference;

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
public enum ER3032PosLbAsrjk201 implements IObject<KeyValueString> {
//	R_4401010099 ("4401010099", "Premi Produksi Baru"),
//	R_4401010100 ("4401010100", "a. Asuransi Perorangan"),
	R_4401010101 ("4401010101", "- Premi Tunggal"),
	R_4401010102 ("4401010102", "- Premi Cicilan (Tahunan, Semesteran, dll)"),
	R_4401010199 ("4401010199", "Jumlah Premi Produksi Baru Perorangan "),
	R_4401010200 ("4401010200", "b. Asuransi Kumpulan"),
	R_4401010000 ("4401010000", "Jumlah Premi Produksi Baru "),
//	R_4401020099 ("4401020099", "Premi Lanjutan"),
	R_4401020100 ("4401020100", "a. Asuransi Perorangan"),
	R_4401020200 ("4401020200", "b. Asuransi Kumpulan"),
	R_4401020000 ("4401020000", "Jumlah Premi Lanjutan "),
//	R_4401030099 ("4401030099", "Premi Top Up"),
	R_4401030100 ("4401030100", "a. Asuransi Perorangan"),
	R_4401030200 ("4401030200", "b. Asuransi Kumpulan"),
	R_4401030000 ("4401030000", "Jumlah Premi Top Up "),
	R_4401990000 ("4401990000", "Jumlah Pendapatan Premi "),
	R_4402000000 ("4402000000", "Premi Reasuransi -/-"),
//	R_4403000099 ("4403000099", "Penurunan (Kenaikan)  CAPYBMP"),
//	R_4403000100 ("4403000100", "a. Penurunan (Kenaikan) CAPYBMP (Gross)"),
	R_4403000101 ("4403000101", "(1) Cadangan Premi tahun berjalan"),
	R_4403000102 ("4403000102", "(2) Cadangan Premi tahun lalu -/-"),
//	R_4403000200 ("4403000200", "b. Penurunan (Kenaikan) Aset Reasuransi Atas CAPYBMP"),
	R_4403000201 ("4403000201", "(1) Aset Reasuransi Atas CAPYBMP tahun berjalan -/-"),
	R_4403000202 ("4403000202", "(2) Aset Reasuransi Atas CAPYBMP tahun lalu"),
	R_4403000000 ("4403000000", "Jumlah Penurunan (Kenaikan) CAPYBMP"),
	R_4400000000 ("4400000000", "Jumlah Pendapatan Premi Neto"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3032PosLbAsrjk201 eEnum : ER3032PosLbAsrjk201.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3032PosLbAsrjk201.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3032PosLbAsrjk201.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects());
	}

	public static FieldValidation genFieldValidation10() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 9), 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 3, 5, 6, 8, 9, 12, 13, 14, 15, 16 }));
	}

	public static FieldValidation genFieldValidation13() {
		return UtilFieldValidation.genEqualsPosFormula("11+12", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 3, 5, 6, 8, 9, 12, 13, 14, 15, 16 }));
	}
	
	public static SegmentValidation genValidationPremiProduksiBaruPerorangan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_4401010199.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 1), 
				"Total premi produksi baru perorangan|Penjumlahan premi produksi baru perorangan");
	}
	
	public static SegmentValidation genValidationPremiProduksiBaru() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_4401010000.key, 
				UtilMetadata.genPlusRow(getObjects(), 2, 3), 
				"Total premi produksi baru|Penjumlahan premi produksi baru");
	}
	
	public static SegmentValidation genValidationPremiLanjutan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_4401020000.key, 
				UtilMetadata.genPlusRow(getObjects(), 5, 6), 
				"Total premi lanjutan|Penjumlahan premi lanjutan");
	}
	
	public static SegmentValidation genValidationPremiTopup() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_4401030000.key, 
				UtilMetadata.genPlusRow(getObjects(), 8, 9), 
				"Total premi topup|Penjumlahan premi topup");
	}
	
	public static SegmentValidation genValidationPendapatanPremi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_4401990000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 4, 7, 10 }), 
				"Total pendapatan premi|Penjumlahan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPenurunanCapybmp() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_4403000000.key, 
				UtilMetadata.genMinusRow(getObjects(), 13, 15) + "+" + R_4403000202.key, 
				"Total penurunan (kenaikan) CAPYBMP|Penjumlahan penurunan (kenaikan) CAPYBMP");
	}
	
	public static SegmentValidation genValidationPendapatanPremiNeto() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_4400000000.key, 
				R_4401990000.key + "-" + UtilMetadata.genPlusRow(getObjects(), new int[] { 12, 17 }), 
				"Total pendapatan premi neto|Penjumlahan pendapatan premi neto");
	}
}
