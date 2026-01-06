package id.go.ojk.client.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EVersion {
	SETUP ("clSetup"),
	METADATA ("clMetadata"),
	REFERENCES ("clReferences"),
	APPLICATION ("clApplication"),
	;
	
	@Getter
	private String id;
}
