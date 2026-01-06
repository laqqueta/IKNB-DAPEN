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
public enum ER2125PosRbAsruu1202 implements IObject<KeyValueString> {
	R_12020100000000("12020100000000", "I.   ASET"), 
	R_12020101000000("12020101000000", "A.  Investasi"),
	R_12020101010000("12020101010000", "1.    Deposito "),
	R_12020101020000("12020101020000", "2.    Sertifikat Deposito "),
	R_12020101030000("12020101030000", "3.    Saham Syariah"),
	R_12020101040000("12020101040000", "4.    Sukuk atau Obligasi Syariah"),
	R_12020101050000("12020101050000", "5.    MTN Syariah"),
	R_12020101060000("12020101060000", "6.    Surat Berharga Syariah Negara"),
	R_12020101070000("12020101070000", "7.    Surat Berharga Syariah yang Diterbitkan oleh Bank Indonesia "),
	R_12020101080000("12020101080000",
			"8.    Surat Berharga Syariah yang Diterbitkan oleh Negara Selain Negara Republik Indonesia "),
	R_12020101090000("12020101090000", "9.    Surat Berharga Syariah yang Diterbitkan oleh Lembaga Multinasional"),
	R_12020101100000("12020101100000", "10. Reksadana Syariah"),
	R_12020101110000("12020101110000", "11. Efek Beragun Aset Syariah"),
	R_12020101120000("12020101120000", "12. Dana Investasi Real Estate Syariah "),
	R_12020101130000("12020101130000", "13. REPO"),
	R_12020101140000("12020101140000", "14. Pembiayaan Melalui Kerjasama dengan Pihak Lain"),
	R_12020101150000("12020101150000", "15. Emas  Murni"), 
	R_12020101160000("12020101160000", "16. Sukuk Daerah"),
	R_12020101170000("12020101170000", "17. Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif"),
	R_12020101180000("12020101180000", "18. Investasi Lain"), 
	R_12020102000000("12020102000000", "B.  Bukan Investasi"),
	R_12020102010000("12020102010000", "1.    Kas dan Bank"),
	R_12020102020000("12020102020000", "2.    Tagihan Kontribusi Penutupan Langsung"),
	R_12020102030000("12020102030000", "3.    Tagihan Kontribusi  Penutupan Tidak Langsung"),
	R_12020102040000("12020102040000", "4.    Tagihan Reasuransi"),
	R_12020102050000("12020102050000", "5.    Tagihan Kontribusi Koasuransi"),
	R_12020102060000("12020102060000", "6.    Tagihan Recovery Klaim Reasuransi"),
	R_12020102070000("12020102070000", "7.    Tagihan Hasil Investasi"),
	R_12020102080000("12020102080000", "8.    Tagihan Investasi"),
	R_12020102090000("12020102090000", "9.    Aset Reasuransi"), 
	R_12020102100000("12020102100000", "10. Aset Lain"),
	R_12020200000000("12020200000000", "II. LIABILITAS DAN EKUITAS"),
	R_12020201000000("12020201000000", "A.  Liabilitas"),
	R_12020201010000("12020201010000", "1.    Utang klaim dan manfaat dibayar"),
	R_12020201020000("12020201020000", "2.    Biaya yang Masih Harus Dibayar                 "),
	R_12020201030000("12020201030000", "3.    Utang lain"),
	R_12020201040000("12020201040000", "4.    Penyisihan Teknis"),
	R_12020201040100("12020201040100", "a.    Penyisihan kontribusi "),
	R_12020201040200("12020201040200", "b.    Penyisihan atas kontribusi yang belum merupakan pendapatan"),
	R_12020201040300("12020201040300", "c.    Penyisihan Klaim"),
	R_12020201040400("12020201040400", "d.    Penyisihan atas risiko bencana"),
	R_12020202000000("12020202000000", "B.  Qardh"), 
	R_12020203000000("12020203000000", "C.  Ekuitas Dana"),
	R_12020203010000("12020203010000", "1.    Akumulasi Dana"),
	R_12020203020000("12020203020000", "2.    Komponen Ekuitas Lainnya. "),;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2125PosRbAsruu1202 eEnum : ER2125PosRbAsruu1202.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2125PosRbAsruu1202.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2125PosRbAsruu1202.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationAsetA() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12020100000000.key,
				R_12020101000000.key + "+" + R_12020102000000.key, "Total Aset|Penjumlahan Aset");
	}

	public static SegmentValidation genValidationAsetB() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12020100000000.key, R_12020200000000.key, "Total Aset|Total Liabilitas dan Ekuitas");
	}

	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12020101000000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 19), "Total Investasi|Penjumlahan Investasi");
	}

	public static SegmentValidation genValidationBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12020102000000.key,
				UtilMetadata.genPlusRow(getObjects(), 21, 30), "Total Bukan Investasi|Penjumlahan Bukan Investasi");
	}

	public static SegmentValidation genValidationLiabilitasDanEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12020200000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 32, 41, 42 }),
				"Total Liabilitas Dan Ekuitas|Penjumlahan Liabilitas Dan Ekuitas");
	}

	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12020201000000.key,
				UtilMetadata.genPlusRow(getObjects(), 33, 36), "Total Liabilitas|Penjumlahan Liabilitas");
	}

	public static SegmentValidation genValidationPenyisihanTeknis() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12020201040000.key,
				UtilMetadata.genPlusRow(getObjects(), 37, 40), "Total Penyisihan Teknis|Penjumlahan Penyisihan Teknis");
	}

	public static SegmentValidation genValidationEkuitasDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_12020203000000.key,
				R_12020203010000.key + "+" + R_12020203020000.key, "Total Ekuitas Dana|Penjumlahan Ekuitas Dana");
	}
}
