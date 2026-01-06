package id.go.ojk.lpei.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.conditional.NumericComparisonConditional;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.field.MinMaxFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5013PosLbLpeig2100 implements IObject<KeyValueString> {
	R_2100010000 ("2100010000", "Detail"),
	;

	@Getter
	private String key;
	private String value;

	@Override
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5013PosLbLpeig2100 eEnum : ER5013PosLbLpeig2100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5013PosLbLpeig2100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5013PosLbLpeig2100.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return ER5013PosLbLpeig2100.R_2100010000.getKey();
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 45), getObjects());
	}

	// Jika kolom 37 (mandatory) diisi <= 0 maka kolom 38 harus diisi
	// Jika kolom 37 (mandatory) diisi > 0 maka kolom 38 harus kosong
	public static ConditionalRequired genConditionalValidation37() {
		StringBuilder sb = new StringBuilder("trueCondition=M");
		sb.append("&falseCondition=N");
		sb.append("&comparatorField=36");
		sb.append("&comparatorValue=0");
		sb.append("&comparation=lte");
		return new NumericComparisonConditional(sb.toString());
	}

	// Jika kolom 38 harus diisi, isinya harus > 0
	public static FieldValidation genFieldValidation37() {
		StringBuilder sb = new StringBuilder("minEqual=true");
		sb.append("&minValue=1");
		return new MinMaxFieldValidation(sb.toString());
	}
}