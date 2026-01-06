package id.go.ojk.lib.client.model.config.validation.field;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.CollectionUtil;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * MM|yyyy
 *
 */
@Data
@Builder
public class YearMonthDifferent {
	
	private int year;
	private int month;
	
	@Tolerate
	public YearMonthDifferent(){
	}
	
	public static YearMonthDifferent fromString(String parameter){
		if ( StringUtils.isEmpty(parameter) )
			return null;
		
		int[] parameters = CollectionUtil.toIntArray(parameter);
		
		if ( parameters.length != 2 )
			return null;
		
		return YearMonthDifferent.builder()
				.year(parameters[1])
				.month(parameters[0])
				.build();
	}
	
	public LocalDate applyDifference(LocalDate localDate){
		LocalDate result = localDate.plusMonths(month).plusYears(year);
		return result;
	}
	
}
