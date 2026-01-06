package id.go.ojk.pnjk.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjk.client.builder.field.lb.reference.ER3029PosLbPnjk3300B;
import id.go.ojk.pnjk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb3300B extends BaseMetadata {

	public Lb3300B(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_3300B;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3029_LB3300B.getObject())));
		fs.add(sf(2, null, "Lokasi Terjamin (Dati II)", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R033.getObject())));
		fs.add(sf(3, null, "Penjaminan atas Surat Utang-Jumlah Terjamin (Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(4, null, "Penjaminan atas Surat Utang-Nilai Jaminan (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(5, null, "Penjaminan atas Surat Utang-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(6, null, "Penjaminan Pembelian Barang secara Angsuran-Jumlah Terjamin (Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(7, null, "Penjaminan Pembelian Barang secara Angsuran-Nilai Jaminan (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(8, null, "Penjaminan Pembelian Barang secara Angsuran-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(9, null, "Penjaminan Transaksi Dagang-Jumlah Terjamin (Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(10, null, "Penjaminan Transaksi Dagang-Nilai Jaminan (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(11, null, "Penjaminan Transaksi Dagang-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(12, null, "Penjaminan Pengadaan barang dan/atau Jasa (Surety Bond)-Jumlah Terjamin (Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(13, null, "Penjaminan Pengadaan barang dan/atau Jasa (Surety Bond)-Nilai Jaminan (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(14, null, "Penjaminan Pengadaan barang dan/atau Jasa (Surety Bond)-Nilai Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(15, null, "Penjaminan Bank Garansi (Kontra Bank Garansi)-Jumlah Terjamin (Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(16, null, "Penjaminan Bank Garansi (Kontra Bank Garansi)-Nilai Jaminan (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(17, null, "Penjaminan Bank Garansi (Kontra Bank Garansi)-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(18, null, "Penjaminan Surat Kredit Berdokumen dalam Negeri-Jumlah Terjamin (Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(19, null, "Penjaminan Surat Kredit Berdokumen dalam Negeri-Nilai Jaminan (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(20, null, "Penjaminan Surat Kredit Berdokumen dalam Negeri-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(21, null, "Penjaminan Letter of Credit-Jumlah Terjamin (Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(22, null, "Penjaminan Letter of Credit-Nilai Jaminan (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(23, null, "Penjaminan Letter of Credit-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(24, null, "Penjaminan Kepabeanan (Customs Bond)-Jumlah Terjamin (Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(25, null, "Penjaminan Kepabeanan (Customs Bond)-Nilai Jaminan (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(26, null, "Penjaminan Kepabeanan (Customs Bond)-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(27, null, "Penjaminan Cukai-Jumlah Terjamin (Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(28, null, "Penjaminan Cukai-Nilai Jaminan (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(29, null, "Penjaminan Cukai-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(30, null,
				"Pemberian Jasa Konsultasi Manajemen terkait dengan Kegiatan Usaha Penjamin-Jumlah Terjamin (Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(31, null,
				"Pemberian Jasa Konsultasi Manajemen terkait dengan Kegiatan Usaha Penjamin-Nilai Jaminan (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(32, null,
				"Pemberian Jasa Konsultasi Manajemen terkait dengan Kegiatan Usaha Penjamin-Nilai Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(33, null, "Kegiatan Usaha Lainnya setelah Mendapat Persetujuan dari OJK-Jumlah Terjamin (Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(34, null, "Kegiatan Usaha Lainnya setelah Mendapat Persetujuan dari OJK-Nilai Jaminan (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(35, null, "Kegiatan Usaha Lainnya setelah Mendapat Persetujuan dari OJK-Nilai Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(36, null, "Total-Jumlah Terjamin (Satuan)", sv(M, 1, 8, numeric))
				.addFieldValidations(ER3029PosLbPnjk3300B.genFieldValidation36()));
		fs.add(sf(37, null, "Total-Nilai Jaminan (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3029PosLbPnjk3300B.genFieldValidation37()));
		fs.add(sf(38, null, "Total-Nilai Klaim (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3029PosLbPnjk3300B.genFieldValidation38()));
		return res;
	}
}
