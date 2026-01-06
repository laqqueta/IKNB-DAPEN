package id.go.ojk.dplks.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2003PosRbDplks0301 implements IObject<KeyValueString> {
//	R_0301000000 ("0301000000", "1. Indikator Keuangan"),
	R_0301010000 ("0301010000", "1. Aset Netto"),
	R_0301020000 ("0301020000", "2. Aset Investasi"),
	R_0301030000 ("0301030000", "3. Pendapatan Investasi"),
	R_0301040000 ("0301040000", "4. Beban Investasi"),
	R_0301050000 ("0301050000", "5. Beban Operasional"),
//	R_0302000000 ("0302000000", "2. Rasio Keuangan"),
	R_0302010000 ("0302010000", "1. Rasio Pendapatan investasi  (ROI)"),
	R_0302020000 ("0302020000", "2. Rasio Pendapatan investasi terhadap Aset (ROA)"),
	R_0302030000 ("0302030000", "3. Rasio beban operasional (BOPO)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2003PosRbDplks0301 eEnum : ER2003PosRbDplks0301.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2003PosRbDplks0301.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2003PosRbDplks0301.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static FieldValidation genValidationRatio() {
		return UtilFieldValidation.genEqualsRatio("3|2");
	}

	public static SegmentValidation genValidationNumericNegatif() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3",
				UtilMetadata.genPipeRow(getObjects(), 0, 4));
	}

	public static SegmentValidation genValidationNumericDotNegatif() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3",
				UtilMetadata.genPipeRow(getObjects(), 5, 7));
	}
}
