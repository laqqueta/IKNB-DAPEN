package id.go.ojk.conf.client.field.reference;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1256JenisValuta implements IObject<KeyValueString> {
	R_1 ("MU:IDR", "Indonesian Rupiah"),
	R_2 ("MU:AED", "UAE Dirham"),
	R_3 ("MU:AFN", "Afghanistan Afghani"),
	R_4 ("MU:ALL", "Albanian Lek"),
	R_5 ("MU:AMD", "Armenia Dram"),
	R_6 ("MU:ANG", "Netherlands Antillian Guilder"),
	R_7 ("MU:AOA", "Angolan Kwanza"),
	R_8 ("MU:ARS", "Argentine Peso"),
	R_9 ("MU:AUD", "Australian Dollar"),
	R_10 ("MU:AWG", "Aruban Guilder"),
	R_11 ("MU:AZN", "Azerbaijanian Manat"),
	R_12 ("MU:BAM", "Bosnia-Herze Conv Marka"),
	R_13 ("MU:BBD", "Barbados Dollar"),
	R_14 ("MU:BDT", "Bangladesh Taka"),
	R_15 ("MU:BGN", "Bulgarian Lev"),
	R_16 ("MU:BHD", "Bahraini Dinar"),
	R_17 ("MU:BIF", "Burundi Franc"),
	R_18 ("MU:BMD", "Bermudian Dollar"),
	R_19 ("MU:BND", "Brunei Dollar"),
	R_20 ("MU:BOB", "Bolivian Boliviano"),
	R_21 ("MU:BOV", "Mvdol"),
	R_22 ("MU:BRL", "Brazilian Real"),
	R_23 ("MU:BSD", "Bahamian Dollar"),
	R_24 ("MU:BTN", "Bhutan Ngultrum"),
	R_25 ("MU:BWP", "Botswana Pula"),
	R_26 ("MU:BYR", "Belarussian Ruble"),
	R_27 ("MU:BZD", "Belize Dollar"),
	R_28 ("MU:CAD", "Canadian Dollar"),
	R_29 ("MU:CDF", "Congolese Franch"),
	R_30 ("MU:CHE", "WIR Euro"),
	R_31 ("MU:CHF", "Swiss Franc"),
	R_32 ("MU:CHW", "WIR Franc"),
	R_33 ("MU:CLF", "Unidades de fomento"),
	R_34 ("MU:CLP", "Chilean Peso"),
	R_35 ("MU:CNY", "China Renminbi"),
	R_36 ("MU:COP", "Colombian Peso"),
	R_37 ("MU:COU", "Unidad de Valor Real"),
	R_38 ("MU:CRC", "Costa Rican Colon"),
	R_39 ("MU:CUC", "Peso Convertible"),
	R_40 ("MU:CUP", "Cuban Peso"),
	R_41 ("MU:CVE", "Cape Verde Escudo"),
	R_42 ("MU:CZK", "Czech Koruna"),
	R_43 ("MU:DJF", "Djibouti Franc"),
	R_44 ("MU:DKK", "Danish Krone"),
	R_45 ("MU:DOP", "Dominican Republic Peso"),
	R_46 ("MU:DZD", "Algerian Dinar"),
	R_47 ("MU:EEK", "Estonian Kroon"),
	R_48 ("MU:EGP", "Egyptian Pound"),
	R_49 ("MU:ERN", "Eritreian Nakfa"),
	R_50 ("MU:ETB", "Ethiopian Birr"),
	R_51 ("MU:EUR", "Euro"),
	R_52 ("MU:FJD", "Fiji Dollar"),
	R_53 ("MU:FKP", "Falkland Islands Pound"),
	R_54 ("MU:GBP", "Pound Sterling"),
	R_55 ("MU:GEL", "Georgian Lari"),
	R_56 ("MU:GHS", "Ghana Cedi"),
	R_57 ("MU:GIP", "Gibraltar Pound"),
	R_58 ("MU:GMD", "Gambian Dalasi"),
	R_59 ("MU:GNF", "Guinea Franc"),
	R_60 ("MU:GTQ", "Guatemala Quetzal"),
	R_61 ("MU:GWP", "Guinea-Bissau Peso"),
	R_62 ("MU:GYD", "Guyana Dollar"),
	R_63 ("MU:HKD", "Hong Kong Dollar"),
	R_64 ("MU:HNL", "Honduras Lempira"),
	R_65 ("MU:HRK", "Croatian Kuna"),
	R_66 ("MU:HTG", "Gourde"),
	R_67 ("MU:HUF", "Hungarian Forint"),
	R_68 ("MU:ILS", "Israeli Shekel"),
	R_69 ("MU:INR", "Indian Rupee"),
	R_70 ("MU:IQD", "Iraqi Dinar"),
	R_71 ("MU:IRR", "Iranian Rial"),
	R_72 ("MU:ISK", "Icelandic Krona"),
	R_73 ("MU:JMD", "Jamaican Dollar"),
	R_74 ("MU:JOD", "Jordanian Dinar"),
	R_75 ("MU:JPY", "Japanese Yen"),
	R_76 ("MU:KES", "Kenyan Shilling"),
	R_77 ("MU:KGS", "Som"),
	R_78 ("MU:KHR", "Cambodia Riel"),
	R_79 ("MU:KMF", "Comoros Franc"),
	R_80 ("MU:KPW", "North Korean Won"),
	R_81 ("MU:KRW", "Won"),
	R_82 ("MU:KWD", "Kuwaiti Dinar"),
	R_83 ("MU:KYD", "Cayman Islands Dollar"),
	R_84 ("MU:KZT", "Kazakhstan Tenge"),
	R_85 ("MU:LAK", "Laos New Kip"),
	R_86 ("MU:LBP", "Lebanese Pound"),
	R_87 ("MU:LKR", "Sri Langka Rupee"),
	R_88 ("MU:LRD", "Liberian Dollar"),
	R_89 ("MU:LSL", "Loti Lesatho"),
	R_90 ("MU:LTL", "Lithuanian Litas"),
	R_91 ("MU:LVL", "Latvian Lats"),
	R_92 ("MU:LYD", "Libyan Dinar"),
	R_93 ("MU:MAD", "Morrocoan Dirham"),
	R_94 ("MU:MDL", "Moldovan Leu"),
	R_95 ("MU:MGA", "Madagascar Franc"),
	R_96 ("MU:MKD", "Macedonian Denar"),
	R_97 ("MU:MMK", "Myanmar Kyat"),
	R_98 ("MU:MNT", "Tugrik"),
	R_99 ("MU:MOP", "Macau Pataca"),
	R_100 ("MU:MRO", "Ouguiya"),
	R_101 ("MU:MUR", "Mauritius Rupee"),
	R_102 ("MU:MVR", "Maldives Rufiyaa"),
	R_103 ("MU:MWK", "Malawi Kwacha"),
	R_104 ("MU:MXN", "Mexican Peso"),
	R_105 ("MU:MXV", "Mexican Unidad de Inversion (UDI)"),
	R_106 ("MU:MYR", "Malaysian Ringgit"),
	R_107 ("MU:MZN", "Metical"),
	R_108 ("MU:NAD", "Namibia Dollar"),
	R_109 ("MU:NGN", "Nigeria Naira"),
	R_110 ("MU:NIO", "Cordoba Oro"),
	R_111 ("MU:NOK", "Norwegian Krone"),
	R_112 ("MU:NPR", "Nepalese Rupee"),
	R_113 ("MU:NZD", "New Zealand Dollar"),
	R_114 ("MU:OMR", "Omani Rial"),
	R_115 ("MU:PAB", "Panamanian Balboa"),
	R_116 ("MU:PEN", "Nuevo Sol"),
	R_117 ("MU:PGK", "Papua New Guinea Kina"),
	R_118 ("MU:PHP", "Philippines Peso"),
	R_119 ("MU:PKR", "Pakistan Rupee"),
	R_120 ("MU:PLN", "Polish Zloty/New Zloty"),
	R_121 ("MU:PYG", "Paraguayan Guarani"),
	R_122 ("MU:QAR", "Qatari Rial"),
	R_123 ("MU:RON", "New Leu"),
	R_124 ("MU:RSD", "Serbian Dinar"),
	R_125 ("MU:RUB", "Russian Rouble"),
	R_126 ("MU:RWF", "Rwanda Franc"),
	R_127 ("MU:SAR", "Saudi Riyal"),
	R_128 ("MU:SBD", "Solomon Islands Dollar"),
	R_129 ("MU:SCR", "Seychelles Rupee"),
	R_130 ("MU:SDP", "Sudanese Pound"),
	R_131 ("MU:SEK", "Swedish Krone"),
	R_132 ("MU:SGD", "Singapore Dollar"),
	R_133 ("MU:SHP", "Saint Helena Paund"),
	R_134 ("MU:SLL", "Leone"),
	R_135 ("MU:SOS", "Somali Schilling"),
	R_136 ("MU:SRD", "Surinam Dollar"),
	R_137 ("MU:STD", "Sao Tome Dobra"),
	R_138 ("MU:SVC", "El Salvador Colon"),
	R_139 ("MU:SYP", "Syrian Pound"),
	R_140 ("MU:SZL", "Swaziland Lilangeni"),
	R_141 ("MU:THB", "Thai Bath"),
	R_142 ("MU:TJS", "Tajikistan Somoni"),
	R_143 ("MU:TMM", "Turkmenistan Manat"),
	R_144 ("MU:TND", "Tunisian Dinar"),
	R_145 ("MU:TOP", "Tonga Pa'anga"),
	R_146 ("MU:TRY", "Turkish Lira"),
	R_147 ("MU:TTD", "Trinidad and Tobago Dollar"),
	R_148 ("MU:TWD", "Taiwan Dollar"),
	R_149 ("MU:TZS", "Tanzanian Shilling"),
	R_150 ("MU:UAH", "Ukrainian Hryvna"),
	R_151 ("MU:UGX", "Ugandan Shilling"),
	R_152 ("MU:USD", "US Dollar"),
	R_153 ("MU:UYI", "Paraguay Peso en Unidades Indexadas"),
	R_154 ("MU:UYU", "Uruguay Peso"),
	R_155 ("MU:UZS", "Uzbekistan Sum"),
	R_156 ("MU:VEF", "Bolivar Fuerte"),
	R_157 ("MU:VND", "Vietnam Dong"),
	R_158 ("MU:VUV", "Vanuatu Vatu"),
	R_159 ("MU:WST", "Samoan (West) Tala"),
	R_160 ("MU:XAF", "CEA Franc BEAC"),
	R_161 ("MU:XCD", "East Caribbean Dollar"),
	R_162 ("MU:XOF", "CFA Franc"),
	R_163 ("MU:XPF", "CFP Franch"),
	R_164 ("MU:YER", "Yemeni Rial"),
	R_165 ("MU:ZAR", "South Afrian Rand"),
	R_166 ("MU:ZMK", "Zambian Kwacha"),
	R_167 ("MU:ZML", "Zimbabwe Dollar"),
	R_168 ("MU:XAU", "Emas"),
	R_169 ("MU:ADP", "Andorran Peseta"),
	R_170 ("MU:FRF", "French Franc"),
	R_171 ("MU:ESP", "Spanish Peseta"),
	R_172 ("MU:ATS", "Austrian Schilling"),
	R_173 ("MU:CYP", "Cypriot Pound"),
	R_174 ("MU:ECS", "Ecuadorean Sucre"),
	R_175 ("MU:FIM", "Finnis Markka"),
	R_176 ("MU:DEM", "German Mark"),
	R_177 ("MU:IEP", "Irish Punt"),
	R_178 ("MU:ITL", "Italian Lira"),
	R_179 ("MU:LUF", "Luxembourg Franc"),
	R_180 ("MU:MLF", "Malian Franc"),
	R_181 ("MU:MTL", "Maltese Lira"),
	R_182 ("MU:NLG", "Netherlands Guilder/Gulden/Florin"),
	R_183 ("MU:PTE", "Portuguese Escudo"),
	R_184 ("MU:ROL", "Romanian Leu"),
	R_185 ("MU:SKK", "Slovakian Koruna"),
	R_186 ("MU:SIT", "Slovenia Tolar"),
	R_187 ("MU:SRG", "Surinam Guilder"),
	R_188 ("MU:VEB", "Venezuelan Bolivar"),
	R_189 ("MU:YUM", "Yugoslav Dinar"),
	R_190 ("MU:GRD", "Greek Drachma"),
	R_191 ("MU:XDR", "Special Drawing Right"),
	R_192 ("MU:XAG", "Perak"),
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
		for (ER1256JenisValuta eEnum : ER1256JenisValuta.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1256JenisValuta.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1256JenisValuta.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1256JenisValuta[] eEnums = ER1256JenisValuta.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1256JenisValuta eEnum = ER1256JenisValuta.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
