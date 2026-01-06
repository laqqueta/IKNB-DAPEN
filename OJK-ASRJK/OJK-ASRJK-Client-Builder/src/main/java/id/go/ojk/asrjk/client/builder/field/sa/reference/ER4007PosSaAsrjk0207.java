package id.go.ojk.asrjk.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1099Peringkat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4007PosSaAsrjk0207 implements IObject<KeyValueString> {
//	R_02070100000000 ("02070100000000", "Tabel II.G.1: Parameter atau Indikator Penilaian untuk Risiko Inheren untuk Risiko Hukum"),
//	R_02070101000000 ("02070101000000", "I Kuantitatif"),
	R_02070101010000 ("02070101010000", "1.  Rasio liabilitas contingency dibandingkan aset lancar"),
	R_02070101020000 ("02070101020000", "2.  Rasio jumlah kasus hukum yang dimenangkan oleh Perusahaan Asuransi dan Perusahaan Reasuransi di pengadilan terhadap jumlah gugatan"),
	R_02070101030000 ("02070101030000", "3.  Jumlah nominal gugatan yang sedang diajukan"),
//	R_02070102000000 ("02070102000000", "B Kualitatif"),
	R_02070102010000 ("02070102010000", "1.  Ketiadaan atau perubahan peraturan perundang-undangan"),
	R_02070102020000 ("02070102020000", "2.  Kegagalan perjanjian/ kelemahan perikatan"),
	R_02070102030000 ("02070102030000", "3.  Litigasi/penyelesaian sengketa"),
//	R_02070200000000 ("02070200000000", "Tabel II.G.2: Tingkat Risiko Inheren untuk Risiko Hukum"),
	R_02070201000000 ("02070201000000", "Tingkat Risiko Inheren untuk Risiko Hukum"),
//	R_02070300000000 ("02070300000000", "Tabel II.G.3: Kualitas Penerapan Manajemen Risiko untuk Risiko Hukum"),
	R_02070301000000 ("02070301000000", "Kualitas Penerapan Manajemen Risiko untuk Risiko Hukum"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4007PosSaAsrjk0207 eEnum : ER4007PosSaAsrjk0207.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER4007PosSaAsrjk0207.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER4007PosSaAsrjk0207.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumericDotNegative() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), 0, 1));
	}
	
	public static SegmentValidation genValidationMaxLengthNumericDotNegative() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 0, 1), 8);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 6, 7 }));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric1() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 2 }), 16);
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric2() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 6, 7 }), 1);
	}
	
	public static SegmentValidation genValidationPeringkat() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 6, 7 }), ER1099Peringkat.getPipedKey());
	}
}
