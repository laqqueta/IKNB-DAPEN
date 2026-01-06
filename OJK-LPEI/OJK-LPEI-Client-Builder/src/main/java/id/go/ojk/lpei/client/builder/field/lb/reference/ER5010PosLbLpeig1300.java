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
public enum ER5010PosLbLpeig1300 implements IObject<KeyValueString> {
	//	R_13000100000000 ("13000100000000","Arus Kas Bersih dari Aktivitas Operasional"),
	R_13000101000000 ("13000101000000","Arus Kas Masuk dari Aktivitas Operasional"),
	R_13000101010000 ("13000101010000","Arus Kas Masuk dari Pendapatan Pembiayaan"),
	R_13000101010100 ("13000101010100","Konvensional"),
	R_13000101010200 ("13000101010200","Syariah"),
	R_13000101020000 ("13000101020000","Arus Kas Masuk dari Pendapatan Penjaminan"),
	R_13000101030000 ("13000101030000","Arus Kas Masuk dari Pendapatan Asuransi"),
	R_13000101040000 ("13000101040000","Arus Kas Masuk dari Pendapatan Kegiatan Operasional Lainnya"),
	R_13000102000000 ("13000102000000","Arus Kas Keluar untuk Aktivitas Operasi"),
	R_13000102010000 ("13000102010000","Arus Kas Keluar untuk Pemberian Pembiayaan"),
	R_13000102010100 ("13000102010100","Konvensional"),
	R_13000102010200 ("13000102010200","Syariah"),
	R_13000102020000 ("13000102020000","Arus Kas Keluar untuk Pembayaran Penjaminan"),
	R_13000102030000 ("13000102030000","Arus Kas Keluar untuk Pembayaran Asuransi"),
	R_13000102040000 ("13000102040000","Arus Kas Keluar untuk Pembayaran Bunga/Bagi Hasil/Margin/Ujrah Operasional"),
	R_13000102050000 ("13000102050000","Arus Kas Keluar untuk Pembayaran Beban Umum dan Administrasi"),
	R_13000102060000 ("13000102060000","Arus Kas Keluar untuk Pembayaran Pajak Penghasilan"),
	R_13000102070000 ("13000102070000","Arus Kas Keluar untuk Pembayaran Kegiatan Operasional Lainnya"),
	R_13000103000000 ("13000103000000","Kas Neto dari/untuk Aktivitas Operasional"),
	//	R_13000200000000 ("13000200000000","Arus Kas Bersih dari Aktivitas Investasi"),
	R_13000201000000 ("13000201000000","Arus Kas Masuk dari Aktivitas Investasi"),
	R_13000201010000 ("13000201010000","Arus Kas Masuk dari Pelepasan Penyertaan Modal"),
	R_13000201020000 ("13000201020000","Arus Kas Masuk dari Penjualan Tanah, Bangunan, dan Peralatan"),
	R_13000201030000 ("13000201030000","Arus Kas Masuk dari Penjualan Aset Takberwujud"),
	R_13000201040000 ("13000201040000","Arus Kas Masuk dari Penerimaan dari Surat Berharga yang Jatuh Tempo"),
	R_13000201050000 ("13000201050000","Arus Kas Masuk dari Penjualan Surat Berharga"),
	R_13000201060000 ("13000201060000","Arus Kas Masuk dari Dividen"),
	R_13000201070000 ("13000201070000","Arus Kas Masuk dari Penerimaan Bunga/Bagi Hasil/Margin/Ujrah/Imbal Hasil Kegiatan Investasi"),
	R_13000201080000 ("13000201080000","Arus Kas Masuk dari Aktivitas Investasi Lainnya"),
	R_13000202000000 ("13000202000000","Arus Kas Keluar untuk Aktivitas Investasi"),
	R_13000202010000 ("13000202010000","Arus Kas Keluar untuk Perolehan Surat Berharga"),
	R_13000202020000 ("13000202020000","Arus Kas Keluar untuk Penyertaan Modal"),
	R_13000202030000 ("13000202030000","Arus Kas Keluar untuk Perolehan Aset Tetap berupa Tanah, Bangunan, dan Peralatan"),
	R_13000202040000 ("13000202040000","Arus Kas Keluar untuk Pembelian Aset Takberwujud"),
	R_13000202050000 ("13000202050000","Arus Kas Keluar untuk Aktivitas Investasi Lainnya"),
	R_13000203000000 ("13000203000000","Kas Neto dari/untuk Aktivitas Investasi"),
	//	R_13000300000000 ("13000300000000","Arus Kas Bersih dari Aktivitas Pendanaan"),
	R_13000301000000 ("13000301000000","Arus Kas Masuk dari Aktivitas Pendanaan"),
	R_13000301010000 ("13000301010000","Arus Kas Masuk dari Setoran Modal Pemerintah"),
	R_13000301020000 ("13000301020000","Arus Kas Masuk dari Pinjaman yang Diterima"),
	R_13000301030000 ("13000301030000","Arus Kas Masuk dari Penerbitan Surat Berharga"),
	R_13000301040000 ("13000301040000","Arus Kas Masuk dari Pendanaan yang Diterima Berdasarkan Prinsip Syariah"),
	R_13000301050000 ("13000301050000","Arus Kas Masuk dari Aktivitas Pendanaan Lainnya"),
	R_13000302000000 ("13000302000000","Arus Kas Keluar untuk Aktivitas Pendanaan"),
	R_13000302010000 ("13000302010000","Arus Kas Keluar untuk Pembayaran ke Pemerintah sebagai Penerimaan Bukan Pajak"),
	R_13000302020000 ("13000302020000","Arus Kas Keluar untuk Pembayaran Pokok Pinjaman"),
	R_13000302030000 ("13000302030000","Arus Kas Keluar untuk Penerbitan Surat Berharga"),
	R_13000302040000 ("13000302040000","Arus Kas Keluar untuk Pendanaan Berdasarkan Prinsip Syariah"),
	R_13000302050000 ("13000302050000","Arus Kas Keluar untuk Aktivitas Pendanaan Lainnya"),
	R_13000303000000 ("13000303000000","Kas Neto dari/untuk Aktivitas Pendanaan"),
	R_13000400000000 ("13000400000000","Surplus (Defisit) pada Kas dan Setara Kas Akibat Perubahan Kurs"),
	R_13000500000000 ("13000500000000","Kenaikan (Penurunan) Bersih Kas dan Setara Kas"),
	R_13000600000000 ("13000600000000","Kas dan Setara Kas pada Awal Periode"),
	R_13000700000000 ("13000700000000","Kas dan Setara Kas pada Akhir Periode"),
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
		for (ER5010PosLbLpeig1300 eEnum : ER5010PosLbLpeig1300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER5010PosLbLpeig1300.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER5010PosLbLpeig1300.class.getSimpleName().substring(2, 6));
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

	public static SegmentValidation genRowValidation00() {
		int[] rows = new int[] {1, 4, 5, 6};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000101000000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_13000101000000.value, "", UtilMetadata.genPlusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation01() {
		int[] rows = new int[] {2, 3};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000101010000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_13000101010000.value, "", UtilMetadata.genPlusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation07() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000102000000.key,
				UtilMetadata.genPlusRowExcept(getObjects(), 8, 16, new int[] {9, 10}),
				UtilMetadata.genMessage(R_13000102000000.value, "", UtilMetadata.genPlusDescExcept(getObjects(), 8, 16, new int[] {9, 10})));
	}

	public static SegmentValidation genRowValidation08() {
		int[] rows = new int[] {9, 10};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000102010000.key,
				UtilMetadata.genPlusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_13000102010000.value, "", UtilMetadata.genPlusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation17() {
		int[] rows = new int[] {0, 7};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000103000000.key,
				UtilMetadata.genMinusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_13000103000000.value, "", UtilMetadata.genMinusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation18() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000201000000.key,
				UtilMetadata.genPlusRow(getObjects(), 19, 26),
				UtilMetadata.genMessage(R_13000201000000.value, "", UtilMetadata.genPlusDesc(getObjects(), 19, 26)));
	}

	public static SegmentValidation genRowValidation27() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000202000000.key,
				UtilMetadata.genPlusRow(getObjects(), 28, 32),
				UtilMetadata.genMessage(R_13000202000000.value, "", UtilMetadata.genPlusDesc(getObjects(), 28, 32)));
	}

	public static SegmentValidation genRowValidation33() {
		int[] rows = new int[] {18, 27};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000203000000.key,
				UtilMetadata.genMinusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_13000203000000.value, "", UtilMetadata.genMinusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation34() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000301000000.key,
				UtilMetadata.genPlusRow(getObjects(), 35, 39),
				UtilMetadata.genMessage(R_13000301000000.value, "", UtilMetadata.genPlusDesc(getObjects(), 35, 39)));
	}

	public static SegmentValidation genRowValidation40() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000302000000.key,
				UtilMetadata.genPlusRow(getObjects(), 41, 45),
				UtilMetadata.genMessage(R_13000302000000.value, "", UtilMetadata.genPlusDesc(getObjects(), 41, 45)));
	}

	public static SegmentValidation genRowValidation46() {
		int[] rows = new int[] {34, 40};
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000303000000.key,
				UtilMetadata.genMinusRow(getObjects(), rows),
				UtilMetadata.genMessage(R_13000303000000.value, "", UtilMetadata.genMinusDesc(getObjects(), rows)));
	}

	public static SegmentValidation genRowValidation52A() {
		String selectPosCode = "110011000101000000+110011000102000000+110011000103000000+110011000104000000";
		String customErrorMsg = R_13000700000000.value + "| 1. Kas + 2. Emas dan Commemorative Coins + 3. Penempatan pada Bank Indonesia dalam Bentuk Simpanan + 4. Penempatan pada Bank dalam Bentuk Simpanan kolom 'Rp' pada form 1100";
		return UtilSegmentValidation.genEqualsFormulaForm("2", R_13000700000000.key, "2",
				selectPosCode, customErrorMsg);
	}

	public static SegmentValidation genRowValidation52B() {
		String selectPosCode = "110011000101000000+110011000102000000+110011000103000000+110011000104000000";
		String customErrorMsg = R_13000700000000.value + "| 1. Kas + 2. Emas dan Commemorative Coins + 3. Penempatan pada Bank Indonesia dalam Bentuk Simpanan + 4. Penempatan pada Bank dalam Bentuk Simpanan kolom 'Valas' pada form 1100";
		return UtilSegmentValidation.genEqualsFormulaForm("3", R_13000700000000.key, "3",
				selectPosCode, customErrorMsg);
	}

	public static SegmentValidation genRowValidation52C() {
		String selectPosCode = "110011000101000000+110011000102000000+110011000103000000+110011000104000000";
		String customErrorMsg = R_13000700000000.value + "| 1. Kas + 2. Emas dan Commemorative Coins + 3. Penempatan pada Bank Indonesia dalam Bentuk Simpanan + 4. Penempatan pada Bank dalam Bentuk Simpanan kolom 'Jumlah' pada form 1100";
		return UtilSegmentValidation.genEqualsFormulaForm("4", R_13000700000000.key, "4",
				selectPosCode, customErrorMsg);
	}
}