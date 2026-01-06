package id.go.ojk.conf.client.field;

import id.go.ojk.conf.client.field.entity.EClientEntityList;
import id.go.ojk.lib.client.model.security.ClientEntityList;

public enum EClientEntityFilename {
	CLIENT_ENTITY ("clientEntity.xml", EClientEntityList.CLIENT_ENTITY_LIST.getObject()),
	;

	private String filename;
	private ClientEntityList references;
	
	private EClientEntityFilename(String filename, ClientEntityList references) {
		this.filename = filename;
		this.references = references;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public ClientEntityList getReferences() {
		return references;
	}
}
