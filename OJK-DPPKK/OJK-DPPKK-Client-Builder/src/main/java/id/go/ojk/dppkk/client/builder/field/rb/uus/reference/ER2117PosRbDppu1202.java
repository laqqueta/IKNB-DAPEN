package id.go.ojk.dppkk.client.builder.field.rb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2117PosRbDppu1202 implements IObject<KeyValueString> {
//	R_1202010000 ("1202010000", "PENAMBAHAN"),
//	R_1202010100 ("1202010100", "Pendapatan Investasi"),
	R_1202010101 ("1202010101", "Bagi Hasil "),
	R_1202010102 ("1202010102", "Dividen "),
	R_1202010103 ("1202010103", "Sewa "),
	R_1202010104 ("1202010104", "Laba (Rugi) Pelepasan Investasi "),
	R_1202010105 ("1202010105", "Pendapatan Investasi Lain  "),
	R_1202010200 ("1202010200", "Total Pendapatan Investasi"),
	R_1202010300 ("1202010300", "Peningkatan (Penurunan) Nilai Investasi "),
	R_1202010400 ("1202010400", "Iuran Jatuh Tempo:"),
	R_1202010401 ("1202010401", "Iuran Normal Pemberi Kerja"),
	R_1202010402 ("1202010402", "Iuran Normal Peserta"),
	R_1202010403 ("1202010403", "Iuran Sukarela Peserta"),
	R_1202010404 ("1202010404", "Iuran Tambahan"),
	R_1202010500 ("1202010500", "Pendapatan di Luar Investasi "),
	R_1202010600 ("1202010600", "Pengalihan Dana Dari Dana Pensiun Lain "),
	R_1202020000 ("1202020000", "Jumlah Penambahan"),
//	R_1202030000 ("1202030000", "PENGURANGAN"),
	R_1202030100 ("1202030100", "Beban Investasi "),
	R_1202030200 ("1202030200", "Beban Operasional "),
	R_1202030300 ("1202030300", "Beban di Luar Investasi dan Operasional "),
	R_1202030400 ("1202030400", "Manfaat Pensiun dan Manfaat Lain"),
	R_1202030500 ("1202030500", "Pajak Penghasilan "),
	R_1202030600 ("1202030600", "Pengalihan Dana ke Dana Pensiun Lain "),
	R_1202040000 ("1202040000", "Jumlah Pengurangan"),
	R_1202050000 ("1202050000", "Kenaikan (Penurunan) Aset Neto"),
	R_1202060000 ("1202060000", "Aset Neto Awal Periode"),
	R_1202070000 ("1202070000", "Aset Neto Akhir Periode"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2117PosRbDppu1202 eEnum : ER2117PosRbDppu1202.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2117PosRbDppu1202.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2117PosRbDppu1202.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}
	
	public static SegmentValidation genValidationTotalPendapatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1202010200.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 4),
				"Total Pendapatan Investasi|Penjumlahan Pendapatan Investasi");
	}
	
	public static SegmentValidation genValidationIuranJatuhTempo() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1202010400.key,
				UtilMetadata.genPlusRow(getObjects(), 8, 11),
				"Total Iuran Jatuh Tempo|Penjumlahan Iuran Jatuh Tempo");
	}
	
	public static SegmentValidation genValidationJumlahPenambahan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1202020000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 5, 6, 7, 12, 13 }),
				"Total Penambahan|Penjumlahan Penambahan");
	}
	
	public static SegmentValidation genValidationJumlahPengurangan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1202040000.key,
				UtilMetadata.genPlusRow(getObjects(), 15, 20),
				"Total Pengurangan|Penjumlahan Pengurangan");
	}
	
	public static SegmentValidation genValidationKenaikanAsetNeto() {
		int[] fields = new int[] { 14, 21 };
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1202050000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				"Total Kenaikan (Penurunan) Aset Neto|Perhitungan Kenaikan (Penurunan) Aset Neto");
	}
	
	public static SegmentValidation genValidationAsetNetoAkhirPeriode() {
		int[] fields = new int[] { 22, 23 };
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_1202070000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				"Total Aset Neto Akhir Periode|Perhitungan Aset Neto Akhir Periode");
	}
}
