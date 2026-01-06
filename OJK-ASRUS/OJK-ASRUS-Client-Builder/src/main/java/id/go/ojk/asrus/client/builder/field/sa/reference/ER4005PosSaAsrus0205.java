package id.go.ojk.asrus.client.builder.field.sa.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1099Peringkat;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER4005PosSaAsrus0205 implements IObject<KeyValueString> {
//	R_02050100000000 ("02050100000000", "Tabel II.E.1: Parameter atau Indikator Penilaian Risiko untuk Risiko Pasar "),
//	R_02050101000000 ("02050101000000", "I Kuantitatif"),
	R_02050101010000 ("02050101010000", "1.  Rasio aset berisiko lebih besar dari peringkat/klaster 3 terhadap total asset"),
//	R_02050101020000 ("02050101020000", "2.  Rasio tingkat pengembalian investasi (Return on Investment Ratio/ROI)"),
	R_02050101020100 ("02050101020100", "ROI Dana Tabarru' "),
	R_02050101020200 ("02050101020200", "ROI Dana Perusahaan"),
	R_02050101020300 ("02050101020300", "ROI Dana Investasi Peserta"),
//	R_02050101030000 ("02050101030000", "3.  Pertumbuhan risiko pasar (dari DTMBR, MMBR dan PAYDI garansi)"),
	R_02050101030100 ("02050101030100", "Dana Tabarru' (DTMBR)"),
	R_02050101030200 ("02050101030200", "Dana Perusahaan (MMBR)"),
	R_02050101030300 ("02050101030300", "Dana Perusahaan (MMBR atas PAYDI digaransi)"),
//	R_02050101040000 ("02050101040000", "4.  Rasio aset mata uang asing terhadap total aset"),
	R_02050101040100 ("02050101040100", "Dana Tabarru'"),
	R_02050101040200 ("02050101040200", "Dana Perusahaan"),
	R_02050101040300 ("02050101040300", "Dana Investasi Peserta"),
//	R_02050101050000 ("02050101050000", "5.  Rasio aset dalam mata uang asing terhadap liabilitas dalam mata uang asing"),
	R_02050101050100 ("02050101050100", "Dana Tabarru'"),
	R_02050101050200 ("02050101050200", "Dana Perusahaan"),
	R_02050101050300 ("02050101050300", "Dana Investasi Peserta"),
//	R_02050102000000 ("02050102000000", "II Kualitatif "),
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
//	R_02050302000000 ("02050302000000", "Tingkat Risiko Pasar"),
	R_02050303000000 ("02050303000000", "Tingkat Risiko Pasar Net Risk"),
//	R_02050400000000 ("02050400000000", "Tabel II.E.4: Tingkat Risiko Inheren untuk Risiko Pasar Konsolidasi"),
	R_02050401000000 ("02050401000000", "Tingkat Risiko Inheren untuk Risiko Pasar "),
//	R_02050500000000 ("02050500000000", "Tabel II.E.5: Kualitas Penerapan Manajemen Risiko untuk Risiko Pasar Konsolidasi"),
	R_02050501000000 ("02050501000000", "Kualitas Penerapan Manajemen Risiko untuk Risiko Pasar "),
//	R_02050502000000 ("02050502000000", "Tingkat Risiko Pasar "),
	R_02050503000000 ("02050503000000", "Tingkat Risiko Pasar Net Risk"),
	R_02050600000000 ("02050600000000", "ANALISIS"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4005PosSaAsrus0205 eEnum : ER4005PosSaAsrus0205.values()) {
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
	
	public static ConditionalRequired genConditional2() {
		return UtilFieldConditional.genExistPos("O", "M", UtilMetadata.genPipeRow(getObjects(), 23, 25));
	}
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), 0, 12));
	}
	
	public static SegmentValidation genValidationMaxLengthNumericDot() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 0, 12), 10);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), 20, 25));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 20, 25), 1);
	}
	
	public static SegmentValidation genValidationPeringkat1() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), 20, 22), ER1099Peringkat.getPipedKey());
	}
	
	public static SegmentValidation genValidationPeringkat2() {
		return UtilSegmentValidation.genFixedValueOptional("2", UtilMetadata.genPipeRow(getObjects(), 23, 25), ER1099Peringkat.getPipedKey());
	}
}
