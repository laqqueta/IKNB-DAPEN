package id.go.ojk.fins.client.builder.field.lb.reference;

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
public enum ER3018PosLbFins2116 implements IObject<KeyValueString> {
	R_211601010000("211601010000", "Detail"),
	R_211601000000("211601000000", "Total"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3018PosLbFins2116 eEnum : ER3018PosLbFins2116.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3018PosLbFins2116.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3018PosLbFins2116.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4|5|6", getObjects());
	}
	
	public static ConditionalRequired genConditional() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 1 }));
	}
	
	public static FieldValidation genFieldValidation6() {
		return UtilFieldValidation.genEqualsFormula("3+4-5", 0);
	}
	
	public static SegmentValidation genRowValidation2() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5", R_211601000000.key, R_211601010000.key,
				UtilMetadata.genMessage(R_211601000000.value, "Penjumlahan rincian"));
	}
}
