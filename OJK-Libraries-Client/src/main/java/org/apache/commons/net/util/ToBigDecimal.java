package org.apache.commons.net.util;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ToBigDecimal {

	public static BigDecimal convert(String str) {
		BigDecimal res = BigDecimal.ZERO;
		try {
			res = new BigDecimal(str);
		} catch (Exception e) {
		}
		return res;
	}

	public static BigDecimal convert(String str, int defaultValue) {
		BigDecimal res = BigDecimal.ZERO;
		try {
			res = new BigDecimal(str);
		} catch (Exception e) {
			res = new BigDecimal(defaultValue);
		}
		return res;
	}
}
