package id.go.ojk.pa.client.builder.field.reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.conf.client.field.reference.ER1015Dati1;
import id.go.ojk.conf.client.field.reference.ER1016Dati2;
import id.go.ojk.conf.client.field.reference.ER1162Available;
import id.go.ojk.conf.client.field.reference.ER1163SandiBank;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import id.go.ojk.lib.client.model.reference.ReferenceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EHeaderMetadataShared implements IObject<ReferenceMetadata> {
	R000 (ER1015Dati1.getRefNumber(), ER1015Dati1.getName(), ER1015Dati1.getObjects()),
	R001 (ER1016Dati2.getRefNumber(), ER1016Dati2.getName(), ER1016Dati2.getObjects()),
	R002 (ER1162Available.getRefNumber(), ER1162Available.getName(), ER1162Available.getObjects()),
	R003 (ER1163SandiBank.getRefNumber(), ER1163SandiBank.getName(), ER1163SandiBank.getObjects()),
	;

	@Getter
	private int number;
	private String name;
	private List<KeyValueString> references;

	public String getFileName() {
		StringBuilder res = new StringBuilder("R");
		res.append(number);
		res.append(name);
		res.append(".xml");
		return res.toString();
	}

	public String getDescription() {
		return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(name), " ");
	}

	@Override
	public ReferenceMetadata getObject() {
		ReferenceMetadata res = new ReferenceMetadata(number, name, ReferenceType.keyValue, getDescription(), "");
		res.setPerSegment(false);
		res.setLabel1Map(null);
		return res;
	}

	public static List<ReferenceMetadata> getObjects() {
		List<ReferenceMetadata> res = new ArrayList<>();
		for (EHeaderMetadataShared eEnum : EHeaderMetadataShared.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static Map<String, List<KeyValueString>> getMap() {
		Map<String, List<KeyValueString>> res = new HashMap<>();
		for (EHeaderMetadataShared eEnum : EHeaderMetadataShared.values()) {
			res.put(eEnum.getFileName(), eEnum.references);
		}
		return res;
	}
}
