package id.go.ojk.pnjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3027PosLbPnjk3200B implements IObject<KeyValueString> {
	R_3200B10100 ("3200B10100", "Detail"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3027PosLbPnjk3200B eEnum : ER3027PosLbPnjk3200B.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3027PosLbPnjk3200B.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3027PosLbPnjk3200B.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static FieldValidation genFieldValidation36() {
		return UtilFieldValidation.genEqualsFormula("3+6+9+12+15+18+21+24+27+30+33");
	}
	
	public static FieldValidation genFieldValidation37() {
		return UtilFieldValidation.genEqualsFormula("4+7+10+13+16+19+22+25+28+31+34");
	}
	
	public static FieldValidation genFieldValidation38() {
		return UtilFieldValidation.genEqualsFormula("5+8+11+14+17+20+23+26+29+32+35");
	}
}
