package id.go.ojk.asrjs.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1099Peringkat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4013PosSaAsrjs0400 implements IObject<KeyValueString> {
//	R_04000100000000 ("04000100000000", "Tabel IV.A: Parameter atau Indikator Penilaian Faktor Permodalan"),
//	R_04000101000000 ("04000101000000", "1.  Tingkat kecukupan permodalan"),
//	R_04000101010000 ("04000101010000", " I. Kualitatif"),
	R_04000101010100 ("04000101010100", " 1) Penilaian level (posisi), tren, dan komposisi aset yang diperkenankan (admitted assets) Perusahaan."),
	R_04000101010200 ("04000101010200", " 2) Penilaian kecukupan modal dengan memperhitungkan risiko-risiko pada Perusahaan"),
	R_04000101010300 ("04000101010300", " 3) Penentuan kecukupan modal minimum menurut profil risiko"),
//	R_04000101020000 ("04000101020000", " II. Kuantitatif"),
	R_04000101020100 ("04000101020100", " 1) Return on Equity (RoE) pada Dana Perusahaan "),
	R_04000101020200 ("04000101020200", " 2) Pertumbuhan saldo laba"),
//	R_04000102000000 ("04000102000000", "2.  Pengelolaan Permodalan"),
	R_04000102010000 ("04000102010000", " a. Manajemen permodalan Perusahaan."),
	R_04000102020000 ("04000102020000", " b. Kemampuan akses permodalan yang dilihat dari sumber internal dan sumber eksternal."),
//	R_04000200000000 ("04000200000000", "Tabel IV.B: Peringkat Faktor Permodalan"),
	R_04000201000000 ("04000201000000", "Peringkat Faktor Permodalan Individu"),
	R_04000202000000 ("04000202000000", "Peringkat Faktor Permodalan Konsolidasi *)"),
	R_04000203000000 ("04000203000000", "Analisis"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4013PosSaAsrjs0400 eEnum : ER4013PosSaAsrjs0400.values()) {
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
		return UtilFieldConditional.genExistPos("O", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 8 }));
	}
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), 3, 4));
	}
	
	public static SegmentValidation genValidationMaxLengthNumericDot() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 3, 4), 10);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), 7, 8));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 7, 8), 1);
	}
	
	public static SegmentValidation genValidationPeringkat1() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 7 }), ER1099Peringkat.getPipedKey());
	}
	
	public static SegmentValidation genValidationPeringkat2() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 8 }), ER1099Peringkat.getPipedKey());
	}
}
