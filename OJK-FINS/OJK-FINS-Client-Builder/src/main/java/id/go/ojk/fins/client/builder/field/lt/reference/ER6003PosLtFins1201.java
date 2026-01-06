package id.go.ojk.fins.client.builder.field.lt.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.fins.client.builder.field.EFormLaporanTahunan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER6003PosLtFins1201 implements IObject<KeyValueString> {
	R_120101000000("120101000000", "I. Saldo Ekuitas Awal Periode"),
//	R_120102000000("120102000000", "II. Penambahan (Pengurangan) Ekuitas"),
	R_120102010000("120102010000", "1. Tambahan modal selama periode berjalan"),
	R_120102020000("120102020000", "2. Laba (Rugi) Komprehensif periode berjalan"),
	R_120102030000("120102030000", "3. Transaksi Lainnya yang menyebabkan perubahan kepemilikan "),
	R_120102040000("120102040000", "4. Dividen"),
	R_120103000000("120103000000", "III. Saldo Ekuitas Akhir Periode"),
	;

	@Getter
	private String key;
	private String value;

	public String getValue() {
		String marker = ". ";
		int idx = value.indexOf(marker);
		return idx > -1 ? value.substring(idx + 1).trim() : value;
	}

	public KeyValueString getObject() {
		return new KeyValueString(key, getValue(), new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER6003PosLtFins1201 eEnum : ER6003PosLtFins1201.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER6003PosLtFins1201.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER6003PosLtFins1201.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}

	public static SegmentValidation genRowValidation2() {
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_120102010000.key, "2",
				UtilMetadata.genPlusRow(ER6001PosLtFins1100.getObjectsForm(), 42, 43),
				UtilMetadata.genMessage(R_120102010000.getValue(),
						UtilMetadata.genPlusDesc(ER6001PosLtFins1100.getObjects(), 42, 43) + " pada form 1100"));
	}

	public static SegmentValidation genRowValidation3() {
		return UtilSegmentValidation.genEqualsForm2("2", R_120102020000.key, EFormLaporanTahunan.LT_1200.getCode(), 
				ER6002PosLtFins1200.R_120013000000.getKey(),
				UtilMetadata.genMessage(R_120102020000.getValue(), "Laba (Rugi) Komprehensif pada form 1200"));
	}

	public static SegmentValidation genRowValidation6() {
		return UtilSegmentValidation.genEqualsFormula("2", R_120103000000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 3) + "-" + R_120102040000.key,
				UtilMetadata.genMessage(R_120103000000.getValue(),
						UtilMetadata.genPlusDesc(getObjects(), 0, 3) + "-'" + R_120102040000.getValue() + "'"));
	}
}
