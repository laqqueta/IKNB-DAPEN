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
public enum ER2004PosRbDplkk0500 implements IObject<KeyValueString> {
//	R_0501000000 ("0501000000", "INVESTASI"),
	R_0501010000 ("0501010000", "Tabungan pada Bank"), 
	R_0501020000 ("0501020000", "Deposito on call pada Bank"),
	R_0501030000 ("0501030000", "Deposito Berjangka pada Bank"),
	R_0501040000 ("0501040000", "Sertifikat Deposito pada Bank"),
	R_0501050000 ("0501050000", "Surat Berharga yang diterbitkan oleh Bank Indonesia"),
	R_0501060000 ("0501060000", "Surat Berharga Negara "),
	R_0501070000 ("0501070000", "Saham yang tercatat di Bursa Efek di Indonesia"),
	R_0501080000 ("0501080000", "Obligasi korporasi yang tercatat di bursa efek di indonesia"),
	R_0501090000 ("0501090000", "Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
	R_0501100000 ("0501100000", "Obligasi/Sukuk Daerah"), 
	R_0501110000 ("0501110000", "Reksa Dana"),
	R_0501120000 ("0501120000", "MTN"), 
	R_0501130000 ("0501130000", "Efek Beragun Aset"),
	R_0501140000 ("0501140000", "Dana investasi real estat berbentuk kontrak investasi kolektif"),
	R_0501150000 ("0501150000", "Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
	R_0501160000 ("0501160000", "Kontrak opsi dan kontrak berjangka efek yang tercatat di Bursa Efek di Indonesia"),
	R_0501170000 ("0501170000", "REPO"), 
	R_0501180000 ("0501180000", "Penyertaan langsung"),
	R_0501190000 ("0501190000", "Tanah di Indonesia"), 
	R_0501200000 ("0501200000", "Bangunan di Indonesia"),
	R_0501210000 ("0501210000", "Tanah dan Bangunan di Indonesia"), 
	R_0501220000 ("0501220000", "TOTAL"),;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2004PosRbDplkk0500 eEnum : ER2004PosRbDplkk0500.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2004PosRbDplkk0500.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2004PosRbDplkk0500.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 17), getObjects());
	}
	
	public static FieldValidation genValidationSumEqual5() {
		return UtilFieldValidation.genEqualsPosFormula("2+3-4", UtilMetadata.genPipeColumn(0, 19));
	}
	
	public static FieldValidation genValidationSumEqual9() {
		return UtilFieldValidation.genEqualsPosFormula("6+7-8", UtilMetadata.genPipeColumn(0, 19));
	}
	
	public static FieldValidation genValidationSumEqual13() {
		return UtilFieldValidation.genEqualsPosFormula("10+11-12", UtilMetadata.genPipeColumn(0, 19));
	}
	
	public static FieldValidation genValidationSumEqual17() {
		return UtilFieldValidation.genEqualsPosFormula("14+15-16", UtilMetadata.genPipeColumn(0, 19));
	}

	public static SegmentValidation genValidationInvestasi() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 17), R_0501220000.key,
				UtilMetadata.genPlusRow(getObjects(), 0, 20),
				"Total Investasi|Penjumlahan Investasi", 0);
	}
}
