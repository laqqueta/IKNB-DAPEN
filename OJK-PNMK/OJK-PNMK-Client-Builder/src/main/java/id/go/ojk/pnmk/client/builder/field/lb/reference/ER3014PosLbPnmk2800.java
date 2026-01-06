package id.go.ojk.pnmk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3014PosLbPnmk2800 implements IObject<KeyValueString> {
	R_2800010000 ("2800010000", "Kas dan Setara Kas"),
	R_2800020000 ("2800020000", "Pinjaman ULaMM yang Diberikan"),
	R_2800030000 ("2800030000", "Pembiayaan ULaMM Syariah yang Diberikan"),
	R_2800040000 ("2800040000", "Pinjaman Mekaar yang Diberikan"),
	R_2800050000 ("2800050000", "Pembiayaan Mekaar Syariah yang Diberikan"),
	R_2800060000 ("2800060000", "Pembiayaan Modal"),
	R_2800070000 ("2800070000", "Piutang Jasa Manajemen"),
	R_2800080000 ("2800080000", "Pendapatan yang Masih Diterima"),
	R_2800090000 ("2800090000", "Piutang Kegiatan Manajer Investasi"),
	R_2800100000 ("2800100000", "Piutang Lain-lain"),
	;

	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulanan.LB_2800.getCode() + key;
	}

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public KeyValueString getFormObject() {
		return new KeyValueString(getFormKey(), value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3014PosLbPnmk2800 eEnum : ER3014PosLbPnmk2800.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static List<KeyValueString> getFormObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3014PosLbPnmk2800 eEnum : ER3014PosLbPnmk2800.values()) {
			res.add(eEnum.getFormObject());
		}
		return res;
	}

	public static String getName() {
		return ER3014PosLbPnmk2800.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3014PosLbPnmk2800.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 3), getObjects());
	}
	
	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsFormula("2-3", 0);
	}
}
