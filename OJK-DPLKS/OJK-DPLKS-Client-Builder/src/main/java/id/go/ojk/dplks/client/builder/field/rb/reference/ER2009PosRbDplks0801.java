package id.go.ojk.dplks.client.builder.field.rb.reference;

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
public enum ER2009PosRbDplks0801 implements IObject<KeyValueString> {
	R_0801010000 ("0801010000", "Iuran Pemberi Kerja "),
	R_0801020000 ("0801020000", "Iuran Peserta"),
	R_0801030000 ("0801030000", "Total Dana Iuran"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2009PosRbDplks0801 eEnum : ER2009PosRbDplks0801.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2009PosRbDplks0801.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2009PosRbDplks0801.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationTotalDanaIuran() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0801030000.key, 
				R_0801010000.key + "+" + R_0801020000.key, "Total Dana Iuran|Penjumlahan Dana Iuran");
	}
}
