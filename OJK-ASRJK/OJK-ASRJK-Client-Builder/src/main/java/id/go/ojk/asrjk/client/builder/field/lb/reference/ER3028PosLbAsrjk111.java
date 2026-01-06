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
public enum ER3028PosLbAsrjk111 implements IObject<KeyValueString> {
//	R_2501010099 ("2501010099", "Tradisional"),
//	R_2501010199 ("2501010199", "A. Asuransi Jiwa"),
	R_2501010101 ("2501010101", "1. Kematian Jangka Warsa (Term Life)"),
	R_2501010102 ("2501010102", "2. Dwiguna (Endowment) dan/atau Kombinasinya"),
	R_2501010103 ("2501010103", "3. Seumur Hidup (Whole Life)"),
	R_2501010104 ("2501010104", "4. Kecelakaan Diri"),
	R_2501010105 ("2501010105", "5. Kesehatan"),
	R_2501010106 ("2501010106", "6. Lainnya"),
	R_2501010100 ("2501010100", "Sub Jumlah A"),
//	R_2501010299 ("2501010299", "B. Anuitas"),
	R_2501010200 ("2501010200", "Sub Jumlah B"),
	R_2501010001 ("2501010001", "Total Cadangan Premi Tradisional"),
//	R_2501020000 ("2501020000", "PAYDI"),
//	R_2501020199 ("2501020199", "A. Asuransi Jiwa"),
	R_2501020101 ("2501020101", "1. Kematian Jangka Warsa (Term Life)"),
	R_2501020102 ("2501020102", "2. Dwiguna (Endowment) dan/atau Kombinasinya"),
	R_2501020103 ("2501020103", "3. Seumur Hidup (Whole Life)"),
	R_2501020104 ("2501020104", "4. Kecelakaan Diri"),
	R_2501020105 ("2501020105", "5. Kesehatan"),
	R_2501020106 ("2501020106", "6. Lainnya"),
	R_2501020100 ("2501020100", "Sub Jumlah A"),
//	R_2501020299 ("2501020299", "B. Anuitas"),
	R_2501020200 ("2501020200", "Sub Jumlah B"),
	R_2501010002 ("2501010002", "Total Cadangan Premi PAYDI"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3028PosLbAsrjk111 eEnum : ER3028PosLbAsrjk111.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3028PosLbAsrjk111.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3028PosLbAsrjk111.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects());
	}
	
	public static FieldValidation genFieldValidation11A() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 10), 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 4, 5, 7, 16 }));
	}
	
	public static FieldValidation genFieldValidation11B() {
		return UtilFieldValidation.genEqualsPosFormula("3+4+6+7+9+10", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 9, 10, 11, 12, 13, 14 }));
	}
	
	public static SegmentValidation genValidationAsuransiJiwaTradisional() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_2501010100.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 5), 
				"Total asuransi jiwa tradisional|Penjumlahan asuransi jiwa tradisional");
	}
	
	public static SegmentValidation genValidationCadanganPremiTradisional() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_2501010001.key, 
				UtilMetadata.genPlusRow(getObjects(), 6, 7), 
				"Total cadangan premi tradisional|Penjumlahan cadangan premi tradisional");
	}
	
	public static SegmentValidation genValidationAsuransiJiwaPaydi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_2501020100.key, 
				UtilMetadata.genPlusRow(getObjects(), 9, 14), 
				"Total asuransi jiwa PAYDI|Penjumlahan asuransi jiwa PAYDI");
	}
	
	public static SegmentValidation genValidationCadanganPremiPaydi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_2501010002.key, 
				UtilMetadata.genPlusRow(getObjects(), 15, 16), 
				"Total cadangan premi PAYDI|Penjumlahan cadangan premi PAYDI");
	}
}
