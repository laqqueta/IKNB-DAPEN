package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1003JenisIndustri implements IObject<KeyValueString> {
	R_00 ("00", "Bank Konvensional"),
	R_05 ("05", "Bank Syariah"),
	R_10 ("10", "BPR - Rural Bank"),
	R_15 ("15", "BPRS - Syaria Rural Bank"),
	R_20 ("20", "Multifinance"),
	R_21 ("21", "Multifinance - Ventura"),
	R_22 ("22", "Multifinance Infrastruktur"),
	R_30 ("30", "Asuransi"),
	R_31 ("31", "Asuransi Umum"),
	R_32 ("32", "Asuransi Jiwa"),
	R_33 ("33", "Reasuransi"),
	R_34 ("34", "Asuransi Wajib"),
	R_35 ("35", "Asuransi Sosial"),
	R_36 ("36", "BPJS Ketenagakerjaan"),
	R_37 ("37", "Dana Pensiun"),
	R_38 ("38", "Fintech"),
	R_39 ("39", "Jasa penunjang  IKNB"),
	R_40 ("40", "Keagenan"),
	R_41 ("41", "Akuntan Publik"),
	R_42 ("42", "Jasa Penilai"),
	R_43 ("43", "Perusahaan Konsultan Aktuaria"),
	R_44 ("44", "Perusahaan Pialang Asuransi"),
	R_45 ("45", "Perusahaan Penilai Kerugian Asuransi"),
	R_46 ("46", "Perusahaan Pialang Reasuransi"),
	R_47 ("47", "Lembaga jasa keuangan lainnya"),
	R_48 ("48", "EXIM"),
	R_49 ("49", "Perusahaan Penjaminan Kredit"),
	R_50 ("50", "Pegadaian"),
	R_51 ("51", "Perusahaan Pembiayaan Sekunder Perumahan"),
	R_55 ("55", "IKNB Syariah"),
	R_25 ("25", "Perusahaan Pembiayaan Syariah"),
	R_56 ("56", "Asuransi Jiwa Syariah"),
	R_57 ("57", "Asuransi Umum Syariah"),
	R_58 ("58", "Reasuransi Syariah"),
	R_59 ("59", "Modal Ventura Syariah"),
	R_60 ("60", "Perusahaan Pembiayaan Infrastruktur Syariah"),
	R_61 ("61", "Perusahaan Penjaminan Syariah"),
	R_62 ("62", "Fintech Syariah"),
	R_70 ("70", "Securities Company"),
	R_71 ("71", "Emiten"),
	R_72 ("72", "SRO"),
	R_73 ("73", "Jasa Penunjang Pasar Modal "),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1003JenisIndustri eEnum : ER1003JenisIndustri.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1003JenisIndustri.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1003JenisIndustri.class.getSimpleName().substring(2, 6));
	}
}
