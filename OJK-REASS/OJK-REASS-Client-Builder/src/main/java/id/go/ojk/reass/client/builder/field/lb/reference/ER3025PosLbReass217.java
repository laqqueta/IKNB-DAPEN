package id.go.ojk.reass.client.builder.field.lb.reference;

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
public enum ER3025PosLbReass217 implements IObject<KeyValueString> {
	R_2172000001 ("2172000001", "PKrf"),
	R_2172000002 ("2172000002", "PKo"),
	R_2172000003 ("2172000003", "Max((PKrf-PKo),0)"),
	R_2172000004 ("2172000004", "PUrf"),
	R_2172000005 ("2172000005", "PUo"),
	R_2172000006 ("2172000006", "Max((PUrf-PUo),0)"),
	R_2172000007 ("2172000007", "fPTB"),
	R_2172000008 ("2172000008", "PTPI"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3025PosLbReass217 eEnum : ER3025PosLbReass217.values()) {
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
		return UtilFieldConditional.genExistPos("M", "N",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 1, 2 }));
	}
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3, 4, 5 }));
	}
	
	public static SegmentValidation genValidationMax1() {
		return UtilSegmentValidation.genMaxValue("3", R_2172000003.key, UtilMetadata.genMinusRow(getObjects(), 0, 1), 
				"0", "Perhitungan nilai maksimum");
	}
	
	public static SegmentValidation genValidationMax2() {
		return UtilSegmentValidation.genMaxValue("2", R_2172000006.key, UtilMetadata.genMinusRow(getObjects(), 3, 4), 
				"0", "Perhitungan nilai maksimum");
	}
	
	public static SegmentValidation genValidationPTPIA() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2172000008.key, R_2172000006.key + "*" + R_2172000007.key, 
				"Nilai PTPI|Nilai kode baris 2172000006 x nilai kode baris 2172000007", 0);
	}
	
	public static SegmentValidation genValidationPTPIB() {
		return UtilSegmentValidation.genEqualsFormula("3", R_2172000008.key, R_2172000003.key + "*" + R_2172000007.key, 
				"Nilai PTPI|Nilai kode baris 2172000003 x nilai kode baris 2172000007", 0);
	}
}
