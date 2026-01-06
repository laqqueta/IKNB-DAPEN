package id.go.ojk.lib.client.model.config.validation.segmen.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder	
public class GuarantorRow {

	private String accountNumber;
	private String cif;
	private boolean creditJoin;
	
	private int rowHashCode;
	private int creditJoinRowHashCode;
	
	private int fileSeq;
	private int rowNum;

	@Tolerate
	public GuarantorRow(){
	}
		
}
