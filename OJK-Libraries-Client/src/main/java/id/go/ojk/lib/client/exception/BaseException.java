package id.go.ojk.lib.client.exception;

import org.apache.commons.lang3.StringUtils;

public class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String code;

	public BaseException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public BaseException(String code, String message) {
		super(message);
		this.code = code;
	}

	public BaseException(String message) {
		this("", message);
	}

	public String getCode() {
		return code;
	}

	protected static String getFormattedMessage(String pattern, Object... params) {
		for (int i = 0; i < params.length; i++) {
			if (!pattern.contains("{}")) {
				return pattern;
			}
			pattern = StringUtils.replaceOnce(pattern, "{}", String.valueOf(params[i]));
		}
		return pattern;
	}
}
