package id.go.ojk.reass.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3018PosLbReass210 implements IObject<KeyValueString> {
	R_2101000001 ("2101000001", "Risiko Kredit (a)"),
	R_2101000002 ("2101000002", "Risiko Kredit (b)"),
	R_2101000003 ("2101000003", "Total Risiko Kredit"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3018PosLbReass210 eEnum : ER3018PosLbReass210.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 4), getObjects());
	}
	
	public static SegmentValidation genValidationTotalRisikoKredit() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 4), R_2101000003.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 1), "Total Risiko Kredit|Penjumlahan Risiko Kredit");
	}
}
