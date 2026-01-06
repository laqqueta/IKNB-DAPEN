package id.go.ojk.asruk.client.builder.field.sa.uus.reference;

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
public enum ER4109PosSaAsruu0210 implements IObject<KeyValueString> {
//	R_0210010000 ("0210010000", "Tabel II.J: Format Analisis Penilaian Risiko"),
	R_0210010100 ("0210010100", "Analisis Peringkat Risiko"),
	R_0210010200 ("0210010200", "Analisis Risiko Inheren"),
	R_0210010300 ("0210010300", "Analisis Kualitas Penerapan Manajemen Risiko"),
//	R_0210020000 ("0210020000", "Tabel II.L: Peringkat Faktor Profil Risiko"),
	R_0210020100 ("0210020100", "Peringkat Faktor Profil Risiko Individu"),
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
		for (ER4109PosSaAsruu0210 eEnum : ER4109PosSaAsruu0210.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static ConditionalRequired genConditional3() {
		return UtilFieldConditional.genExistPos("M", "N", R_0210020100.key);
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}

	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 3 }), 1);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 3 }));
	}
	
	public static SegmentValidation genValidationPeringkat() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 3 }), ER1099Peringkat.getPipedKey());
	}

	public static FieldValidation genValidationPeringkat3()  {
		return UtilFieldValidation.genPosLookup("2", R_0210020100.key, ER1099Peringkat.getLookup());
	}
}
