package id.go.ojk.asrjk.client.builder.field.lb.reference;

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
public enum ER3030PosLbAsrjk113 implements IObject<KeyValueString> {
	R_2503000001 ("2503000001", "Kematian Ekawarsa"),
	R_2503000002 ("2503000002", "Kematian Jangka Warsa"),
	R_2503000003 ("2503000003", "Kecelakaan DIri"),
	R_2503000004 ("2503000004", "Kesehatan"),
	R_2503000005 ("2503000005", "Anuitas"),
	R_2503000000 ("2503000000", "Total"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3030PosLbAsrjk113 eEnum : ER3030PosLbAsrjk113.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3030PosLbAsrjk113.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3030PosLbAsrjk113.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 10), getObjects());
	}
	
	public static ConditionalRequired genConditionalMustEmpty() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRow(getObjects(), 4, 5));
	}
	
	public static FieldValidation genFieldValidation8A() {
		return UtilFieldValidation.genEqualsPosFormula("2+4", UtilMetadata.genPipeRow(getObjects(), 0, 3));
	}
	
	public static FieldValidation genFieldValidation8B() {
		return UtilFieldValidation.genEqualsPosFormula("2+4+6", R_2503000005.key);
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_2503000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 4),  "Total|Penjumlahan Cadangan Klaim");
	}
}
