package id.go.ojk.asruk.client.builder.field.rb.uus.reference;

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
public enum ER2137PosReAsruu0101 implements IObject<KeyValueString> {
	R_01010100000000 ("01010100000000", "I.        ASET"),
	R_01010101000000 ("01010101000000", "A.   Investasi"),
	R_01010101010000 ("01010101010000", "1.    Deposito "),
	R_01010101020000 ("01010101020000", "2.    Sertifikat Deposito "),
	R_01010101030000 ("01010101030000", "3.    Saham Syariah"),
	R_01010101040000 ("01010101040000", "4.    Sukuk atau Obligasi Syariah"),
	R_01010101050000 ("01010101050000", "5.    MTN Syariah"),
	R_01010101060000 ("01010101060000", "6.    Surat Berharga Syariah Negara"),
	R_01010101070000 ("01010101070000", "7.    Surat Berharga Syariah yang Diterbitkan Oleh Bank Indonesia"),
	R_01010101080000 ("01010101080000", "8.    Surat Berharga Syariah yang Diterbitkan oleh Negara Selain Negara Republik Indonesia"),
	R_01010101090000 ("01010101090000", "9.    Surat Berharga Syariah yang Diterbitkan oleh Lembaga Multinasional"),
	R_01010101100000 ("01010101100000", "10. Reksa Dana Syariah"),
	R_01010101110000 ("01010101110000", "11. Efek Beragun Aset Syariah"),
	R_01010101120000 ("01010101120000", "12. Dana Investasi Real Estate Syariah "),
	R_01010101130000 ("01010101130000", "13. REPO"),
	R_01010101140000 ("01010101140000", "14. Pembiayaan Melalui Kerjasama dengan Pihak Lain"),
	R_01010101150000 ("01010101150000", "15. Pembiayaan Syariah Dengan Hak Tanggungan"),
	R_01010101160000 ("01010101160000", "16. Penyertaan Langsung"),
	R_01010101170000 ("01010101170000", "17. Properti Investasi"),
	R_01010101180000 ("01010101180000", "18. Emas Murni"),
	R_01010101190000 ("01010101190000", "19. Sukuk Daerah"),
	R_01010101200000 ("01010101200000", "20. Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif"),
	R_01010101210000 ("01010101210000", "21. Investasi Lain"),
	R_01010102000000 ("01010102000000", "B.   Bukan Investasi"),
	R_01010102010000 ("01010102010000", "1.    Kas dan Bank"),
	R_01010102020000 ("01010102020000", "2.    Tagihan Ujrah Penutupan Langsung"),
	R_01010102030000 ("01010102030000", "3.    Tagihan Ujrah Penutupan Tidak Langsung"),
	R_01010102040000 ("01010102040000", "4.    Tagihan Hasil Investasi"),
	R_01010102050000 ("01010102050000", "5.    Tagihan Investasi"),
	R_01010102060000 ("01010102060000", "6.    Aset Reasuransi"),
	R_01010102070000 ("01010102070000", "7.    Biaya Akuisisi yang Ditangguhkan"),
	R_01010102080000 ("01010102080000", "8.    Property Bukan Investasi"),
	R_01010102090000 ("01010102090000", "9.    Aset Lain"),
	R_01010200000000 ("01010200000000", "II.        LIABILITAS DAN EKUITAS"),
	R_01010201000000 ("01010201000000", "A.   Liabilitas"),
	R_01010201010000 ("01010201010000", "1.    Biaya yang Masih Harus Dibayar                 "),
	R_01010201020000 ("01010201020000", "2.    Utang lain"),
	R_01010201030000 ("01010201030000", "3.    Penyisihan Teknis"),
	R_01010201030100 ("01010201030100", "a.    Penyisihan ujroh "),
	R_01010201030200 ("01010201030200", "b.    Penyisihan PAYDI yang memberikan garansi pokok investasi"),
	R_01010202000000 ("01010202000000", "B.   Qardh"),
	R_01010203000000 ("01010203000000", "C.   Ekuitas Dana"),
	R_01010203010000 ("01010203010000", "1.    Modal Disetor "),
	R_01010203020000 ("01010203020000", "2.    Agio/Disagio Saham"),
	R_01010203030000 ("01010203030000", "3.    Saldo Laba"),
	R_01010203040000 ("01010203040000", "4.    Komponen Ekuitas Lainnya. "),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2137PosReAsruu0101 eEnum : ER2137PosReAsruu0101.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2137PosReAsruu0101.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2137PosReAsruu0101.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumericNegative("3|4|5|6",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 2, 4 }));
	}

	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDotNegative("3|4|5|6",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 1, 3, 5, 6 }));
	}
	
	public static FieldValidation genValidationField4() {
		return UtilFieldValidation.genEqualsFormula("3-2", 2);
	}
	
	public static FieldValidation genValidationField5() {
		return UtilFieldValidation.genEqualsRatio("3|2");
	}

	public static SegmentValidation genValidationAsetA() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01010100000000.key,
				R_01010101000000.key + "+" + R_01010102000000.key, 
				"Total Aset|Perhitungan Aset");
	}

	public static SegmentValidation genValidationAsetB() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01010100000000.key, R_01010200000000.key, "Total Aset|Total Liabilitas dan Ekuitas");
	}

	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01010101000000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 22), 
				"Total Investasi|Perhitungan Investasi");
	}

	public static SegmentValidation genValidationBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01010102000000.key,
				UtilMetadata.genPlusRow(getObjects(), 24, 32), 
				"Total Bukan  Investasi|Perhitungan Bukan Investasi");
	}

	public static SegmentValidation genValidationLiabilitasDanEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01010200000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 34, 40, 41 }), 
				"Total Liabilitas dan Ekuitas|Perhitungan Liabilitas dan Ekuitas");
	}

	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01010201000000.key,
				UtilMetadata.genPlusRow(getObjects(), 35, 37), 
				"Total Liabilitas|Perhitungan Liabilitas");
	}

	public static SegmentValidation genValidationPenyisihanTeknis() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01010201030000.key,
				R_01010201030100.key + "+" + R_01010201030200.key, 
				"Total Penyisihan Teknis|Perhitungan Penyisihan Teknis");
	}

	public static SegmentValidation genValidationEkuitasDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01010203000000.key,
				UtilMetadata.genPlusRow(getObjects(), 42, 45), 
				"Total Ekuitas Dana|Perhitungan Ekuitas Dana");
	}
}
