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
public enum ER3037PosLbAsrjs232 implements IObject<KeyValueString> {
//	R_2320090100 ("2320090100", "I. Kematian Ekawarsa (Masukkan semua produk asuransi jiwa)"),
	R_2320090101 ("2320090101", "Kematian Ekawarsa "),
	R_2320090102 ("2320090102", "Dwiguna / Dwiguna Kombinasi"),
	R_2320090103 ("2320090103", "Kecelakaan Diri"),
	R_2320090104 ("2320090104", "Kesehatan"),
//	R_2320090105 ("2320090105", "II Penyisihan Atas Risiko Yang Belum Dijalani"),
	R_2320090106 ("2320090106", "Kematian Ekawarsa "),
	R_2320090107 ("2320090107", "Kecelakaan Diri"),
	R_2320090108 ("2320090108", "Kesehatan"),
	R_2320090109 ("2320090109", "Total PAKYBMP"),
	R_2320090110 ("2320090110", "Total PARYBD"),
	R_2320090111 ("2320090111", "Maks (PAKYBMP,PARYBD)"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3037PosLbAsrjs232 eEnum : ER3037PosLbAsrjs232.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 7), getObjects());
	}
	
	public static FieldValidation genValidation5() {
		return UtilFieldValidation.genEqualsPosFormula("2+3+4", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 7, 8, 9 }));
	}
	
	public static SegmentValidation genValidationTotalPAKYBMP() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_2320090109.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 3), "Total PAKYBMP|Penjumlahan PAKYBMP");
	}
	
	public static SegmentValidation genValidationTotalPARYBD() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_2320090110.key, 
				UtilMetadata.genPlusRow(getObjects(), 4, 6), "Total PARYBD|Penjumlahan PARYBD");
	}
	
	public static SegmentValidation genValidationMaks() {
		return UtilSegmentValidation.genMaxValue(UtilMetadata.genPipeColumn(2, 7), R_2320090111.key, 
				UtilMetadata.genPipeRow(getObjects(), 7, 8), "", "perhitungan nilai maksimum");
	}
}
