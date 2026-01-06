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
public enum ER2010PosRbDplks0802 implements IObject<KeyValueString> {
	R_0802010000 ("0802010000", "Peserta Program Pensiun"),
	R_0802020000 ("0802020000", "Peserta Manfaat Lain"),
	R_0802030000 ("0802030000", "Total Peserta"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2010PosRbDplks0802 eEnum : ER2010PosRbDplks0802.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2010PosRbDplks0802.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2010PosRbDplks0802.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationTotalPeserta() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0802030000.key,
				R_0802010000.key + "+" + R_0802020000.key,
				"Total Peserta|Penjumlahan Peserta");
	}
}
