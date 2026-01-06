 package id.go.ojk.ppik.client.builder.field.lb.uus.reference;

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
public enum ER3105PosLbPpiu0041 implements IObject<KeyValueString> {
//	R_0041010000 ("0041010000", "Jumlah Tenaga Kerja Kantor Pusat"),
	R_0041010100 ("0041010100", "Tingkat Pendidikan Lainnya di Bawah SMA"),
	R_0041010200 ("0041010200", "SMA"),
	R_0041010300 ("0041010300", "Diploma"),
	R_0041010400 ("0041010400", "Sarjana"),
	R_0041010500 ("0041010500", "Pasca Sarjana"),
	R_0041020000 ("0041020000", "Total Tenaga Kerja Kantor Pusat"),
//	R_0041030000 ("0041030000", "Jumlah Tenaga Kerja Kantor Cabang"),
	R_0041030100 ("0041030100", "Tingkat Pendidikan Lainnya di Bawah SMA"),
	R_0041030200 ("0041030200", "SMA"),
	R_0041030300 ("0041030300", "Diploma"),
	R_0041030400 ("0041030400", "Sarjana"),
	R_0041030500 ("0041030500", "Pasca Sarjana"),
	R_0041040000 ("0041040000", "Total Tenaga Kerja Kantor Cabang"),
	R_0041050000 ("0041050000", "Jumlah Tenaga Kerja Kantor Pusat dan Cabang"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3105PosLbPpiu0041 eEnum : ER3105PosLbPpiu0041.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3105PosLbPpiu0041.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3105PosLbPpiu0041.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 11), getObjects());
	}
	
	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genEqualsPosFormula("2+3",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5, 11, 12 }));
	}

	public static FieldValidation genFieldValidation7() {
		return UtilFieldValidation.genEqualsPosFormula("5+6",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5, 11, 12 }));
	}

	public static FieldValidation genFieldValidation10() {
		return UtilFieldValidation.genEqualsPosFormula("8+9",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5, 11, 12 }));
	}

	public static FieldValidation genFieldValidation11() {
		return UtilFieldValidation.genEqualsPosFormula("4+7+10",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5, 11, 12 }));
	}

	public static SegmentValidation genRowValidation07() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_0041020000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 4),
				UtilMetadata.genMessage(R_0041020000.value, "Tenaga kerja kantor pusat", UtilMetadata.genPlusDesc(getObjects(), 0, 4)));
	}

	public static SegmentValidation genRowValidation13() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_0041040000.key,
				UtilMetadata.genPlusRow(getObjects(), 6, 10),
				UtilMetadata.genMessage(R_0041040000.value, "Tenaga kerja kantor cabang", UtilMetadata.genPlusDesc(getObjects(), 6, 10)));
	}

	public static SegmentValidation genRowValidation14() {
		int[] fields = new int[] { 5, 11 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 11), R_0041050000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_0041050000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
}
