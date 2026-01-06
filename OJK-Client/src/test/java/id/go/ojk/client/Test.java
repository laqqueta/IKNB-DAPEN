package id.go.ojk.client;

import org.apache.commons.lang3.StringUtils;

public class Test {

	public static void main(String[] args) {
		try {
	    	String str = "|aaa";
	    	String[] res = StringUtils.split(str, "|");
//	    	String[] res = str.split("|");
	    	System.out.println(">>" + res.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
