package id.go.ojk.reask.client.builder.field.rb.reference;

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
public enum ER2007PosRbReask0702 implements IObject<KeyValueString> {
	R_0702010000 ("0702010000", "Posisi Modal"),
//	R_0702020000 ("0702020000", "Pemegang Saham"),
	R_0702020100 ("0702020100", "Pemegang Saham"),
	R_0702030000 ("0702030000", "IPO (Initial Public Offering)- Go Public"),
	R_0702040000 ("0702040000", "Penerbitan saham baru"),
	R_0702050000 ("0702050000", "Lainnya (seperti pinjaman subordinasi)"),
	R_0702060000 ("0702060000", "Total Modal Disetor"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2007PosRbReask0702 eEnum : ER2007PosRbReask0702.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2007PosRbReask0702.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2007PosRbReask0702.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 2, 3, 4, 5 });
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4|5|6", getObjects());
	}

	public static ConditionalRequired genConditionalField2() {
		return UtilFieldConditional.genExistPos("O", "N", R_0702020100.key);
	}

	public static SegmentValidation genValidationModalDisetor() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5|6", R_0702060000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 4), 
				"Total Modal Disetor|Penjumlahan Modal Disetor");
	}
}
