package id.go.ojk.asrus.client.builder.field.setup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ESetupKeyValueStringFilename {
	R3("R3Branch.xml", ER3Branch.getObjects()),;

	@Getter
	private String filename;
	private List<KeyValueString> references;

	public List<KeyValueString> getReferences() {
		return references;
	}

	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (ESetupKeyValueStringFilename eEnum : ESetupKeyValueStringFilename.values()) {
			res.put(eEnum.filename, eEnum.references);
		}
		return res;
	}
}
