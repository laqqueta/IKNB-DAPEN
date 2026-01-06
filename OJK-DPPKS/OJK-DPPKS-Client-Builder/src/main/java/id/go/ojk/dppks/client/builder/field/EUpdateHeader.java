package id.go.ojk.dppks.client.builder.field;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.client.constant.EVersion;
import id.go.ojk.dppks.client.builder.Constant;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.constant.ConfigVersion;
import id.go.ojk.lib.client.model.update.UpdateHeader;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EUpdateHeader implements IObject<UpdateHeader> {
	UPDATE_HEADER (ConfigVersion.SETUP_VERSION, Constant.METADATA_VERSION, Constant.REFERENCE_VERSION, ""),
	FTP_UPDATE_HEADER (ConfigVersion.SETUP_VERSION, Constant.METADATA_VERSION, Constant.REFERENCE_VERSION, ConfigVersion.APPLICATION_VERSION),
	;

	private String setupVersion;
	private String metadataVersion;
	private String referecesVersion;
	private String applicationVersion;
	
	@Override
	public UpdateHeader getObject() {
		UpdateHeader res = new UpdateHeader();
		res.setCreatedBy(ConfigVersion.CREATED_BY);
		res.setCreatedDatetime(ConfigVersion.CREATED_DATETIME);
		res.setVersions(getVersionMap());
		return res;
	}
	
	public String getVersion() {
		StringBuilder res = new StringBuilder();
		res.append(setupVersion).append("|");
		res.append(metadataVersion).append("|");
		res.append(referecesVersion).append("|");
		res.append(applicationVersion);
		return res.toString();
	}

	private Map<String, String> getVersionMap() {
		Map<String, String> res = new HashMap<>();
		res.put(EVersion.SETUP.getId(), setupVersion);
		res.put(EVersion.METADATA.getId(), metadataVersion);
		res.put(EVersion.REFERENCES.getId(), referecesVersion);
		if (StringUtils.isNotEmpty(applicationVersion)) {
			res.put(EVersion.APPLICATION.getId(), applicationVersion);
		}
		return res;
	}
}
