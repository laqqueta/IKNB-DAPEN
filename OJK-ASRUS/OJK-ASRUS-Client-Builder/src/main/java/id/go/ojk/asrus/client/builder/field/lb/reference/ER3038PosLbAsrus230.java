package id.go.ojk.asrus.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3038PosLbAsrus230 implements IObject<KeyValueString> {
	R_2300070100 ("2300070100", "Harta Benda (Property)"),
	R_2300070101 ("2300070101", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)"),
	R_2300070102 ("2300070102", "Pengangkutan (Marine Cargo)"),
	R_2300070103 ("2300070103", "Rangka Kapal (Marine Hull)"),
	R_2300070104 ("2300070104", "Rangka Pesawat (Aviation Hull)"),
	R_2300070105 ("2300070105", "Satelit"),
	R_2300070106 ("2300070106", "Energi Onshore (Oil and Gas)"),
	R_2300070107 ("2300070107", "Energi Offshore (Oil and Gas)"),
	R_2300070108 ("2300070108", "Rekayasa (Engineering)"),
	R_2300070109 ("2300070109", "Tanggung Gugat (Liability)"),
	R_2300070110 ("2300070110", "Kecelakaan Diri"),
	R_2300070111 ("2300070111", "Kesehatan"),
	R_2300070112 ("2300070112", "Kredit (Credit) "),
	R_2300070113 ("2300070113", "Suretyship"),
	R_2300070114 ("2300070114", "Aneka"),
	R_2300070115 ("2300070115", "Jiwa*)"),
	R_2300070116 ("2300070116", "Total  II"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3038PosLbAsrus230 eEnum : ER3038PosLbAsrus230.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
