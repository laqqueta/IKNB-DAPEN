package id.go.ojk.conf.client.field.entity;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.security.ClientUser;

public enum EClientUserDummy implements IObject<ClientUser> {
	USER_1 ("BPR Dummy", "a0fad6dd3a08ccb6901cde567a6031be", "bprdummy@gmail.com"),
	USER_2 ("Muhammad Amiruddin Hasan", "7a3a078d6b18ee2ab999911824a306bf", "mamiruddinhasan3@gmail.com"),
	;

	private String namaPengguna;
	private String userKey;
	private String userName;
	
	private EClientUserDummy(String namaPengguna, String userKey, String userName) {
		this.namaPengguna = namaPengguna;
		this.userKey = userKey;
		this.userName = userName;
	}
	
	@Override
	public ClientUser getObject() {
		ClientUser res = new ClientUser();
		res.setNamaPengguna(namaPengguna);
		res.setUserKey(userKey);
		res.setUserName(userName);
		return res;
	}

	public static List<ClientUser> getObjects() {
		List<ClientUser> res = new ArrayList<>();
		for (EClientUserDummy eEnum : EClientUserDummy.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
}
