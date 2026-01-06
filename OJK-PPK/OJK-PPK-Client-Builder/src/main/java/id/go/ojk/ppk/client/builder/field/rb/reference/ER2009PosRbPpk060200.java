package id.go.ojk.ppk.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2009PosRbPpk060200 implements IObject<KeyValueString> {
	R_06020100000000 ("06020100000000", "Modal Disetor Awal"),
	R_06020200000000 ("06020200000000", "Pemegang Saham"),
	R_06020300000000 ("06020300000000", "Total Modal Disetor"),
	R_06020400000000 ("06020400000000", "Laba ditahan"),
	R_06020500000000 ("06020500000000", "Total Ekuitas"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2009PosRbPpk060200 eEnum : ER2009PosRbPpk060200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2009PosRbPpk060200.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2009PosRbPpk060200.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 2, 3, 4 });
	}

	public static ConditionalRequired genConditionalFieldMustEmpty() {
		return UtilFieldConditional.genExistPos("N", "M",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 2, 3, 4 }));
	}
}
