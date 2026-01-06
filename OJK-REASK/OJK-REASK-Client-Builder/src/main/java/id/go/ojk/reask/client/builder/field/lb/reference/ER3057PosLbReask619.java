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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3057PosLbReask619 implements IObject<KeyValueString> {
	R_6801000000 ("6801000000", "Harta Benda (Property)"),
	R_6802000000 ("6802000000", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)"),
	R_6803000000 ("6803000000", "Pengangkutan (Marine Cargo)"),
	R_6804000000 ("6804000000", "Rangka Kapal (Marine Hull)"),
	R_6805000000 ("6805000000", "Rangka Pesawat (Aviation Hull)"),
	R_6806000000 ("6806000000", "Satelit"),
	R_6807000000 ("6807000000", "Energi Onshore (Oil and Gas)"),
	R_6808000000 ("6808000000", "Energi Offshore (Oil and Gas)"),
	R_6809000000 ("6809000000", "Rekayasa (Engineering)"),
	R_6810000000 ("6810000000", "Tanggung Gugat (Liability)"),
	R_6811000000 ("6811000000", "Kecelakaan Diri"),
	R_6812000000 ("6812000000", "Kesehatan"),
	R_6813000000 ("6813000000", "Kredit (Credit) "),
	R_6814000000 ("6814000000", "Suretyship"),
	R_6815000000 ("6815000000", "Aneka"),
	R_6816000000 ("6816000000", "Jiwa"),
	R_6817000000 ("6817000000", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3057PosLbReask619 eEnum : ER3057PosLbReask619.values()) {
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
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_6817000000.key, UtilMetadata.genPlusRow(getObjects(), 0, 15), 
				"Total|Penjumlahan detail");
	}
}
