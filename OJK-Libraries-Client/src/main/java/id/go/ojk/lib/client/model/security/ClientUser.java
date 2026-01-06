package id.go.ojk.lib.client.model.security;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

@XStreamAlias("ClientUser")
public class ClientUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XStreamAlias("NamaPengguna")
	@Getter @Setter private String namaPengguna;
	@XStreamAlias("UserKey")
	@Getter @Setter private String userKey;
	@XStreamAlias("UserName")
	@Getter @Setter private String userName;
}
