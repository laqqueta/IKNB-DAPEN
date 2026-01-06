package id.go.ojk.reask.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3049PosLbReask213 implements IObject<KeyValueString> {
	R_6201000000 ("6201000000", "Rumah Tangga"),
	R_6202000000 ("6202000000", "Lembaga Non Profit yang Melayani RT"),
	R_6203000000 ("6203000000", "Pemerintah"),
	R_6204000000 ("6204000000", "Korporasi Finansial"),
	R_6205000000 ("6205000000", "Korporasi Non Finansial"),
	R_6206000000 ("6206000000", "Luar Negeri"),
	R_6200000000 ("6200000000", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3049PosLbReask213 eEnum : ER3049PosLbReask213.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 13), getObjects());
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 13), R_6200000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 5), "Total|Penjumlahan detail");
	}
}
