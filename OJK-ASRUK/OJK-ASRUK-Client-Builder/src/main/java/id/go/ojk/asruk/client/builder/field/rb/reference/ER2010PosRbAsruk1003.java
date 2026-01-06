package id.go.ojk.asruk.client.builder.field.rb.reference;

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
public enum ER2010PosRbAsruk1003 implements IObject<KeyValueString> {
	R_1003010000 ("1003010000", "Dst"),
	R_1003020000 ("1003020000", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2010PosRbAsruk1003 eEnum : ER2010PosRbAsruk1003.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2010PosRbAsruk1003.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2010PosRbAsruk1003.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return R_1003020000.key;
	}

	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_1003020000.key, "2");
	}

	public static ConditionalRequired genConditionalField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_1003020000.key);
	}

	public static ConditionalRequired genConditionalField89() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_1003020000.key, "2");
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("8|9", getObjects());
	}

	public static SegmentValidation genValidationRencanaPelaksanaanPendidikandanPelatihanSDM() {
		return UtilSegmentValidation.genEqualsFormula("8|9", R_1003020000.key, R_1003010000.key, 
				"Total Rencana Pelaksanaan Pendidikan dan Pelatihan SDM|Penjumlahan Rencana Pelaksanaan Pendidikan dan Pelatihan SDM");
	}
}
