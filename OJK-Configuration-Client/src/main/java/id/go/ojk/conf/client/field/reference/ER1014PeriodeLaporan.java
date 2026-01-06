package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1014PeriodeLaporan implements IObject<KeyValueString> {
	R_0 ("0", "Near Realtime"),
	R_1 ("1", "Harian"),
	R_2 ("2", "Mingguan"),
	R_3 ("3", "Bulanan"),
	R_4 ("4", "Triwulanan"),
	R_5 ("5", "Semester"),
	R_6 ("6", "Tahunan"),
	R_00 ("00", "Gabungan"),
	R_10 ("10", "Konsolidasi"),
	R_20 ("20", "Per Kantor"),
	R_30 ("30", "Per kantor syariah"),
	R_40 ("40", "Per kantor konvensional"),
	R_50 ("50", "Unit Usaha Syariah"),
	R_60 ("60", "Gabungan konvensional"),
	R_70 ("70", "Perusahaan anak"),
	R_80 ("80", "Not Available"),
	R_90 ("90", "Kantor Pusat"),
	R_15 ("15", "Produk"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1014PeriodeLaporan eEnum : ER1014PeriodeLaporan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1014PeriodeLaporan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1014PeriodeLaporan.class.getSimpleName().substring(2, 6));
	}
}
