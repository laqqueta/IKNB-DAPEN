package id.go.ojk.pnmk.client.builder.field.lb.uus.reference;

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
public enum ER3105PosLbPnmu1300 implements IObject<KeyValueString> {
	R_1300010000 ("1300010000", "Arus Kas dari Aktivitas Operasional"),
	R_1300010100 ("1300010100", "Kas Masuk"),
	R_1300010101 ("1300010101", "Penerimaan dari Pendapatan Margin Murabahah"),
	R_1300010102 ("1300010102", "Penerimaan dari Pendapatan Bagi Hasil Mudharabah"),
	R_1300010103 ("1300010103", "Penerimaan dari Pendapatan Bagi Hasil Musyarakah"),
	R_1300010104 ("1300010104", "Penerimaan Ujrah "),
	R_1300010105 ("1300010105", "Pengembalian Penyaluran Pembiayaan Murabahah"),
	R_1300010106 ("1300010106", "Pengembalian Pembiayaan Musyarakah"),
	R_1300010107 ("1300010107", "Pembayaran Pokok Ijarah "),
	R_1300010108 ("1300010108", "Penerimaan Lain-lain "),
	R_1300010200 ("1300010200", "Kas Keluar"),
	R_1300010201 ("1300010201", "Penyaluran pembiayaan Murabahah "),
	R_1300010202 ("1300010202", "Penyaluran Pembiayaan Mudharabah "),
	R_1300010203 ("1300010203", "Penyaluran Pembiayaan Musyarakah "),
	R_1300010204 ("1300010204", "Pembayaran Jasa Ijarah/Pembelian Aset Ijarah"),
	R_1300010205 ("1300010205", "Penyaluran Kegiatan Usaha dengan Akad Lain"),
	R_1300010206 ("1300010206", "Pembayaran Bagi Hasil Pendanaan dan Pembayaran Kepada Pihak Ketiga "),
	R_1300010207 ("1300010207", "Pembayaran Pajak "),
	R_1300010208 ("1300010208", "Pembayaran Gaji dan Tunjangan Pegawai "),
	R_1300010209 ("1300010209", "Pembayaran Lain-lain "),
	R_1300010300 ("1300010300", "Kas Neto dari dan untuk Aktivitas Operasional"),
	R_1300020000 ("1300020000", "Arus Kas dari Aktivitas Investasi"),
	R_1300020100 ("1300020100", "Kas Masuk"),
	R_1300020101 ("1300020101", "Penerimaan Imbal Hasil Deposito "),
	R_1300020102 ("1300020102", "Penerimaan Imbal Hasil Investasi Surat Berharga Syariah"),
	R_1300020103 ("1300020103", "Penerimaan Dividen "),
	R_1300020104 ("1300020104", "Penjualan Efek Syariah dan Surat Berharga Syariah Lainnya"),
	R_1300020105 ("1300020105", "Penjualan Aset Tetap "),
	R_1300020106 ("1300020106", "Divestasi pada Entitas Asosiasi "),
	R_1300020107 ("1300020107", "Penjualan Aset Lain-lain "),
	R_1300020200 ("1300020200", "Kas Keluar"),
	R_1300020201 ("1300020201", "Penempatan Deposito "),
	R_1300020202 ("1300020202", "Pembelian Efek Syariah "),
	R_1300020203 ("1300020203", "Pembelian Aset Tetap "),
	R_1300020204 ("1300020204", "Investasi pada Entitas Asosiasi "),
	R_1300020205 ("1300020205", "Pembelian Aset Lain-lain "),
	R_1300020300 ("1300020300", "Kas Neto dari dan untuk Aktivitas Investasi"),
	R_1300030000 ("1300030000", "Arus Kas dari Aktivitas Pendanaan"),
	R_1300030100 ("1300030100", "Kas Masuk"),
	R_1300030101 ("1300030101", "Penerimaan Setoran Modal Kerja "),
	R_1300030102 ("1300030102", "Penerimaan Pendanaan dari Pemerintah Republik Indonesia "),
	R_1300030103 ("1300030103", "Penerimaan Pendanaan dari Luar Negeri"),
	R_1300030104 ("1300030104", "Penerimaan Dana dari Bank Syariah "),
	R_1300030105 ("1300030105", "Penerimaan Dana dari Lembaga Jasa Keuangan Nonbank Syariah "),
	R_1300030106 ("1300030106", "Penerimaan Pendanaan dari Penerbitan Sukuk "),
	R_1300030107 ("1300030107", "Penerimaan Dana dari Medium Term Notes (MTN) Syariah"),
	R_1300030108 ("1300030108", "Penerimaan Dana dari Program Kemitraan Bina Lingkungan (PKBL)"),
	R_1300030109 ("1300030109", "Penerimaan Hibah "),
	R_1300030110 ("1300030110", "Penerimaan dari Aktivitas Pendanaan Syariah Lainnya"),
	R_1300030200 ("1300030200", "Kas Keluar"),
	R_1300030201 ("1300030201", "Pembayaran Pengembalian Pendanaan Pemerintah Republik Indonesia "),
	R_1300030202 ("1300030202", "Pengembalian Pendanaan dari Luar Negeri"),
	R_1300030203 ("1300030203", "Pembayaran Pengembalian Pendanaan Bank Syariah "),
	R_1300030204 ("1300030204", "Pembayaran Pengembalian Pendanaan Lembaga Jasa Keuangan Nonbank Syariah "),
	R_1300030205 ("1300030205", "Pembayaran Pengembalian Pokok Surat Berharga Syariah "),
	R_1300030206 ("1300030206", "Pembayaran Medium Term Notes (MTN) Syariah"),
	R_1300030207 ("1300030207", "Pembayaran Biaya Emisi Sukuk "),
	R_1300030208 ("1300030208", "Pembayaran untuk Aktivitas Pendanaan Syariah Lainnya"),
	R_1300030300 ("1300030300", "Kas Neto dari dan untuk Aktivitas Pendanaan"),
	R_1300040000 ("1300040000", "Kenaikan (Penurunan) Bersih Kas dan Setara Kas"),
	R_1300050000 ("1300050000", "Kas dan Setara Kas pada Awal Periode"),
	R_1300060000 ("1300060000", "Kas dan Setara Kas pada Akhir Periode"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3105PosLbPnmu1300 eEnum : ER3105PosLbPnmu1300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static String getName() {
		return ER3105PosLbPnmu1300.class.getSimpleName().substring(6);
	}

	public static int getRefNumber() {
		return Integer.parseInt(ER3105PosLbPnmu1300.class.getSimpleName().substring(2, 6));
	}

	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}

	public static String genFieldSave() {
		return UtilMetadata.genFieldSave("2", getObjects());
	}
	
	public static ConditionalRequired genConditional() {
		return UtilFieldConditional.genExistPos("N", "M", UtilMetadata.genPipeRow(getObjects(), new int[] { 0, 21, 37 }));
	}
	
	public static SegmentValidation genRowValidation02() {
		int[] fields = new int[] { 1, 10, 20 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300010000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300010000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation03() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1300010100.key, UtilMetadata.genPlusRow(getObjects(), 2, 9), 
				UtilMetadata.genMessage(R_1300010100.value, UtilMetadata.genPlusDesc(getObjects(), 2, 9)));
	}
	
	public static SegmentValidation genRowValidation12() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1300010200.key, UtilMetadata.genPlusRow(getObjects(), 11, 19), 
				UtilMetadata.genMessage(R_1300010200.value, UtilMetadata.genPlusDesc(getObjects(), 11, 19)));
	}
	
	public static SegmentValidation genRowValidation22() {
		int[] fields = new int[] { 1, 10 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300010300.key, UtilMetadata.genMinusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300010300.value, UtilMetadata.genMinusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation23() {
		int[] fields = new int[] { 22, 30, 36 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300020000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300020000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation24() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1300020100.key, UtilMetadata.genPlusRow(getObjects(), 23, 29), 
				UtilMetadata.genMessage(R_1300020100.value, UtilMetadata.genPlusDesc(getObjects(), 23, 29)));
	}
	
	public static SegmentValidation genRowValidation32() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1300020200.key, UtilMetadata.genPlusRow(getObjects(), 31, 35), 
				UtilMetadata.genMessage(R_1300020200.value, UtilMetadata.genPlusDesc(getObjects(), 31, 35)));
	}
	
	public static SegmentValidation genRowValidation38() {
		int[] fields = new int[] { 22, 30 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300020300.key, UtilMetadata.genMinusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300020300.value, UtilMetadata.genMinusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation39() {
		int[] fields = new int[] { 38, 49, 58 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300030000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300030000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation40() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1300030100.key, UtilMetadata.genPlusRow(getObjects(), 39, 48), 
				UtilMetadata.genMessage(R_1300030100.value, UtilMetadata.genPlusDesc(getObjects(), 39, 48)));
	}
	
	public static SegmentValidation genRowValidation51() {
		return UtilSegmentValidation.genEqualsFormula("2", R_1300030200.key, UtilMetadata.genPlusRow(getObjects(), 50, 57), 
				UtilMetadata.genMessage(R_1300030200.value, UtilMetadata.genPlusDesc(getObjects(), 50, 57)));
	}
	
	public static SegmentValidation genRowValidation60() {
		int[] fields = new int[] { 38, 49 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300030300.key, UtilMetadata.genMinusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300030300.value, UtilMetadata.genMinusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation61() {
		int[] fields = new int[] { 0, 21, 37 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300040000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300040000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation63() {
		int[] fields = new int[] { 59, 60 };
		return UtilSegmentValidation.genEqualsFormula("2", R_1300060000.key, UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_1300060000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
}
