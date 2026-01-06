 package id.go.ojk.ppik.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3007PosLbPpik0043 implements IObject<KeyValueString> {
//	R_0043010000 ("0043010000", "Jumlah Tenaga Kerja"),
	R_0043010100 ("0043010100", "Pemasaran"),
	R_0043010200 ("0043010200", "Pembiayaan dan Investasi"),
	R_0043010300 ("0043010300", "Human Resource (HR) dan General Affair (GA)"),
	R_0043010400 ("0043010400", "Keuangan, Administrasi, dan Akuntansi"),
	R_0043010500 ("0043010500", "Manajemen Risiko"),
	R_0043010600 ("0043010600", "Pengendalian Internal dan Kepatuhan"),
	R_0043010700 ("0043010700", "Legal"),
	R_0043010800 ("0043010800", "Pengelolaan Sistem Informasi"),
	R_0043010900 ("0043010900", "Penerapan Program Anti Pencucian Uang dan Pencegahan Pendanaan Terorisme "),
	R_0043011000 ("0043011000", "Pengendalian fraud"),
	R_0043011100 ("0043011100", "Fungsi Lainnya"),
	R_0043020000 ("0043020000", "Total Tenaga Kerja"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3007PosLbPpik0043 eEnum : ER3007PosLbPpik0043.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3007PosLbPpik0043.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3007PosLbPpik0043.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 10), getObjects());
	}
	
	public static ConditionalRequired genFieldCondition11() {
		return UtilFieldConditional.genExistPos("N", "O", R_0043020000.key);
	}
	
	public static FieldValidation genFieldValidation8() {
		return UtilFieldValidation.genEqualsFormula("2+4+6");
	}
	
	public static FieldValidation genFieldValidation9() {
		return UtilFieldValidation.genEqualsFormula("3+5+7");
	}
	
	public static FieldValidation genFieldValidation10() {
		return UtilFieldValidation.genEqualsFormula("8+9");
	}
	
	public static SegmentValidation genRowValidation12() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7), R_0043020000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 10),
				UtilMetadata.genMessage(R_0043020000.value, "Tenaga kerja", UtilMetadata.genPlusDesc(getObjects(), 0, 10)));
	}

	public static SegmentValidation genRowValidation13() {
		return UtilSegmentValidation.genEqualsForm("10", R_0043020000.key, EFormLaporanBulanan.LB_0041.getCode(), "11",
				ER3006PosLbPpik0041.R_0041050000.getKey(), R_0043020000.value);
	}
}
