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
public enum ER3029PosLbReass221 implements IObject<KeyValueString> {
	R_2211000000 ("2211000000", "Harta Benda (Property)", "20.00"),
	R_2211000001 ("2211000001", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)", "20.00"),
	R_2211000002 ("2211000002", "Pengangkutan (Marine Cargo)", "25.00"),
	R_2211000003 ("2211000003", "Rangka Kapal (Marine Hull)", "25.00"),
	R_2211000004 ("2211000004", "Rangka Pesawat (Aviation Hull)", "25.00"),
	R_2211000005 ("2211000005", "Satelit", "20.00"),
	R_2211000006 ("2211000006", "Energi Onshore (Oil and Gas)", "30.00"),
	R_2211000007 ("2211000007", "Energi Offshore (Oil and Gas)", "30.00"),
	R_2211000008 ("2211000008", "Rekayasa (Engineering)", "20.00"),
	R_2211000009 ("2211000009", "Tanggung Gugat (Liability)", "30.00"),
	R_2211000010 ("2211000010", "Aneka", "20.00"),
	R_2211000011 ("2211000011", "Kesehatan", "20.00"),
	R_2211000012 ("2211000012", "Kecelakaan Diri", "20.00"),
	R_2211000013 ("2211000013", "Jiwa*)", "10.00"),
	R_2211000014 ("2211000014", "Total ", ""),
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
		for (ER3029PosLbReass221 eEnum : ER3029PosLbReass221.values()) {
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
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_2211000014.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 13), "Total|Penjumlahan Detail");
	}

	private static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER3029PosLbReass221[] eEnums = ER3029PosLbReass221.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3029PosLbReass221 eEnum = ER3029PosLbReass221.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.factor);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
