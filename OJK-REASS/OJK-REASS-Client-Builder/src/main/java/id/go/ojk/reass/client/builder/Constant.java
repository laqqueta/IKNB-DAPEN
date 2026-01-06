package id.go.ojk.reass.client.builder;

import id.go.ojk.client.constant.ESector;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constant {
	public static final ESector SECTOR = ESector.REASS;
	public static final String METADATA_VERSION = "2.1.5";
	public static final String REFERENCE_VERSION = "2.1.2";
}
