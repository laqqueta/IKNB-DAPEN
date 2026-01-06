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
public enum ER5008PosLbLpeig1110 implements IObject<KeyValueString> {
	//	R_11100100000000 ("11100100000000","Tagihan Komitmen"),
	R_11100101000000 ("11100101000000","Fasilitas Pinjaman yang Diterima dan Belum Digunakan"),
	R_11100102000000 ("11100102000000","Posisi Pembelian Spot dan Derivatif yang Masih Berjalan"),
	R_11100103000000 ("11100103000000","Lainnya"),
	R_11100200000000 ("11100200000000","Jumlah Tagihan Komitmen"),
	//	R_11100300000000 ("11100300000000","Kewajiban Komitmen"),
	R_11100301000000 ("11100301000000","Fasilitas Pembiayaan yang Belum Ditarik"),
	R_11100302000000 ("11100302000000","Irrecovable L/C yang Masih Berjalan"),
	R_11100303000000 ("11100303000000","Posisi Penjualan Spot dan Derivatif yang Masih Berjalan"),
	R_11100304000000 ("11100304000000","Lainnya"),
	R_11100400000000 ("11100400000000","Jumlah Kewajiban Komitmen"),
	R_11100500000000 ("11100500000000","Jumlah Komitmen Bersih"),
	//	R_11100600000000 ("11100600000000","Tagihan Kontinjensi"),
	R_11100601000000 ("11100601000000","Penjaminan yang Diterima"),
	R_11100602000000 ("11100602000000","Pendapatan Bunga, Bagi Hasil, Margin, serta Ujrah dalam Penyelesaian"),
	R_11100602010000 ("11100602010000","Bunga atas Pembiayaan yang Diberikan"),
	R_11100602020000 ("11100602020000","Lainnya"),
	R_11100603000000 ("11100603000000","Lainnya"),
	R_11100700000000 ("11100700000000","Jumlah Tagihan Kontinjensi"),
	//	R_11100800000000 ("11100800000000","Kewajiban Kontinjensi"),
	R_11100801000000 ("11100801000000","Asuransi yang Diberikan"),
	R_11100802000000 ("11100802000000","Penjaminan yang Diberikan"),
	R_11100803000000 ("11100803000000","Lainnya"),
	R_11100900000000 ("11100900000000","Jumlah Kewajiban Kontinjensi"),
	R_11101000000000 ("11101000000000","Jumlah Kontinjensi Bersih"),
	//	R_11101100000000 ("11101100000000","Lainnya"),
	R_11101101000000 ("11101101000000","Aset Produktif yang Dihapus Buku"),
	R_11101101010000 ("11101101010000","Aset Produktif"),
	R_11101101010100 ("11101101010100","Pembiayaan yang Diberikan"),
	R_11101101010200 ("11101101010200","Lainnya"),
	R_11101101020000 ("11101101020000","Aset Produktif Dihapus Buku yang Dipulihkan atau Berhasil Ditagih"),
	R_11101101020100 ("11101101020100","Pembiayaan yang Diberikan"),
	R_11101101020200 ("11101101020200","Lainnya"),
	R_11101102000000 ("11101102000000","Aset Produktif yang Dihapus Tagih"),
	R_11101102010000 ("11101102010000","Pembiayaan yang Diberikan"),
	R_11101102020000 ("11101102020000","Lainnya"),
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
		for (ER5008PosLbLpeig1110 eEnum : ER5008PosLbLpeig1110.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5008PosLbLpeig1110.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5008PosLbLpeig1110.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String getUniquePos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 4), getObjects());
	}

	public static FieldValidation genFieldValidation04() {
		return UtilFieldValidation.genEqualsPosFormula("2+3", UtilMetadata.genPipeRow(getObjects()));
	}

	public static SegmentValidation genRowValidation05() {
		int[] fields = new int[] {0, 1, 2};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100200000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11100200000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation10() {
		int[] fields = new int[] {4, 5, 6, 7};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100400000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11100400000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation11() {
		int[] fields = new int[] {3, 8};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100500000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11100500000000.value, "", UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation13() {
		int[] fields = new int[] {12, 13};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100602000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11100602000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation17() {
		int[] fields = new int[] {10, 11, 14};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100700000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11100700000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation21() {
		int[] fields = new int[] {16, 17, 18};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11100900000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11100900000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation22() {
		int[] fields = new int[] {15, 19};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11101000000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11101000000000.value, "", UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation23() {
		int[] fields = new int[] {22, 25};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11101101000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11101101000000.value, "", UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation24() {
		int[] fields = new int[] {23, 24};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11101101010000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11101101010000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation27() {
		int[] fields = new int[] {26, 27};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11101101020000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11101101020000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation30() {
		int[] fields = new int[] {29, 30};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11101102000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11101102000000.value, "", UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
}
