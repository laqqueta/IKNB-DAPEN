package id.go.ojk.asrus.client.builder.field.lb.reference;

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
public enum ER3037PosLbAsrus229 implements IObject<KeyValueString> {
	R_2290060100 ("2290060100", "Harta Benda (Property)"),
	R_2290060101 ("2290060101", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)"),
	R_2290060102 ("2290060102", "Pengangkutan (Marine Cargo)"),
	R_2290060103 ("2290060103", "Rangka Kapal (Marine Hull)"),
	R_2290060104 ("2290060104", "Rangka Pesawat (Aviation Hull)"),
	R_2290060105 ("2290060105", "Satelit"),
	R_2290060106 ("2290060106", "Energi Onshore (Oil and Gas)"),
	R_2290060107 ("2290060107", "Energi Offshore (Oil and Gas)"),
	R_2290060108 ("2290060108", "Rekayasa (Engineering)"),
	R_2290060109 ("2290060109", "Tanggung Gugat (Liability)"),
	R_2290060110 ("2290060110", "Kredit (Credit) "),
	R_2290060111 ("2290060111", "Suretyship"),
	R_2290060112 ("2290060112", "Aneka"),
	R_2290060113 ("2290060113", "Kesehatan"),
	R_2290060114 ("2290060114", "Kecelakaan Diri"),
	R_2290060115 ("2290060115", "Jiwa*)"),
	R_2290060116 ("2290060116", "Total"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3037PosLbAsrus229 eEnum : ER3037PosLbAsrus229.values()) {
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
		return UtilFieldValidation.genEqualsPosFormula("2+3+4", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 16 }));
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_2290060116.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 15), "Total|Penjumlahan Detail");
	}
}
