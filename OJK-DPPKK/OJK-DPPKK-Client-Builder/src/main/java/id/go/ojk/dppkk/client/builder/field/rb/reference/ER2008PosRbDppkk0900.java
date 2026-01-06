package id.go.ojk.dppkk.client.builder.field.rb.reference;

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
public enum ER2008PosRbDppkk0900 implements IObject<KeyValueString> {
//	R_0901000000 ("0901000000", "PENAMBAHAN"),
//	R_0901010000 ("0901010000", "Pendapatan Investasi"),
	R_0901010100 ("0901010100", "Bunga/Bagi Hasil "),
	R_0901010200 ("0901010200", "Dividen "),
	R_0901010300 ("0901010300", "Sewa "),
	R_0901010400 ("0901010400", "Laba (Rugi) Pelepasan Investasi "),
	R_0901010500 ("0901010500", "Pendapatan Investasi Lain  "),
	R_0901010600 ("0901010600", "Total Pendapatan Investasi"),
	R_0901020000 ("0901020000", "Peningkatan (Penurunan) Nilai Investasi "),
	R_0901030000 ("0901030000", "Iuran Jatuh Tempo:"),
	R_0901030100 ("0901030100", "- Iuran Normal Pemberi Kerja"),
	R_0901030200 ("0901030200", "- Iuran Normal Peserta"),
	R_0901030300 ("0901030300", "- Iuran Sukarela Peserta"),
	R_0901030400 ("0901030400", "- Iuran Tambahan"),
	R_0901040000 ("0901040000", "Pendapatan di Luar Investasi "),
	R_0901050000 ("0901050000", "Pengalihan Dana Dari Dana Pensiun Lain "),
	R_0902000000 ("0902000000", "Jumlah Penambahan"),
//	R_0903000000 ("0903000000", "PENGURANGAN"),
	R_0903010000 ("0903010000", "Beban Investasi "),
	R_0903020000 ("0903020000", "Beban Operasional "),
	R_0903030000 ("0903030000", "Beban di Luar Investasi dan Operasional "),
	R_0903040000 ("0903040000", "Manfaat Pensiun dan Manfaat Lain"),
	R_0903050000 ("0903050000", "Pajak Penghasilan "),
	R_0903060000 ("0903060000", "Pengalihan Dana ke Dana Pensiun Lain "),
	R_0903070000 ("0903070000", "Jumlah Pengurangan"),
	R_0904000000 ("0904000000", "KENAIKAN (PENURUNAN) ASET NETO"),
	R_0905000000 ("0905000000", "ASET NETO AWAL PERIODE"),
	R_0906000000 ("0906000000", "ASET NETO AKHIR PERIODE"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2008PosRbDppkk0900 eEnum : ER2008PosRbDppkk0900.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2008PosRbDppkk0900.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2008PosRbDppkk0900.class.getSimpleName().substring(2, 6));
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5", getObjects());
	}

	public static SegmentValidation genValidationPendapatanInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0901010600.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 4),
				"Total Pendapatan Investasi|Penjumlahan Pendapatan Investasi");
	}

	public static SegmentValidation genValidationIuranJatuhTempo() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0901030000.key,
				UtilMetadata.genPlusRow(getObjects(), 8, 11),
				"Total Iuran Jatuh Tempo|Penjumlahan Iuran Jatuh Tempo");
	}

	public static SegmentValidation genValidationPenambahan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0902000000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 5, 6, 7, 12, 13 }),
				"Total Penambahan|Penjumlahan Penambahan");
	}

	public static SegmentValidation genValidationPengurangan() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0903070000.key,
				UtilMetadata.genPlusRow(getObjects(), 15, 20),
				"Total Pengurangan|Penjumlahan Pengurangan");
	}

	public static SegmentValidation genValidationKenaikanAsetNeto() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0904000000.key,
				R_0902000000.key + "-" + R_0903070000.key,
				"Total Kenaikan (Penurunan) Aset Neto|Penjumlahan Kenaikan (Penurunan) Aset Neto");
	}

	public static SegmentValidation genValidationAsetNetoAkhirPeriode() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5", R_0906000000.key,
				R_0904000000.key + "+" + R_0905000000.key,
				"Total Aset Neto Akhir Periode|Penjumlahan Aset Neto Akhir Periode");
	}
}
