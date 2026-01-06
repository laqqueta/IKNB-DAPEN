package id.go.ojk.lib.client.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class FormatUtil {

	public static DecimalFormatSymbols getIDDecimalFormatSymbols(){
		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setCurrencySymbol("Rp. ");
		decimalFormatSymbols.setMonetaryDecimalSeparator(',');
		decimalFormatSymbols.setGroupingSeparator('.');
		return decimalFormatSymbols;
	}

	public static String formatWithThousandSeparator(Number input){
		if ( input == null )
			return "";
		return getWithThousandSeparator().format(input);
	}

	public static DecimalFormat getWithThousandSeparator(){
		DecimalFormat format = new DecimalFormat("###,###", getIDDecimalFormatSymbols());
		return format;
	}

	public static DecimalFormat getIdDecimalFormat(){
		DecimalFormat format = new DecimalFormat("", getIDDecimalFormatSymbols());
		return format;
	}
	
	public static String maskingPassword(String text) {
		String password = text;
		StringBuffer maskPassword = new StringBuffer();
		for (int i = 0; i < password.length(); i++) {
			if (i == 0 || i == (password.length()-1) || i == (password.length()-2)) {
				maskPassword.append(password.charAt(i));
			} else {
				maskPassword.append("*");
			}
		}
		return maskPassword.toString();		
	}
}
