package id.go.ojk.fink.client.builder.field.lt.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.fink.client.builder.field.EFormLaporanTahunan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER6002PosLtFink1200 implements IObject<KeyValueString> {
//	R_120001000000("120001000000", "I. Pendapatan Operasional"),
	R_120001010000("120001010000", "1. Pendapatan atas Komisi/Ujrah"),
	R_120001020000("120001020000", "2. Pendapatan atas Denda"),
	R_120002000000("120002000000", "Jumlah Pendapatan Operasional"),
//	R_120003000000("120003000000", "II. Beban Operasional"),
	R_120003010000("120003010000", "1. Beban atas Pendapatan"),
	R_120003020000("120003020000", "2. Beban atas Penyisihan Piutang Ragu-Ragu"),
	R_120003030000("120003030000", "3. Beban Ketenagakerjaan"),
	R_120003030100("120003030100", "Beban Peningkatan Kompetensi dan Keahlian SDM"),
	R_120003040000("120003040000", "4. Beban Pemasaran dan Periklanan"),
	R_120003050000("120003050000", "5. Beban Umum dan Administrasi"),
	R_120003060000("120003060000", "6. Beban Pengembangan dan Pemeliharaan IT "),
	R_120003070000("120003070000", "7. Beban penyusutan"),
	R_120003080000("120003080000", "8. Beban Amortisasi"),
	R_120004000000("120004000000", "Jumlah Beban Operasional"),
	R_120005000000("120005000000", "Laba (Rugi) Operasional"),
//	R_120006000000("120006000000", "III. Pendapatan Non Operasional"),
	R_120006010000("120006010000", "1. Pendapatan Bunga "),
	R_120006020000("120006020000", "2. Pendapatan Lainnya"),
	R_120007000000("120007000000", "Jumlah Pendapatan Non Operasional"),
//	R_120008000000("120008000000", "IV. Beban Non Operasional"),
	R_120008010000("120008010000", "1. Beban Bunga"),
	R_120008020000("120008020000", "2. Beban Administrasi Bank"),
	R_120008030000("120008030000", "3. Laba (Rugi) Selisih Kurs"),
	R_120008040000("120008040000", "4. Beban Lainnya"),
	R_120009000000("120009000000", "Jumlah Beban Non Operasional"),
	R_120010000000("120010000000", "Laba (Rugi) Sebelum Pajak"),
	R_120011000000("120011000000", "Beban Pajak"),
	R_120012000000("120012000000", "Laba (Rugi) Setelah Pajak"),
	R_120012010000("120012010000", "Pendapatan (Beban) Komprehensif Lainnya"),
	R_120013000000("120013000000", "Laba (Rugi) Komprehensif"),
	;

	@Getter
	private String key;
	private String value;

	public String getValue() {
		String marker = ". ";
		int idx = value.indexOf(marker);
		return idx > -1 ? value.substring(idx + 1).trim() : value;
	}

	public KeyValueString getObject() {
		return new KeyValueString(key, getValue(), new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER6002PosLtFink1200 eEnum : ER6002PosLtFink1200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER6002PosLtFink1200.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER6002PosLtFink1200.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}

	public static SegmentValidation genRowValidation03() {
		return UtilSegmentValidation.genEqualsFormula("2", R_120002000000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 1),
				UtilMetadata.genMessage(R_120002000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 0, 1)));
	}

	public static SegmentValidation genRowValidation06() {
		return UtilSegmentValidation.genGreaterEquals("2", R_120003030000.key, R_120003030100.key);
	}

	public static SegmentValidation genRowValidation07() {
		return UtilSegmentValidation.genEqualsForm("2", R_120003040000.key, EFormLaporanTahunan.LT_2118.getCode(), "3",
				ER6013PosLtFink2118.R_211801000000.getKey(),
				UtilMetadata.genMessage(R_120003040000.getValue(), "Total jumlah pada form 2118"));
	}

	public static SegmentValidation genRowValidation09() {
		return UtilSegmentValidation.genEqualsForm("2", R_120003060000.key, EFormLaporanTahunan.LT_2913.getCode(), "3",
				ER6014PosLtFink2913.R_291301000000.getKey(),
				UtilMetadata.genMessage(R_120003060000.getValue(), "Total jumlah pada form 2913"));
	}

	public static SegmentValidation genRowValidation12() {
		int[] rows = new int[] { 3, 4, 5, 7, 8, 9, 10, 11 };
		return UtilSegmentValidation.genEqualsFormula("2", R_120004000000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_120004000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation13() {
		int[] rows = new int[] { 2, 12 };
		return UtilSegmentValidation.genEqualsFormula("2", R_120005000000.key,
				UtilMetadata.genMinusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_120005000000.getValue(), UtilMetadata.genMinusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation16A() {
		return UtilSegmentValidation.genEqualsFormula("2", R_120007000000.key,
				UtilMetadata.genPlusRow(getObjects(), 14, 15),
				UtilMetadata.genMessage(R_120007000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 14, 15)));
	}

	public static SegmentValidation genRowValidation16B() {
		return UtilSegmentValidation.genEqualsForm("2", R_120007000000.key, EFormLaporanTahunan.LT_2119.getCode(), "3",
				ER6015PosLtFink2119.R_211901000000.getKey(),
				UtilMetadata.genMessage(R_120007000000.getValue(), "Total jumlah pada form 2119"));
	}

	public static SegmentValidation genRowValidation21() {
		return UtilSegmentValidation.genEqualsFormula("2", R_120009000000.key,
				UtilMetadata.genPlusRow(getObjects(), 17, 20),
				UtilMetadata.genMessage(R_120009000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 17, 20)));
	}

	public static SegmentValidation genRowValidation22() {
		int[] rowsPlus = new int[] { 13, 16 };
		return UtilSegmentValidation.genEqualsFormula("2", R_120010000000.key,
				UtilMetadata.genPlusRow(getObjects(), rowsPlus) + "-" + R_120009000000.key,
				UtilMetadata.genMessage(R_120010000000.getValue(),
						UtilMetadata.genPlusDesc(getObjects(), rowsPlus) + "-'" + R_120009000000.getValue() + "'"));
	}

	public static SegmentValidation genRowValidation24() {
		int[] rows = new int[] { 22, 23 };
		return UtilSegmentValidation.genEqualsFormula("2", R_120012000000.key,
				UtilMetadata.genMinusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_120012000000.getValue(), UtilMetadata.genMinusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation26() {
		return UtilSegmentValidation.genEqualsFormula("2", R_120013000000.key,
				UtilMetadata.genPlusRow(getObjects(), 24, 25),
				UtilMetadata.genMessage(R_120013000000.getValue(), UtilMetadata.genPlusDesc(getObjects(), 24, 25)));
	}
}
