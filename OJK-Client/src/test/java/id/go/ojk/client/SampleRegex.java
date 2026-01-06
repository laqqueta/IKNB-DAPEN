package id.go.ojk.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import id.go.ojk.client.model.config.SimpleValidation;

public class SampleRegex {
	public static void main(String[] args) {
		try {
			System.out.println("<start>");
			match();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("<end>");
		}
	}
	
	private static void match() {
		String pattern = SimpleValidation.patternAll.getPattern();
		System.out.println("pattern=" + pattern);
		Pattern p = Pattern.compile(pattern);//. represents single character  
		Matcher m = p.matcher("{}|");
		System.out.println("result=" + m.matches());
	}
}
