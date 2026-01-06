package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1063JenisLiabilitasVsKategoriUtang implements IObject<KeyValueString> {
	R_01 ("01", "EKW|KTB|DWG|DWK|LFT|LFC|GAN|PAN|ACD|HLT"),
	R_02 ("02", "LO_IDN|LO_e1"),
	R_03 ("03", "LO_IDN|LO_e1"),
	R_04 ("04", "EKW|KTB|DWG|DWK|LFT|LFC|GAN|PAN|ACD|HLT"),
	;

	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1063JenisLiabilitasVsKategoriUtang eEnum : ER1063JenisLiabilitasVsKategoriUtang.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1063JenisLiabilitasVsKategoriUtang.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1063JenisLiabilitasVsKategoriUtang.class.getSimpleName().substring(2, 6));
	}
}
