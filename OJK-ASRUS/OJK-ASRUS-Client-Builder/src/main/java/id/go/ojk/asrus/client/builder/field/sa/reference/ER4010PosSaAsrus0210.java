package id.go.ojk.asrus.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1099Peringkat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4010PosSaAsrus0210 implements IObject<KeyValueString> {
//	R_0210010000 ("0210010000", "Tabel II.J: Format Analisis Penilaian Risiko"),
	R_0210010100 ("0210010100", "Analisis Peringkat Risiko"),
	R_0210010200 ("0210010200", "Analisis Risiko Inheren"),
	R_0210010300 ("0210010300", "Analisis Kualitas Penerapan Manajemen Risiko"),
//	R_0210020000 ("0210020000", "Tabel II.L: Peringkat Faktor Profil Risiko"),
	R_0210020100 ("0210020100", "Peringkat Faktor Profil Risiko"),
	R_0210020200 ("0210020200", "Peringkat Faktor Profil Risiko Konsolidasi"),
	R_0210020300 ("0210020300", "Analisis"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4010PosSaAsrus0210 eEnum : ER4010PosSaAsrus0210.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("O", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 4 }));
	}
	
	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genRow("M", UtilMetadata.genPipeRow(getObjects(), new int[] { 3 }), 
				"O",  UtilMetadata.genPipeRow(getObjects(), new int[] { 4 }), "N");
	}
	
	public static FieldValidation genValidationPeringkat3A()  {
		return UtilFieldValidation.genPosLookup("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 3 }), ER1099Peringkat.getLookup());
	}
	
	public static FieldValidation genValidationPeringkat3B()  {
		return UtilFieldValidation.genPosLookup("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 4 }), ER1099Peringkat.getLookup(), "");
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), 3, 4));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 3, 4), 1);
	}
	
	public static SegmentValidation genValidationPeringkat1() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 3 }), ER1099Peringkat.getPipedKey());
	}
	
	public static SegmentValidation genValidationPeringkat2() {
		return UtilSegmentValidation.genFixedValueOptional("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 4 }), ER1099Peringkat.getPipedKey());
	}
}
