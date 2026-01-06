package id.go.ojk.lpei.client.builder.field.lb.uus.reference;

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
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER7013PosLbLpeiu2100 implements IObject<KeyValueString> {
	R_2100010000 ("2100010000", "Detail"),
	R_2100100000 ("2100100000", "Total"),
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
		for (ER7013PosLbLpeiu2100 eEnum : ER7013PosLbLpeiu2100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER7013PosLbLpeiu2100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER7013PosLbLpeiu2100.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}

	public static String getUniquePos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 1 });
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 42), getObjects());
	}

	public static ConditionalRequired genConditionalExist() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 1 }));
	}

	public static SegmentValidation genRowValidation02() {
		return UtilSegmentValidation.genEqualsFormula("28", R_2100100000.key, R_2100010000.key,
				UtilMetadata.genMessage(R_2100100000.value, "Total penjumlahan kolom "  + R_2100010000.value));
	}
}