package id.go.ojk.reask.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1099Peringkat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4005PosSaReask0205 implements IObject<KeyValueString> {
//	R_02050100000000 ("02050100000000", "Tabel II.E.1: Parameter atau Indikator Penilaian Risiko untuk Risiko Pasar "),
//	R_02050101000000 ("02050101000000", "I Kuantitatif"),
	R_02050101010000 ("02050101010000", "1.  Rasio tingkat pengembalian investasi (ROI)"),
	R_02050101020000 ("02050101020000", "2.  Rasio aset berisiko lebih besar dari peringkat/klaster 3 terhadap total asset"),
	R_02050101030000 ("02050101030000", "3.  Pertumbuhan Risiko Pasar (dari MMBR)"),
	R_02050101040000 ("02050101040000", "4.  Rasio aset mata uang asing terhadap aset"),
	R_02050101050000 ("02050101050000", "5.  Rasio aset dalam mata uang asing terhadap liabilitas dalam mata uang asing"),
//	R_02050102000000 ("02050102000000", "B Kualitatif "),
//	R_02050102010000 ("02050102010000", "1.  Alokasi dan/atau struktur investasi"),
	R_02050102010100 ("02050102010100", " a. portofolio investasi"),
	R_02050102010200 ("02050102010200", " b. volatilitas portofolio investasi"),
//	R_02050102020000 ("02050102020000", "2.  Tujuan dan strategi investasi "),
	R_02050102020100 ("02050102020100", " a. Tujuan dan Strategi Investasi "),
	R_02050102020200 ("02050102020200", " b. Kesesuaian strategi alokasi aset dengan target yang ingin dicapai"),
	R_02050102020300 ("02050102020300", " c. Diversifikasi Investasi"),
//	R_02050102030000 ("02050102030000", "3.  Valuasi Aset Investasi"),
	R_02050102030100 ("02050102030100", " a. Kemudahan transaksi portofolio investasi."),
	R_02050102030200 ("02050102030200", " b. Penilaian investasi : 1) Tingkat kehandalan valuasi portofolio investasi dan 2) Reputasi penyedia jasa penilaian"),
//	R_02050200000000 ("02050200000000", "Tabel II.E.2: Tingkat Risiko Inheren untuk Risiko Pasar"),
	R_02050201000000 ("02050201000000", "Tingkat Risiko Inheren untuk Risiko Pasar"),
//	R_02050300000000 ("02050300000000", "Tabel II.E.3: Kualitas Penerapan Manajemen Risiko untuk Risiko Pasar "),
	R_02050301000000 ("02050301000000", "Kualitas Penerapan Manajemen Risiko untuk Risiko Pasar"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4005PosSaReask0205 eEnum : ER4005PosSaReask0205.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumericDotNegative() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), 0, 4));
	}
	
	public static SegmentValidation genValidationMaxLengthNumericDotNegative() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 0, 4), 8);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 12, 13 }));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 12, 13 }), 1);
	}
	
	public static SegmentValidation genValidationPeringkat() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 12, 13 }), ER1099Peringkat.getPipedKey());
	}
}
