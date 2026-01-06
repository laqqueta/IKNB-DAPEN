package id.go.ojk.client.util;

import org.junit.Test;

import id.go.ojk.lib.client.util.FormatUtil;

public class FormatUtilTest {
	@Test
	public void testFormat1(){
		String result = FormatUtil.formatWithThousandSeparator(100000012);
		System.out.println(result);
	}
}
