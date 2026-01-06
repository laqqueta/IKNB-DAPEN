package id.go.ojk.lib.client.model.constant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigVersion {
//	private static final int TYPE = 1;
	/**versi selain PPI dan PNM**/
//	public static String SETUP_VERSION		= TYPE == 0 ? "2.0.0" : "1.0.0";
//	public static String APPLICATION_VERSION	= TYPE == 0 ? "3.3.3" : "1.0.0";
//	public static String LIBRARY_VERSION		= TYPE == 0 ? "2.0.0" : "1.0.0";
	public static String SETUP_VERSION		= "2.0.0";
	public static String APPLICATION_VERSION	= "4.1.5";
	public static String LIBRARY_VERSION		= "2.0.0";
	/**versi PPI**/
//	public static final String SETUP_VERSION		= "1.0.0";
//	public static final String APPLICATION_VERSION	= "1.0.0";
//	public static final String LIBRARY_VERSION		= "1.0.0";
	
	public static final String CREATED_BY = "APOLO-Team";
	public static final String CREATED_DATETIME = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
	public static final String APP_BUILD_DATE		= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));//"2020/03/31 15:00";
	public static final String APP_BUILD_DATE_PROD	= "Update Version " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMMMM yyyy"));
	
	public static final Boolean DEVEL_ROOT_FTP		= false; // False jika menggunakan server production
//	public static final Boolean DEVEL_ROOT_FTP		= true; // True jika menggunakan server devel
	
	
	/* ===== APPLICATION =====
	 * Version 3.3.3 (28 Maret 2022)
	 * Version 4.0.0 (5 Februari 2024) penambahan UUS di Asuransi dan DPPK dan Fintech
	 * Version 4.1.0 (28 Februari 2025) penambahan Polis Asuransi
	 * Version 4.1.1 (18 Maret 2025) penambahan fungsi resume data besar dan perbaikan bug progress bar
	 * Version 4.1.2 (30 April 2025) perbaikan validasi antar form NIK dan Nomor Polis Asuransi dan perbaikan securityService agar login online gagal jika pwd = email
	 * Version 4.1.3 (20 Mei 2025) penambahan F.S.2 Polis Asuransi
	 * Version 4.1.4 (22 Juni 2025) perbaikan Jiwa UUS kolom NIK/NPWP bisa huruf dan angka, perbaikan CRLF, jumlah error view default maks 500,
	 * Version 4.1.5 (06 November 2025) Implementasi FS2 Laporan Bulanan (PNJK & PNJS)
	*/
	
	/* ===== SETUP =====
	 * Version 2.0.0 (28 Maret 2022)
	 * Version 2.1.0 (28 Februari 2025) penambahan Polis Asuransi
	 * 
	*/
	
	/* ===== LIBRARY =====
	 * Version 2.0.0 (28 Maret 2022)
	 * Version 2.1.0 (28 Februari 2025) penambahan Polis Asuransi
	*/
	
	public static void setSetupVersion(String version) {
		SETUP_VERSION = version;
	}
	
	public static void setApplicationVersion(String version) {
		APPLICATION_VERSION = version;
	}
	
	public static void setLibraryVersion(String version) {
		LIBRARY_VERSION = version;
	}
}
