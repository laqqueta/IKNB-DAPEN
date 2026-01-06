package id.go.ojk.reass.client.builder.field.sa.reference;

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
public enum ER4012PosSaReass0300 implements IObject<KeyValueString> {
//	R_03000100000000 ("03000100000000", "Tabel III.A: Parameter atau Indikator Penilaian Faktor Rentabilitas "),
//	R_03000101000000 ("03000101000000", "1.  Kinerja Perusahaan dalam menghasilkan laba (rentabilitas)"),
	R_03000101010000 ("03000101010000", " 1) Return on asset (RoA)"),
	R_03000101020000 ("03000101020000", " 2) Pertumbuhan kontribusi bruto"),
	R_03000101030000 ("03000101030000", " 3) Loss ratio dari bisnis utama"),
	R_03000101040000 ("03000101040000", " 4)  Rasio biaya"),
	R_03000101050000 ("03000101050000", " 5)  Kinerja dana perusahaan (rentabilitas) aktual terhadap proyeksi"),
//	R_03000101060000 ("03000101060000", " 6)  Surplus (defisit) underwriting "),
	R_03000101060100 ("03000101060100", " a)  Rasio pertumbuhan surplus (defisit) underwriting"),
	R_03000101060200 ("03000101060200", " b)  Surplus (defisit) underwriting dana tabarru’ terhadap laba (rugi) dana tabarru’ sebelum pajak"),
	R_03000101070000 ("03000101070000", " 7)  Pembentukan penyisihan"),
//	R_03000102000000 ("03000102000000", "2.  Sumber-sumber yang mendukung rentabilitas"),
	R_03000102010000 ("03000102010000", " 1) Analisa pendapatan premi/kontribusi"),
	R_03000102020000 ("03000102020000", " 2) Analisa pendapatan selain pendapatan premi/kontribusi"),
	R_03000102030000 ("03000102030000", " 3) Analisa beban klaim (beban asuransi) "),
	R_03000102040000 ("03000102040000", " 4) Analisa beban usaha/operasional"),
	R_03000102050000 ("03000102050000", " 5) Analisa penurunan nilai aset "),
//	R_03000103000000 ("03000103000000", "3.  Stabilitas komponen yang mendukung rentabilitas"),
	R_03000103010000 ("03000103010000", " 1) Rasio gabungan (combine ratio)"),
	R_03000103020000 ("03000103020000", " 2) Rata-rata pertumbuhan laba (rugi) sebelum pajak selama 3 tahun kedepan"),
	R_03000103030000 ("03000103030000", " 3) Prospek rentabilitas di masa datang"),
//	R_03000103040000 ("03000103040000", " 4) Tren saldo laba dan pembayaran dividen"),
	R_03000103040100 ("03000103040100", " a. Tren saldo laba"),
	R_03000103040200 ("03000103040200", " b. Tren pembayaran dividen"),
//	R_03000200000000 ("03000200000000", "Tabel III.B: Peringkat Faktor Rentabilitas"),
	R_03000201000000 ("03000201000000", "Peringkat Faktor Rentabilitas"),
	R_03000202000000 ("03000202000000", "Peringkat Faktor Rentabilitas Konsolidasi *)"),
	R_03000203000000 ("03000203000000", "Analisis"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER4012PosSaReass0300 eEnum : ER4012PosSaReass0300.values()) {
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
		return UtilFieldConditional.genExistPos("O", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 19 }));
	}
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 13, 14 }));
	}
	
	public static SegmentValidation genValidationMaxLengthNumericDot() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 13, 14 }), 10);
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2", UtilMetadata.genPipeRow(getObjects(), 16, 19));
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric1() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 16, 17), 16);
	}
	
	public static SegmentValidation genValidationMaxLengthNumeric2() {
		return UtilSegmentValidation.genMaxLength("2", UtilMetadata.genPipeRow(getObjects(), 18, 19), 1);
	}
	
	public static SegmentValidation genValidationPeringkat1() {
		return UtilSegmentValidation.genFixedValue("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 18 }), ER1099Peringkat.getPipedKey());
	}
	
	public static SegmentValidation genValidationPeringkat2() {
		return UtilSegmentValidation.genFixedValueOptional("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 19 }), ER1099Peringkat.getPipedKey());
	}
}
