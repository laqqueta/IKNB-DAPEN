package id.go.ojk.ppk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppk.client.builder.field.EFormRencanaBisnisUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2508PosRbPpu060101 implements IObject<KeyValueString> {
	R_06010101000000 ("06010101000000", "Ekuitas yang Disesuaikan"),
	R_06010102000000 ("06010102000000", "Aset yang Disesuaikan"),
	R_06010103000000 ("06010103000000", "Rasio Permodalan (%)"),;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2508PosRbPpu060101 eEnum : ER2508PosRbPpu060101.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2508PosRbPpu060101.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2508PosRbPpu060101.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3|4|5", R_06010103000000.key);
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3|4|5", R_06010101000000.key + "|" + R_06010102000000.key);
	}

	public static SegmentValidation genValidationFormRasioPermodalan() {
		String comparatorFormCode = EFormRencanaBisnisUus.RB_110200.getCode();
		return UtilSegmentValidation.genEqualsForm2("2|3|4|5", R_06010103000000.key, comparatorFormCode, 
				ER2522PosRbPpu110200.R_11020700000000.getKey(), "Total Rasio Permodalan|Total Rasio Permodalan form " + comparatorFormCode + " #kolom#");
	}
}
