package id.go.ojk.pnjk.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulananUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3133PosLbPnju3500B implements IObject<KeyValueString> {
//	R_3500B10100 ("3500B10100", "Penerima Jaminan"),
	R_3500B10101 ("3500B10101", "Bank"),
	R_3500B10102 ("3500B10102", "Lembaga Keuangan Bukan Bank"),
	R_3500B10103 ("3500B10103", "Di Luar Lembaga Keuangan"),
	R_3500B10000 ("3500B10000", "Total"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3133PosLbPnju3500B eEnum : ER3133PosLbPnju3500B.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public String getKeyForm() {
		return EFormLaporanBulananUus.LB_3500B.getCode() + key;
	}
	
	public KeyValueString getObjectForm() {
		return new KeyValueString(getKeyForm(), value, new String[] {});
	}

	public static List<KeyValueString> getObjectsForm() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3133PosLbPnju3500B eEnum : ER3133PosLbPnju3500B.values()) {
			res.add(eEnum.getObjectForm());
		}
		return res;
	}

	public static String getName() {
		return ER3133PosLbPnju3500B.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3133PosLbPnju3500B.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 73), getObjects());
	}

	public static FieldValidation genFieldValidation68() {
		return UtilFieldValidation.genEqualsPosFormula("2+8+14+20+26+32+38+44+50+56+62",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3 }));
	}

	public static FieldValidation genFieldValidation69() {
		return UtilFieldValidation.genEqualsPosFormula("3+9+15+21+27+33+39+45+51+57+63",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3 }));
	}

	public static FieldValidation genFieldValidation70() {
		return UtilFieldValidation.genEqualsPosFormula("4+10+16+22+28+34+40+46+52+58+64",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3 }));
	}

	public static FieldValidation genFieldValidation71() {
		return UtilFieldValidation.genEqualsPosFormula("5+11+17+23+29+35+41+47+53+59+65",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3 }));
	}

	public static FieldValidation genFieldValidation72() {
		return UtilFieldValidation.genEqualsPosFormula("6+12+18+24+30+36+42+48+54+60+66",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3 }));
	}

	public static FieldValidation genFieldValidation73() {
		return UtilFieldValidation.genEqualsPosFormula("7+13+19+25+31+37+43+49+55+61+67",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 3 }));
	}
	
	public static SegmentValidation genValidation5() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 73), R_3500B10000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 2),
				UtilMetadata.genMessage(R_3500B10000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 2)));
	}
}
