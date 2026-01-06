package id.go.ojk.asrjk.client.builder.field.sa.uus.reference;

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
public enum ER4105PosSaAsrju0206 implements IObject<KeyValueString> {
//	R_02060100000000 ("02060100000000", "Tabel II.F.1: Parameter atau Indikator Penilaian Risiko Inheren untuk Risiko Likuiditas"),
//	R_02060101000000 ("02060101000000", "I Kuantitatif"),
//	R_02060101010000 ("02060101010000", "1.  Quick Ratio atau Rasio kekayaan lancar terhadap kewajiban lancar"),
	R_02060101010100 ("02060101010100", "  Dana Tabarru'"),
	R_02060101010200 ("02060101010200", "  Dana Perusahaan"),
	R_02060101010300 ("02060101010300", "  Dana Investasi Peserta"),
	R_02060101020000 ("02060101020000", "2.  Rasio Kecukupan Investasi Kurang dari 1 tahun dibagi total kewajiban kepada pemegang polis kurang dari 1 Tahun"),
	R_02060101030000 ("02060101030000", "3.  Rasio Kecukupan Investasi (RKI) (investasi+kas dan bank)"),
	R_02060101040000 ("02060101040000", "4.  Pertumbuhan Rasio Kecukupan Investasi (RKI) Dana Tabarru'"),
//	R_02060101050000 ("02060101050000", "5.  Pertumbuhan risiko likuiditas (dari DTMBR, MMBR, dan PAYDI garansi)"),
	R_02060101050100 ("02060101050100", "  Dana Tabarru' (DTMBR)"),
	R_02060101050200 ("02060101050200", "  Dana Perusahaan (MMBR)"),
	R_02060101050300 ("02060101050300", "  Dana Investasi Peserta (MMBR atas paydi digaransi)"),
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
//	R_02060302000000 ("02060302000000", "Tingkat Risiko Likuiditas"),
	R_02060303000000 ("02060303000000", "Tingkat Risiko Likuiditas Net Risk"),
	R_02060400000000 ("02060400000000", "ANALISIS"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4105PosSaAsrju0206 eEnum : ER4105PosSaAsrju0206.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER4105PosSaAsrju0206.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER4105PosSaAsrju0206.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), 0, 8));
	}
	
	public static SegmentValidation genValidationMaxLengthNumericDot() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 0, 8), 10);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), 15, 17));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 15, 17), 1);
	}
	
	public static SegmentValidation genValidationPeringkat() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), 15, 17), ER1099Peringkat.getPipedKey());
	}
}
