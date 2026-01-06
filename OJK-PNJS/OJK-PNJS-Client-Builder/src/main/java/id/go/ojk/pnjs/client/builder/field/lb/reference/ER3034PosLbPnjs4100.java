package id.go.ojk.pnjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3034PosLbPnjs4100 implements IObject<KeyValueString> {
	R_4100010000 ("4100010000", "<= 1 tahun"),
	R_4100020000 ("4100020000", "1 tahun < umur <= 5 tahun"),
	R_4100030000 ("4100030000", "5 tahun < umur <= 10 tahun"),
	R_4100040000 ("4100040000", "> 10 tahun"),
	R_4100050000 ("4100050000", "Total"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3034PosLbPnjs4100 eEnum : ER3034PosLbPnjs4100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3034PosLbPnjs4100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3034PosLbPnjs4100.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static SegmentValidation genValidation6() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_4100050000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 3),
				UtilMetadata.genMessage(R_4100050000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 3)));
	}
}
