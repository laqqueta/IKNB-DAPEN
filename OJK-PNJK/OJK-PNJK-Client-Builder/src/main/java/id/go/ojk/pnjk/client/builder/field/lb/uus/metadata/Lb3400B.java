package id.go.ojk.pnjk.client.builder.field.lb.uus.metadata;

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
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3131PosLbPnju3400B;
import id.go.ojk.pnjk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb3400B extends BaseMetadata {

	public Lb3400B(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_3400B;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3131_LB3400B.getObject())));
		fs.add(sf(2, null, "Sektor Ekonomi", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R022.getObject())));
		fs.add(sf(3, null, "Kafalah atas Surat Utang-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(4, null, "Kafalah atas Surat Utang-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(5, null, "Kafalah atas Surat Utang-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(6, null, "Kafalah Pembelian Barang secara Angsuran-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(7, null, "Kafalah Pembelian Barang secara Angsuran-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(8, null, "Kafalah Pembelian Barang secara Angsuran-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(9, null, "Kafalah Transaksi Dagang-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(10, null, "Kafalah Transaksi Dagang-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(11, null, "Kafalah Transaksi Dagang-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(12, null,
				"Kafalah Pengadaan barang dan/atau Jasa (Surety Bond)-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(13, null, "Kafalah Pengadaan barang dan/atau Jasa (Surety Bond)-Nilai Kafalah (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(14, null, "Kafalah Pengadaan barang dan/atau Jasa (Surety Bond)-Nilai Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(15, null, "Kafalah Bank Garansi (Kontra Bank Garansi)-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(16, null, "Kafalah Bank Garansi (Kontra Bank Garansi)-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(17, null, "Kafalah Bank Garansi (Kontra Bank Garansi)-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(18, null, "Kafalah Surat Kredit Berdokumen dalam Negeri-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(19, null, "Kafalah Surat Kredit Berdokumen dalam Negeri-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(20, null, "Kafalah Surat Kredit Berdokumen dalam Negeri-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(21, null, "Kafalah Letter of Credit-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(22, null, "Kafalah Letter of Credit-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(23, null, "Kafalah Letter of Credit-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(24, null, "Kafalah Kepabeanan (Customs Bond)-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(25, null, "Kafalah Kepabeanan (Customs Bond)-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(26, null, "Kafalah Kepabeanan (Customs Bond)-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(27, null, "Kafalah Cukai-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)", sv(M, 1, 8, numeric)));
		fs.add(sf(28, null, "Kafalah Cukai-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(29, null, "Kafalah Cukai-Nilai Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(30, null,
				"Pemberian Jasa Konsultasi Manajemen terkait dengan Kegiatan Usaha Penjamin-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(31, null,
				"Pemberian Jasa Konsultasi Manajemen terkait dengan Kegiatan Usaha Penjamin-Nilai Kafalah (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(32, null,
				"Pemberian Jasa Konsultasi Manajemen terkait dengan Kegiatan Usaha Penjamin-Nilai Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(33, null,
				"Kegiatan Usaha Lainnya setelah Mendapat Persetujuan dari OJK-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)",
				sv(M, 1, 8, numeric)));
		fs.add(sf(34, null, "Kegiatan Usaha Lainnya setelah Mendapat Persetujuan dari OJK-Nilai Kafalah (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(35, null, "Kegiatan Usaha Lainnya setelah Mendapat Persetujuan dari OJK-Nilai Klaim (Rp)",
				sv(M, 1, 16, numeric)));
		fs.add(sf(36, null, "Total-Jumlah Terjamin (Makfuul 'Anhu)-(Satuan)", sv(M, 1, 8, numeric))
				.addFieldValidations(ER3131PosLbPnju3400B.genFieldValidation36()));
		fs.add(sf(37, null, "Total-Nilai Kafalah (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3131PosLbPnju3400B.genFieldValidation37()));
		fs.add(sf(38, null, "Total-Nilai Klaim (Rp)", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3131PosLbPnju3400B.genFieldValidation38()));
		return res;
	}
}
