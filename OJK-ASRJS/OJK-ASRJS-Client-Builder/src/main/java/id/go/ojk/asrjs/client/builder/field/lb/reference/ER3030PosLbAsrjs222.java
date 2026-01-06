package id.go.ojk.asrjs.client.builder.field.lb.reference;

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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3030PosLbAsrjs222 implements IObject<KeyValueString> {
	R_2220010000 ("2220010000", "Kematian Jangka Warsa"),
	R_2220010001 ("2220010001", "Endowment dan/atau Kombinasinya"),
	R_2220010002 ("2220010002", "Seumur Hidup"),
	R_2220010003 ("2220010003", "Anuitas"),
	R_2220010004 ("2220010004", "Kematian Ekawarsa"),
	R_2220010005 ("2220010005", "Kesehatan"),
	R_2220010006 ("2220010006", "Kecelakaan Diri"),
	R_2220010007 ("2220010007", "Lainnya"),
	R_2220010014 ("2220010014", "IV. Total ((PRBi - ARi)fpbi)"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3030PosLbAsrjs222 eEnum : ER3030PosLbAsrjs222.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}
	
	public static ConditionalRequired genConditional4() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 8 }));
	}

	public static FieldValidation genValidation5() {
		return UtilFieldValidation.genPosPercentage("2-3|4", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 8 }), 2);
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_2220010014.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 7), "Total|Penjumlahan Detail", 2);
	}
}
