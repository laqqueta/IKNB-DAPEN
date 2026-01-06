package id.go.ojk.dplks.client.builder.field.rb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2002PosRbDplks0205 implements IObject<KeyValueString> {
	R_0205010000 ("0205010000", "Rasio Pendapatan investasi  (ROI)"),
	R_0205020000 ("0205020000", "Rasio Pendapatan investasi terhadap Aset (ROA)"),
	R_0205030000 ("0205030000", "Rasio beban operasional (BOPO)"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2002PosRbDplks0205 eEnum : ER2002PosRbDplks0205.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2002PosRbDplks0205.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2002PosRbDplks0205.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
}
