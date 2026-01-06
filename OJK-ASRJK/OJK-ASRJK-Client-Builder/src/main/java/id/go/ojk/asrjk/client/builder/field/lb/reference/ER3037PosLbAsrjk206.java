package id.go.ojk.asrjk.client.builder.field.lb.reference;

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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3037PosLbAsrjk206 implements IObject<KeyValueString> {
//	R_4901000099 ("4901000099", "Klaim dan Manfaat Dibayar"),
	R_4901010000 ("4901010000", "   a. Akhir Kontrak (Jatuh Tempo)"),
	R_4901020000 ("4901020000", "   b. Klaim Meninggal"),
	R_4901030000 ("4901030000", "   c. Nilai Tunai"),
	R_4901990000 ("4901990000", "   d. Lain-lain"),
	R_4901000000 ("4901000000", "Jumlah Klaim dan Manfaat Dibayar"),
	R_4902000000 ("4902000000", "Klaim Reasuransi"),
//	R_4903000099 ("4903000099", "Kenaikan (Penurunan) Cadangan Premi"),
	R_4903010000 ("4903010000", "a. Kenaikan (Penurunan) Cadangan Premi (Gross)"),
	R_4903010100 ("4903010100", "    (1) Cadangan Premi tahun berjalan"),
	R_4903010200 ("4903010200", "    (2) Cadangan Premi tahun lalu -/-"),
	R_4903020000 ("4903020000", "b. Kenaikan (Penurunan) Aset Reasuransi Atas Cadangan Premi"),
	R_4903020100 ("4903020100", "    (1) Aset Reasuransi Atas Cadangan Premi tahun berjalan"),
	R_4903020200 ("4903020200", "    (2) Aset Reasuransi Atas Cadangan Premi tahun lalu"),
	R_4903000000 ("4903000000", "Jumlah Kenaikan (Penurunan) Cadangan Premi"),
//	R_4904000099 ("4904000099", "Kenaikan (Penurunan) Cadangan Klaim"),
	R_4904010000 ("4904010000", "a. Kenaikan (Penurunan) Cadangan Klaim (Gross)"),
	R_4904010100 ("4904010100", "    (1) Cadangan Klaim tahun berjalan"),
	R_4904010200 ("4904010200", "    (2) Cadangan Klaim tahun lalu -/-"),
	R_4904020000 ("4904020000", "b. Kenaikan (Penurunan) Aset Reasuransi Atas Cadangan Klaim"),
	R_4904020100 ("4904020100", "    (1) Aset Reasuransi Atas Cadangan Klaim tahun berjalan"),
	R_4904020200 ("4904020200", "    (2) Aset Reasuransi Atas Cadangan Klaim tahun lalu -/-"),
	R_4904000000 ("4904000000", "Jumlah Kenaikan (Penurunan) Cadangan Klaim"),
//	R_4905000099 ("4905000099", "Kenaikan (Penurunan) Cadangan atas Risiko Bencana (Catastrophic)"),
	R_4905010100 ("4905010100", "    (1) Cadangan Cadangan atas Risiko Bencana tahun berjalan"),
	R_4905010200 ("4905010200", "    (2) Cadangan Cadangan atas Risiko Bencana tahun lalu -/-"),
	R_4905000000 ("4905000000", "Jumlah Kenaikan (Penurunan) Cadangan atas Risiko Bencana (Catastrophic)"),
	R_4906000000 ("4906000000", "Jumlah Beban Klaim dan Manfaat"),
//	R_4907000099 ("4907000099", "Biaya Akuisisi "),
	R_4907010000 ("4907010000", "   a. Beban Komisi - Tahun Pertama"),
	R_4907020000 ("4907020000", "   b. Beban Komisi - Tahun Lanjutan"),
	R_4907030000 ("4907030000", "   c. Beban Komisi - Overiding"),
	R_4907990000 ("4907990000", "   d. Beban Lainnya"),
	R_4907000000 ("4907000000", "Jumlah  Biaya Akuisisi "),
	R_4908000000 ("4908000000", "Jumlah Beban Asuransi"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3037PosLbAsrjk206 eEnum : ER3037PosLbAsrjk206.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3037PosLbAsrjk206.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3037PosLbAsrjk206.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 10), getObjects());
	}

	public static FieldValidation genFieldValidation10() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 9), 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 6, 9, 12, 13, 16, 19, 22, 23, 28, 29 }));
	}
	
	public static SegmentValidation genValidationKlaimDanManfaatDibayar() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4901000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 3), 
				"Total klaim dan manfaat dibayar|Penjumlahan klaim dan manfaat dibayar");
	}
	
	public static SegmentValidation genValidationKenaikanCadanganPremiGross() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4903010000.key, 
				UtilMetadata.genMinusRow(getObjects(), 7, 8), 
				"Total kenaikan (penurunan) cadangan premi (gross)|Penjumlahan kenaikan (penurunan) cadangan premi (gross)");
	}
	
	public static SegmentValidation genValidationKenaikanAsetReasuransiAtasCadanganPremi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4903020000.key, 
				UtilMetadata.genMinusRow(getObjects(), 10, 11), 
				"Total kenaikan (penurunan) aset reasuransi atas cadangan premi|Penjumlahan kenaikan (penurunan) aset reasuransi atas cadangan premi");
	}
	
	public static SegmentValidation genValidationKenaikanCadanganPremi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4903000000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 6, 9 }), 
				"Total kenaikan (penurunan) cadangan premi|Penjumlahan kenaikan (penurunan) cadangan premi");
	}
	
	public static SegmentValidation genValidationKenaikanCadanganKlaimGross() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4904010000.key, 
				UtilMetadata.genMinusRow(getObjects(), 14, 15), 
				"Total kenaikan (penurunan) cadangan klaim (gross)|Penjumlahan kenaikan (penurunan) cadangan klaim (gross)");
	}
	
	public static SegmentValidation genValidationKenaikanAsetReasuransiAtasCadanganKlaim() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4904020000.key, 
				UtilMetadata.genMinusRow(getObjects(), 17, 18), 
				"Total kenaikan (penurunan) aset reasuransi atas cadangan klaim|Penjumlahan kenaikan (penurunan) aset reasuransi atas cadangan klaim");
	}
	
	public static SegmentValidation genValidationKenaikanCadanganKlaim() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4904000000.key, 
				UtilMetadata.genMinusRow(getObjects(), new int[] { 13, 16 }), 
				"Total kenaikan (penurunan) cadangan klaim|Penjumlahan kenaikan (penurunan) cadangan klaim");
	}
	
	public static SegmentValidation genValidationKenaikanCadanganAtasRisikoBencana() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4905000000.key, 
				UtilMetadata.genMinusRow(getObjects(), 20, 21), 
				"Total kenaikan (penurunan) cadangan atas risiko bencana (catastrophic)|Penjumlahan kenaikan (penurunan) cadangan atas risiko bencana (catastrophic)");
	}
	
	public static SegmentValidation genValidationBebanKlaimDanManfaat() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4906000000.key, 
				R_4901000000.key + "-" + UtilMetadata.genPlusRow(getObjects(), new int[] { 5, 12, 19, 22 }), 
				"Total beban klaim dan manfaat|Penjumlahan beban klaim dan manfaat");
	}
	
	public static SegmentValidation genValidationKenaikanBiayaAkuisisi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4907000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 24, 27), 
				"Total biaya akuisisi|Penjumlahan biaya akuisisi");
	}
	
	public static SegmentValidation genValidationBebanAsuransi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 10), R_4908000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 23, 28 }), 
				"Total beban asuransi|Penjumlahan beban asuransi");
	}
}
