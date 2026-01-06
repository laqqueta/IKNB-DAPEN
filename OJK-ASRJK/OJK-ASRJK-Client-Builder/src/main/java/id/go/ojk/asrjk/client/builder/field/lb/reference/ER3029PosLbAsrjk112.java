package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3029PosLbAsrjk112 implements IObject<KeyValueString> {
//	R_2502010000 ("2502010000", "I. Cadangan Atas Premi Yang Belum Merupakan Pendapatan"),
	R_2502010100 ("2502010100", "Kematian Ekawarsa "),
	R_2502010200 ("2502010200", "Kecelakaan Diri"),
	R_2502010300 ("2502010300", "Kesehatan"),
	R_2502010400 ("2502010400", "Total CAPYBMP"),
//	R_2502020000 ("2502020000", "II. Cadangan Atas Risiko Yang Belum Dijalani"),
	R_2502020100 ("2502020100", "Kematian Ekawarsa "),
	R_2502020200 ("2502020200", "Kecelakaan Diri"),
	R_2502020300 ("2502020300", "Kesehatan"),
	R_2502030000 ("2502030000", "Total CARYBD"),
	R_2502040000 ("2502040000", "Maks (CAPYBMP,CARYBD)"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3029PosLbAsrjk112 eEnum : ER3029PosLbAsrjk112.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3029PosLbAsrjk112.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3029PosLbAsrjk112.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 7), getObjects());
	}
	
	public static ConditionalRequired genCondition2346() {
		return UtilFieldConditional.genExistPos("N", "M", R_2502040000.key);
	}
	
	public static FieldValidation genFieldValidation5() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 4), 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 4, 5, 6 }));
	}
	
	public static SegmentValidation genValidationCapybmp() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_2502010400.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 2), 
				"Total CAPYBMP|Penjumlahan CAPYBMP");
	}
	
	public static SegmentValidation genValidationCarybd() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_2502030000.key, 
				UtilMetadata.genPlusRow(getObjects(), 4, 6), 
				"Total CARYBD|Penjumlahan CARYBD");
	}
	
	public static SegmentValidation genValidationMax() {
		return UtilSegmentValidation.genMaxValue(UtilMetadata.genPipeColumn(new int[] { 5, 7 }), R_2502040000.key, 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 3, 7 }), "0",
				"perhitungan nilai maksimum");
	}
}
