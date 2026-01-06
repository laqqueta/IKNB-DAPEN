package id.go.ojk.lib.client.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EResponseCode {
	SUCCEED ("0000", "Succeed"),
	FAILED ("1000", "Failed"),
	NULL_1 ("1001", LogTemplate.NULL_1),
	EMPTY_1 ("1002", LogTemplate.EMPTY_1),
	RELOGIN_FAILED_1 ("1100", LogTemplate.RELOGIN_FAILED_1),
	;
	
	private String code;
	private String message;
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
