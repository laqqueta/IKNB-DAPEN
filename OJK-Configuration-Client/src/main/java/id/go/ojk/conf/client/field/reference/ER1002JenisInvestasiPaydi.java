package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1002JenisInvestasiPaydi implements IObject<KeyValueString> {
	R_101 ("101", "Deposito"),
	R_102 ("102", "Sertifikat Deposito"),
	R_103 ("103", "Saham"),
	R_104 ("104", "Obligasi Korporasi"),
	R_105 ("105", "MTN"),
	R_106 ("106", "Surat Berharga yang Diterbitkan oleh Negara RI"),
	R_107 ("107", "Surat Berharga yang Diterbitkan oleh Negara Selain Negara RI"),
	R_108 ("108", "Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
	R_109 ("109", "Surat Berharga yang Diterbitkan oleh Lembaga Multinasional"),
	R_110 ("110", "Reksa Dana"),
	R_111 ("111", "Efek Beragun Aset"),
	R_113 ("113", "REPO"),
	R_117 ("117", "Emas Murni"),
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
		for (ER1002JenisInvestasiPaydi eEnum : ER1002JenisInvestasiPaydi.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1002JenisInvestasiPaydi.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1002JenisInvestasiPaydi.class.getSimpleName().substring(2, 6));
	}
}
