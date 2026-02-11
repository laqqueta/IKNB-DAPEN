package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1254Reksadana implements IObject<KeyValueString> {

	R_RD1("RD01", "Reksa Dana Pasar Uang"),
	R_RD2("RD02", "Reksa Dana Pendapatan Tetap"),
	R_RD3("RD03", "Reksa Dana Campuran"),
	R_RD4("RD04", "Reksa Dana Saham"),
	R_RD5("RD05", "Reksa Dana Terproteksi"),
	R_RD6("RD06", "Reksa Dana dengan Penjaminan"),
	R_RD7("RD07", "Reksa Dana Indeks"),
	R_RD8("RD08", "Reksa Dana Berbentuk Kontrak Investasi Kolektif Penyertaan Terbatas"),
	R_RD9("RD09", "Reksa Dana yang Saham/Unit Penyertaannya Diperdagangkan di Bursa Efek"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1254Reksadana eEnum : ER1254Reksadana.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1254Reksadana.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1254Reksadana.class.getSimpleName().substring(2, 6));
	}
}
