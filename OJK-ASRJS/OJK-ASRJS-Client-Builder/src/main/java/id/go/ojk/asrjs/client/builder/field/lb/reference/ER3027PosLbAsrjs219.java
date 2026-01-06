package id.go.ojk.asrjs.client.builder.field.lb.reference;

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
public enum ER3027PosLbAsrjs219 implements IObject<KeyValueString> {
	R_2190000099 ("2190000099", "Kematian Jangka Warsa"),
	R_2190000100 ("2190000100", "Endowment dan/atau Kombinasinya"),
	R_2190000101 ("2190000101", "Seumur Hidup"),
	R_2190000102 ("2190000102", "Anuitas"),
	R_2190000103 ("2190000103", "Kematian Ekawarsa"),
	R_2190000104 ("2190000104", "Kesehatan"),
	R_2190000105 ("2190000105", "Kecelakaan Diri"),
	R_2190000106 ("2190000106", "Lainnya"),
	R_2190000113 ("2190000113", "Total max ((PK* - PK), 0)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3027PosLbAsrjs219 eEnum : ER3027PosLbAsrjs219.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}
	
	public static ConditionalRequired genConditional4() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 8 }));
	}

	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsPosMaxValue("3-2", "0", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 8 }));
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_2190000113.key, UtilMetadata.genPlusRow(getObjects(), 0, 7), 
				"Total max|Perhitungan max");
	}
}
