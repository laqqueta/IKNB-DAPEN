package id.go.ojk.conf.client.field.entity;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.security.ClientEntity;
import id.go.ojk.lib.client.model.security.ClientUser;

public enum EClientEntity implements IObject<ClientEntity> {
	ENTITY_609999 ("PD. BPR Dummy", "010201-609999", EClientUserDummy.getObjects(), "010201"),
	;

	private String entityName;
	private String fullEntityCode;
	private List<ClientUser> listClientUser;
	private String sectorCode;
	
	private EClientEntity(String entityName, String fullEntityCode, List<ClientUser> listClientUser, String sectorCode) {
		this.entityName = entityName;
		this.fullEntityCode = fullEntityCode;
		this.listClientUser = listClientUser;
		this.sectorCode = sectorCode;
	}
	
	@Override
	public ClientEntity getObject() {
		ClientEntity res = new ClientEntity();
		res.setEntityName(entityName);
		res.setFullEntityCode(fullEntityCode);
		res.setListClientUser(listClientUser);
		res.setSectorCode(sectorCode);
		return res;
	}

	public static List<ClientEntity> getObjects() {
		List<ClientEntity> res = new ArrayList<>();
		for (EClientEntity eEnum : EClientEntity.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
