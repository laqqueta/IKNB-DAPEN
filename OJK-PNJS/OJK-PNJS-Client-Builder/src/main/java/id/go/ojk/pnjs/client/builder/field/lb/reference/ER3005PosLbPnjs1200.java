package id.go.ojk.pnjs.client.builder.field.lb.reference;

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
public enum ER3005PosLbPnjs1200 implements IObject<KeyValueString> {
//	R_12000100000000 ("12000100000000", "Pendapatan"),
//	R_12000101000000 ("12000101000000", "Pendapatan IJK"),
	R_12000101010000 ("12000101010000", "IJK Bruto"),
	R_12000101020000 ("12000101020000", "Beban IJK co-guarantee/IJK penjaminan ulang/premi reasuransi"),
	R_12000101030000 ("12000101030000", "Pendapatan Komisi Penjaminan"),
	R_12000101040000 ("12000101040000", "Biaya Akuisisi"),
	R_12000101050000 ("12000101050000", "Beban Komisi Penjaminan"),
	R_12000101060000 ("12000101060000", "Jumlah Pendapatan IJK Bersih"),
//	R_12000102000000 ("12000102000000", "Pendapatan Operasional Lainnya"),
	R_12000102010000 ("12000102010000", "Pendapatan Bagi Hasil"),
	R_12000102020000 ("12000102020000", "Pendapatan Investasi Selain Bagi Hasil"),
	R_12000102030000 ("12000102030000", "Peningkatan Nilai Wajar Surat Berharga"),
	R_12000102040000 ("12000102040000", "Keuntungan Atas Penjualan Aset Keuangan"),
	R_12000102050000 ("12000102050000", "Penjualan Investasi Pada Entitas Asosiasi/Ventura Bersama"),
	R_12000102060000 ("12000102060000", "Pendapatan Subrogasi"),
	R_12000102070000 ("12000102070000", "Pendapatan Operasional Lain-Lain"),
	R_12000102080000 ("12000102080000", "Jumlah Pendapatan Operasional Lainnya"),
	R_12000103000000 ("12000103000000", "Pendapatan Operasional"),
	R_12000104000000 ("12000104000000", "Pendapatan Non-Operasional"),
	R_12000105000000 ("12000105000000", "Jumlah Total Pendapatan"),
//	R_12000200000000 ("12000200000000", "Beban"),
//	R_12000201000000 ("12000201000000", "Klaim"),
	R_12000201010000 ("12000201010000", "Beban Klaim"),
	R_12000201020000 ("12000201020000", "Kenaikan/(Penurunan) Cadangan Klaim"),
	R_12000201030000 ("12000201030000", "Jumlah Beban Klaim"),
//	R_12000202000000 ("12000202000000", "Beban Operasional Lainnya"),
	R_12000202010000 ("12000202010000", "Beban Pegawai"),
	R_12000202020000 ("12000202020000", "Beban Pengembangan dan Pelatihan Tenaga Kerja"),
	R_12000202030000 ("12000202030000", "Beban Umum dan Administrasi"),
	R_12000202040000 ("12000202040000", "Beban Depresiasi dan Amortisasi"),
	R_12000202050000 ("12000202050000", "Penurunan Nilai Wajar Aset Keuangan"),
	R_12000202060000 ("12000202060000", "Kenaikan Nilai Wajar Liabilitas Keuangan"),
	R_12000202070000 ("12000202070000", "Kerugian Penjualan Aset Keuangan"),
	R_12000202080000 ("12000202080000", "Kerugian Penjualan Surat Berharga"),
	R_12000202090000 ("12000202090000", "Kerugian Penjualan Investasi pada Entitas Asosiasi/Ventura Bersama"),
	R_12000202100000 ("12000202100000", "Beban Operasional Lain-Lain"),
	R_12000202110000 ("12000202110000", "Jumlah Beban Operasional Lainnya"),
	R_12000203000000 ("12000203000000", "Jumlah Beban Operasional"),
	R_12000204000000 ("12000204000000", "Beban Non-Operasional"),
	R_12000205000000 ("12000205000000", "Jumlah Total Beban"),
	R_12000300000000 ("12000300000000", "Laba/(Rugi) Sebelum Pajak"),
	R_12000400000000 ("12000400000000", "Beban Pajak"),
	R_12000500000000 ("12000500000000", "Laba/(Rugi) Setelah Pajak"),
	R_12000600000000 ("12000600000000", "Pendapatan Komprehensif Lainnya"),
	R_12000700000000 ("12000700000000", "Laba/(Rugi) Komprehensif"),
	;

	@Getter
	private String key;
	private String value;

    private static final int[] negativeFields = { 1, 3, 4, 5, 18, 31, 32, 34, 36, 37, 38 };

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3005PosLbPnjs1200 eEnum : ER3005PosLbPnjs1200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3005PosLbPnjs1200.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3005PosLbPnjs1200.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2",
				UtilMetadata.genPipeRowExcept(getObjects(), negativeFields));
	}
	
	public static SegmentValidation genValidationNumericNegative() {
		return UtilSegmentValidation.genRegexNumericNegative("2",
				UtilMetadata.genPipeRow(getObjects(), negativeFields));
	}
	
	public static SegmentValidation genValidation07() {
		return UtilSegmentValidation.genEqualsFormula("2", R_12000101060000.key,
				R_12000101010000.key + "-" + UtilMetadata.genPlusRow(getObjects(), 1, 2) + "-"
						+ UtilMetadata.genMinusRow(getObjects(), 3, 4),
				UtilMetadata.genMessage(R_12000101060000.value,
						"'" + R_12000101010000.value + "'-" + UtilMetadata.genPlusDesc(getObjects(), 1, 2) + "-"
								+ UtilMetadata.genMinusDesc(getObjects(), 3, 4)));
	}

	public static SegmentValidation genValidation15() {
		return UtilSegmentValidation.genEqualsFormula("2", R_12000102080000.key,
				UtilMetadata.genPlusRow(getObjects(), 6, 12),
				UtilMetadata.genMessage(R_12000102080000.value, UtilMetadata.genPlusDesc(getObjects(), 6, 12)));
	}

	public static SegmentValidation genValidation16() {
		int[] field = new int[] { 5, 13 };
		return UtilSegmentValidation.genEqualsFormula("2", R_12000103000000.key,
				UtilMetadata.genPlusRow(getObjects(), field),
				UtilMetadata.genMessage(R_12000103000000.value, UtilMetadata.genPlusDesc(getObjects(), field)));
	}

	public static SegmentValidation genValidation18() {
		return UtilSegmentValidation.genEqualsFormula("2", R_12000105000000.key,
				UtilMetadata.genPlusRow(getObjects(), 14, 15),
				UtilMetadata.genMessage(R_12000105000000.value, UtilMetadata.genPlusDesc(getObjects(), 14, 15)));
	}

	public static SegmentValidation genValidation21() {
		return UtilSegmentValidation.genEqualsFormula("2", R_12000201030000.key,
				UtilMetadata.genPlusRow(getObjects(), 17, 18),
				UtilMetadata.genMessage(R_12000201030000.value, UtilMetadata.genPlusDesc(getObjects(), 17, 18)));
	}

	public static SegmentValidation genValidation32() {
		return UtilSegmentValidation.genEqualsFormula("2", R_12000202110000.key,
				UtilMetadata.genPlusRow(getObjects(), 20, 29),
				UtilMetadata.genMessage(R_12000202110000.value, UtilMetadata.genPlusDesc(getObjects(), 20, 29)));
	}

	public static SegmentValidation genValidation33() {
		int[] field = new int[] { 19, 30 };
		return UtilSegmentValidation.genEqualsFormula("2", R_12000203000000.key,
				UtilMetadata.genPlusRow(getObjects(), field),
				UtilMetadata.genMessage(R_12000203000000.value, UtilMetadata.genPlusDesc(getObjects(), field)));
	}

	public static SegmentValidation genValidation35() {
		return UtilSegmentValidation.genEqualsFormula("2", R_12000205000000.key,
				UtilMetadata.genPlusRow(getObjects(), 31, 32),
				UtilMetadata.genMessage(R_12000205000000.value, UtilMetadata.genPlusDesc(getObjects(), 31, 32)));
	}

	public static SegmentValidation genValidation36() {
		int[] field = new int[] { 16, 33 };
		return UtilSegmentValidation.genEqualsFormula("2", R_12000300000000.key,
				UtilMetadata.genMinusRow(getObjects(), field),
				UtilMetadata.genMessage(R_12000300000000.value, UtilMetadata.genMinusDesc(getObjects(), field)));
	}

	public static SegmentValidation genValidation38() {
		int[] field = new int[] { 34, 35 };
		return UtilSegmentValidation.genEqualsFormula("2", R_12000500000000.key,
				UtilMetadata.genMinusRow(getObjects(), field),
				UtilMetadata.genMessage(R_12000500000000.value, UtilMetadata.genMinusDesc(getObjects(), field)));
	}

	public static SegmentValidation genValidation40() {
		return UtilSegmentValidation.genEqualsFormula("2", R_12000700000000.key,
				UtilMetadata.genPlusRow(getObjects(), 36, 37),
				UtilMetadata.genMessage(R_12000700000000.value, UtilMetadata.genPlusDesc(getObjects(), 36, 37)));
	}

    public static SegmentValidation genValidation41() {
        return UtilSegmentValidation.genEqualsFormAdd("2", R_12000201010000.key, "35|71",
                ER3032PosLbPnjs3500A.R_3500A10000.getKeyForm() + "|" + ER3033PosLbPnjs3500B.R_3500B10000.getKeyForm(),
                UtilMetadata.genMessage(R_12000201010000.value,
                        "\"Total klaim dibayar\" yang dilaporkan pada form \"Daftar Rincian Laporan Klaim Penjaminan Per Status Klaim\" (form 3500A+form 3500B)"));
    }
}
