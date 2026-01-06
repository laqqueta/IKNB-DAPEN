package id.go.ojk.client.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EPeriodTypeCode {
	ANNUAL ("A", "Annual"),
	SEMESTER ("S", "Semester"),
	MONTHLY ("M", "Monthly"),
	INSIDENTAL ("I", "Insidental"),
	;
	@Getter
	private String code;
	@Getter
	private String name;
}
