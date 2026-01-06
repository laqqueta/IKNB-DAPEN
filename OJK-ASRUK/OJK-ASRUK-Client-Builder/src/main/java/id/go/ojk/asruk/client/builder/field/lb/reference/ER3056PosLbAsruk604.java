package id.go.ojk.asruk.client.builder.field.lb.reference;

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
public enum ER3056PosLbAsruk604 implements IObject<KeyValueString> {
	R_150102010001 ("150102010001", "Premi", "00"),
	R_150102020001 ("150102020001", "Komisi", "00"),
	R_250201000001 ("250201000001", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "00"),
	R_250202000001 ("250202000001", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "00"),
	R_150102010101 ("150102010101", "Pendapatan Premi", "00"),
	R_150102030001 ("150102030001", "Klaim Dibayar", "00"),
	R_240601000001 ("240601000001", "Biaya Adjuster", "00"),
	R_250301000001 ("250301000001", "Cadangan/Outstanding Klaim - Tahun Lalu", "00"),
	R_250302000001 ("250302000001", "Cadangan/Outstanding Klaim - Tahun Berjalan", "00"),
	R_681000000001 ("681000000001", "Beban Klaim", "00"),
	R_240101000001 ("240101000001", "Surplus Underwriting", "00"),
	R_150102010002 ("150102010002", "Premi", "01"),
	R_150102020002 ("150102020002", "Komisi", "01"),
	R_250201000002 ("250201000002", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "01"),
	R_250202000002 ("250202000002", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "01"),
	R_150102010102 ("150102010102", "Pendapatan Premi", "01"),
	R_150102030002 ("150102030002", "Klaim Dibayar", "01"),
	R_240601000002 ("240601000002", "Biaya Adjuster", "01"),
	R_250301000002 ("250301000002", "Cadangan/Outstanding Klaim - Tahun Lalu", "01"),
	R_250302000002 ("250302000002", "Cadangan/Outstanding Klaim - Tahun Berjalan", "01"),
	R_681000000002 ("681000000002", "Beban Klaim", "01"),
	R_240101000002 ("240101000002", "Surplus Underwriting", "01"),
	R_150102010003 ("150102010003", "Premi", "02"),
	R_150102020003 ("150102020003", "Komisi", "02"),
	R_250201000003 ("250201000003", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "02"),
	R_250202000003 ("250202000003", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "02"),
	R_150102010103 ("150102010103", "Pendapatan Premi", "02"),
	R_150102030003 ("150102030003", "Klaim Dibayar", "02"),
	R_240601000003 ("240601000003", "Biaya Adjuster", "02"),
	R_250301000003 ("250301000003", "Cadangan/Outstanding Klaim - Tahun Lalu", "02"),
	R_250302000003 ("250302000003", "Cadangan/Outstanding Klaim - Tahun Berjalan", "02"),
	R_681000000003 ("681000000003", "Beban Klaim", "02"),
	R_240101000003 ("240101000003", "Surplus Underwriting", "02"),
	R_150102010004 ("150102010004", "Premi", "03"),
	R_150102020004 ("150102020004", "Komisi", "03"),
	R_250201000004 ("250201000004", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "03"),
	R_250202000004 ("250202000004", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "03"),
	R_150102010104 ("150102010104", "Pendapatan Premi", "03"),
	R_150102030004 ("150102030004", "Klaim Dibayar", "03"),
	R_240601000004 ("240601000004", "Biaya Adjuster", "03"),
	R_250301000004 ("250301000004", "Cadangan/Outstanding Klaim - Tahun Lalu", "03"),
	R_250302000004 ("250302000004", "Cadangan/Outstanding Klaim - Tahun Berjalan", "03"),
	R_681000000004 ("681000000004", "Beban Klaim", "03"),
	R_240101000004 ("240101000004", "Surplus Underwriting", "03"),
	R_150102010005 ("150102010005", "Premi", "04"),
	R_150102020005 ("150102020005", "Komisi", "04"),
	R_250201000005 ("250201000005", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "04"),
	R_250202000005 ("250202000005", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "04"),
	R_150102010105 ("150102010105", "Pendapatan Premi", "04"),
	R_150102030005 ("150102030005", "Klaim Dibayar", "04"),
	R_240601000005 ("240601000005", "Biaya Adjuster", "04"),
	R_250301000005 ("250301000005", "Cadangan/Outstanding Klaim - Tahun Lalu", "04"),
	R_250302000005 ("250302000005", "Cadangan/Outstanding Klaim - Tahun Berjalan", "04"),
	R_681000000005 ("681000000005", "Beban Klaim", "04"),
	R_240101000005 ("240101000005", "Surplus Underwriting", "04"),
	R_150102010006 ("150102010006", "Premi", "05"),
	R_150102020006 ("150102020006", "Komisi", "05"),
	R_250201000006 ("250201000006", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "05"),
	R_250202000006 ("250202000006", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "05"),
	R_150102010106 ("150102010106", "Pendapatan Premi", "05"),
	R_150102030006 ("150102030006", "Klaim Dibayar", "05"),
	R_240601000006 ("240601000006", "Biaya Adjuster", "05"),
	R_250301000006 ("250301000006", "Cadangan/Outstanding Klaim - Tahun Lalu", "05"),
	R_250302000006 ("250302000006", "Cadangan/Outstanding Klaim - Tahun Berjalan", "05"),
	R_681000000006 ("681000000006", "Beban Klaim", "05"),
	R_240101000006 ("240101000006", "Surplus Underwriting", "05"),
	R_150102010007 ("150102010007", "Premi", "06"),
	R_150102020007 ("150102020007", "Komisi", "06"),
	R_250201000007 ("250201000007", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "06"),
	R_250202000007 ("250202000007", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "06"),
	R_150102010107 ("150102010107", "Pendapatan Premi", "06"),
	R_150102030007 ("150102030007", "Klaim Dibayar", "06"),
	R_240601000007 ("240601000007", "Biaya Adjuster", "06"),
	R_250301000007 ("250301000007", "Cadangan/Outstanding Klaim - Tahun Lalu", "06"),
	R_250302000007 ("250302000007", "Cadangan/Outstanding Klaim - Tahun Berjalan", "06"),
	R_681000000007 ("681000000007", "Beban Klaim", "06"),
	R_240101000007 ("240101000007", "Surplus Underwriting", "06"),
	R_150102010008 ("150102010008", "Premi", "07"),
	R_150102020008 ("150102020008", "Komisi", "07"),
	R_250201000008 ("250201000008", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "07"),
	R_250202000008 ("250202000008", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "07"),
	R_150102010108 ("150102010108", "Pendapatan Premi", "07"),
	R_150102030008 ("150102030008", "Klaim Dibayar", "07"),
	R_240601000008 ("240601000008", "Biaya Adjuster", "07"),
	R_250301000008 ("250301000008", "Cadangan/Outstanding Klaim - Tahun Lalu", "07"),
	R_250302000008 ("250302000008", "Cadangan/Outstanding Klaim - Tahun Berjalan", "07"),
	R_681000000008 ("681000000008", "Beban Klaim", "07"),
	R_240101000008 ("240101000008", "Surplus Underwriting", "07"),
	R_150102010009 ("150102010009", "Premi", "08"),
	R_150102020009 ("150102020009", "Komisi", "08"),
	R_250201000009 ("250201000009", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "08"),
	R_250202000009 ("250202000009", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "08"),
	R_150102010109 ("150102010109", "Pendapatan Premi", "08"),
	R_150102030009 ("150102030009", "Klaim Dibayar", "08"),
	R_240601000009 ("240601000009", "Biaya Adjuster", "08"),
	R_250301000009 ("250301000009", "Cadangan/Outstanding Klaim - Tahun Lalu", "08"),
	R_250302000009 ("250302000009", "Cadangan/Outstanding Klaim - Tahun Berjalan", "08"),
	R_681000000009 ("681000000009", "Beban Klaim", "08"),
	R_240101000009 ("240101000009", "Surplus Underwriting", "08"),
	R_150102010010 ("150102010010", "Premi", "09"),
	R_150102020010 ("150102020010", "Komisi", "09"),
	R_250201000010 ("250201000010", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "09"),
	R_250202000010 ("250202000010", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "09"),
	R_150102010110 ("150102010110", "Pendapatan Premi", "09"),
	R_150102030010 ("150102030010", "Klaim Dibayar", "09"),
	R_240601000010 ("240601000010", "Biaya Adjuster", "09"),
	R_250301000010 ("250301000010", "Cadangan/Outstanding Klaim - Tahun Lalu", "09"),
	R_250302000010 ("250302000010", "Cadangan/Outstanding Klaim - Tahun Berjalan", "09"),
	R_681000000010 ("681000000010", "Beban Klaim", "09"),
	R_240101000010 ("240101000010", "Surplus Underwriting", "09"),
	R_150102010011 ("150102010011", "Premi", "10"),
	R_150102020011 ("150102020011", "Komisi", "10"),
	R_250201000011 ("250201000011", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "10"),
	R_250202000011 ("250202000011", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "10"),
	R_150102010111 ("150102010111", "Pendapatan Premi", "10"),
	R_150102030011 ("150102030011", "Klaim Dibayar", "10"),
	R_240601000011 ("240601000011", "Biaya Adjuster", "10"),
	R_250301000011 ("250301000011", "Cadangan/Outstanding Klaim - Tahun Lalu", "10"),
	R_250302000011 ("250302000011", "Cadangan/Outstanding Klaim - Tahun Berjalan", "10"),
	R_681000000011 ("681000000011", "Beban Klaim", "10"),
	R_240101000011 ("240101000011", "Surplus Underwriting", "10"),
	R_150102010012 ("150102010012", "Premi", "11"),
	R_150102020012 ("150102020012", "Komisi", "11"),
	R_250201000012 ("250201000012", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "11"),
	R_250202000012 ("250202000012", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "11"),
	R_150102010112 ("150102010112", "Pendapatan Premi", "11"),
	R_150102030012 ("150102030012", "Klaim Dibayar", "11"),
	R_240601000012 ("240601000012", "Biaya Adjuster", "11"),
	R_250301000012 ("250301000012", "Cadangan/Outstanding Klaim - Tahun Lalu", "11"),
	R_250302000012 ("250302000012", "Cadangan/Outstanding Klaim - Tahun Berjalan", "11"),
	R_681000000012 ("681000000012", "Beban Klaim", "11"),
	R_240101000012 ("240101000012", "Surplus Underwriting", "11"),
	R_150102010013 ("150102010013", "Premi", "12"),
	R_150102020013 ("150102020013", "Komisi", "12"),
	R_250201000013 ("250201000013", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "12"),
	R_250202000013 ("250202000013", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "12"),
	R_150102010113 ("150102010113", "Pendapatan Premi", "12"),
	R_150102030013 ("150102030013", "Klaim Dibayar", "12"),
	R_240601000013 ("240601000013", "Biaya Adjuster", "12"),
	R_250301000013 ("250301000013", "Cadangan/Outstanding Klaim - Tahun Lalu", "12"),
	R_250302000013 ("250302000013", "Cadangan/Outstanding Klaim - Tahun Berjalan", "12"),
	R_681000000013 ("681000000013", "Beban Klaim", "12"),
	R_240101000013 ("240101000013", "Surplus Underwriting", "12"),
	R_150102010014 ("150102010014", "Premi", "13"),
	R_150102020014 ("150102020014", "Komisi", "13"),
	R_250201000014 ("250201000014", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "13"),
	R_250202000014 ("250202000014", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "13"),
	R_150102010114 ("150102010114", "Pendapatan Premi", "13"),
	R_150102030014 ("150102030014", "Klaim Dibayar", "13"),
	R_240601000014 ("240601000014", "Biaya Adjuster", "13"),
	R_250301000014 ("250301000014", "Cadangan/Outstanding Klaim - Tahun Lalu", "13"),
	R_250302000014 ("250302000014", "Cadangan/Outstanding Klaim - Tahun Berjalan", "13"),
	R_681000000014 ("681000000014", "Beban Klaim", "13"),
	R_240101000014 ("240101000014", "Surplus Underwriting", "13"),
	R_150102010015 ("150102010015", "Premi", "14"),
	R_150102020015 ("150102020015", "Komisi", "14"),
	R_250201000015 ("250201000015", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Lalu", "14"),
	R_250202000015 ("250202000015", "Cadangan Atas Premi Yang Belum Merupakan Pendapatan - Tahun Berjalan", "14"),
	R_150102010115 ("150102010115", "Pendapatan Premi", "14"),
	R_150102030015 ("150102030015", "Klaim Dibayar", "14"),
	R_240601000015 ("240601000015", "Biaya Adjuster", "14"),
	R_250301000015 ("250301000015", "Cadangan/Outstanding Klaim - Tahun Lalu", "14"),
	R_250302000015 ("250302000015", "Cadangan/Outstanding Klaim - Tahun Berjalan", "14"),
	R_681000000015 ("681000000015", "Beban Klaim", "14"),
	R_240101000015 ("240101000015", "Surplus Underwriting", "14"),
	;
	
	private String key;
	private String value;
	private String kodeLiniUsaha;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3056PosLbAsruk604 eEnum : ER3056PosLbAsruk604.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(3, 10), getObjects());
	}

	public static FieldValidation genFieldValidation10() {
		return UtilFieldValidation.genEqualsPosFormula("3+4+5+6-7-8-9", 
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 9, 10, 15, 20, 21, 26, 31, 32, 37, 42, 43, 48, 53, 54, 59, 64, 65, 70, 75, 76, 81, 86, 87, 92, 97, 98, 103, 108, 109, 114, 119, 120, 125, 130, 131, 136, 141, 142, 147, 152, 153, 158, 163, 164 }));
	}
	public static FieldValidation genFieldValidation2() {
		return UtilFieldValidation.genLookup("1", getLookup());
	}

	public static SegmentValidation genValidationBebanKlaim() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000001.key, 
				R_150102030001.key + "+" + R_240601000001.key + "-" + R_250301000001.key + "+" + R_250302000001.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBebanKlaim10() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000010.key, 
				R_150102030010.key + "+" + R_240601000010.key + "-" + R_250301000010.key + "+" + R_250302000010.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}

	public static SegmentValidation genValidationBebanKlaim11() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000011.key, 
				R_150102030011.key + "+" + R_240601000011.key + "-" + R_250301000011.key + "+" + R_250302000011.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBebanKlaim12() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000012.key, 
				R_150102030012.key + "+" + R_240601000012.key + "-" + R_250301000012.key + "+" + R_250302000012.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBebanKlaim13() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000013.key, 
				R_150102030013.key + "+" + R_240601000013.key + "-" + R_250301000013.key + "+" + R_250302000013.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBebanKlaim14() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000014.key, 
				R_150102030014.key + "+" + R_240601000014.key + "-" + R_250301000014.key + "+" + R_250302000014.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBebanKlaim15() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000015.key, 
				R_150102030015.key + "+" + R_240601000015.key + "-" + R_250301000015.key + "+" + R_250302000015.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBebanKlaim2() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000002.key, 
				R_150102030002.key + "+" + R_240601000002.key + "-" + R_250301000002.key + "+" + R_250302000002.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBebanKlaim3() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000003.key, 
				R_150102030003.key + "+" + R_240601000003.key + "-" + R_250301000003.key + "+" + R_250302000003.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBebanKlaim4() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000004.key, 
				R_150102030004.key + "+" + R_240601000004.key + "-" + R_250301000004.key + "+" + R_250302000004.key, 
				"Total beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBebanKlaim5() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000005.key, 
				R_150102030005.key + "+" + R_240601000005.key + "-" + R_250301000005.key + "+" + R_250302000005.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBebanKlaim6() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000006.key, 
				R_150102030006.key + "+" + R_240601000006.key + "-" + R_250301000006.key + "+" + R_250302000006.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBebanKlaim7() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000007.key, 
				R_150102030007.key + "+" + R_240601000007.key + "-" + R_250301000007.key + "+" + R_250302000007.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBebanKlaim8() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000008.key, 
				R_150102030008.key + "+" + R_240601000008.key + "-" + R_250301000008.key + "+" + R_250302000008.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBebanKlaim9() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_681000000009.key, 
				R_150102030009.key + "+" + R_240601000009.key + "-" + R_250301000009.key + "+" + R_250302000009.key, 
				"Total pendapatan beban klaim|Perhitungan beban klaim");
	}
	
	public static SegmentValidation genValidationBiayaAdjuster() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 9), R_240601000001.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 17, 28, 39, 50, 61, 72, 83, 94, 105, 116, 127, 138, 149, 160 }), 
				"Total biaya adjuster|Penjumlahan biaya adjuster");
	}
	
	public static SegmentValidation genValidationCadanganAtasPremiYangBelumMerupakanPendapatanTahunBerjalan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 9), R_250202000001.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 14, 25, 36, 47, 58, 69, 80, 91, 102, 113, 124, 135, 146, 157 }), 
				"Total cadangan atas premi yang belum merupakan pendapatan - tahun berjalan|Penjumlahan cadangan atas premi yang belum merupakan pendapatan - tahun berjalan");
	}
	
	public static SegmentValidation genValidationCadanganAtasPremiYangBelumMerupakanPendapatanTahunLalu() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 9), R_250201000001.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 13, 24, 35, 46, 57, 68, 79, 90, 101, 112, 123, 134, 145, 156 }), 
				"Total cadangan atas premi yang belum merupakan pendapatan - tahun lalu|Penjumlahan cadangan atas premi yang belum merupakan pendapatan - tahun lalu");
	}
	
	public static SegmentValidation genValidationCadanganOutstandingKlaimTahunBerjalan() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 9), R_250302000001.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 19, 30, 41, 52, 63, 74, 85, 96, 107, 118, 129, 140, 151, 162 }), 
				"Total cadangan/outstanding klaim - tahun berjalan|Penjumlahan cadangan/outstanding klaim - tahun berjalan");
	}
	
	public static SegmentValidation genValidationCadanganOutstandingKlaimTahunLalu() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 9), R_250301000001.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 18, 29, 40, 51, 62, 73, 84, 95, 106, 117, 128, 139, 150, 161 }), 
				"Total cadangan/outstanding klaim - tahun lalu|Penjumlahan cadangan/outstanding klaim - tahun lalu");
	}
	
	public static SegmentValidation genValidationKlaimDibayar() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 9), R_150102030001.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 16, 27, 38, 49, 60, 71, 82, 93, 104, 115, 126, 137, 148, 159 }), 
				"Total klaim dibayar|Penjumlahan klaim dibayar");
	}
	
	public static SegmentValidation genValidationKomisi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 9), R_150102020001.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 12, 23, 34, 45, 56, 67, 78, 89, 100, 111, 122, 133, 144, 155 }), 
				"Total komisi|Perhitungan komisi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010101.key, 
				R_150102010001.key + "-" + R_150102020001.key + "+" + R_250201000001.key + "-" + R_250202000001.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi10() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010110.key, 
				R_150102010010.key + "-" + R_150102020010.key + "+" + R_250201000010.key + "-" + R_250202000010.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi11() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010111.key, 
				R_150102010011.key + "-" + R_150102020011.key + "+" + R_250201000011.key + "-" + R_250202000011.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi12() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010112.key, 
				R_150102010012.key + "-" + R_150102020012.key + "+" + R_250201000012.key + "-" + R_250202000012.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi13() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010113.key, 
				R_150102010013.key + "-" + R_150102020013.key + "+" + R_250201000013.key + "-" + R_250202000013.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi14() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010114.key, 
				R_150102010014.key + "-" + R_150102020014.key + "+" + R_250201000014.key + "-" + R_250202000014.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi15() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010115.key, 
				R_150102010015.key + "-" + R_150102020015.key + "+" + R_250201000015.key + "-" + R_250202000015.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi2() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010102.key, 
				R_150102010002.key + "-" + R_150102020002.key + "+" + R_250201000002.key + "-" + R_250202000002.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi3() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010103.key, 
				R_150102010003.key + "-" + R_150102020003.key + "+" + R_250201000003.key + "-" + R_250202000003.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi4() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010104.key, 
				R_150102010004.key + "-" + R_150102020004.key + "+" + R_250201000004.key + "-" + R_250202000004.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi5() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010105.key, 
				R_150102010005.key + "-" + R_150102020005.key + "+" + R_250201000005.key + "-" + R_250202000005.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi6() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010106.key, 
				R_150102010006.key + "-" + R_150102020006.key + "+" + R_250201000006.key + "-" + R_250202000006.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi7() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010107.key, 
				R_150102010007.key + "-" + R_150102020007.key + "+" + R_250201000007.key + "-" + R_250202000007.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi8() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010108.key, 
				R_150102010008.key + "-" + R_150102020008.key + "+" + R_250201000008.key + "-" + R_250202000008.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPendapatanPremi9() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_150102010109.key, 
				R_150102010009.key + "-" + R_150102020009.key + "+" + R_250201000009.key + "-" + R_250202000009.key, 
				"Total pendapatan premi|Perhitungan pendapatan premi");
	}
	
	public static SegmentValidation genValidationPremi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 9), R_150102010001.key, 
				UtilMetadata.genPlusRow(getObjects(), new int[] { 11, 22, 33, 44, 55, 66, 77, 88, 99, 110, 121, 132, 143, 154 }), 
				"Total premi|Penjumlahan premi");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000001.key, 
				R_150102010101.key + "-" + R_681000000001.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting10() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000010.key, 
				R_150102010110.key + "-" + R_681000000010.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting11() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000011.key, 
				R_150102010111.key + "-" + R_681000000011.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting12() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000012.key, 
				R_150102010112.key + "-" + R_681000000012.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting13() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000013.key, 
				R_150102010113.key + "-" + R_681000000013.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting14() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000014.key, 
				R_150102010114.key + "-" + R_681000000014.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting15() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000015.key, 
				R_150102010115.key + "-" + R_681000000015.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting2() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000002.key, 
				R_150102010102.key + "-" + R_681000000002.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting3() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000003.key, 
				R_150102010103.key + "-" + R_681000000003.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting4() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000004.key, 
				R_150102010104.key + "-" + R_681000000004.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting5() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000005.key, 
				R_150102010105.key + "-" + R_681000000005.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting6() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000006.key, 
				R_150102010106.key + "-" + R_681000000006.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting7() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000007.key, 
				R_150102010107.key + "-" + R_681000000007.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting8() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000008.key, 
				R_150102010108.key + "-" + R_681000000008.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	public static SegmentValidation genValidationSurplusUnderwriting9() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(3, 10), R_240101000009.key, 
				R_150102010109.key + "-" + R_681000000009.key, 
				"Total pendapatan surplus underwriting|Perhitungan surplus underwriting");
	}
	
	private static String getLookup() {
		StringBuilder res = new StringBuilder();
		ER3056PosLbAsruk604[] eEnums = ER3056PosLbAsruk604.values();
		int enumLength = eEnums.length;
		for (int i= 0; i < enumLength; i++) {
			ER3056PosLbAsruk604 eEnum = ER3056PosLbAsruk604.values()[i];
			res.append(eEnum.key).append(":").append(eEnum.kodeLiniUsaha);
			if (i + 1 < enumLength) {
				res.append("|");
			}
		}
		return res.toString();
	}
}
