 package id.go.ojk.ppik.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3012PosLbPpik1300 implements IObject<KeyValueString> {
	R_13000100000000 ("13000100000000", "Arus Kas Bersih dari Kegiatan Operasi"),
	R_13000101000000 ("13000101000000", "Arus Kas Masuk dari Kegiatan Operasi"),
	R_13000101010000 ("13000101010000", "Arus Kas Masuk dari Pemberian Pinjaman Langsung (Direct Lending) untuk Pembiayaan Infrastruktur"),
	R_13000101020000 ("13000101020000", "Arus Kas Masuk dari Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain"),
	R_13000101030000 ("13000101030000", "Arus Kas Masuk dari Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur"),
	R_13000101040000 ("13000101040000", "Arus Kas Masuk dari Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan"),
	R_13000101050000 ("13000101050000", "Arus Kas Masuk dari Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah"),
	R_13000101060000 ("13000101060000", "Arus Kas Masuk dari Kegiatan Pembiayaan yang Diberikan Berdasarkan Prinsip Syariah"),
	R_13000101070000 ("13000101070000", "Arus Kas Masuk dari Kegiatan Usaha Lain"),
	R_13000101070100 ("13000101070100", "Arus Kas Masuk dari Pemberian Dukungan Kredit/Pembiayaan"),
	R_13000101070200 ("13000101070200", "Arus Kas Masuk dari Pemberian Jasa Konsultasi"),
	R_13000101070300 ("13000101070300", "Arus Kas Masuk dari Upaya Mencarikan Pasar Swap yang Berkaitan dengan Pembiayaan Infrastruktur"),
	R_13000101080000 ("13000101080000", "Arus Kas Masuk dari Pendapatan Kegiatan Operasi Lainnya"),
	R_13000102000000 ("13000102000000", "Arus Kas Keluar untuk Kegiatan Operasi"),
	R_13000102010000 ("13000102010000", "Arus Kas Keluar untuk Pemberian Pinjaman Langsung (Direct Lending) untuk Pembiayaan Infrastruktur"),
	R_13000102020000 ("13000102020000", "Arus Kas Keluar untuk Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain"),
	R_13000102030000 ("13000102030000", "Arus Kas Keluar untuk Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur"),
	R_13000102040000 ("13000102040000", "Arus Kas Keluar untuk Kegiatan atau Pemberian Fasilitas pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan"),
	R_13000102050000 ("13000102050000", "Arus Kas Keluar untuk Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah"),
	R_13000102060000 ("13000102060000", "Arus Kas Keluar untuk Kegiatan Pembiayaan yang Diberikan Berdasarkan Prinsip Syariah"),
	R_13000102070000 ("13000102070000", "Arus Kas Keluar untuk Kegiatan Usaha Lain"),
	R_13000102070100 ("13000102070100", "Arus Kas Keluar untuk Pemberian Dukungan Kredit/Pembiayaan"),
	R_13000102070200 ("13000102070200", "Arus Kas Keluar untuk Pemberian Jasa Konsultasi"),
	R_13000102070300 ("13000102070300", "Arus Kas Keluar untuk Upaya Mencarikan Pasar Swap yang Berkaitan dengan Pembiayaan Infrastruktur"),
	R_13000102080000 ("13000102080000", "Arus Kas Keluar untuk Pembayaran Bunga/Ujrah/Imbal Hasil Operasional"),
	R_13000102090000 ("13000102090000", "Arus Kas Keluar untuk Pembayaran Beban Umum dan Administrasi"),
	R_13000102100000 ("13000102100000", "Arus Kas Keluar untuk Pembayaran Pajak Penghasilan"),
	R_13000102110000 ("13000102110000", "Arus Kas Keluar untuk Pembayaran Kegiatan Operasi Lainnya"),
	R_13000200000000 ("13000200000000", "Arus Kas bersih dari Kegiatan Investasi"),
	R_13000201000000 ("13000201000000", "Arus Kas Masuk dari Kegiatan Investasi"),
	R_13000201010000 ("13000201010000", "Arus Kas Masuk dari Pelepasan Penyertaan Modal"),
	R_13000201020000 ("13000201020000", "Arus Kas Masuk dari Penjualan Tanah, Bangunan, dan Peralatan"),
	R_13000201030000 ("13000201030000", "Arus Kas Masuk dari Penjualan Aset Tak Berwujud"),
	R_13000201040000 ("13000201040000", "Arus Kas Masuk dari Penjualan Surat Berharga"),
	R_13000201050000 ("13000201050000", "Arus Kas Masuk dari Dividen"),
	R_13000201060000 ("13000201060000", "Arus Kas Masuk dari Penerimaan Bunga/Ujrah/Imbal Hasil Kegiatan Investasi"),
	R_13000201070000 ("13000201070000", "Arus Kas Masuk dari Kegiatan Investasi Lainnya"),
	R_13000202000000 ("13000202000000", "Arus Kas Keluar untuk Kegiatan Investasi"),
	R_13000202010000 ("13000202010000", "Arus Kas Keluar untuk Penyertaan Modal"),
	R_13000202020000 ("13000202020000", "Arus Kas Keluar untuk Pembelian Tanah, Bangunan, dan Peralatan"),
	R_13000202030000 ("13000202030000", "Arus Kas Keluar untuk Pembelian Aset Tak Berwujud"),
	R_13000202040000 ("13000202040000", "Arus Kas Keluar untuk Perolehan Surat Berharga"),
	R_13000202050000 ("13000202050000", "Arus Kas Keluar untuk Kegiatan Investasi Lainnya"),
	R_13000300000000 ("13000300000000", "Arus Kas Bersih dari Kegiatan Pendanaan "),
	R_13000301000000 ("13000301000000", "Arus Kas Masuk dari Kegiatan Pendanaan   "),
	R_13000301010000 ("13000301010000", "Arus Kas Masuk dari Pinjaman dan Penerbitan Surat Berharga"),
	R_13000301020000 ("13000301020000", "Arus Kas Masuk dari Penerbitan Modal Saham"),
	R_13000301030000 ("13000301030000", "Arus Kas Masuk dari Pendanaan Berdasarkan Prinsip Syariah"),
	R_13000301040000 ("13000301040000", "Arus Kas Masuk dari Pendanaan Lainnya"),
	R_13000302000000 ("13000302000000", "Arus Kas Keluar untuk Kegiatan Pendanaan"),
	R_13000302010000 ("13000302010000", "Arus Kas Keluar untuk Pembayaran Pokok Pinjaman dan Surat Berharga yang Diterbitkan "),
	R_13000302020000 ("13000302020000", "Arus Kas Keluar untuk Pembayaran Bunga Pinjaman dan Surat Berharga yang Diterbitkan "),
	R_13000302030000 ("13000302030000", "Arus Kas Keluar untuk Penarikan Kembali Modal Perusahaan Pembiayaan Infrastruktur  (Treasury Stock)"),
	R_13000302040000 ("13000302040000", "Arus Kas Keluar untuk Pembayaran Dividen"),
	R_13000302050000 ("13000302050000", "Arus Kas Keluar untuk Pendanaan Berdasarkan Prinsip Syariah"),
	R_13000302060000 ("13000302060000", "Arus Kas Keluar untuk Pendanaan Lainnya"),
	R_13000400000000 ("13000400000000", "Surplus (Defisit) pada Kas dan Setara Kas  Akibat Perubahan Kurs"),
	R_13000500000000 ("13000500000000", "Kenaikan (Penurunan) Bersih Kas dan Setara Kas"),
	R_13000600000000 ("13000600000000", "Kas dan Setara Kas pada Awal Periode"),
	R_13000700000000 ("13000700000000", "Kas dan Setara Kas pada Akhir Periode"),
	;

	@Getter
	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3012PosLbPpik1300 eEnum : ER3012PosLbPpik1300.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3012PosLbPpik1300.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3012PosLbPpik1300.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 4), getObjects());
	}
	
	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genEqualsFormula("2+3");
	}
	
	public static SegmentValidation genRowValidation02() {
		int[] fields = new int[] { 1, 13 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000100000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_13000100000000.value, UtilMetadata.genMinusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation03() {
		int[] fields = new int[] { 2, 3, 4, 5, 6, 7, 8, 12 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000101000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_13000101000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation10() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000101070000.key,
				UtilMetadata.genPlusRow(getObjects(), 9, 11),
				UtilMetadata.genMessage(R_13000101070000.value, UtilMetadata.genPlusDesc(getObjects(), 9, 11)));
	}
	
	public static SegmentValidation genRowValidation15() {
		int[] fields = new int[] { 14, 15, 16, 17, 18, 19, 20, 24, 25, 26, 27 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000102000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_13000102000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation22() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000102070000.key,
				UtilMetadata.genPlusRow(getObjects(), 21, 23),
				UtilMetadata.genMessage(R_13000102070000.value, UtilMetadata.genPlusDesc(getObjects(), 21, 23)));
	}
	
	public static SegmentValidation genRowValidation30() {
		int[] fields = new int[] { 29, 37 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000200000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_13000200000000.value, UtilMetadata.genMinusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation31() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000201000000.key,
				UtilMetadata.genPlusRow(getObjects(), 30, 36),
				UtilMetadata.genMessage(R_13000201000000.value, UtilMetadata.genPlusDesc(getObjects(), 30, 36)));
	}
	
	public static SegmentValidation genRowValidation39() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000202000000.key,
				UtilMetadata.genPlusRow(getObjects(), 38, 42),
				UtilMetadata.genMessage(R_13000202000000.value, UtilMetadata.genPlusDesc(getObjects(), 38, 42)));
	}
	
	public static SegmentValidation genRowValidation45() {
		int[] fields = new int[] { 44, 49 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000300000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_13000300000000.value, UtilMetadata.genMinusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation46() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000301000000.key,
				UtilMetadata.genPlusRow(getObjects(), 45, 48),
				UtilMetadata.genMessage(R_13000301000000.value, UtilMetadata.genPlusDesc(getObjects(), 45, 48)));
	}
	
	public static SegmentValidation genRowValidation51() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000302000000.key,
				UtilMetadata.genPlusRow(getObjects(), 50, 55),
				UtilMetadata.genMessage(R_13000302000000.value, UtilMetadata.genPlusDesc(getObjects(), 50, 55)));
	}
	
	public static SegmentValidation genRowValidation59() {
		int[] fields = new int[] { 0, 28, 43, 56 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000500000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_13000500000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation61A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_13000700000000.key,
				UtilMetadata.genPlusRow(getObjects(), 57, 58),
				UtilMetadata.genMessage(R_13000700000000.value, UtilMetadata.genPlusDesc(getObjects(), 57, 58)));
	}

	public static SegmentValidation genRowValidation61B() {
		return UtilSegmentValidation.genEqualsForm("2", R_13000700000000.key, EFormLaporanBulanan.LB_1100.getCode(), "2",
				ER3009PosLbPpik1100.R_11000101000000.getKey(), R_13000700000000.value);
	}

	public static SegmentValidation genRowValidation61C() {
		return UtilSegmentValidation.genEqualsForm("3", R_13000700000000.key, EFormLaporanBulanan.LB_1100.getCode(), "3",
				ER3009PosLbPpik1100.R_11000101000000.getKey(), R_13000700000000.value);
	}

	public static SegmentValidation genRowValidation61D() {
		return UtilSegmentValidation.genEqualsForm("4", R_13000700000000.key, EFormLaporanBulanan.LB_1100.getCode(), "4",
				ER3009PosLbPpik1100.R_11000101000000.getKey(), R_13000700000000.value);
	}
}
