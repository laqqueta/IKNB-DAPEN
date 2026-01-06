package id.go.ojk.dppkk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2123PosReDppu0500 implements IObject<KeyValueString> {
	R_0501000000 ("0501000000", "Rasio Pendapatan Investasi (ROI)"),
	R_0502000000 ("0502000000", "Rasio Pendapatan Investasi terhadap Aset (ROA)"),
	R_0503000000 ("0503000000", "Rasio Beban Operasional (BOPO)"),
	R_0504000000 ("0504000000", "Rasio Pendanaan (khusus PPMP)"),
	R_0505000000 ("0505000000", "Rasio Solvabilitas (khusus PPMP)"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2123PosReDppu0500 eEnum : ER2123PosReDppu0500.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2123PosReDppu0500.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2123PosReDppu0500.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsRatio("3|2");
	}
}
