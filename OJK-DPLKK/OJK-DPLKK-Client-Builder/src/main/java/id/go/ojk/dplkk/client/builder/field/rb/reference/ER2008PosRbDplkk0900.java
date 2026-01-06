package id.go.ojk.dplkk.client.builder.field.rb.reference;

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
public enum ER2008PosRbDplkk0900 implements IObject<KeyValueString> {
//	R_0901000000 ("0901000000", "PENDAPATAN INVESTASI"),
	R_0901010000 ("0901010000", "Bunga/Bagi Hasil"),
	R_0901020000 ("0901020000", "Dividen"),
	R_0901030000 ("0901030000", "Sewa"),
	R_0901040000 ("0901040000", "Laba (Rugi) Pelepasan Investasi"),
	R_0901050000 ("0901050000", "Pendapatan Investasi Lain "),
	R_0901060000 ("0901060000", "Total Pendapatan Investasi"),
	R_0901070000 ("0901070000", "Peningkatan (Penurunan) Nilai Investasi"),
	R_0901080000 ("0901080000", "Iuran"),
	R_0901090000 ("0901090000", "Pendapatan di Luar Investasi"),
	R_0901100000 ("0901100000", "Pengalihan Dana Dari Dana Pensiun Lain"),
	R_0901110000 ("0901110000", "Jumlah Penambahan"),
//	R_0902000000 ("0902000000", "PENGURANGAN"),
	R_0902010000 ("0902010000", "Beban Investasi"),
	R_0902020000 ("0902020000", "Beban Operasional"),
	R_0902030000 ("0902030000", "Beban di Luar Investasi dan OperasionalBeban di Luar Investasi dan Operasional"),
	R_0902040000 ("0902040000", "Manfaat Pensiun dan Manfaat Lain"),
	R_0902050000 ("0902050000", "Pajak Penghasilan"),
	R_0902060000 ("0902060000", "Pengalihan Dana ke Dana Pensiun Lain"),
	R_0902070000 ("0902070000", "Penarikan Iuran"),
	R_0902080000 ("0902080000", "Jumlah Pengurangan"),
	R_0903000000 ("0903000000", "KENAIKAN (PENURUNAN) ASET NETO"),
	R_0904000000 ("0904000000", "ASET NETO AWAL PERIODE"),
	R_0905000000 ("0905000000", "ASET NETO AKHIR PERIODE"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2008PosRbDplkk0900 eEnum : ER2008PosRbDplkk0900.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2008PosRbDplkk0900.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2008PosRbDplkk0900.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationPendapatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0901060000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 4),
				"Total Pendapatan Investasi|Penjumlahan Pendapatan Investasi");
	}

	public static SegmentValidation genValidationPenambahan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0901110000.key,
				UtilMetadata.genPlusRow(getObjects(), 5, 9),
				"Total Penambahan|Penjumlahan Penambahan");
	}

	public static SegmentValidation genValidationPengurangan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0902080000.key,
				UtilMetadata.genPlusRow(getObjects(), 11, 17),
				"Total Pengurangan|Penjumlahan Pengurangan");
	}

	public static SegmentValidation genValidationKenaikanAsetNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0903000000.key,
				R_0901110000.key + "-" + R_0902080000.key,
				"Total Kenaikan (Penurunan) Aset Neto|Penjumlahan Kenaikan (Penurunan) Aset Neto");
	}

	public static SegmentValidation genValidationAsetNetoAkhirPeriode() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0905000000.key,
				R_0903000000.key + "+" + R_0904000000.key,
				"Total Aset Neto Akhir Periode|Penjumlahan Aset Neto Akhir Periode");
	}
}
