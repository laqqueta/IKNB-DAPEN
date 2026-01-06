package id.go.ojk.lib.client.api;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class DtoHttpResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, String> mapHeader;
	private String content;
	private String contentType;
	private int responseCode = 500;

}
