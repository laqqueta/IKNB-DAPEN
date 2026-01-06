package id.go.ojk.lpei.client.builder.field.lb.uus.reference;

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
public enum ER7029PosLbLpeiu5310 implements IObject<KeyValueString> {
	R_53100100000000 ("53100100000000","ASET"),
	R_53100101000000 ("53100101000000","Pembiayaan berdasarkan Prinsip Syariah"),
	R_53100101010000 ("53100101010000","Pembiayaan yang Diberikan"),
	R_53100101010100 ("53100101010100","Akad Musyarakah"),
	R_53100101010200 ("53100101010200","Akad Mudharabah"),
	R_53100101010300 ("53100101010300","Akad Mudharabah Musytarakah"),
	R_53100101010400 ("53100101010400","Akad Musyarakah Mutanaqisah"),
	R_53100101010500 ("53100101010500","Akad Qardh"),
	R_53100101010600 ("53100101010600","Akad Ijarah/IMBT"),
	R_53100101010700 ("53100101010700","Akad Lainnya"),
	R_53100101020000 ("53100101020000","Piutang Ijarah"),
	R_53100101030000 ("53100101030000","Lainnya"),
	R_53100101040000 ("53100101040000","PPKA - Pembiayaan Berdasarkan Prinsip Syariah -/-"),
	R_53100102000000 ("53100102000000","Aset Non Pembiayaan"),
	R_53100103000000 ("53100103000000","Aset Ijarah"),
	R_53100200000000 ("53100200000000","LIABILITAS"),
	R_53100201000000 ("53100201000000","Pendanaan yang Diterima"),
	R_53100202000000 ("53100202000000","Surat Berharga yang Diterbitkan"),
	R_53100203000000 ("53100203000000","Liabilitas Selain Pendanaan dan Surat Berharga yang Diterbitkan"),
	R_53100300000000 ("53100300000000","RASIO ASET TERHADAP LIABILITAS"),
	R_53100400000000 ("53100400000000","Rasio Aset Lancar Terhadap Aset Tidak lancar"),
	R_53100500000000 ("53100500000000","Rasio Liabilitas Lancar Terhadap Liabilitas Tidak lancar"),
	;

	@Getter
	private String key;
	private String value;

	@Override
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER7029PosLbLpeiu5310 eEnum : ER7029PosLbLpeiu5310.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER7029PosLbLpeiu5310.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER7029PosLbLpeiu5310.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String getUniquePos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 16), getObjects());
	}

	public static FieldValidation genFieldValidation6() {
		return UtilFieldValidation.genEqualsPosFormula("2+3+4+5", 2, UtilMetadata.genPipeRow(getObjects()));
	}

	public static FieldValidation genFieldValidation11() {
		return UtilFieldValidation.genEqualsPosFormula("7+8+9+10", 2, UtilMetadata.genPipeRow(getObjects()));
	}

	public static FieldValidation genFieldValidation12() {
		return UtilFieldValidation.genEqualsPosFormula("2+7", 2, UtilMetadata.genPipeRowExcept(getObjects(), new int[] {0, 1, 2, 15}));
	}

	public static FieldValidation genFieldValidation13() {
		return UtilFieldValidation.genEqualsPosFormula("3+8", 2, UtilMetadata.genPipeRowExcept(getObjects(), new int[] {0, 1, 2, 15}));
	}

	public static FieldValidation genFieldValidation14() {
		return UtilFieldValidation.genEqualsPosFormula("4+9", 2, UtilMetadata.genPipeRowExcept(getObjects(), new int[] {0, 1, 2, 15}));
	}

	public static FieldValidation genFieldValidation15() {
		return UtilFieldValidation.genEqualsPosFormula("5+10", 2, UtilMetadata.genPipeRowExcept(getObjects(), new int[] {0, 1, 2, 15}));
	}

	public static FieldValidation genFieldValidation16() {
		return UtilFieldValidation.genEqualsPosFormula("12+13+14+15", 2, UtilMetadata.genPipeRow(getObjects()));
	}

	public static SegmentValidation genRowValidation02() {
		int[] fields = new int[] { 1, 13, 14 };
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 5, 7, 8, 9, 10, 12, 13, 14, 15 }),
				R_53100100000000.key, UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_53100100000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation03() {
		int[] plusFields = new int[] { 2, 10, 11 };
		int[] minusFields = new int[] { 12 };

		String plusMinusRow = UtilMetadata.genPlusRow(getObjects(), plusFields) + "-"
				+ UtilMetadata.genMinusRow(getObjects(), minusFields);

		String plusMinusDesc = UtilMetadata.genPlusDesc(getObjects(), plusFields) + "-"
				+ UtilMetadata.genMinusDesc(getObjects(), minusFields);

		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 5, 7, 8, 9, 10, 12, 13, 14, 15 }),
				R_53100101000000.key, plusMinusRow, UtilMetadata.genMessage(R_53100101000000.value, "", plusMinusDesc));
	}

	public static SegmentValidation genRowValidation04() {
		int[] fields = new int[] { 3, 4, 5, 6, 7, 8, 9 };
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 5, 7, 8, 9, 10, 12, 13, 14, 15 }), R_53100101010000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_53100101010000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation17() {
		int[] fields = new int[] { 16, 17, 18 };
		return UtilSegmentValidation.genEqualsFormula(
				UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 5, 7, 8, 9, 10, 12, 13, 14, 15 }), R_53100200000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_53100200000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

//	public static SegmentValidation genRowValidation21A() {
//		return UtilSegmentValidation.genFixedValue("6", R_53100300000000.key, "100.00");
//	}
//
//	public static SegmentValidation genRowValidation21B() {
//		return UtilSegmentValidation.genFixedValue("11", R_53100300000000.key, "100.00");
//	}

	public static SegmentValidation genRowValidation22A() {
		return UtilSegmentValidation.genFixedValue("6", R_53100400000000.key, "100.00");
	}

	public static SegmentValidation genRowValidation22B() {
		return UtilSegmentValidation.genFixedValue("11", R_53100400000000.key, "100.00");
	}

	public static SegmentValidation genRowValidation23A() {
		return UtilSegmentValidation.genFixedValue("6", R_53100500000000.key, "100.00");
	}

	public static SegmentValidation genRowValidation23B() {
		return UtilSegmentValidation.genFixedValue("11", R_53100500000000.key, "100.00");
	}
}