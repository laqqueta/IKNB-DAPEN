package id.go.ojk.pnmk.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldConditional;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3005PosLbPnmk1300 implements IObject<KeyValueString> {
	R_1300010000("1300010000", "Arus Kas dari Aktivitas Operasional"), 
	R_1300010100("1300010100", "Kas Masuk"),
	R_1300010101("1300010101", "Penerimaan dari Pendapatan Bunga ULaMM"),
	R_1300010102("1300010102", "Penerimaan dari Pendapatan Bunga Mekaar"),
	R_1300010103("1300010103", "Pengembalian Penyaluran Pinjaman ULaMM"),
	R_1300010104("1300010104", "Pengembalian Penyaluran Pinjaman Mekaar"),
	R_1300010105("1300010105", "Penerimaan Jasa Konsultasi Manajemen"),
	R_1300010106("1300010106", "Penerimaan dari Aktivitas Operasional Lain"), 
	R_1300010200("1300010200", "Kas Keluar"),
	R_1300010201("1300010201", "Penyaluran Pinjaman ULaMM"), 
	R_1300010202("1300010202", "Penyaluran Pinjaman Mekaar"),
	R_1300010203("1300010203", "Pembayaran Bunga Pinjaman dan Pembayaran Kepada Pihak Ketiga"),
	R_1300010204("1300010204", "Pembayaran Pajak"), 
	R_1300010205("1300010205", "Pembayaran Gaji dan Tunjangan Pegawai"),
	R_1300010206("1300010206", "Pembayaran untuk Aktivitas Operasional Lain"),
	R_1300010300("1300010300", "Kas Neto dari dan untuk Operasional Lain"),
	R_1300020000("1300020000", "Arus Kas dari Aktivitas Investasi"), 
	R_1300020100("1300020100", "Kas Masuk"),
	R_1300020101("1300020101", "Penerimaan Bunga Simpanan"),
	R_1300020102("1300020102", "Penerimaan Bunga Obligasi dan Surat Berharga Lainnya"),
	R_1300020103("1300020103", "Penerimaan Deviden"),
	R_1300020104("1300020104", "Penjualan Efek dan Surat Berharga Lainnya"),
	R_1300020105("1300020105", "Penjualan Asset Tetap"), 
	R_1300020106("1300020106", "Divestasi pada Entitas Asosiasi"),
	R_1300020107("1300020107", "Penerimaan dari Aktivitas Investasi Lain"), 
	R_1300020200("1300020200", "Kas Keluar"),
	R_1300020201("1300020201", "Penempatan Deposito"), 
	R_1300020202("1300020202", "Pembelian Surat Berharga"),
	R_1300020203("1300020203", "Pembelian Asset Tetap"), 
	R_1300020204("1300020204", "Investasi pada Entitas Asosiasi"),
	R_1300020205("1300020205", "Pengeluaran untuk Aktivitas Investasi Lain"),
	R_1300020300("1300020300", "Kas Neto dari dan untuk Aktivitas Investasi"),
	R_1300030000("1300030000", "Arus Kas dari Aktivitas Pendanaan"), 
	R_1300030100("1300030100", "Kas Masuk"),
	R_1300030101("1300030101", "Penerimaan Setoran Modal"),
	R_1300030102("1300030102", "Penerimaan Pinjaman dari Pemerintah Republik Indonesia"),
	R_1300030103("1300030103", "Penerimaan Pinjaman dari Luar Negeri"),
	R_1300030104("1300030104", "Penerimaan Dana dari Bank"),
	R_1300030105("1300030105", "Penerimaan Dana dari Jasa Keuangan Nonbank"),
	R_1300030106("1300030106", "Penerimaan Dana dari Obligasi"),
	R_1300030107("1300030107", "Penerimaan Dana dari Medium Term Notes (MTN)"),
	R_1300030108("1300030108", "Penerimaan Dana dari Program Kemitraan Bina Lingkungan (PKBL)"),
	R_1300030109("1300030109", "Penerimaan Hibah"),
	R_1300030110("1300030110", "Penerimaan dari Aktivitas Pendanaan Lainnya"), 
	R_1300030200("1300030200", "Kas Keluar"),
	R_1300030201("1300030201", "Pembayaran Pengembalian Pinjaman Pemerintah Republik Indonesia"),
	R_1300030202("1300030202", "Pembayaran Pinjaman dari Luar Negeri"),
	R_1300030203("1300030203", "Pembayaran Pengembalian Pinjaman Bank"),
	R_1300030204("1300030204", "Pembayaran Pengembalian Pinjaman Jasa Keuangan Nonbank"),
	R_1300030205("1300030205", "Pembayaran Pokok Obligasi"),
	R_1300030206("1300030206", "Pembayaran Medium Term Notes (MTN)"),
	R_1300030207("1300030207", "Pembayaran Biaya Emisi Obligasi"),
	R_1300030208("1300030208", "Pengeluaran untuk Aktivitas Pendanaan"),
	R_1300030300("1300030300", "Kas Neto dari dan untuk Aktivitas Pendanaan"),
	R_1300040000("1300040000", "Kenaikan (Penurunan) Bersih Kas dan Setara Kas"),
	R_1300050000("1300050000", "Kas dan Setara Kas pada Awal Periode"),
	R_1300060000("1300060000", "Kas dan Setara Kas pada Akhir Periode"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3005PosLbPnmk1300 eEnum : ER3005PosLbPnmk1300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3005PosLbPnmk1300.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3005PosLbPnmk1300.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static ConditionalRequired genConditional() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 16, 32 }));
	}
	
	public static SegmentValidation genRowValidation02() {
		int[] fields = new int[] { 1, 8, 15 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300010000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300010000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation03() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1300010100.key, UtilMetadata.genPlusRow(getObjects(), 2, 7), 
				UtilMetadata.genMessage(R_1300010100.value, UtilMetadata.genPlusDesc(getObjects(), 2, 7)));
	}
	
	public static SegmentValidation genRowValidation10() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1300010200.key, UtilMetadata.genPlusRow(getObjects(), 9, 14), 
				UtilMetadata.genMessage(R_1300010200.value, UtilMetadata.genPlusDesc(getObjects(), 9, 14)));
	}
	
	public static SegmentValidation genRowValidation17() {
		int[] fields = new int[] { 1, 8 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300010300.key, UtilMetadata.genMinusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300010300.value, UtilMetadata.genMinusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation18() {
		int[] fields = new int[] { 17, 25, 31 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300020000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300020000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation19() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1300020100.key, UtilMetadata.genPlusRow(getObjects(), 18, 24), 
				UtilMetadata.genMessage(R_1300020100.value, UtilMetadata.genPlusDesc(getObjects(), 18, 24)));
	}
	
	public static SegmentValidation genRowValidation27() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1300020200.key, UtilMetadata.genPlusRow(getObjects(), 26, 30), 
				UtilMetadata.genMessage(R_1300020200.value, UtilMetadata.genPlusDesc(getObjects(), 26, 30)));
	}
	
	public static SegmentValidation genRowValidation33() {
		int[] fields = new int[] { 17, 25 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300020300.key, UtilMetadata.genMinusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300020300.value, UtilMetadata.genMinusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation34() {
		int[] fields = new int[] { 33, 44, 53 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300030000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300030000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation35() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1300030100.key, UtilMetadata.genPlusRow(getObjects(), 34, 43), 
				UtilMetadata.genMessage(R_1300030100.value, UtilMetadata.genPlusDesc(getObjects(), 34, 43)));
	}
	
	public static SegmentValidation genRowValidation46() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1300030200.key, UtilMetadata.genPlusRow(getObjects(), 45, 52), 
				UtilMetadata.genMessage(R_1300030200.value, UtilMetadata.genPlusDesc(getObjects(), 45, 52)));
	}
	
	public static SegmentValidation genRowValidation55() {
		int[] fields = new int[] { 33, 44 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300030300.key, UtilMetadata.genMinusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300030300.value, UtilMetadata.genMinusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation56() {
		int[] fields = new int[] { 0, 16, 32 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300040000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300040000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation58() {
		int[] fields = new int[] { 54, 55 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300060000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300060000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
}
