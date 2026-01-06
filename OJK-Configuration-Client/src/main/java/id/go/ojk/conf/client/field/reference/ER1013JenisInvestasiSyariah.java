package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1013JenisInvestasiSyariah implements IObject<KeyValueString> {
	R_2010 ("2010", "Deposito "),
	R_2011 ("2011", "Sertifikat Deposito"),
	R_2031 ("2031", "Saham Syariah"),
	R_2024 ("2024", "Sukuk atau Obligasi Syariah"),
	R_2027 ("2027", "MTN Syariah"),
	R_2023 ("2023", "Surat Berharga Syariah Negara"),
	R_2012 ("2012", "Surat Berharga Syariah yang Diterbitkan oleh  Bank Indonesia"),
	R_2026 ("2026", "Surat Berharga Syariah yang Diterbitkan oleh Negara Selain Negara Republik Indonesia"),
	R_2025 ("2025", "Surat Berharga Syariah yang Diterbitkan oleh Lembaga Multinasional"),
	R_2040 ("2040", "Reksa Dana Syariah"),
	R_2048 ("2048", "Efek Beragun Aset Syariah"),
	R_2049 ("2049", "Dana Investasi Real Estate Syariah"),
	R_2061 ("2061", "REPO"),
	R_2062 ("2062", "Pembiayaan Melalui Kerjasama dengan Pihak Lain."),
	R_2060 ("2060", "Pembiayaan Syariah Dengan Hak Tanggungan"),
	R_2063 ("2063", "Penyertaan Langsung"),
	R_2064 ("2064", "Properti Investasi"),
	R_2001 ("2001", "Emas  murni"),
	R_2028 ("2028", "Sukuk Daerah"),
	R_2052 ("2052", "Dana Investasi Infrastruktur berbentuk kontrak investasi kolektif"),
	R_2065 ("2065", "Investasi lain"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1013JenisInvestasiSyariah eEnum : ER1013JenisInvestasiSyariah.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1013JenisInvestasiSyariah.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1013JenisInvestasiSyariah.class.getSimpleName().substring(2, 6));
	}
}
