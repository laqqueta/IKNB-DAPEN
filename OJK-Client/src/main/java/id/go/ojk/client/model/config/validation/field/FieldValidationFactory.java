package id.go.ojk.client.model.config.validation.field;

import java.util.Map.Entry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import id.go.ojk.client.model.config.validation.conditional.AllExistConditional;
import id.go.ojk.client.model.config.validation.conditional.ComparisonConditional;
import id.go.ojk.client.model.config.validation.conditional.RefConditional;
import id.go.ojk.client.model.config.validation.conditional.RefLabelConditional;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.config.validation.segmen.DateFieldCompare;

public class FieldValidationFactory {

	private final static ImmutableMap<String, Class<? extends FieldValidation>> map = ImmutableMap.<String, Class<? extends FieldValidation>>builder()
			.put("amountBaseConditionFieldValidation", 	AmountBaseConditionFieldValidation.class)
			.put("collectibilityFieldValidation", 		CollectibilityFieldValidation.class)
			.put("minMaxFieldValidation", 				MinMaxFieldValidation.class)
			.put("oriCurrencyFieldValidation", 			OriCurrencyFieldValidation.class)
			.put("restructureFreqFieldValidation", 		RestructureFreqFieldValidation.class)
			.put("referenceLabelFieldValidation", 		ReferenceLabelFieldValidation.class)
			.put("newRenewalFieldValidation", 			NewRenewalFieldValidation.class)
			.put("dateFieldRelativeValidation", 		DateFieldRelativeValidation.class)
			.put("dateFieldAbsoluteValidation", 		DateFieldAbsoluteValidation.class)
			.put("yearMonthFieldRelativeValidation", 	YearMonthFieldRelativeValidation.class)
			.put("fieldSumValidation", 	SumValidation.class)
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
			
	public static FieldValidation createInstance(String name, String parameter){
		Class<? extends FieldValidation> clazz = map.get(name);
		if ( clazz != null ){
			try {
				return clazz.getConstructor(String.class).newInstance(parameter);
			} catch (Exception e) {
				throw new SlikException("fail instantiate FieldValidation " + name + "", e);
			} 
		} else {
			throw new SlikException("FieldValidation untuk " + name + " tidak ditemukan");
		}
	}
		
	public static String getFieldValidationType(FieldValidation fieldValidation){
		for (Entry<String, Class<? extends FieldValidation>> entry : map.entrySet()) {
			if ( entry.getValue().isAssignableFrom(fieldValidation.getClass()) ){
				return entry.getKey();
			}
		}
		throw new SlikException("FieldValidation type untuk " + fieldValidation.getClass() + " tidak ditemukan");
	}


//	public final static String amountBaseConditionFieldValidation 	= "amountBaseConditionFieldValidation";
//	public final static String collectibilityFieldValidation 		= "collectibilityFieldValidation";
//	public final static String minMaxFieldValidation 				= "minMaxFieldValidation";
//	public final static String oriCurrencyFieldValidation 			= "oriCurrencyFieldValidation";
//	public final static String restructureFreqFieldValidation 		= "restructureFreqFieldValidation";
//	public final static String referenceLabelFieldValidation 		= "referenceLabelFieldValidation";
//	public final static String newRenewalFieldValidation 			= "newRenewalFieldValidation";
//	
//	public final static String dateFieldRelativeValidation 			= "dateFieldRelativeValidation";
//	public final static String dateFieldAbsoluteValidation 			= "dateFieldAbsoluteValidation";
//	
//	public final static String yearMonthFieldRelativeValidation 	= "yearMonthFieldRelativeValidation";
//	
//	
//	public static FieldValidation createInstance(String name, String parameter){
//		switch (name) {
//		case amountBaseConditionFieldValidation:
//			return new AmountBaseConditionFieldValidation(parameter);
//		case collectibilityFieldValidation:
//			return new CollectibilityFieldValidation(parameter);
//		case minMaxFieldValidation:
//			return new MinMaxFieldValidation(parameter);
//		case oriCurrencyFieldValidation:
//			return new OriCurrencyFieldValidation(parameter);
//		case restructureFreqFieldValidation:
//			return new RestructureFreqFieldValidation(parameter);
//		case referenceLabelFieldValidation:
//			return new ReferenceLabelFieldValidation(parameter);
//		case newRenewalFieldValidation:
//			return new NewRenewalFieldValidation(parameter);
//		case dateFieldRelativeValidation:
//			return new DateFieldRelativeValidation(parameter);
//		case dateFieldAbsoluteValidation:
//			return new DateFieldAbsoluteValidation(parameter);
//		case yearMonthFieldRelativeValidation:
//			return new YearMonthFieldRelativeValidation(parameter);
//		default:
//			throw new SlikException("FieldValidationFactory untuk " + name + " tidak ditemukan");
//		}
//	}
//	
//	public static String getSegmentValidationType(FieldValidation fieldValidation){
//		if ( fieldValidation == null )
//			return null;
//		
//		if ( fieldValidation instanceof AmountBaseConditionFieldValidation ){
//			return amountBaseConditionFieldValidation;
//		} else if ( fieldValidation instanceof CollectibilityFieldValidation ){
//			return collectibilityFieldValidation;
//		} else if ( fieldValidation instanceof MinMaxFieldValidation ){
//			return minMaxFieldValidation;
//		} else if ( fieldValidation instanceof OriCurrencyFieldValidation ){
//			return oriCurrencyFieldValidation;
//		} else if ( fieldValidation instanceof RestructureFreqFieldValidation ){
//			return restructureFreqFieldValidation;
//		} else if ( fieldValidation instanceof ReferenceLabelFieldValidation ){
//			return referenceLabelFieldValidation;
//		} else if ( fieldValidation instanceof NewRenewalFieldValidation ){
//			return newRenewalFieldValidation;
//		} else if ( fieldValidation instanceof DateFieldRelativeValidation ){
//			return dateFieldRelativeValidation;
//		} else if ( fieldValidation instanceof DateFieldAbsoluteValidation ){
//			return dateFieldAbsoluteValidation;
//		} else if ( fieldValidation instanceof YearMonthFieldRelativeValidation ){
//			return yearMonthFieldRelativeValidation;
//		} else {
//			throw new SlikException("FieldValidation type untuk " + fieldValidation.getClass() + " tidak ditemukan");
//		}
//		
//	}


}
