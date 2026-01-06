package id.go.ojk.fins.client.builder.field.lt.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER6004PosLtFins1300 implements IObject<KeyValueString> {
	R_130001000000("130001000000", "A. Arus Kas Bersih dari Kegiatan Operasi"),
	R_130001010000("130001010000", "1. Arus Kas Masuk dari Kegiatan Operasi"),
	R_130001020000("130001020000", "2. Arus Kas Keluar untuk Kegiatan Operasi"),
	R_130002000000("130002000000", "B. Arus Kas Bersih dari Kegiatan Investasi"),
	R_130002010000("130002010000", "1. Arus Kas Masuk dari Kegiatan Investasi"),
	R_130002020000("130002020000", "2. Arus Kas Keluar untuk Kegiatan Investasi"),
	R_130003000000("130003000000", "C. Arus Kas Bersih dari Kegiatan Pembiayaan"),
	R_130003010000("130003010000", "1. Arus Kas Masuk dari Kegiatan Pembiayaan"),
	R_130003020000("130003020000", "2. Arus Kas Keluar dari Kegiatan Pembiayaan"),
	R_130004000000("130004000000", "D. Kenaikan (Penurunan) dari Perubahan Kurs Valuta Kas dan Setara Kas"),
	R_130005000000("130005000000", "E. Kenaikan (Penurunan) Bersih Kas dan Setara Kas"),
	R_130006000000("130006000000", "F. Kas dan Setara Kas pada Awal Periode"),
	R_130007000000("130007000000", "G. Kas dan Setara Kas pada Akhir Periode"),
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
		for (ER6004PosLtFins1300 eEnum : ER6004PosLtFins1300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER6004PosLtFins1300.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER6004PosLtFins1300.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}

	public static SegmentValidation genRowValidation01() {
		int[] rows = new int[] { 1, 2 };
		return UtilSegmentValidation.genEqualsFormula("2", R_130001000000.key,
				UtilMetadata.genMinusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_130001000000.getValue(), UtilMetadata.genMinusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation04() {
		int[] rows = new int[] { 4, 5 };
		return UtilSegmentValidation.genEqualsFormula("2", R_130002000000.key,
				UtilMetadata.genMinusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_130002000000.getValue(), UtilMetadata.genMinusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation07() {
		int[] rows = new int[] { 7, 8 };
		return UtilSegmentValidation.genEqualsFormula("2", R_130003000000.key,
				UtilMetadata.genMinusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_130003000000.getValue(), UtilMetadata.genMinusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation11() {
		int[] rows = new int[] { 0, 3, 6, 9 };
		return UtilSegmentValidation.genEqualsFormula("2", R_130005000000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_130005000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation13() {
		int[] rows = new int[] { 10, 11 };
		return UtilSegmentValidation.genEqualsFormula("2", R_130007000000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_130007000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}
}
