package id.go.ojk.pnjk.client;

import id.go.ojk.client.constant.ESector;
import id.go.ojk.lib.client.model.constant.ConfigVersion;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
	public static final ESector SECTOR = ESector.PNJK;
	public static final String METADATA_VERSION = "1.0.0";
	public static final String REFERENCE_VERSION = "1.0.0";
	public static final String SETUP_VERSION = "1.0.0";
	public static final String APPLICATION_VERSION = "1.0.0";
	public static final String LIBRARY_VERSION = "1.0.0";

	public static void initAppVersion() {
		ConfigVersion.setSetupVersion(Constant.SETUP_VERSION);
		ConfigVersion.setApplicationVersion(Constant.APPLICATION_VERSION);
		ConfigVersion.setLibraryVersion(Constant.LIBRARY_VERSION);
	}
}
