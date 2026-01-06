package id.go.ojk.reask.client.builder.field.rb.reference;

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
public enum ER2015PosRbReask1304 implements IObject<KeyValueString> {
	R_4101010000 ("4101010000", "a. Premi Penutupan Langsung"),
	R_4101020000 ("4101020000", "b.Premi Penutupan Tidak Langsung"),
	R_4101000000 ("4101000000", "Jumlah Pendapatan Premi"),
	R_4102000000 ("4102000000", "c. Komisi Dibayar"),
	R_4100000000 ("4100000000", "Jumlah Premi Bruto"),
//	R_4200000099 ("4200000099", "Premi Reasuransi"),
	R_4201000000 ("4201000000", "a. Premi Reasuransi Dibayar"),
	R_4202000000 ("4202000000", "b. Komisi Reasuransi Diterima"),
	R_4200000000 ("4200000000", "Jumlah Premi Reasuransi"),
	R_4300000000 ("4300000000", "Premi Neto"),
//	R_4400000099 ("4400000099", "Penurunan (Kenaikan) Cadangan Premi dan CAPYBMP"),
	R_4401000000 ("4401000000", "a. Penurunan (kenaikan) Cadangan Premi"),
	R_4402000000 ("4402000000", "b. Penurunan (kenaikan) CAPYBMP"),
	R_4403000000 ("4403000000", "c. Penurunan (kenaikan) Cadangan atas Risiko Bencana (Catastrophic)"),
	R_4400000000 ("4400000000", "Penurunan (Kenaikan) Cadangan Premi dan CAPYBMP"),
	R_4500000000 ("4500000000", "Jumlah Pendapatan Premi Neto"),
	R_4600000000 ("4600000000", "Pendapatan Underwriting Lain Neto"),
	R_4000000000 ("4000000000", "PENDAPATAN U N D E R W R I T I N G"),
//	R_5400000099 ("5400000099", "BEBAN UNDERWRITING"),
//	R_5401000099 ("5401000099", "Beban Klaim"),
	R_5401010000 ("5401010000", "a. Klaim Bruto"),
	R_5401020000 ("5401020000", "b. Klaim Reasuransi"),
	R_5401030000 ("5401030000", "c. Kenaikan (Penurunan) Cadangan Klaim"),
	R_5401000000 ("5401000000", "Jumlah Beban Klaim Netto"),
	R_5402000000 ("5402000000", "Beban Underwriting Lain Neto"),
	R_5400000000 ("5400000000", "JUMLAH BEBAN U N D E R W R I T I N G"),
	R_5500000000 ("5500000000", "HASIL UNDERWRITING"),
	R_5600000000 ("5600000000", "Hasil Investasi"),
//	R_5700000099 ("5700000099", "Beban Usaha:"),
	R_5701000000 ("5701000000", "a. Beban Pemasaran"),
//	R_5702000099 ("5702000099", "b. Beban Umum dan Administrasi:"),
	R_5702010000 ("5702010000", "Beban Pegawai dan Pengurus"),
	R_5702020000 ("5702020000", "Beban Pendidikan dan Pelatihan"),
	R_5702030000 ("5702030000", "Beban Umum dan Administrasi Lainnya"),
	R_5703000000 ("5703000000", "Biaya Terkait Estimasi Kecelakaan Diri"),
	R_5704000000 ("5704000000", "Biaya Manajemen"),
	R_5700000000 ("5700000000", "Jumlah Beban Usaha"),
	R_5801000000 ("5801000000", "LABA (RUGI) USAHA ASURANSI"),
	R_5802000000 ("5802000000", "Hasil (Beban) Lain"),
	R_5803000000 ("5803000000", "LABA (RUGI) SEBELUM PAJAK"),
	R_5804000000 ("5804000000", "Pajak Penghasilan"),
	R_5805000000 ("5805000000", "LABA SETELAH PAJAK"),
	R_5806000000 ("5806000000", "PENDAPATAN KOMPREHENSIF LAIN"),
	R_5800000000 ("5800000000", "TOTAL LABA (RUGI) KOMPREHENSIF"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2015PosRbReask1304 eEnum : ER2015PosRbReask1304.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2015PosRbReask1304.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2015PosRbReask1304.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}
	
	public static SegmentValidation genValidasiPendapatanPremi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_4101000000.key, 
				R_4101010000.key + "+" + R_4101020000.key, 
				"Total Pendapatan Premi|Penjumlahan Pendapatan Premi");
	}
	
	public static SegmentValidation genValidasiPremiBruto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_4100000000.key, 
				R_4101000000.key + "-" + R_4102000000.key, 
				"Total Premi Bruto|Penjumlahan Premi Bruto");
	}
	
	public static SegmentValidation genValidasiPremiReasuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_4200000000.key, 
				R_4201000000.key + "-" + R_4202000000.key, 
				"Total Beban Klaim dan Manfaat|Penjumlahan Beban Klaim dan Manfaat");
	}
	
	public static SegmentValidation genValidasiPremiNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_4300000000.key, 
				R_4100000000.key + "-" + R_4200000000.key, 
				"Total Premi Neto|Penjumlahan Premi Neto");
	}
	
	public static SegmentValidation genValidasiPenurunanCadanganPremiCapybmp() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_4400000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 9, 11), 
				"Total Penurunan (Kenaikan) Cadangan Premi dan CAPYBMP|Penjumlahan Penurunan (Kenaikan) Cadangan Premi dan CAPYBMP");
	}
	
	public static SegmentValidation genValidasiPendapatanPremiNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_4500000000.key, 
				R_4300000000.key + "+" + R_4400000000.key, 
				"Total Pendapatan Premi Neto|Penjumlahan Pendapatan Premi Neto");
	}
	
	public static SegmentValidation genValidasiPendapatanUnderWriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_4000000000.key, 
				R_4500000000.key + "+" + R_4600000000.key, 
				"Total Pendapatan UnderWriting|Penjumlahan Pendapatan UnderWriting");
	}
	
	public static SegmentValidation genValidasiBebanKlaimNetto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_5401000000.key, 
				R_5401010000.key + "-" + R_5401020000.key + "+" + R_5401030000.key, 
				"Total Beban Klaim Netto|Penjumlahan Beban Klaim Netto");
	}
	
	public static SegmentValidation genValidasiBebanUnderWriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_5400000000.key, 
				R_5401000000.key + "+" + R_5402000000.key, 
				"Total Beban UnderWriting|Penjumlahan Beban UnderWriting");
	}
	
	public static SegmentValidation genValidasiHasilUnderWriting() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_5500000000.key, 
				R_4000000000.key + "-" + R_5400000000.key, 
				"Total Hasil UnderWriting|Penjumlahan Hasil UnderWriting");
	}
	
	public static SegmentValidation genValidasiBebanUsaha() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_5700000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 24, 29), 
				"Total Beban Usaha|Penjumlahan Beban Usaha");
	}
	
	public static SegmentValidation genValidasiLabaUsahaAsuransi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_5801000000.key, 
				R_5500000000.key + "+" + R_5600000000.key + "-" + R_5700000000.key, 
				"Total Laba (Rugi) Usaha Asuransi|Penjumlahan Laba (Rugi) Usaha Asuransi");
	}
	
	public static SegmentValidation genValidasiLabaSebelumPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_5803000000.key, 
				R_5801000000.key + "+" + R_5802000000.key, 
				"Total Laba (Rugi) Sebelum Pajak|Penjumlahan Laba (Rugi) Sebelum Pajak");
	}
	
	public static SegmentValidation genValidasiLabaSetelahPajak() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_5805000000.key, 
				R_5803000000.key + "-" + R_5804000000.key, 
				"Total Laba Setelah Pajak|Penjumlahan Laba Setelah Pajak");
	}
	
	public static SegmentValidation genValidasiLabaKomprehensif() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_5800000000.key, 
				R_5805000000.key + "+" + R_5806000000.key, 
				"Total Laba (Rugi) Komprehensif|Penjumlahan Laba (Rugi) Komprehensif");
	}
}
