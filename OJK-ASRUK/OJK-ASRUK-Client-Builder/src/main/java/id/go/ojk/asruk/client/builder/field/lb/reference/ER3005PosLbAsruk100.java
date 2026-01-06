package id.go.ojk.asruk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1000JenisInvestasi;
import id.go.ojk.conf.client.field.reference.ER1036TradisionalAtauPaydi;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3005PosLbAsruk100 implements IObject<KeyValueString> {
	//	R_1000000099 ("1000000099", "ASET"),
	//	R_1400000099 ("1400000099", "Investasi"),
	R_1401000000 ("1401000000", "Deposito Berjangka "),
	R_1402000000 ("1402000000", "Sertifikat Deposito"),
	R_1403000000 ("1403000000", "Saham "),
	R_1404000000 ("1404000000", "Obligasi Korporasi"),
	R_1420000000 ("1420000000", "Obligasi / Sukuk Daerah"),
	R_1405000000 ("1405000000", "MTN"),
	R_1406000000 ("1406000000", "Surat Berharga yang Diterbitkan oleh Negara RI "),
	R_1407000000 ("1407000000", "Surat Berharga yang Diterbitkan oleh Negara Selain Negara RI "),
	R_1408000000 ("1408000000", "Surat Berharga yang Diterbitkan oleh Bank Indonesia"),
	R_1409000000 ("1409000000", "Surat Berharga yang Diterbitkan oleh Lembaga Multinasional"),
	R_1410000000 ("1410000000", "Reksa Dana"),
	R_1411000000 ("1411000000", "Efek Beragun Aset"),
	R_1412000000 ("1412000000", "Dana Investasi Real Estat"),
	R_1421000000 ("1421000000", "Dana Investasi Infrastruktur Berbentuk Kontrak Investasi Kolektif"),
	R_1413000000 ("1413000000", "REPO"),
	R_1414000000 ("1414000000", "Penyertaan Langsung"),
	R_1415000000 ("1415000000", "Tanah, Bangunan dengan Hak Strata, atau Tanah dengan Bangunan, untuk Investasi"),
	R_1416000000 ("1416000000", "Pembiayaan Melalui Kerjasama dengan Pihak Lain (Executing)"),
	R_1417000000 ("1417000000", "Emas Murni"),
	R_1418000000 ("1418000000", "Pinjaman yang Dijamin dengan Hak Tanggungan"),
	R_1419000000 ("1419000000", "Pinjaman Polis"),
	R_1499000000 ("1499000000", "Investasi Lain"),
	R_1400000000 ("1400000000", "Jumlah Investasi"),
//	R_1500000099 ("1500000099", "Bukan Investasi"),
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
	R_1511000000 ("1511000000", "Aset Tetap Lain"),
	R_1599000000 ("1599000000", "Aset Lain"),
	R_1500000000 ("1500000000", "Jumlah Bukan Investasi"),
	R_1000000000 ("1000000000", "JUMLAH ASET"),
//	R_2000000099 ("2000000099", "Liabilitas"),
//	R_2400000099 ("2400000099", "Utang"),
	R_2401000000 ("2401000000", "Utang Klaim"),
	R_2402000000 ("2402000000", "Utang Koasuransi"),
	R_2403000000 ("2403000000", "Utang Reasuransi"),
	R_2404000000 ("2404000000", "Utang Komisi"),
	R_2405000000 ("2405000000", "Utang Pajak"),
	R_2406000000 ("2406000000", "Biaya yang Masih Harus Dibayar"),
	R_2407000000 ("2407000000", "Utang Lain"),
	R_2400000000 ("2400000000", "Jumlah Utang"),
//	R_2500000099 ("2500000099", "Cadangan Teknis"),
	R_2501000000 ("2501000000", "Cadangan Premi"),
	R_2502000000 ("2502000000", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan"),
	R_2503000000 ("2503000000", "Cadangan Klaim "),
	R_2504000000 ("2504000000", "Cadangan atas Risiko Bencana (Catastrophic)"),
	R_2500000000 ("2500000000", "Jumlah Cadangan Teknis"),
	R_2000000000 ("2000000000", "Jumlah Liabilitas"),
	R_2600000000 ("2600000000", "Pinjaman Subordinasi"),
//	R_3000000099 ("3000000099", "Ekuitas"),
	R_3401000000 ("3401000000", "Modal Disetor"),
	R_3402000000 ("3402000000", "Agio Saham"),
	R_3403000000 ("3403000000", "Saldo Laba"),
	R_3404000000 ("3404000000", "Komponen Ekuitas Lainnya"),
	R_3405000000 ("3405000000", "Selisih Penilaian Berdasar SAK & SAP"),
	R_3406000000 ("3406000000", "Aset yang Tidak Termasuk AYD"),
	R_3000000000 ("3000000000", "Jumlah Ekuitas"),
	R_3999999999 ("3999999999", "Jumlah LIABILITAS dan EKUITAS (harus sama dengan JUMLAH ASET)"),
	;
	
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3005PosLbAsruk100 eEnum : ER3005PosLbAsruk100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5|6|7|8|9|10|11|12", getObjects());
	}

	public static ConditionalRequired genConditionalExistPos10() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 31, 33, 34, 41, 42, 43, 52, 53, 54, 55, 56, 57 }));
	}
	public static ConditionalRequired genConditionalExistPos11() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 51 }));
	}

	public static ConditionalRequired genConditionalExistPos2() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 56, 57 }));
	}
	
	public static ConditionalRequired genConditionalExistPos3() {
		return UtilFieldConditional.genExistPos("N", "M", 
				UtilMetadata.genPipeRow(getObjects(), new int[] { 21, 33, 34 }));
	}

	public static ConditionalRequired genConditionalExistPos4() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRow(getObjects(), 
						new int[] { 0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 14, 18, 22, 23, 24, 30, 34, 35, 36, 37, 40, 43, 44, 45, 49, 50, 58, 59 }));
	}
	
	public static ConditionalRequired genConditionalExistPos5() {
		return UtilFieldConditional.genExistPos("M", "N", 
				UtilMetadata.genPipeRow(getObjects(), 
						new int[] { 0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 14, 18, 22, 23, 24, 30, 35, 36, 37, 40, 43, 44, 45, 49, 50, 56, 57, 58, 59 }));
	}
	
	public static SegmentValidation genFormValidationBukanInvestasiPaydiSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1500000000.key, "17", 
				ER3026PosLbAsruk109.R_1400090100.getFormKey(), "2", ER1036TradisionalAtauPaydi.R_PYD.getKey(),
				"Total bukan investasi PAYDI saldo SAK|Penjumlahan bukan investasi PAYDI saldo SAK pada form " + EFormLaporanBulanan.LB_109.getCode());
	}
	
	public static SegmentValidation genFormValidationBukanInvestasiPaydiSap() {
		return UtilSegmentValidation.genEqualsFormulaForm2("5", R_1500000000.key, "18", 
				ER3026PosLbAsruk109.R_1400090100.getFormKey(), "2", ER1036TradisionalAtauPaydi.R_PYD.getKey(),
				"Total bukan investasi PAYDI saldo SAP|Penjumlahan bukan investasi PAYDI saldo SAP pada form " + EFormLaporanBulanan.LB_109.getCode());
	}
	
	public static SegmentValidation genFormValidationBukanInvestasiTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1500000000.key, "17", 
				ER3026PosLbAsruk109.R_1400090100.getFormKey(), "2", ER1036TradisionalAtauPaydi.R_TRD.getKey(),
				"Total bukan investasi tradisional saldo SAK|Penjumlahan bukan investasi tradisional saldo SAK pada form " + EFormLaporanBulanan.LB_109.getCode());
	}
	
	public static SegmentValidation genFormValidationBukanInvestasiTradisionalSak2() {
		return UtilSegmentValidation.genEqualsForm("2", R_1500000000.key, EFormLaporanBulanan.LB_101.getCode(), "2", 
				ER3018PosLbAsruk101.R_1500000000.getKey());
	}
	
	public static SegmentValidation genFormValidationBukanInvestasiTradisionalSap() {
		return UtilSegmentValidation.genEqualsFormulaForm2("3", R_1500000000.key, "18", 
				ER3026PosLbAsruk109.R_1400090100.getFormKey(), "2", ER1036TradisionalAtauPaydi.R_TRD.getKey(),
				"Total bukan investasi tradisional saldo SAP|Penjumlahan bukan investasi tradisional saldo SAP pada form " + EFormLaporanBulanan.LB_109.getCode());
	}
	
	public static SegmentValidation genFormValidationCadanganAtasPremiYangBelumMerupakanPendapatanTradisionalSak() {
		return UtilSegmentValidation.genEqualsForm("2", R_2502000000.key, EFormLaporanBulanan.LB_101.getCode(), "2", 
				ER3018PosLbAsruk101.R_2502000000.getKey());
	}
	
	public static SegmentValidation genFormValidationCadanganAtasRisikoBencanaTradisionalSak() {
		return UtilSegmentValidation.genEqualsForm("2", R_2504000000.key, EFormLaporanBulanan.LB_101.getCode(), "2", 
				ER3018PosLbAsruk101.R_2504000000.getKey());
	}
	
	public static SegmentValidation genFormValidationCadanganAtasRisikoBencanaTradisionalSap() {
		return UtilSegmentValidation.genEqualsForm("3", R_2504000000.key, EFormLaporanBulanan.LB_114.getCode(), "2", 
				ER3030PosLbAsruk114.R_2503000000.getKey());
	}
	
	public static SegmentValidation genFormValidationCadanganKlaimTradisionalSak() {
		return UtilSegmentValidation.genEqualsForm("2", R_2503000000.key, EFormLaporanBulanan.LB_101.getCode(), "2", 
				ER3018PosLbAsruk101.R_2503000000.getKey());
	}
	
	public static SegmentValidation genFormValidationCadanganKlaimTradisionalSap() {
		return UtilSegmentValidation.genEqualsForm("3", R_2503000000.key, EFormLaporanBulanan.LB_113.getCode(), "5", 
				ER3029PosLbAsruk113.R_2503000000.getKey());
	}

	public static SegmentValidation genFormValidationCadanganPremiPaydiSap() {
		return UtilSegmentValidation.genEqualsForm("5", R_2501000000.key, EFormLaporanBulanan.LB_111.getCode(), "3", 
				ER3028PosLbAsruk111.R_2501000000.getKey());
	}

	public static SegmentValidation genFormValidationCadanganPremiTradisionalSak() {
		return UtilSegmentValidation.genEqualsForm("2", R_2501000000.key, EFormLaporanBulanan.LB_101.getCode(), "2", 
				ER3018PosLbAsruk101.R_2501000000.getKey());
	}

	public static SegmentValidation genFormValidationCadanganPremiTradisionalSap() {
		return UtilSegmentValidation.genEqualsForm("3", R_2501000000.key, EFormLaporanBulanan.LB_111.getCode(), "2", 
				ER3028PosLbAsruk111.R_2501000000.getKey());
	}

	public static SegmentValidation genFormValidationCapybmpTradisionalSap() {
		return UtilSegmentValidation.genEqualsForm("3", R_2502000000.key, EFormLaporanBulanan.LB_111.getCode(), "2", 
				ER3028PosLbAsruk111.R_2502000000.getKey());
	}

	public static SegmentValidation genFormValidationDanaInvestasiInfrastrukturBerbentukKontrakInvestasiKolektifTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1421000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_121.getKey(),
				"Total investasi dana investasi infrastruktur berbentuk kontrak investasi kolektif tradisional|Penjumlahan investasi dana investasi infrastruktur berbentuk kontrak investasi kolektif pada form " + EFormLaporanBulanan.LB_107.getCode());
	}

	public static SegmentValidation genFormValidationDanaInvestasiRealEstatTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1412000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_112.getKey(),
				"Total investasi dana investasi real estat tradisional|Penjumlahan investasi dana investasi real estat pada form " + EFormLaporanBulanan.LB_107.getCode());
	}

	public static SegmentValidation genFormValidationDepositoBerjangkaPaydiSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1401000000.key, "17", 
				ER3025PosLbAsruk108.R_1400080100.getFormKey(), "2", ER1000JenisInvestasi.R_101.getKey(),
				"Total investasi deposito berjangka PAYDI|Penjumlahan investasi deposito berjangka pada form " + EFormLaporanBulanan.LB_108.getCode());
	}

	public static SegmentValidation genFormValidationDepositoTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1401000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_101.getKey(),
				"Total investasi deposito berjangka tradisional|Penjumlahan investasi deposito berjangka pada form " + EFormLaporanBulanan.LB_107.getCode());
	}

	public static SegmentValidation genFormValidationEfekBeragunAsetPaydiSaldoSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1411000000.key, "17", 
				ER3025PosLbAsruk108.R_1400080100.getFormKey(), "2", ER1000JenisInvestasi.R_111.getKey(),
				"Total investasi efek beragun aset PAYDI|Penjumlahan investasi efek beragun aset pada form " + EFormLaporanBulanan.LB_108.getCode());
	}
	
	public static SegmentValidation genFormValidationEfekBeragunAsetTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1411000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_111.getKey(),
				"Total investasi efek beragun aset tradisional|Penjumlahan investasi efek beragun aset pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationEkuitasTradisionalSak() {
		return UtilSegmentValidation.genEqualsForm("2", R_3000000000.key, EFormLaporanBulanan.LB_400.getCode(), "3", 
				ER3008PosLbAsruk400.R_3411000099.getKey());
	}
	
	public static SegmentValidation genFormValidationEkuitasTradisionalSap() {
		return UtilSegmentValidation.genEqualsForm("3", R_3000000000.key, EFormLaporanBulanan.LB_400.getCode(), "3", 
				ER3008PosLbAsruk400.R_3423000000.getKey());
	}
	
	public static SegmentValidation genFormValidationEmasMurniPaydiSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1417000000.key, "17", 
				ER3025PosLbAsruk108.R_1400080100.getFormKey(), "2", ER1000JenisInvestasi.R_117.getKey(),
				"Total investasi emas murni PAYDI|Penjumlahan investasi emas murni pada form " + EFormLaporanBulanan.LB_108.getCode());
	}
	
	public static SegmentValidation genFormValidationEmasMurniTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1417000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_117.getKey(),
				"Total investasi emas murni tradisional|Penjumlahan investasi emas murni pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationInvestasiLainTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1499000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_999.getKey(),
				"Total investasi lain tradisional|Penjumlahan investasi lain pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationInvestasiTradisionalSak() {
		return UtilSegmentValidation.genEqualsForm("2", R_1400000000.key, EFormLaporanBulanan.LB_101.getCode(), "2", 
				ER3018PosLbAsruk101.R_1400000000.getKey());
	}
	
	public static SegmentValidation genFormValidationJumlahAsetPaydiSap() {
		return UtilSegmentValidation.genEqualsForm("5", R_1000000000.key, EFormLaporanBulanan.LB_500.getCode(), "4", 
				ER3009PosLbAsruk500.R_7100000000.getKey());
	}
	
	public static SegmentValidation genFormValidationJumlahAsetTradisionalSak() {
		return UtilSegmentValidation.genEqualsForm("2", R_1000000000.key, EFormLaporanBulanan.LB_101.getCode(), "2", 
				ER3018PosLbAsruk101.R_1000000000.getKey());
	}
	
	public static SegmentValidation genFormValidationJumlahAsetTradisionalSap() {
		return UtilSegmentValidation.genEqualsForm("3", R_1000000000.key, EFormLaporanBulanan.LB_101.getCode(), "6", 
				ER3018PosLbAsruk101.R_1000000000.getKey());
	}
	
	public static SegmentValidation genFormValidationJumlahAsetTradisionalSap2() {
		return UtilSegmentValidation.genEqualsForm("3", R_1000000000.key, EFormLaporanBulanan.LB_500.getCode(), "3", 
				ER3009PosLbAsruk500.R_7100000000.getKey());
	}
	
	public static SegmentValidation genFormValidationJumlahBukanInvestasiTradisionalSap() {
		return UtilSegmentValidation.genEqualsForm("3", R_1500000000.key, EFormLaporanBulanan.LB_101.getCode(), "6", 
				ER3018PosLbAsruk101.R_1500000000.getKey());
	}
	
	public static SegmentValidation genFormValidationJumlahInvestasiTradisionalSap() {
		return UtilSegmentValidation.genEqualsForm("3", R_1400000000.key, EFormLaporanBulanan.LB_101.getCode(), "6", 
				ER3018PosLbAsruk101.R_1400000000.getKey());
	}
	
	public static SegmentValidation genFormValidationJumlahLiabilitasPaydiSap() {
		return UtilSegmentValidation.genEqualsForm("5", R_2000000000.key, EFormLaporanBulanan.LB_500.getCode(), "4", 
				ER3009PosLbAsruk500.R_7200000000.getKey());
	}
	
	public static SegmentValidation genFormValidationJumlahLiabilitasTradisionalSap() {
		return UtilSegmentValidation.genEqualsForm("3", R_2000000000.key, EFormLaporanBulanan.LB_500.getCode(), "3", 
				ER3009PosLbAsruk500.R_7200000000.getKey());
	}
	
	public static SegmentValidation genFormValidationJumlahUtangTradisionalSak() {
		return UtilSegmentValidation.genEqualsForm("2", R_2400000000.key, EFormLaporanBulanan.LB_101.getCode(), "2", 
				ER3018PosLbAsruk101.R_2400000000.getKey());
	}
	
	public static SegmentValidation genFormValidationKasDanBankSak() {
		return UtilSegmentValidation.genEqualsForm("8", R_1501000000.key, EFormLaporanBulanan.LB_300.getCode(), "2", 
				ER3007PosLbAsruk300.R_1501000000.getKey());
	}
	
	public static SegmentValidation genFormValidationMtnPaydiSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1405000000.key, "17", 
				ER3025PosLbAsruk108.R_1400080100.getFormKey(), "2", ER1000JenisInvestasi.R_105.getKey(),
				"Total investasi MTN PAYDI|Penjumlahan investasi MTN pada form " + EFormLaporanBulanan.LB_108.getCode());
	}
	
	public static SegmentValidation genFormValidationMtnTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1405000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_105.getKey(),
				"Total investasi MTN tradisional|Penjumlahan investasi MTN pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationObligasiDaerahTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1420000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_120.getKey(),
				"Total investasi obligasi daerah tradisional|Penjumlahan investasi obligasi daerah pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationObligasiKorporasiPaydiSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1404000000.key, "17", 
				ER3025PosLbAsruk108.R_1400080100.getFormKey(), "2", ER1000JenisInvestasi.R_104.getKey(),
				"Total investasi obligasi korporasi PAYDI|Penjumlahan investasi obligasi korporasi pada form " + EFormLaporanBulanan.LB_108.getCode());
	}
	
	public static SegmentValidation genFormValidationObligasiTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1404000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_104.getKey(),
				"Total investasi obligasi korporasi tradisional|Penjumlahan investasi obligasi korporasi pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationPaydiSak() {
		return UtilSegmentValidation.genEqualsForm("4", R_1400000000.key, EFormLaporanBulanan.LB_108.getCode(), "17", 
				ER3025PosLbAsruk108.R_1400080200.getKey());
	}
	
	public static SegmentValidation genFormValidationPaydiSap() {
		return UtilSegmentValidation.genEqualsForm("5", R_1400000000.key, EFormLaporanBulanan.LB_108.getCode(), "18", 
				ER3025PosLbAsruk108.R_1400080200.getKey());
	}
	
	public static SegmentValidation genFormValidationPembiayaanMelaluiKerjasamaDenganPihakLainTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1416000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_116.getKey(),
				"Total investasi pembiayaan melalui kerjasama dengan pihak lain (executing)|Penjumlahan investasi pembiayaan melalui kerjasama dengan pihak lain (executing) pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationPenyertaanLangsungTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1414000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_114.getKey(),
				"Total investasi penyertaan langsung tradisional|Penjumlahan investasi penyertaan langsung pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationPinjamanPolisTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1419000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_119.getKey(),
				"Total investasi pinjaman polis tradisional|Penjumlahan investasi pinjaman polis pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationPinjamanYangDijaminDenganHakTanggunganTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1418000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_118.getKey(),
				"Total investasi pinjaman yang dijamin dengan hak tanggungan tradisional|Penjumlahan investasi pinjaman yang dijamin dengan hak tanggungan pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationReksaDanaPaydiSaldoSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1410000000.key, "17", 
				ER3025PosLbAsruk108.R_1400080100.getFormKey(), "2", ER1000JenisInvestasi.R_110.getKey(),
				"Total investasi reksa dana PAYDI|Penjumlahan investasi reksa dana pada form " + EFormLaporanBulanan.LB_108.getCode());
	}
	
	public static SegmentValidation genFormValidationReksaDanaTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1410000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_110.getKey(),
				"Total investasi reksa dana tradisional|Penjumlahan investasi reksa dana pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationRepoPaydiSaldoSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1413000000.key, "17", 
				ER3025PosLbAsruk108.R_1400080100.getFormKey(), "2", ER1000JenisInvestasi.R_113.getKey(),
				"Total investasi REPO PAYDI|Penjumlahan investasi REPO pada form " + EFormLaporanBulanan.LB_108.getCode());
	}
	
	public static SegmentValidation genFormValidationRepoTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1413000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_113.getKey(),
				"Total investasi REPO tradisional|Penjumlahan investasi REPO pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationSahamPaydiSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1403000000.key, "17", 
				ER3025PosLbAsruk108.R_1400080100.getFormKey(), "2", ER1000JenisInvestasi.R_103.getKey(),
				"Total investasi saham PAYDI|Penjumlahan investasi saham pada form " + EFormLaporanBulanan.LB_108.getCode());
	}
	
	public static SegmentValidation genFormValidationSahamTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1403000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_103.getKey(),
				"Total investasi saham tradisional|Penjumlahan investasi saham pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationSertifikatDepositoPaydiSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1402000000.key, "17", 
				ER3025PosLbAsruk108.R_1400080100.getFormKey(), "2", ER1000JenisInvestasi.R_102.getKey(),
				"Total investasi sertifikat deposito PAYDI|Penjumlahan investasi sertifikat deposito pada form " + EFormLaporanBulanan.LB_108.getCode());
	}
	
	public static SegmentValidation genFormValidationSertifikatDepositoTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1402000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_102.getKey(),
				"Total investasi sertifikat deposito tradisional|Penjumlahan investasi sertifikat deposito pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationSuratBerhargaBankIndonesiaPaydiSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1408000000.key, "17", 
				ER3025PosLbAsruk108.R_1400080100.getFormKey(), "2", ER1000JenisInvestasi.R_108.getKey(),
				"Total investasi surat berharga yang diterbitkan oleh Bank Indonesia PAYDI|Penjumlahan investasi surat berharga yang diterbitkan oleh Bank Indonesia pada form " + EFormLaporanBulanan.LB_108.getCode());
	}
	
	public static SegmentValidation genFormValidationSuratBerhargaBankIndonesiaTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1408000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_108.getKey(),
				"Total investasi surat berharga yang diterbitkan oleh Bank Indonesia tradisional|Penjumlahan investasi surat berharga yang diterbitkan oleh Bank Indonesia pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationSuratBerhargaLembagaMultinasionalPaydiSaldoSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1409000000.key, "17", 
				ER3025PosLbAsruk108.R_1400080100.getFormKey(), "2", ER1000JenisInvestasi.R_109.getKey(),
				"Total investasi surat berharga yang diterbitkan oleh lembaga multinasional PAYDI|Penjumlahan investasi surat berharga yang diterbitkan oleh lembaga multinasional pada form " + EFormLaporanBulanan.LB_108.getCode());
	}
	
	public static SegmentValidation genFormValidationSuratBerhargaLembagaMultinasionalTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1409000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_109.getKey(),
				"Total investasi surat berharga yang diterbitkan oleh lembaga multinasional tradisional|Penjumlahan investasi surat berharga yang diterbitkan oleh lembaga multinasional pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationSuratBerhargaNegaraRiPaydiSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1406000000.key, "17", 
				ER3025PosLbAsruk108.R_1400080100.getFormKey(), "2", ER1000JenisInvestasi.R_106.getKey(),
				"Total investasi surat berharga yang diterbitkan oleh negara RI PAYDI|Penjumlahan investasi surat berharga yang diterbitkan oleh negara RI pada form " + EFormLaporanBulanan.LB_108.getCode());
	}
	
	public static SegmentValidation genFormValidationSuratBerhargaNegaraRiTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1406000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_106.getKey(),
				"Total investasi surat berharga yang diterbitkan oleh negara RI tradisional|Penjumlahan investasi surat berharga yang diterbitkan oleh negara RI pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationSuratBerhargaNegaraSelainNegaraRiPaydiSaldoSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_1407000000.key, "17", 
				ER3025PosLbAsruk108.R_1400080100.getFormKey(), "2", ER1000JenisInvestasi.R_107.getKey(),
				"Total investasi surat berharga yang diterbitkan oleh negara selain negara RI PAYDI|Penjumlahan investasi surat berharga yang diterbitkan oleh negara selain negara RI pada form " + EFormLaporanBulanan.LB_108.getCode());
	}
	
	public static SegmentValidation genFormValidationSuratBerhargaNegaraSelainNegaraRiTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1407000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_107.getKey(),
				"Total investasi surat berharga yang diterbitkan oleh negara selain negara RI tradisional|Penjumlahan investasi surat berharga yang diterbitkan oleh negara selain negara RI pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationTanahBangunanTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_1415000000.key, "23", 
				ER3024PosLbAsruk107.R_1400070100.getFormKey(), "2", ER1000JenisInvestasi.R_115.getKey(),
				"Total investasi tanah, bangunan dengan hak strata, atau tanah dengan bangunan, untuk investasi tradisional|Penjumlahan investasi tanah, bangunan dengan hak strata, atau tanah dengan bangunan, untuk investasi pada form " + EFormLaporanBulanan.LB_107.getCode());
	}
	
	public static SegmentValidation genFormValidationTradisionalSak() {
		return UtilSegmentValidation.genEqualsForm("2", R_1400000000.key, EFormLaporanBulanan.LB_107.getCode(), "23", 
				ER3024PosLbAsruk107.R_1400000000.getKey());
	}
	
	public static SegmentValidation genFormValidationTradisionalSap() {
		return UtilSegmentValidation.genEqualsForm("3", R_1400000000.key, EFormLaporanBulanan.LB_107.getCode(), "24", 
				ER3024PosLbAsruk107.R_1400000000.getKey());
	}
	
	public static SegmentValidation genFormValidationUtangPaydiSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("4", R_2400000000.key, "11", 
				ER3027PosLbAsruk110.R_1400100100.getFormKey(), "2", ER1036TradisionalAtauPaydi.R_PYD.getKey(),
				"Total utang PAYDI saldo SAK|Penjumlahan utang PAYDI saldo SAK pada form " + EFormLaporanBulanan.LB_110.getCode());
	}
	
	public static SegmentValidation genFormValidationUtangTradisionalSak() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_2400000000.key, "11", 
				ER3027PosLbAsruk110.R_1400100100.getFormKey(), "2", ER1036TradisionalAtauPaydi.R_TRD.getKey(),
				"Total utang tradisional saldo SAK|Penjumlahan utang tradisional saldo SAK pada form " + EFormLaporanBulanan.LB_110.getCode());
	}
	
	public static FieldValidation genValidation12() {
		return UtilFieldValidation.genEqualsPosFormula("10+11", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 22, 35, 36, 44, 49, 50, 58, 59 }));
	}
	
	public static FieldValidation genValidation8a() {
		return UtilFieldValidation.genEqualsPosFormula("2+4+6", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 22, 35, 36, 44, 49, 50, 58, 59 }));
	}
	
	public static FieldValidation genValidation8b() {
		return UtilFieldValidation.genPosEquals("12", R_3999999999.key);
	}
	
	public static FieldValidation genValidation9() {
		return UtilFieldValidation.genEqualsPosFormula("3+5+7", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 22, 35, 36, 44, 49, 50, 58, 59 }));
	}
	
	public static SegmentValidation genValidationSumAset() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12", R_1000000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 22, 35 }), "Jumlah aset|Penjumlahan aset");
	}
	
	public static SegmentValidation genValidationSumBukanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12", R_1500000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 23, 34), "Jumlah bukan investasi|Penjumlahan bukan investasi");
	}
	
	public static SegmentValidation genValidationSumCadanganTeknis() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12", R_2500000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 45, 48), "Jumlah cadangan teknis|Penjumlahan cadangan teknis");
	}
	
	public static SegmentValidation genValidationSumEkuitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12", R_3000000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 52, 57), "Total ekuitas|Penjumlahan ekuitas");
	}
	
	public static SegmentValidation genValidationSumInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12", R_1400000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 21), "Jumlah investasi|Penjumlahan investasi");
	}
	
	public static SegmentValidation genValidationSumLiabilitas() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12", R_2000000000.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 44, 49 }), "Total liabilitas|Penjumlahan liabilitas");
	}
	
	public static SegmentValidation genValidationSumLiabilitasEkuitasA() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12", R_3999999999.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 50, 51, 58 }), "Total liabilitas dan ekuitas|Penjumlahan liabilitas dan ekuitas");
	}
	
	public static SegmentValidation genValidationSumLiabilitasEkuitasB() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12", R_3999999999.key, 
				R_1000000000.key, "Jumlah liabilitas dan ekuitas|Jumlah aset");
	}
	
	public static SegmentValidation genValidationSumUtang() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12", R_2400000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 37, 43), "Jumlah utang|Penjumlahan utang");
	}
}
