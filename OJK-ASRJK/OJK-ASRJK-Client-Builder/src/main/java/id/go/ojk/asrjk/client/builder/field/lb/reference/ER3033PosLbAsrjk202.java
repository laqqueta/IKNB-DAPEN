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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3033PosLbAsrjk202 implements IObject<KeyValueString> {
//	R_4401010000 ("4401010000", "Premi Produksi Baru"),
//	R_4401010100 ("4401010100", "a. Premi Diterima"),
	R_4401010101 ("4401010101", "- Dalam Negeri"),
	R_4401010102 ("4401010102", "- ASEAN"),
	R_4401010103 ("4401010103", "- Lainnya"),
//	R_4401010200 ("4401010200", "b. Komisi Dibayar"),
	R_4401010201 ("4401010201", "- Dalam Negeri -/-"),
	R_4401010202 ("4401010202", "- ASEAN -/-"),
	R_4401010203 ("4401010203", "- Lainnya -/-"),
//	R_4401010300 ("4401010300", "c. Klaim Dibayar"),
	R_4401010301 ("4401010301", "- Dalam Negeri -/-"),
	R_4401010302 ("4401010302", "- ASEAN -/-"),
	R_4401010303 ("4401010303", "- Lainnya -/-"),
	R_4401010099 ("4401010099", "Jumlah Premi Produksi Baru Setelah Klaim"),
//	R_4401020000 ("4401020000", "Premi Lanjutan"),
//	R_4401020100 ("4401020100", "a. Premi Diterima"),
	R_4401020101 ("4401020101", "- Dalam Negeri"),
	R_4401020102 ("4401020102", "- ASEAN"),
	R_4401020103 ("4401020103", "- Lainnya"),
//	R_4401020200 ("4401020200", "b. Komisi Dibayar"),
	R_4401020201 ("4401020201", "- Dalam Negeri -/-"),
	R_4401020202 ("4401020202", "- ASEAN -/-"),
	R_4401020203 ("4401020203", "- Lainnya -/-"),
//	R_4401020300 ("4401020300", "c. Klaim Dibayar"),
	R_4401020301 ("4401020301", "- Dalam Negeri -/-"),
	R_4401020302 ("4401020302", "- ASEAN -/-"),
	R_4401020303 ("4401020303", "- Lainnya -/-"),
	R_4401020099 ("4401020099", "Jumlah Premi Lanjutan Setelah Klaim"),
	R_4401000099 ("4401000099", "Jumlah Premi Baru dan Lanjutan Setelah Klaim"),
//	R_4401030000 ("4401030000", "Klaim dan Manfaat Dibayar"),
	R_4401030100 ("4401030100", "- Dalam Negeri"),
	R_4401030200 ("4401030200", "- ASEAN"),
	R_4401030300 ("4401030300", "- Lainnya"),
	R_4401030099 ("4401030099", "Jumlah Klaim dan Manfaat Dibayar"),
//	R_4401040000 ("4401040000", "Klaim Reasuransi"),
	R_4401040100 ("4401040100", "- Dalam Negeri"),
	R_4401040200 ("4401040200", "- ASEAN"),
	R_4401040300 ("4401040300", "- Lainnya"),
	R_4401040099 ("4401040099", "Jumlah Klaim Reasuransi"),
//	R_4401050000 ("4401050000", "Biaya Akuisisi"),
	R_4401050100 ("4401050100", "- Dalam Negeri"),
	R_4401050200 ("4401050200", "- ASEAN"),
	R_4401050300 ("4401050300", "- Lainnya"),
	R_4401050099 ("4401050099", "Jumlah Biaya Akuisisi"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3033PosLbAsrjk202 eEnum : ER3033PosLbAsrjk202.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3033PosLbAsrjk202.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3033PosLbAsrjk202.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 10), getObjects());
	}

	public static FieldValidation genFieldValidation10() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 9), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 9, 19, 20, 24, 28, 32 }));
	}
	
	public static SegmentValidation genValidationPremiProduksiBaruSetelahKlaim() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4401010099.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 2) + "-" + UtilMetadata.genMinusRow(getObjects(), 3, 8), 
				"Total premi produksi baru setelah klaim|Perhitungan premi produksi baru setelah klaim");
	}
	
	public static SegmentValidation genValidationPremiLanjutanSetelahKlaim() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4401020099.key, 
				UtilMetadata.genPlusRow(getObjects(), 10, 12) + "-" + UtilMetadata.genMinusRow(getObjects(), 13, 18), 
				"Total premi lanjutan setelah klaim|Perhitungan premi lanjutan setelah klaim");
	}
	
	public static SegmentValidation genValidationPremiBaruDanLanjutanSetelahKlaim() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4401000099.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 9, 19 }), 
				"Total premi baru dan lanjutan setelah klaim|Penjumlahan premi baru dan lanjutan setelah klaim");
	}
	
	public static SegmentValidation genValidationKlaimDanManfaatDibayar() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4401030099.key, 
				UtilMetadata.genPlusRow(getObjects(), 21, 23), 
				"Total klaim dan manfaat dibayar|Penjumlahan klaim dan manfaat dibayar");
	}
	
	public static SegmentValidation genValidationKlaimReasuransi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4401040099.key, 
				UtilMetadata.genPlusRow(getObjects(), 25, 27), 
				"Total klaim reasuransi|Penjumlahan klaim reasuransi");
	}
	
	public static SegmentValidation genValidationBiayaAkuisisi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4401050099.key, 
				UtilMetadata.genPlusRow(getObjects(), 29, 31), 
				"Total biaya akuisisi|Penjumlahan biaya akuisisi");
	}
}
