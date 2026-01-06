package id.go.ojk.lib.client.model;

import java.util.HashMap;
import java.util.Map;

public class MonthDate {
	
	private Map<String, String> mapMonthDate = new HashMap<String, String>();
	private String years;
	
	public MonthDate(String years) {
		this.years = years;
	}

	public Map<String, String> getMapMonthDate() {
		String[] months = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		String[] dates1 = { "31", "28", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31" };
		String[] dates2 = { "31", "29", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31" };

		int leapYear = Integer.parseInt(years) % 4;
		for (int i = 0; i < months.length; i++) {
			if (leapYear != 0) {
				mapMonthDate.put(months[i], dates1[i]);
			} else {
				mapMonthDate.put(months[i], dates2[i]);
			}
		}

		return mapMonthDate;
	}
	
	public boolean yearsIsNumeric() {
		return years.matches("[\\d]+");
	}

}
