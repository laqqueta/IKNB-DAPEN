package id.go.ojk.dppkk.client.builder.field.rb.uus.reference;

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
public enum ER2108PosRbDppu0703 implements IObject<KeyValueString> {
//	R_0703000000 ("0703000000", "INVESTASI"),
	R_0703010000 ("0703010000", "1. Tabungan pada Bank"),
	R_0703020000 ("0703020000", "2. Deposito on call pada Bank"),
	R_0703030000 ("0703030000", "3. Deposito Berjangka pada Bank"),
	R_0703040000 ("0703040000", "4. Sertifikat Deposito pada Bank"),
	R_0703050000 ("0703050000", "5. Surat Berharga Berdasarkan Prinsip Syariah yang diterbitkan oleh Bank Indonesia"),
	R_0703060000 ("0703060000", "6. Surat Berharga Syariah Negara"),
	R_0703070000 ("0703070000", "7. Saham Syariah yang tercatat di Bursa Efek di Indonesia"),
	R_0703080000 ("0703080000", "8. Sukuk Korporasi yang Tercatat di Bursa Efek di Indonesia"),
	R_0703090000 ("0703090000", "9. Sukuk Daerah"),
	R_0703100000 ("0703100000", "10. Reksa Dana Syariah"),
	R_0703110000 ("0703110000", "11. MTN Syariah"),
	R_0703120000 ("0703120000", "12. Efek Beragun Aset Syariah"),
	R_0703130000 ("0703130000", "13. Dana investasi real estate Syariah berbentuk kontrak investasi kolektif"),
	R_0703140000 ("0703140000", "14. Dana investasi infrastruktur berbentuk kontrak investasi kolektif"),
	R_0703150000 ("0703150000", "15. Kontrak opsi dan kontrak berjangka efek syariah yang tercatat di Bursa Efek di Indonesia"),
	R_0703160000 ("0703160000", "16. REPO"),
	R_0703170000 ("0703170000", "17. Penyertaan langsung"),
	R_0703180000 ("0703180000", "18. Tanah di Indonesia"),
	R_0703190000 ("0703190000", "19. Bangunan di Indonesia"),
	R_0703200000 ("0703200000", "20. Tanah dan Bangunan di Indonesia"),
	R_0703220000 ("0703220000", "TOTAL"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2108PosRbDppu0703 eEnum : ER2108PosRbDppu0703.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2108PosRbDppu0703.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2108PosRbDppu0703.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17", getObjects());
	}
	
	public static FieldValidation genValidation5() {
		return UtilFieldValidation.genEqualsFormula("2+3-4", 2);
	}
	
	public static FieldValidation genValidation9() {
		return UtilFieldValidation.genEqualsFormula("6+7-8", 2);
	}
	
	public static FieldValidation genValidation13() {
		return UtilFieldValidation.genEqualsFormula("10+11-12", 2);
	}
	
	public static FieldValidation genValidation17() {
		return UtilFieldValidation.genEqualsFormula("14+15-16", 2);
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula("2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17", 
				R_0703220000.key, UtilMetadata.genPlusRow(getObjects(), 0, 19),
				"Total Investasi|Penjumlahan Investasi");
	}
}
