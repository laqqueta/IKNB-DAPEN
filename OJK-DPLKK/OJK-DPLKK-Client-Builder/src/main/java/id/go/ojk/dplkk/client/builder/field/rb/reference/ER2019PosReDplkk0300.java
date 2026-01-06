package id.go.ojk.dplkk.client.builder.field.rb.reference;

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
public enum ER2019PosReDplkk0300 implements IObject<KeyValueString> {
//	R_0301000000 ("0301000000", "PENDAPATAN INVESTASI"),
	R_0301010000 ("0301010000", "Bunga/Bagi Hasil"),
	R_0301020000 ("0301020000", "Dividen"),
	R_0301030000 ("0301030000", "Sewa"),
	R_0301040000 ("0301040000", "Laba (Rugi) Pelepasan Investasi"),
	R_0301050000 ("0301050000", "Pendapatan Investasi Lain "),
	R_0301060000 ("0301060000", "Total Pendapatan Investasi"),
	R_0301070000 ("0301070000", "Peningkatan (Penurunan) Nilai Investasi"),
	R_0301080000 ("0301080000", "Iuran"),
	R_0301090000 ("0301090000", "Pendapatan di Luar Investasi"),
	R_0301100000 ("0301100000", "Pengalihan Dana Dari Dana Pensiun Lain"),
	R_0301110000 ("0301110000", "Jumlah Penambahan"),
//	R_0302000000 ("0302000000", "PENGURANGAN"),
	R_0302010000 ("0302010000", "Beban Investasi"),
	R_0302020000 ("0302020000", "Beban Operasional"),
	R_0302030000 ("0302030000", "Beban di Luar Investasi dan OperasionalBeban di Luar Investasi dan Operasional"),
	R_0302040000 ("0302040000", "Manfaat Pensiun dan Manfaat Lain"),
	R_0302050000 ("0302050000", "Pajak Penghasilan"),
	R_0302060000 ("0302060000", "Pengalihan Dana ke Dana Pensiun Lain"),
	R_0302070000 ("0302070000", "Penarikan Iuran"),
	R_0302080000 ("0302080000", "Jumlah Pengurangan"),
	R_0303000000 ("0303000000", "KENAIKAN (PENURUNAN) ASET NETO"),
	R_0304000000 ("0304000000", "ASET NETO AWAL PERIODE"),
	R_0305000000 ("0305000000", "ASET NETO AKHIR PERIODE"),
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
		for (ER2019PosReDplkk0300 eEnum : ER2019PosReDplkk0300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2019PosReDplkk0300.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2019PosReDplkk0300.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4", getObjects());
	}
	
	public static FieldValidation genValidation4() {
		return UtilFieldValidation.genEqualsRatio("3|2");
	}
	
	public static FieldValidation genValidation5() {
		return UtilFieldValidation.genEqualsFormula("3-2");
	}

	public static SegmentValidation genValidationPendapatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0301060000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 4), 
				"Total Pendapatan Investasi|Penjumlahan Pendapatan Investasi");
	}

	public static SegmentValidation genValidationPenambahan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0301110000.key,
				UtilMetadata.genPlusRow(getObjects(), 5, 9), 
				"Total Penambahan|Penjumlahan Penambahan");
	}

	public static SegmentValidation genValidationPengurangan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0302080000.key,
				UtilMetadata.genPlusRow(getObjects(), 11, 17), 
				"Total Pengurangan|Penjumlahan Pengurangan");
	}

	public static SegmentValidation genValidationKenaikanAsetNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0303000000.key,
				R_0301110000.key + "-" + R_0302080000.key, 
				"Total Kenaikan (Penurunan) Aset Neto|Penjumlahan Kenaikan (Penurunan) Aset Neto");
	}

	public static SegmentValidation genValidationAsetNetoAkhirPeriode() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0305000000.key,
				R_0303000000.key + "+" + R_0304000000.key, 
				"Total Aset Neto Akhir Periode|Penjumlahan Aset Neto Akhir Periode");
	}
}
