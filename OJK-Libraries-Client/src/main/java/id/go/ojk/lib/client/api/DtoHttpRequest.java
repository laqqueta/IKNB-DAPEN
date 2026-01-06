package id.go.ojk.lib.client.api;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class DtoHttpRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, String> mapHeader;
	private String url;
	private String content;
	private boolean contentAsFile = false;
	private String contentType;
	private String method;
	
	public boolean isGet() {
		return method.equalsIgnoreCase("GET");
	}
	
	public boolean isPost() {
		return method.equalsIgnoreCase("POST");
	}
	
	public boolean isPut() {
		return method.equalsIgnoreCase("PUT");
	}
	
	public boolean isPatch() {
		return method.equalsIgnoreCase("PATCH");
	}
	
	public boolean hasContent() {
		return content != null && !content.isEmpty();
	}
}
