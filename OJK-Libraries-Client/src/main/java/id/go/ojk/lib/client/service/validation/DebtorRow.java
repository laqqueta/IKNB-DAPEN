package id.go.ojk.lib.client.service.validation;

import lombok.Builder;
import lombok.Getter;

@Builder
public class DebtorRow {
	@Getter private int fileSeq;
	@Getter private int lineNumber;
	@Getter private boolean hasF;
	@Getter private boolean hasM;
	
	public synchronized void setHasF(boolean hasF) {
		this.hasF = hasF;
	}
	
	public synchronized void setHasM(boolean hasM) {
		this.hasM = hasM;
	}
}
