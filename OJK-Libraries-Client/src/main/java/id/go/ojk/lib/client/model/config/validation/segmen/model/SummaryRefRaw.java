package id.go.ojk.lib.client.model.config.validation.segmen.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class SummaryRefRaw {

	private String facilityType;
	private String startYearMonth;
	private String endYearMonth;
	
	private String operation;
	
	@Tolerate
	public SummaryRefRaw(){
	}
	
}
