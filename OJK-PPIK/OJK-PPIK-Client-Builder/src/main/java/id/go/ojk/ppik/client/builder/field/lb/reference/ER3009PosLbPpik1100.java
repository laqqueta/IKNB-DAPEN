package id.go.ojk.ppik.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1122JenisValuta;
import id.go.ojk.conf.client.field.reference.ER1126Negara;
import id.go.ojk.conf.client.field.reference.ER1132JenisPinjaman;
import id.go.ojk.conf.client.field.reference.ER1140GolonganPihakLawan2550;
import id.go.ojk.conf.client.field.reference.ER1142JenisKegiatanUsahaYangDilakukan;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulanan;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3009PosLbPpik1100 implements IObject<KeyValueString> {
//	R_11000100000000 ("11000100000000", "Aset"),
	R_11000101000000 ("11000101000000", "Kas dan Setara Kas"),
	R_11000101010000 ("11000101010000", "Kas"),
	R_11000101020000 ("11000101020000", "Simpanan pada Bank Dalam Negeri"),
	R_11000101020100 ("11000101020100", "Giro Pada Bank Dalam Negeri"),
	R_11000101020200 ("11000101020200", "Simpanan Lainnya Pada Bank Dalam Negeri"),
	R_11000101030000 ("11000101030000", "Simpanan Pada Bank Luar Negeri"),
	R_11000101030100 ("11000101030100", "Giro Pada Bank Luar Negeri"),
	R_11000101030200 ("11000101030200", "Simpanan Lainnya Pada Bank Luar Negeri"),
	R_11000101040000 ("11000101040000", "Dana yang Dibatasi Penggunaannya (Restricted Fund)"),
	R_11000102000000 ("11000102000000", "Investasi dalam Surat Berharga/Surat Berharga Syariah"),
	R_11000103000000 ("11000103000000", "Aset Tagihan Derivatif"),
	R_11000104000000 ("11000104000000", "Piutang Pembiayaan Neto"),
	R_11000104010000 ("11000104010000", "Pemberian Pinjaman Langsung (Direct Lending) untuk Pembiayaan Infrastruktur Neto"),
	R_11000104010100 ("11000104010100", "Pemberian Pinjaman Langsung (Direct Lending) untuk Pembiayaan Infrastruktur Bruto"),
	R_11000104010200 ("11000104010200", "Pendapatan Bunga yang Belum Diterima (Unearned Interest Income)"),
	R_11000104010300 ("11000104010300", "Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000104010400 ("11000104010400", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Pemberian Pinjaman Langsung (Direct Lending) untuk Pembiayaan Infrastruktur"),
	R_11000104020000 ("11000104020000", "Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain Neto"),
	R_11000104020100 ("11000104020100", "Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain Bruto"),
	R_11000104020200 ("11000104020200", "Pendapatan Bunga yang Belum Diterima (Unearned Interest Income) "),
	R_11000104020300 ("11000104020300", "Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000104020400 ("11000104020400", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain"),
	R_11000104030000 ("11000104030000", "Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur Neto"),
	R_11000104030100 ("11000104030100", "Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur Bruto"),
	R_11000104030200 ("11000104030200", "Pendapatan Bunga yang Belum Diterima (Unearned Interest Income)"),
	R_11000104030300 ("11000104030300", "Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000104030400 ("11000104030400", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur"),
	R_11000105000000 ("11000105000000", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan Neto"),
	R_11000105010000 ("11000105010000", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan Bruto"),
	R_11000105020000 ("11000105020000", "Pendapatan Bunga yang Belum Diterima (Unearned Interest Income)"),
	R_11000105030000 ("11000105030000", "Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi "),
	R_11000105040000 ("11000105040000", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan"),
	R_11000106000000 ("11000106000000", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Neto"),
	R_11000106010000 ("11000106010000", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Bruto"),
	R_11000106020000 ("11000106020000", "Pendapatan Bunga yang Belum Diterima (Unearned Interest Income)"),
	R_11000106030000 ("11000106030000", "Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000106040000 ("11000106040000", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah"),
	R_11000107000000 ("11000107000000", "Piutang Pembiayaan Berdasarkan Prinsip Syariah Neto"),
	R_11000107010000 ("11000107010000", "Pemberian Pembiayaan Langsung (Direct Financing) untuk Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah Neto"),
	R_11000107010100 ("11000107010100", "Pemberian Pembiayaan Langsung (Direct Financing) untuk Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah Bruto"),
	R_11000107010101 ("11000107010101", "Pembiayaan Murabahah"),
	R_11000107010102 ("11000107010102", "Pembiayaan Mudharabah"),
	R_11000107010103 ("11000107010103", "Pembiayaan Musyarakah"),
	R_11000107010104 ("11000107010104", "Pembiayaan MMQ"),
	R_11000107010105 ("11000107010105", "Pembiayaan Ijarah"),
	R_11000107010106 ("11000107010106", "Pembiayaan IMBT"),
	R_11000107010107 ("11000107010107", "Pembiayaan Lainnya"),
	R_11000107010200 ("11000107010200", "Pendapatan Bagi Hasil Tangguhan"),
	R_11000107010300 ("11000107010300", "Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000107010400 ("11000107010400", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Pemberian Pembiayaan Langsung (Direct Financing) untuk Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah"),
	R_11000107020000 ("11000107020000", "Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain Berdasarkan Prinsip Syariah Neto"),
	R_11000107020100 ("11000107020100", "Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain Berdasarkan Prinsip Syariah Bruto"),
	R_11000107020101 ("11000107020101", "Pembiayaan IMBT"),
	R_11000107020102 ("11000107020102", "Pembiayaan MMQ"),
	R_11000107020103 ("11000107020103", "Pembiayaan Lainnya"),
	R_11000107020200 ("11000107020200", "Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi "),
	R_11000107020300 ("11000107020300", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Refinancing atas Infrastruktur yang Telah Dibiayai Pihak Lain Berdasarkan Prinsip Syariah"),
	R_11000107030000 ("11000107030000", "Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah Neto"),
	R_11000107030100 ("11000107030100", "Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah Bruto"),
	R_11000107030200 ("11000107030200", "Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000107030300 ("11000107030300", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Pemberian Pembiayaan Subordinasi yang Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Prinsip Syariah"),
	R_11000107040000 ("11000107040000", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan Berdasarkan Prinsip Syariah neto"),
	R_11000107040100 ("11000107040100", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan Berdasarkan Prinsip Syariah Bruto"),
	R_11000107040200 ("11000107040200", "Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000107040300 ("11000107040300", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan Berdasarkan Prinsip Syariah"),
	R_11000107050000 ("11000107050000", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Berdasarkan Prinsip Syariah Neto"),
	R_11000107050100 ("11000107050100", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Berdasarkan Prinsip Syariah Bruto"),
	R_11000107050200 ("11000107050200", "Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000107050300 ("11000107050300", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Berdasarkan Prinsip Syariah"),
	R_11000108000000 ("11000108000000", "Aset Ijarah Neto"),
	R_11000108010000 ("11000108010000", "Aset Ijarah Bruto"),
	R_11000108020000 ("11000108020000", "Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000108030000 ("11000108030000", "Akumulasi Penyusutan"),
	R_11000109000000 ("11000109000000", "Penyertaan Modal"),
	R_11000109010000 ("11000109010000", "Penyertaan Modal pada Perusahaan di Sektor Jasa Keuangan"),
	R_11000109020000 ("11000109020000", "Penyertaan Modal pada Perusahaan yang Bergerak dalam Proyek Infrastruktur"),
	R_11000110000000 ("11000110000000", "Tagihan terkait Kegiatan Usaha Lain:"),
	R_11000110010000 ("11000110010000", "Tagihan terkait Pemberian Dukungan Kredit/Pembiayaan"),
	R_11000110020000 ("11000110020000", "Tagihan terkait Pemberian Jasa Konsultasi"),
	R_11000110030000 ("11000110030000", "Tagihan terkait Upaya Mencarikan Pasar Swap yang Berkaitan dengan Pembiayaan Infrastruktur"),
	R_11000111000000 ("11000111000000", "Aset Tetap dan Inventaris Neto"),
	R_11000111010000 ("11000111010000", "Aset Tetap dan Inventaris Bruto"),
	R_11000111020000 ("11000111020000", "Akumulasi Penyusutan Aset Tetap dan Inventaris"),
	R_11000112000000 ("11000112000000", "Aset Tak Berwujud Neto"),
	R_11000112010000 ("11000112010000", "Aset Tidak Berwujud Bruto"),
	R_11000112020000 ("11000112020000", "Akumulasi Amortisasi Aset Tidak Berwujud"),
	R_11000113000000 ("11000113000000", "Aset Pajak Tangguhan"),
	R_11000114000000 ("11000114000000", "Rupa-Rupa Aset"),
	R_11000200000000 ("11000200000000", "Total Aset"),
//	R_11000300000000 ("11000300000000", "Liabilitas dan Ekuitas"),
	R_11000301000000 ("11000301000000", "Liabilitas Segera"),
	R_11000301010000 ("11000301010000", "Liabilitas kepada Pemerintah"),
	R_11000301020000 ("11000301020000", "Liabilitas kepada Organisasi Multilateral"),
	R_11000301030000 ("11000301030000", "Liabilitas kepada Bank"),
	R_11000301040000 ("11000301040000", "Liabilitas kepada Lembaga Keuangan"),
	R_11000301050000 ("11000301050000", "Liabilitas Segera Lainnya"),
	R_11000302000000 ("11000302000000", "Liabilitas Derivatif"),
	R_11000303000000 ("11000303000000", "Utang Pajak"),
	R_11000304000000 ("11000304000000", "Pinjaman/Pendanaan Yang Diterima"),
	R_11000304010000 ("11000304010000", "Pinjaman/Pendanaan yang Diterima dari Pemerintah"),
	R_11000304010100 ("11000304010100", "Pinjaman/Pendanaan yang Diterima dari Pemerintah Pusat"),
	R_11000304010200 ("11000304010200", "Pinjaman/Pendanaan yang Diterima dari Pemerintah Daerah"),
	R_11000304010300 ("11000304010300", "Pinjaman/Pendanaan yang Diterima dari Pemerintah Asing"),
	R_11000304020000 ("11000304020000", "Pinjaman/Pendanaan yang Diterima dari Organisasi Multilateral"),
	R_11000304030000 ("11000304030000", "Pinjaman/Pendanaan yang Diterima dari Bank"),
	R_11000304030100 ("11000304030100", "Pinjaman/Pendanaan Yang Diterima Dari Bank Dalam Negeri"),
	R_11000304030200 ("11000304030200", "Pinjaman/Pendanaan Yang Diterima Dari Bank Luar Negeri"),
	R_11000304040000 ("11000304040000", "Pinjaman/Pendanaan yang Diterima dari Lembaga Keuangan non Bank"),
	R_11000304040100 ("11000304040100", "Pinjaman/Pendanaan yang Diterima dari Lembaga Keuangan non Bank Dalam Negeri"),
	R_11000304040200 ("11000304040200", "Pinjaman/Pendanaan yang Diterima dari Lembaga Keuangan non Bank Luar Negeri"),
	R_11000305000000 ("11000305000000", "Surat Berharga/Surat Berharga Syariah yang Diterbitkan"),
	R_11000306000000 ("11000306000000", "Liabilitas Imbalan Pasca Kerja"),
	R_11000307000000 ("11000307000000", "Liabilitas Pajak Tangguhan"),
	R_11000308000000 ("11000308000000", "Pinjaman/Pendanaan Subordinasi"),
	R_11000308010000 ("11000308010000", "Pinjaman/Pendanaan Subordinasi Dalam Negeri"),
	R_11000308020000 ("11000308020000", "Pinjaman/Pendanaan Subordinasi Luar Negeri"),
	R_11000315000000 ("11000315000000", "Sumber Pendanaan Lainnya Sesuai dengan Peraturan Perundang-Undangan"),
	R_11000309000000 ("11000309000000", "Rupa-Rupa Liabilitas"),
	R_11000310000000 ("11000310000000", "Modal"),
	R_11000310010000 ("11000310010000", "Modal Disetor"),
	R_11000310010100 ("11000310010100", "Modal Dasar"),
	R_11000310010200 ("11000310010200", "Modal yang Belum Disetor"),
	R_11000310020000 ("11000310020000", "Tambahan modal Disetor"),
	R_11000310020100 ("11000310020100", "Agio"),
	R_11000310020200 ("11000310020200", "Modal Hibah"),
	R_11000310020300 ("11000310020300", "Selisih Nilai Transaksi Restrukturisasi Entitas Sepengendali"),
	R_11000310020400 ("11000310020400", "Tambahan Modal Disetor Lainnya"),
	R_11000310030000 ("11000310030000", "Disagio"),
	R_11000310040000 ("11000310040000", "Modal Saham Diperoleh Kembali"),
	R_11000310050000 ("11000310050000", "Biaya Emisi Efek Ekuitas"),
	R_11000311000000 ("11000311000000", "Cadangan"),
	R_11000311010000 ("11000311010000", "Cadangan Umum"),
	R_11000311020000 ("11000311020000", "Cadangan Tujuan"),
	R_11000312000000 ("11000312000000", "Saldo Laba (Rugi) yang Ditahan"),
	R_11000313000000 ("11000313000000", "Laba (Rugi) Bersih Setelah Pajak"),
	R_11000314000000 ("11000314000000", "Komponen Ekuitas Lainnya"),
	R_11000314010000 ("11000314010000", "Saldo Komponen Ekuitas Lainnya"),
	R_11000314010100 ("11000314010100", "Saldo Keuntungan (Kerugian) Akibat Perubahan dalam Surplus Revaluasi Aset Tetap"),
	R_11000314010200 ("11000314010200", "Saldo Keuntungan (Kerugian) Akibat Selisih Kurs Karena Penjabaran Laporan Keuangan Dalam Mata Uang Asing"),
	R_11000314010300 ("11000314010300", "Saldo Keuntungan (Kerugian) Akibat Pengukuran Kembali Aset Keuangan Tersedia Untuk Dijual"),
	R_11000314010400 ("11000314010400", "Saldo Keuntungan (Kerugian) Akibat Bagian Efektif Instrumen Keuangan Lindung Nilai dalam Rangka Lindung Nilai Arus Kas"),
	R_11000314010500 ("11000314010500", "Saldo Keuntungan (Kerugian) atas Komponen Ekuitas Lainnya Sesuai Prinsip Standar Akuntansi Keuangan"),
	R_11000314020000 ("11000314020000", "Keuntungan (Kerugian) Komperehensif Lainnya Periode Berjalan"),
	R_11000400000000 ("11000400000000", "Total Liabilitas dan Ekuitas"),
	;

	@Getter
	private String key;
	private String value;
	
	public String getFormKey() {
		return EFormLaporanBulanan.LB_1100.getCode() + key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public KeyValueString getFormObject() {
		return new KeyValueString(getFormKey(), value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3009PosLbPpik1100 eEnum : ER3009PosLbPpik1100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static List<KeyValueString> getFormObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3009PosLbPpik1100 eEnum : ER3009PosLbPpik1100.values()) {
			res.add(eEnum.getFormObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3009PosLbPpik1100.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3009PosLbPpik1100.class.getSimpleName().substring(2, 6));
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
	
	public static SegmentValidation genRowValidation002() {
		int[] fields = new int[] { 1, 2, 5, 8 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000101000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_11000101000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation004() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000101020000.key,
				UtilMetadata.genPlusRow(getObjects(), 3, 4), 
				UtilMetadata.genMessage(R_11000101020000.value, UtilMetadata.genPlusDesc(getObjects(), 3, 4)));
	}
	
	public static SegmentValidation genRowValidation007() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000101030000.key,
				UtilMetadata.genPlusRow(getObjects(), 6, 7), 
				UtilMetadata.genMessage(R_11000101030000.value, UtilMetadata.genPlusDesc(getObjects(), 6, 7)));
	}

	public static SegmentValidation genRowValidation011A() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_11000102000000.key, "12",
				ER3015PosLbPpik2200.R_2200010000.getFormKey(), "6", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessage(R_11000102000000.value, "Akumulasi nilai kolom Saldo Akhir (rupiah) pada form 2200"));
	}

	public static SegmentValidation genRowValidation011B() {
		return UtilSegmentValidation.genEqualsFormulaFormNotEquals("3", R_11000102000000.key, "12",
				ER3015PosLbPpik2200.R_2200010000.getFormKey(), "6", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessage(R_11000102000000.value, "Akumulasi nilai kolom Saldo Akhir (selain rupiah) pada form 2200"));
	}
	
	public static SegmentValidation genRowValidation013A() {
		int[] fields = new int[] { 12, 17, 22, 27, 32 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000104000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_11000104000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation013B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000104000000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101000000.getKey(), R_11000104000000.value);
	}

	public static SegmentValidation genRowValidation013C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000104000000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101000000.getKey(), R_11000104000000.value);
	}

	public static SegmentValidation genRowValidation013D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000104000000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101000000.getKey(), R_11000104000000.value);
	}
	
	public static SegmentValidation genRowValidation014A() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_11000104010000.key,
				UtilMetadata.genPlusRow(getObjects(), 13, 14) + "-" + UtilMetadata.genMinusRow(getObjects(), 15, 16),
				UtilMetadata.genMessage(R_11000104010000.value,
				UtilMetadata.genPlusDesc(getFormObjects(), 13, 14) + "-" + UtilMetadata.genMinusDesc(getFormObjects(), 15, 16)));
	}

	public static SegmentValidation genRowValidation014B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000104010000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101010000.getKey(), R_11000104010000.value);
	}

	public static SegmentValidation genRowValidation014C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000104010000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101010000.getKey(), R_11000104010000.value);
	}

	public static SegmentValidation genRowValidation014D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000104010000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101010000.getKey(), R_11000104010000.value);
	}

	public static SegmentValidation genRowValidation015A() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_1.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000104010100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000104010100.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation015B() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_1.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000104010100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000104010100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation018A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000104010400.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101010200.getKey(), R_11000104010400.value);
	}

	public static SegmentValidation genRowValidation018B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000104010400.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101010200.getKey(), R_11000104010400.value);
	}

	public static SegmentValidation genRowValidation018C() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000104010400.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101010200.getKey(), R_11000104010400.value);
	}

	public static SegmentValidation genRowValidation018D() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_1.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000104010400.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000104010400.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation018E() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_1.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000104010400.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000104010400.value, messageForm2100BNonRupiah(kegiatan)));
	}
	
	public static SegmentValidation genRowValidation019A() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_11000104020000.key,
				UtilMetadata.genPlusRow(getObjects(), 18, 19) + "-" + UtilMetadata.genMinusRow(getObjects(), 20, 21),
				UtilMetadata.genMessage(R_11000104020000.value,
						UtilMetadata.genPlusDesc(getObjects(), 18, 19) + "-" + UtilMetadata.genMinusDesc(getObjects(), 20, 21)));
	}

	public static SegmentValidation genRowValidation019B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000104020000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101020000.getKey(), R_11000104020000.value);
	}

	public static SegmentValidation genRowValidation019C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000104020000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101020000.getKey(), R_11000104020000.value);
	}

	public static SegmentValidation genRowValidation019D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000104020000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101020000.getKey(), R_11000104020000.value);
	}

	public static SegmentValidation genRowValidation020A() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_2.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000104020100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000104020100.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation020B() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_2.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000104020100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000104020100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation023A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000104020400.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101020200.getKey(), R_11000104020400.value);
	}

	public static SegmentValidation genRowValidation023B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000104020400.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101020200.getKey(), R_11000104020400.value);
	}

	public static SegmentValidation genRowValidation023C() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000104020400.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101020200.getKey(), R_11000104020400.value);
	}

	public static SegmentValidation genRowValidation023D() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_2.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000104020400.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000104020400.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation023E() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_2.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000104020400.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000104020400.value, messageForm2100BNonRupiah(kegiatan)));
	}
	
	public static SegmentValidation genRowValidation024A() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_11000104030000.key,
				UtilMetadata.genPlusRow(getObjects(), 23, 24) + "-" + UtilMetadata.genMinusRow(getObjects(), 25, 26),
				UtilMetadata.genMessage(R_11000104030000.value,
						UtilMetadata.genPlusDesc(getObjects(), 23, 24) + "-" + UtilMetadata.genMinusDesc(getObjects(), 25, 26)));
	}

	public static SegmentValidation genRowValidation024B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000104030000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101030000.getKey(), R_11000104030000.value);
	}

	public static SegmentValidation genRowValidation024C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000104030000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101030000.getKey(), R_11000104030000.value);
	}

	public static SegmentValidation genRowValidation024D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000104030000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101030000.getKey(), R_11000104030000.value);
	}

	public static SegmentValidation genRowValidation025A() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_3.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000104030100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000104030100.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation025B() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_3.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000104030100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000104030100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation028A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000104030400.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101030200.getKey(), R_11000104030400.value);
	}

	public static SegmentValidation genRowValidation028B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000104030400.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101030200.getKey(), R_11000104030400.value);
	}

	public static SegmentValidation genRowValidation028C() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000104030400.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101030200.getKey(), R_11000104030400.value);
	}

	public static SegmentValidation genRowValidation028D() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_3.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000104030400.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000104030400.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation028E() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_3.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000104030400.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000104030400.value, messageForm2100BNonRupiah(kegiatan)));
	}
	
	public static SegmentValidation genRowValidation029A() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_11000105000000.key,
				UtilMetadata.genPlusRow(getObjects(), 28, 29) + "-" + UtilMetadata.genMinusRow(getObjects(), 30, 31),
				UtilMetadata.genMessage(R_11000105000000.value,
						UtilMetadata.genPlusDesc(getObjects(), 28, 29) + "-" + UtilMetadata.genMinusDesc(getObjects(), 30, 31)));
	}

	public static SegmentValidation genRowValidation029B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000105000000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101040000.getKey(), R_11000105000000.value);
	}

	public static SegmentValidation genRowValidation029C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000105000000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101040000.getKey(), R_11000105000000.value);
	}

	public static SegmentValidation genRowValidation029D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000105000000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101040000.getKey(), R_11000105000000.value);
	}

	public static SegmentValidation genRowValidation030A() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_4.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000105010000.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000105010000.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation030B() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_4.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000105010000.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000105010000.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation033A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000105040000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101040200.getKey(), R_11000105040000.value);
	}

	public static SegmentValidation genRowValidation033B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000105040000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101040200.getKey(), R_11000105040000.value);
	}

	public static SegmentValidation genRowValidation033C() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000105040000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101040200.getKey(), R_11000105040000.value);
	}

	public static SegmentValidation genRowValidation033D() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_4.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000105040000.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000105040000.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation033E() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_4.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000105040000.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000105040000.value, messageForm2100BNonRupiah(kegiatan)));
	}
	
	public static SegmentValidation genRowValidation034A() {
		return UtilSegmentValidation.genEqualsFormula("2|3", R_11000106000000.key,
				UtilMetadata.genPlusRow(getObjects(), 33, 34) + "-" + UtilMetadata.genMinusRow(getObjects(), 35, 36),
				UtilMetadata.genMessage(R_11000106000000.value,
						UtilMetadata.genPlusDesc(getObjects(), 33, 34) + "-" + UtilMetadata.genMinusDesc(getObjects(), 35, 36)));
	}

	public static SegmentValidation genRowValidation034B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000106000000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101050000.getKey(), R_11000106000000.value);
	}

	public static SegmentValidation genRowValidation034C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000106000000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101050000.getKey(), R_11000106000000.value);
	}

	public static SegmentValidation genRowValidation034D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000106000000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101050000.getKey(), R_11000106000000.value);
	}

	public static SegmentValidation genRowValidation035A() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_5.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000106010000.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000106010000.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation035B() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_5.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000106010000.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000106010000.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation038A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000106040000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101050200.getKey(), R_11000106040000.value);
	}

	public static SegmentValidation genRowValidation038B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000106040000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101050200.getKey(), R_11000106040000.value);
	}

	public static SegmentValidation genRowValidation038C() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000106040000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101050200.getKey(), R_11000106040000.value);
	}

	public static SegmentValidation genRowValidation038D() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_5.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000106040000.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000106040000.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation038E() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_5.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000106040000.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000106040000.value, messageForm2100BNonRupiah(kegiatan)));
	}
	
	public static SegmentValidation genRowValidation039A() {
		int[] fields = new int[] { 38, 50, 57, 61, 65 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_11000107000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation039B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107000000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101060000.getKey(), R_11000107000000.value);
	}

	public static SegmentValidation genRowValidation039C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107000000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101060000.getKey(), R_11000107000000.value);
	}

	public static SegmentValidation genRowValidation039D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107000000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101060000.getKey(), R_11000107000000.value);
	}
	
	public static SegmentValidation genRowValidation040A() {
		int[] fields = new int[] { 39, 47 };
		return UtilSegmentValidation.genEqualsFormula("2|3", R_11000107010000.key,
				UtilMetadata.genPlusRow(getObjects(), fields) + "-" + UtilMetadata.genMinusRow(getObjects(), 48, 49),
				UtilMetadata.genMessage(R_11000107010000.value,
						UtilMetadata.genPlusDesc(getObjects(), fields) + "-" + UtilMetadata.genMinusDesc(getObjects(), 48, 49)));
	}

	public static SegmentValidation genRowValidation040B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107010000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101060100.getKey(), R_11000107010000.value);
	}

	public static SegmentValidation genRowValidation040C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107010000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101060100.getKey(), R_11000107010000.value);
	}

	public static SegmentValidation genRowValidation040D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107010000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101060100.getKey(), R_11000107010000.value);
	}
	
	public static SegmentValidation genRowValidation041A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107010100.key,
				UtilMetadata.genPlusRow(getObjects(), 40, 46), 
				UtilMetadata.genMessage(R_11000107010100.value, UtilMetadata.genPlusDesc(getObjects(), 40, 46)));
	}

	public static SegmentValidation genRowValidation041B() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_6.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107010100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107010100.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation041C() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_6.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107010100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107010100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation051A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107010400.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101060102.getKey(), R_11000107010400.value);
	}

	public static SegmentValidation genRowValidation051B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107010400.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101060102.getKey(), R_11000107010400.value);
	}

	public static SegmentValidation genRowValidation051C() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107010400.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101060102.getKey(), R_11000107010400.value);
	}

	public static SegmentValidation genRowValidation051D() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_6.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107010400.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107010400.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation051E() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_6.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107010400.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107010400.value, messageForm2100BNonRupiah(kegiatan)));
	}
	
	public static SegmentValidation genRowValidation052A() {
		int[] fields = new int[] { 51, 55, 56 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107020000.key,
				UtilMetadata.genMinusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_11000107020000.value, UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation052B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107020000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101060200.getKey(), R_11000107020000.value);
	}

	public static SegmentValidation genRowValidation052C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107020000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101060200.getKey(), R_11000107020000.value);
	}

	public static SegmentValidation genRowValidation052D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107020000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101060200.getKey(), R_11000107020000.value);
	}
	
	public static SegmentValidation genRowValidation053A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107020100.key,
				UtilMetadata.genPlusRow(getObjects(), 52, 54), 
				UtilMetadata.genMessage(R_11000107020100.value, UtilMetadata.genPlusDesc(getObjects(), 52, 54)));
	}


	public static SegmentValidation genRowValidation053B() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_7.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107020100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107020100.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation053C() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_7.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107020100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107020100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation058A() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_7.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107020300.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107020300.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation058B() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_7.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107020300.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107020300.value, messageForm2100BNonRupiah(kegiatan)));
	}
	
	public static SegmentValidation genRowValidation059A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107030000.key,
				UtilMetadata.genMinusRow(getObjects(), 58, 60), 
				UtilMetadata.genMessage(R_11000107030000.value, UtilMetadata.genMinusDesc(getObjects(), 58, 60)));
	}

	public static SegmentValidation genRowValidation059B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107030000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101060300.getKey(), R_11000107030000.value);
	}

	public static SegmentValidation genRowValidation059C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107030000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101060300.getKey(), R_11000107030000.value);
	}

	public static SegmentValidation genRowValidation059D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107030000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101060300.getKey(), R_11000107030000.value);
	}

	public static SegmentValidation genRowValidation060A() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_8.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107030100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107030100.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation060B() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_8.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107030100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107030100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation062A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107030300.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101060302.getKey(), R_11000107030300.value);
	}

	public static SegmentValidation genRowValidation062B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107030300.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101060302.getKey(), R_11000107030300.value);
	}

	public static SegmentValidation genRowValidation062C() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107030300.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101060302.getKey(), R_11000107030300.value);
	}

	public static SegmentValidation genRowValidation062D() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_8.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107030300.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107030300.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation062E() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_8.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107030300.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107030300.value, messageForm2100BNonRupiah(kegiatan)));
	}
	
	public static SegmentValidation genRowValidation063A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107040000.key,
				UtilMetadata.genMinusRow(getObjects(), 62, 64), 
				UtilMetadata.genMessage(R_11000107040000.value, UtilMetadata.genMinusDesc(getObjects(), 62, 64)));
	}

	public static SegmentValidation genRowValidation063B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107040000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101060400.getKey(), R_11000107040000.value);
	}

	public static SegmentValidation genRowValidation063C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107040000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101060400.getKey(), R_11000107040000.value);
	}

	public static SegmentValidation genRowValidation063D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107040000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101060400.getKey(), R_11000107040000.value);
	}

	public static SegmentValidation genRowValidation064A() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_9.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107040100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107040100.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation064B() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_9.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107040100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107040100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation066A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107040300.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101060402.getKey(), R_11000107040300.value);
	}

	public static SegmentValidation genRowValidation066B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107040300.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101060402.getKey(), R_11000107040300.value);
	}

	public static SegmentValidation genRowValidation066C() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107040300.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101060402.getKey(), R_11000107040300.value);
	}

	public static SegmentValidation genRowValidation066D() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_9.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107040300.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107040300.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation066E() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_9.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107040300.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107040300.value, messageForm2100BNonRupiah(kegiatan)));
	}
	
	public static SegmentValidation genRowValidation067A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107050000.key,
				UtilMetadata.genMinusRow(getObjects(), 66, 68), 
				UtilMetadata.genMessage(R_11000107050000.value,
						UtilMetadata.genMinusDesc(getObjects(), 66, 68)));
	}

	public static SegmentValidation genRowValidation067B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107050000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101060500.getKey(), R_11000107050000.value);
	}

	public static SegmentValidation genRowValidation067C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107050000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101060500.getKey(), R_11000107050000.value);
	}

	public static SegmentValidation genRowValidation067D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107050000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101060500.getKey(), R_11000107050000.value);
	}

	public static SegmentValidation genRowValidation068A() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_10.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107050100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107050100.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation068B() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_10.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107050100.key, "18",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107050100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation070A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107050300.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100101060502.getKey(), R_11000107050300.value);
	}

	public static SegmentValidation genRowValidation070B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107050300.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100101060502.getKey(), R_11000107050300.value);
	}

	public static SegmentValidation genRowValidation070C() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107050300.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100101060502.getKey(), R_11000107050300.value);
	}

	public static SegmentValidation genRowValidation070D() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_10.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107050300.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13|21", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107050300.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation070E() {
		String kegiatan = ER1142JenisKegiatanUsahaYangDilakukan.R_10.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107050300.key, "36+37+38",
				ER3013PosLbPpik2100.R_2100010000.getFormKey(), "13", kegiatan, "21", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107050300.value, messageForm2100BNonRupiah(kegiatan)));
	}
	
	public static SegmentValidation genRowValidation071() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000108000000.key,
				UtilMetadata.genMinusRow(getObjects(), 70, 72), 
				UtilMetadata.genMessage(R_11000108000000.value, UtilMetadata.genMinusDesc(getObjects(), 70, 72)));
	}

	public static SegmentValidation genRowValidation075A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000109000000.key,
				UtilMetadata.genPlusRow(getObjects(), 74, 75), 
				UtilMetadata.genMessage(R_11000109000000.value, UtilMetadata.genPlusDesc(getObjects(), 74, 75)));
	}

	public static SegmentValidation genRowValidation075B() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_11000109000000.key, "12",
				ER3016PosLbPpik2300.R_2300010000.getFormKey(), "8", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000109000000.value, "Kolom nilai penyertaan modal periode laporan (rupiah) pada form 2300"));
	}

	public static SegmentValidation genRowValidation075C() {
		return UtilSegmentValidation.genEqualsFormulaFormNotEquals("3", R_11000109000000.key, "12",
				ER3016PosLbPpik2300.R_2300010000.getFormKey(), "8", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000109000000.value, "Kolom nilai penyertaan modal periode laporan (selain rupiah) pada form 2300"));
	}
	
	public static SegmentValidation genRowValidation078() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000110000000.key,
				UtilMetadata.genPlusRow(getObjects(), 77, 79), 
				UtilMetadata.genMessage(R_11000110000000.value, UtilMetadata.genPlusDesc(getObjects(), 77, 79)));
	}

	public static SegmentValidation genRowValidation080A() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_11000110020000.key, "10",
				ER3017PosLbPpik2350.R_2350010000.getFormKey(), "6", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000110020000.value, "Kolom nilai proyek berdasarkan tagihan (rupiah) pada form 2350"));
	}

	public static SegmentValidation genRowValidation080B() {
		return UtilSegmentValidation.genEqualsFormulaFormNotEquals("3", R_11000110020000.key, "10",
				ER3017PosLbPpik2350.R_2350010000.getFormKey(), "6", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000110020000.value, "Kolom nilai proyek berdasarkan tagihan (selain rupiah) pada form 2350"));
	}
	
	public static SegmentValidation genRowValidation082() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000111000000.key,
				UtilMetadata.genMinusRow(getObjects(), 81, 82), 
				UtilMetadata.genMessage(R_11000111000000.value, UtilMetadata.genMinusDesc(getObjects(), 81, 82)));
	}
	
	public static SegmentValidation genRowValidation085() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000112000000.key,
				UtilMetadata.genMinusRow(getObjects(), 84, 85), 
				UtilMetadata.genMessage(R_11000112000000.value, UtilMetadata.genMinusDesc(getObjects(), 84, 85)));
	}

	public static SegmentValidation genRowValidation089A() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_11000114000000.key, "4",
				ER3019PosLbPpik2490.R_2490010000.getFormKey(), "3", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000114000000.value, "Kolom nominal rupa-rupa aset (rupiah) pada form 2490"));
	}

	public static SegmentValidation genRowValidation089B() {
		return UtilSegmentValidation.genEqualsFormulaFormNotEquals("3", R_11000114000000.key, "4",
				ER3019PosLbPpik2490.R_2490010000.getFormKey(), "3", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000114000000.value, "Kolom nominal rupa-rupa aset (selain rupiah) pada form 2490"));
	}
	
	public static SegmentValidation genRowValidation090A() {
		int[] fields = new int[] { 0, 9, 10, 11, 37, 69, 73, 76, 80, 83, 86, 87 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000200000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_11000200000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation090B() {
		return UtilSegmentValidation.genEqualRowColumn("4", R_11000200000000.key, "4", R_11000400000000.key, 
				UtilMetadata.genMessage(R_11000200000000.value, R_11000400000000.value));
	}

	public static SegmentValidation genRowValidation090C() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000200000000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100200000000.getKey(), R_11000200000000.value);
	}

	public static SegmentValidation genRowValidation090D() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000200000000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100200000000.getKey(), R_11000200000000.value);
	}

	public static SegmentValidation genRowValidation090E() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000200000000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100200000000.getKey(), R_11000200000000.value);
	}
	
	public static SegmentValidation genRowValidation091() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000301000000.key,
				UtilMetadata.genPlusRow(getObjects(), 90, 94), 
				UtilMetadata.genMessage(R_11000301000000.value, UtilMetadata.genPlusDesc(getObjects(), 90, 94)));
	}
	
	public static SegmentValidation genRowValidation099A() {
		int[] fields = new int[] { 98, 102, 103, 106 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000304000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000304000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation099B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000304000000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100301000000.getKey(), R_11000304000000.value);
	}

	public static SegmentValidation genRowValidation099C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000304000000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100301000000.getKey(), R_11000304000000.value);
	}

	public static SegmentValidation genRowValidation099D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000304000000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100301000000.getKey(), R_11000304000000.value);
	}
	
	public static SegmentValidation genRowValidation100() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000304010000.key,
				UtilMetadata.genPlusRow(getObjects(), 99, 101),
				UtilMetadata.genMessage(R_11000304010000.value, 
						UtilMetadata.genPlusDesc(getObjects(), 99, 101)));
	}

	public static SegmentValidation genRowValidation101A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304010100.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "5|6",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getPmrnthPst(), "3",
				ER1132JenisPinjaman.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304010100.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.PMRNTH_PST, true)));
	}

	public static SegmentValidation genRowValidation101B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304010100.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "6", ER1140GolonganPihakLawan2550.getPmrnthPst(), "3|5",
				ER1132JenisPinjaman.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(), UtilMetadata.genMessageTotal(
						R_11000304010100.value, messageForm2550A(ER1140GolonganPihakLawan2550.PMRNTH_PST, false)));
	}

	public static SegmentValidation genRowValidation102A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304010200.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "5|6",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getPmrnthDrh(), "3",
				ER1132JenisPinjaman.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304010200.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.PMRNTH_DRH, true)));
	}

	public static SegmentValidation genRowValidation102B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304010200.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "6", ER1140GolonganPihakLawan2550.getPmrnthDrh(), "3|5",
				ER1132JenisPinjaman.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(), UtilMetadata.genMessageTotal(
						R_11000304010200.value, messageForm2550A(ER1140GolonganPihakLawan2550.PMRNTH_DRH, false)));
	}

	public static SegmentValidation genRowValidation103A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304010300.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "5|6",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getPmrnthSng(), "3",
				ER1132JenisPinjaman.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304010300.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.PMRNTH_SNG, true)));
	}

	public static SegmentValidation genRowValidation103B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304010300.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "6", ER1140GolonganPihakLawan2550.getPmrnthSng(), "3|5",
				ER1132JenisPinjaman.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(), UtilMetadata.genMessageTotal(
						R_11000304010300.value, messageForm2550A(ER1140GolonganPihakLawan2550.PMRNTH_SNG, false)));
	}

	public static SegmentValidation genRowValidation104A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304020000.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "5|6",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getOrgnsiMltltrl(), "3",
				ER1132JenisPinjaman.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304020000.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.ORGNSI_MLTLTRL, true)));
	}

	public static SegmentValidation genRowValidation104B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304020000.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "6", ER1140GolonganPihakLawan2550.getOrgnsiMltltrl(),
				"3|5", ER1132JenisPinjaman.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000304020000.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.ORGNSI_MLTLTRL, false)));
	}
	
	public static SegmentValidation genRowValidation105() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000304030000.key,
				UtilMetadata.genPlusRow(getObjects(), 104, 105),
				UtilMetadata.genMessage(R_11000304030000.value, UtilMetadata.genPlusDesc(getObjects(), 104, 105)));
	}

	public static SegmentValidation genRowValidation106A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304030100.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "5|6",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getBnkDn(), "3",
				ER1132JenisPinjaman.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304030100.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.BNK_DN, true)));
	}

	public static SegmentValidation genRowValidation106B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304030100.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "6", ER1140GolonganPihakLawan2550.getBnkDn(), "3|5",
				ER1132JenisPinjaman.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(), UtilMetadata.genMessageTotal(
						R_11000304030100.value, messageForm2550A(ER1140GolonganPihakLawan2550.BNK_DN, false)));
	}

	public static SegmentValidation genRowValidation107A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304030200.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "5|6",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getBnkLn(), "3",
				ER1132JenisPinjaman.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304030200.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.BNK_LN, true)));
	}

	public static SegmentValidation genRowValidation107B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304030200.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "6", ER1140GolonganPihakLawan2550.getBnkLn(), "3|5",
				ER1132JenisPinjaman.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(), UtilMetadata.genMessageTotal(
						R_11000304030200.value, messageForm2550A(ER1140GolonganPihakLawan2550.BNK_LN, false)));
	}
	
	public static SegmentValidation genRowValidation108() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000304040000.key,
				UtilMetadata.genPlusRow(getObjects(), 107, 108),
				UtilMetadata.genMessage(R_11000304040000.value, UtilMetadata.genPlusDesc(getObjects(), 107, 108)));
	}

	public static SegmentValidation genRowValidation109A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304040100.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "5|6",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getLjknbDn(), "3",
				ER1132JenisPinjaman.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304040100.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.LJKNB_DN, true)));
	}

	public static SegmentValidation genRowValidation109B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304040100.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "6", ER1140GolonganPihakLawan2550.getLjknbDn(), "3|5",
				ER1132JenisPinjaman.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(), UtilMetadata.genMessageTotal(
						R_11000304040100.value, messageForm2550A(ER1140GolonganPihakLawan2550.LJKNB_DN, false)));
	}

	public static SegmentValidation genRowValidation110A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304040200.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "5|6",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getLjknbLn(), "3",
				ER1132JenisPinjaman.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304040200.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.LJKNB_LN, true)));
	}

	public static SegmentValidation genRowValidation110B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304040200.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "6", ER1140GolonganPihakLawan2550.getLjknbLn(), "3|5",
				ER1132JenisPinjaman.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(), UtilMetadata.genMessageTotal(
						R_11000304040200.value, messageForm2550A(ER1140GolonganPihakLawan2550.LJKNB_LN, false)));
	}

	public static SegmentValidation genRowValidation111A() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_11000305000000.key, "13",
				ER3021PosLbPpik2600.R_2600010000.getFormKey(), "4", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000305000000.value, "Kolom surat berharga yang diterbitkan (rupiah) pada form 2600"));
	}

	public static SegmentValidation genRowValidation111B() {
		return UtilSegmentValidation.genEqualsFormulaFormNotEquals("3", R_11000305000000.key, "13",
				ER3021PosLbPpik2600.R_2600010000.getFormKey(), "4", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000305000000.value, "Kolom surat berharga yang diterbitkan (selain rupiah) pada form 2600"));
	}

	public static SegmentValidation genRowValidation111C() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000305000000.key, EFormLaporanBulanan.LB_5310.getCode(), "8",
				ER3024PosLbPpik5310.R_53100302000000.getKey(), R_11000305000000.value);
	}

	public static SegmentValidation genRowValidation111D() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000305000000.key, EFormLaporanBulanan.LB_5310.getCode(), "15",
				ER3024PosLbPpik5310.R_53100302000000.getKey(), R_11000305000000.value);
	}

	public static SegmentValidation genRowValidation111E() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000305000000.key, EFormLaporanBulanan.LB_5310.getCode(), "16",
				ER3024PosLbPpik5310.R_53100302000000.getKey(), R_11000305000000.value);
	}
	
	public static SegmentValidation genRowValidation114() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000308000000.key,
				UtilMetadata.genPlusRow(getObjects(), 113, 114),
				UtilMetadata.genMessage(R_11000308000000.value, UtilMetadata.genPlusDesc(getObjects(), 113, 114)));
	}

	public static SegmentValidation genRowValidation115A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000308010000.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "3|5|19",
				ER1132JenisPinjaman.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey() + "|" + ER1126Negara.R_1.getKey(),
						UtilMetadata.genMessageTotal(R_11000308010000.value, messageForm2550B(true, true)));
	}

	public static SegmentValidation genRowValidation115B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000308010000.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "3|19",
				ER1132JenisPinjaman.R_4.getKey() + "|" + ER1126Negara.R_1.getKey(), "5", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000308010000.value, messageForm2550B(true, false)));
	}

	public static SegmentValidation genRowValidation116A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000308020000.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "3|5",
				ER1132JenisPinjaman.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(), "19",
				ER1126Negara.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000308020000.value, messageForm2550B(false, true)));
	}

	public static SegmentValidation genRowValidation116B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000308020000.key, "17",
				ER3020PosLbPpik2550.R_2550010000.getFormKey(), "3", ER1132JenisPinjaman.R_4.getKey(), "5|19",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1126Negara.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000308020000.value, messageForm2550B(false, false)));
	}

	public static SegmentValidation genRowValidation118A() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_11000309000000.key, "4",
				ER3022PosLbPpik2790.R_2790010000.getFormKey(), "3", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000309000000.value, "Kolom nominal (rupiah) pada form 2790"));
	}

	public static SegmentValidation genRowValidation118B() {
		return UtilSegmentValidation.genEqualsFormulaFormNotEquals("3", R_11000309000000.key, "4",
				ER3022PosLbPpik2790.R_2790010000.getFormKey(), "3", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000309000000.value, "Kolom nominal (selain rupiah) pada form 2790"));
	}
	
	public static SegmentValidation genRowValidation119() {
		int[] fields = new int[] { 118, 121 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000310000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields) + "-" + R_11000310030000.key + "+" + R_11000310040000.key
						+ "-" + R_11000310050000.key,
				UtilMetadata.genMessage(R_11000310000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)) + "-'"
						+ R_11000310030000.value + "'+'" + R_11000310040000.value + "'-'" + R_11000310050000.value
						+ "'");
	}
	
	public static SegmentValidation genRowValidation120A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000310010000.key,
				UtilMetadata.genMinusRow(getObjects(), 119, 120),
				UtilMetadata.genMessage(R_11000310010000.value, UtilMetadata.genMinusDesc(getObjects(), 119, 120)));
	}
	
	public static SegmentValidation genRowValidation120B() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000310010000.key, EFormLaporanBulanan.LB_0030.getCode(), "9",
				ER3003PosLbPpik0030.R_0030010000.getKey(), R_11000310010000.value);
	}
	
	public static SegmentValidation genRowValidation123() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000310020000.key,
				UtilMetadata.genPlusRow(getObjects(), 122, 125),
				UtilMetadata.genMessage(R_11000310020000.value, UtilMetadata.genPlusDesc(getObjects(), 122, 125)));
	}
	
	public static SegmentValidation genRowValidation131() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000311000000.key,
				UtilMetadata.genPlusRow(getObjects(), 130, 131),
				UtilMetadata.genMessage(R_11000311000000.value, UtilMetadata.genPlusDesc(getObjects(), 130, 131)));
	}
	
	public static SegmentValidation genRowValidation136() {
		int[] fields = new int[] { 135, 141 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000314000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000314000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation137() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000314010000.key,
				UtilMetadata.genPlusRow(getObjects(), 136, 140),
				UtilMetadata.genMessage(R_11000314010000.value, UtilMetadata.genPlusDesc(getObjects(), 136, 140)));
	}
	
	public static SegmentValidation genRowValidation144() {
		int[] fields = new int[] { 89, 95, 96, 97, 109, 110, 111, 112, 115, 116, 117, 129, 132, 133, 134 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000400000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000400000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	private static String messageForm2100ARupiah(String kodeKegiatan) {
		return messageForm2100A(kodeKegiatan, true);
	}
	
	private static String messageForm2100ANonRupiah(String kodeKegiatan) {
		return messageForm2100A(kodeKegiatan, false);
	}
	
	private static String messageForm2100A(String kodeKegiatan, boolean isRupiah) {
		return "Tagihan piutang pembiayaan bruto dalam ekuivalen rupiah dengan [dimensi Jenis Pembiayaan terisi "  + kodeKegiatan + "] (" + getOther(isRupiah) + "rupiah) pada form 2100";
	}
	
	private static String messageForm2100BRupiah(String kodeKegiatan) {
		return messageForm2100B(kodeKegiatan, true);
	}
	
	private static String messageForm2100BNonRupiah(String kodeKegiatan) {
		return messageForm2100B(kodeKegiatan, false);
	}
	
	private static String messageForm2100B(String kodeKegiatan, boolean isRupiah) {
		return "Kolom Nilai CKPN Aset Baik + Nilai CKPN Aset Kurang Baik + Nilai CKPN Aset Tidak Baik dengan [dimensi Jenis Pembiayaan terisi "  + kodeKegiatan + "] (" + getOther(isRupiah) + "rupiah) pada form 2100";
	}
	
	private static String messageForm2550A(String kodeKreditur, boolean isRupiah) {
		return "Kolom [Saldo Pinjaman/Pendanaan yang Diterima] dengan  dimensi [Jenis Pinjaman/Pendanaan terisi selain Pinjaman Subordinasi (SF:e8)] dan Golongan Kreditur terisi sandi yang termasuk " + kodeKreditur + " (" + getOther(isRupiah) + "rupiah) pada form 2550";
	}
	
	private static String messageForm2550B(boolean isIndonesia, boolean isRupiah) {
		return "Kolom [Saldo Pinjaman/Pendanaan yang Diterima] dengan  dimensi [Jenis Pinjaman/Pendanaan terisi Pinjaman Subordinasi (SF:e8)] dan Lokasi Negara Pihak Lawan terisi " + getOther(isIndonesia) + "Indonesia (LO:ID) (" + getOther(isRupiah) + "rupiah) pada form 2550";
	}
	
	private static String getOther(boolean isTrue) {
		return (isTrue ? "" : "selain ");
	}
}
