package id.go.ojk.lib.client.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoVersion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String setup;
	private String metadata;
	private String reference;
	private String application;

}
