package id.go.ojk.conf.client.field.entity;

import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.security.ClientEntity;
import id.go.ojk.lib.client.model.security.ClientEntityList;

public enum EClientEntityList implements IObject<ClientEntityList> {
	CLIENT_ENTITY_LIST (EClientEntity.getObjects()),
	;

	private List<ClientEntity> clientEntityList;
	
	private EClientEntityList(List<ClientEntity> clientEntityList) {
		this.clientEntityList = clientEntityList;
	}
	
	@Override
	public ClientEntityList getObject() {
		ClientEntityList res = new ClientEntityList();
		res.setClientEntityList(clientEntityList);
		return res;
	}

}
