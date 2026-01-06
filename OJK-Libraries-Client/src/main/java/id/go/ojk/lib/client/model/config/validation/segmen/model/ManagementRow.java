package id.go.ojk.lib.client.model.config.validation.segmen.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder	
public class ManagementRow {

	//private Double shareOwnership;
	private BigDecimal shareOwnership;
	private String cif;
	private boolean active;
	private int rowHashCode;
	
	private int fileSeq;
	private int rowNum;

	@Tolerate
	public ManagementRow(){
	}
		
}
