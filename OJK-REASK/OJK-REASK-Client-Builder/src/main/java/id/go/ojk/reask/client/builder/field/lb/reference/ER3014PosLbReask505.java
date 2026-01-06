package id.go.ojk.reask.client.builder.field.lb.reference;

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
public enum ER3014PosLbReask505 implements IObject<KeyValueString> {
//	R_1000000099 ("1000000099", "Aset Yang Diperkenankan"),
	R_1401000000 ("1401000000", "Deposito Berjangka "),
	R_1402000000 ("1402000000", "Sertifikat Deposito"),
	R_1403000000 ("1403000000", "Saham "),
	R_1404000000 ("1404000000", "Obligasi Korporasi"),
	R_1420000000 ("1420000000", "Obligasi / Sukuk Daerah"),
	R_1405000000 ("1405000000", "MTN"),
	R_1406000000 ("1406000000", "Surat Berharga yang Diterbitkan oleh Negara RI"),
	R_1407000000 ("1407000000", "Surat Berharga yang Diterbitkan oleh Negara Selain Negara RI "),
	R_1408000000 ("1408000000", "Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
	R_1409000000 ("1409000000", "Surat Berharga yang Diterbitkan oleh Lembaga Multinasional"),
	R_1410000000 ("1410000000", "Reksa Dana"),
	R_1411000000 ("1411000000", "Efek Beragun Aset"),
	R_1412000000 ("1412000000", "Dana Investasi Real Estat"),
	R_1421000000 ("1421000000", "Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolekti"),
	R_1413000000 ("1413000000", "REPO"),
	R_1414000000 ("1414000000", "Penyertaan Langsung"),
	R_1415000000 ("1415000000", "Tanah, Bangunan dengan Hak Strata, atau Tanah dengan Bangunan, untuk Investasi"),
	R_1416000000 ("1416000000", "Pembiayaan Melalui Kerjasama dengan Pihak Lain (Executing)"),
	R_1417000000 ("1417000000", "Emas Murni"),
	R_1418000000 ("1418000000", "Pinjaman yang Dijamin dengan Hak Tanggungan"),
	R_1419000000 ("1419000000", "Pinjaman Polis"),
	R_1501000000 ("1501000000", "Kas dan Bank"),
	R_1502000000 ("1502000000", "Tagihan Premi Penutupan Langsung"),
	R_1503000000 ("1503000000", "Tagihan Premi Reasuransi"),
	R_1504000000 ("1504000000", "Aset Reasuransi"),
	R_1505000000 ("1505000000", "Tagihan Klaim Koasuransi"),
	R_1506000000 ("1506000000", "Tagihan Klaim Reasuransi"),
	R_1507000000 ("1507000000", "Tagihan Investasi"),
	R_1508000000 ("1508000000", "Tagihan Hasil Investasi"),
	R_1509000000 ("1509000000", "Bangunan dengan Hak Strata atau Tanah dengan Bangunan untuk Dipakai Sendiri"),
	R_1510000000 ("1510000000", "Biaya Akuisisi yang Ditangguhkan"),
	R_1000000000 ("1000000000", "Jumlah Aset Yang Diperkenankan "),
//	R_2000000099 ("2000000099", "Liabilitas"),
	R_2401000000 ("2401000000", "Utang Klaim"),
	R_2402000000 ("2402000000", "Utang Koasuransi"),
	R_2403000000 ("2403000000", "Utang Reasuransi"),
	R_2404000000 ("2404000000", "Utang Komisi"),
	R_2405000000 ("2405000000", "Utang Pajak"),
	R_2406000000 ("2406000000", "Biaya yang Masih Harus Dibayar"),
	R_2407000000 ("2407000000", "Utang Lain"),
	R_2501000000 ("2501000000", "Cadangan Premi"),
	R_2502000000 ("2502000000", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan"),
	R_2503000000 ("2503000000", "Cadangan Klaim "),
	R_2504000000 ("2504000000", "Cadangan atas Risiko Bencana (Catastrophic)"),
	R_2000000000 ("2000000000", "Jumlah Liabilitas "),
	R_2002000000 ("2002000000", "Kurs (konversi ke Rupiah)"),
	R_7100000000 ("7100000000", "Jumlah Aset Yang Diperkenankan Dalam Rupiah "),
	R_2000000098 ("2000000098", "Jumlah Liabilitas Dalam Rupiah "),
	R_7303020100 ("7303020100", "Selisih Aset Yang Diperkenankan atas Liabilitas "),
	R_7303020200 ("7303020200", "Faktor (sesuai SE MMBR 2017)"),
	R_7303020000 ("7303020000", "Jumlah Deviasi"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3014PosLbReask505 eEnum : ER3014PosLbReask505.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("3|4|6|7|9|10|12|13|15|16|18|19|21|22|24|25|27|28|30|31|33|34|36|37|39|40|42|43|45|46|48|49|51|52|54|55|57|58|60|61|62|63", 
				getObjects());
	}
	
	public static ConditionalRequired genConditionMustEmpty62_63() {
		return UtilFieldConditional.genExistPos("M", "N", UtilMetadata.genPipeRow(getObjects(), new int[] { 45, 46, 47, 49 }));
	}

	public static FieldValidation genFieldValidationUniqueToOther(String checkField) {
		return UtilFieldValidation.genUniqueToOther(checkField);
	}
	
	public static FieldValidation genFieldValidation62() {
		return UtilFieldValidation.genEqualsPosFormula("3+6+9+12+15+18+21+24+27+30+33+36+39+42+45+48+51+54+57+60", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 45, 46, 49 }));
	}

	public static FieldValidation genFieldValidation63() {
		return UtilFieldValidation.genEqualsPosFormula("4+7+10+13+16+19+22+25+28+31+34+37+40+43+46+49+52+55+58+61", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 45, 46, 49 }));
	}
	
	public static SegmentValidation genValidationNumericNegatif() {
		return UtilSegmentValidation.genRegexNumericNegative("3|4|6|7|9|10|12|13|15|16|18|19|21|22|24|25|27|28|30|31|33|34|36|37|39|40|42|43|45|46|48|49|51|52|54|55|57|58|60|61", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 48 }));
	}
	
	public static SegmentValidation genValidationNumericDotNegatif() {
		return UtilSegmentValidation.genRegexNumericDotNegative("3|4|6|7|9|10|12|13|15|16|18|19|21|22|24|25|27|28|30|31|33|34|36|37|39|40|42|43|45|46|48|49|51|52|54|55|57|58|60|61", 
				R_7303020200.key);
	}
	
	public static SegmentValidation genValidationJumlahAsetYangDiperkenankan() {
		return UtilSegmentValidation.genEqualsFormula("3|4|6|7|9|10|12|13|15|16|18|19|21|22|24|25|27|28|30|31|33|34|36|37|39|40|42|43|45|46|48|49|51|52|54|55|57|58|60|61", 
				R_1000000000.key, UtilMetadata.genPlusRow(getObjects(), 0, 30), 
				"Total Aset Yang Diperkenankan|Penjumlahan Aset Yang Diperkenankan");
	}
	
	public static SegmentValidation genValidationJumlahLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("3|4|6|7|9|10|12|13|15|16|18|19|21|22|24|25|27|28|30|31|33|34|36|37|39|40|42|43|45|46|48|49|51|52|54|55|57|58|60|61", 
				R_2000000000.key, UtilMetadata.genPlusRow(getObjects(), 32, 42), 
				"Jumlah Liabilitas|Penjumlahan Liabilitas");
	}
	
	public static SegmentValidation genValidationJumlahAsetYangDiperkenankanDalamRupiah() {
		return UtilSegmentValidation.genEqualsFormula("3|4|6|7|9|10|12|13|15|16|18|19|21|22|24|25|27|28|30|31|33|34|36|37|39|40|42|43|45|46|48|49|51|52|54|55|57|58|60|61", 
				R_7100000000.key, R_1000000000.key + "*" + R_2002000000.key, 
				"Jumlah Aset Yang Diperkenankan Dalam Rupiah|Perhitungan Jumlah Aset Yang Diperkenankan Dalam Rupiah");
	}
	
	public static SegmentValidation genValidationJumlahLiabilitasDalamRupiah() {
		return UtilSegmentValidation.genEqualsFormula("3|4|6|7|9|10|12|13|15|16|18|19|21|22|24|25|27|28|30|31|33|34|36|37|39|40|42|43|45|46|48|49|51|52|54|55|57|58|60|61", 
				R_2000000098.key, R_2000000000.key + "*" + R_2002000000.key, 
				"Total Liabilitas Dalam Rupiah|Perhitungan Liabilitas Dalam Rupiah");
	}
	
	public static SegmentValidation genValidationSelisihAsetYangDiperkenankanAtasLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("3|4|6|7|9|10|12|13|15|16|18|19|21|22|24|25|27|28|30|31|33|34|36|37|39|40|42|43|45|46|48|49|51|52|54|55|57|58|60|61|62|63", 
				R_7303020100.key, R_7100000000.key + "-" + R_2000000098.key, 
				"Selisih Aset Yang Diperkenankan atas Liabilitas|Perhitungan Selisih Aset Yang Diperkenankan atas Liabilitas");
	}
	
	public static SegmentValidation genValidationFaktorSeMmbr2017() {
		return UtilSegmentValidation.genFactorSeMmbr2017Validation("3|4|6|7|9|10|12|13|15|16|18|19|21|22|24|25|27|28|30|31|33|34|36|37|39|40|42|43|45|46|48|49|51|52|54|55|57|58", 
				R_7303020200.key, R_7303020100.key, R_2000000098.key);
	}
	
	public static SegmentValidation genValidationDeviationFaktorSeMmbr2017() {
		return UtilSegmentValidation.genDeviationFactorSeMmbr2017Validation("3|4|6|7|9|10|12|13|15|16|18|19|21|22|24|25|27|28|30|31|33|34|36|37|39|40|42|43|45|46|48|49|51|52|54|55|57|58", 
				R_7303020000.key, R_7303020200.key, R_7100000000.key, R_2000000098.key, 0);
	}
}
