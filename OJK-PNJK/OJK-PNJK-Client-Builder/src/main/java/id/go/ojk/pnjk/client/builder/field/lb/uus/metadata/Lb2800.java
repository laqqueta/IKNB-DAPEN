package id.go.ojk.pnjk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
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
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3122PosLbPnju2800;
import id.go.ojk.pnjk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2800 extends BaseMetadata {

	public Lb2800(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2800;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, null, ER3122PosLbPnju2800.genFieldSave(), null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3122_LB2800.getObject())));
		fs.add(sf(2, null, "Skim", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R044.getObject())));
		fs.add(sf(3, null, "Nama", sv(M, 1, 100, all)));
		fs.add(sf(4, null, "Nomor Induk Kependudukan (NIK)/Nomor Pokok Wajib Pajak (NPWP)", sv(M, 1, 20, numeric)));
		fs.add(sf(5, null, "Jenis Kelamin", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R045.getObject())));
		fs.add(sf(6, null, "Nomor Sertifikat Kafalah", sv(M, 1, 50, all)));
		fs.add(sf(7, null, "Tanggal Sertifikat Kafalah", sv(M, 8, 8, date)));
		fs.add(sf(8, null, "Jenis Penerima Jaminan (Makfuul Lahu)", sv(M, 1, 10, refTable)
				.confRegex(PATTERN_REFERENCE_1).confReference(EHeaderMetadataShared.R053.getObject())));
		fs.add(sf(9, null, "Nama Penerima Jaminan (Makfuul Lahu)", sv(M, 1, 100, all)));
		fs.add(sf(10, null, "Jenis Kafalah", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R042.getObject())));
		fs.add(sf(11, null, "Produk Kafalah", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R043.getObject())));
		fs.add(sf(12, null, "Lokasi Terjamin-Kabupaten/Kota", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R033.getObject())));
		fs.add(sf(13, null, "Lokasi Terjamin-Provinsi", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R048.getObject())));
		fs.add(sf(14, null, "Sektor Ekonomi", sv(M, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R022.getObject())));
		fs.add(sf(15, null, "Nilai Pembiayaan/Proyek", sv(M, 1, 16, numeric)));
		fs.add(sf(16, null, "Nilai Kafalah", sv(M, 1, 16, numeric)));
		fs.add(sf(17, null, "Nilai Co-Guarantee/Reasuransi", sv(M, 1, 16, numeric)));
		fs.add(sf(18, null, "Outstanding Kafalah Retensi Sendiri", sv(M, 1, 16, numeric)));
		fs.add(sf(19, null, "Tanggal Awal Kafalah", sv(M, 8, 8, date)));
		fs.add(sf(20, null, "Tanggal Akhir Kafalah", sv(M, 8, 8, date)));
		fs.add(sf(21, null, "Jumlah Hari Utang IJK", sv(M, 1, 8, numeric)));
		fs.add(sf(22, null, "Nilai IJK", sv(M, 1, 16, numeric)));
		fs.add(sf(23, null, "Utang IJK", sv(M, 1, 16, numeric)));
		fs.add(sf(24, null, "CKPN", sv(M, 1, 16, numeric)));
		return res;
	}
}
