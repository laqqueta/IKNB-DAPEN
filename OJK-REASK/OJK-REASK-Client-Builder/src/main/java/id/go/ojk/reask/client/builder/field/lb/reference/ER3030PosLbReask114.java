package id.go.ojk.reask.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3030PosLbReask114 implements IObject<KeyValueString> {
	R_2503000001 ("2503000001", "Harta Benda (Property)"),
	R_2503000002 ("2503000002", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)"),
	R_2503000003 ("2503000003", "Pengangkutan (Marine Cargo)"),
	R_2503000004 ("2503000004", "Rangka Kapal (Marine Hull)"),
	R_2503000005 ("2503000005", "Rangka Pesawat (Aviation Hull)"),
	R_2503000006 ("2503000006", "Satelit"),
	R_2503000007 ("2503000007", "Energi Onshore (Oil and Gas)"),
	R_2503000008 ("2503000008", "Energi Offshore (Oil and Gas)"),
	R_2503000009 ("2503000009", "Rekayasa (Engineering)"),
	R_2503000010 ("2503000010", "Tanggung Gugat (Liability)"),
	R_2503000011 ("2503000011", "Kecelakaan Diri"),
	R_2503000012 ("2503000012", "Kesehatan"),
	R_2503000013 ("2503000013", "Kredit (Credit) "),
	R_2503000014 ("2503000014", "Suretyship"),
	R_2503000015 ("2503000015", "Aneka"),
	R_2503000016 ("2503000016", "Jiwa"),
	R_2503000000 ("2503000000", "Total"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3030PosLbReask114 eEnum : ER3030PosLbReask114.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_2503000000.key, UtilMetadata.genPlusRow(getObjects(), 0, 15), 
				"Total|Penjumlahan detail");
	}
}
