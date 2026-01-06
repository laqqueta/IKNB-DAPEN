package id.go.ojk.lib.client.model.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SegmentValidationType {
	R,		//Row
	P;		//Post
	
	public static List<String> getValueList(){
		return Arrays.asList(SegmentValidationType.values()).stream().map( e -> e.name()).collect(Collectors.toList());
	}

}
