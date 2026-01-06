package id.go.ojk.lib.client.model.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DataType {
	all,
	all2,
	alfa,
    freeText,
	numeric,
	numericNegatif,
	
	unsignInt,
	signInt,
	decimal,
	
	alfaSpace,
	alfaNumeric,
	numericDot,
	numericDotNegatif,
	alfaNumericSpace,
	tax,

	date,
	yearMonth,
	year,
	email,
	phone,
	refTable,
	refTablePerSegment,
	constant;
	
	public static List<String> getValueList(){
		return Arrays.asList(DataType.values()).stream().map( e -> e.name()).collect(Collectors.toList());
	}

}
