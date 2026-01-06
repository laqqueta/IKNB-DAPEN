package id.go.ojk.ppk.client.builder.field.rb.reference;

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
public enum ER2002PosRbPpk040201 implements IObject<KeyValueString> {
	R_04020101000000 ("04020101000000", "Nama Debitur"), 
	R_04020102000000 ("04020102000000", "Total"),;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2002PosRbPpk040201 eEnum : ER2002PosRbPpk040201.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2002PosRbPpk040201.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2002PosRbPpk040201.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return R_04020102000000.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4|5|6", getObjects());
	}

	public static ConditionalRequired genConditionalMustEmpty() {
		return UtilFieldConditional.genExistPos("N", "O", R_04020102000000.key);
	}

	public static ConditionalRequired genConditionalField() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_04020102000000.key, "2");
	}

	public static SegmentValidation genValidationTotalPenyaluranPembiayaanKepadaDebiturInti() {
		return UtilSegmentValidation.genEqualsFormula("3|4|5|6", R_04020102000000.key, R_04020101000000.key,
				"Total Penyaluran Pembiayaan Kepada Debitur Inti|Penjumlahan Penyaluran Pembiayaan Kepada Debitur Inti");
	}
}
