package id.go.ojk.dplks.client.builder.field.rb.reference;

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
public enum ER2017PosRbDplks1202 implements IObject<KeyValueString> {
//	R_1202010000 ("1202010000", "PENDAPATAN INVESTASI"),
	R_1202010100 ("1202010100", "Bagi Hasil"),
	R_1202010200 ("1202010200", "Dividen"),
	R_1202010300 ("1202010300", "Sewa"),
	R_1202010400 ("1202010400", "Laba (Rugi) Pelepasan Investasi"),
	R_1202010500 ("1202010500", "Pendapatan Investasi Lain "),
	R_1202020000 ("1202020000", "Total Pendapatan Investasi"),
	R_1202030000 ("1202030000", "Peningkatan (Penurunan) Nilai Investasi"),
	R_1202040000 ("1202040000", "Iuran"),
	R_1202050000 ("1202050000", "Pendapatan di Luar Investasi"),
	R_1202060000 ("1202060000", "Pengalihan Dana Dari Dana Pensiun Lain"),
	R_1202070000 ("1202070000", "Jumlah Penambahan"),
//	R_1202080000 ("1202080000", "PENGURANGAN"),
	R_1202080100 ("1202080100", "Beban Investasi"),
	R_1202080200 ("1202080200", "Beban Operasional"),
	R_1202080300 ("1202080300", "Beban di Luar Investasi dan Operasional"),
	R_1202080400 ("1202080400", "Manfaat Pensiun dan Manfaat Lain"),
	R_1202080500 ("1202080500", "Pajak Penghasilan"),
	R_1202080600 ("1202080600", "Pengalihan Dana ke Dana Pensiun Lain"),
	R_1202080700 ("1202080700", "Penarikan Iuran"),
	R_1202090000 ("1202090000", "Jumlah Pengurangan"),
	R_1202100000 ("1202100000", "KENAIKAN (PENURUNAN) ASET NETO"),
	R_1202110000 ("1202110000", "ASET NETO AWAL PERIODE"),
	R_1202120000 ("1202120000", "ASET NETO AKHIR PERIODE"),
	;

	private String key;
	private String value;

	public String getKey() {
		return key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2017PosRbDplks1202 eEnum : ER2017PosRbDplks1202.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2017PosRbDplks1202.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2017PosRbDplks1202.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}
	
	public static SegmentValidation genValidationTotalPendapatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1202020000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 4),
				"Total Pendapatan Investasi|Penjumlahan Pendapatan Investasi");
	}
	
	public static SegmentValidation genValidationJumlahPenambahan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1202070000.key,
				UtilMetadata.genPlusRow(getObjects(), 5, 9),
				"Total Penambahan|Penjumlahan Penambahan");
	}
	
	public static SegmentValidation genValidationJumlahPengurangan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1202090000.key,
				UtilMetadata.genPlusRow(getObjects(), 11, 17),
				"Total Pengurangan|Penjumlahan Pengurangan");
	}
	
	public static SegmentValidation genValidationKenaikanAsetNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1202100000.key,
				R_1202070000.key + "-" + R_1202090000.key,
				"Total Kenaikan Aset Neto|Perhitungan Kenaikan Aset Neto");
	}
	
	public static SegmentValidation genValidationAsetNetoAkhirPeriode() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1202120000.key,
				R_1202100000.key + "+" + R_1202110000.key,
				"Total Aset Neto Akhir Periode|Perhitungan Aset Neto Akhir Periode");
	}
}
