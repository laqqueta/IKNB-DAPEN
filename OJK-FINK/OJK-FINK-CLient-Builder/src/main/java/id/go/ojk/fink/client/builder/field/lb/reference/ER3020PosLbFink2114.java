package id.go.ojk.fink.client.builder.field.lb.reference;

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
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3020PosLbFink2114 implements IObject<KeyValueString> {
	R_211401010000("211401010000", "Detail"),
	R_211401000000("211401000000", "Total"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3020PosLbFink2114 eEnum : ER3020PosLbFink2114.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3020PosLbFink2114.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3020PosLbFink2114.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4|5", getObjects());
	}

	public static String genFieldSaveForm() {
		return UtilMetadata.genFieldSave("5", getObjects());
	}
	
	public static ConditionalRequired genConditional() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 1 }));
	}
	
	public static FieldValidation genFieldValidation5() {
		return UtilFieldValidation.genEqualsPosFormula("3+4", 0, R_211401010000.key);
	}
	
	public static SegmentValidation genRowValidation2() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5", R_211401000000.key, R_211401010000.key,
				UtilMetadata.genMessage(R_211401000000.value, "Penjumlahan rincian"));
	}
}
