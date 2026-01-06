package id.go.ojk.dplks.client.builder.field.rb.reference;

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
public enum ER2022PosReDplks0300 implements IObject<KeyValueString> {
//	R_0301000000 ("0301000000", "PENDAPATAN INVESTASI"),
	R_0301010000 ("0301010000", "Bagi Hasil"),
	R_0301020000 ("0301020000", "Dividen"),
	R_0301030000 ("0301030000", "Sewa"),
	R_0301040000 ("0301040000", "Laba (Rugi) Pelepasan Investasi"),
	R_0301050000 ("0301050000", "Pendapatan Investasi Lain "),
	R_0302000000 ("0302000000", "Total Pendapatan Investasi"),
	R_0303000000 ("0303000000", "Peningkatan (Penurunan) Nilai Investasi"),
	R_0304000000 ("0304000000", "Iuran"),
	R_0305000000 ("0305000000", "Pendapatan di Luar Investasi"),
	R_0306000000 ("0306000000", "Pengalihan Dana Dari Dana Pensiun Lain"),
	R_0307000000 ("0307000000", "Jumlah Penambahan"),
//	R_0308000000 ("0308000000", "PENGURANGAN"),
	R_0308010000 ("0308010000", "Beban Investasi"),
	R_0308020000 ("0308020000", "Beban Operasional"),
	R_0308030000 ("0308030000", "Beban di Luar Investasi dan Operasional"),
	R_0308040000 ("0308040000", "Manfaat Pensiun dan Manfaat Lain"),
	R_0308050000 ("0308050000", "Pajak Penghasilan"),
	R_0308060000 ("0308060000", "Pengalihan Dana ke Dana Pensiun Lain"),
	R_0308070000 ("0308070000", "Penarikan Iuran"),
	R_0309000000 ("0309000000", "Jumlah Pengurangan"),
	R_0310000000 ("0310000000", "KENAIKAN (PENURUNAN) ASET NETO"),
	R_0311000000 ("0311000000", "ASET NETO AWAL PERIODE"),
	R_0312000000 ("0312000000", "ASET NETO AKHIR PERIODE"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2022PosReDplks0300 eEnum : ER2022PosReDplks0300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2022PosReDplks0300.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2022PosReDplks0300.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}
	
	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsFormula("3-2", 2);
	}
	
	public static FieldValidation genValidation5() {
		return UtilFieldValidation.genEqualsRatio("3|2");
	}

	public static SegmentValidation genValidationPendapatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0302000000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 4), 
				"Total Pendapatan Investasi|Penjumlahan Pendapatan Investasi");
	}

	public static SegmentValidation genValidationPenambahan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0307000000.key,
				UtilMetadata.genPlusRow(getObjects(), 5, 9), 
				"Total Penambahan|Penjumlahan Penambahan");
	}

	public static SegmentValidation genValidationPengurangan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0309000000.key,
				UtilMetadata.genPlusRow(getObjects(), 11, 17), 
				"Total Pengurangan|Penjumlahan Pengurangan");
	}

	public static SegmentValidation genValidationKenaikanAsetNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0310000000.key,
				R_0307000000.key + "-" + R_0309000000.key, 
				"Total Kenaikan Aset Neto|Penjumlahan Kenaikan Aset Neto");
	}

	public static SegmentValidation genValidationAsetNetoAkhirPeriode() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0312000000.key,
				R_0310000000.key + "+" + R_0311000000.key, 
				"Total Aset Neto Akhir Periode|Penjumlahan Aset Neto Akhir Periode");
	}
}
