package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1200LiniUsahaAsuransiUmum implements IObject<KeyValueString> {
	R_501 ("501", "Harta Benda"),
	R_502 ("502", "Kendaraan Bermotor"),
	R_503 ("503", "Pengangkutan"),
	R_504 ("504", "Rangka Kapal"),
	R_505 ("505", "Rangka Pesawat"),
	R_506 ("506", "Satelit"),
	R_507 ("507", "Energi Onshore"),
	R_508 ("508", "Energi Offshore"),
	R_509 ("509", "Rekayasa"),
	R_510 ("510", "Tanggung Gugat"),
	R_511 ("511", "Kecelakaan Diri"),
	R_512 ("512", "Kesehatan"),
	R_513 ("513", "Kredit"),
	R_514 ("514", "Suretyship"),
	R_515 ("515", "Aneka"),
	R_516 ("516", "Jiwa"),
	R_517 ("517", "Gempa Bumi"),
	R_518 ("518", "PAYDI"),
	R_519 ("519", "Third Party Liability (TPL) Kendaraan Bermotor"),
	R_520 ("520", "Asuransi perjalanan"),
	R_521 ("521", "Asuransi barang elektronik"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1200LiniUsahaAsuransiUmum eEnum :ER1200LiniUsahaAsuransiUmum.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1200LiniUsahaAsuransiUmum.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1200LiniUsahaAsuransiUmum.class.getSimpleName().substring(2, 6));
	}
}