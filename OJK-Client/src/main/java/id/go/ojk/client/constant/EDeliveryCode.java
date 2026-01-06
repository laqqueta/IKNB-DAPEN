package id.go.ojk.client.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EDeliveryCode {
	RUTIN ("R", "Rutin"),
	KOREKSI ("K", "Koreksi"),
	;
	@Getter
	private String code;
	@Getter
	private String name;
}
