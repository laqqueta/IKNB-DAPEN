package id.go.ojk.reask.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1018DalamLuarNegeri;
import id.go.ojk.conf.client.field.reference.ER1019PeringkatKlaster;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3011PosLbReask502 implements IObject<KeyValueString> {
	R_7301020100 ("7301020100", "Baris rincian"),
	R_7301020200 ("7301020200", "Total"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3011PosLbReask502 eEnum : ER3011PosLbReask502.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return R_7301020200.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("5|6|7|9", getObjects());
	}
	
	public static ConditionalRequired genConditionalMustEmpty2() {
		return UtilFieldConditional.genExistPos("O", "N", R_7301020100.key);
	}
	
	public static ConditionalRequired genConditionalMustEmpty348() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_7301020200.key, "2");
	}
	
	public static ConditionalRequired genConditionalMustEmpty5679() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_7301020200.key, "2");
	}
	
	public static FieldValidation genFieldValidation7() {
		return UtilFieldValidation.genEqualsPosFormula("5-6", R_7301020100.key);
	}
	
	public static FieldValidation genFieldValidation8() {
		return UtilFieldValidation.genPosLookup("3|4", R_7301020100.key, genLookup());
	}
	
	public static FieldValidation genFieldValidation9() {
		return UtilFieldValidation.genPosPercentage("7|8", R_7301020100.key);
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("5|6|7|9", R_7301020200.key, R_7301020100.key, 
				"Total resiko kredit|Penjumlahan resiko kredit");
	}
	
	private static String genLookup() {
		StringBuilder res = new StringBuilder();
		res.append(ER1018DalamLuarNegeri.R_LO_IDN.getObject().getKey()).append(ER1019PeringkatKlaster.R_1.getObject().getKey()).append(":").append("2.80").append("|");
		res.append(ER1018DalamLuarNegeri.R_LO_IDN.getObject().getKey()).append(ER1019PeringkatKlaster.R_2.getObject().getKey()).append(":").append("2.80").append("|");
		res.append(ER1018DalamLuarNegeri.R_LO_IDN.getObject().getKey()).append(ER1019PeringkatKlaster.R_3.getObject().getKey()).append(":").append("2.80").append("|");
		res.append(ER1018DalamLuarNegeri.R_LO_IDN.getObject().getKey()).append(ER1019PeringkatKlaster.R_4.getObject().getKey()).append(":").append("2.80").append("|");
		res.append(ER1018DalamLuarNegeri.R_LO_IDN.getObject().getKey()).append(ER1019PeringkatKlaster.R_5.getObject().getKey()).append(":").append("2.80").append("|");
		res.append(ER1018DalamLuarNegeri.R_LO_E1.getObject().getKey()).append(ER1019PeringkatKlaster.R_1.getObject().getKey()).append(":").append("2.80").append("|");
		res.append(ER1018DalamLuarNegeri.R_LO_E1.getObject().getKey()).append(ER1019PeringkatKlaster.R_2.getObject().getKey()).append(":").append("4.00").append("|");
		res.append(ER1018DalamLuarNegeri.R_LO_E1.getObject().getKey()).append(ER1019PeringkatKlaster.R_3.getObject().getKey()).append(":").append("6.00").append("|");
		res.append(ER1018DalamLuarNegeri.R_LO_E1.getObject().getKey()).append(ER1019PeringkatKlaster.R_4.getObject().getKey()).append(":").append("12.00").append("|");
		res.append(ER1018DalamLuarNegeri.R_LO_E1.getObject().getKey()).append(ER1019PeringkatKlaster.R_5.getObject().getKey()).append(":").append("15.00");
		return res.toString();
	}
}
