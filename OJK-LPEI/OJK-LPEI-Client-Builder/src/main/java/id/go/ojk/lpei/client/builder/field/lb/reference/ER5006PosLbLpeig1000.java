package id.go.ojk.lpei.client.builder.field.lb.reference;

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
public enum ER5006PosLbLpeig1000 implements IObject<KeyValueString> {
	R_100001000000 ("100001000000","Aset Produktif"),
	R_100001010000 ("100001010000","Pembiayaan"),
	R_100001010100 ("100001010100","Investasi"),
	R_100001010200 ("100001010200","Modal Kerja"),
	R_100001010300 ("100001010300","Lainnya"),
	R_100001020000 ("100001020000","Pembiayaan berdasarkan Prinsip Syariah"),
	R_100001030000 ("100001030000","Penempatan pada Bank Indonesia dalam Bentuk Simpanan"),
	R_100001040000 ("100001040000","Penempatan pada Bank dalam Bentuk Simpanan"),
	R_100001050000 ("100001050000","Surat Berharga yang Dimiliki"),
	R_100001060000 ("100001060000","Penyertaan Modal"),
	R_100001060100 ("100001060100","Pada Badan Hukum atau Badan Lainnya"),
	R_100001060200 ("100001060200","Dalam Rangka Restrukturisasi Pembiayaan"),
	R_100001070000 ("100001070000","Tagihan Akseptasi"),
	R_100001080000 ("100001080000","Tagihan Derivatif"),
	R_100001090000 ("100001090000","Transaksi Rekening Administratif"),
	R_100002000000 ("100002000000","Aset Non Produktif"),
	R_100002010000 ("100002010000","Agunan yang Diambil Alih (AYDA)"),
	R_100002020000 ("100002020000","Rekening Antar Kantor dan Suspense Account"),
	R_100003000000 ("100003000000","Jumlah"),
	R_100004000000 ("100004000000","Penyisihan Penilaian Kualitas Aset (PPKA)"),
	R_100004010000 ("100004010000","PPKA Produktif yang Wajib Dibentuk"),
	R_100004020000 ("100004020000","PPKA NonProduktif yang Wajib Dibentuk"),
	R_100004030000 ("100004030000","Total PPKA yang Wajib Dibentuk"),
	R_100004040000 ("100004040000","PPKA Produktif yang Telah Dibentuk"),
	R_100004050000 ("100004050000","PPKA NonProduktif yang Telah Dibentuk"),
	R_100004060000 ("100004060000","Total PPKA yang Telah Dibentuk"),
	R_100004070000 ("100004070000","Kelebihan/(Kekurangan) PPKA"),
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
		for (ER5006PosLbLpeig1000 eEnum : ER5006PosLbLpeig1000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5006PosLbLpeig1000.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5006PosLbLpeig1000.class.getSimpleName().substring(2, 6));
	}

	/*
	 * Unique and required validation
	 */
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String getUniquePos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 7), getObjects());
	}

	public static FieldValidation genFieldValidation07() {
		return UtilFieldValidation.genEqualsPosFormula("2+3+4+5+6", UtilMetadata.genPipeRow(getObjects()));
	}

	public static SegmentValidation genRowValidation02() {
		int[] fields = new int[] {1, 5, 6, 7, 8, 9, 12, 13, 14};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_100001000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_100001000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation03() {
		int[] fields = new int[] {2, 3, 4};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_100001010000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_100001010000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation11() {
		int[] fields = new int[] {10, 11};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_100001060000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_100001060000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation17() {
		int[] fields = new int[] {16, 17};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_100002000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_100002000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation20() {
		int[] fields = new int[] {0, 15};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_100003000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_100003000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation21() {
		int[] fields = new int[] {20, 21, 22, 23, 24, 25, 26};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_100004000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_100004000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2|3|4|5|6|7", UtilMetadata.genPipeRow(getObjects(), 0, 25));
	}
}
