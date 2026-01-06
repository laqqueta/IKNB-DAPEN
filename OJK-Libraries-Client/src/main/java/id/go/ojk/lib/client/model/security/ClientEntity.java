package id.go.ojk.lib.client.model.security;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

@XStreamAlias("ClientEntity")
public class ClientEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XStreamAlias("EntityName")
	@Getter
	@Setter
	private String entityName;
	@XStreamAlias("FullEntityCode")
	@Getter
	@Setter
	private String fullEntityCode;
	@XStreamAlias("ListClientUser")
	@Getter
	@Setter
	private List<ClientUser> listClientUser;
	@XStreamAlias("SectorCode")
	@Getter
	@Setter
	private String sectorCode;
	
	public String getEntityCode() {
		String[] parts = StringUtils.split(fullEntityCode, "-");
		return parts != null && parts.length > 1 ? parts[1] : "";
	}
}
