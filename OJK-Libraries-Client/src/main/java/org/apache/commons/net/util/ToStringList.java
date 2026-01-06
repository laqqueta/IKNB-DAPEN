package org.apache.commons.net.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ToStringList {

	public static List<String> convert(String string, String delimiter) {
		String[] arr = StringUtils.split(string, delimiter);
		return (arr != null ? Arrays.asList(arr) : new ArrayList<>());
	}
	
	private ToStringList() {
	}
}
