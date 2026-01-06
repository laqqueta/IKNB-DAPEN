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
public enum ER3114PosLbPnmu2800 implements IObject<KeyValueString> {
	R_2800010000 ("2800010000", "Pembiayaan ULaMM Syariah "),
	R_2800020000 ("2800020000", "Pembiayaan Mekaar Syariah yang diberikan "),
	R_2800030000 ("2800030000", "Pembiayaan Mudharabah "),
	R_2800040000 ("2800040000", "Pembiayaan Musyarakah "),
	R_2800050000 ("2800050000", "Piutang atas Kegiatan Usaha Lain "),
	R_2800060000 ("2800060000", "Piutang Lain-lain "),
	R_2800070000 ("2800070000", "Pendapatan yang Masih Akan Diterima "),
	;

	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulananUus.LB_2800.getCode() + key;
	}

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public KeyValueString getFormObject() {
		return new KeyValueString(getFormKey(), value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3114PosLbPnmu2800 eEnum : ER3114PosLbPnmu2800.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static List<KeyValueString> getFormObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3114PosLbPnmu2800 eEnum : ER3114PosLbPnmu2800.values()) {
			res.add(eEnum.getFormObject());
		}
		return res;
	}

	public static String getName() {
		return ER3114PosLbPnmu2800.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3114PosLbPnmu2800.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsFormula("2-3", 0);
	}
}
