package id.go.ojk.asrjs.client.builder.field.lb.reference;

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
public enum ER3036PosLbAsrjs228 implements IObject<KeyValueString> {
//	R_2280050100 ("2280050100", "A. Asuransi Jiwa"),
	R_2280050101 ("2280050101", "1. Kematian Jangka Warsa (Term Life)"),
	R_2280050102 ("2280050102", "2. Dwiguna (Endowment) dan/atau Kombinasinya"),
	R_2280050103 ("2280050103", "3. Seumur Hidup (Whole Life)"),
	R_2280050104 ("2280050104", "4. Kesehatan"),
	R_2280050105 ("2280050105", "5. Kecelakaan Diri"),
	R_2280050106 ("2280050106", "6. Lainnya"),
	R_2280050107 ("2280050107", "Sub Jumlah A"),
	R_2280050108 ("2280050108", "B. Anuitas"),
	R_2280050109 ("2280050109", "Sub Jumlah B"),
	R_2280050110 ("2280050110", "Total Penyisihan Kontribusi"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3036PosLbAsrjs228 eEnum : ER3036PosLbAsrjs228.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects());
	}
	
	public static FieldValidation genFieldValidation11() {
		return UtilFieldValidation.genEqualsPosFormula("2+3+5+6+8+9", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 6, 8, 9 }));
	}
	
	public static SegmentValidation genValidationSubJumlahA() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_2280050107.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 5),  "Sub Jumlah A|Penjumlahan Sub Jumlah A");
	}
	
	public static SegmentValidation genValidationSubJumlahB() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_2280050109.key, 
				R_2280050108.key,  "Sub Jumlah B|Nilai B. Anuitas");
	}
	
	public static SegmentValidation genValidationTotalPenyisihanKontribusi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_2280050110.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 6, 8 }),  "Total Penyisihan Kontribusi|Penjumlahan Penyisihan Kontribusi");
	}
}
