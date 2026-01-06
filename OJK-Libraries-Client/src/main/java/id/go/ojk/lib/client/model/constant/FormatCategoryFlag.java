package id.go.ojk.lib.client.model.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum FormatCategoryFlag {
	N,		//Normal
	M;		//Migration
	
	public static List<String> getValueList(){
		return Arrays.asList(FormatCategoryFlag.values()).stream().map( e -> e.name()).collect(Collectors.toList());
	}
}
