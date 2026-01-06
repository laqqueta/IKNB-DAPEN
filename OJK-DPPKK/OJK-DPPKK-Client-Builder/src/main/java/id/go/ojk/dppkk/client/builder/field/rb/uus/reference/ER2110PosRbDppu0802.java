package id.go.ojk.dppkk.client.builder.field.rb.uus.reference;

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
public enum ER2110PosRbDppu0802 implements IObject<KeyValueString> {
	R_0802010100 ("0802010100", "Iuran Normal Peserta"),
	R_0802010200 ("0802010200", "Iuran Sukarela Peserta"),
	R_0802010300 ("0802010300", "Iuran Normal Pemberi kerja"),
	R_0802010400 ("0802010400", "Iuran Tambahan Pemberi kerja"),
	R_0802010500 ("0802010500", "Total Dana Iuran"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2110PosRbDppu0802 eEnum : ER2110PosRbDppu0802.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2110PosRbDppu0802.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2110PosRbDppu0802.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationDanaIuran() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0802010500.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 3),
				"Total Dana Iuran|Penjumlahan Dana Iuran");
	}
}
