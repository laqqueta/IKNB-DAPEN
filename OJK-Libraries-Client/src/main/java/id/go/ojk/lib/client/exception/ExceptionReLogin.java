package id.go.ojk.lib.client.exception;

import id.go.ojk.lib.client.constant.EResponseCode;

public class ExceptionReLogin extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionReLogin(String userId) {
		super(EResponseCode.RELOGIN_FAILED_1.getCode(),
				getFormattedMessage(EResponseCode.RELOGIN_FAILED_1.getMessage(), userId));
	}

}
