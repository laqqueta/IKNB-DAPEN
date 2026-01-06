package id.go.ojk.asruk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2126PosRbAsruu1203 implements IObject<KeyValueString> {
	R_12030100000000 ("12030100000000", "I.      ASET"),
	R_12030101000000 ("12030101000000", "A.   Investasi"),
	R_12030101010000 ("12030101010000", "1.    Deposito "),
	R_12030101020000 ("12030101020000", "2.    Sertifikat Deposito "),
	R_12030101030000 ("12030101030000", "3.    Saham Syariah"),
	R_12030101040000 ("12030101040000", "4.    Sukuk atau Obligasi Syariah"),
	R_12030101050000 ("12030101050000", "5.    MTN Syariah"),
	R_12030101060000 ("12030101060000", "6.    Surat Berharga Syariah Negara"),
	R_12030101070000 ("12030101070000", "7.    Surat Berharga Syariah yang Diterbitkan oleh Bank Indonesia "),
	R_12030101080000 ("12030101080000", "8.    Surat Berharga Syariah yang Diterbitkan oleh Negara Selain Negara Republik Indonesia"),
	R_12030101090000 ("12030101090000", "9.    Surat Berharga Syariah yang Diterbitkan oleh Lembaga Multinasional"),
	R_12030101100000 ("12030101100000", "10. Reksa Dana Syariah"),
	R_12030101110000 ("12030101110000", "11. Efek Beragun Aset Syariah"),
	R_12030101120000 ("12030101120000", "12. Dana Investasi Real Estate Syariah "),
	R_12030101130000 ("12030101130000", "13. REPO"),
	R_12030101140000 ("12030101140000", "14. Pembiayaan Melalui Kerjasama dengan Pihak Lain"),
	R_12030101150000 ("12030101150000", "15. Emas  Murni"),
	R_12030101160000 ("12030101160000", "16. Sukuk Daerah"),
	R_12030101170000 ("12030101170000", "17. Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif"),
	R_12030101180000 ("12030101180000", "18. Investasi Lain"),
	R_12030102000000 ("12030102000000", "B.  Bukan Investasi"),
	R_12030102010000 ("12030102010000", "1.    Kas dan Bank"),
	R_12030102020000 ("12030102020000", "2.    Tagihan Hasil Investasi"),
	R_12030102030000 ("12030102030000", "3.    Tagihan Investasi"),
	R_12030102040000 ("12030102040000", "4.    Aset Lain"),
	R_12030200000000 ("12030200000000", "II. LIABILITAS DAN EKUITAS"),
	R_12030201000000 ("12030201000000", "A.  Liabilitas"),
	R_12030201010000 ("12030201010000", "1.    Utang klaim dan manfaat dibayar"),
	R_12030201020000 ("12030201020000", "2.    Biaya yang Masih Harus Dibayar                 "),
	R_12030201030000 ("12030201030000", "3.    Utang lain"),
	R_12030202000000 ("12030202000000", "B.  Ekuitas Dana"),
	R_12030202010000 ("12030202010000", "1.    Akumulasi Dana"),
	R_12030202020000 ("12030202020000", "2.    Profit Equalization Reserve (PER)"),
	R_12030202030000 ("12030202030000", "3.    Komponen Ekuitas Lainnya. "),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2126PosRbAsruu1203 eEnum : ER2126PosRbAsruu1203.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2126PosRbAsruu1203.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2126PosRbAsruu1203.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationAsetA() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12030100000000.key,
				R_12030101000000.key + "+" + R_12030102000000.key, 
				"Total Aset|Penjumlahan Aset");
	}

	public static SegmentValidation genValidationAsetB() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12030100000000.key, R_12030200000000.key, "Total Aset|Total Liabilitas dan Ekuitas");
	}

	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12030101000000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 19), 
				"Total Investasi|Penjumlahan Investasi");
	}

	public static SegmentValidation genValidationBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12030102000000.key,
				UtilMetadata.genPlusRow(getObjects(), 21, 24), 
				"Total Bukan Investasi|Penjumlahan Bukan Investasi");
	}

	public static SegmentValidation genValidationLiabilitasDanEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12030200000000.key,
				R_12030201000000.key + "+" + R_12030202000000.key, 
				"Total Liabilitas Dan Ekuitas|Penjumlahan Liabilitas Dan Ekuitas");
	}

	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12030201000000.key,
				UtilMetadata.genPlusRow(getObjects(), 27, 29), 
				"Total Liabilitas|Penjumlahan Liabilitas");
	}

	public static SegmentValidation genValidationEkuitasDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12030202000000.key,
				UtilMetadata.genPlusRow(getObjects(), 31, 33), 
				"Total Ekuitas Dana|Penjumlahan Ekuitas Dana");
	}
}
