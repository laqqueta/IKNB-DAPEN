package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1045CabangAsuransiUmum implements IObject<KeyValueString> {
	R_AHB ("AHB", "Harta Benda (Property)"),
	R_AKB ("AKB", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)"),
	R_APG ("APG", "Pengangkutan (Marine Cargo)"),
	R_ARK ("ARK", "Rangka Kapal (Marine Hull)"),
	R_ARP ("ARP", "Rangka Pesawat (Aviation Hull)"),
	R_SAT ("SAT", "Satelit"),
	R_EON ("EON", "Energi Onshore (Oil and Gas)"),
	R_EOF ("EOF", "Energi Offshore (Oil and Gas)"),
	R_RKY ("RKY", "Rekayasa (Engineering)"),
	R_TGG ("TGG", "Tanggung Gugat (Liability)"),
	R_PAH ("PAH", "Kecelakaan Diri"),
	R_HLT ("HLT", "Kesehatan"),
	R_KRE ("KRE", "Kredit (Credit) "),
	R_SRT ("SRT", "Suretyship"),
	R_ANK ("ANK", "Aneka"),
	R_JIW ("JIW", "Jiwa"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1045CabangAsuransiUmum eEnum : ER1045CabangAsuransiUmum.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1045CabangAsuransiUmum.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1045CabangAsuransiUmum.class.getSimpleName().substring(2, 6));
	}
}
