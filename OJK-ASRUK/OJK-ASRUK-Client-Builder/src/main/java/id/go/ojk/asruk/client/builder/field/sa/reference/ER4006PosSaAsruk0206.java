package id.go.ojk.asruk.client.builder.field.sa.reference;

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
public enum ER4006PosSaAsruk0206 implements IObject<KeyValueString> {
//	R_02060100000000 ("02060100000000", "Tabel II.F.1: Parameter atau Indikator Penilaian Risiko Inheren untuk Risiko Likuiditas"),
//	R_02060101000000 ("02060101000000", "I Kuantitatif"),
	R_02060101010000 ("02060101010000", "1.  Rasio likuiditas"),
	R_02060101020000 ("02060101020000", "2.  Rasio kekayaan lancar terhadap total kewajiban"),
	R_02060101030000 ("02060101030000", "3.  Rasio kecukupan investasi kurang dari 1 tahun dibagi total kewajiban kepada pemegang polis kurang dari 1 tahun."),
	R_02060101040000 ("02060101040000", "4.  Rasio Kecukupan Investasi (RKI)"),
	R_02060101050000 ("02060101050000", "5.  Rasio pertumbuhan RKI"),
	R_02060101060000 ("02060101060000", "6.  Lock-up period asset ratio    "),
	R_02060101070000 ("02060101070000", "7.  Pertumbuhan risiko likuiditas"),
//	R_02060102000000 ("02060102000000", "II Kualitatif"),
	R_02060102010000 ("02060102010000", "1.  Jumlah, kualitas, diversifikasi dan penjualan aset dan liabilitas"),
	R_02060102020000 ("02060102020000", "2.  Risiko ketidaksesuaian antara besar dan saat jatuh tempo aset dengan besar dan saat jatuh tempo liabilitas"),
	R_02060102030000 ("02060102030000", "3.  Risiko terhadap lock-up period merupakan risiko terhadap investasi yang tidak dapat dicairkan dalam  jangka waktu tertentu"),
	R_02060102040000 ("02060102040000", "4.  Arus kas"),
	R_02060102050000 ("02060102050000", "5.  Profil aset jangka pendek"),
	R_02060102060000 ("02060102060000", "6.  Profil liabilitas jangka pendek"),
//	R_02060200000000 ("02060200000000", "Tabel II.F.2: Pedoman Penetapan Tingkat Risiko Inheren untuk Risiko Likuiditas "),
	R_02060201000000 ("02060201000000", "Tingkat Risiko Inheren untuk Risiko Likuiditas"),
//	R_02060300000000 ("02060300000000", "Tabel II.F.3: Pedoman Penetapan Kualitas Penerapan Manajemen Risiko untuk Risiko Likuiditas"),
	R_02060301000000 ("02060301000000", "Kualitas Penerapan Manajemen Risiko untuk Risiko Likuiditas"),
	;
	
	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4006PosSaAsruk0206 eEnum : ER4006PosSaAsruk0206.values()) {
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
	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 13, 14 }), 1);
	}

	public static SegmentValidation genValidationMaxLengthNumericDotNegative() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 0, 6), 8);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 13, 14 }));
	}
	
	public static SegmentValidation genValidationNumericDotNegative() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), 0, 6));
	}

	public static SegmentValidation genValidationPeringkat() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 13, 14 }), ER1099Peringkat.getPipedKey());
	}
}
