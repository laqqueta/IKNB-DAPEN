package id.go.ojk.asrus.client.builder.field.rb.reference;

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
public enum ER2024PosRbAsrus1201 implements IObject<KeyValueString> {
	R_12010100000000 ("12010100000000", "I.   ASET"),
	R_12010101000000 ("12010101000000", "A.   Investasi"),
	R_12010101010000 ("12010101010000", "1.    Deposito "),
	R_12010101020000 ("12010101020000", "2.    Sertifikat Deposito "),
	R_12010101030000 ("12010101030000", "3.    Saham Syariah"),
	R_12010101040000 ("12010101040000", "4.    Sukuk atau Obligasi Syariah"),
	R_12010101050000 ("12010101050000", "5.    MTN Syariah"),
	R_12010101060000 ("12010101060000", "6.    Surat Berharga Syariah Negara"),
	R_12010101070000 ("12010101070000", "7.    Surat Berharga Syariah yang Diterbitkan oleh Bank Indonesia"),
	R_12010101080000 ("12010101080000", "8.    Surat Berharga Syariah yang Diterbitkan oleh Negara Selain Negara Republik Indonesia "),
	R_12010101090000 ("12010101090000", "9.    Surat Berharga Syariah yang Diterbitkan oleh Lembaga Multinasional"),
	R_12010101100000 ("12010101100000", "10. Reksa Dana Syariah"),
	R_12010101110000 ("12010101110000", "11. Efek Beragun Aset Syariah"),
	R_12010101120000 ("12010101120000", "12. Dana Investasi Real Estate Syariah "),
	R_12010101130000 ("12010101130000", "13. REPO"),
	R_12010101140000 ("12010101140000", "14. Pembiayaan Melalui Kerjasama dengan Pihak Lain"),
	R_12010101150000 ("12010101150000", "15. Pembiayaan Syariah Dengan Hak Tanggungan"),
	R_12010101160000 ("12010101160000", "16. Penyertaan Langsung"),
	R_12010101170000 ("12010101170000", "17. Properti Investasi"),
	R_12010101180000 ("12010101180000", "18. Emas Murni"),
	R_12010101190000 ("12010101190000", "19. Sukuk Daerah"),
	R_12010101200000 ("12010101200000", "20. Dana Investasi Infrastruktur berbentuk Kontrak Investasi Kolektif"),
	R_12010101210000 ("12010101210000", "21. Investasi Lain"),
	R_12010102000000 ("12010102000000", "B.    Bukan Investasi"),
	R_12010102010000 ("12010102010000", "1.    Kas dan Bank"),
	R_12010102020000 ("12010102020000", "2.    Tagihan Ujrah Penutupan Langsung"),
	R_12010102030000 ("12010102030000", "3.    Tagihan Ujrah Penutupan Tidak Langsung"),
	R_12010102040000 ("12010102040000", "4.    Tagihan Hasil Investasi"),
	R_12010102050000 ("12010102050000", "5.    Tagihan Investasi"),
	R_12010102060000 ("12010102060000", "6.    Aset Reasuransi"),
	R_12010102070000 ("12010102070000", "7.    Biaya Akuisisi yang      Ditangguhkan"),
	R_12010102080000 ("12010102080000", "8.    Property Bukan Investasi"),
	R_12010102090000 ("12010102090000", "9.    Aset Lain"),
	R_12010200000000 ("12010200000000", "II. LIABILITAS DAN EKUITAS"),
	R_12010201000000 ("12010201000000", "A.   Liabilitas"),
	R_12010201010000 ("12010201010000", "1.    Biaya yang Masih Harus Dibayar                 "),
	R_12010201020000 ("12010201020000", "2.    Utang lain"),
	R_12010201030000 ("12010201030000", "3.    Penyisihan Teknis"),
	R_12010201030100 ("12010201030100", "a.    Penyisihan ujroh "),
	R_12010201030200 ("12010201030200", "b.    Penyisihan PAYDI yang memberikan garansi pokok investasi"),
	R_12010202000000 ("12010202000000", "B.    Qardh"),
	R_12010203000000 ("12010203000000", "C.    Ekuitas Dana"),
	R_12010203010000 ("12010203010000", "1.    Modal Disetor "),
	R_12010203020000 ("12010203020000", "2.    Agio/Disagio Saham"),
	R_12010203030000 ("12010203030000", "3.    Saldo Laba"),
	R_12010203040000 ("12010203040000", "4.    Komponen Ekuitas Lainnya. "),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2024PosRbAsrus1201 eEnum : ER2024PosRbAsrus1201.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2024PosRbAsrus1201.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2024PosRbAsrus1201.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationAsetA() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010100000000.key,
				R_12010101000000.key + "+" + R_12010102000000.key, 
				"Total Aset|Penjumlahan Aset");
	}

	public static SegmentValidation genValidationAsetB() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010100000000.key, R_12010200000000.key, "Total Aset|Total Liabilitas dan Ekuitas");
	}

	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010101000000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 22), 
				"Total Investasi|Penjumlahan Investasi");
	}

	public static SegmentValidation genValidationBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010102000000.key,
				UtilMetadata.genPlusRow(getObjects(), 24, 32), 
				"Total Bukan Investasi|Penjumlahan Bukan Investasi");
	}

	public static SegmentValidation genValidationLiabilitasDanEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010200000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 34, 40, 41 }), 
				"Total Liabilitas Dan Ekuitas|Penjumlahan Liabilitas Dan Ekuitas");
	}

	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010201000000.key,
				UtilMetadata.genPlusRow(getObjects(), 35, 37), 
				"Total Liabilitas|Penjumlahan Liabilitas");
	}

	public static SegmentValidation genValidationPenyisihanTeknis() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010201030000.key,
				R_12010201030100.key + "+" + R_12010201030200.key, 
				"Total Penyisihan Teknis|Penjumlahan Penyisihan Teknis");
	}

	public static SegmentValidation genValidationEkuitasDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12010203000000.key,
				UtilMetadata.genPlusRow(getObjects(), 42, 45), 
				"Total Ekuitas Dana|Penjumlahan Ekuitas Dana");
	}
}
