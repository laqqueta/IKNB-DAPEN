package id.go.ojk.lib.client.model.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum VariableType {
	intType, longType, stringType, booleanType, enumType, localDateType;
	
	public static List<String> getValueList(){
		return Arrays.asList(VariableType.values()).stream().map( e -> e.name()).collect(Collectors.toList());
	}

}
