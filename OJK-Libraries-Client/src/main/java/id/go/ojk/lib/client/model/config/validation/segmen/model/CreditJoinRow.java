package id.go.ojk.lib.client.model.config.validation.segmen.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder	
public class CreditJoinRow {

	private String cif;
	private Integer sequence;
	//private boolean activeAccount;
	private String conditionCode;
	private int rowHashCode;
	
	private int fileSeq;
	private int rowNum;
	
	@Tolerate
	public CreditJoinRow(){
	}
		
}
