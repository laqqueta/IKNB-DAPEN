package id.go.ojk.lib.client.model.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum UniqueType {
	N,					//Not Unique
	U,					//Unique
	D;					//Unique Disticnt
	
	public static List<String> getValueList(){
		return Arrays.asList(UniqueType.values()).stream().map( e -> e.name()).collect(Collectors.toList());
	}

}
