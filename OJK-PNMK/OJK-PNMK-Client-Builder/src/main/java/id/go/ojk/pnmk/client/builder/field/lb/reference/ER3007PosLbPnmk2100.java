package id.go.ojk.pnmk.client.builder.field.lb.reference;

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
public enum ER3007PosLbPnmk2100 implements IObject<KeyValueString> {
	R_2100010000("2100010000", "Kas"), 
	R_2100020000("2100020000", "Bank"),
	R_2100030000("2100030000", "Deposito Jangka Pendek"), 
	R_2100040000("2100040000", "Total Kas dan Setara Kas"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3007PosLbPnmk2100 eEnum : ER3007PosLbPnmk2100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3007PosLbPnmk2100.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3007PosLbPnmk2100.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genRowValidation5() {
		return UtilSegmentValidation.genEqualsFormula("2", R_2100040000.key, UtilMetadata.genPlusRow(getObjects(), 0, 2), 
				UtilMetadata.genMessage(R_2100040000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 2)));
	}
}
