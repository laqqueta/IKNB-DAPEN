package id.go.ojk.lkk.client;

import id.go.ojk.client.constant.ESector;
import id.go.ojk.lib.client.model.constant.ConfigVersion;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
/**
VERSI DI PACKAGE INI TIDAK DIPAKAI, YANG DIPAKAI DI MASING-MASING LPEI DAN PNM
**/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
	public static final ESector SECTOR = ESector.LKK;
	public static final String METADATA_VERSION = "1.0.2";
	public static final String REFERENCE_VERSION = "1.0.2";
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
 * Version 1.0.2 (13 Oktober 2025) Agar spasi tetap terbaca sebagai karakter di Class 
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
 * Version 1.0.2 (8 Desember 2025) Lapbul LPEI = Penambahan referensi form 2790 UUS kolom jenis dengan referensi Rekening Antar Kantor (RK:E71)
 * 					referensi form 2600 terkait Jenis Surat Berharga
 */

/*
 * ===== METADATA ===== 
 * Version 1.0.0 (10 September 2024) Laporan Bulanan LPEI
 * Version 1.0.1 = F.S.2 Lapbul LPEI
 * Version 1.0.2 (8 Desember 2025) Lapbul LPEI = Penyesuaian form 5200 UUS kolom jenis asuransi jadi Optional
 */
