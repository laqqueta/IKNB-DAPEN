 package id.go.ojk.ppik.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3011PosLbPpik1200 implements IObject<KeyValueString> {
	R_1200010000000000 ("1200010000000000", "Pendapatan"),
	R_1200010100000000 ("1200010100000000", "Pendapatan Operasional"),
	R_1200010101000000 ("1200010101000000", "Pendapatan dari Kegiatan Operasi"),
	R_1200010101010000 ("1200010101010000", "Pendapatan Bunga Pinjaman yang Diberikan"),
	R_1200010101010100 ("1200010101010100", "Pemberian Pinjaman Langsung (Direct Lending) untuk Pembiayaan Infrastruktur"),
	R_1200010101010200 ("1200010101010200", "Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain"),
	R_1200010101010300 ("1200010101010300", "Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur Pengembangan Usaha"),
	R_1200010101010400 ("1200010101010400", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan"),
	R_1200010101010500 ("1200010101010500", "Kegiatan atau Pemberian Fasilita Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah"),
	R_1200010101020000 ("1200010101020000", "Pendapatan Pembiayaan yang Diberikan Berdasarkan Prinsip Syariah"),
	R_1200010101020100 ("1200010101020100", "Pemberian Pembiayaan Langsung (Direct Financing) untuk Pembiayaan Infrastruktur"),
	R_1200010101020101 ("1200010101020101", "Marjin Murabahah"),
	R_1200010101020102 ("1200010101020102", "Bagi Hasil Mudharabah"),
	R_1200010101020103 ("1200010101020103", "Bagi Hasil Musyarakah"),
	R_1200010101020104 ("1200010101020104", "Bagi Hasil MMQ"),
	R_1200010101020105 ("1200010101020105", "Pendapatan Ijarah"),
	R_1200010101020106 ("1200010101020106", "Pendapatan IMBT"),
	R_1200010101020107 ("1200010101020107", "Pendapatan/Bagi Hasil Lainnya"),
	R_1200010101020200 ("1200010101020200", "Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain"),
	R_1200010101020201 ("1200010101020201", "Pendapatan IMBT"),
	R_1200010101020202 ("1200010101020202", "Bagi Hasil MMQ"),
	R_1200010101020203 ("1200010101020203", "Pendapatan/Bagi Hasil Lainnya"),
	R_1200010101020300 ("1200010101020300", "Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur"),
	R_1200010101020400 ("1200010101020400", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur setelah memperoleh Persetujuan Otoritas Jasa Keuangan"),
	R_1200010101020500 ("1200010101020500", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah"),
	R_1200010102000000 ("1200010102000000", "Pendapatan dari Kegiatan Usaha Lain"),
	R_1200010102010000 ("1200010102010000", "Pendapatan dari Pemberian Dukungan Kredit/Pembiayaan"),
	R_1200010102020000 ("1200010102020000", "Pendapatan dari Pemberian Jasa Konsultasi"),
	R_1200010102030000 ("1200010102030000", "Pendapatan Dividen dari Penyertaan Modal"),
	R_1200010102040000 ("1200010102040000", "Pendapatan dari Upaya Mencarikan Pasar Swap yang Berkaitan dengan Pembiayaan Infrastruktur"),
	R_1200010102050000 ("1200010102050000", "Keuntungan dari Penyertaan Modal dengan Metode Ekuitas"),
	R_1200010103000000 ("1200010103000000", "Pendapatan Operasional Lain terkait Pembiayaan"),
	R_1200010103010000 ("1200010103010000", "Pendapatan Administrasi"),
	R_1200010103020000 ("1200010103020000", "Pendapatan Provisi"),
	R_1200010103030000 ("1200010103030000", "Pendapatan Denda/Ganti Rugi (Ta’zir)"),
	R_1200010103040000 ("1200010103040000", "Pendapatan Operasional Lain terkait Pembiayaan Lainnya"),
	R_1200010104000000 ("1200010104000000", "Pendapatan Operasional Lainnya"),
	R_1200010200000000 ("1200010200000000", "Pendapatan Non Operasional"),
	R_1200010201000000 ("1200010201000000", "Pendapatan Bunga/Jasa Giro/Ujrah/Bagi Hasil"),
	R_1200010202000000 ("1200010202000000", "Pendapatan Bunga/Imbal Hasil Investasi"),
	R_1200010203000000 ("1200010203000000", "Pendapatan Non Operasional Lainnya"),
	R_1200020000000000 ("1200020000000000", "Beban"),
	R_1200020100000000 ("1200020100000000", "Beban Operasional "),
	R_1200020101000000 ("1200020101000000", "Beban Bunga, Imbal Hasil, Provisi, dan Fee"),
	R_1200020101010000 ("1200020101010000", "Beban Bunga dari Pinjaman yang Diterima"),
	R_1200020101020000 ("1200020101020000", "Beban Bunga dari Surat Berharga yang Diterbitkan"),
	R_1200020101030000 ("1200020101030000", "Beban Ujrah/Imbal Hasi atas Pendanaan yang Diterima Berdasarkan Prinsip Syariah"),
	R_1200020101040000 ("1200020101040000", "Beban Provisi dan Fee"),
	R_1200020102000000 ("1200020102000000", "Beban Premi atas Transaksi Swap"),
	R_1200020103000000 ("1200020103000000", "Beban Tenaga Kerja"),
	R_1200020103010000 ("1200020103010000", "Beban Gaji, Upah, dan Tunjangan"),
	R_1200020103020000 ("1200020103020000", "Beban Pengembangan dan Pelatihan Tenaga Kerja"),
	R_1200020103030000 ("1200020103030000", "Beban Tenaga Kerja Lainnya"),
	R_1200020104000000 ("1200020104000000", "Beban Pemasaran"),
	R_1200020105000000 ("1200020105000000", "Beban Penyisihan/Penyusutan"),
	R_1200020105010000 ("1200020105010000", "Beban Penyisihan Penghapusan Piutang Pembiayaan"),
	R_1200020105010100 ("1200020105010100", "Beban Penyisihan Penghapusan Piutang Pembiayaan Pemberian Pinjaman Langsung (Direct Lending) untuk Pembiayaan Infrastruktur"),
	R_1200020105010200 ("1200020105010200", "Beban Penyisihan Penghapusan Piutang Pembiayaan Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain"),
	R_1200020105010300 ("1200020105010300", "Beban Penyisihan Penghapusan Piutang Pembiayaan Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur"),
	R_1200020105010400 ("1200020105010400", "Beban Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan"),
	R_1200020105010500 ("1200020105010500", "Beban Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah"),
	R_1200020105020000 ("1200020105020000", "Beban Penyisihan Penghapusan Piutang Pembiayaan Berdasarkan Prinsip Syariah"),
	R_1200020105020100 ("1200020105020100", "Beban Penyisihan Penghapusan Piutang Pembiayaan Pemberian Pembiayaan Langsung (Direct Financing) untuk Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah"),
	R_1200020105020200 ("1200020105020200", "Beban Penyisihan Penghapusan Piutang Pembiayaan Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain Berdasarkan Prinsip Syariah"),
	R_1200020105020300 ("1200020105020300", "Beban Penyisihan Penghapusan Piutang Pembiayaan Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah"),
	R_1200020105020400 ("1200020105020400", "Beban Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan Berdasarkan Prinsip Syariah"),
	R_1200020105020500 ("1200020105020500", "Beban Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Berdasarkan Prinsip Syariah"),
	R_1200020105030000 ("1200020105030000", "Beban Penyusutan Aset Tetap dan Inventaris"),
	R_1200020105040000 ("1200020105040000", "Beban Amortisasi Aset Tidak Berwujud"),
	R_1200020106000000 ("1200020106000000", "Beban Penurunan Nilai Aset Keuangan"),
	R_1200020106010000 ("1200020106010000", "Penempatan pada Bank"),
	R_1200020106020000 ("1200020106020000", "Surat Berharga yang Dimiliki"),
	R_1200020106030000 ("1200020106030000", "Pinjaman yang Diberikan"),
	R_1200020106040000 ("1200020106040000", "Lainnya"),
	R_1200020107000000 ("1200020107000000", "Beban Sewa"),
	R_1200020108000000 ("1200020108000000", "Beban Pemeliharaan dan Perbaikan"),
	R_1200020109000000 ("1200020109000000", "Beban Administrasi dan Umum"),
	R_1200020110000000 ("1200020110000000", "Beban Operasional Lainnya"),
	R_1200020200000000 ("1200020200000000", "Beban Non Operasional"),
	R_1200030000000000 ("1200030000000000", "Laba (Rugi) Sebelum Pajak"),
	R_1200040000000000 ("1200040000000000", "Taksiran Pajak Penghasilan"),
	R_1200040100000000 ("1200040100000000", "Pajak Tahun Berjalan"),
	R_1200040200000000 ("1200040200000000", "Pendapatan (Beban) Pajak Tangguhan"),
	R_1200050000000000 ("1200050000000000", "Laba (Rugi) Bersih Setelah Pajak"),
	R_1200060000000000 ("1200060000000000", "Keuntungan (Kerugian) Pendapatan Komprehensif Lainnya Periode Berjalan"),
	R_1200060100000000 ("1200060100000000", "Keuntungan (Kerugian) Akibat Perubahan dalam Surplus Revaluasi Aset Tetap"),
	R_1200060200000000 ("1200060200000000", "Selisih Kurs Karena Penjabaran Laporan Keuangan dalam Mata Uang Asing"),
	R_1200060300000000 ("1200060300000000", "Keuntungan (Kerugian) Akibat Pengukuran Kembali Aset Keuangan Tersedia untuk Dijual"),
	R_1200060400000000 ("1200060400000000", "Keuntungan (Kerugian) Akibat Bagian Efektif Instrumen Keuangan Lindung Nilai dalam Rangka Lindung Nilai Arus Kas"),
	R_1200060500000000 ("1200060500000000", "Keuntungan (Kerugian) atas Komponen Ekuitas Lainnya Sesuai Prinsip Standar Akuntansi Keuangan"),
	R_1200070000000000 ("1200070000000000", "Laba (Rugi) Bersih Komprehensif Tahun Berjalan"),
	;

	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulanan.LB_1200.getCode() + key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3011PosLbPpik1200 eEnum : ER3011PosLbPpik1200.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3011PosLbPpik1200.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3011PosLbPpik1200.class.getSimpleName().substring(2, 6));
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2,  4), getObjects());
	}
	
	public static FieldValidation genFieldValidation4() {
		return UtilFieldValidation.genEqualsFormula("2+3");
	}
	
	public static SegmentValidation genRowValidation02() {
		int[] fields = new int[] { 1, 37 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200010000000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_1200010000000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation03() {
		int[] fields = new int[] { 2, 25, 31, 36 };
		return UtilSegmentValidation.genEqualsFormula("2|3", R_1200010100000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_1200010100000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation04() {
		int[] fields = new int[] { 3, 9 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200010101000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_1200010101000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation05() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200010101010000.key,
				UtilMetadata.genPlusRow(getObjects(), 4, 8),
				UtilMetadata.genMessage(R_1200010101010000.value, UtilMetadata.genPlusDesc(getObjects(), 4, 8)));
	}
	
	public static SegmentValidation genRowValidation10() {
		int[] fields = new int[] { 10, 18, 22, 23, 24 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200010101020000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_1200010101020000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation11() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200010101020100.key,
				UtilMetadata.genPlusRow(getObjects(), 11, 17),
				UtilMetadata.genMessage(R_1200010101020100.value, UtilMetadata.genPlusDesc(getObjects(), 11, 17)));
	}
	
	public static SegmentValidation genRowValidation20() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200010101020200.key,
				UtilMetadata.genPlusRow(getObjects(), 19, 21),
				UtilMetadata.genMessage(R_1200010101020200.value, UtilMetadata.genPlusDesc(getObjects(), 19, 21)));
	}
	
	public static SegmentValidation genRowValidation27() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200010102000000.key,
				UtilMetadata.genPlusRow(getObjects(), 26, 30),
				UtilMetadata.genMessage(R_1200010102000000.value, UtilMetadata.genPlusDesc(getObjects(), 26, 30)));
	}
	
	public static SegmentValidation genRowValidation33() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200010103000000.key,
				UtilMetadata.genPlusRow(getObjects(), 32, 35),
				UtilMetadata.genMessage(R_1200010103000000.value, UtilMetadata.genPlusDesc(getObjects(), 32, 35)));
	}
	
	public static SegmentValidation genRowValidation39() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200010200000000.key,
				UtilMetadata.genPlusRow(getObjects(), 38, 40),
				UtilMetadata.genMessage(R_1200010200000000.value, UtilMetadata.genPlusDesc(getObjects(), 38, 40)));
	}
	
	public static SegmentValidation genRowValidation43() {
		int[] fields = new int[] { 42, 78 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200020000000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_1200020000000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation44() {
		int[] fields = new int[] { 43, 48, 49, 53, 54, 69, 74, 75, 76, 77 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200020100000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_1200020100000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation45() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200020101000000.key,
				UtilMetadata.genPlusRow(getObjects(), 44, 47),
				UtilMetadata.genMessage(R_1200020101000000.value, UtilMetadata.genPlusDesc(getObjects(), 44, 47)));
	}
	
	public static SegmentValidation genRowValidation51() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200020103000000.key,
				UtilMetadata.genPlusRow(getObjects(), 50, 52),
				UtilMetadata.genMessage(R_1200020103000000.value, UtilMetadata.genPlusDesc(getObjects(), 50, 52)));
	}
	
	public static SegmentValidation genRowValidation56() {
		int[] fields = new int[] { 55, 61, 67, 68 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200020105000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_1200020105000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation57() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200020105010000.key,
				UtilMetadata.genPlusRow(getObjects(), 56, 60),
				UtilMetadata.genMessage(R_1200020105010000.value, UtilMetadata.genPlusDesc(getObjects(), 56, 60)));
	}
	
	public static SegmentValidation genRowValidation63() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200020105020000.key,
				UtilMetadata.genPlusRow(getObjects(), 62, 66),
				UtilMetadata.genMessage(R_1200020105020000.value, UtilMetadata.genPlusDesc(getObjects(), 62, 66)));
	}
	
	public static SegmentValidation genRowValidation71() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200020106000000.key,
				UtilMetadata.genPlusRow(getObjects(), 70, 73),
				UtilMetadata.genMessage(R_1200020106000000.value, UtilMetadata.genPlusDesc(getObjects(), 70, 73)));
	}
	
	public static SegmentValidation genRowValidation81() {
		int[] fields = new int[] { 0, 41 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200030000000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_1200030000000000.value, UtilMetadata.genMinusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation82() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200040000000000.key,
				UtilMetadata.genPlusRow(getObjects(), 81, 82),
				UtilMetadata.genMessage(R_1200040000000000.value, UtilMetadata.genPlusDesc(getObjects(), 81, 82)));
	}
	
	public static SegmentValidation genRowValidation85A() {
		int[] fields = new int[] { 79, 81 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200050000000000.key,
				UtilMetadata.genMinusRow(getObjects(), fields) + "+" + R_1200040200000000.key,
				UtilMetadata.genMessage(R_1200050000000000.value,
						UtilMetadata.genMinusDesc(getObjects(), fields) + "+"
								+ StringUtils.wrap(R_1200040200000000.value.toLowerCase(), "'")));
	}

	public static SegmentValidation genRowValidation85B() {
		return UtilSegmentValidation.genEqualsForm("2", R_1200050000000000.key, EFormLaporanBulanan.LB_1100.getCode(), 
				"2", ER3009PosLbPpik1100.R_11000313000000.getKey(), R_1200050000000000.value);
	}

	public static SegmentValidation genRowValidation85C() {
		return UtilSegmentValidation.genEqualsForm("3", R_1200050000000000.key, EFormLaporanBulanan.LB_1100.getCode(), 
				"3", ER3009PosLbPpik1100.R_11000313000000.getKey(), R_1200050000000000.value);
	}

	public static SegmentValidation genRowValidation85D() {
		return UtilSegmentValidation.genEqualsForm("4", R_1200050000000000.key, EFormLaporanBulanan.LB_1100.getCode(), 
				"4", ER3009PosLbPpik1100.R_11000313000000.getKey(), R_1200050000000000.value);
	}
	
	public static SegmentValidation genRowValidation86A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200060000000000.key,
				UtilMetadata.genPlusRow(getObjects(), 85, 89),
				UtilMetadata.genMessage(R_1200060000000000.value, UtilMetadata.genPlusDesc(getObjects(), 85, 89)));
	}

	public static SegmentValidation genRowValidation86B() {
		return UtilSegmentValidation.genEqualsForm("2", R_1200060000000000.key, EFormLaporanBulanan.LB_1100.getCode(), 
				"2", ER3009PosLbPpik1100.R_11000314020000.getKey(), R_1200060000000000.value);
	}

	public static SegmentValidation genRowValidation86C() {
		return UtilSegmentValidation.genEqualsForm("3", R_1200060000000000.key, EFormLaporanBulanan.LB_1100.getCode(), 
				"3", ER3009PosLbPpik1100.R_11000314020000.getKey(), R_1200060000000000.value);
	}

	public static SegmentValidation genRowValidation86D() {
		return UtilSegmentValidation.genEqualsForm("4", R_1200060000000000.key, EFormLaporanBulanan.LB_1100.getCode(), 
				"4", ER3009PosLbPpik1100.R_11000314020000.getKey(), R_1200060000000000.value);
	}
	
	public static SegmentValidation genRowValidation92() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_1200070000000000.key,
				UtilMetadata.genPlusRow(getObjects(), 83, 84),
				UtilMetadata.genMessage(R_1200070000000000.value, UtilMetadata.genPlusDesc(getObjects(), 83, 84)));
	}
}
