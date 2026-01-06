package id.go.ojk.asrus.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2017PosRbAsrus0701 implements IObject<KeyValueString> {
	R_0701010000 ("0701010000", "POSISI MODAL "),
//	R_0701020000 ("0701020000", "Pemegang Saham "),
	R_0701020100 ("0701020100", "1. ---------------- "),
	R_0701030000 ("0701030000", "IPO (Initial Public Offering)-Go Public"),
	R_0701040000 ("0701040000", "Penerbitan saham baru"),
	R_0701050000 ("0701050000", "Lainnya (seperti pinjaman subordinasi)"),
	R_0701060000 ("0701060000", "Total Modal Disetor"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2017PosRbAsrus0701 eEnum : ER2017PosRbAsrus0701.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2017PosRbAsrus0701.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2017PosRbAsrus0701.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 2, 3, 5 });
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("4|5|6|7", getObjects());
	}

	public static ConditionalRequired genConditionalField2() {
		return UtilFieldConditional.genExistPos("O", "N", R_0701020100.key);
	}

	public static ConditionalRequired genConditionalField3() {
		return UtilFieldConditional.genExistPos("O", "N", R_0701050000.key);
	}

	public static SegmentValidation genValidationTotalModalDisetor() {
		return UtilSegmentValidation.genEqualsFormula("4|5|6|7", R_0701060000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 4), "Total Modal Disetor|Penjumlahan Modal Disetor");
	}
}
