package id.go.ojk.asruk.client.builder.field.lb.reference;

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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3042PosLbAsruk209 implements IObject<KeyValueString> {
//	R_4401010099 ("4401010099", "Premi Produksi Baru"),
//	R_4401010100 ("4401010100", "a. Asuransi Perorangan"),
	R_4401010101 ("4401010101", "- Premi tunggal"),
	R_4401010102 ("4401010102", "- Premi Cicilan (Tahunan, Semesteran, dll)"),
	R_4401010199 ("4401010199", "Jumlah Premi Produksi Baru Perorangan"),
	R_4401010200 ("4401010200", "b. Asuransi Kumpulan"),
	R_4401010000 ("4401010000", "Jumlah Premi Produksi Baru "),
//	R_4401020099 ("4401020099", "Premi Lanjutan"),
	R_4401020100 ("4401020100", "a. Asuransi Perorangan"),
	R_4401020200 ("4401020200", "b. Asuransi Kumpulan"),
	R_4401020000 ("4401020000", "Jumlah Premi Lanjutan"),
//	R_4401030099 ("4401030099", "Premi Top Up"),
	R_4401030100 ("4401030100", "a. Asuransi Perorangan"),
	R_4401030200 ("4401030200", "b. Asuransi Kumpulan"),
	R_4401030000 ("4401030000", "Jumlah Premi Top Up "),
	R_4401990000 ("4401990000", "Jumlah Pendapatan Premi "),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3042PosLbAsruk209 eEnum : ER3042PosLbAsruk209.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 5), getObjects());
	}
	public static FieldValidation genFieldValidation5() {
		return UtilFieldValidation.genEqualsPosFormula("3+4", UtilMetadata.genPipeRow(getObjects(), 
				new int[] { 0, 1, 3, 5, 6, 8, 9 }));
	}

	public static SegmentValidation genValidationJumlahPendapatanPremi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_4401990000.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 4, 7, 10 }), 
				"Total pendapatan premi|Penjumlahan pendapatan premi");
	}
	
	public static SegmentValidation genValidationJumlahPremiLanjutan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_4401020000.key, UtilMetadata.genPlusRow(getObjects(), 5, 6), 
				"Total premi lanjutan|Penjumlahan premi lanjutan");
	}

	public static SegmentValidation genValidationJumlahPremiProduksiBaru() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_4401010000.key, UtilMetadata.genPlusRow(getObjects(), 2, 3), 
				"Total premi produksi baru|Penjumlahan premi produksi baru");
	}
	
	public static SegmentValidation genValidationJumlahPremiProduksiBaruPerorangan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_4401010199.key, UtilMetadata.genPlusRow(getObjects(), 0, 1), 
				"Total premi Produksi baru perorangan|Penjumlahan premi Produksi baru perorangan");
	}
	
	public static SegmentValidation genValidationJumlahPremiTopUp() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_4401030000.key, UtilMetadata.genPlusRow(getObjects(), 8, 9), 
				"Total premi top up|Penjumlahan premi top up");
	}
}
