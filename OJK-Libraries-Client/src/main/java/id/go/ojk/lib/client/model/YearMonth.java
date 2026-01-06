package id.go.ojk.lib.client.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import id.go.ojk.lib.client.DateUtil;
import lombok.Data;

@Data
public class YearMonth implements Comparable<YearMonth>{
	
	private int year;
	private int month;
	private LocalDate localDate;
	
	public YearMonth(int year, int month){
		this.year = year;
		this.month = month;
		initLocalDate();
	}
	
	private void initLocalDate(){
		this.localDate = LocalDate.of(this.year, this.month, 1).with(TemporalAdjusters.lastDayOfMonth());
	}
	
	public YearMonth addMonth(int monthAdd){
		YearMonth result = cloneSave();
		result.month += monthAdd;
		
		if ( result.month <= 0 ){
			result.year--;
			result.month += 12;			
		} else {
			double tmp = ((double)result.month / (double)12);
			if ( tmp > 1  ) {
				result.year += tmp;
				result.month = result.month % 12;
			} 			
		}
		
		result.initLocalDate();
		return result;
	}

	public YearMonth cloneSave() {
		return new YearMonth(year, month);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new YearMonth(year, month);
	}

	@Override
	public int compareTo(YearMonth o) {
		if(this.year > o.year){
			return 1;
		} else if ( this.year < o.year ){
			return -1;
		} else {
			if(this.month > o.month){
				return 1;
			} else if ( this.month < o.month){
				return -1;
			} else {
				return 0;
			}			
		}
	}
	
	public int monthDifference(YearMonth o){
		return (year - o.getYear()) * 12 + (month - o.getMonth());
	}
	
	public String toYYYY_MM(){
		return StringUtils.join(new DecimalFormat("0000").format(year), "-", new DecimalFormat("00").format(month));
	}
	
	public String toMMslashYYYY(){
		return StringUtils.join(new DecimalFormat("00").format(month), "/", new DecimalFormat("0000").format(year));
	}

	
	public String toYYYYDotMM(){
		return StringUtils.join(new DecimalFormat("0000").format(year), ".", new DecimalFormat("00").format(month));
	}
	
	public String toMMMM_yyyy(){
		return DateUtil.dateTimeFormatter_MMMM_yyyy.format(localDate);
	}
	
	public String toYYYYMM(){
		return StringUtils.join(new DecimalFormat("0000").format(year), new DecimalFormat("00").format(month));
	}

	//~ static factory

	/**
	 * 
	 * @param string yyyyMM
	 * @return
	 */
	public static YearMonth from(String string){
		return new YearMonth(Integer.parseInt(string.substring(0,4)), Integer.parseInt(string.substring(4,6)));
	}

	public static YearMonth from(LocalDate localDate){
		return new YearMonth(localDate.getYear(), localDate.getMonthValue());
	}

	public static YearMonth from(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return from(calendar);
	}

	public static YearMonth from(Calendar calendar){
		return new YearMonth(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);
	}
	
	public static String format(String input){
		if ( StringUtils.isEmpty(input) || input.length() < 6 ){
			return input;
		}
		return StringUtils.join(input.substring(4,6), "/", input.substring(0,4));			
	}

}
