package id.go.ojk.lpei.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5004PosLbLpeig0043 implements IObject<KeyValueString> {
	R_0041010100 ("0043010000", "Pemasaran"),
	R_0043020000 ("0043020000", "Pembiayaan"),
	R_0043030000 ("0043030000", "Treasury dan Investasi"),
	R_0043040000 ("0043040000", "Human Resource (HR) dan General Affair (GA)"),
	R_0043050000 ("0043050000", "Keuangan, Administrasi, dan Akuntansi"),
	R_0043060000 ("0043060000", "Manajemen Risiko dan Pengendalian Internal"),
	R_0043070000 ("0043070000", "Kepatuhan dan Penerapan Program Anti Pencucian Uang dan Pencegahan Pendanaan Terorisme"),
	R_0043080000 ("0043080000", "Legal"),
	R_0043090000 ("0043090000", "Pengelolaan Sistem Informasi"),
	R_0043110000 ("0043110000", "Pengendalian Fraud"),
	R_0043111000 ("0043111000", "Fungsi Lainnya"),
	R_0043112000 ("0043112000", "Jumlah Tenaga Kerja")
	;

	@Getter
	private String key;
	private String value;

	public String getFormKey() {
		return EFormLaporanBulanan.LB_0043.getCode() + key;
	}

	@Override
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5004PosLbLpeig0043 eEnum : ER5004PosLbLpeig0043.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5004PosLbLpeig0043.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5004PosLbLpeig0043.class.getSimpleName().substring(2, 6));
	}

	/*
	 * Unique and required validation
	 */
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String getUniquePos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 9), getObjects());
	}

	public static FieldValidation genFieldValidation8() {
		return UtilFieldValidation.genEqualsFormula("2+4+6");
	}

	public static FieldValidation genFieldValidation9() {
		return UtilFieldValidation.genEqualsFormula("3+5+7");
	}

	public static SegmentValidation genRowValidation13() {
		int[] fields = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 9), R_0043112000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_0043112000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
}
