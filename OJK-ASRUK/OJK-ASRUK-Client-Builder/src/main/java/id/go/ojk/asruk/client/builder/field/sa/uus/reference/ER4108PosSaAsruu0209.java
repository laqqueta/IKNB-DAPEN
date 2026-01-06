package id.go.ojk.asruk.client.builder.field.sa.uus.reference;

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
public enum ER4108PosSaAsruu0209 implements IObject<KeyValueString> {
//	R_02090100000000 ("02090100000000", "Tabel II.I.1: Parameter atau Indikator Penilaian Risiko Inheren untuk Risiko Reputasi"),
//	R_02090101000000 ("02090101000000", "I Kuantitatif"),
	R_02090101010000 ("02090101010000", "1.  Rasio jumlah pengaduan terhadap total polis"),
	R_02090101020000 ("02090101020000", "2.  Rasio tindak lanjut pengaduan terhadap jumlah pengaduan"),
	R_02090101030000 ("02090101030000", "3.  Frekuensi atas pemberitaan negatif tentang Perusahaan dalam 1 tahun"),
//	R_02090102000000 ("02090102000000", "II Kualitatif"),
//	R_02090102010000 ("02090102010000", "1.  Pengaruh reputasi pemilik dan grup"),
	R_02090102010100 ("02090102010100", "a. Kredibilitas pemilik dan Perusahaan terkait"),
	R_02090102010200 ("02090102010200", "b. Kejadian reputasi (reputational event) pada pemilik dan Perusahaan terkait."),
//	R_02090102020000 ("02090102020000", "2.  Pelanggaran etika bisnis"),
	R_02090102020100 ("02090102020100", "Pelanggaran etika terlihat antara lain melalui: a. Transparansi informasi keuangan; dan b. Kerjasama bisnis dengan pemangku kepentingan lain. c. Praktik kecurangan/fraud yang dilakukan oleh SDM Perusahaan. d. Transparansi pemasaran produk. e. Penjualan produk asuransi tanpa izin OJK."),
//	R_02090102030000 ("02090102030000", "3.  Kompleksitas produk dan kerja sama bisnis"),
	R_02090102030100 ("02090102030100", "a. Jumlah dan tingkat penggunaan pemegang polis/tertanggung dan/atau peserta atas produk Perusahaan dan Unit Syariah yang kompleks"),
	R_02090102030200 ("02090102030200", "b. Jumlah dan materialitas kerjasama Perusahaan dan Unit Syariah dengan mitra bisnis."),
//	R_02090102040000 ("02090102040000", "4.  Penerapan strategi branding"),
	R_02090102040100 ("02090102040100", "a. Kesesuaian strategi branding Perusahaan dan Unit Syariah dengan visi misi dan kompleksitas bisnis Perusahaan dan Unit Syariah."),
	R_02090102040200 ("02090102040200", "b. Adanya evaluasi atas penerapan strategi branding Perusahaan dan Unit Syariah."),
//	R_02090102050000 ("02090102050000", "5.  Materialitas pengaduan pemegang polis, tertanggung, dan/atau peserta"),
	R_02090102050100 ("02090102050100", "a. Frekuensi pengaduan pemegang polis, tertanggung, dan/atau peserta."),
	R_02090102050200 ("02090102050200", "b. Materialitas keluhan pemegang polis, tertanggung, dan/atau peserta."),
//	R_02090102060000 ("02090102060000", "6.  Eksposur pemberitaan negatif Perusahaan dan Unit Syariah"),
	R_02090102060100 ("02090102060100", "a. materialitas pemberitaan negatif tentang Perusahaan dan Unit Syariah "),
	R_02090102060200 ("02090102060200", "b. jenis media dan ruang lingkup pemberitaan."),
	R_02090102060300 ("02090102060300", "c. media relations dan media monitoring pemberitaan"),
//	R_02090200000000 ("02090200000000", "Tabel II.I.2: Tingkat Risiko Inheren untuk Risiko Reputasi "),
	R_02090201000000 ("02090201000000", "Tingkat Risiko Inheren untuk Risiko Reputasi"),
//	R_02090300000000 ("02090300000000", "Tabel II.I.3: Kualitas Penerapan Manajemen Risiko untuk Risiko Reputasi"),
	R_02090301000000 ("02090301000000", "Kualitas Penerapan Manajemen Risiko untuk Risiko Reputasi"),
//	R_02090302000000 ("02090302000000", "Tingkat Risiko Reputasi"),
	R_02090303000000 ("02090303000000", "Tingkat Risiko Reputasi Net Risk"),
	R_02090400000000 ("02090400000000", "ANALISIS"),
	;
	
	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4108PosSaAsruu0209 eEnum : ER4108PosSaAsruu0209.values()) {
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

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), 0, 1));
	}
	
	public static SegmentValidation genValidationMaxLengthNumericDot() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 0, 1), 10);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 15, 16, 17 }));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric1() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 2 }), 10);
	}

	public static SegmentValidation genValidationMaxLengthNumeric2() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 15, 17), 1);
	}
	
	public static SegmentValidation genValidationPeringkat() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), 15, 17), ER1099Peringkat.getPipedKey());
	}
}
