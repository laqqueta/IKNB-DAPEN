package id.go.ojk.reass.client.builder.field.rb.reference;

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
public enum ER2029PosReReass0102 implements IObject<KeyValueString> {
	R_01020100000000 ("01020100000000", "I.        ASET"),
	R_01020101000000 ("01020101000000", "A.   Investasi"),
	R_01020101010000 ("01020101010000", "1.    Deposito "),
	R_01020101020000 ("01020101020000", "2.    Sertifikat Deposito "),
	R_01020101030000 ("01020101030000", "3.    Saham Syariah"),
	R_01020101040000 ("01020101040000", "4.    Sukuk atau Obligasi Syariah"),
	R_01020101050000 ("01020101050000", "5.    MTN Syariah"),
	R_01020101060000 ("01020101060000", "6.    Surat Berharga Syariah Syariah Negara"),
	R_01020101070000 ("01020101070000", "7.    Surat Berharga Syariah yang Diterbitkan Oleh Bank Indonesia"),
	R_01020101080000 ("01020101080000", "8.    Surat Berharga Syariah yang Diterbitkan oleh Negara Selain Negara Republik Indonesia"),
	R_01020101090000 ("01020101090000", "9.    Surat Berharga Syariah yang Diterbitkan oleh Lembaga Multinasional"),
	R_01020101100000 ("01020101100000", "10. Reksa dana Syariah"),
	R_01020101110000 ("01020101110000", "11. Efek Beragun Aset Syariah"),
	R_01020101120000 ("01020101120000", "12. Dana Investasi Real Estate Syariah "),
	R_01020101130000 ("01020101130000", "13. REPO"),
	R_01020101140000 ("01020101140000", "14. Pembiayaan Melalui Kerjasama dengan Pihak Lain"),
	R_01020101150000 ("01020101150000", "15. Emas  Murni"),
	R_01020101160000 ("01020101160000", "16. Sukuk Daerah"),
	R_01020101170000 ("01020101170000", "17. Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif"),
	R_01020101180000 ("01020101180000", "18. Investasi Lain"),
	R_01020102000000 ("01020102000000", "B.   Bukan Investasi"),
	R_01020102010000 ("01020102010000", "1.    Kas dan Bank"),
	R_01020102020000 ("01020102020000", "2.    Tagihan Kontribusi Penutupan Langsung"),
	R_01020102030000 ("01020102030000", "3.    Tagihan Kontribusi  Penutupan Tidak Langsung"),
	R_01020102040000 ("01020102040000", "4.    Tagihan Reasuransi"),
	R_01020102050000 ("01020102050000", "5.    Tagihan Kontribusi Koasuransi"),
	R_01020102060000 ("01020102060000", "6.    Tagihan Recovery Klaim Reasuransi"),
	R_01020102070000 ("01020102070000", "7.    Tagihan Hasil Investasi"),
	R_01020102080000 ("01020102080000", "8.    Tagihan Investasi"),
	R_01020102090000 ("01020102090000", "9.    Aset Reasuransi"),
	R_01020102100000 ("01020102100000", "10. Aset Lain"),
	R_01020200000000 ("01020200000000", "II.        LIABILITAS DAN EKUITAS"),
	R_01020201000000 ("01020201000000", "A.   Liabilitas"),
	R_01020201010000 ("01020201010000", "1.    Utang klaim dan manfaat dibayar"),
	R_01020201020000 ("01020201020000", "2.    Biaya yang Masih Harus Dibayar                 "),
	R_01020201030000 ("01020201030000", "3.    Utang lain"),
	R_01020201040000 ("01020201040000", "4.    Penyisihan Teknis"),
	R_01020201040100 ("01020201040100", "a.    Penyisihan kontribusi "),
	R_01020201040200 ("01020201040200", "b.    Penyisihan atas kontribusi yang belum merupakan pendapatan"),
	R_01020201040300 ("01020201040300", "c.    Penyisihan Klaim"),
	R_01020201040400 ("01020201040400", "d.    Penyisihan atas risiko bencana"),
	R_01020202000000 ("01020202000000", "B.   Qardh"),
	R_01020203000000 ("01020203000000", "C.   Ekuitas Dana"),
	R_01020203010000 ("01020203010000", "1.    Akumulasi Dana"),
	R_01020203020000 ("01020203020000", "2.    Komponen Ekuitas Lainnya. "),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2029PosReReass0102 eEnum : ER2029PosReReass0102.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2029PosReReass0102.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2029PosReReass0102.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", ER2029PosReReass0102.getObjects());
	}
	
	public static FieldValidation genValidationField4() {
		return UtilFieldValidation.genEqualsFormula("3-2", 2);
	}
	
	public static FieldValidation genValidationField5() {
		return UtilFieldValidation.genEqualsRatio("3|2");
	}

	public static SegmentValidation genValidationAsetA() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01020100000000.key,
				R_01020101000000.key + "+" + R_01020102000000.key, 
				"Total Aset|Perhitungan Aset");
	}

	public static SegmentValidation genValidationAsetB() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_01020100000000.key, R_01020200000000.key, 
				"Total Aset|Total Liabilitas dan Ekuitas");
	}

	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01020101000000.key,
				UtilMetadata.genPlusRow(getObjects(), 2, 19), 
				"Total Investasi|Perhitungan Investasi");
	}

	public static SegmentValidation genValidationBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01020102000000.key,
				UtilMetadata.genPlusRow(getObjects(), 21, 30), 
				"Total Bukan  Investasi|Perhitungan Bukan Investasi");
	}

	public static SegmentValidation genValidationLiabilitasDanEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01020200000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 32, 41, 42 }), 
				"Total Liabilitas dan Ekuitas|Perhitungan Liabilitas dan Ekuitas");
	}

	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01020201000000.key,
				UtilMetadata.genPlusRow(getObjects(), 33, 36), 
				"Total Liabilitas|Perhitungan Liabilitas");
	}

	public static SegmentValidation genValidationPenyisihanTeknis() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01020201040000.key,
				UtilMetadata.genPlusRow(getObjects(), 37, 40), 
				"Total Penyisihan Teknis|Perhitungan Penyisihan Teknis");
	}

	public static SegmentValidation genValidationEkuitasDana() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_01020203000000.key,
				R_01020203010000.key + "+" + R_01020203020000.key, 
				"Total Ekuitas Dana|Perhitungan Ekuitas Dana");
	}
}
