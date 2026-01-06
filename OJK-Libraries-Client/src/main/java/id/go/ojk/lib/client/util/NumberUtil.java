package id.go.ojk.lib.client.util;

public class NumberUtil {

	public static Integer parseInteger(String value, Integer defValue ){
		try {
			return Integer.parseInt(value);	
		} catch (Throwable t){
			return defValue;
		}
	}

	public static Long parseLong(String value){
		try {
			return Long.parseLong(value);	
		} catch (Throwable t){
		}
		return null;
	}
	
	public static Double parseDouble(String value){
		try {
			return Double.parseDouble(value);	
		} catch (Throwable t){
		}
		return null;
	}

}
