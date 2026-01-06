package id.go.ojk.reass.client.builder.field.lb.reference;

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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3027PosLbReass219 implements IObject<KeyValueString> {
	R_2190000099 ("2190000099", "Harta Benda (Property)"),
	R_2190000100 ("2190000100", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)"),
	R_2190000101 ("2190000101", "Pengangkutan (Marine Cargo)"),
	R_2190000102 ("2190000102", "Rangka Kapal (Marine Hull)"),
	R_2190000103 ("2190000103", "Rangka Pesawat (Aviation Hull)"),
	R_2190000104 ("2190000104", "Satelit"),
	R_2190000105 ("2190000105", "Energi Onshore (Oil and Gas)"),
	R_2190000106 ("2190000106", "Energi Offshore (Oil and Gas)"),
	R_2190000107 ("2190000107", "Rekayasa (Engineering)"),
	R_2190000108 ("2190000108", "Tanggung Gugat (Liability)"),
	R_2190000109 ("2190000109", "Aneka"),
	R_2190000110 ("2190000110", "Kesehatan"),
	R_2190000111 ("2190000111", "Kecelakaan Diri"),
	R_2190000112 ("2190000112", "Jiwa*)"),
	R_2190000113 ("2190000113", "Total max ((PK* - PK), 0)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3027PosLbReass219 eEnum : ER3027PosLbReass219.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}
	
	public static ConditionalRequired genConditional4() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 14 }));
	}

	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsPosMaxValue("3-2", "0", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 14 }));
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_2190000113.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 13), "Total max ((PK* - PK), 0)|Perhitungan max ((PK* - PK), 0)");
	}
}
