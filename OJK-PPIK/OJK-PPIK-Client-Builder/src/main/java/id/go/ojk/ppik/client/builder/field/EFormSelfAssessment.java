package id.go.ojk.ppik.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormSelfAssessment {
	SA_060100("060100", "Form 6.A - Laporan Hasil Penilaian Tingkat Kesehatan Perusahaan"),
	SA_060301("060301", "Form 6.C.1 - Penilaian Faktor Profil Risiko bagi Perusahaan"),
	SA_888888("888888", "Surat Pengantar"),
	SA_999999("999999", "Data Kualitatif"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
