package id.go.ojk.pnmk.client.builder.field.lb.reference;

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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3006PosLbPnmk1400 implements IObject<KeyValueString> {
	R_1400001000("1400001000", "Umur Aset atau Liabilitas dibawah 1 (satu) tahun ( < 1 tahun ),"),
	R_1400002000("1400002000", "Umur Aset atau Liabilitas 1 (satu) sampai 3 (tiga) tahun (1-3 tahun),"),
	R_1400003000("1400003000", "Umur Aset atau Liabilitas 3 (tiga) sampai 5 (lima) tahun (3-5 tahun), atau"),
	R_1400004000("1400004000", "Umur Aset atau Liabilitas lebih dari 5 (lima) tahun ( > 5 tahun )."),
	R_1400005000("1400005000", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3006PosLbPnmk1400 eEnum : ER3006PosLbPnmk1400.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3006PosLbPnmk1400.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3006PosLbPnmk1400.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 7), getObjects());
	}
	
	public static ConditionalRequired genConditional() {
		return UtilFieldConditional.genExistPos("M", "N", R_1400001000.key);
	}
	
	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genEqualsRatio("2|3");
	}
	
	public static SegmentValidation genRowValidation6() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1400005000.key, UtilMetadata.genPlusRow(getObjects(), 0, 3), 
				UtilMetadata.genMessage(R_1400005000.value, UtilMetadata.genPlusDesc(getObjects(), 0, 3)), 0);
	}
}
