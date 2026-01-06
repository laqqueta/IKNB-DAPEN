package id.go.ojk.lib.client.model.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum RequiredCondition {
	M,		//Mandatory
	O, 		//Optional
	C,		//Conditional
	N;		//Harus Kosong
		
	public static List<String> getValueList(){
		return Arrays.asList(RequiredCondition.values()).stream().map( e -> e.name()).collect(Collectors.toList());
	}
}
