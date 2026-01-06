package id.go.ojk.ppik.client;

import id.go.ojk.client.constant.ESector;
import id.go.ojk.lib.client.model.constant.ConfigVersion;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
	public static final ESector SECTOR = ESector.PPIK;
	public static final String METADATA_VERSION = "2.0.0";
	public static final String REFERENCE_VERSION = "2.0.0";
	public static final String SETUP_VERSION = "2.0.0";
	public static final String APPLICATION_VERSION = "2.0.0";
	public static final String LIBRARY_VERSION = "2.0.0";

	public static void initAppVersion() {
		ConfigVersion.setSetupVersion(Constant.SETUP_VERSION);
		ConfigVersion.setApplicationVersion(Constant.APPLICATION_VERSION);
		ConfigVersion.setLibraryVersion(Constant.LIBRARY_VERSION);
	}
}

/* ===== APPLICATION =====
 * Version 1.0.0 (25 Juni 2024)
 * 	Laporan Bulanan PPI
 * Version 2.0.0 (10 September 2024)
 * 	TKS PPI
 */

/* ===== LIBRARY =====
 * Version 1.0.0 (25 Juni 2024)
 * 	Laporan Bulanan PPI
 * Version 2.0.0 (10 September 2024)
 * 	TKS PPI
 */

/* ===== SETUP =====
 * Version 1.0.0 (25 Juni 2024)
 * 	Laporan Bulanan PPI
 * Version 2.0.0 (10 September 2024)
 * 	TKS PPI
 */

/* ===== REFERENCE =====
 * Version 1.0.0 (25 Juni 2024)
 * 	Laporan Bulanan PPI
 * Version 2.0.0 (10 September 2024)
 * 	TKS PPI
 */

/* ===== METADATA =====
 * Version 1.0.0 (25 Juni 2024)
 * 	Laporan Bulanan PPI
 * Version 2.0.0 (10 September 2024)
 * 	TKS PPI
 */
