package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1052JenisNonInvestasiVsKategori implements IObject<KeyValueString> {
	R_101 ("101", "CSH|SIDN|Se1"),
	R_102 ("102", "EKW|KTB|DWG|DWK|LFT|LFC|GAN|PAN|ACD|HLT|DLL"),
	R_103 ("103", "LO_IDN|LO_e1"),
	R_104 ("104", "LO_IDN|LO_e1"),
	R_105 ("105", "LO_IDN|LO_e1"),
	R_106 ("106", "LO_IDN|LO_e1"),
	R_107 ("107", "101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|999"),
	R_108 ("108", "101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|999"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1052JenisNonInvestasiVsKategori eEnum : ER1052JenisNonInvestasiVsKategori.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1052JenisNonInvestasiVsKategori.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1052JenisNonInvestasiVsKategori.class.getSimpleName().substring(2, 6));
	}
}
