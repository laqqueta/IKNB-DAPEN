package id.go.ojk.dplkk.client.builder.field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EFormRencanaBisnis {
	RB_0100 ("0100", "Form 1. Profil Dana Pensiun"),
	RB_0200 ("0200", "Form 2. Ringkasan Eksekutif"),
	RB_0300 ("0300", "Form 3. Evaluasi atas Pelaksanaan Rencana Bisnis Periode Sebelumnya"),
	RB_0400 ("0400", "Form 4. Rencana Komposisi Investasi"),
	RB_0500 ("0500", "Form 5. Hasil Investasi"),
	RB_0600 ("0600", "Form 6. Rencana Pendanaan"),
	RB_0700 ("0700", "Form 7. Rencana Pengembangan Sumber Daya Manusia"),
	RB_0800 ("0800", "Form 8. Proyeksi LAN Untuk Dana Pensiun"),
	RB_0900 ("0900", "Form 9. Proyeksi LPAN"),
	RB_1000 ("1000", "Form 10. Asumsi Yang Digunakan"),
	RB_1100 ("1100", "Form 11. Strategi Bisnis Dana Pensiun"),
	RB_1200 ("1200", "Form 12. Rencana Pengembangan Atau Perluasan Kegiatan Usaha  (Penambahan Manfaat Selain Manfaat Pensiun) "),
	RB_1300 ("1300", "Form 13. Rencana Pengembangan dan/atau perubahan jaringan kantor atau saluran distribusi "),
	RB_1400 ("1400", "Form 14.  Rencana Pemenuhan Sumber Daya Manusia"),
	RB_1500 ("1500", "Form 15. Rencana Pengembangan Sistem Teknologi Informasi"),
	RB_9001 ("9001", "Surat Pengantar"),
	RB_9002 ("9002", "Rencana Bisnis"),
	;
	
	@Getter
	private String code;
	@Getter
	private String name;
}
