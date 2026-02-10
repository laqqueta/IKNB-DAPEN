package id.go.ojk.bpks.client.builder;

import id.go.ojk.client.constant.ESector;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
	public static final ESector SECTOR = ESector.BPKS;
	public static final String METADATA_VERSION = "1.0.0";
	public static final String REFERENCE_VERSION = "1.0.0";
}
