package id.go.ojk.asrjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3016PosLbAsrjk507 implements IObject<KeyValueString> {
	R_2500010000 ("2500010000", "Kematian Jangka Warsa", "10.00", "10.00", "10.00"),
	R_2500020000 ("2500020000", "Endowment dan/atau Kombinasinya", "10.00", "10.00", "10.00"),
	R_2500030000 ("2500030000", "Seumur Hidup", "10.00", "10.00", "10.00"),
	R_2500040000 ("2500040000", "Anuitas", "10.00", "10.00", "10.00"),
	R_2500050000 ("2500050000", "Kematian Ekawarsa", "10.00", "10.00", "10.00"),
	R_2500060000 ("2500060000", "Kesehatan", "25.00", "20.00", "25.00"),
	R_2500070000 ("2500070000", "Kecelakaan Diri", "25.00", "20.00", "25.00"),
	R_2500080000 ("2500080000", "Lainnya", "10.00", "10.00", "10.00"),
	R_2500990000 ("2500990000", "Jumlah", "0", "0", "0"),
	R_2501000000 ("2501000000", "I. Total Cadangan Premi", "0", "0", "0"),
	R_2502000000 ("2502000000", "II. Total CAPYBMP", "0", "0", "0"),
	R_2503000000 ("2503000000", "III. Total Cadangan Klaim", "0", "0", "0"),
	R_2504000000 ("2504000000", "IV. Total Cadangan Atas Risiko Bencana", "0", "0", "0"),
	R_7304000000 ("7304000000", "Total Deviasi untuk Risiko Asuransi", "0", "0", "0"),
	;

	private String key;
	private String value;
	private String factor1;
	private String factor2;
	private String factor3;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3016PosLbAsrjk507 eEnum : ER3016PosLbAsrjk507.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3016PosLbAsrjk507.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3016PosLbAsrjk507.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5|6|8|9|10|12|13|14|16", getObjects());
	}
	
	public static ConditionalRequired genConditionalMustEmpty() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), 9, 13));
	}
	
	public static ConditionalRequired genConditionalMustEmpty7_11_15() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), 8, 13));
	}
	
	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genEqualsPosFormula("3-2", UtilMetadata.genPipeRow(getObjects(), 0, 7));
	}
	
	public static FieldValidation genFieldValidation7() {
		return UtilFieldValidation.genPosLookup("1", UtilMetadata.genPipeRow(getObjects(), 0, 7), getLookupFactor1());
	}
	
	public static FieldValidation genFieldValidation8() {
		return UtilFieldValidation.genPosPercentage("5-6|7", UtilMetadata.genPipeRow(getObjects(), 0, 7));
	}
	
	public static FieldValidation genFieldValidation11() {
		return UtilFieldValidation.genPosLookup("1", UtilMetadata.genPipeRow(getObjects(), 0, 7), getLookupFactor2());
	}
	
	public static FieldValidation genFieldValidation12() {
		return UtilFieldValidation.genPosPercentage("9-10|11", UtilMetadata.genPipeRow(getObjects(), 0, 7));
	}
	
	public static FieldValidation genFieldValidation15() {
		return UtilFieldValidation.genPosLookup("1", UtilMetadata.genPipeRow(getObjects(), 0, 7), getLookupFactor3());
	}
	
	public static FieldValidation genFieldValidation16() {
		return UtilFieldValidation.genPosPercentage("13-14|15", UtilMetadata.genPipeRow(getObjects(), 0, 7));
	}
	
	public static SegmentValidation genValidationJumlah() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|8|9|10|12|13|14|16", R_2500990000.key, UtilMetadata.genPlusRow(getObjects(), 0, 7), 
				"Total|Penjumlahan detail");
	}
	
	public static SegmentValidation genValidationTotalCadanganPremi() {
		return UtilSegmentValidation.genEqualRowColumn("2", R_2501000000.key, "4", R_2500990000.key, "Total Cadangan Premi|Jumlah deviasi");
	}
	
	public static SegmentValidation genValidationTotalCAPYBMP() {
		return UtilSegmentValidation.genEqualRowColumn("2", R_2502000000.key, "8", R_2500990000.key, "Total CAPYBMP|Jumlah deviasi CAPYBMP");
	}
	
	public static SegmentValidation genValidationTotalCadanganKlaim() {
		return UtilSegmentValidation.genEqualRowColumn("2", R_2503000000.key, "12", R_2500990000.key, "Total Cadangan Klaim|Jumlah deviasi CK");
	}
	
	public static SegmentValidation genValidationTotalCadanganAtasRisikoBencana() {
		return UtilSegmentValidation.genEqualRowColumn("2", R_2504000000.key, "16", R_2500990000.key, "Total Cadangan Atas Risiko Bencana|Jumlah deviasi cadangan atas risiko bencana");
	}
	
	public static SegmentValidation genValidationTotalDeviasiUntukRisikoAsuransi() {
		return UtilSegmentValidation.genEqualsFormula("2", R_7304000000.key, UtilMetadata.genPlusRow(getObjects(), 9, 12), 
				"Total deviasi untuk risiko asuransi|Penjumlahan deviasi untuk risiko asuransi");
	}
	
	private static String getLookupFactor1() {
		StringBuilder res = new StringBuilder();
		ER3016PosLbAsrjk507[] eEnums = ER3016PosLbAsrjk507.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3016PosLbAsrjk507 eEnum = ER3016PosLbAsrjk507.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.factor1);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
	
	private static String getLookupFactor2() {
		StringBuilder res = new StringBuilder();
		ER3016PosLbAsrjk507[] eEnums = ER3016PosLbAsrjk507.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3016PosLbAsrjk507 eEnum = ER3016PosLbAsrjk507.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.factor2);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
	
	private static String getLookupFactor3() {
		StringBuilder res = new StringBuilder();
		ER3016PosLbAsrjk507[] eEnums = ER3016PosLbAsrjk507.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3016PosLbAsrjk507 eEnum = ER3016PosLbAsrjk507.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.factor3);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
