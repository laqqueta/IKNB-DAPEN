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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER2003PosRbDppkk0400 implements IObject<KeyValueString> {
//	R_0401000000 ("0401000000", "Berdasarkan Nilai Perolehan"),
	R_0401010000 ("0401010000", "Tabungan pada Bank"),
	R_0401020000 ("0401020000", "Deposito on call pada Bank"),
	R_0401030000 ("0401030000", "Deposito Berjangka pada Bank"),
	R_0401040000 ("0401040000", "Sertifikat Deposito pada Bank"),
	R_0401050000 ("0401050000", "Surat Berharga yang diterbitkan oleh Bank Indonesia"),
	R_0401060000 ("0401060000", "Surat Berharga Negara "),
	R_0401070000 ("0401070000", "Saham yang tercatat di Bursa Efek di Indonesia"),
	R_0401080000 ("0401080000", "Obligasi korporasi yang tercatat di bursa efek di indonesia"),
	R_0401090000 ("0401090000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
	R_0401100000 ("0401100000", "Obligasi/Sukuk Daerah"),
	R_0401110000 ("0401110000", "Reksa Dana"),
	R_0401120000 ("0401120000", "MTN"),
	R_0401130000 ("0401130000", "Efek Beragun Aset"),
	R_0401140000 ("0401140000", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
	R_0401150000 ("0401150000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
	R_0401160000 ("0401160000", "Kontrak opsi dan kontrak berjangka efek yang tercatat di Bursa Efek di Indonesia"),
	R_0401170000 ("0401170000", "REPO"),
	R_0401180000 ("0401180000", "Penyertaan langsung"),
	R_0401190000 ("0401190000", "Tanah di Indonesia"),
	R_0401200000 ("0401200000", "Bangunan di Indonesia"),
	R_0401210000 ("0401210000", "Tanah dan Bangunan di Indonesia"),
	R_0401220000 ("0401220000", ""),
//	R_0402000000 ("0402000000", "Berdasarkan Nilai Wajar"),
	R_0402010000 ("0402010000", "Tabungan pada Bank"),
	R_0402020000 ("0402020000", "Deposito on call pada Bank"),
	R_0402030000 ("0402030000", "Deposito Berjangka pada Bank"),
	R_0402040000 ("0402040000", "Sertifikat Deposito pada Bank"),
	R_0402050000 ("0402050000", "Surat Berharga yang diterbitkan oleh Bank Indonesia"),
	R_0402060000 ("0402060000", "Surat Berharga Negara "),
	R_0402070000 ("0402070000", "Saham yang tercatat di Bursa Efek di Indonesia"),
	R_0402080000 ("0402080000", "Obligasi korporasi yang tercatat di bursa efek di indonesia"),
	R_0402090000 ("0402090000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
	R_0402100000 ("0402100000", "Obligasi/Sukuk Daerah"),
	R_0402110000 ("0402110000", "Reksa Dana"),
	R_0402120000 ("0402120000", "MTN"),
	R_0402130000 ("0402130000", "Efek Beragun Aset"),
	R_0402140000 ("0402140000", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
	R_0402150000 ("0402150000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
	R_0402160000 ("0402160000", "Kontrak opsi dan kontrak berjangka efek yang tercatat di Bursa Efek di Indonesia"),
	R_0402170000 ("0402170000", "REPO"),
	R_0402180000 ("0402180000", "Penyertaan langsung"),
	R_0402190000 ("0402190000", "Tanah di Indonesia"),
	R_0402200000 ("0402200000", "Bangunan di Indonesia"),
	R_0402210000 ("0402210000", "Tanah dan Bangunan di Indonesia"),
	R_0402220000 ("0402220000", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2003PosRbDppkk0400 eEnum : ER2003PosRbDppkk0400.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2003PosRbDppkk0400.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2003PosRbDppkk0400.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5|6|7|8|9", getObjects());
	}
	
	public static SegmentValidation genValidationFixedValue() {
		return UtilSegmentValidation.genFixedValue("3|5|7|9", R_0401220000.key + "|" + R_0402220000.key, "100.00");
	}

	public static SegmentValidation genValidationBerdasarkanNilaiPerolehan() {
		return UtilSegmentValidation.genEqualsFormula("2|4|6|8", R_0401220000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 20),
				"Total Berdasarkan Nilai Perolehan|Penjumlahan Berdasarkan Nilai Perolehan");
	}

	public static SegmentValidation genValidationRatioBerdasarkanNilaiPerolehan() {
		return UtilSegmentValidation.genSumPrecision("3|5|7|9", R_0401220000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 20), "0.05",
				"Total Persentase Nilai Perolehan|Penjumlahan Persentase Nilai Perolehan");
	}

	public static SegmentValidation genValidationRatioNilaiPerolehan3() {
		return UtilSegmentValidation.genCurrentRowVsCustomRowRatio("2|2|3", 
				UtilMetadata.genPipeRow(getObjects(), 0, 20), R_0401220000.key, 
				"Persentase Nilai Perolehan|Perhitungan Persentase Nilai Perolehan");
	}

	public static SegmentValidation genValidationRatioNilaiPerolehan5() {
		return UtilSegmentValidation.genCurrentRowVsCustomRowRatio("4|4|5", 
				UtilMetadata.genPipeRow(getObjects(), 0, 20), R_0401220000.key, 
				"Persentase Nilai Perolehan|Perhitungan Persentase Nilai Perolehan");
	}

	public static SegmentValidation genValidationRatioNilaiPerolehan7() {
		return UtilSegmentValidation.genCurrentRowVsCustomRowRatio("6|6|7", 
				UtilMetadata.genPipeRow(getObjects(), 0, 20), R_0401220000.key, 
				"Persentase Nilai Perolehan|Perhitungan Persentase Nilai Perolehan");
	}

	public static SegmentValidation genValidationRatioNilaiPerolehan9() {
		return UtilSegmentValidation.genCurrentRowVsCustomRowRatio("8|8|9", 
				UtilMetadata.genPipeRow(getObjects(), 0, 20), R_0401220000.key, 
				"Persentase Nilai Perolehan|Perhitungan Persentase Nilai Perolehan");
	}

	public static SegmentValidation genValidationBerdasarkanNilaiWajar() {
		return UtilSegmentValidation.genEqualsFormula("2|4|6|8", R_0402220000.key,
				UtilMetadata.genPlusRow(getObjects(), 22, 42),
				"Total Berdasarkan Nilai Wajar|Penjumlahan Berdasarkan Nilai Wajar");
	}

	public static SegmentValidation genValidationRatioBerdasarkanNilaiWajar() {
		return UtilSegmentValidation.genSumPrecision("3|5|7|9", R_0402220000.key,
				UtilMetadata.genPlusRow(getObjects(), 22, 42), "0.05",
				"Total Persentase Nilai Wajar|Penjumlahan Persentase Nilai Wajar");
	}

	public static SegmentValidation genValidationRatioNilaiWajar3() {
		return UtilSegmentValidation.genCurrentRowVsCustomRowRatio("2|2|3", 
				UtilMetadata.genPipeRow(getObjects(), 22, 42), R_0402220000.key, 
				"Persentase Nilai Wajar|Perhitungan Persentase Nilai Wajar");
	}

	public static SegmentValidation genValidationRatioNilaiWajar5() {
		return UtilSegmentValidation.genCurrentRowVsCustomRowRatio("4|4|5", 
				UtilMetadata.genPipeRow(getObjects(), 22, 42), R_0402220000.key, 
				"Persentase Nilai Wajar|Perhitungan Persentase Nilai Wajar");
	}

	public static SegmentValidation genValidationRatioNilaiWajar7() {
		return UtilSegmentValidation.genCurrentRowVsCustomRowRatio("6|6|7", 
				UtilMetadata.genPipeRow(getObjects(), 22, 42), R_0402220000.key, 
				"Persentase Nilai Wajar|Perhitungan Persentase Nilai Wajar");
	}

	public static SegmentValidation genValidationRatioNilaiWajar9() {
		return UtilSegmentValidation.genCurrentRowVsCustomRowRatio("8|8|9", 
				UtilMetadata.genPipeRow(getObjects(), 22, 42), R_0402220000.key, 
				"Persentase Nilai Wajar|Perhitungan Persentase Nilai Wajar");
	}
}
