package id.go.ojk.client.constant;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ESector {
	ASRJK ("031201", "031201", ESectorType.KONVENSIONAL, "Asuransi Jiwa Konvensional"),
	ASRJU ("031201", "031201", ESectorType.UUS, "Asuransi Jiwa Unit Usaha Syariah"),
	ASRUK ("031202", "031202", ESectorType.KONVENSIONAL, "Asuransi Umum Konvensional"),
	ASRUU ("031202", "031202", ESectorType.UUS, "Asuransi Umum Unit Usaha Syariah"),
	REASK ("031203", "031203", ESectorType.KONVENSIONAL, "ReAsuransi Konvensional"),
	REASU ("031203", "031203", ESectorType.UUS, "ReAsuransi Unit Usaha Syariah"),
	PPK ("031401", "031401", ESectorType.KONVENSIONAL, "Perusahaan Pembiayaan Konvensional"),
	PPU ("031401", "031401", ESectorType.UUS, "Perusahaan Pembiayaan Unit Usaha Syariah"),
	DPPKK ("031301", "031301", ESectorType.KONVENSIONAL, "Dana Pensiun Pemberi Kerja (DPPK) Konvensional"),
	DPPKU ("031301", "031301", ESectorType.UUS, "Dana Pensiun Pemberi Kerja (DPPK) Unit Usaha Syariah"),
	DPLKK ("031302",  "031302",ESectorType.KONVENSIONAL, "Dana Pensiun Lembaga Keuangan (DPLK) Konvensional"),
	PMVK ("031403", "031403", ESectorType.KONVENSIONAL, "Perusahaan Modal Ventura Konvensional"),
	GDK ("030401", "030401", ESectorType.KONVENSIONAL, "Pegadaian Konvensional"),
	PMVU ("031403", "031403", ESectorType.UUS, "Perusahaan Modal Ventura Unit Usaha Syariah"),
	ASRJS ("031204", "031204", ESectorType.SYARIAH, "Asuransi Jiwa Syariah"),
	ASRUS ("031205", "031205", ESectorType.SYARIAH, "Asuransi Umum Syariah"),
	REASS ("031206", "031206", ESectorType.SYARIAH, "Reasuransi Syariah"),
	PPS ("031402", "031402", ESectorType.SYARIAH, "Perusahaan Pembiayaan Syariah"),
	DPPKS ("031303", "031303", ESectorType.SYARIAH, "Dana Pensiun Pemberi Kerja (DPPK) Syariah"),
	DPLKS ("031304", "031304", ESectorType.SYARIAH, "Dana Pensiun Lembaga Keuangan (DPLK) Syariah"),
	PMVS ("031404", "031404", ESectorType.SYARIAH, "Perusahaan Modal Ventura Syariah"),
	GDS ("030402", "030402", ESectorType.SYARIAH, "Pegadaian Syariah"),
	PPIK ("031405", "031405", ESectorType.KONVENSIONAL, "Perusahaan Pembiayaan Infrasruktur Gabungan"),
	PPIU ("031405", "031405", ESectorType.UUS, "Perusahaan Pembiayaan Infrasruktur Unit Usaha Syariah"),
	PPIS ("031406", "031406", ESectorType.SYARIAH, "Perusahaan Pembiayaan Infrasruktur Syariah"),
	LKK ("030491", "030491", ESectorType.KONVENSIONAL, "Lembaga Keuangan Khusus"),
	PNMK ("030491", "030491-PNMK", ESectorType.KONVENSIONAL, "PNM Konvensional"),
	PNMU ("030491", "030491-PNMU", ESectorType.UUS, "PNM Unit Usaha Syariah"),
	LPEIG ("030491", "030491-LPEIG", ESectorType.KONVENSIONAL, "LPEI Gabungan"),
	LPEIU ("030491", "030491-LPEIU", ESectorType.UUS, "LPEI Unit Usaha Syariah"),
	LFINK ("030416", "030416", ESectorType.KONVENSIONAL, "Fintech Konvensional"),
	LFINS ("030417", "030417", ESectorType.SYARIAH, "Fintech Syariah"),
	PNJK ("030403", "030403", ESectorType.KONVENSIONAL, "Perusahaan Penjaminan Konvensional"),
	PNJU ("030403", "030403", ESectorType.UUS, "Perusahaan Penjaminan Unit Usaha Syariah"),
	PNJS ("030404", "030404", ESectorType.SYARIAH, "Perusahaan Penjaminan Syariah"),
	PA("031207", "031207", ESectorType.KONVENSIONAL, "Pialang Asuransi"),
	BPKS ("030499", "030499", ESectorType.KONVENSIONAL, "BPJS Kesehatan"),
	BPTK ("030497", "030497", ESectorType.KONVENSIONAL, "BPJS Ketenagakerjaan"),
	;

	@Getter
	private String code;
	@Getter
	private String codeAlias;
	@Getter
	private ESectorType type;
	@Getter
	private String name;
	
	public static List<String> listCode() {
		List<String> res = new ArrayList<>();
		for (ESector eEnum : ESector.values()) {
			res.add(eEnum.code);
		}
		return res;
	}
	
	public static ESector getEnumByCode(String code) {
		ESector res = null;
		try {
			for (ESector eEnum : ESector.values()) {
				if (eEnum.code.equals(code)) {
					res = eEnum;
					break;
				}
			}
		} catch (Exception e) {
		}
		return res;
	}

	public static ESector getEnumByCodeAlias(String alias) {
		ESector res = null;
		try {
			for (ESector eEnum : ESector.values()) {
				if (eEnum.codeAlias.equals(alias)) {
					res = eEnum;
					break;
				}
			}
		} catch (Exception e) {
		}
		return res;
	}
	
	public static boolean isFintech(String sectorCode) {
		return sectorCode.equals(LFINK.getCode()) || sectorCode.equals(LFINS.getCode()) || sectorCode.equals(PA.getCode());
	}
	
	public static boolean isPnj(String sectorCode) {
		return sectorCode.equals(PNJK.getCode()) || sectorCode.equals(PNJU.getCode()) || sectorCode.equals(PNJS.getCode());
	}
}
