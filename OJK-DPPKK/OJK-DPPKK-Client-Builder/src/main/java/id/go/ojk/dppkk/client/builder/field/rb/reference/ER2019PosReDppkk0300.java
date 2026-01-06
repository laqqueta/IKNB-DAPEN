package id.go.ojk.dppkk.client.builder.field.rb.reference;

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
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2019PosReDppkk0300 implements IObject<KeyValueString> {
//	R_0301000000 ("0301000000", "PENAMBAHAN"),
//	R_0301010000 ("0301010000", "Pendapatan Investasi"),
	R_0301010100 ("0301010100", "Bunga/Bagi Hasil "),
	R_0301010200 ("0301010200", "Dividen "),
	R_0301010300 ("0301010300", "Sewa "),
	R_0301010400 ("0301010400", "Laba (Rugi) Pelepasan Investasi "),
	R_0301010500 ("0301010500", "Pendapatan Investasi Lain  "),
	R_0301010600 ("0301010600", "Total Pendapatan Investasi"),
	R_0301020000 ("0301020000", "Peningkatan (Penurunan) Nilai Investasi "),
	R_0301030000 ("0301030000", "Iuran Jatuh Tempo:"),
	R_0301030100 ("0301030100", "- Iuran Normal Pemberi Kerja"),
	R_0301030200 ("0301030200", "- Iuran Normal Peserta"),
	R_0301030300 ("0301030300", "- Iuran Sukarela Peserta"),
	R_0301030400 ("0301030400", "- Iuran Tambahan"),
	R_0301040000 ("0301040000", "Pendapatan di Luar Investasi "),
	R_0301050000 ("0301050000", "Pengalihan Dana Dari Dana Pensiun Lain "),
	R_0302000000 ("0302000000", "Jumlah Penambahan"),
//	R_0303000000 ("0303000000", "PENGURANGAN"),
	R_0303010000 ("0303010000", "Beban Investasi "),
	R_0303020000 ("0303020000", "Beban Operasional "),
	R_0303030000 ("0303030000", "Beban di Luar Investasi dan Operasional "),
	R_0303040000 ("0303040000", "Manfaat Pensiun dan Manfaat Lain"),
	R_0303050000 ("0303050000", "Pajak Penghasilan "),
	R_0303060000 ("0303060000", "Pengalihan Dana ke Dana Pensiun Lain "),
	R_0303070000 ("0303070000", "Jumlah Pengurangan"),
	R_0304000000 ("0304000000", "KENAIKAN (PENURUNAN) ASET NETO"),
	R_0305000000 ("0305000000", "ASET NETO AWAL PERIODE"),
	R_0306000000 ("0306000000", "ASET NETO AKHIR PERIODE"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2019PosReDppkk0300 eEnum : ER2019PosReDppkk0300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2019PosReDppkk0300.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2019PosReDppkk0300.class.getSimpleName().substring(2, 6));
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
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0301010600.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 4), 
				"Total Pendapatan Investasi|Penjumlahan Pendapatan Investasi");
	}

	public static SegmentValidation genValidationIuranJatuhTempo() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0301030000.key,
				UtilMetadata.genPlusRow(getObjects(), 8, 11), 
				"Total Iuran Jatuh Tempo|Penjumlahan Iuran Jatuh Tempo");
	}

	public static SegmentValidation genValidationPenambahan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0302000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 5, 6, 7, 12, 13 }), 
				"Total Penambahan|Penjumlahan Penambahan");
	}

	public static SegmentValidation genValidationPengurangan() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0303070000.key,
				UtilMetadata.genPlusRow(getObjects(), 15, 20), 
				"Total Pengurangan|Penjumlahan Pengurangan");
	}

	public static SegmentValidation genValidationKenaikanAsetNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0304000000.key,
				R_0302000000.key + "-" + R_0303070000.key, 
				"Total Kenaikan (Penurunan) Aset Neto|Penjumlahan Kenaikan (Penurunan) Aset Neto");
	}

	public static SegmentValidation genValidationAsetNetoAkhirPeriode() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_0306000000.key,
				R_0304000000.key + "+" + R_0305000000.key, 
				"Total Aset Neto Akhir Periode|Penjumlahan Aset Neto Akhir Periode");
	}
}
