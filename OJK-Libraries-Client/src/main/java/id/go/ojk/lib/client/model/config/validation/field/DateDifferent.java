package id.go.ojk.lib.client.model.config.validation.field;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.CollectionUtil;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * dd|MM|yyyy
 * @author PC
 *
 */
@Data
@Builder
public class DateDifferent {
	
	private int year;
	private int month;
	private int day;
	
	@Tolerate
	public DateDifferent(){
	}
	
	public static DateDifferent fromString(String parameter){
		if ( StringUtils.isEmpty(parameter) )
			return null;
		
		int[] parameters = CollectionUtil.toIntArray(parameter);
		
		if ( parameters.length != 3 )
			return null;
		
		return DateDifferent.builder()
				.year(parameters[2])
				.month(parameters[1])
				.day(parameters[0])
				.build();
	}
	
	public LocalDate applyDifference(LocalDate localDate){
		LocalDate result = localDate.plusDays(day).plusMonths(month).plusYears(year);
		return result;
	}
	
}
