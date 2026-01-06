package id.go.ojk.reass.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3028PosLbReass220 implements IObject<KeyValueString> {
	R_2201000000 ("2201000000", "Harta Benda (Property)", "25.00"),
	R_2201000001 ("2201000001", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)", "25.00"),
	R_2201000002 ("2201000002", "Pengangkutan (Marine Cargo)", "30.00"),
	R_2201000003 ("2201000003", "Rangka Kapal (Marine Hull)", "30.00"),
	R_2201000004 ("2201000004", "Rangka Pesawat (Aviation Hull)", "30.00"),
	R_2201000005 ("2201000005", "Satelit", "25.00"),
	R_2201000006 ("2201000006", "Energi Onshore (Oil and Gas)", "35.00"),
	R_2201000007 ("2201000007", "Energi Offshore (Oil and Gas)", "35.00"),
	R_2201000008 ("2201000008", "Rekayasa (Engineering)", "25.00"),
	R_2201000009 ("2201000009", "Tanggung Gugat (Liability)", "35.00"),
	R_2201000010 ("2201000010", "Aneka", "25.00"),
	R_2201000011 ("2201000011", "Kesehatan", "25.00"),
	R_2201000012 ("2201000012", "Kecelakaan Diri", "25.00"),
	R_2201000013 ("2201000013", "Jiwa*)", "10.00"),
	R_2201000014 ("2201000014", "Total ", ""),
	;

	@Getter
	private String key;
	private String value;
	private String factor;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3028PosLbReass220 eEnum : ER3028PosLbReass220.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}
	
	public static ConditionalRequired genConditional4() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 14 }));
	}
	
	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genPosLookup("1", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 14 }), 
				getLookup());
	}

	public static FieldValidation genValidation5() {
		return UtilFieldValidation.genPosPercentage("2-3|4", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 14 }), 0);
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_2201000014.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 13), "Total|Penjumlahan Detail");
	}

	private static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER3028PosLbReass220[] eEnums = ER3028PosLbReass220.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3028PosLbReass220 eEnum = ER3028PosLbReass220.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.factor);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
