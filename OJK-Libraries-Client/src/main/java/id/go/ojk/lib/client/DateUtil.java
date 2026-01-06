package id.go.ojk.lib.client;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import id.go.ojk.lib.client.exception.SlikException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

	public final static DateTimeFormatter dateTimeFormatterYYYYmmss = DateTimeFormatter.ofPattern("yyyyMMdd");
	public final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	public final static DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	public final static DateTimeFormatter dateTimeFormatterMs = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

	public final static DateTimeFormatter dateTimeFormatter_dd_MM_yyyy = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public final static DateTimeFormatter dateTimeFormatter_MMMM_yyyy = DateTimeFormatter.ofPattern("MMMM yyyy", new Locale("ID", "ID"));
	
	public final static DateTimeFormatter dateTimeFormatter_dd_MMMM_yyyy_HH_mm_ss = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss", new Locale("ID", "ID"));
	
	public static String formatdd_MMMM_yyyy_HH_mm_ss_Save(Date input){
		if ( input == null )
			return "";
		return dateTimeFormatter_dd_MMMM_yyyy_HH_mm_ss.format( DateUtil.toLocalDateTime(input));
	}
	
	public static LocalDateTime parseLocalDateTime(String input){
		return LocalDateTime.parse(input, dateTimeFormatter);
	}

	public static String format(LocalDateTime localDateTime){
		return localDateTime.format(dateTimeFormatter);
	}

	public static String formatNow(){
		return LocalDateTime.now().format(dateTimeFormatter);
	}

	public static String formatNowMs(){
		return LocalDateTime.now().format(dateTimeFormatterMs);
	}

	public static String format2(String parseLocalDateTime){
		return dateTimeFormatter2.format(parseLocalDateTime(parseLocalDateTime));
	}

	public static LocalDate toLocalDate(Date input){
		return input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static Date toDate(LocalDate localDate){
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return date;
	}
	
	public static LocalDateTime toLocalDateTime(Date input){
		return input.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static String convertFormatDate(String input){
		return 	convertFormatDate(input, dateTimeFormatter, dateTimeFormatter2);
 
	}

	public static String convertFormatDate(String input, DateTimeFormatter parseFormater, DateTimeFormatter formatFormater){
		return formatFormater.format(parseFormater.parse(input));		
	}

	
//	versionModel.setupModifiedParseProperty.set(
//			DateUtil.dateTimeFormatter2.format(
//				DateUtil.dateTimeFormatter.parse(setupBranchModified)
//			)		 
//		);

	
	public static Date max(Date ... inputs){
		Date maxDate = null;
		for (Date date : inputs) {
			if ( date == null ){
				continue;
			}
				
			if ( maxDate == null ){
				maxDate = date;
				continue;
			}
			
			if ( maxDate.before(date) ){
				maxDate = date;
			}
		}
		return maxDate;
	}
	
	public final static String[] MONTH_LONG_ID = new String[] {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"}; 
	public final static String[] MONTH_SHORT_ID = new String[] {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agt", "Sep", "Okt", "Nov", "Des"};
	
	public static String yearMonthToMMMMyyyy(String yearMonth) {
		if ( yearMonth.length() != 6 ) 
			return "";
		DateFormat sourceDateFormat = new SimpleDateFormat("yyyyMM");
		Date yearMonthDate;
		try {
			yearMonthDate = sourceDateFormat.parse(yearMonth);
			return createDateFormatID("MMMM yyyy").format(yearMonthDate);
		} catch (ParseException e) {
			throw new SlikException("Fail parse yearMonth " + yearMonth, e);
		}
	}
			
	public static DateFormat createDateFormatID(String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		
		DateFormatSymbols dateFormatSymbols = dateFormat.getDateFormatSymbols();
		
		dateFormatSymbols.setMonths(MONTH_LONG_ID);
		dateFormatSymbols.setShortMonths(MONTH_SHORT_ID);
		dateFormat.setDateFormatSymbols(dateFormatSymbols);
		
		return dateFormat;
	}
	
	//~ local data comparation
	
//	public static boolean isBefore(LocalDate localDate1, LocalDate localDate2){
//		
//	}
	
//	if ( !initialContractDateObj.isBefore(lastContractDateObj) ){
//		
//	}
	


}
