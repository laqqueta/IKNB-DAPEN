package id.go.ojk.client.model.config.validation.segmen;

import java.util.Map.Entry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import id.go.ojk.client.model.config.validation.conditional.AllExistConditional;
import id.go.ojk.client.model.config.validation.conditional.ComparisonConditional;
import id.go.ojk.client.model.config.validation.conditional.RefConditional;
import id.go.ojk.client.model.config.validation.conditional.RefLabelConditional;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.config.validation.segmen.DateFieldCompare;

public class SegmentValidationFactory {
	
	//special 
	public final static String uniqueCombineField 			= "uniqueCombineField";

	private final static ImmutableMap<String, Class<? extends SegmentValidation>> map = ImmutableMap.<String, Class<? extends SegmentValidation>>builder()
		.put("dateMatrixSegmentValidation", 		DateMatrixSegmentValidation.class)
		.put("contractDateValidation", 				ContractDateValidation.class)
		.put("overdueValidation", 					OverdueValidation.class)
		.put("k01SegmentValidation", 				K01SegmentValidation.class)
		.put("establismentDateValidation", 			EstablismentDateValidation.class)
		.put("uniqueParipasuValidation", 			UniqueParipasuValidation.class)		
		.put("collectRestrucValidation",			CollectRestrucValidation.class)

		.put("m01SegmentValidationRaw", 			M01SegmentValidation.class)
		.put("m01PostSegmentValidation", 			M01PostSegmentValidation.class)

		.put("f02SegmentValidationRaw", 			F02SegmentValidation.class)
		.put("f02PostSegmentValidation", 			F02PostSegmentValidation.class)

		.put("a01SegmentValidation", 				A01SegmentValidation.class)
		.put("a01PostSegmentValidation", 			A01PostSegmentValidation.class)

		.put("p01SegmentValidation", 				P01SegmentValidation.class)
		.put("p01PostSegmentValidation", 			P01PostSegmentValidation.class)
		
		.put("t01SegmentValidation", 				T01SegmentValidation.class)
		.put("t01PostSegmentValidation", 			T01PostSegmentValidation.class)

		.put("refForSummaryRaw", 					RefForSummaryRaw.class)
		.put("s01SegmentValidationRaw", 			S01SegmentValidationRaw.class)
		.put("s01PostSegmentValidation", 			S01PostSegmentValidation.class)
		
		.put("refAccnumCifSegfactype", 				RefAccnumCifSegfactype.class)
		
		.put("cancelFacilityValidation", 			CancelFacilityValidation.class)

		.put("debtorCreateCollector", 				DebtorCreateCollector.class)
		.put("debtorCreateFacilityCheck", 			DebtorCreateFacilityCheck.class)
		.put("debtorCreateFacilityPostCheck", 		DebtorCreateFacilityPostCheck.class)

		.put("debtorCreateMgnCheck", 				DebtorCreateMgnCheck.class)
		.put("debtorCreateMgnPostCheck", 			DebtorCreateMgnPostCheck.class)

		.put("debtorCreateFinRptCheck", 			DebtorCreateFinRptCheck.class)
		.put("emptyPostSegmentVal", 				EmptyPostSegmentVal.class)
		.put("setFinishPostSegmentValidation", 		SetFinishPostSegmentValidation.class)

		.put("restructContractDateValidation", 		RestructContractDateValidation.class)

		.put("segmentSumValidation", 				SumValidation.class)
		.put("segmentSumFormValidation", 			SumFormValidation.class)
		.put("segmentRatioValidation", 				RatioValidation.class)
		
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
		.add(uniqueCombineField)
		.build();
	
	public static SegmentValidation createInstance(String name, String parameter){
		Class<? extends SegmentValidation> clazz = map.get(name);
		if ( clazz != null ){
			try {
				return clazz.getConstructor(String.class).newInstance(parameter);
			} catch (Exception e) {
				throw new SlikException("fail instantiate SegmentValidation " + name + "", e);
			} 
		} else {
			throw new SlikException("SegmentValidation untuk " + name + " tidak ditemukan");
		}
	}
	
	public static String getSegmentValidationType(SegmentValidation segmentValidation){
		for (Entry<String, Class<? extends SegmentValidation>> entry : map.entrySet()) {
			if ( entry.getValue().isAssignableFrom(segmentValidation.getClass()) ){
				return entry.getKey();
			}
		}
		throw new SlikException("SegmentValidation type untuk " + segmentValidation.getClass() + " tidak ditemukan");
	}

}
