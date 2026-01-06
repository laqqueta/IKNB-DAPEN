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
public enum ER7006PosLbLpeiu1000 implements IObject<KeyValueString> {
	R_100001000000 ("100001000000","Aset Produktif"),
	R_100001010000 ("100001010000","Pembiayaan berdasarkan Prinsip Syariah"),
	R_100001010100 ("100001010100","Pembiayaan yang Diberikan"),
	R_100001010101 ("100001010101","Akad Murabahah"),
	R_100001010102 ("100001010102","Akad Musyarakah"),
	R_100001010103 ("100001010103","Akad Mudharabah"),
	R_100001010104 ("100001010104","Akad Mudharabah Musytarakah"),
	R_100001010105 ("100001010105","Akad Musyarakah Mutanaqisah"),
	R_100001010106 ("100001010106","Akad Qardh"),
	R_100001010107 ("100001010107","Akad Ijarah/IMBT"),
	R_100001010108 ("100001010108","Akad Lainnya"),
	R_100001010200 ("100001010200","Piutang Ijarah"),
	R_100001010300 ("100001010300","Lainnya"),
	R_100001020000 ("100001020000","Penempatan pada Bank Indonesia dalam Bentuk Simpanan"),
	R_100001030000 ("100001030000","Penempatan pada Bank dalam Bentuk Simpanan"),
	R_100001040000 ("100001040000","Surat Berharga Syariah yang Dimiliki"),
	R_100001050000 ("100001050000","Aset Ijarah"),
	R_100001050100 ("100001050100","Aset Ijarah Bruto"),
	R_100001050200 ("100001050200","Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_100001050300 ("100001050300","Akumulasi Penyusutan"),
	R_100001060000 ("100001060000","Tagihan Akseptasi"),
	R_100001070000 ("100001070000","Tagihan Derivatif"),
	R_100001080000 ("100001080000","Transaksi Rekening Administratif"),
	R_100002000000 ("100002000000","ASET NONPRODUKTIF"),
	R_100002010000 ("100002010000","Agunan yang Diambil Alih (AYDA)"),
	R_100002020000 ("100002020000","Rekening Antar Kantor dan Suspense Account"),
	R_100003000000 ("100003000000","JUMLAH"),
	// R_100004000000 ("100004000000", "PENYISIHAN PENILAIAN KUALITAS ASET (PPKA)"),
	R_100004010000 ("100004010000","PPKA Produktif yang Wajib Dibentuk"),
	R_100004020000 ("100004020000","PPKA Nonproduktif yang Wajib Dibentuk"),
	R_100004030000 ("100004030000","Total PPKA yang Wajib Dibentuk"),
	R_100004040000 ("100004040000","PPKA Produktif yang Telah Dibentuk"),
	R_100004050000 ("100004050000","PPKA Nonproduktif yang Telah Dibentuk"),
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
		for (ER7006PosLbLpeiu1000 eEnum : ER7006PosLbLpeiu1000.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER7006PosLbLpeiu1000.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER7006PosLbLpeiu1000.class.getSimpleName().substring(2, 6));
	}

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
		int[] fields = new int[] { 1, 13, 14, 15, 16, 20, 21, 22 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_100001000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_100001000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation03() {
		int[] fields = new int[] { 2, 11, 13 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_100001010000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_100001010000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation04() {
		int[] fields = new int[] { 3, 4, 5, 6, 7, 8, 9, 10 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_100001010100.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_100001010100.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation18() {
		int[] fields = new int[] { 17, 18, 19 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_100001050000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_100001050000.value, "", UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation25() {
		int[] fields = new int[] { 24, 25 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_100002000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_100002000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation28() {
		int[] fields = new int[] { 0, 23 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 6), R_100003000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_100003000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genValidationNumeric() {
		return UtilSegmentValidation.genRegexNumeric("2|3|4|5|6|7", UtilMetadata.genPipeRowExcept(getObjects(), new int[] {18, 33}));
	}
}
