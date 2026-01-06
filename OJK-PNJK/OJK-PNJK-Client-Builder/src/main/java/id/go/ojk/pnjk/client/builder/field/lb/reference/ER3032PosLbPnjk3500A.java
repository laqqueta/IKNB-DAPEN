package id.go.ojk.pnjk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3032PosLbPnjk3500A implements IObject<KeyValueString> {
//	R_3500A10100 ("3500A10100", "Penerima Jaminan"),
	R_3500A10101 ("3500A10101", "Bank"),
	R_3500A10102 ("3500A10102", "Lembaga Keuangan Bukan Bank"),
	R_3500A10103 ("3500A10103", "Di Luar Lembaga Keuangan"),
	R_3500A10000 ("3500A10000", "Total"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3032PosLbPnjk3500A eEnum : ER3032PosLbPnjk3500A.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public String getKeyForm() {
		return EFormLaporanBulanan.LB_3500A.getCode() + key;
	}
	
	public KeyValueString getObjectForm() {
		return new KeyValueString(getKeyForm(), value, new String[] {});
	}

	public static List<KeyValueString> getObjectsForm() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3032PosLbPnjk3500A eEnum : ER3032PosLbPnjk3500A.values()) {
			res.add(eEnum.getObjectForm());
		}
		return res;
	}

	public static String getName() {
		return ER3032PosLbPnjk3500A.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3032PosLbPnjk3500A.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 37), getObjects());
	}

	public static FieldValidation genFieldValidation32() {
		return UtilFieldValidation.genEqualsPosFormula("2+8+14+20+26",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3 }));
	}

	public static FieldValidation genFieldValidation33() {
		return UtilFieldValidation.genEqualsPosFormula("3+9+15+21+27",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3 }));
	}

	public static FieldValidation genFieldValidation34() {
		return UtilFieldValidation.genEqualsPosFormula("4+10+16+22+28",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3 }));
	}

	public static FieldValidation genFieldValidation35() {
		return UtilFieldValidation.genEqualsPosFormula("5+11+17+23+29",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3 }));
	}

	public static FieldValidation genFieldValidation36() {
		return UtilFieldValidation.genEqualsPosFormula("6+12+18+24+30",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3 }));
	}

	public static FieldValidation genFieldValidation37() {
		return UtilFieldValidation.genEqualsPosFormula("7+13+19+25+31",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3 }));
	}
	
	public static SegmentValidation genValidation5() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 37), R_3500A10000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 2),
				UtilMetadata.genMessage(R_3500A10000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 2)));
	}
}
