package id.go.ojk.fink.client.builder.field.lt.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.fink.client.builder.field.EFormLaporanTahunan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER6016PosLtFink2310 implements IObject<KeyValueString> {
	R_231001000000("231001000000", "A. Arus Kas Bersih dari Kegiatan Operasi"),
	R_231001010100("231001010100", "Rincian Arus Kas Masuk dari Kegiatan Operasi"),
	R_231001010000("231001010000", "Total Arus Kas Masuk dari Kegiatan Operasi"),
	R_231001020100("231001020100", "Rincian Arus Kas Keluar untuk Kegiatan Operasi"),
	R_231001020000("231001020000", "Total Arus Kas Keluar untuk Kegiatan Operasi"),
	R_231002000000("231002000000", "B. Arus Kas Bersih dari Kegiatan Investasi"),
	R_231002010100("231002010100", "Rincian Arus Kas Masuk dari Kegiatan Investasi"),
	R_231002010000("231002010000", "Total Arus Kas Masuk dari Kegiatan Investasi"),
	R_231002020100("231002020100", "Rincian Arus Kas Keluar untuk Kegiatan Investasi"),
	R_231002020000("231002020000", "Total Arus Kas Keluar untuk Kegiatan Investasi"),
	R_231003000000("231003000000", "C. Arus Kas Bersih dari Kegiatan Pembiayaan"),
	R_231003010100("231003010100", "Rincian Arus Kas Masuk dari Kegiatan Pembiayaan"),
	R_231003010000("231003010000", "Total Arus Kas Masuk dari Kegiatan Pembiayaan"),
	R_231003020100("231003020100", "Rincian Arus Kas Keluar untuk Kegiatan Pembiayaan"),
	R_231003020000("231003020000", "Total Arus Kas Keluar untuk Kegiatan Pembiayaan"),
//	R_231004000000("231004000000", "D. Kenaikan (Penurunan) dari Perubahan Kurs Valuta Kas dan Setara Kas"),
	R_231004010100("231004010100", "Rincian Kenaikan (Penurunan) dari Perubahan Kurs Valuta Kas dan Setara Kas"),
	R_231004010000("231004010000", "Total Kenaikan (Penurunan) dari Perubahan Kurs Valuta Kas dan Setara Kas"),
	;

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
		for (ER6016PosLtFink2310 eEnum : ER6016PosLtFink2310.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER6016PosLtFink2310.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER6016PosLtFink2310.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 2, 4, 5, 7, 9, 10, 12, 14, 16 });
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3", getObjects());
	}

	public static ConditionalRequired genConditional() {
		return UtilFieldConditional.genExistPos("N", "M",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 2, 4, 5, 7, 9, 10, 12, 14, 16 }));
	}

	public static SegmentValidation genRowValidation01A() {
		int[] rows = new int[] { 2, 4 };
		return UtilSegmentValidation.genEqualsFormula("3", R_231001000000.key,
				UtilMetadata.genMinusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_231001000000.getValue(), UtilMetadata.genMinusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation01B() {
		return UtilSegmentValidation.genEqualsForm("3", R_231001000000.key, EFormLaporanTahunan.LT_1300.getCode(),
				"2", ER6004PosLtFink1300.R_130001000000.getKey(), 
				UtilMetadata.genMessage(R_231001000000.getValue(), "Arus Kas Bersih dari Kegiatan Operasi pada form 1300"));
	}

	public static SegmentValidation genRowValidation03A() {
		return UtilSegmentValidation.genEqualsFormula("3", R_231001010000.key, R_231001010100.key, UtilMetadata
				.genMessage(R_231001010000.getValue(), "Penjumlahan " + R_231001010100.getValue().toLowerCase()));
	}

	public static SegmentValidation genRowValidation03B() {
		return UtilSegmentValidation.genEqualsForm("3", R_231001010000.key, EFormLaporanTahunan.LT_1300.getCode(),
				"2", ER6004PosLtFink1300.R_130001010000.getKey(), 
				UtilMetadata.genMessage(R_231001010000.getValue(), "Arus Kas Masuk dari Kegiatan Operasi pada form 1300"));
	}

	public static SegmentValidation genRowValidation05A() {
		return UtilSegmentValidation.genEqualsFormula("3", R_231001020000.key, R_231001020100.key, UtilMetadata
				.genMessage(R_231001020000.getValue(), "Penjumlahan " + R_231001020100.getValue().toLowerCase()));
	}

	public static SegmentValidation genRowValidation05B() {
		return UtilSegmentValidation.genEqualsForm("3", R_231001020000.key, EFormLaporanTahunan.LT_1300.getCode(),
				"2", ER6004PosLtFink1300.R_130001020000.getKey(), 
				UtilMetadata.genMessage(R_231001020000.getValue(), "Arus Kas Keluar untuk Kegiatan Operasi pada form 1300"));
	}

	public static SegmentValidation genRowValidation06A() {
		int[] rows = new int[] { 7, 9 };
		return UtilSegmentValidation.genEqualsFormula("3", R_231002000000.key,
				UtilMetadata.genMinusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_231002000000.getValue(), UtilMetadata.genMinusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation06B() {
		return UtilSegmentValidation.genEqualsForm("3", R_231002000000.key, EFormLaporanTahunan.LT_1300.getCode(),
				"2", ER6004PosLtFink1300.R_130002000000.getKey(), 
				UtilMetadata.genMessage(R_231002000000.getValue(), "Arus Kas Bersih dari Kegiatan Investasi pada form 1300"));
	}

	public static SegmentValidation genRowValidation08A() {
		return UtilSegmentValidation.genEqualsFormula("3", R_231002010000.key, R_231002010100.key, UtilMetadata
				.genMessage(R_231002010000.getValue(), "Penjumlahan " + R_231002010100.getValue().toLowerCase()));
	}

	public static SegmentValidation genRowValidation08B() {
		return UtilSegmentValidation.genEqualsForm("3", R_231002010000.key, EFormLaporanTahunan.LT_1300.getCode(),
				"2", ER6004PosLtFink1300.R_130002010000.getKey(), 
				UtilMetadata.genMessage(R_231002010000.getValue(), "Arus Kas Masuk dari Kegiatan Investasi pada form 1300"));
	}

	public static SegmentValidation genRowValidation10A() {
		return UtilSegmentValidation.genEqualsFormula("3", R_231002020000.key, R_231002020100.key, UtilMetadata
				.genMessage(R_231002020000.getValue(), "Penjumlahan " + R_231002020100.getValue().toLowerCase()));
	}

	public static SegmentValidation genRowValidation10B() {
		return UtilSegmentValidation.genEqualsForm("3", R_231002020000.key, EFormLaporanTahunan.LT_1300.getCode(),
				"2", ER6004PosLtFink1300.R_130002020000.getKey(), 
				UtilMetadata.genMessage(R_231002020000.getValue(), "Arus Kas Keluar untuk Kegiatan Investasi pada form 1300"));
	}

	public static SegmentValidation genRowValidation11A() {
		int[] rows = new int[] { 12, 14 };
		return UtilSegmentValidation.genEqualsFormula("3", R_231003000000.key,
				UtilMetadata.genMinusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_231003000000.getValue(), UtilMetadata.genMinusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation11B() {
		return UtilSegmentValidation.genEqualsForm("3", R_231003000000.key, EFormLaporanTahunan.LT_1300.getCode(),
				"2", ER6004PosLtFink1300.R_130003000000.getKey(), 
				UtilMetadata.genMessage(R_231003000000.getValue(), "Arus Kas Bersih dari Kegiatan Pembiayaan pada form 1300"));
	}

	public static SegmentValidation genRowValidation13() {
		return UtilSegmentValidation.genEqualsFormula("3", R_231003010000.key, R_231003010100.key, UtilMetadata
				.genMessage(R_231003010000.getValue(), "Penjumlahan " + R_231003010100.getValue().toLowerCase()));
	}

	public static SegmentValidation genRowValidation15() {
		return UtilSegmentValidation.genEqualsFormula("3", R_231003020000.key, R_231003020100.key, UtilMetadata
				.genMessage(R_231003020000.getValue(), "Penjumlahan " + R_231003020100.getValue().toLowerCase()));
	}

	public static SegmentValidation genRowValidation17() {
		return UtilSegmentValidation.genEqualsFormula("3", R_231004010000.key, R_231004010100.key, UtilMetadata
				.genMessage(R_231004010000.getValue(), "Penjumlahan " + R_231004010100.getValue().toLowerCase()));
	}
}
