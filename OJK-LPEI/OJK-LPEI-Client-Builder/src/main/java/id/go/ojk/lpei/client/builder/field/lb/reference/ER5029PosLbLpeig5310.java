package id.go.ojk.lpei.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER5029PosLbLpeig5310 implements IObject<KeyValueString> {
	R_531001000000 ("531001000000","ASET"),
	R_531001010000 ("531001010000","Pembiayaan"),
	R_531001010100 ("531001010100","Investasi"),
	R_531001010200 ("531001010200","Modal Kerja"),
	R_531001010300 ("531001010300","Lainnya"),
	R_531001010400 ("531001010400","CKPN - Pembiayaan -/-"),
	R_531001020000 ("531001020000","Pembiayaan berdasarkan Prinsip Syariah"),
	R_531001020100 ("531001020100","CKPN - Pembiayaan berdasarkan Prinsip Syariah -/-"),
	R_531001030000 ("531001030000","Aset Non Pembiayaan"),
	R_531002000000 ("531002000000","LIABILITAS"),
	R_531002010000 ("531002010000","Pendanaan yang Diterima"),
	R_531002020000 ("531002020000","Surat Berharga yang Diterbitkan"),
	R_531002030000 ("531002030000","Liabilitas Selain Pendanaan dan Surat Berharga yang Diterbitkan"),
	R_531003000000 ("531003000000","RASIO ASET TERHADAP LIABILITAS"),
	R_531004000000 ("531004000000","Rasio Aset Lancar Terhadap Aset Tidak lancar"),
	R_531005000000 ("531005000000","Rasio Liabilitas Lancar Terhadap Liabilitas Tidak lancar"),
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
		for (ER5029PosLbLpeig5310 eEnum : ER5029PosLbLpeig5310.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5029PosLbLpeig5310.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5029PosLbLpeig5310.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String getUniquePos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 12), getObjects());
	}

	public static FieldValidation genFieldValidation6() {
		return UtilFieldValidation.genEqualsPosFormula("2+3+4+5", 2, UtilMetadata.genPipeRow(getObjects()));
	}

	public static FieldValidation genFieldValidation11() {
		return UtilFieldValidation.genEqualsPosFormula("7+8+9+10", 2, UtilMetadata.genPipeRow(getObjects()));
	}

	public static FieldValidation genFieldValidation12() {
		return UtilFieldValidation.genEqualsPosFormula("6+11", 2, UtilMetadata.genPipeRow(getObjects()));
	}

	public static ConditionalRequired genConditionalExist() {
		return UtilFieldConditional.genExistPos("N", "M",UtilMetadata.genPipeRow(ER5029PosLbLpeig5310.getObjects(), new int[] { 13, 14, 15 }));
	}

	public static SegmentValidation genRowValidation02() {
		int[] minusFields1 = new int[] { 1, 5 };
		int[] minusFields2 = new int[] { 6, 7 };
		int[] plusFields = new int[] { 8 };

		String plusMinusRow = UtilMetadata.genMinusRow(getObjects(), minusFields1) + "+"
				+ UtilMetadata.genMinusRow(getObjects(), minusFields2) + "+"
				+ UtilMetadata.genPlusRow(getObjects(), plusFields);

		String plusMinusDesc = UtilMetadata.genMinusDesc(getObjects(), minusFields1) + "+"
				+ UtilMetadata.genMinusDesc(getObjects(), minusFields2) + "+"
				+ UtilMetadata.genPlusDesc(getObjects(), plusFields);

		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 5, 7, 8, 9, 10 }),
				R_531001000000.key, plusMinusRow, UtilMetadata.genMessage(R_531001000000.value, "", plusMinusDesc));
	}

	public static SegmentValidation genRowValidation03() {
		int[] fields = new int[] { 2, 3, 4 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 5, 7, 8, 9, 10 }),
				R_531001010000.key, UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_531001010000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation09() {
		int[] fields = new int[] { 10, 11, 12 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(new int[] { 2, 3, 4, 5, 7, 8, 9, 10 }),
				R_531002000000.key, UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_531002000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
}