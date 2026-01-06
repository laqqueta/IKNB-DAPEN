package id.go.ojk.lib.client.service.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import id.go.ojk.lib.client.model.config.validation.segmen.model.CollateralRow;
import id.go.ojk.lib.client.model.config.validation.segmen.model.CreditJoinRow;
import id.go.ojk.lib.client.model.config.validation.segmen.model.GuarantorRow;
import id.go.ojk.lib.client.model.config.validation.segmen.model.ManagementRow;
import id.go.ojk.lib.client.model.config.validation.segmen.model.SummaryRefRaw;
import id.go.ojk.lib.client.service.validation.DebtorRow;

public class ValidationRelationModel {
	
	//~
	
	private HashMap<String, HashSet<String>> relationMap = new HashMap<>();

	public void put(String name, HashSet<String> relation){
		relationMap.put(name, relation);
	}

	public HashSet<String> getRelation(String key){
		return relationMap.get(key);
	}

	public boolean isRelationValid(String key, String fieldValue){
		HashSet<String> relation = getRelation(key);
		if ( relation == null )
			return false;
		return relation.contains(fieldValue);
	}

	//~  data use inter file
	
	public final ConcurrentMap<String, SummaryRefRaw> summaryRefRawMap 			= new ConcurrentHashMap<>();		//accountNumber + "#" + cif - SummaryRefRaw
	public final ConcurrentMap<String, List<ManagementRow>> managementRowRefMap	= new ConcurrentHashMap<>();		//identityNumber-ManagementRow
	public final ConcurrentMap<String, List<CreditJoinRow>> creditJoinRefMap 	= new ConcurrentHashMap<>();		//accountNumber-CreditJoinRow
	public final ConcurrentMap<String, List<CollateralRow>> collateralRowMap 	= new ConcurrentHashMap<>();		//collateralRegNo - CollateralRow
	public final ConcurrentMap<String, List<GuarantorRow>> guarantorRowMap 		= new ConcurrentHashMap<>();		//identityNumber - GuarantorRow
		
	public final Map<Integer, ConcurrentMap<String, DebtorRow>> debtorCreateStorage	= new HashMap<>();				//debtor storage number - (File seq#LineNumber)
	{
		debtorCreateStorage.put(1, new ConcurrentHashMap<>());
		debtorCreateStorage.put(2, new ConcurrentHashMap<>());
	}

}
