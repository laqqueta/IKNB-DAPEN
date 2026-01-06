package id.go.ojk.asruk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3028PosLbAsruk111 implements IObject<KeyValueString> {
//	R_2501000099 ("2501000099", "Cadangan Premi"),
	R_2501010000 ("2501010000", "Harta Benda (Property)"),
	R_2501020000 ("2501020000", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)"),
	R_2501030000 ("2501030000", "Pengangkutan (Marine Cargo)"),
	R_2501040000 ("2501040000", "Rangka Kapal (Marine Hull)"),
	R_2501050000 ("2501050000", "Rangka Pesawat (Aviation Hull)"),
	R_2501060000 ("2501060000", "Satelit"),
	R_2501070000 ("2501070000", "Energi Onshore (Oil and Gas)"),
	R_2501080000 ("2501080000", "Energi Offshore (Oil and Gas)"),
	R_2501090000 ("2501090000", "Rekayasa (Engineering)"),
	R_2501100000 ("2501100000", "Tanggung Gugat (Liability)"),
	R_2501110000 ("2501110000", "Kecelakaan Diri"),
	R_2501120000 ("2501120000", "Kesehatan"),
	R_2501130000 ("2501130000", "Kredit (Credit) "),
	R_2501140000 ("2501140000", "Suretyship"),
	R_2501150000 ("2501150000", "Aneka"),
	R_2501160000 ("2501160000", "Jiwa"),
	R_2501000000 ("2501000000", "Total Cadangan Premi"),
//	R_2502000099 ("2502000099", "CAPYBMP"),
	R_2502010000 ("2502010000", "Harta Benda (Property)"),
	R_2502020000 ("2502020000", "Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident)"),
	R_2502030000 ("2502030000", "Pengangkutan (Marine Cargo)"),
	R_2502040000 ("2502040000", "Rangka Kapal (Marine Hull)"),
	R_2502050000 ("2502050000", "Rangka Pesawat (Aviation Hull)"),
	R_2502060000 ("2502060000", "Satelit"),
	R_2502070000 ("2502070000", "Energi Onshore (Oil and Gas)"),
	R_2502080000 ("2502080000", "Energi Offshore (Oil and Gas)"),
	R_2502090000 ("2502090000", "Rekayasa (Engineering)"),
	R_2502100000 ("2502100000", "Tanggung Gugat (Liability)"),
	R_2502110000 ("2502110000", "Kecelakaan Diri"),
	R_2502120000 ("2502120000", "Kesehatan"),
	R_2502130000 ("2502130000", "Kredit (Credit)"),
	R_2502140000 ("2502140000", "Suretyship"),
	R_2502150000 ("2502150000", "Aneka"),
	R_2502160000 ("2502160000", "Jiwa"),
	R_2502000000 ("2502000000", "Total CAPYBMP"),
	;
	
	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3028PosLbAsruk111 eEnum : ER3028PosLbAsruk111.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}
	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genEqualsPosFormula("2+3", UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 16, 33 }));
	}

	public static SegmentValidation genValidationTotalCadanganPremi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_2501000000.key, UtilMetadata.genPlusRow(getObjects(), 0, 15), 
				"Total cadangan premi|Penjumlahan cadangan premi");
	}
	
	public static SegmentValidation genValidationTotalCAPYBMP() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4", R_2502000000.key, UtilMetadata.genPlusRow(getObjects(), 17, 32), 
				"Total CAPYBMP|Penjumlahan CAPYBMP");
	}
}
