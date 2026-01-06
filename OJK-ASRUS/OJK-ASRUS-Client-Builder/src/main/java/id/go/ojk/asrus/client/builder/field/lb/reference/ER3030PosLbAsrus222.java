package id.go.ojk.asrus.client.builder.field.lb.reference;

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
public enum ER3030PosLbAsrus222 implements IObject<KeyValueString> {
	R_2220010000 ("2220010000", "Harta Benda (Property)", "25.00"),
	R_2220010001 ("2220010001", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)", "25.00"),
	R_2220010002 ("2220010002", "Pengangkutan (Marine Cargo)", "30.00"),
	R_2220010003 ("2220010003", "Rangka Kapal (Marine Hull)", "30.00"),
	R_2220010004 ("2220010004", "Rangka Pesawat (Aviation Hull)", "30.00"),
	R_2220010005 ("2220010005", "Satelit", "25.00"),
	R_2220010006 ("2220010006", "Energi Onshore (Oil and Gas)", "35.00"),
	R_2220010007 ("2220010007", "Energi Offshore (Oil and Gas)", "35.00"),
	R_2220010008 ("2220010008", "Rekayasa (Engineering)", "25.00"),
	R_2220010009 ("2220010009", "Tanggung Gugat (Liability)", "35.00"),
	R_2220010010 ("2220010010", "Aneka", "25.00"),
	R_2220010011 ("2220010011", "Kesehatan", "25.00"),
	R_2220010012 ("2220010012", "Kecelakaan Diri", "25.00"),
	R_2220010013 ("2220010013", "Jiwa*)", "10.00"),
	R_2220010014 ("2220010014", "Total ", ""),
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
		for (ER3030PosLbAsrus222 eEnum : ER3030PosLbAsrus222.values()) {
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
		return UtilSegmentValidation.genEqualsFormula("2|3|5", R_2220010014.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 13), "Total|Penjumlahan Detail");
	}

	private static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER3030PosLbAsrus222[] eEnums = ER3030PosLbAsrus222.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3030PosLbAsrus222 eEnum = ER3030PosLbAsrus222.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.factor);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
