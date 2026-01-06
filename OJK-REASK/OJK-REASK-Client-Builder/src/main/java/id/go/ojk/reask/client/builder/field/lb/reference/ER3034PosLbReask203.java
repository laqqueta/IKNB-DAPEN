package id.go.ojk.reask.client.builder.field.lb.reference;

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
public enum ER3034PosLbReask203 implements IObject<KeyValueString> {
	R_4402000001 ("4402000001", "Harta Benda (Property)"),
	R_4402000002 ("4402000002", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)"),
	R_4402000003 ("4402000003", "Pengangkutan (Marine Cargo)"),
	R_4402000004 ("4402000004", "Rangka Kapal (Marine Hull)"),
	R_4402000005 ("4402000005", "Rangka Pesawat (Aviation Hull)"),
	R_4402000006 ("4402000006", "Satelit"),
	R_4402000007 ("4402000007", "Energi Onshore (Oil and Gas)"),
	R_4402000008 ("4402000008", "Energi Offshore (Oil and Gas)"),
	R_4402000009 ("4402000009", "Rekayasa (Engineering)"),
	R_4402000010 ("4402000010", "Tanggung Gugat (Liability)"),
	R_4402000011 ("4402000011", "Kecelakaan Diri"),
	R_4402000012 ("4402000012", "Kesehatan"),
	R_4402000013 ("4402000013", "Kredit (Credit) "),
	R_4402000014 ("4402000014", "Suretyship"),
	R_4402000015 ("4402000015", "Aneka"),
	R_4402000016 ("4402000016", "Jiwa"),
	R_4402000000 ("4402000000", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3034PosLbReask203 eEnum : ER3034PosLbReask203.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5|6|7|8|9", getObjects());
	}
	
	public static FieldValidation genFieldValidation5() {
		return UtilFieldValidation.genEqualsPosFormula("2+3+4", UtilMetadata.genPipeRow(getObjects(), 0, 15));
	}
	
	public static FieldValidation genFieldValidation9() {
		return UtilFieldValidation.genEqualsPosFormula("6+7+8", UtilMetadata.genPipeRow(getObjects(), 0, 15));
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9", R_4402000000.key, UtilMetadata.genPlusRow(getObjects(), 0, 15), 
				"Total|Penjumlahan detail");
	}
}
