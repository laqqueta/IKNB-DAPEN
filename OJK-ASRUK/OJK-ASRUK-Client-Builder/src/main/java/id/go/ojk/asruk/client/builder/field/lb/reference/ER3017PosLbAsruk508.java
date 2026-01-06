package id.go.ojk.asruk.client.builder.field.lb.reference;

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
public enum ER3017PosLbAsruk508 implements IObject<KeyValueString> {
//	R_7305010000 ("7305010000", "I. Risiko Operasional Perusahaan"),
	R_7305010100 ("7305010100", "a. Beban Umum dan Administrasi"),
	R_7305010200 ("7305010200", "b. Beban Pendidikan dan Pelatihan"),
	R_7305010300 ("7305010300", "c. Saldo Biaya Akuisisi yang Ditangguhkan"),
	R_7305010400 ("7305010400", "Sub Total Risiko Operasional Perusahaan ((0,01 x (a-b)) + (0,5 x c)"),
//	R_7305020000 ("7305020000", "II. Risiko Operasional PAYDI (ROPAYDI)"),
	R_7305020100 ("7305020100", "d. Dana Kelolaan PAYDI "),
	R_7305020200 ("7305020200", "Sub Total Risiko Operasional PAYDI (ROPAYDI = (1‰*d))"),
	R_7305000000 ("7305000000", "Total Deviasi"),
	;
	
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3017PosLbAsruk508 eEnum : ER3017PosLbAsruk508.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	public static SegmentValidation genValidationTotalDeviasi() {
		return UtilSegmentValidation.genEqualsFormula("2", R_7305000000.key, UtilMetadata.genPlusRow(getObjects(), new int[] { 3, 5 }), 
				"Total deviasi|Penjumlahan deviasi", 0);
	}

	public static SegmentValidation genValidationTotalRisikoOperasionalPAYDI() {
		return UtilSegmentValidation.genMultiply("2", R_7305020200.key, R_7305020100.key, ".001", 0,
				"perkalian 0.001 dengan Dana Kelolaan PAYDI");
	}
	
	public static SegmentValidation genValidationTotalRisikoOperasionalPerusahaan() {
		return UtilSegmentValidation.genRisikoOperasionalPerusahaan("2", R_7305010400.key, 
				R_7305010100.key, R_7305010200.key, R_7305010300.key, 0);
	}
}
