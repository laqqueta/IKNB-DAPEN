package id.go.ojk.dppks.client.builder;

import id.go.ojk.client.constant.ESector;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
	/* ===== APPLICATION =====
	 * Version 3.0.0 (25 Juni 2024)
	 */
	public static final ESector SECTOR = ESector.DPPKS;
	public static final String METADATA_VERSION = "2.1.2";
	public static final String REFERENCE_VERSION = "2.1.0";
}


/* ===== REFERENCE =====
 * Version 1.0.0 
 * 	Rencana Bisnis DPPKS
 * Version 2.1.0 
 * 	Tindak Lanjut Rekomendasi Hasil Pemeriksaan Langsung DPPKS
 */

/* ===== METADATA =====
 * Version 1.0.0 
 * 	Rencana Bisnis DPPKS
 * Version 2.1.0 
 * 	Tindak Lanjut Rekomendasi Hasil Pemeriksaan Langsung DPPKS
 * Version 2.1.1
 * 	penyesuaian ID Bukti di TLR jadi 35 digit
 * Version 2.1.2
 * perbaikan tahun di form 0100 bisa yyyy dan form 0801 bisa +/-
 */
