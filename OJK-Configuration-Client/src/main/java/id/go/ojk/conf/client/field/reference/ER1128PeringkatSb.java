package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1128PeringkatSb implements IObject<KeyValueString> {
	R_1 ("EN:eMIS01", "MIS - Aaa"),
	R_2 ("EN:eMIS02", "MIS - Aa1"),
	R_3 ("EN:eMIS03", "MIS - Aa2"),
	R_4 ("EN:eMIS04", "MIS - Aa3"),
	R_5 ("EN:eMIS05", "MIS - A1"),
	R_6 ("EN:eMIS06", "MIS - A2"),
	R_7 ("EN:eMIS07", "MIS - A3"),
	R_8 ("EN:eMIS08", "MIS - Baa1"),
	R_9 ("EN:eMIS09", "MIS - Baa2"),
	R_10 ("EN:eMIS10", "MIS - Baa3"),
	R_11 ("EN:eMIS11", "MIS - Ba1"),
	R_12 ("EN:eMIS12", "MIS - Ba2"),
	R_13 ("EN:eMIS13", "MIS - Ba3"),
	R_14 ("EN:eMIS14", "MIS - B1"),
	R_15 ("EN:eMIS15", "MIS - B2"),
	R_16 ("EN:eMIS16", "MIS - B3"),
	R_17 ("EN:eMIS17", "MIS - Caa1"),
	R_18 ("EN:eMIS18", "MIS - Caa2"),
	R_19 ("EN:eMIS19", "MIS - Caa3"),
	R_20 ("EN:eMIS20", "MIS - Ca"),
	R_21 ("EN:eMIS21", "MIS - C"),
	R_22 ("EN:eMIS61", "MIS - short term - P-1"),
	R_23 ("EN:eMIS62", "MIS - short term - P-2"),
	R_24 ("EN:eMIS63", "MIS - short term - P-3"),
	R_25 ("EN:eMIS64", "MIS - short term - NP"),
	R_26 ("EN:eSNP01", "SNP - AAA"),
	R_27 ("EN:eSNP02", "SNP - AA+"),
	R_28 ("EN:eSNP03", "SNP - AA"),
	R_29 ("EN:eSNP04", "SNP - AA-"),
	R_30 ("EN:eSNP05", "SNP - A+"),
	R_31 ("EN:eSNP06", "SNP - A"),
	R_32 ("EN:eSNP07", "SNP - A-"),
	R_33 ("EN:eSNP08", "SNP - BBB+"),
	R_34 ("EN:eSNP09", "SNP - BBB"),
	R_35 ("EN:eSNP10", "SNP - BBB-"),
	R_36 ("EN:eSNP11", "SNP - BB+"),
	R_37 ("EN:eSNP12", "SNP - BB"),
	R_38 ("EN:eSNP13", "SNP - BB-"),
	R_39 ("EN:eSNP14", "SNP - B+"),
	R_40 ("EN:eSNP15", "SNP - B"),
	R_41 ("EN:eSNP16", "SNP - B-"),
	R_42 ("EN:eSNP17", "SNP - CCC+"),
	R_43 ("EN:eSNP18", "SNP - CCC"),
	R_44 ("EN:eSNP19", "SNP - CCC-"),
	R_45 ("EN:eSNP20", "SNP - CC"),
	R_46 ("EN:eSNP21", "SNP - C"),
	R_47 ("EN:eSNP22", "SNP - D"),
	R_48 ("EN:eSNP62", "SNP - short term - A-1"),
	R_49 ("EN:eSNP63", "SNP - short term - A-2"),
	R_50 ("EN:eSNP64", "SNP - short term - A-3"),
	R_51 ("EN:eSNP65", "SNP - short term - B-1"),
	R_52 ("EN:eSNP66", "SNP - short term - B-2"),
	R_53 ("EN:eSNP67", "SNP - short term - B-3"),
	R_54 ("EN:eSNP68", "SNP - short term - C"),
	R_55 ("EN:eSNP69", "SNP - short term - D"),
	R_56 ("EN:eFIN01", "FIN - AAA"),
	R_57 ("EN:eFIN02", "FIN - AA+"),
	R_58 ("EN:eFIN03", "FIN - AA"),
	R_59 ("EN:eFIN04", "FIN - AA-"),
	R_60 ("EN:eFIN05", "FIN - A+"),
	R_61 ("EN:eFIN06", "FIN - A"),
	R_62 ("EN:eFIN07", "FIN - A-"),
	R_63 ("EN:eFIN08", "FIN - BBB+"),
	R_64 ("EN:eFIN09", "FIN - BBB"),
	R_65 ("EN:eFIN10", "FIN - BBB-"),
	R_66 ("EN:eFIN11", "FIN - BB+"),
	R_67 ("EN:eFIN12", "FIN - BB"),
	R_68 ("EN:eFIN13", "FIN - BB-"),
	R_69 ("EN:eFIN14", "FIN - B+"),
	R_70 ("EN:eFIN15", "FIN - B"),
	R_71 ("EN:eFIN16", "FIN - B-"),
	R_72 ("EN:eFIN18", "FIN - CCC"),
	R_73 ("EN:eFIN20", "FIN - CC"),
	R_74 ("EN:eFIN22", "FIN - RD, D"),
	R_75 ("EN:eFIN61", "FIN - short term - F1+"),
	R_76 ("EN:eFIN62", "FIN - short term - F1"),
	R_77 ("EN:eFIN63", "FIN - short term - F2"),
	R_78 ("EN:eFIN64", "FIN - short term - F3"),
	R_79 ("EN:eFIN65", "FIN - short term - B"),
	R_80 ("EN:eFIN66", "FIN - short term - C"),
	R_81 ("EN:eFIN67", "FIN - short term - D"),
	R_82 ("EN:ePEF01", "PEF - idAAA"),
	R_83 ("EN:ePEF02", "PEF - idAA+"),
	R_84 ("EN:ePEF03", "PEF - idAA"),
	R_85 ("EN:ePEF04", "PEF - idAA-"),
	R_86 ("EN:ePEF05", "PEF - idA+"),
	R_87 ("EN:ePEF06", "PEF - idA"),
	R_88 ("EN:ePEF07", "PEF - idA-"),
	R_89 ("EN:ePEF08", "PEF - idBBB+"),
	R_90 ("EN:ePEF09", "PEF - idBBB"),
	R_91 ("EN:ePEF10", "PEF - idBBB-"),
	R_92 ("EN:ePEF11", "PEF - idBB+"),
	R_93 ("EN:ePEF12", "PEF - idBB"),
	R_94 ("EN:ePEF13", "PEF - idBB-"),
	R_95 ("EN:ePEF14", "PEF - idB+"),
	R_96 ("EN:ePEF15", "PEF - idB"),
	R_97 ("EN:ePEF16", "PEF - idB-"),
	R_98 ("EN:ePEF18", "PEF - idCCC"),
	R_99 ("EN:ePEF22", "PEF - idSD, idD"),
	R_100 ("EN:ePEF63", "PEF - short term - idA1"),
	R_101 ("EN:ePEF64", "PEF - short term - idA2"),
	R_102 ("EN:ePEF65", "PEF - short term - idA3"),
	R_103 ("EN:ePEF66", "PEF - short term - idA4"),
	R_104 ("EN:ePEF67", "PEF - short term - idB"),
	R_105 ("EN:ePEF68", "PEF - short term - idC"),
	R_106 ("EN:ePEF69", "PEF - short term - idD"),
	R_107 ("EN:eFID01", "FID - AAA(idn)"),
	R_108 ("EN:eFID02", "FID - AA+(idn)"),
	R_109 ("EN:eFID03", "FID - AA(idn)"),
	R_110 ("EN:eFID04", "FID - AA-(idn)"),
	R_111 ("EN:eFID05", "FID - A+(idn)"),
	R_112 ("EN:eFID06", "FID - A(idn)"),
	R_113 ("EN:eFID07", "FID - A-(idn)"),
	R_114 ("EN:eFID08", "FID - BBB+(idn)"),
	R_115 ("EN:eFID09", "FID - BBB(idn)"),
	R_116 ("EN:eFID10", "FID - BBB-(idn)"),
	R_117 ("EN:eFID11", "FID - BB+(idn)"),
	R_118 ("EN:eFID12", "FID - BB(idn)"),
	R_119 ("EN:eFID13", "FID - BB-(idn)"),
	R_120 ("EN:eFID14", "FID - B+(idn)"),
	R_121 ("EN:eFID15", "FID - B(idn)"),
	R_122 ("EN:eFID16", "FID - B-(idn)"),
	R_123 ("EN:eFID18", "FID - CCC(idn)"),
	R_124 ("EN:eFID20", "FID - CC(idn)"),
	R_125 ("EN:eFID21", "FID - C(idn)"),
	R_126 ("EN:eFID22", "FID - RD(idn), D(idn)"),
	R_127 ("EN:eFID61", "FID - short term - F1+(idn)"),
	R_128 ("EN:eFID62", "FID - short term - F1(idn)"),
	R_129 ("EN:eFID63", "FID - short term - F2(idn)"),
	R_130 ("EN:eFID64", "FID - short term - F3(idn)"),
	R_131 ("EN:eFID65", "FID - short term - B(idn)"),
	R_132 ("EN:eFID66", "FID - short term - C(idn)"),
	R_133 ("EN:eFID67", "FID - short term - D(idn)"),
	R_134 ("EN:eKRI01", "KRI - irAAA"),
	R_135 ("EN:eKRI02", "KRI - irAA+"),
	R_136 ("EN:eKRI03", "KRI - irAA"),
	R_137 ("EN:eKRI04", "KRI - irAA-"),
	R_138 ("EN:eKRI05", "KRI - irA+"),
	R_139 ("EN:eKRI06", "KRI - irA"),
	R_140 ("EN:eKRI07", "KRI - irA-"),
	R_141 ("EN:eKRI08", "KRI - irBBB+"),
	R_142 ("EN:eKRI09", "KRI - irBBB"),
	R_143 ("EN:eKRI10", "KRI - irBBB-"),
	R_144 ("EN:eKRI11", "KRI - irBB+"),
	R_145 ("EN:eKRI12", "KRI - irBB"),
	R_146 ("EN:eKRI13", "KRI - irBB-"),
	R_147 ("EN:eKRI14", "KRI - irB+"),
	R_148 ("EN:eKRI15", "KRI - irB"),
	R_149 ("EN:eKRI16", "KRI - irB-"),
	R_150 ("EN:eKRI18", "KRI - irCCC"),
	R_151 ("EN:eKRI22", "KRI - irD"),
	R_152 ("EN:eKRI63", "KRI - short term - irA-1"),
	R_153 ("EN:eKRI64", "KRI - short term - irA-2"),
	R_154 ("EN:eKRI65", "KRI - short term - irA-3"),
	R_155 ("EN:eKRI66", "KRI - short term - irB"),
	R_156 ("EN:eKRI67", "KRI - short term - irC"),
	R_157 ("EN:eKRI68", "KRI - short term - irD"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1128PeringkatSb eEnum : ER1128PeringkatSb.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return "PeringkatSuratBerharga";
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1128PeringkatSb.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1128PeringkatSb[] eEnums = ER1128PeringkatSb.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1128PeringkatSb eEnum = ER1128PeringkatSb.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
