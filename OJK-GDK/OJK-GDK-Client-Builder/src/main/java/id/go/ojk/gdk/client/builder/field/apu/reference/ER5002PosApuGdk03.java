package id.go.ojk.gdk.client.builder.field.apu.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5002PosApuGdk03 implements IObject<KeyValueString> {
//	R_0301000000 ("0301000000", "I. AREA GEOGRAFIS"),
//	R_0301010000 ("0301010000", "A. Jumlah Kantor Cabang. "),
	R_0301010100 ("0301010100", "1. Provinsi Aceh"),
	R_0301010200 ("0301010200", "2. Provinsi Sumatera Utara"),
	R_0301010300 ("0301010300", "3. Provinsi Sumatera Barat"),
	R_0301010400 ("0301010400", "4. Provinsi Riau"),
	R_0301010500 ("0301010500", "5. Provinsi Kepulauan Riau"),
	R_0301010600 ("0301010600", "6. Provinsi Jambi"),
	R_0301010700 ("0301010700", "7. Provinsi Bengkulu"),
	R_0301010800 ("0301010800", "8. Provinsi Sumatera Selatan"),
	R_0301010900 ("0301010900", "9. Provinsi Kepulauan Bangka Belitung"),
	R_0301011000 ("0301011000", "10. Provinsi Lampung"),
	R_0301011100 ("0301011100", "11. Provinsi Banten"),
	R_0301011200 ("0301011200", "12. Provinsi Jawa Barat"),
	R_0301011300 ("0301011300", "13. Provinsi DKI Jakarta"),
	R_0301011400 ("0301011400", "14. Provinsi Jawa Tengah"),
	R_0301011500 ("0301011500", "15. Provinsi Daerah Istimewa Yogyakarta"),
	R_0301011600 ("0301011600", "16. Provinsi Jawa Timur"),
	R_0301011700 ("0301011700", "17. Provinsi Kalimantan Barat"),
	R_0301011800 ("0301011800", "18. Provinsi Kalimantan Tengah"),
	R_0301011900 ("0301011900", "19. Provinsi Kalimantan Selatan"),
	R_0301012000 ("0301012000", "20. Provinsi Kalimantan Timur"),
	R_0301012100 ("0301012100", "21. Provinsi Kalimantan Utara"),
	R_0301012200 ("0301012200", "22. Provinsi Bali"),
	R_0301012300 ("0301012300", "23. Provinsi Nusa Tenggara Barat"),
	R_0301012400 ("0301012400", "24. Provinsi Nusa Tenggara Timur"),
	R_0301012500 ("0301012500", "25. Provinsi Sulawesi Utara"),
	R_0301012600 ("0301012600", "26. Provinsi Sulawesi Barat"),
	R_0301012700 ("0301012700", "27. Provinsi Sulawesi Tengah"),
	R_0301012800 ("0301012800", "28. Provinsi Sulawesi Selatan"),
	R_0301012900 ("0301012900", "29. Provinsi Sulawesi Tenggara"),
	R_0301013000 ("0301013000", "30. Provinsi Gorontalo"),
	R_0301013100 ("0301013100", "31. Provinsi Maluku"),
	R_0301013200 ("0301013200", "32. Provinsi Maluku Utara"),
	R_0301013300 ("0301013300", "33. Provinsi Papua"),
	R_0301013400 ("0301013400", "34. Provinsi Papua Barat"),
	R_0302000000 ("0302000000", "II. STRUKTUR PERUSAHAAN"),
	R_0303000000 ("0303000000", "III. STRUKTUR KEPEMILIKAN"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER5002PosApuGdk03 eEnum : ER5002PosApuGdk03.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER5002PosApuGdk03.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER5002PosApuGdk03.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static ConditionalRequired genConditionalMustEmpty() {
		return UtilFieldConditional.genExistPos("N", "M", R_0302000000.key + "|" + R_0303000000.key);
	}

	public static FieldValidation genValidationPerusahaan() {
		return UtilFieldValidation.genPosEqualsFixedValue("1|2|3|4|5", R_0302000000.key);
	}

	public static FieldValidation genValidationKepemilikan() {
		return UtilFieldValidation.genPosEqualsFixedValue("1|2|3|4|5|6|7|8", R_0303000000.key);
	}
}
