package id.go.ojk.reass.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3006PosLbReass100 implements IObject<KeyValueString> {
	R_1000000099 ("1000000099", "ASET"),
	R_1400000099 ("1400000099", "Investasi"),
	R_1401000000 ("1401000000", "Deposito "),
	R_1402000000 ("1402000000", "Sertifikat Deposito"),
	R_1403000000 ("1403000000", "Saham Syariah"),
	R_1404000000 ("1404000000", "Sukuk atau Obligasi Syariah"),
	R_1420000000 ("1420000000", "MTN Syariah"),
	R_1405000000 ("1405000000", "Surat Berharga Syariah Negara"),
	R_1406000000 ("1406000000", "Surat Berharga Syariah yang Diterbitkan oleh  Bank Indonesia"),
	R_1407000000 ("1407000000", "Surat Berharga Syariah yang Diterbitkan oleh Negara Selain Negara Republik Indonesia"),
	R_1408000000 ("1408000000", "Surat Berharga Syariah yang Diterbitkan oleh Lembaga Multinasional"),
	R_1409000000 ("1409000000", "Reksa Dana Syariah"),
	R_1410000000 ("1410000000", "Efek Beragun Aset Syariah"),
	R_1411000000 ("1411000000", "Dana Investasi Real Estate Syariah"),
	R_1412000000 ("1412000000", "REPO"),
	R_1421000000 ("1421000000", "Pembiayaan Melalui Kerjasama dengan Pihak Lain."),
	R_1413000000 ("1413000000", "Pembiayaan Syariah Dengan Hak Tanggungan"),
	R_1414000000 ("1414000000", "Penyertaan Langsung"),
	R_1415000000 ("1415000000", "Properti Investasi"),
	R_1416000000 ("1416000000", "Emas  murni"),
	R_1417000000 ("1417000000", "Sukuk Daerah"),
	R_1418000000 ("1418000000", "Dana Investasi Infrastruktur berbentuk kontrak investasi kolektif"),
	R_1419000000 ("1419000000", "Investasi lain"),
	R_1499000000 ("1499000000", "Bukan investasi"),
	R_1400000000 ("1400000000", "Kas dan Bank"),
	R_1500000099 ("1500000099", "Tagihan "),
	R_1501000000 ("1501000000", "Aset Reasuransi"),
	R_1502000000 ("1502000000", "Biaya akuisisi yang ditangguhkan"),
	R_1503000000 ("1503000000", "Property Non Investasi"),
	R_1504000000 ("1504000000", "Aset Lain"),
	R_1505000000 ("1505000000", "Liabilitas"),
	R_1506000000 ("1506000000", "Utang klaim atau manfaat investasi"),
	R_1507000000 ("1507000000", "Biaya yang Masih Harus Dibayar"),
	R_1508000000 ("1508000000", "Utang lain"),
	R_1509000000 ("1509000000", "Penyisihan Teknis"),
	R_1510000000 ("1510000000", "Penyisihan ujroh"),
	R_1511000000 ("1511000000", "Penyisihan PAYDI yang memberikan garansi pokok investasi"),
	R_1599000000 ("1599000000", "Penyisihan kontribusi"),
	R_1500000000 ("1500000000", "Penyisihan atas kontribusi yang belum merupakan pendapatan"),
	R_1000000000 ("1000000000", "Penyisihan  klaim"),
	R_2000000099 ("2000000099", "Penyisihan atas risiko bencana"),
	R_2400000099 ("2400000099", "Qardh"),
	R_2401000000 ("2401000000", "Ekuitas Dana"),
	R_2402000000 ("2402000000", "Modal Disetor "),
	R_2403000000 ("2403000000", "Agio/Disagio Saham"),
	R_2404000000 ("2404000000", "Akumulasi Dana"),
	R_2405000000 ("2405000000", "Profit Equilization Reserve"),
	R_2406000000 ("2406000000", "Saldo Laba"),
	R_2407000000 ("2407000000", "Komponen Ekuitas Lainnya"),
	R_2400000000 ("2400000000", "Selisih Saldo SAK dan Saldo SAP"),
	R_2500000099 ("2500000099", "Kekayaan Yang Tidak Diperkenankan"),
	R_2501000000 ("2501000000", "LIABILITAS DAN EKUITAS"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3006PosLbReass100 eEnum : ER3006PosLbReass100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 9), getObjects());
	}
	
	public static ConditionalRequired genConditional8() {
		return UtilFieldConditional.genExistPos("N", "O", 
				UtilMetadata.genPipeRow(getObjects(), 0, 1));
	}
	
	public static FieldValidation genValidation9() {
		return UtilFieldValidation.genEqualsPosFormula(UtilMetadata.genPlusColumn(2, 7) + "-8", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 0, 1, 50 }));
	}

	public static SegmentValidation genValidationAsetA() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7) + "|9", R_1000000099.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 1, 23 }), "Total Aset|Penjumlahan Aset");
	}

	public static SegmentValidation genValidationAsetB() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 5, 6, 9 }), R_1000000099.key, 
				R_2501000000.key, "Aset|Liabilitas dan Ekuitas");
	}

	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 7) + "|9", R_1400000099.key, 
				UtilMetadata.genPlusRow(getObjects(), 2, 22), "Total Investasi|Penjumlahan Investasi");
	}

	public static SegmentValidation genValidationBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 8), R_1499000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 24, 29), "Total Bukan Investasi|Penjumlahan Bukan Investasi");
	}

	public static SegmentValidation genValidationLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 8), R_1505000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 31, 34), "Total Liabilitas|Penjumlahan Liabilitas");
	}

	public static SegmentValidation genValidationPenyisihanTeknis() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 8), R_1509000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 35, 40), "Total Penyisihan Teknis|Penjumlahan Penyisihan Teknis");
	}

	public static SegmentValidation genValidationEkuitasDana() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 8), R_2401000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 43, 50), "Total Ekuitas Dana|Penjumlahan Ekuitas Dana");
	}

	public static SegmentValidation genValidationKekayaanYangTidakDiperkenankan() {
		return UtilSegmentValidation.genFixedValue("9", R_2500000099.key, "0");
	}

	public static SegmentValidation genValidationLiabilitasDanEkuitas() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 8), R_2501000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 30, 42 }), "Total Liabilitas dan Ekuitas|Penjumlahan Liabilitas dan Ekuitas");
	}
}
