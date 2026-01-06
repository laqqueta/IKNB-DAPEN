package id.go.ojk.pps.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1007RencanaPengembanganKantor;
import id.go.ojk.conf.client.field.reference.ER1008JenisKantor;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2263PosRePps080000 implements IObject<KeyValueString> {
	R_08010100000000 ("08010100000000", "Pengembangan"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2263PosRePps080000 eEnum : ER2263PosRePps080000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2263PosRePps080000.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2263PosRePps080000.class.getSimpleName().substring(2, 6));
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}

	public static ConditionalRequired genConditionalField3() {
		return UtilFieldConditional.genAllExist("M", "N", "2");
	}

	public static ConditionalRequired genConditionalField4() {
		return genConditionalField3();
	}

	public static ConditionalRequired genConditionalField5() {
		return genConditionalField3();
	}

	public static ConditionalRequired genConditionalField6() {
		return genConditionalField3();
	}

	public static ConditionalRequired genConditionalField7() {
		return UtilFieldConditional.genComparatorHasValue("M", "O", "2", 
				ER1007RencanaPengembanganKantor.R_PKE1.getKey() + "|" + ER1007RencanaPengembanganKantor.R_PKE2.getKey());
	}
	
	public static FieldValidation genValidationField3() {
		return UtilFieldValidation.genIfEqualThen("2", 
				ER1007RencanaPengembanganKantor.R_PKE1.getKey() + "|" + ER1007RencanaPengembanganKantor.R_PKE2.getKey(), 
				ER1008JenisKantor.R_PKE6.getKey() + "|" + ER1008JenisKantor.R_PKE7.getKey());
	}
	
	public static SegmentValidation genValidationUnique() {
		return UtilSegmentValidation.genUnique("3", "", ER1008JenisKantor.R_PKE5.getKey(), "2", ER1007RencanaPengembanganKantor.R_PKE3.getKey());
	}
}
