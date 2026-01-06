package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1163SandiBank implements IObject<KeyValueString> {
	R_002 ("002", "PT BANK RAKYAT INDONESIA (PERSERO), Tbk"),
	R_008 ("008", "PT BANK MANDIRI (PERSERO), Tbk"),
	R_009 ("009", "PT BANK NEGARA INDONESIA (PERSERO), Tbk"),
	R_011 ("011", "PT BANK DANAMON INDONESIA, Tbk"),
	R_013 ("013", "PT BANK PERMATA, Tbk"),
	R_014 ("014", "PT BANK CENTRAL ASIA, Tbk"),
	R_016 ("016", "PT BANK MAYBANK INDONESIA, Tbk"),
	R_019 ("019", "PT PAN INDONESIA BANK, Tbk"),
	R_022 ("022", "PT BANK CIMB NIAGA, Tbk"),
	R_023 ("023", "PT BANK UOB INDONESIA"),
	R_026 ("026", "PT.LIPPOBANK TBK"),
	R_028 ("028", "PT BANK OCBC NISP, Tbk"),
	R_031 ("031", "CITIBANK NA"),
	R_032 ("032", "JP. MORGAN CHASE BANK, N.A."),
	R_033 ("033", "BANK OF AMERICA, N.A"),
	R_036 ("036", "PT BANK CHINA CONSTRUCTION BANK INDONESIA, Tbk"),
	R_037 ("037", "PT BANK ARTHA GRAHA INTERNASIONAL, Tbk"),
	R_040 ("040", "THE BANGKOK BANK COMP. LTD"),
	R_042 ("042", "MUFG Bank, Ltd"),
	R_046 ("046", "PT BANK DBS INDONESIA"),
	R_047 ("047", "PT BANK RESONA PERDANIA"),
	R_048 ("048", "PT BANK MIZUHO INDONESIA"),
	R_050 ("050", "STANDARD CHARTERED BANK"),
	R_054 ("054", "PT BANK CAPITAL INDONESIA, Tbk"),
	R_057 ("057", "PT BANK BNP PARIBAS INDONESIA"),
	R_058 ("058", "PT BANK UOB BUANA"),
	R_060 ("060", "PT.RABO BANK DUTA INDONESIA"),
	R_061 ("061", "PT BANK ANZ INDONESIA"),
	R_067 ("067", "DEUTSCHE BANK AG."),
	R_068 ("068", "PT BANK WOORI INDONESIA"),
	R_069 ("069", "BANK OF CHINA LIMITED"),
	R_076 ("076", "PT BANK BUMI ARTA, Tbk"),
	R_087 ("087", "PT BANK HSBC INDONESIA"),
	R_089 ("089", "PT BANK RABOBANK INTERNATIONAL INDONESIA"),
	R_095 ("095", "PT BANK JTRUST INDONESIA, TBK"),
	R_097 ("097", "PT BANK MAYAPADA INTERNATIONAL, Tbk"),
	R_110 ("110", "PT BPD JAWA BARAT DAN BANTEN, Tbk"),
	R_111 ("111", "PT BPD DKI"),
	R_112 ("112", "PT BPD DAERAH ISTIMEWA YOGYAKARTA"),
	R_113 ("113", "PT BPD JAWA TENGAH"),
	R_114 ("114", "PT.  BPD JAWA TIMUR"),
	R_115 ("115", "PT BPD JAMBI"),
	R_116 ("116", "PT BANK ACEH SYARIAH"),
	R_117 ("117", "PT BPD SUMATERA UTARA"),
	R_118 ("118", "PT BPD SUMATERA BARAT"),
	R_119 ("119", "PT BPD RIAU DAN KEPULAUAN RIAU"),
	R_120 ("120", "PT BPD SUMATERA SELATAN DAN BANGKA BELITUNG"),
	R_121 ("121", "PT BPD LAMPUNG"),
	R_122 ("122", "PT BPD KALIMANTAN SELATAN"),
	R_123 ("123", "BPD KALIMANTAN BARAT"),
	R_124 ("124", "PT BPD KALIMANTAN TIMUR DAN KALIMANTAN UTARA"),
	R_125 ("125", "PT BPD KALTENG"),
	R_126 ("126", "PT BPD SULAWESI SELATAN DAN SULAWESI BARAT"),
	R_127 ("127", "PT BPD SULAWESI UTARA DAN GORONTALO"),
	R_128 ("128", "PT BANK NTB SYARIAH"),
	R_129 ("129", "PT BPD BALI"),
	R_130 ("130", "PT BPD NUSA TENGGARA TIMUR"),
	R_131 ("131", "PT BPD MALUKU DAN MALUKU UTARA"),
	R_132 ("132", "PT BPD PAPUA"),
	R_133 ("133", "PT BPD BENGKULU"),
	R_134 ("134", "PT.  BPD SULAWESI TENGAH"),
	R_135 ("135", "PT BPD SULAWESI TENGGARA"),
	R_137 ("137", "PT BANK PEMBANGUNAN DAERAH BANTEN, TBK"),
	R_140 ("140", "BANK CITRA MAKMUR ASIA (eks.YAMA BANK)"),
	R_145 ("145", "PT BANK NUSANTARA PARAHYANGAN,Tbk"),
	R_146 ("146", "PT BANK OF INDIA INDONESIA, Tbk"),
	R_147 ("147", "PT BANK MUAMALAT INDONESIA"),
	R_151 ("151", "PT BANK MESTIKA DHARMA"),
	R_152 ("152", "PT BANK SHINHAN INDONESIA"),
	R_153 ("153", "PT BANK SINARMAS, Tbk"),
	R_157 ("157", "PT BANK MASPION INDONESIA"),
	R_161 ("161", "PT BANK GANESHA"),
	R_164 ("164", "PT BANK ICBC INDONESIA"),
	R_167 ("167", "PT BANK QNB INDONESIA, Tbk"),
	R_200 ("200", "PT BANK TABUNGAN NEGARA (PERSERO), Tbk"),
	R_212 ("212", "PT BANK WOORI SAUDARA INDONESIA 1906, Tbk"),
	R_213 ("213", "PT BANK BTPN, Tbk"),
	R_332 ("332", "PT.BANK JAKARTA"),
	R_405 ("405", "PT. Bank Victoria Syariah"),
	R_422 ("422", "PT. Bank BRI Syariah"),
	R_425 ("425", "PT. Bank Jabar Banten Syariah"),
	R_426 ("426", "PT BANK MEGA, Tbk"),
	R_427 ("427", "PT. Bank BNI Syariah"),
	R_441 ("441", "PT BANK BUKOPIN, Tbk"),
	R_451 ("451", "PT. Bank Syariah Mandiri"),
	R_459 ("459", "PT BANK BISNIS INTERNASIONAL"),
	R_466 ("466", "PT BANK OKE INDONESIA"),
	R_472 ("472", "PT BANK JASA JAKARTA"),
	R_484 ("484", "PT BANK KEB HANA INDONESIA"),
	R_485 ("485", "PT BANK MNC INTERNASIONAL, Tbk"),
	R_490 ("490", "PT BANK YUDHA BHAKTI"),
	R_491 ("491", "PT BANK MITRANIAGA"),
	R_494 ("494", "PT BRI AGRONIAGA, Tbk"),
	R_498 ("498", "PT BANK SBI INDONESIA"),
	R_501 ("501", "PT BANK ROYAL INDONESIA"),
	R_503 ("503", "PT BANK NATIONALNOBU"),
	R_506 ("506", "PT BANK MEGA SYARIAH"),
	R_513 ("513", "PT BANK INA PERDANA"),
	R_517 ("517", "PT Bank Panin Dubai Syariah Tbk"),
	R_520 ("520", "PT PRIMA MASTER BANK"),
	R_521 ("521", "PT. Bank Syariah Bukopin"),
	R_523 ("523", "PT BANK SAHABAT SAMPOERNA"),
	R_526 ("526", "PT BANK DINAR INDONESIA"),
	R_531 ("531", "PT BANK AMAR INDONESIA"),
	R_535 ("535", "PT BANK KESEJAHTERAAN EKONOMI"),
	R_536 ("536", "PT. Bank BCA Syariah"),
	R_542 ("542", "PT BANK ARTOS INDONESIA"),
	R_547 ("547", "PT BANK TABUNGAN PENSIUNAN NASIONAL SYARIAH"),
	R_548 ("548", "PT BANK MULTIARTA SENTOSA"),
	R_553 ("553", "PT BANK MAYORA"),
	R_555 ("555", "PT BANK INDEX SELINDO"),
	R_562 ("562", "PT BANK FAMA INTERNASIONAL"),
	R_564 ("564", "PT BANK MANDIRI TASPEN"),
	R_566 ("566", "PT BANK VICTORIA INTERNATIONAL, Tbk"),
	R_567 ("567", "PT BANK HARDA INTERNASIONAL"),
	R_945 ("945", "PT. BANK AGRIS"),
	R_947 ("947", "PT. Bank Maybank Syariah Indonesia"),
	R_949 ("949", "PT BANK CTBC INDONESIA"),
	R_950 ("950", "PT BANK COMMONWEALTH"),
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
		for (ER1163SandiBank eEnum : ER1163SandiBank.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1163SandiBank.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1163SandiBank.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1163SandiBank[] eEnums = ER1163SandiBank.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1163SandiBank eEnum = ER1163SandiBank.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
