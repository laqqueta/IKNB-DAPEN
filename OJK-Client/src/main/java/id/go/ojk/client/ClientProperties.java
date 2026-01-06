package id.go.ojk.client;

import java.io.File;

import id.go.ojk.client.constant.ClientConstant;
import id.go.ojk.lib.client.instance.BaseProperties;

public class ClientProperties extends BaseProperties {
	public static final String VALIDATION_LOOP_DELAY = "validationLoopDelay";
	public static final String MAX_THREAD = "maxThread";
	public static final String MAX_ERROR_COUNT = "maxErrorCount";
	public static final String PWD_EXPIRATION_PERIOD = "pwdExpirationPeriod";
	public static final String CONNECT_TIMEOUT = "connectTimeout";
	public static final String READ_TIMEOUT = "readTimeout";
	private static ClientProperties instance;
	private static final String FILENAME = "resources" + File.separator + ClientConstant.CLIENT_PROPERTIES;
	
	public static ClientProperties getInstance() {
		if (instance == null) {
			instance = new ClientProperties(FILENAME);
		}
		return instance;
	}

	private ClientProperties(String fileName) {
		super(fileName);
	}
}
