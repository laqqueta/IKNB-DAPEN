package id.go.ojk.asrus.client.builder.field.lb.reference;

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
public enum ER3036PosLbAsrus228 implements IObject<KeyValueString> {
	R_2280050100 ("2280050100", "I. Penyisihan Ujroh/Kontribusi"),
	R_2280050101 ("2280050101", "Harta Benda (Property)"),
	R_2280050102 ("2280050102", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)"),
	R_2280050103 ("2280050103", "Pengangkutan (Marine Cargo)"),
	R_2280050104 ("2280050104", "Rangka Kapal (Marine Hull)"),
	R_2280050105 ("2280050105", "Rangka Pesawat (Aviation Hull)"),
	R_2280050106 ("2280050106", "Satelit"),
	R_2280050107 ("2280050107", "Energi Onshore (Oil and Gas)"),
	R_2280050108 ("2280050108", "Energi Offshore (Oil and Gas)"),
	R_2280050109 ("2280050109", "Rekayasa (Engineering)"),
	R_2280050110 ("2280050110", "Tanggung Gugat (Liability)"),
	R_2280050111 ("2280050111", "Kecelakaan Diri"),
	R_2280050112 ("2280050112", "Kesehatan"),
	R_2280050113 ("2280050113", "Kredit (Credit) "),
	R_2280050114 ("2280050114", "Suretyship"),
	R_2280050115 ("2280050115", "Aneka"),
	R_2280050116 ("2280050116", "Jiwa*)"),
	R_2280050117 ("2280050117", "II. PKYBMP"),
	R_2280050118 ("2280050118", "Harta Benda (Property)"),
	R_2280050119 ("2280050119", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)"),
	R_2280050120 ("2280050120", "Pengangkutan (Marine Cargo)"),
	R_2280050121 ("2280050121", "Rangka Kapal (Marine Hull)"),
	R_2280050122 ("2280050122", "Rangka Pesawat (Aviation Hull)"),
	R_2280050123 ("2280050123", "Satelit"),
	R_2280050124 ("2280050124", "Energi Onshore (Oil and Gas)"),
	R_2280050125 ("2280050125", "Energi Offshore (Oil and Gas)"),
	R_2280050126 ("2280050126", "Rekayasa (Engineering)"),
	R_2280050127 ("2280050127", "Tanggung Gugat (Liability)"),
	R_2280050128 ("2280050128", "Kesehatan"),
	R_2280050129 ("2280050129", "Kecelakaan Diri"),
	R_2280050130 ("2280050130", "Kredit (Credit) "),
	R_2280050131 ("2280050131", "Suretyship"),
	R_2280050132 ("2280050132", "Aneka"),
	R_2280050133 ("2280050133", "Jiwa*)"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3036PosLbAsrus228 eEnum : ER3036PosLbAsrus228.values()) {
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
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 11, 17, 29 }));
	}
	
	public static ConditionalRequired genConditional6() {
		return genConditional3();
	}
	
	public static ConditionalRequired genConditional9() {
		return genConditional3();
	}
	
	public static FieldValidation genValidation4A() {
		return UtilFieldValidation.genEqualsPosFormula("2", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 11, 17, 29 }));
	}
	
	public static FieldValidation genValidation4B() {
		return UtilFieldValidation.genEqualsPosFormula("2+3", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 11, 29 }));
	}
	
	public static FieldValidation genValidation7A() {
		return UtilFieldValidation.genEqualsPosFormula("5", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 11, 17, 29 }));
	}
	
	public static FieldValidation genValidation7B() {
		return UtilFieldValidation.genEqualsPosFormula("5+6", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 11, 29 }));
	}
	
	public static FieldValidation genValidation8() {
		return UtilFieldValidation.genEqualsPosFormula("2+5", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 17 }));
	}
	
	public static FieldValidation genValidation9() {
		return UtilFieldValidation.genEqualsPosFormula("3+6", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 11, 29 }));
	}
	
	public static FieldValidation genValidation10A() {
		return UtilFieldValidation.genEqualsPosFormula("8", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 11, 17, 29 }));
	}
	
	public static FieldValidation genValidation10B() {
		return UtilFieldValidation.genEqualsPosFormula("8+9", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 11, 29 }));
	}
	
	public static SegmentValidation genValidationPenyisihanUjrohKontribusiA() {
		return UtilSegmentValidation.genEqualsFormula("2|4|5|7|8|10", R_2280050100.key, 
				UtilMetadata.genPlusRow(getObjects(), 2, 16), "Total Penyisihan Ujroh/Kontribusi|Penjumlahan Penyisihan Ujroh/Kontribusi");
	}
	
	public static SegmentValidation genValidationPenyisihanUjrohKontribusiB() {
		return UtilSegmentValidation.genEqualsFormula("3|6|9", R_2280050100.key, 
				R_2280050111.key, "kode komponen 2280050100|kode komponen 2280050111");
	}
	
	public static SegmentValidation genValidationPKYBMPA() {
		return UtilSegmentValidation.genEqualsFormula("2|4|5|7|8|10", R_2280050117.key, 
				UtilMetadata.genPlusRow(getObjects(), 18, 33), "Total PKYBMP|Penjumlahan PKYBMP");
	}
	
	public static SegmentValidation genValidationPKYBMPB() {
		return UtilSegmentValidation.genEqualsFormula("3|6|9", R_2280050117.key, 
				R_2280050129.key, "kode komponen 2280050117|kode komponen 2280050129");
	}
}
