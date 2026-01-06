package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1029MataUang implements IObject<KeyValueString> {
	R_AFN ("AFN", "Afghanistan Afghani (AFN)"),
	R_ALL ("ALL", "Albanian Lek (ALL)"),
	R_DZD ("DZD", "Algerian Dinar (DZD)"),
	R_USD ("USD", "US Dollar (USD)"),
	R_AOA ("AOA", "Angokan Kwanza (AOA)"),
	R_XCD ("XCD", "East Caribbean Dollar (XCD)"),
	R_ARS ("ARS", "Argentine Peso (ARS)"),
	R_AMD ("AMD", "Armenia Dram (AMD)"),
	R_AWG ("AWG", "Aruban Guider (AWG)"),
	R_AUD ("AUD", "Australian Dollar (AUD)"),
	R_AZM ("AZM", "Azerbaijan Mant (AZM)"),
	R_BSD ("BSD", "Bahamas Dollar (BSD)"),
	R_BHD ("BHD", "Bahraini Dinar (BHD)"),
	R_BDT ("BDT", "Bangladesh Taka (BDT)"),
	R_BBD ("BBD", "Bardados Dollar (BBD)"),
	R_BYR ("BYR", "Belarus Rouble (BYR)"),
	R_BZD ("BZD", "Belize Dollar (BZD)"),
	R_XOF ("XOF", "CFA Franc BCEAO (XOF)"),
	R_BMD ("BMD", "Bermudian Dollar (BMD)"),
	R_INR ("INR", "Indian Rupee (INR)"),
	R_BTN ("BTN", "Bhutan Ngultrum (BTN)"),
	R_BOB ("BOB", "Bolivian Boliviano (BOB)"),
	R_BAM ("BAM", "Bosnia-Herze Conv Marka (BAM)"),
	R_BWP ("BWP", "Botswana Pula (BWP)"),
	R_BRL ("BRL", "Brazilian Real (BRL)"),
	R_BND ("BND", "Brunei Dollar (BND)"),
	R_BEN ("BEN", "Bulgarian Lev (BEN)"),
	R_BIF ("BIF", "Burundi Franc (BIF)"),
	R_KHR ("KHR", "Cambodia Riel (KHR)"),
	R_XAF ("XAF", "Franc de la Communaute finaniere Africaine (XAF)"),
	R_CLP ("CLP", "Chilean Peso (CLP)"),
	R_CLF ("CLF", "Chilean Fomento (CLF)"),
	R_CNY ("CNY", "China Renminbi (CNY)"),
	R_COP ("COP", "Colombian Peso (COP)"),
	R_KMF ("KMF", "Comoros Franc (KMF)"),
	R_CDF ("CDF", "Democratic Rep. Congo Franc (CDF)"),
	R_NZD ("NZD", "New Zealand Dollar (NZD)"),
	R_CRC ("CRC", "Costa Rican Colon (CRC)"),
	R_HRK ("HRK", "Croatian Kuna (HRK)"),
	R_CUP ("CUP", "Cuban Peso (CUP)"),
	R_ANG ("ANG", "Netherlands Guilder/Gulden/Florin (ANG)"),
	R_CZK ("CZK", "Czech Koruna (CZK)"),
	R_DKK ("DKK", "Danish Krone (DKK)"),
	R_DJF ("DJF", "Djibouti Franc (DJF)"),
	R_DOP ("DOP", "Dominican Republic Peso (DOP)"),
	R_EGP ("EGP", "Egyptian Pound (EGP)"),
	R_SVC ("SVC", "El Savador Colon  (SVC)"),
	R_ERN ("ERN", "Eritreian Nakfa (ERN)"),
	R_EUR ("EUR", "European Community (EUR)"),
	R_ETB ("ETB", "Ethiopian Birr (ETB)"),
	R_FKP ("FKP", "Falkland Islandss Pound (FKP)"),
	R_FJD ("FJD", "Fiji Dollar (FJD)"),
	R_XPF ("XPF", "Franc Pacific Is.Fran (XPF)"),
	R_GMD ("GMD", "Gambian Dalasi (GMD)"),
	R_GEL ("GEL", "Georgian Lari (GEL)"),
	R_GHC ("GHC", "Ghana Cedi (GHC)"),
	R_GIP ("GIP", "Gibraltar Pound (GIP )"),
	R_GTQ ("GTQ", "Guatemala Quetzal (GTQ)"),
	R_GBP ("GBP", "Pound Sterling (United Kingdom Pound) (GBP)"),
	R_GNF ("GNF", "Guinea Franc (GNF)"),
	R_GYD ("GYD", "Guyana Dollar (GYD)"),
	R_HTG ("HTG", "Haiti Gourde (HTG)"),
	R_HNL ("HNL", "Honduras Lempira (HNL)"),
	R_HKD ("HKD", "Hong Kong Dollar (HKD)"),
	R_HUF ("HUF", "Hungarian Forint (HUF)"),
	R_ISK ("ISK", "Icelandic Krona (ISK)"),
	R_IDR ("IDR", "Indonesian Rupiah  (IDR)"),
	R_XDR ("XDR", "Special Drawing Right (XDR)"),
	R_IRR ("IRR", "Iranian Rial (IRR)"),
	R_IQD ("IQD", "Iraqi Dinar (IQD)"),
	R_ILS ("ILS", "Israeli Shekel (ILS)"),
	R_JMD ("JMD", "Jamaican Dollar (JMD)"),
	R_JPY ("JPY", "Japanese Yen (JPY)"),
	R_JOD ("JOD", "Jordanian Dinar (JOD)"),
	R_KZT ("KZT", "Kazakhstan Tenge (KZT)"),
	R_KES ("KES", "Kenyan Shilling (KES)"),
	R_KPW ("KPW", "North Korean Won (KPW)"),
	R_KRW ("KRW", "Korean Won (KRW)"),
	R_KWD ("KWD", "Kuwaiti Dinar (KWD)"),
	R_KGS ("KGS", "Kyrgyzstan Som (KGS)"),
	R_LAK ("LAK", "Laos New Kip (LAK)"),
	R_LBP ("LBP", "Lebanese Pound (LBP)"),
	R_LSL ("LSL", "Loti Lesatho (LSL)"),
	R_LRD ("LRD", "Liberian Dollar (LRD)"),
	R_LYD ("LYD", "Libyan Dinar (LYD)"),
	R_CHF ("CHF", "Liechtenstein Franc (CHF)"),
	R_MOP ("MOP", "Macau Pataca (MOP)"),
	R_MKD ("MKD", "Macedonian Denar (MKD)"),
	R_MWK ("MWK", "Malawi Kwacha (MWK)"),
	R_MYR ("MYR", "Malaysian Ringgit (MYR)"),
	R_MVR ("MVR", "Maldives Rufiyaa (MVR)"),
	R_MRO ("MRO", "Mauritania Ouguiya (MRO)"),
	R_MUR ("MUR", "Maurutius Rupee (MUR)"),
	R_MXN ("MXN", "Mexican Peso (MXN)"),
	R_MDL ("MDL", "Moldova Lei (MDL)"),
	R_MNT ("MNT", "Mongolia Tugrik (MNT)"),
	R_MAD ("MAD", "Moroccan Dirham (MAD)"),
	R_MZM ("MZM", "Mozambique Metical (MZM)"),
	R_MMK ("MMK", "Myanmar Kyat (MMK)"),
	R_NAD ("NAD", "Namibia Dollar (NAD)"),
	R_ZAR ("ZAR", "Rand (South African Rand) (ZAR)"),
	R_NPR ("NPR", "Nepalese Rupee (NPR)"),
	R_NGN ("NGN", "Nigeria Naira (NGN)"),
	R_NOK ("NOK", "Norwegian Krone (NOK)"),
	R_OMR ("OMR", "Omani Rial (OMR)"),
	R_PKR ("PKR", "Pakistan Rupee (PKR)"),
	R_PAB ("PAB", "Panamanian Balboa (PAB)"),
	R_PGK ("PGK", "Papua New Guinea Kina (PGK)"),
	R_PYG ("PYG", "Paraguayan Guarani (PYG)"),
	R_PEN ("PEN", "Peruvian Nuevo (PEN)"),
	R_PHP ("PHP", "Philippines Peso (PHP)"),
	R_PLN ("PLN", "Polis Zloty/New Zloty (PLN)"),
	R_QAR ("QAR", "Qatari Rial (QAR)"),
	R_ROL ("ROL", "Romanian Leu (ROL)"),
	R_RUB ("RUB", "Russian Rouble (RUB)"),
	R_RWF ("RWF", "Rwanda Franc (RWF)"),
	R_SHP ("SHP", "St. Helena Pound (SHP)"),
	R_WST ("WST", "Samoan (West) Tala (WST)"),
	R_STD ("STD", "Sao Tome Dobra (STD)"),
	R_SAR ("SAR", "Saudi Riyal (SAR)"),
	R_SCR ("SCR", "Seychelles Rupee (SCR)"),
	R_SLL ("SLL", "Sierra Leone Leone (SLL)"),
	R_SGD ("SGD", "Singapore Dollar (SGD)"),
	R_SBD ("SBD", "Solomon Islands Dollar (SBD)"),
	R_SOS ("SOS", "Somali Schilling (SOS)"),
	R_LKR ("LKR", "Sri Langka Rupee (LKR)"),
	R_SDP ("SDP", "Sudanese Pound (SDP)"),
	R_SRD ("SRD", "Surinam Dollar  (SRD)"),
	R_SZL ("SZL", "Swaziland Lilangeni (SZL)"),
	R_SEK ("SEK", "Swedish Krone (SEK)"),
	R_SYP ("SYP", "Syrian Pound (SYP)"),
	R_TWD ("TWD", "Taiwan Dollar (TWD)"),
	R_TJS ("TJS", "Tajikistan Somoni (TJS)"),
	R_TZS ("TZS", "Tanzanian Shilling (TZS)"),
	R_THB ("THB", "Thai Bath (THB)"),
	R_TOP ("TOP", "Tonga Pa'anga (TOP)"),
	R_TTD ("TTD", "Trinidad & Tobago Dollar (TTD)"),
	R_TND ("TND", "Tunisian Dinar (TND)"),
	R_TRY ("TRY", "Turkish Lira (TRY)"),
	R_TMM ("TMM", "Turkmenistan Manat (TMM)"),
	R_UGX ("UGX", "Ugandan Shilling (UGX)"),
	R_UAH ("UAH", "Ukrainian Hryvna (UAH)"),
	R_AED ("AED", "UAE Dirham (AED)"),
	R_UYU ("UYU", "Uruguay Peso (UYU)"),
	R_UZS ("UZS", "Uzbekistan Sum (UZS)"),
	R_VUV ("VUV", "Vanuatu Vatu (VUV)"),
	R_VND ("VND", "Vietnam Dong (VND)"),
	R_YER ("YER", "Yemeni Rial (YER)"),
	R_ZMK ("ZMK", "Zambian Kwacha (ZMK)"),
	R_ZWD ("ZWD", "Zimbabwe Dollar (ZWD)"),
	R_XAU ("XAU", "Gold (XAU)"),
	R_XAG ("XAG", "Afghanistan Afghani (AFN)"),
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
		for (ER1029MataUang eEnum : ER1029MataUang.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1029MataUang.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1029MataUang.class.getSimpleName().substring(2, 6));
	}
}
