package id.go.ojk.lpei.client;

import id.go.ojk.client.constant.ESector;
import id.go.ojk.lib.client.model.constant.ConfigVersion;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
	public static final ESector SECTOR = ESector.LPEIG;
	public static final String METADATA_VERSION = "1.0.2";
	public static final String REFERENCE_VERSION = "1.0.4";
	public static final String SETUP_VERSION = "1.0.0";
	public static final String APPLICATION_VERSION = "1.0.2";
	public static final String LIBRARY_VERSION = "1.0.0";

	public static void initAppVersion() {
		ConfigVersion.setSetupVersion(Constant.SETUP_VERSION);
		ConfigVersion.setApplicationVersion(Constant.APPLICATION_VERSION);
		ConfigVersion.setLibraryVersion(Constant.LIBRARY_VERSION);
	}
}
/* versi di masing-masing project dibawah OJK-LKK sudah tidak dipakai lagi, dipakai ke induknya OJK-LKK
 * ===== APPLICATION ===== 
 * Version 1.0.0 (10 September 2024) Laporan Bulanan LPEI
 * Version 1.0.1 (28 Juli 2025) Pemisahan LPEI dan PNM di LKK
 */

/*
 * ===== LIBRARY ===== 
 * Version 1.0.0 (10 September 2024) Laporan Bulanan LPEI
 */

/*
 * ===== SETUP =====
 * Version 1.0.0 (10 September 2024) Laporan Bulanan LPEI
 */

/*
 * ===== REFERENCE ===== 
 * Version 1.0.0 (10 September 2024) Laporan Bulanan LPEI
 * Version 1.0.1 = F.S.2 Lapbul LPEI
 * Version 1.0.2 = Penyesuaian Versi Penempatan Dana Form 2050
 * Version 1.0.3 = Penambahan referensi form 2790 UUS kolom jenis dengan referensi Rekening Antar Kantor (RK:E71)
 * 					referensi form 2600 terkait Jenis Surat Berharga
 * Version 1.0.4 = Perbaikan referensi ER1119Kualitas harusnya dihilangkan 1 di belakang
 */

/*
 * ===== METADATA ===== 
 * Version 1.0.0 (10 September 2024) Laporan Bulanan LPEI
 * Version 1.0.1 = F.S.2 Lapbul LPEI
 * Version 1.0.2 = Penyesuaian form 5200 UUS kolom jenis asuransi jadi Optional, form 2790 tanggal mulai selesai opsional
 */
