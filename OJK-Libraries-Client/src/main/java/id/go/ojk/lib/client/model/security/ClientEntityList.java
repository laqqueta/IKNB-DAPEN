package id.go.ojk.lib.client.model.security;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

@XStreamAlias("ArrayOfClientEntity")
public class ClientEntityList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter private List<ClientEntity> clientEntityList;
}
