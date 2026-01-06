package id.go.ojk.lpei.client.builder.field.lb.reference;

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
public enum ER5011PosLbLpeig2000 implements IObject<KeyValueString> {
	R_2000010100 ("2000010100", "Detail"),
	R_2000010000 ("2000010000", "Jumlah"),
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
		for (ER5011PosLbLpeig2000 eEnum : ER5011PosLbLpeig2000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5011PosLbLpeig2000.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5011PosLbLpeig2000.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return ER5011PosLbLpeig2000.R_2000010000.getKey();
	}

	public static String getUniquePos() {
		return ER5011PosLbLpeig2000.R_2000010000.getKey();
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 5), getObjects());
	}

	public static ConditionalRequired genConditionalExist() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 1 }));
	}

	public static SegmentValidation genRowValidationJumlah() {
		return UtilSegmentValidation.genEqualsFormula("4", R_2000010000.key, R_2000010100.key,
				UtilMetadata.genMessage(R_2000010000.value, "Total penjumlahan kolom "  + R_2000010000.value));
	}
}