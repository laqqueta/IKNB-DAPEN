package id.go.ojk.pnjs.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1185JenisPenjaminan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.pnjs.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3003PosLbPnjs1000 implements IObject<KeyValueString> {
	R_1000010000 ("1000010000", "Aset"),
	R_1000020000 ("1000020000", "Investasi"),
	R_1000030000 ("1000030000", "Liabilitas"),
	R_1000040000 ("1000040000", "Ekuitas"),
	R_1000050000 ("1000050000", "Laba/(rugi) bersih"),
	R_1000060000 ("1000060000", "Nilai Kafalah usaha produktif"),
	R_1000060100 ("1000060100", "Nilai Kafalah usaha produktif - KUR"),
	R_1000060200 ("1000060200", "Nilai Kafalah usaha produktif - UMKM Non KUR"),
	R_1000060300 ("1000060300", "Nilai kafalah usaha produktif - Non UMKM"),
	R_1000080000 ("1000080000", "Nilai kafalah usaha non produktif"),
	R_1000100000 ("1000100000", "Total Kafalah"),
	R_1000110000 ("1000110000", "Total Gearing Ratio"),
	R_1000120000 ("1000120000", "Imbal Jasa Kafalah"),
	R_1000130000 ("1000130000", "Jumlah terjamin (Makfuul 'Anhu) total"),
	R_1000140000 ("1000140000", "Jumlah terjamin (Makfuul 'Anhu) produktif"),
	R_1000140100 ("1000140100", "Jumlah terjamin (Makfuul 'Anhu) produktif - KUR"),
	R_1000140200 ("1000140200", "Jumlah terjamin (Makfuul 'Anhu) produktif - UMKM Non KUR"),
	R_1000140300 ("1000140300", "Jumlah terjamin (Makfuul 'Anhu) produktif - Non UMKM"),
	R_1000150000 ("1000150000", "Jumlah terjamin (Makfuul 'Anhu) non produktif"),
	R_1000160000 ("1000160000", "Klaim dibayar"),
	R_1000170000 ("1000170000", "Piutang subrogasi"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3003PosLbPnjs1000 eEnum : ER3003PosLbPnjs1000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3003PosLbPnjs1000.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3003PosLbPnjs1000.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2",
				UtilMetadata.genPipeRowExcept(getObjects(), new int[] { 4, 12, 11 }));
	}
	
	public static SegmentValidation genValidationNumericNegative() {
		return UtilSegmentValidation.genRegexNumericNegative("2",
				UtilMetadata.genPipeRow(getObjects(), new int[] { 4, 12 }));
	}
	
	public static SegmentValidation genValidationNumericDot() {
		return UtilSegmentValidation.genRegexNumericDot("2", UtilMetadata.genPipeRow(getObjects(), new int[] { 11}));
	}
	
	public static SegmentValidation genValidation02() {
		return UtilSegmentValidation.genEqualsForm("2", R_1000010000.key, EFormLaporanBulanan.LB_1100.getCode(), "2", 
				ER3004PosLbPnjs1100.R_11000103000000.getKey());
	}
	
	public static SegmentValidation genValidation03() {
		int[] fieldForm = new int[] { 1, 29 };
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_1000020000.key, "2",
				UtilMetadata.genPlusRow(ER3004PosLbPnjs1100.getObjectsForm(), fieldForm),
				UtilMetadata.genMessage(R_1000020000.value,
						UtilMetadata.genPlusDesc(ER3004PosLbPnjs1100.getObjects(), fieldForm) + " pada form 1100"));
	}
	
	public static SegmentValidation genValidation04() {
		return UtilSegmentValidation.genEqualsForm("2", R_1000030000.key, EFormLaporanBulanan.LB_1100.getCode(), "2", 
				ER3004PosLbPnjs1100.R_11000203000000.getKey());
	}
	
	public static SegmentValidation genValidation05() {
		return UtilSegmentValidation.genEqualsForm("2", R_1000040000.key, EFormLaporanBulanan.LB_1100.getCode(), "2", 
				ER3004PosLbPnjs1100.R_11000302000000.getKey());
	}
	
	public static SegmentValidation genValidation06() {
		return UtilSegmentValidation.genEqualsForm("2", R_1000050000.key, EFormLaporanBulanan.LB_1200.getCode(), "2", 
				ER3005PosLbPnjs1200.R_12000500000000.getKey());
	}
	
	public static SegmentValidation genValidation07A() {
		int[] field = new int[] { 6, 7, 8 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1000060000.key, UtilMetadata.genPlusRow(getObjects(), field),
				UtilMetadata.genMessage(R_1000060000.value, UtilMetadata.genPlusDesc(getObjects(), field)));
	}
	
	public static SegmentValidation genValidation07B() {
		return UtilSegmentValidation.genEqualsForm("2", R_1000060000.key, EFormLaporanBulanan.LB_7100.getCode(), "2", 
				ER3037PosLbPnjs7100.R_7100010000.getKey());
	}
	
	public static SegmentValidation genValidation12() {
		return UtilSegmentValidation.genEqualsForm("2", R_1000080000.key, EFormLaporanBulanan.LB_7100.getCode(), "3", 
				ER3037PosLbPnjs7100.R_7100010000.getKey());
	}
	
	public static SegmentValidation genValidation14() {
		return UtilSegmentValidation.genEqualsForm("2", R_1000100000.key, EFormLaporanBulanan.LB_7100.getCode(), "4", 
				ER3037PosLbPnjs7100.R_7100010000.getKey());
	}
	
	public static SegmentValidation genValidation15() {
		return UtilSegmentValidation.genEqualsForm("2", R_1000110000.key, EFormLaporanBulanan.LB_7100.getCode(), "4", 
				ER3037PosLbPnjs7100.R_7100030000.getKey());
	}
	
	public static SegmentValidation genValidation16() {
		return UtilSegmentValidation.genEqualsForm("2", R_1000120000.key, EFormLaporanBulanan.LB_1200.getCode(), "2", 
				ER3005PosLbPnjs1200.R_12000101060000.getKey());
	}

	public static SegmentValidation genValidation17() {
		return UtilSegmentValidation.genEqualsFormTotalRowExpectPos("2", R_1000130000.key,
				EFormLaporanBulanan.LB_3100.getCode(), ER3025PosLbPnjs3100.R_3100000000.getKey(), UtilMetadata.genMessage(R_1000130000.value,
						"jumlah baris rincian detail pada form \"Daftar Rincian Penjaminan\" (form 3100)"));
	}
	
	public static SegmentValidation genValidation18A() {
		int[] field = new int[] { 15, 16, 17 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1000140000.key, UtilMetadata.genPlusRow(getObjects(), field),
				UtilMetadata.genMessage(R_1000140000.value, UtilMetadata.genPlusDesc(getObjects(), field)));
	}

	public static SegmentValidation genValidation18B() {
		return UtilSegmentValidation.genEqualsFormTotalRowNotInExpectPos("2", R_1000140000.key,
				EFormLaporanBulanan.LB_3100.getCode(), "7", ER1185JenisPenjaminan.R_14.getKey(),
                ER3025PosLbPnjs3100.R_3100000000.getKey(),
				UtilMetadata.genMessage(R_1000140000.value,
						"total rincian detail dengan kolom \"Jenis Penjaminan\" (8) adalah selain 'Penjaminan Non Produktif'  pada form \"Daftar Rincian Penjaminan\" (form 3100)"));
	}

	public static SegmentValidation genValidation22() {
		return UtilSegmentValidation.genEqualsFormTotalRowExpectPos("2", R_1000150000.key,
				EFormLaporanBulanan.LB_3100.getCode(), "7", ER1185JenisPenjaminan.R_14.getKey(),
                ER3025PosLbPnjs3100.R_3100000000.getKey(),
				UtilMetadata.genMessage(R_1000150000.value,
						"total rincian detail dengan kolom \"Jenis Penjaminan\" (8) adalah 'Penjaminan Non Produktif'  pada form \"Daftar Rincian Penjaminan\" (form 3100)"));
	}
	
	public static SegmentValidation genValidation23() {
		return UtilSegmentValidation.genEqualsFormAdd("2", R_1000160000.key, "35|71", 
				ER3032PosLbPnjs3500A.R_3500A10000.getKeyForm() + "|" + ER3033PosLbPnjs3500B.R_3500B10000.getKeyForm(), 
				UtilMetadata.genMessage(R_1000160000.value,
						"\"Total klaim dibayar\" yang dilaporkan pada form \"Daftar Rincian Laporan Klaim Penjaminan Per Status Klaim\" (form 3500A+form 3500B)"));
	}
	
	public static SegmentValidation genValidation24() {
		return UtilSegmentValidation.genEqualsForm("2", R_1000170000.key, EFormLaporanBulanan.LB_6100.getCode(), "2", 
				ER3036PosLbPnjs6100.R_6100030000.getKey());
	}

    public static SegmentValidation genValidationR1000100000() {
        return UtilSegmentValidation.genEqualsForm("2", R_1000100000.key, EFormLaporanBulanan.LB_3100.getCode(), "20",
                ER3025PosLbPnjs3100.R_3100000000.getKey()); // change later
    }
}
