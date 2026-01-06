package id.go.ojk.dppkk.client.builder;

import id.go.ojk.client.constant.ESector;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
	/* ===== APPLICATION =====
	 * Version 3.0.0 (25 Juni 2024)
	 */
	public static final ESector SECTOR = ESector.DPPKK;
	public static final String METADATA_VERSION = "3.0.0";
	public static final String REFERENCE_VERSION = "3.0.1";
}

/*
 * ===== REFERENCE ===== 
 * Version 3.0.0 = versi awal
 */

/*
 * ===== METADATA ===== 
 * Version 3.0.0 = versi awal
 * Version 3.0.1 = penyesuaian ID Bukti di TLR jadi 35 digit
 * Version 3.0.2 = penyesuaian validasi agar spasi dianggap sebagai karakter
 */