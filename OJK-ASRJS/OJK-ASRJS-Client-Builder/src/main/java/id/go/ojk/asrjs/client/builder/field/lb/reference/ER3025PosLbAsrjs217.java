package id.go.ojk.asrjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3025PosLbAsrjs217 implements IObject<KeyValueString> {
	R_2172000001 ("2172000001", "PKrf"),
	R_2172000002 ("2172000002", "PKo"),
	R_2172000003 ("2172000003", "Max((PKrf-PKo),0)"),
	R_2172000004 ("2172000004", "PUrf"),
	R_2172000005 ("2172000005", "PUo"),
	R_2172000006 ("2172000006", "Max((PUrf-PUo),0)"),
	R_2172000007 ("2172000007", "fPHI"),
	R_2172000008 ("2172000008", "PHI"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3025PosLbAsrjs217 eEnum : ER3025PosLbAsrjs217.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 1, 2 }));
	}
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3, 4, 5 }));
	}
	
	public static SegmentValidation genValidationNumericNegative() {
		return UtilSegmentValidation.genRegexNumericNegative("2|3", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 6, 7 }));
	}
	
	public static SegmentValidation genValidationNumericDotNegative() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2|3", UtilMetadata.genPipeRow(getObjects(), new int[] { 6, 7 }));
	}
	
	public static SegmentValidation genValidationMaxLength6() {
		return UtilSegmentValidation.genMaxLength("2|3", UtilMetadata.genPipeRow(getObjects(), new int[] { 6, 7 }), 6);
	}
	
	public static SegmentValidation genValidationMax1() {
		return UtilSegmentValidation.genMaxValue("3", R_2172000003.key, UtilMetadata.genMinusRow(getObjects(), 0, 1), 
				"0", "Perhitungan nilai maksimum");
	}
	
	public static SegmentValidation genValidationMax2() {
		return UtilSegmentValidation.genMaxValue("2", R_2172000006.key, UtilMetadata.genMinusRow(getObjects(), 3, 4), 
				"0", "Perhitungan nilai maksimum");
	}
	
	public static SegmentValidation genValidationfPHI() {
		return UtilSegmentValidation.genFixedValue("2|3", R_2172000007.key, "15.00");
	}
	
	public static SegmentValidation genValidationPHIA() {
		return UtilSegmentValidation.genMultiply("2", R_2172000008.key, UtilMetadata.genPipeRow(getObjects(), new int[] { 5, 6 }), 
				".01", 2, "perhitungan PHI");
	}
	
	public static SegmentValidation genValidationPHIB() {
		return UtilSegmentValidation.genMultiply("3", R_2172000008.key, UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 6 }), 
				".01", 2, "perhitungan PHI");
	}
}
