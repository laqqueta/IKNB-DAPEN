package id.go.ojk.ppik.client.builder.field.lb.uus.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.field.FieldValidation;
import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.conf.client.field.reference.ER1122JenisValuta;
import id.go.ojk.conf.client.field.reference.ER1126Negara;
import id.go.ojk.conf.client.field.reference.ER1140GolonganPihakLawan2550;
import id.go.ojk.conf.client.field.reference.ER1141JenisKegiatanUsahaSyariahYangDilakukan;
import id.go.ojk.conf.client.field.reference.ER1150JenisPinjamanSyariah;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulananUus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3108PosLbPpiu1100 implements IObject<KeyValueString> {
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
	R_11000107040000 ("11000107040000", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan Berdasarkan Prinsip Syariah Neto "),
	R_11000107040100 ("11000107040100", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuanga Berdasarkan Prinsip Syaria Bruto"),
	R_11000107040200 ("11000107040200", "Pendapatan dan Biaya Lainny sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000107040300 ("11000107040300", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Berkaitan dengan Pembiayaan Infrastruktur Setelah Memperoleh Persetujuan Otoritas Jasa Keuangan Berdasarkan Prinsip Syariah"),
	R_11000107050000 ("11000107050000", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Berdasarkan Prinsip Syariah Neto"),
	R_11000107050100 ("11000107050100", "Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Berdasarkan Prinsip Syariah Bruto"),
	R_11000107050200 ("11000107050200", "Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000107050300 ("11000107050300", "Cadangan Penyisihan Penghapusan Piutang Pembiayaan Kegiatan atau Pemberian Fasilitas Pembiayaan Lain yang Tidak Berkaitan dengan Pembiayaan Infrastruktur Berdasarkan Penugasan Pemerintah Berdasarkan Prinsip Syariah"),
	R_11000108000000 ("11000108000000", "Aset Ijarah"),
	R_11000108010000 ("11000108010000", "Aset Ijarah Bruto"),
	R_11000108020000 ("11000108020000", "Pendapatan dan Biaya Lainnya sehubungan Transaksi Pembiayaan yang Diamortisasi"),
	R_11000108030000 ("11000108030000", "Akumulasi Penyusutan"),
	R_11000109000000 ("11000109000000", "Penyertaan Modal"),
	R_11000109010000 ("11000109010000", "Penyertaan Modal pada Perusahaan di Sektor Jasa Keuangan"),
	R_11000109020000 ("11000109020000", "Penyertaan Modal pada Perusahaan yang Bergerak dalam Proyek Infrastruktur"),
	R_11000110000000 ("11000110000000", "Tagihan terkait Kegiatan Usaha Lain:"),
	R_11000110010000 ("11000110010000", "Tagihan terkait Pemberian Dukungan Pembiayaan"),
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
	R_11000304000000 ("11000304000000", "Pendanaan Yang Diterima"),
	R_11000304010000 ("11000304010000", "Pendanaan yang Diterima dari Pemerintah"),
	R_11000304010100 ("11000304010100", "Pendanaan yang Diterima dari Pemerintah Pusat"),
	R_11000304010200 ("11000304010200", "Pendanaan yang Diterima dari Pemerintah Daerah"),
	R_11000304010300 ("11000304010300", "Pendanaan yang Diterima dari Pemerintah Asing"),
	R_11000304020000 ("11000304020000", "Pendanaan yang Diterima dari Organisasi Multilateral"),
	R_11000304030000 ("11000304030000", "Pendanaan yang Diterima dari Bank"),
	R_11000304030100 ("11000304030100", "Pendanaan Yang Diterima Dari Bank Dalam Negeri"),
	R_11000304030200 ("11000304030200", "Pendanaan Yang Diterima Dari Bank Luar Negeri"),
	R_11000304040000 ("11000304040000", "Pendanaan yang Diterima dari Lembaga Keuangan non Bank"),
	R_11000304040100 ("11000304040100", "Pendanaan yang Diterima dari Lembaga Keuangan non Bank Dalam Negeri"),
	R_11000304040200 ("11000304040200", "Pendanaan yang Diterima dari Lembaga Keuangan non Bank Luar Negeri"),
	R_11000305000000 ("11000305000000", "Surat Berharga Syariah yang Diterbitkan"),
	R_11000306000000 ("11000306000000", "Liabilitas Imbalan Pasca Kerja"),
	R_11000307000000 ("11000307000000", "Liabilitas Pajak Tangguhan"),
	R_11000308000000 ("11000308000000", "Pendanaan Subordinasi"),
	R_11000308010000 ("11000308010000", "Pendanaan Subordinasi Dalam Negeri"),
	R_11000308020000 ("11000308020000", "Pendanaan Subordinasi Luar Negeri"),
	R_11000309000000 ("11000309000000", "Rupa-Rupa Liabilitas"),
	R_11000315000000 ("11000315000000", "Dana Syirkah Temporer"),
	R_11000315000100 ("11000315000100", "Sukuk Mudharabah"),
	R_11000315000200 ("11000315000200", "Pendanaan Mudharabah"),
	R_11000315000300 ("11000315000300", "Pendanaan Musyarakah"),
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
		return EFormLaporanBulananUus.LB_1100.getCode() + key;
	}
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}
	
	public KeyValueString getFormObject() {
		return new KeyValueString(getFormKey(), value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3108PosLbPpiu1100 eEnum : ER3108PosLbPpiu1100.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}

	public static List<KeyValueString> getFormObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3108PosLbPpiu1100 eEnum : ER3108PosLbPpiu1100.values()) {
			res.add(eEnum.getFormObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER3108PosLbPpiu1100.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER3108PosLbPpiu1100.class.getSimpleName().substring(2, 6));
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
				UtilMetadata.genMessage(R_11000101020000.value, UtilMetadata.genPlusDesc(getObjects(), 6, 7)));
	}

	public static SegmentValidation genRowValidation011A() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_11000102000000.key, "13",
				ER3114PosLbPpiu2200.R_2200010000.getFormKey(), "7", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessage(R_11000102000000.value, "Akumulasi nilai kolom Saldo Akhir (rupiah) pada form 2200"));
	}

	public static SegmentValidation genRowValidation011B() {
		return UtilSegmentValidation.genEqualsFormulaFormNotEquals("3", R_11000102000000.key, "13",
				ER3114PosLbPpiu2200.R_2200010000.getFormKey(), "7", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessage(R_11000102000000.value, "Akumulasi nilai kolom Saldo Akhir (selain rupiah) pada form 2200"));
	}
	
	public static SegmentValidation genRowValidation013A() {
		int[] fields = new int[] { 12, 24, 31, 35, 39 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_11000107000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation013B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "8",
				ER3123PosLbPpiu5310.R_53100101060000.getKey(), R_11000107000000.value);
	}

	public static SegmentValidation genRowValidation013C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "15",
				ER3123PosLbPpiu5310.R_53100101060000.getKey(), R_11000107000000.value);
	}

	public static SegmentValidation genRowValidation013D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "16",
				ER3123PosLbPpiu5310.R_53100101060000.getKey(), R_11000107000000.value);
	}
	
	public static SegmentValidation genRowValidation014A() {
		int[] fields1 = new int[] { 13, 21 };
		int[] fields2 = new int[] { 22, 23 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107010000.key,
				UtilMetadata.genPlusRow(getObjects(), fields1) + "-" + UtilMetadata.genMinusRow(getObjects(), fields2),
				UtilMetadata.genMessage(R_11000107010000.value, UtilMetadata.genPlusDesc(getObjects(), fields1) + "-"
						+ UtilMetadata.genMinusDesc(getObjects(), fields2)));
	}

	public static SegmentValidation genRowValidation014B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107010000.key, EFormLaporanBulananUus.LB_5310.getCode(), "8",
				ER3123PosLbPpiu5310.R_53100101060100.getKey(), R_11000107010000.value);
	}

	public static SegmentValidation genRowValidation014C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107010000.key, EFormLaporanBulananUus.LB_5310.getCode(), "15",
				ER3123PosLbPpiu5310.R_53100101060100.getKey(), R_11000107010000.value);
	}

	public static SegmentValidation genRowValidation014D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107010000.key, EFormLaporanBulananUus.LB_5310.getCode(), "16",
				ER3123PosLbPpiu5310.R_53100101060100.getKey(), R_11000107010000.value);
	}
	
	public static SegmentValidation genRowValidation015A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107010100.key,
				UtilMetadata.genPlusRow(getObjects(), 14, 20), 
				UtilMetadata.genMessage(R_11000107010100.value, UtilMetadata.genPlusDesc(getObjects(), 14, 20)));
	}

	public static SegmentValidation genRowValidation015B() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_1.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107010100.key, "19",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13|22", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107010100.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation015C() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_1.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107010100.key, "19",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13", kegiatan, "22", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107010100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation025A() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107010400.key, EFormLaporanBulananUus.LB_5310.getCode(), "8",
				ER3123PosLbPpiu5310.R_53100101060102.getKey(), R_11000107010400.value);
	}

	public static SegmentValidation genRowValidation025B() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107010400.key, EFormLaporanBulananUus.LB_5310.getCode(), "15",
				ER3123PosLbPpiu5310.R_53100101060102.getKey(), R_11000107010400.value);
	}

	public static SegmentValidation genRowValidation025C() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107010400.key, EFormLaporanBulananUus.LB_5310.getCode(), "16",
				ER3123PosLbPpiu5310.R_53100101060102.getKey(), R_11000107010400.value);
	}

	public static SegmentValidation genRowValidation025D() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_1.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107010400.key, "37+38+39",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13|22", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107010400.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation025E() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_1.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107010400.key, "37+38+39",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13", kegiatan, "22", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107010400.value, messageForm2100BNonRupiah(kegiatan)));
	}
	
	public static SegmentValidation genRowValidation026A() {
		int[] fields = new int[] { 25, 29, 30 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107020000.key,
				UtilMetadata.genMinusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_11000107020000.value, UtilMetadata.genMinusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation026B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107020000.key, EFormLaporanBulananUus.LB_5310.getCode(), "8",
				ER3123PosLbPpiu5310.R_53100101060200.getKey(), R_11000107020000.value);
	}

	public static SegmentValidation genRowValidation026C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107020000.key, EFormLaporanBulananUus.LB_5310.getCode(), "15",
				ER3123PosLbPpiu5310.R_53100101060200.getKey(), R_11000107020000.value);
	}

	public static SegmentValidation genRowValidation026D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107020000.key, EFormLaporanBulananUus.LB_5310.getCode(), "16",
				ER3123PosLbPpiu5310.R_53100101060200.getKey(), R_11000107020000.value);
	}
	
	public static SegmentValidation genRowValidation027A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107020100.key,
				UtilMetadata.genPlusRow(getObjects(), 26, 28), 
				UtilMetadata.genMessage(R_11000107020100.value, UtilMetadata.genPlusDesc(getObjects(), 26, 28)));
	}

	public static SegmentValidation genRowValidation027B() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_2.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107020100.key, "19",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13|22", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107020100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation027C() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_2.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107020100.key, "19",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13", kegiatan, "22", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107020100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation032A() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_2.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107020300.key, "37+38+39",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13|22", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107020300.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation032B() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_2.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107020300.key, "37+38+39",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13", kegiatan, "22", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107020300.value, messageForm2100BNonRupiah(kegiatan)));
	}
	
	public static SegmentValidation genRowValidation033A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107030000.key,
				UtilMetadata.genMinusRow(getObjects(), 32, 34), 
				UtilMetadata.genMessage(R_11000107030000.value, UtilMetadata.genMinusDesc(getObjects(), 32, 34)));
	}

	public static SegmentValidation genRowValidation033B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107030000.key, EFormLaporanBulananUus.LB_5310.getCode(), "8",
				ER3123PosLbPpiu5310.R_53100101060300.getKey(), R_11000107030000.value);
	}

	public static SegmentValidation genRowValidation033C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107030000.key, EFormLaporanBulananUus.LB_5310.getCode(), "15",
				ER3123PosLbPpiu5310.R_53100101060300.getKey(), R_11000107030000.value);
	}

	public static SegmentValidation genRowValidation033D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107030000.key, EFormLaporanBulananUus.LB_5310.getCode(), "16",
				ER3123PosLbPpiu5310.R_53100101060300.getKey(), R_11000107030000.value);
	}

	public static SegmentValidation genRowValidation034A() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_3.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107030100.key, "19",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13|22", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107030100.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation034B() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_3.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107030100.key, "19",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13", kegiatan, "22", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107030100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation036A() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_3.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107030300.key, "37+38+39",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13|22", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107030300.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation036B() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_3.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107030300.key, "37+38+39",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13", kegiatan, "22", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107030300.value, messageForm2100BNonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation036C() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107030300.key, EFormLaporanBulananUus.LB_5310.getCode(), "8",
				ER3123PosLbPpiu5310.R_53100101060302.getKey(), R_11000107030300.value);
	}

	public static SegmentValidation genRowValidation036D() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107030300.key, EFormLaporanBulananUus.LB_5310.getCode(), "15",
				ER3123PosLbPpiu5310.R_53100101060302.getKey(), R_11000107030300.value);
	}

	public static SegmentValidation genRowValidation036E() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107030300.key, EFormLaporanBulananUus.LB_5310.getCode(), "16",
				ER3123PosLbPpiu5310.R_53100101060302.getKey(), R_11000107030300.value);
	}
	
	public static SegmentValidation genRowValidation037A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107040000.key,
				UtilMetadata.genMinusRow(getObjects(), 36, 38), 
				UtilMetadata.genMessage(R_11000107040000.value, UtilMetadata.genMinusDesc(getObjects(), 36, 38)));
	}

	public static SegmentValidation genRowValidation037B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107040000.key, EFormLaporanBulananUus.LB_5310.getCode(), "8",
				ER3123PosLbPpiu5310.R_53100101060400.getKey(), R_11000107040000.value);
	}

	public static SegmentValidation genRowValidation037C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107040000.key, EFormLaporanBulananUus.LB_5310.getCode(), "15",
				ER3123PosLbPpiu5310.R_53100101060400.getKey(), R_11000107040000.value);
	}

	public static SegmentValidation genRowValidation037D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107040000.key, EFormLaporanBulananUus.LB_5310.getCode(), "16",
				ER3123PosLbPpiu5310.R_53100101060400.getKey(), R_11000107040000.value);
	}

	public static SegmentValidation genRowValidation038A() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_4.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107040100.key, "19",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13|22", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107040100.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation038B() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_4.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107040100.key, "19",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13", kegiatan, "22", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107040100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation040A() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_4.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107040300.key, "37+38+39",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13|22", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107040300.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation040B() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_4.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107040300.key, "37+38+39",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13", kegiatan, "22", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107040300.value, messageForm2100BNonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation041A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000107050000.key,
				UtilMetadata.genMinusRow(getObjects(), 40, 42), 
				UtilMetadata.genMessage(R_11000107050000.value, UtilMetadata.genMinusDesc(getObjects(), 40, 42)));
	}

	public static SegmentValidation genRowValidation041B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000107050000.key, EFormLaporanBulananUus.LB_5310.getCode(), "8",
				ER3123PosLbPpiu5310.R_53100101060500.getKey(), R_11000107050000.value);
	}

	public static SegmentValidation genRowValidation041C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000107050000.key, EFormLaporanBulananUus.LB_5310.getCode(), "15",
				ER3123PosLbPpiu5310.R_53100101060500.getKey(), R_11000107050000.value);
	}

	public static SegmentValidation genRowValidation041D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000107050000.key, EFormLaporanBulananUus.LB_5310.getCode(), "16",
				ER3123PosLbPpiu5310.R_53100101060500.getKey(), R_11000107050000.value);
	}

	public static SegmentValidation genRowValidation042A() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_5.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107050100.key, "19",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13|22", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107050100.value, messageForm2100ARupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation042B() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_5.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107050100.key, "19",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13", kegiatan, "22", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107050100.value, messageForm2100ANonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation044A() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_5.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000107050300.key, "37+38+39",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13|22", kegiatan + "|" + ER1122JenisValuta.R_1.getKey(), 
				UtilMetadata.genMessageTotal(R_11000107050300.value, messageForm2100BRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation044B() {
		String kegiatan = ER1141JenisKegiatanUsahaSyariahYangDilakukan.R_5.getKey();
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000107050300.key, "37+38+39",
				ER3112PosLbPpiu2100.R_2100010000.getFormKey(), "13", kegiatan, "22", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000107050300.value, messageForm2100BNonRupiah(kegiatan)));
	}

	public static SegmentValidation genRowValidation045A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000108000000.key,
				UtilMetadata.genMinusRow(getObjects(), 44, 46), 
				UtilMetadata.genMessage(R_11000108000000.value, UtilMetadata.genMinusDesc(getObjects(), 44, 46)));
	}

	public static SegmentValidation genRowValidation045D() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000108000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "8",
				ER3123PosLbPpiu5310.R_53100101060600.getKey(), R_11000108000000.value);
	}

	public static SegmentValidation genRowValidation045E() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000108000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "15",
				ER3123PosLbPpiu5310.R_53100101060600.getKey(), R_11000108000000.value);
	}

	public static SegmentValidation genRowValidation045F() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000108000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "16",
				ER3123PosLbPpiu5310.R_53100101060600.getKey(), R_11000108000000.value);
	}

	public static SegmentValidation genRowValidation049A() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000109000000.key,
				UtilMetadata.genPlusRow(getObjects(), 48, 49), 
				UtilMetadata.genMessage(R_11000109000000.value, UtilMetadata.genPlusDesc(getObjects(), 48, 49)));
	}

	public static SegmentValidation genRowValidation049B() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_11000109000000.key, "12",
				ER3115PosLbPpiu2300.R_2300010000.getFormKey(), "8", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000109000000.value, "Kolom nilai penyertaan modal periode laporan (rupiah) pada form 2300"));
	}

	public static SegmentValidation genRowValidation049C() {
		return UtilSegmentValidation.genEqualsFormulaFormNotEquals("3", R_11000109000000.key, "12",
				ER3115PosLbPpiu2300.R_2300010000.getFormKey(), "8", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000109000000.value, "Kolom nilai penyertaan modal periode laporan (selain rupiah) pada form 2300"));
	}
	
	public static SegmentValidation genRowValidation052() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000110000000.key,
				UtilMetadata.genPlusRow(getObjects(), 51, 53), 
				UtilMetadata.genMessage(R_11000110000000.value, 
						UtilMetadata.genPlusDesc(getObjects(), 51, 53)));
	}

	public static SegmentValidation genRowValidation054A() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_11000110020000.key, "10",
				ER3116PosLbPpiu2350.R_2350010000.getFormKey(), "6", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000110020000.value, "Kolom nilai proyek berdasarkan tagihan (rupiah) pada form 2350"));
	}

	public static SegmentValidation genRowValidation054B() {
		return UtilSegmentValidation.genEqualsFormulaFormNotEquals("3", R_11000110020000.key, "10",
				ER3116PosLbPpiu2350.R_2350010000.getFormKey(), "6", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000110020000.value, "Kolom nilai proyek berdasarkan tagihan (selain rupiah) pada form 2350"));
	}
	
	public static SegmentValidation genRowValidation056() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000111000000.key,
				UtilMetadata.genMinusRow(getObjects(), 55, 56), 
				UtilMetadata.genMessage(R_11000111000000.value, UtilMetadata.genMinusDesc(getObjects(), 55, 56)));
	}
	
	public static SegmentValidation genRowValidation059() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000112000000.key,
				UtilMetadata.genMinusRow(getObjects(), 58, 59), 
				UtilMetadata.genMessage(R_11000112000000.value, UtilMetadata.genMinusDesc(getObjects(), 58, 59)));
	}

	public static SegmentValidation genRowValidation063A() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_11000114000000.key, "4",
				ER3118PosLbPpiu2490.R_2490010000.getFormKey(), "3", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000114000000.value, "Kolom nominal rupa-rupa aset (rupiah) pada form 2490"));
	}

	public static SegmentValidation genRowValidation063B() {
		return UtilSegmentValidation.genEqualsFormulaFormNotEquals("3", R_11000114000000.key, "4",
				ER3118PosLbPpiu2490.R_2490010000.getFormKey(), "3", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000114000000.value, "Kolom nominal rupa-rupa aset (selain rupiah) pada form 2490"));
	}
	
	public static SegmentValidation genRowValidation064A() {
		int[] fields = new int[] { 0, 9, 10, 11, 43, 47, 50, 54, 57, 60, 61 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000200000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields), 
				UtilMetadata.genMessage(R_11000200000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation064B() {
		return UtilSegmentValidation.genEqualRowColumn("4", R_11000200000000.key, "4", R_11000400000000.key, 
				UtilMetadata.genMessage(R_11000200000000.value, R_11000400000000.value));
	}

	public static SegmentValidation genRowValidation064C() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000200000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "8",
				ER3123PosLbPpiu5310.R_53100200000000.getKey(), R_11000200000000.value);
	}

	public static SegmentValidation genRowValidation064D() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000200000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "15",
				ER3123PosLbPpiu5310.R_53100200000000.getKey(), R_11000200000000.value);
	}

	public static SegmentValidation genRowValidation064E() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000200000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "16",
				ER3123PosLbPpiu5310.R_53100200000000.getKey(), R_11000200000000.value);
	}
	
	public static SegmentValidation genRowValidation065() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000301000000.key,
				UtilMetadata.genPlusRow(getObjects(), 65, 69), 
				UtilMetadata.genMessage(R_11000301000000.value, UtilMetadata.genPlusDesc(getObjects(), 65, 69)));
	}
	
	public static SegmentValidation genRowValidation073A() {
		int[] fields = new int[] { 72, 76, 77, 80 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000304000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000304000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}

	public static SegmentValidation genRowValidation073B() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000304000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "8",
				ER3123PosLbPpiu5310.R_53100301000000.getKey(), R_11000304000000.value);
	}

	public static SegmentValidation genRowValidation073C() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000304000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "15",
				ER3123PosLbPpiu5310.R_53100301000000.getKey(), R_11000304000000.value);
	}

	public static SegmentValidation genRowValidation073D() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000304000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "16",
				ER3123PosLbPpiu5310.R_53100301000000.getKey(), R_11000304000000.value);
	}
	
	public static SegmentValidation genRowValidation074() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000304010000.key,
				UtilMetadata.genPlusRow(getObjects(), 73, 75),
				UtilMetadata.genMessage(R_11000304010000.value,
						UtilMetadata.genPlusDesc(getObjects(), 73, 75)));
	}

	public static SegmentValidation genRowValidation075A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304010100.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "6|7",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getPmrnthPst(), "3",
				ER1150JenisPinjamanSyariah.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304010100.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.PMRNTH_PST, true)));
	}

	public static SegmentValidation genRowValidation075B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304010100.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "7", ER1140GolonganPihakLawan2550.getPmrnthPst(), "3|6",
				ER1150JenisPinjamanSyariah.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000304010100.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.PMRNTH_PST, false)));
	}

	public static SegmentValidation genRowValidation076A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304010200.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "6|7",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getPmrnthDrh(), "3",
				ER1150JenisPinjamanSyariah.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304010200.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.PMRNTH_DRH, true)));
	}

	public static SegmentValidation genRowValidation076B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304010200.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "7", ER1140GolonganPihakLawan2550.getPmrnthDrh(), "3|6",
				ER1150JenisPinjamanSyariah.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000304010200.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.PMRNTH_DRH, false)));
	}

	public static SegmentValidation genRowValidation077A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304010300.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "6|7",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getPmrnthSng(), "3",
				ER1150JenisPinjamanSyariah.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304010300.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.PMRNTH_SNG, true)));
	}

	public static SegmentValidation genRowValidation077B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304010300.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "7", ER1140GolonganPihakLawan2550.getPmrnthSng(), "3|6",
				ER1150JenisPinjamanSyariah.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000304010300.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.PMRNTH_SNG, false)));
	}

	public static SegmentValidation genRowValidation078A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304020000.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "6|7",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getOrgnsiMltltrl(), "3",
				ER1150JenisPinjamanSyariah.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304020000.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.ORGNSI_MLTLTRL, true)));
	}

	public static SegmentValidation genRowValidation078B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304020000.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "7", ER1140GolonganPihakLawan2550.getOrgnsiMltltrl(),
				"3|6", ER1150JenisPinjamanSyariah.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000304020000.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.ORGNSI_MLTLTRL, false)));
	}
	
	public static SegmentValidation genRowValidation079() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000304030000.key,
				UtilMetadata.genPlusRow(getObjects(), 78, 79),
				UtilMetadata.genMessage(R_11000304030000.value, UtilMetadata.genPlusDesc(getObjects(), 78, 79)));
	}

	public static SegmentValidation genRowValidation080A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304030100.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "6|7",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getBnkDn(), "3",
				ER1150JenisPinjamanSyariah.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304030100.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.BNK_DN, true)));
	}

	public static SegmentValidation genRowValidation080B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304030100.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "7", ER1140GolonganPihakLawan2550.getBnkDn(), "3|6",
				ER1150JenisPinjamanSyariah.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000304030100.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.BNK_DN, false)));
	}

	public static SegmentValidation genRowValidation081A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304030200.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "6|7",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getBnkLn(), "3",
				ER1150JenisPinjamanSyariah.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304030200.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.BNK_LN, true)));
	}

	public static SegmentValidation genRowValidation081B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304030200.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "7", ER1140GolonganPihakLawan2550.getBnkLn(), "3|6",
				ER1150JenisPinjamanSyariah.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000304030200.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.BNK_LN, false)));
	}
	
	public static SegmentValidation genRowValidation082() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000304040000.key,
				UtilMetadata.genPlusRow(getObjects(), 81, 82),
				UtilMetadata.genMessage(R_11000304040000.value, UtilMetadata.genPlusDesc(getObjects(), 81, 82)));
	}

	public static SegmentValidation genRowValidation083A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304040100.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "6|7",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getLjknbDn(), "3",
				ER1150JenisPinjamanSyariah.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304040100.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.LJKNB_DN, true)));
	}

	public static SegmentValidation genRowValidation083B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304040100.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "7", ER1140GolonganPihakLawan2550.getLjknbDn(), "3|6",
				ER1150JenisPinjamanSyariah.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000304040100.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.LJKNB_DN, false)));
	}

	public static SegmentValidation genRowValidation084A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000304040200.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "6|7",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1140GolonganPihakLawan2550.getLjknbLn(), "3",
				ER1150JenisPinjamanSyariah.R_4.getKey(), UtilMetadata.genMessageTotal(R_11000304040200.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.LJKNB_LN, true)));
	}

	public static SegmentValidation genRowValidation084B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000304040200.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "7", ER1140GolonganPihakLawan2550.getLjknbLn(), "3|6",
				ER1150JenisPinjamanSyariah.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000304040200.value,
						messageForm2550A(ER1140GolonganPihakLawan2550.LJKNB_LN, false)));
	}

	public static SegmentValidation genRowValidation085A() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_11000305000000.key, "14",
				ER3120PosLbPpiu2600.R_2600010000.getFormKey(), "5", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000305000000.value, "Kolom surat berharga yang diterbitkan (rupiah) pada form 2600"));
	}

	public static SegmentValidation genRowValidation085B() {
		return UtilSegmentValidation.genEqualsFormulaFormNotEquals("3", R_11000305000000.key, "14",
				ER3120PosLbPpiu2600.R_2600010000.getFormKey(), "5", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000305000000.value, "Kolom surat berharga yang diterbitkan (selain rupiah) pada form 2600"));
	}

	public static SegmentValidation genRowValidation085C() {
		return UtilSegmentValidation.genEqualsForm("2", R_11000305000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "8",
				ER3123PosLbPpiu5310.R_53100302000000.getKey(), R_11000305000000.value);
	}

	public static SegmentValidation genRowValidation085D() {
		return UtilSegmentValidation.genEqualsForm("3", R_11000305000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "15",
				ER3123PosLbPpiu5310.R_53100302000000.getKey(), R_11000305000000.value);
	}

	public static SegmentValidation genRowValidation085E() {
		return UtilSegmentValidation.genEqualsForm("4", R_11000305000000.key, EFormLaporanBulananUus.LB_5310.getCode(), "16",
				ER3123PosLbPpiu5310.R_53100302000000.getKey(), R_11000305000000.value);
	}
	
	public static SegmentValidation genRowValidation088() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000308000000.key,
				UtilMetadata.genPlusRow(getObjects(), 87, 88),
				UtilMetadata.genMessage(R_11000308000000.value, UtilMetadata.genPlusDesc(getObjects(), 87, 88)));
	}

	public static SegmentValidation genRowValidation089A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilter("2", R_11000308010000.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "3|6|20",
				ER1150JenisPinjamanSyariah.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey() + "|"
						+ ER1126Negara.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000308010000.value, messageForm2550B(true, true)));
	}

	public static SegmentValidation genRowValidation089B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000308010000.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "3|20",
				ER1150JenisPinjamanSyariah.R_4.getKey() + "|" + ER1126Negara.R_1.getKey(), "6",
				ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000308010000.value, messageForm2550B(true, false)));
	}

	public static SegmentValidation genRowValidation090A() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("2", R_11000308020000.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "3|6",
				ER1150JenisPinjamanSyariah.R_4.getKey() + "|" + ER1122JenisValuta.R_1.getKey(), "20",
				ER1126Negara.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000308020000.value, messageForm2550B(false, true)));
	}

	public static SegmentValidation genRowValidation090B() {
		return UtilSegmentValidation.genEqualsFormulaFormMultiFilterNotEquals("3", R_11000308020000.key, "18",
				ER3119PosLbPpiu2550.R_2550010000.getFormKey(), "3", ER1150JenisPinjamanSyariah.R_4.getKey(), "6|20",
				ER1122JenisValuta.R_1.getKey() + "|" + ER1126Negara.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000308020000.value, messageForm2550B(false, false)));
	}

	public static SegmentValidation genRowValidation091A() {
		return UtilSegmentValidation.genEqualsFormulaForm2("2", R_11000309000000.key, "4",
				ER3121PosLbPpiu2790.R_2790010000.getFormKey(), "3", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000309000000.value, "Kolom nominal (rupiah) pada form 2790"));
	}

	public static SegmentValidation genRowValidation091B() {
		return UtilSegmentValidation.genEqualsFormulaFormNotEquals("3", R_11000309000000.key, "4",
				ER3121PosLbPpiu2790.R_2790010000.getFormKey(), "3", ER1122JenisValuta.R_1.getKey(),
				UtilMetadata.genMessageTotal(R_11000309000000.value, "Kolom nominal (selain rupiah) pada form 2790"));
	}
	
	public static SegmentValidation genRowValidation092() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000315000000.key,
				UtilMetadata.genPlusRow(getObjects(), 91, 93),
				UtilMetadata.genMessage(R_11000315000000.value, UtilMetadata.genPlusDesc(getObjects(), 91, 93)));
	}
	
	public static SegmentValidation genRowValidation096() {
		int[] fields1 = new int[] { 95, 98 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000310000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields1) + "-" + R_11000310030000.key + "+" + R_11000310040000.key
				+ "-" + R_11000310050000.key,
				UtilMetadata.genMessage(R_11000310000000.value, UtilMetadata.genPlusDesc(getObjects(), fields1) + "-'"
						+ R_11000310030000.value + "'+'" + R_11000310040000.value + "'-' " + R_11000310050000.value)
						+ "'");
	}
	
	public static SegmentValidation genRowValidation097() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000310010000.key,
				UtilMetadata.genPlusRow(getObjects(), 96, 97),
				UtilMetadata.genMessage(R_11000310010000.value, UtilMetadata.genPlusDesc(getObjects(), 96, 97)));
	}
	
	public static SegmentValidation genRowValidation100() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000310020000.key,
				UtilMetadata.genPlusRow(getObjects(), 99, 102),
				UtilMetadata.genMessage(R_11000310020000.value, UtilMetadata.genPlusDesc(getObjects(), 99, 102)));
	}
	
	public static SegmentValidation genRowValidation108() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000311000000.key,
				UtilMetadata.genPlusRow(getObjects(), 107, 108),
				UtilMetadata.genMessage(R_11000311000000.value, UtilMetadata.genPlusDesc(getObjects(), 107, 108)));
	}
	
	public static SegmentValidation genRowValidation113() {
		int[] fields = new int[] { 112, 118 };
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000314000000.key,
				UtilMetadata.genPlusRow(getObjects(), fields),
				UtilMetadata.genMessage(R_11000314000000.value, UtilMetadata.genPlusDesc(getObjects(), fields)));
	}
	
	public static SegmentValidation genRowValidation115() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 3), R_11000314010000.key,
				UtilMetadata.genPlusRow(getObjects(), 113, 117),
				UtilMetadata.genMessage(R_11000314010000.value, UtilMetadata.genPlusDesc(getObjects(), 113, 117)));
	}
	
	public static SegmentValidation genRowValidation121() {
		int[] fields = new int[] { 63, 69, 70, 71, 83, 84, 85, 86, 89, 90, 94, 106, 109, 110, 111 };
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
