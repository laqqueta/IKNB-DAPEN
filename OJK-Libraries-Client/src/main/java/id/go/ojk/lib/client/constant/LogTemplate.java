package id.go.ojk.lib.client.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogTemplate {
	public static final String STARTING_BUILDER = "Starting builder";
	public static final String STARTING_BUILDER_METADATA = "Starting metadata builder";
	public static final String STARTING_BUILDER_REFERENCE = "Starting reference builder";
	public static final String STOPPED = "Stopped";

	public static final String SESSION_2 = "Session {} will expired at {}";
	
	public static final String NULL_1 = "{} is null!!!";
	public static final String EMPTY_1 = "{} is empty!!!";
	public static final String RELOGIN_FAILED_1 = "ReLogin {} failed!!!";
}
