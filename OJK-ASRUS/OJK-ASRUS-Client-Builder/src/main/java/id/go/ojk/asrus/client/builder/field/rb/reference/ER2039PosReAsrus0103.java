package id.go.ojk.asrus.client.builder.field.rb.reference;

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
public enum ER2039PosReAsrus0103 implements IObject<KeyValueString> {
	R_01030100000000 ("01030100000000", "I.        ASET"),
	R_01030101000000 ("01030101000000", "A.   Investasi"),
	R_01030101010000 ("01030101010000", "1.    Deposito "),
	R_01030101020000 ("01030101020000", "2.    Sertifikat Deposito "),
	R_01030101030000 ("01030101030000", "3.    Saham Syariah"),
	R_01030101040000 ("01030101040000", "4.    Sukuk atau Obligasi Syariah"),
	R_01030101050000 ("01030101050000", "5.    MTN Syariah"),
	R_01030101060000 ("01030101060000", "6.    Surat Berharga Syariah Negara"),
	R_01030101070000 ("01030101070000", "7.    Surat Berharga Syariah yang Diterbitkan Oleh Bank Indonesia"),
	R_01030101080000 ("01030101080000", "8.    Surat Berharga Syariah yang Diterbitkan oleh  Negara Selain Negara Republik Indonesia"),
	R_01030101090000 ("01030101090000", "9.    Surat Berharga Syariah yang Diterbitkan oleh Lembaga Multinasional"),
	R_01030101100000 ("01030101100000", "10. Reksadana Syariah"),
	R_01030101110000 ("01030101110000", "11. Efek Beragun Aset Syariah"),
	R_01030101120000 ("01030101120000", "12. Dana Investasi Real Estate Syariah "),
	R_01030101130000 ("01030101130000", "13. REPO"),
	R_01030101140000 ("01030101140000", "14. Pembiayaan Melalui Kerjasama dengan Pihak Lain"),
	R_01030101150000 ("01030101150000", "15. Emas  Murni"),
	R_01030101160000 ("01030101160000", "16. Sukuk Daerah"),
	R_01030101170000 ("01030101170000", "17. Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif"),
	R_01030101180000 ("01030101180000", "18. Investasi Lain"),
	R_01030102000000 ("01030102000000", "B.   Bukan Investasi"),
	R_01030102010000 ("01030102010000", "1.    Kas dan Bank"),
	R_01030102020000 ("01030102020000", "2.    Tagihan Hasil Investasi"),
	R_01030102030000 ("01030102030000", "3.    Tagihan Investasi"),
	R_01030102040000 ("01030102040000", "4.    Aset Lain"),
	R_01030200000000 ("01030200000000", "II.        LIABILITAS DAN EKUITAS"),
	R_01030201000000 ("01030201000000", "A.   Liabilitas"),
	R_01030201010000 ("01030201010000", "1.    Utang klaim dan manfaat dibayar"),
	R_01030201020000 ("01030201020000", "2.    Biaya yang Masih Harus Dibayar                 "),
	R_01030201030000 ("01030201030000", "3.    Utang lain"),
	R_01030202000000 ("01030202000000", "B.   Ekuitas Dana"),
	R_01030202010000 ("01030202010000", "1.    Akumulasi Dana"),
	R_01030202020000 ("01030202020000", "2.    Profit Equalization Reserve (PER)"),
	R_01030202030000 ("01030202030000", "               3.    Komponen Ekuitas Lainnya. "),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2039PosReAsrus0103 eEnum : ER2039PosReAsrus0103.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2039PosReAsrus0103.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2039PosReAsrus0103.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}
	
	public static FieldValidation genValidationField4() {
		return UtilFieldValidation.genEqualsFormula("3-2", 2);
	}
	
	public static FieldValidation genValidationField5() {
		return UtilFieldValidation.genEqualsRatio("3|2");
	}

	public static SegmentValidation genValidationAset() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01030100000000.key,
				R_01030101000000.key + "+" + R_01030102000000.key, 
				"Total Aset|Perhitungan Aset");
	}

	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01030101000000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 19), 
				"Total Investasi|Perhitungan Investasi");
	}

	public static SegmentValidation genValidationBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01030102000000.key,
				UtilMetadata.genPlusRow(getObjects(), 21, 24), 
				"Total Bukan  Investasi|Perhitungan Bukan Investasi");
	}

	public static SegmentValidation genValidationLiabilitasDanEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01030200000000.key,
				R_01030201000000.key + "+" + R_01030202000000.key, 
				"Total Liabilitas dan Ekuitas|Perhitungan Liabilitas dan Ekuitas");
	}

	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01030201000000.key,
				UtilMetadata.genPlusRow(getObjects(), 27, 29), 
				"Total Liabilitas|Perhitungan Liabilitas");
	}

	public static SegmentValidation genValidationEkuitasDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01030202000000.key,
				UtilMetadata.genPlusRow(getObjects(), 31, 33), 
				"Total Ekuitas Dana|Perhitungan Ekuitas Dana");
	}
}
