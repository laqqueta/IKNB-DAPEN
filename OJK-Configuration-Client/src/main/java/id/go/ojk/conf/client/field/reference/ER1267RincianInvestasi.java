package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1267RincianInvestasi implements IObject<KeyValueString> {

	R_RIV1("INV1", "Deposito on call pada Bank"),
	R_RIV2("INV2", "Deposito Berjangka pada Bank"),
	R_RIV3("INV3", "Sertifikat Deposito pada Bank"),
	R_RIV4("INV4", "Surat Berharga yang diterbitkan oleh Bank Indonesia"),
	R_RIV5("INV5", "Surat Berharga Negara"),
	R_RIV6("INV6", "Saham yang tercatat di Bursa Efek di Indonesia"),
	R_RIV7("INV7", "Obligasi korporasi yang tercatat di Bursa Efek di indonesia"),
	R_RIV8("INV8", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
	R_RIV9("INV9", "Obligasi/Sukuk Daerah"),
	R_RIV10("INV10", "Reksa Dana"),
	R_RIV11("INV11", "MTN"),
	R_RIV12("INV12", "Efek Beragun Aset"),
	R_RIV13("INV13", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
	R_RIV14("INV14", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
	R_RIV15("INV15", "Kontrak opsi dan kontrak berjangka efek yang diperdagangkan di Bursa Efek di Indonesia"),
	R_RIV16("INV16", "REPO"),
	R_RIV17("INV17", "Penyertaan langsung di Indonesia"),
	R_RIV18("INV18", "Tanah di Indonesia"),
	R_RIV19("INV19", "Bangunan di Indonesia"),
	R_RIV20("INV20", "Tanah dan Bangunan di Indonesia"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1267RincianInvestasi eEnum : ER1267RincianInvestasi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER1267RincianInvestasi.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER1267RincianInvestasi.class.getSimpleName().substring(2, 6));
	}
}
