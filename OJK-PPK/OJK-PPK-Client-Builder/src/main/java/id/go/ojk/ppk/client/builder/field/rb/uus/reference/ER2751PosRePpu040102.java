package id.go.ojk.ppk.client.builder.field.rb.uus.reference;

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
public enum ER2751PosRePpu040102 implements IObject<KeyValueString> {
//	R_04010201000000 ("04010201000000", "Rencana Penyaluran Pembiayaan Syariah Baru:"),
	R_04010201010000 ("04010201010000", "Pembiayaan Jual Beli"),
	R_04010201010100 ("04010201010100", "a. Murabahah"),
	R_04010201010200 ("04010201010200", "b. Salam"),
	R_04010201010300 ("04010201010300", "c. Istisna’"),
	R_04010201010400 ("04010201010400", "d. Akad Selain Akad Sebagaimana Dimaksud pada Huruf a Sampai Dengan Huruf c"),
	R_04010201020000 ("04010201020000", "Pembiayaan Investasi"),
	R_04010201020100 ("04010201020100", "a. Mudharabah"),
	R_04010201020200 ("04010201020200", "b. Musyarakah"),
	R_04010201020300 ("04010201020300", "c. Mudharabah Musytarakah"),
	R_04010201020400 ("04010201020400", "d. Musyarakah Mutanaqishoh"),
	R_04010201020500 ("04010201020500", "e. Akad Selain Akad Sebagaimana Dimaksud pada Huruf a Sampai Dengan Huruf d"),
	R_04010201030000 ("04010201030000", "Pembiayaan Jasa"),
	R_04010201030100 ("04010201030100", "a. Ijarah"),
	R_04010201030200 ("04010201030200", "b. Ijarah Muntahiyah Bittamlik"),
	R_04010201030300 ("04010201030300", "c. Hawalah atau Hawalah bil Ujrah"),
	R_04010201030400 ("04010201030400", "d. Wakalah atau Wakalah Bil Ujrah"),
	R_04010201030500 ("04010201030500", "e. Kafalah atau Kafalah bil Ujrah"),
	R_04010201030600 ("04010201030600", "f. Ju’alah"),
	R_04010201030700 ("04010201030700", "g. Qardh"),
	R_04010201030800 ("04010201030800", "h. Akad Selain Akad Sebagaimana Dimaksud pada Huruf a Sampai Dengan Huruf g"),
	R_04010201040000 ("04010201040000", "Total Rencana Penyaluran Pembiayaan Syariah Baru"),
//	R_04010202000000 ("04010202000000", "Saldo Piutang Pembiayaan Syariah (Outstanding Principal):"),
	R_04010202010000 ("04010202010000", "Pembiayaan Jual Beli"),
	R_04010202010100 ("04010202010100", "a. Murabahah"),
	R_04010202010200 ("04010202010200", "b. Salam"),
	R_04010202010300 ("04010202010300", "c. Istisna’"),
	R_04010202010400 ("04010202010400", "d. Akad Selain Akad Sebagaimana Dimaksud pada Huruf a Sampai Dengan Huruf c"),
	R_04010202020000 ("04010202020000", "Pembiayaan Investasi"),
	R_04010202020100 ("04010202020100", "a. Mudharabah"),
	R_04010202020200 ("04010202020200", "b. Musyarakah"),
	R_04010202020300 ("04010202020300", "c. Mudharabah Musytarakah"),
	R_04010202020400 ("04010202020400", "d. Musyarakah Mutanaqishoh"),
	R_04010202020500 ("04010202020500", "e. Akad Selain Akad Sebagaimana Dimaksud pada Huruf a Sampai Dengan Huruf d"),
	R_04010202030000 ("04010202030000", "Pembiayaan Jasa"),
	R_04010202030100 ("04010202030100", "a. Ijarah"),
	R_04010202030200 ("04010202030200", "b. Ijarah Muntahiyah Bittamlik"),
	R_04010202030300 ("04010202030300", "c. Hawalah atau Hawalah bil Ujrah"),
	R_04010202030400 ("04010202030400", "d. Wakalah atau Wakalah Bil Ujrah"),
	R_04010202030500 ("04010202030500", "e. Kafalah atau Kafalah bil Ujrah"),
	R_04010202030600 ("04010202030600", "f. Ju’alah"),
	R_04010202030700 ("04010202030700", "g. Qardh"),
	R_04010202030800 ("04010202030800", "h. Akad Selain Akad Sebagaimana Dimaksud pada Huruf a Sampai Dengan Huruf g"),
	R_04010202040000 ("04010202040000", "Total Saldo Piutang Pembiayaan Syariah (Outstanding Principal)"),
	;

	@Getter
	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER2751PosRePpu040102 eEnum : ER2751PosRePpu040102.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER2751PosRePpu040102.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER2751PosRePpu040102.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2|3", getObjects());
	}
	
	public static FieldValidation genValidationSum() {
		return UtilFieldValidation.genEqualsFormula("3-2", 2);
	}

	public static SegmentValidation genValidationPembiayaanJualBeliA() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010201010000.key,
				UtilMetadata.genPlusRow(getObjects(), 1, 4),
				"Total Pembiayaan Jual Beli|Penjumlahan Pembiayaan Jual Beli");
	}

	public static SegmentValidation genValidationPembiayaanInvestasiA() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010201020000.key,
				UtilMetadata.genPlusRow(getObjects(), 6, 10),
				"Total Pembiayaan Investasi|Penjumlahan Pembiayaan Investasi");
	}

	public static SegmentValidation genValidationPembiayaanJasaA() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010201030000.key,
				UtilMetadata.genPlusRow(getObjects(), 12, 19),
				"Total Pembiayaan Jasa|Penjumlahan Pembiayaan Jasa");
	}

	public static SegmentValidation genValidationTotalRencanaPenyaluranPembiayaanBaruA() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010201040000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 0, 5, 11 }),
				"Total Rencana Penyaluran Pembiayaan Syariah Baru|Penjumlahan Rencana Penyaluran Pembiayaan Syariah Baru");
	}

	public static SegmentValidation genValidationPembiayaanJualBeliB() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010202010000.key,
				UtilMetadata.genPlusRow(getObjects(), 22, 25),
				"Total Pembiayaan Jual Beli|Penjumlahan Pembiayaan Jual Beli");
	}

	public static SegmentValidation genValidationPembiayaanInvestasiB() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010202020000.key,
				UtilMetadata.genPlusRow(getObjects(), 27, 31),
				"Total Pembiayaan Investasi|Penjumlahan Pembiayaan Investasi");
	}

	public static SegmentValidation genValidationPembiayaanJasaB() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010202030000.key,
				UtilMetadata.genPlusRow(getObjects(), 33, 40),
				"Total Pembiayaan Jasa|Penjumlahan Pembiayaan Jasa");
	}

	public static SegmentValidation genValidationTotalSaldoPiutangPembiayaanB() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_04010202040000.key,
				UtilMetadata.genPlusRow(getObjects(), new int[] { 21, 26, 32 }),
				"Total Saldo Piutang Pembiayaan Syariah|Penjumlahan Saldo Piutang Pembiayaan Syariah");
	}
}
