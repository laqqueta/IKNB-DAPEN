package id.go.ojk.lib.client.api;

import java.io.Serializable;

import lombok.Data;

@Data
public class DtoHttpClient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int connectTimeout = 3000;
	private int readTimeout = 60000;
//	private int retry = 0;
	
}
