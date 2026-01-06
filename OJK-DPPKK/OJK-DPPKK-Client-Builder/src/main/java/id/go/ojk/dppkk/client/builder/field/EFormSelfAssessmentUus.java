package id.go.ojk.dppkk.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormSelfAssessmentUus {
	SA_0100 ("0100", "Form 1. Laporan Hasil Penilaian Tingkat Kesehatan Dana Pensiun"),
	SA_0200 ("0200", "Form 2. Penilaian Faktor Tata Kelola Perusahaan yang Baik Bagi Dana Pensiun"),
	SA_0301 ("0301", "Form 3. Penilaian Faktor Profil Risiko bagi Dana Pensiun - Peringkat"),
	SA_0302 ("0302", "Form 3. Penilaian Faktor Profil Risiko bagi Dana Pensiun - Analisis Individu"),
	SA_0303 ("0303", "Form 3. Penilaian Faktor Profil Risiko bagi Dana Pensiun - Analisis Konsolidasi"),
	SA_0400 ("0400", "Form 4. Penilaian Faktor Rentabilitas"),
	SA_0500 ("0500", "Form 5. Penilaian Faktor Pendanaan"),
	SA_8888 ("8888", "SURAT PENGANTAR"),
	SA_9999 ("9999", "LAPORAN SELF ASSESSMENT KUALITATIF"),
	;

	@Getter
	private String code;
	@Getter
	private String name;
}
