package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1122JenisValuta implements IObject<KeyValueString> {
	R_1 ("MU:IDR", "Indonesian Rupiah"),
	R_2 ("MU:valas", "Mata Uang Asing"),
	R_3 ("MU:AED", "UAE Dirham"),
	R_4 ("MU:AFN", "Afghanistan Afghani"),
	R_5 ("MU:ALL", "Albanian Lek"),
	R_6 ("MU:AMD", "Armenia Dram"),
	R_7 ("MU:ANG", "Netherlands Antillian Guilder"),
	R_8 ("MU:AOA", "Angolan Kwanza"),
	R_9 ("MU:ARS", "Argentine Peso"),
	R_10 ("MU:AUD", "Australian Dollar"),
	R_11 ("MU:AWG", "Aruban Guilder"),
	R_12 ("MU:AZN", "Azerbaijanian Manat"),
	R_13 ("MU:BAM", "Bosnia-Herze Conv Marka"),
	R_14 ("MU:BBD", "Barbados Dollar"),
	R_15 ("MU:BDT", "Bangladesh Taka"),
	R_16 ("MU:BGN", "Bulgarian Lev"),
	R_17 ("MU:BHD", "Bahraini Dinar"),
	R_18 ("MU:BIF", "Burundi Franc"),
	R_19 ("MU:BMD", "Bermudian Dollar"),
	R_20 ("MU:BND", "Brunei Dollar"),
	R_21 ("MU:BOB", "Bolivian Boliviano "),
	R_22 ("MU:BOV", "Mvdol"),
	R_23 ("MU:BRL", "Brazilian Real"),
	R_24 ("MU:BSD", "Bahamian Dollar"),
	R_25 ("MU:BTN", "Bhutan Ngultrum"),
	R_26 ("MU:BWP", "Botswana Pula"),
	R_27 ("MU:BYR", "Belarussian Ruble"),
	R_28 ("MU:BZD", "Belize Dollar"),
	R_29 ("MU:CAD", "Canadian Dollar"),
	R_30 ("MU:CDF", "Congolese Franch"),
	R_31 ("MU:CHE", "WIR Euro"),
	R_32 ("MU:CHF", "Swiss Franc"),
	R_33 ("MU:CHW", "WIR Franc"),
	R_34 ("MU:CLF", "Unidades de fomento"),
	R_35 ("MU:CLP", "Chilean Peso"),
	R_36 ("MU:CNY", "China Renminbi"),
	R_37 ("MU:COP", "Colombian Peso"),
	R_38 ("MU:COU", "Unidad de Valor Real"),
	R_39 ("MU:CRC", "Costa Rican Colon"),
	R_40 ("MU:CUC", "Peso Convertible"),
	R_41 ("MU:CUP", "Cuban Peso"),
	R_42 ("MU:CVE", "Cape Verde Escudo"),
	R_43 ("MU:CZK", "Czech Koruna"),
	R_44 ("MU:DJF", "Djibouti Franc"),
	R_45 ("MU:DKK", "Danish Krone"),
	R_46 ("MU:DOP", "Dominican Republic Peso"),
	R_47 ("MU:DZD", "Algerian Dinar"),
	R_48 ("MU:EEK", "Estonian Kroon"),
	R_49 ("MU:EGP", "Egyptian Pound"),
	R_50 ("MU:ERN", "Eritreian Nakfa"),
	R_51 ("MU:ETB", "Ethiopian Birr"),
	R_52 ("MU:EUR", "Euro"),
	R_53 ("MU:FJD", "Fiji Dollar"),
	R_54 ("MU:FKP", "Falkland Islands Pound"),
	R_55 ("MU:GBP", "Pound Sterling"),
	R_56 ("MU:GEL", "Georgian Lari"),
	R_57 ("MU:GHS", "Ghana Cedi"),
	R_58 ("MU:GIP", "Gibraltar Pound"),
	R_59 ("MU:GMD", "Gambian Dalasi"),
	R_60 ("MU:GNF", "Guinea Franc"),
	R_61 ("MU:GTQ", "Guatemala Quetzal"),
	R_62 ("MU:GWP", "Guinea-Bissau Peso"),
	R_63 ("MU:GYD", "Guyana Dollar"),
	R_64 ("MU:HKD", "Hong Kong Dollar"),
	R_65 ("MU:HNL", "Honduras Lempira"),
	R_66 ("MU:HRK", "Croatian Kuna"),
	R_67 ("MU:HTG", "Gourde"),
	R_68 ("MU:HUF", "Hungarian Forint"),
	R_69 ("MU:ILS", "Israeli Shekel"),
	R_70 ("MU:INR", "Indian Rupee"),
	R_71 ("MU:IQD", "Iraqi Dinar"),
	R_72 ("MU:IRR", "Iranian Rial"),
	R_73 ("MU:ISK", "Icelandic Krona"),
	R_74 ("MU:JMD", "Jamaican Dollar"),
	R_75 ("MU:JOD", "Jordanian Dinar"),
	R_76 ("MU:JPY", "Japanese Yen"),
	R_77 ("MU:KES", "Kenyan Shilling"),
	R_78 ("MU:KGS", "Som"),
	R_79 ("MU:KHR", "Cambodia Riel"),
	R_80 ("MU:KMF", "Comoros Franc"),
	R_81 ("MU:KPW", "North Korean Won"),
	R_82 ("MU:KRW", "Won"),
	R_83 ("MU:KWD", "Kuwaiti Dinar"),
	R_84 ("MU:KYD", "Cayman Islands Dollar"),
	R_85 ("MU:KZT", "Kazakhstan Tenge"),
	R_86 ("MU:LAK", "Laos New Kip"),
	R_87 ("MU:LBP", "Lebanese Pound"),
	R_88 ("MU:LKR", "Sri Langka Rupee "),
	R_89 ("MU:LRD", "Liberian Dollar"),
	R_90 ("MU:LSL", "Loti Lesatho"),
	R_91 ("MU:LTL", "Lithuanian Litas"),
	R_92 ("MU:LVL", "Latvian Lats"),
	R_93 ("MU:LYD", "Libyan Dinar"),
	R_94 ("MU:MAD", "Morrocoan Dirham"),
	R_95 ("MU:MDL", "Moldovan Leu"),
	R_96 ("MU:MGA", "Madagascar Franc"),
	R_97 ("MU:MKD", "Macedonian Denar"),
	R_98 ("MU:MMK", "Myanmar Kyat"),
	R_99 ("MU:MNT", "Tugrik"),
	R_100 ("MU:MOP", "Macau Pataca"),
	R_101 ("MU:MRO", "Ouguiya"),
	R_102 ("MU:MUR", "Mauritius Rupee"),
	R_103 ("MU:MVR", "Maldives Rufiyaa"),
	R_104 ("MU:MWK", "Malawi Kwacha"),
	R_105 ("MU:MXN", "Mexican Peso"),
	R_106 ("MU:MXV", "Mexican Unidad de Inversion (UDI)"),
	R_107 ("MU:MYR", "Malaysian Ringgit"),
	R_108 ("MU:MZN", "Metical"),
	R_109 ("MU:NAD", "Namibia Dollar"),
	R_110 ("MU:NGN", "Nigeria Naira"),
	R_111 ("MU:NIO", "Cordoba Oro"),
	R_112 ("MU:NOK", "Norwegian Krone"),
	R_113 ("MU:NPR", "Nepalese Rupee"),
	R_114 ("MU:NZD", "New Zealand Dollar"),
	R_115 ("MU:OMR", "Omani Rial"),
	R_116 ("MU:PAB", "Panamanian Balboa"),
	R_117 ("MU:PEN", "Nuevo Sol"),
	R_118 ("MU:PGK", "Papua New Guinea Kina"),
	R_119 ("MU:PHP", "Philippines Peso"),
	R_120 ("MU:PKR", "Pakistan Rupee"),
	R_121 ("MU:PLN", "Polish Zloty/New Zloty"),
	R_122 ("MU:PYG", "Paraguayan Guarani"),
	R_123 ("MU:QAR", "Qatari Rial"),
	R_124 ("MU:RON", "New Leu"),
	R_125 ("MU:RSD", "Serbian Dinar"),
	R_126 ("MU:RUB", "Russian Rouble"),
	R_127 ("MU:RWF", "Rwanda Franc"),
	R_128 ("MU:SAR", "Saudi Riyal"),
	R_129 ("MU:SBD", "Solomon Islands Dollar"),
	R_130 ("MU:SCR", "Seychelles Rupee"),
	R_131 ("MU:SDP", "Sudanese Pound"),
	R_132 ("MU:SEK", "Swedish Krone"),
	R_133 ("MU:SGD", "Singapore Dollar"),
	R_134 ("MU:SHP", "Saint Helena Paund"),
	R_135 ("MU:SLL", "Leone"),
	R_136 ("MU:SOS", "Somali Schilling"),
	R_137 ("MU:SRD", "Surinam Dollar"),
	R_138 ("MU:STD", "Sao Tome Dobra"),
	R_139 ("MU:SVC", "El Salvador Colon"),
	R_140 ("MU:SYP", "Syrian Pound"),
	R_141 ("MU:SZL", "Swaziland Lilangeni"),
	R_142 ("MU:THB", "Thai Bath"),
	R_143 ("MU:TJS", "Tajikistan Somoni"),
	R_144 ("MU:TMM", "Turkmenistan Manat"),
	R_145 ("MU:TND", "Tunisian Dinar"),
	R_146 ("MU:TOP", "Tonga Pa'anga"),
	R_147 ("MU:TRY", "Turkish Lira"),
	R_148 ("MU:TTD", "Trinidad and Tobago Dollar"),
	R_149 ("MU:TWD", "Taiwan Dollar"),
	R_150 ("MU:TZS", "Tanzanian Shilling "),
	R_151 ("MU:UAH", "Ukrainian Hryvna"),
	R_152 ("MU:UGX", "Ugandan Shilling"),
	R_153 ("MU:USD", "US Dollar"),
	R_154 ("MU:UYI", "Paraguay Peso en Unidades Indexadas"),
	R_155 ("MU:UYU", "Uruguay Peso"),
	R_156 ("MU:UZS", "Uzbekistan Sum"),
	R_157 ("MU:VEF", "Bolivar Fuerte"),
	R_158 ("MU:VND", "Vietnam Dong"),
	R_159 ("MU:VUV", "Vanuatu Vatu"),
	R_160 ("MU:WST", "Samoan (West) Tala"),
	R_161 ("MU:XAF", "CEA Franc BEAC"),
	R_162 ("MU:XCD", "East Caribbean Dollar"),
	R_163 ("MU:XOF", "CFA Franc "),
	R_164 ("MU:XPF", "CFP Franch"),
	R_165 ("MU:YER", "Yemeni Rial"),
	R_166 ("MU:ZAR", "South Afrian Rand"),
	R_167 ("MU:ZMK", "Zambian Kwacha"),
	R_168 ("MU:ZML", "Zimbabwe Dollar"),
	R_169 ("MU:XAU", "Emas"),
	R_170 ("MU:ADP", "Andorran Peseta"),
	R_171 ("MU:FRF", "French Franc"),
	R_172 ("MU:ESP", "Spanish Peseta"),
	R_173 ("MU:ATS", "Austrian Schilling"),
	R_174 ("MU:CYP", "Cypriot Pound"),
	R_175 ("MU:ECS", "Ecuadorean Sucre"),
	R_176 ("MU:FIM", "Finnis Markka"),
	R_177 ("MU:DEM", "German Mark"),
	R_178 ("MU:IEP", "Irish Punt"),
	R_179 ("MU:ITL", "Italian Lira"),
	R_180 ("MU:LUF", "Luxembourg Franc"),
	R_181 ("MU:MLF", "Malian Franc"),
	R_182 ("MU:MTL", "Maltese Lira"),
	R_183 ("MU:NLG", "Netherlands Guilder/Gulden/Florin"),
	R_184 ("MU:PTE", "Portuguese Escudo"),
	R_185 ("MU:ROL", "Romanian Leu"),
	R_186 ("MU:SKK", "Slovakian Koruna"),
	R_187 ("MU:SIT", "Slovenia Tolar"),
	R_188 ("MU:SRG", "Surinam Guilder"),
	R_189 ("MU:VEB", "Venezuelan Bolivar"),
	R_190 ("MU:YUM", "Yugoslav Dinar"),
	R_191 ("MU:GRD", "Greek Drachma"),
	R_192 ("MU:XDR", "Special Drawing Right"),
	R_193 ("MU:XAG", "Perak"),
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
		for (ER1122JenisValuta eEnum : ER1122JenisValuta.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1122JenisValuta.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1122JenisValuta.class.getSimpleName().substring(2, 6));
	}
	
	public static String getPipedKey() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER1122JenisValuta[] eEnums = ER1122JenisValuta.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER1122JenisValuta eEnum = ER1122JenisValuta.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.value);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
