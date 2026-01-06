package id.go.ojk.pmvs.client.builder;

import id.go.ojk.client.constant.ESector;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
	public static final ESector SECTOR = ESector.PMVS;
	public static final String METADATA_VERSION = "2.0.1";
	public static final String REFERENCE_VERSION = "2.0.0";
}
