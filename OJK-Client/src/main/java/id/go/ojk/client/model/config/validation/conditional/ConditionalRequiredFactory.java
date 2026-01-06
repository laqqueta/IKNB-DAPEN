package id.go.ojk.client.model.config.validation.conditional;

import java.util.Map.Entry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.config.validation.segmen.DateFieldCompare;

public class ConditionalRequiredFactory {

	private final static ImmutableMap<String, Class<? extends ConditionalRequired>> map = ImmutableMap.<String, Class<? extends ConditionalRequired>>builder()
			.put("allExistConditional", 	AllExistConditional.class)
			.put("comparisonConditional", 	ComparisonConditional.class)
			.put("refConditional", 			RefConditional.class)
			.put("refLabelConditional", 	RefLabelConditional.class)
			.build();
		
	public final static ImmutableList<Class<?>> classList = ImmutableList.<Class<?>>builder()
		.addAll(map.values())
		.add(
			DateFieldCompare.class, DateFieldCompare.RightDateField.class, AllExistConditional.class, 
			ComparisonConditional.class, RefConditional.class, RefLabelConditional.class
		)
		.build();
		
	public final static Class<?>[] clazzs = classList.toArray(new Class<?>[0]); 
			
	public final static ImmutableList<String> keyList = ImmutableList.<String>builder()
			.addAll(map.keySet())
			.build();

	public static ConditionalRequired createInstance(String name, String parameter){
		Class<? extends ConditionalRequired> clazz = map.get(name);
		if ( clazz != null ){
			try {
				return clazz.getConstructor(String.class).newInstance(parameter);
			} catch (Exception e) {
				throw new SlikException("fail instantiate ConditionalRequired " + name + "", e);
			} 
		} else {
			throw new SlikException("ConditionalRequired untuk " + name + " tidak ditemukan");
		}
	}
		
	public static String getConditionalRequiredType(ConditionalRequired conditionalRequired){
		if ( conditionalRequired == null )
			return null;

		for (Entry<String, Class<? extends ConditionalRequired>> entry : map.entrySet()) {
			if ( entry.getValue().isAssignableFrom(conditionalRequired.getClass()) ){
				return entry.getKey();
			}
		}
		throw new SlikException("ConditionalRequired type untuk " + conditionalRequired.getClass() + " tidak ditemukan");
	}
	
//	public final static String allExistConditional 		= "allExistConditional";
//	public final static String comparisonConditional 	= "comparisonConditional";
//	public final static String refConditional 			= "refConditional";
//	public final static String refLabelConditional 		= "refLabelConditional";
//
//	public static ConditionalRequired createInstance(String name, String parameter){
//		switch (name) {
//		case allExistConditional:
//			return new AllExistConditional(parameter);
//		case comparisonConditional:
//			return new ComparisonConditional(parameter);
//		case refConditional:
//			return new RefConditional(parameter);
//		case refLabelConditional:
//			return new RefLabelConditional(parameter);
//		default:
//			throw new SlikException("ConditionalRequired untuk " + name + " tidak ditemukan");
//		}
//	}
//	
//	public static String getConditionalRequiredType(ConditionalRequired conditionalRequired){
//		if ( conditionalRequired == null )
//			return null;
//		
//		if ( conditionalRequired instanceof AllExistConditional ){
//			return allExistConditional;
//		} else if ( conditionalRequired instanceof ComparisonConditional ){
//			return comparisonConditional;
//		} else if ( conditionalRequired instanceof RefConditional ){
//			return refConditional;
//		} else if ( conditionalRequired instanceof RefLabelConditional ){
//			return refLabelConditional;
//		} else {
//			throw new SlikException("ConditionalRequired type untuk " + conditionalRequired.getClass() + " tidak ditemukan");
//		}
//	}

}
