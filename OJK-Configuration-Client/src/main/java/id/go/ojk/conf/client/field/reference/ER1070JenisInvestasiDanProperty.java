package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1070JenisInvestasiDanProperty implements IObject<KeyValueString> {
	R_2001 ("2001", "Setara Kas - Emas"),
	R_2002 ("2002", "Setara Kas - Deposito Berjangka (TD)"),
	R_2003 ("2003", "Setara Kas - Lainnya"),
	R_2011 ("2011", "Surat Berharga Pasar Uang - Sertifikat Deposito (CD)"),
	R_2012 ("2012", "Surat Berharga Pasar Uang - SBI"),
	R_2013 ("2013", "Surat Berharga Pasar Uang - Surat Berharga Komersial (CP)"),
	R_2014 ("2014", "Surat Berharga Pasar Uang - Wesel"),
	R_2015 ("2015", "Surat Berharga Pasar Uang - Promes/Aksep (BAs)"),
	R_2016 ("2016", "Surat Berharga Pasar Uang - Lainnya"),
	R_2021 ("2021", "Surat Berharga Pasar Modal - Obligasi - Surat Berharga Negara - Surat Utang Negara - Surat Perbendaharaan Negara"),
	R_2022 ("2022", "Surat Berharga Pasar Modal - Obligasi - Surat Berharga Negara - Surat Utang Negara - Obligasi Negara"),
	R_2023 ("2023", "Surat Berharga Pasar Modal - Obligasi - Surat Berharga Negara - Surat Berharga Syariah Negara"),
	R_2024 ("2024", "Surat Berharga Pasar Modal - Obligasi - Obligasi Korporasi"),
	R_2025 ("2025", "Surat Berharga Pasar Modal - Obligasi - Lembaga Multinasional"),
	R_2026 ("2026", "Surat Berharga Pasar Modal - Obligasi - Negara Lain"),
	R_2027 ("2027", "MTN Syariah"),
	R_2028 ("2028", "Sukuk Daerah"),
	R_2031 ("2031", "Surat Berharga Pasar Modal - Saham Syariah"),
	R_2041 ("2041", "Surat Berharga Pasar Modal - Reksadana - RD Konvensional"),
	R_2042 ("2042", "Surat Berharga Pasar Modal - Reksadana - RD Terstruktur"),
	R_2043 ("2043", "Surat Berharga Pasar Modal - Reksadana - RD Syariah-SBSN"),
	R_2044 ("2044", "Surat Berharga Pasar Modal - Reksadana - RD Syariah-Sukuk Swasta"),
	R_2045 ("2045", "Surat Berharga Pasar Modal - Reksadana - RD Syariah-Ekuitas"),
	R_2046 ("2046", "Surat Berharga Pasar Modal - Reksadana - RD Syariah-Campuran"),
	R_2053 ("2053", "Surat Berharga Pasar Modal - Reksadana - RD Syariah-Pasar Uang"),
	R_2054 ("2054", "Surat Berharga Pasar Modal - Reksadana - RD Syariah-Terproteksi"),
	R_2055 ("2055", "Surat Berharga Pasar Modal - Reksadana - RD Syariah-Indexs"),
	R_2056 ("2056", "Surat Berharga Pasar Modal - Reksadana - RD Syariah-Luar Negeri"),
	R_2047 ("2047", "Surat Berharga Pasar Modal - Reksadana - RD Penyertaan Terbatas"),
	R_2048 ("2048", "Surat Berharga Pasar Modal - Reksadana - KIK EBA"),
	R_2049 ("2049", "Surat Berharga Pasar Modal - Reksadana - DIRE"),
	R_2050 ("2050", "Surat Berharga Pasar Modal - Reksadana - ETFs"),
	R_2051 ("2051", "Surat Berharga Pasar Modal - Lainnya"),
	R_2052 ("2052", "Dana Investasi Infrastruktur berbentuk kontrak investasi kolektif"),
	R_2060 ("2060", "Pembiayaan Syariah dengan Hak Tanggungan (2060)"),
	R_2061 ("2061", "REPO"),
	R_2062 ("2062", "Pembiayaan Melalui Kerjasama dengan Pihak Lain "),
	R_2063 ("2063", "Penyertaan Langsung"),
	R_2064 ("2064", "Properti Investasi"),
	R_2065 ("2065", "Investasi Lain"),
	R_2066 ("2066", "Properti Non Investasi"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1070JenisInvestasiDanProperty eEnum : ER1070JenisInvestasiDanProperty.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1070JenisInvestasiDanProperty.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1070JenisInvestasiDanProperty.class.getSimpleName().substring(2, 6));
	}
}
