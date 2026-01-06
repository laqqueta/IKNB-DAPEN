package id.go.ojk.dppks.client.builder.field.rb.reference;

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
public enum ER2006PosRbDppks0701 implements IObject<KeyValueString> {
	R_0701010100 ("0701010100", "1. Tabungan pada Bank"),
	R_0701010200 ("0701010200", "2. Deposito on call pada Bank"),
	R_0701010300 ("0701010300", "3. Deposito Berjangka pada Bank"),
	R_0701010400 ("0701010400", "4. Sertifikat Deposito pada Bank"),
	R_0701010500 ("0701010500", "5. Surat Berharga Berdasarkan Prinsip Syariah yang diterbitkan oleh Bank Indonesia"),
	R_0701010600 ("0701010600", "6. Surat Berharga Syariah Negara"),
	R_0701010700 ("0701010700", "7. Saham Syariah yang tercatat di Bursa Efek di Indonesia"),
	R_0701010800 ("0701010800", "8. Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
	R_0701010900 ("0701010900", "9. Sukuk Daerah"),
	R_0701011000 ("0701011000", "10. Reksa Dana Syariah"),
	R_0701011100 ("0701011100", "11. MTN Syariah"),
	R_0701011200 ("0701011200", "12. Efek Beragun Aset Syariah"),
	R_0701011300 ("0701011300", "13. Dana investasi real estate Syariah berbentuk kontrak investasi kolektif"),
	R_0701011400 ("0701011400", "14. Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
	R_0701011500 ("0701011500", "15. Kontrak opsi dan kontrak berjangka efek syariah yang tercatat di Bursa Efek di Indonesia"),
	R_0701011600 ("0701011600", "16. REPO"),
	R_0701011700 ("0701011700", "17. Penyertaan langsung"),
	R_0701011800 ("0701011800", "18. Tanah di Indonesia"),
	R_0701011900 ("0701011900", "19. Bangunan di Indonesia"),
	R_0701012000 ("0701012000", "20. Tanah dan Bangunan di Indonesia"),
	R_0701012100 ("0701012100", "Total"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2006PosRbDppks0701 eEnum : ER2006PosRbDppks0701.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2006PosRbDppks0701.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2006PosRbDppks0701.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5|6|7|8|9", getObjects());
	}
	
	public static SegmentValidation genValidationFixedValue() {
		return UtilSegmentValidation.genFixedValue("3|5|7|9", R_0701012100.key, "100.00");
	}

	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula("2|4|6|8", R_0701012100.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 19),
				"Total Investasi|Penjumlahan Investasi");
	}

	public static SegmentValidation genValidationRatioInvestasi() {
		return UtilSegmentValidation.genSumPrecision("3|5|7|9", R_0701012100.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 19), "0.05",
				"Total Rasio Investasi|Penjumlahan Rasio Investasi");
	}

	public static SegmentValidation genValidationRatioInvestasi3() {
		return UtilSegmentValidation.genCurrentRowVsCustomRowRatio("2|2|3", 
				UtilMetadata.genPipeRow(getObjects(), 0, 19), R_0701012100.key, 
				"Rasio Investasi|Perhitungan Rasio Investasi");
	}

	public static SegmentValidation genValidationRatioInvestasi5() {
		return UtilSegmentValidation.genCurrentRowVsCustomRowRatio("4|4|5", 
				UtilMetadata.genPipeRow(getObjects(), 0, 19), R_0701012100.key, 
				"Rasio Investasi|Perhitungan Rasio Investasi");
	}

	public static SegmentValidation genValidationRatioInvestasi7() {
		return UtilSegmentValidation.genCurrentRowVsCustomRowRatio("6|6|7", 
				UtilMetadata.genPipeRow(getObjects(), 0, 19), R_0701012100.key, 
				"Rasio Investasi|Perhitungan Rasio Investasi");
	}

	public static SegmentValidation genValidationRatioInvestasi9() {
		return UtilSegmentValidation.genCurrentRowVsCustomRowRatio("8|8|9", 
				UtilMetadata.genPipeRow(getObjects(), 0, 19), R_0701012100.key, 
				"Rasio Investasi|Perhitungan Rasio Investasi");
	}
}
