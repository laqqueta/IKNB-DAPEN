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
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.reask.client.builder.field.reference.EHeaderMetadataShared;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3046PosLbReask211 implements IObject<KeyValueString> {
	R_5401000001 ("5401000001", "Baris rincian"),
	R_5401000002 ("5401000002", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3046PosLbReask211 eEnum : ER3046PosLbReask211.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return R_5401000002.key;
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(4, 71), getObjects());
	}
	
	public static ConditionalRequired genConditionField2() {
		return UtilFieldConditional.genExistPos("N", "O", R_5401000002.key);
	}
	
	public static ConditionalRequired genConditionField3() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "N", "M", R_5401000002.key, "2");
	}
	
	public static ConditionalRequired genConditionField() {
		return UtilFieldConditional.genExistPosOrComparatorNotEmpty("N", "M", "M", R_5401000002.key, "2");
	}
	
	public static FieldValidation genFieldValidation3() {
		return UtilFieldValidation.genPosReferenceCondition3(R_5401000002.key, "2", String.valueOf(EHeaderMetadataShared.R030.getNumber()));
	}
	
	public static FieldValidation genFieldValidation60() {
		return UtilFieldValidation.genEqualsPosFormula("4+8+12+16+20+24+28+32+36+40+44+48+52+56", R_5401000001.key);
	}
	
	public static FieldValidation genFieldValidation61() {
		return UtilFieldValidation.genEqualsPosFormula("5+9+13+17+21+25+29+33+37+41+45+49+53+57", R_5401000001.key);
	}
	
	public static FieldValidation genFieldValidation62() {
		return UtilFieldValidation.genEqualsPosFormula("6+10+14+18+22+26+30+34+38+42+46+50+54+58", R_5401000001.key);
	}
	
	public static FieldValidation genFieldValidation63() {
		return UtilFieldValidation.genEqualsPosFormula("7+11+15+19+23+27+31+35+39+43+47+51+55+59", R_5401000001.key);
	}
	
	public static FieldValidation genFieldValidation68() {
		return UtilFieldValidation.genEqualsPosFormula("60+64", R_5401000001.key);
	}
	
	public static FieldValidation genFieldValidation69() {
		return UtilFieldValidation.genEqualsPosFormula("61+65", R_5401000001.key);
	}
	
	public static FieldValidation genFieldValidation70() {
		return UtilFieldValidation.genEqualsPosFormula("62+66", R_5401000001.key);
	}
	
	public static FieldValidation genFieldValidation71() {
		return UtilFieldValidation.genEqualsPosFormula("63+67", R_5401000001.key);
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(4, 71), R_5401000002.key, R_5401000001.key, "Total|Penjumlahan detail");
	}
}
