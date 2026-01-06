package id.go.ojk.pnjk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3133PosLbPnju3500B;

public class Lb3500B extends BaseMetadata {

	public Lb3500B(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_3500B;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 4, 4, ER3133PosLbPnju3500B.genFieldSave(), ER3133PosLbPnju3500B.genFieldSave(),
				ER3133PosLbPnju3500B.getRequiredPos());
		res.addSegmentValidations(ER3133PosLbPnju3500B.genValidation5());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3133_LB3500B.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kafalah atas Surat Utang-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(3, null, "Kafalah atas Surat Utang-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(4, null, "Kafalah atas Surat Utang-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(5, null, "Kafalah atas Surat Utang-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(6, null, "Kafalah atas Surat Utang-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(7, null, "Kafalah atas Surat Utang-Klaim Disetujui Namun Belum Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(8, null, "Kafalah Pembelian Barang secara Angsuran-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(9, null, "Kafalah Pembelian Barang secara Angsuran-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(10, null, "Kafalah Pembelian Barang secara Angsuran-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(11, null, "Kafalah Pembelian Barang secara Angsuran-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(12, null, "Kafalah Pembelian Barang secara Angsuran-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(13, null, "Kafalah Pembelian Barang secara Angsuran-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(14, null, "Kafalah Transaksi Dagang-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(15, null, "Kafalah Transaksi Dagang-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(16, null, "Kafalah Transaksi Dagang-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(17, null, "Kafalah Transaksi Dagang-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(18, null, "Kafalah Transaksi Dagang-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(19, null, "Kafalah Transaksi Dagang-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(20, null, "Kafalah Pengadaan barang dan/atau Jasa (Surety Bond)-Pengajuan Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(21, null, "Kafalah Pengadaan barang dan/atau Jasa (Surety Bond)-Klaim Diproses (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(22, null, "Kafalah Pengadaan barang dan/atau Jasa (Surety Bond)-Klaim Disetujui (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(23, null, "Kafalah Pengadaan barang dan/atau Jasa (Surety Bond)-Klaim Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(24, null, "Kafalah Pengadaan barang dan/atau Jasa (Surety Bond)-Klaim Ditolak (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(25, null,
				"Kafalah Pengadaan barang dan/atau Jasa (Surety Bond)-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(26, null, "Kafalah Bank Garansi (Kontra Bank Garansi)-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(27, null, "Kafalah Bank Garansi (Kontra Bank Garansi)-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(28, null, "Kafalah Bank Garansi (Kontra Bank Garansi)-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(29, null, "Kafalah Bank Garansi (Kontra Bank Garansi)-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(30, null, "Kafalah Bank Garansi (Kontra Bank Garansi)-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(31, null, "Kafalah Bank Garansi (Kontra Bank Garansi)-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(32, null, "Kafalah Surat Kredit Berdokumen dalam Negeri-Pengajuan Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(33, null, "Kafalah Surat Kredit Berdokumen dalam Negeri-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(34, null, "Kafalah Surat Kredit Berdokumen dalam Negeri-Klaim Disetujui (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(35, null, "Kafalah Surat Kredit Berdokumen dalam Negeri-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(36, null, "Kafalah Surat Kredit Berdokumen dalam Negeri-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(37, null, "Kafalah Surat Kredit Berdokumen dalam Negeri-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(38, null, "Kafalah Letter of Credit-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(39, null, "Kafalah Letter of Credit-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(40, null, "Kafalah Letter of Credit-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(41, null, "Kafalah Letter of Credit-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(42, null, "Kafalah Letter of Credit-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(43, null, "Kafalah Letter of Credit-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(44, null, "Kafalah Kepabeanan (Customs Bond)-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(45, null, "Kafalah Kepabeanan (Customs Bond)-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(46, null, "Kafalah Kepabeanan (Customs Bond)-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(47, null, "Kafalah Kepabeanan (Customs Bond)-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(48, null, "Kafalah Kepabeanan (Customs Bond)-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(49, null, "Kafalah Kepabeanan (Customs Bond)-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(50, null, "Kafalah Cukai-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(51, null, "Kafalah Cukai-Klaim Diproses (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(52, null, "Kafalah Cukai-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(53, null, "Kafalah Cukai-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(54, null, "Kafalah Cukai-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(55, null, "Kafalah Cukai-Klaim Disetujui Namun Belum Dibayar (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(56, null,
				"Pemberian Jasa Konsultasi Manajemen terkait dengan Kegiatan Usaha Penjamin-Pengajuan Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(57, null,
				"Pemberian Jasa Konsultasi Manajemen terkait dengan Kegiatan Usaha Penjamin-Klaim Diproses (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(58, null,
				"Pemberian Jasa Konsultasi Manajemen terkait dengan Kegiatan Usaha Penjamin-Klaim Disetujui (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(59, null,
				"Pemberian Jasa Konsultasi Manajemen terkait dengan Kegiatan Usaha Penjamin-Klaim Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(60, null,
				"Pemberian Jasa Konsultasi Manajemen terkait dengan Kegiatan Usaha Penjamin-Klaim Ditolak (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(61, null,
				"Pemberian Jasa Konsultasi Manajemen terkait dengan Kegiatan Usaha Penjamin-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(62, null, "Kegiatan Usaha Lainnya setelah Mendapat Persetujuan dari OJK-Pengajuan Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(63, null, "Kegiatan Usaha Lainnya setelah Mendapat Persetujuan dari OJK-Klaim Diproses (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(64, null, "Kegiatan Usaha Lainnya setelah Mendapat Persetujuan dari OJK-Klaim Disetujui (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(65, null, "Kegiatan Usaha Lainnya setelah Mendapat Persetujuan dari OJK-Klaim Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(66, null, "Kegiatan Usaha Lainnya setelah Mendapat Persetujuan dari OJK-Klaim Ditolak (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(67, null,
				"Kegiatan Usaha Lainnya setelah Mendapat Persetujuan dari OJK-Klaim Disetujui Namun Belum Dibayar (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(68, null, "Total-Pengajuan Klaim (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3133PosLbPnju3500B.genFieldValidation68()));
		fs.add(sf(69, null, "Total-Klaim Diproses (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3133PosLbPnju3500B.genFieldValidation69()));
		fs.add(sf(70, null, "Total-Klaim Disetujui (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3133PosLbPnju3500B.genFieldValidation70()));
		fs.add(sf(71, null, "Total-Klaim Dibayar (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3133PosLbPnju3500B.genFieldValidation71()));
		fs.add(sf(72, null, "Total-Klaim Ditolak (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3133PosLbPnju3500B.genFieldValidation72()));
		fs.add(sf(73, null, "Total-Klaim Disetujui Namun Belum Dibayar (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3133PosLbPnju3500B.genFieldValidation73()));
		return res;
	}
}
