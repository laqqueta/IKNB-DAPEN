package id.go.ojk.fink.client;

import id.go.ojk.client.constant.ESector;
import id.go.ojk.lib.client.model.constant.ConfigVersion;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
	public static final ESector SECTOR = ESector.LFINK;
	public static final String METADATA_VERSION = "1.3.1";
	public static final String REFERENCE_VERSION = "1.0.2";
	public static final String SETUP_VERSION = "1.0.0";
	public static final String APPLICATION_VERSION = "1.2.0";
	public static final String LIBRARY_VERSION = "1.0.0";
	
	public static void initAppVersion() {
		ConfigVersion.setSetupVersion(Constant.SETUP_VERSION);
		ConfigVersion.setApplicationVersion(Constant.APPLICATION_VERSION);
		ConfigVersion.setLibraryVersion(Constant.LIBRARY_VERSION);
	}
}


/**--------------------VERSION HISTORY-----------------
 *METADATA_VERSION :
 *1.0.0 = Versi awal
 *1.1.0 = Hapus validasi di 1201 (120102010000), penyesuaian validasi di 6903 (690305000000, 690314010109, 690314010209)
 *1.2.0 = pelaporan apu
 *1.3.0 = F.S.2 pelaporan apu
 *1.3.1 = pelaporan TPPU TPPT PPSPM
 *
 *REFERENCE_VERSION :
 *1.0.0 = Versi awal
 *1.0.1 = Referensi APU PPT
 *1.0.2 = Referensi TPPU TPPT PPSPM
 *
 *APPLICATION_VERSION :
 *1.0.0 = Versi awal
 *1.1.0 = Tambah fungsi deviasi dan kondisi di 6903 (690305000000, 690314010109, 690314010209)
 *1.2.0 = Update change password
 *
 *LIBRARY_VERSION :
 *1.0.0 = Versi awal
 */
	
