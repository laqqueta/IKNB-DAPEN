package id.go.ojk.fins.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.fins.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3014PosLbFins6910 implements IObject<KeyValueString> {
	R_691001000000("691001000000", "Akumulasi Penyaluran Pendanaan"),
	R_691002000000("691002000000", "Pendanaan Oustanding"),
	R_691003000000("691003000000", "Akumulasi Jumlah Pengembalian Pendanaan"),
	R_691004000000("691004000000", "Akumulasi Pendanaan yang dihapus buku & hapus tagih"),
	R_691005000000("691005000000", "Akumulasi Pendanaan yang dilakukan klaim Asuransi/Penjaminan"),
	R_691006000000("691006000000", "Paid Ratio"),
	R_691007000000("691007000000", "Unpaid Ratio"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3014PosLbFins6910 eEnum : ER3014PosLbFins6910.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3014PosLbFins6910.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3014PosLbFins6910.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("2",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 5, 6 }));
	}
	
	public static SegmentValidation genValidationDecimal() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 5, 6 }));
	}

	public static SegmentValidation genValidation2() {
		return UtilSegmentValidation.genEqualsForm("2", R_691002000000.key, EFormLaporanBulanan.LB_6908.getCode(), "4",
				ER3013PosLbFins6908.R_690806000000.getKey(),
				UtilMetadata.genMessage(R_691002000000.value, "Total Pendanaan pada form 6908"));
	}
	
	public static SegmentValidation genValidation6() {
		return UtilSegmentValidation.genEqualsRatio("2", R_691006000000.key,
				UtilMetadata.genPipeRow(getObjects(), new int[] { 2, 0 }),
				UtilMetadata.genMessage(R_691006000000.value, "'" + R_691003000000.value + "'/'" + R_691001000000.value + "'"));
	}

	public static SegmentValidation genValidation7() {
		int[] rows = new int[] { 1, 3, 4 };
		return UtilSegmentValidation.genEqualsRatio("2", R_691007000000.key,
				UtilMetadata.genPlusRow(getObjects(), rows) + "|" + R_691001000000.key,
				UtilMetadata.genMessage(R_691007000000.value,
						UtilMetadata.genPlusDesc(getObjects(), rows) + "/'" + R_691001000000.value + "'"));
	}
}
