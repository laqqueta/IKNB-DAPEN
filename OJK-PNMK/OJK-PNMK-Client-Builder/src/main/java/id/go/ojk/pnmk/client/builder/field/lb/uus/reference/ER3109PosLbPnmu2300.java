package id.go.ojk.pnmk.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulananUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3109PosLbPnmu2300 implements IObject<KeyValueString> {
	R_2300010000 ("2300010000", "1"),
	;
	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulananUus.LB_2300.getCode() + key;
	}

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public KeyValueString getFormObject() {
		return new KeyValueString(getFormKey(), value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3109PosLbPnmu2300 eEnum : ER3109PosLbPnmu2300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static List<KeyValueString> getFormObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3109PosLbPnmu2300 eEnum : ER3109PosLbPnmu2300.values()) {
			res.add(eEnum.getFormObject());
		}
		return res;
	}

	public static String getName() {
		return ER3109PosLbPnmu2300.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3109PosLbPnmu2300.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("14", getObjects());
	}
	
	public static FieldValidation genValidation7() {
		return UtilFieldValidation.genDateLessEquals("8");
	}
	
	public static FieldValidation genValidation8() {
		return UtilFieldValidation.genDateGreaterEquals("7");
	}
}
