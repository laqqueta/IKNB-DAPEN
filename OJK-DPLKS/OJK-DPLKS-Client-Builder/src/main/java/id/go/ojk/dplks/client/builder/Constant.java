package id.go.ojk.dplks.client.builder;

import id.go.ojk.client.constant.ESector;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
	/* ===== APPLICATION =====
	 * Version 3.0.0 (25 Juni 2024)
	 */
	public static final ESector SECTOR = ESector.DPLKS;
	public static final String METADATA_VERSION = "3.0.0";
	public static final String REFERENCE_VERSION = "3.0.2";
}


/* ===== REFERENCE =====
 * Version 1.0.0 
 * 	Rencana Bisnis DPLKS
 * Version 2.0.0 
 * 	APU PPT DPLKS
 * Version 3.0.0 
 * 	Tindak Lanjut Rekomendasi Hasil Pemeriksaan Langsung DPLKS
 */

/* ===== METADATA =====
 * Version 1.0.0 
 * 	Rencana Bisnis DPLKS
 * Version 2.0.0 
 * 	APU PPT DPLKS
 * Version 3.0.0 
 * 	Tindak Lanjut Rekomendasi Hasil Pemeriksaan Langsung DPLKS
 * Version 3.0.1
 *  Penyesuaian ID Bukti di TLR jadi 35 digit
 *  Version 3.0.2
 *  perbaikan tahun di form 0100 bisa yyyy
 */

