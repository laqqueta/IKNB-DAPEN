package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7022PosLbLpeiu2600;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2600 extends BaseMetadata {

	public Lb2600(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2600;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);

		res.setSavePosForm(ER7022PosLbLpeiu2600.genFieldSave());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R7022_LB2600.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Surat Berharga", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Jenis Surat Berharga",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R064.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Jenis Valuta", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(5, null, "Kategori Pengukuran", sv(M, 1, 100, all)));
		fs.add(sf(6, null, "Investor - Nama", sv(M, 1, 100, all)));
		fs.add(sf(7, null, "Investor - Negara",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R024.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(8, null, "Investor - Golongan", sv(M, 1, 100, all)));
		fs.add(sf(9, null, "Jangka Waktu, Tanggal Mulai", sv(M, 1, 8, date)));
		fs.add(sf(10, null, "Jangka Waktu, Tanggal Selesai", sv(M, 1, 8, date)));
		fs.add(sf(11, null, "Bagi Hasil/Imbal Hasil - Jenis",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R015.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(12, null, "Bagi Hasil/Imbal Hasil - Nilai", sv(M, 1, 20, numeric)));
		fs.add(sf(13, null, "Bagi Hasil/Imbal Hasil - Tingkat", sv(M, 1, 10, DataType.numericDot)));
		fs.add(sf(14, null, "Nilai Nominal Surat Berharga, Dalam Mata Uang Asal", sv(M, 1, 23, numericDot)));
		fs.add(sf(15, null, "Nilai Nominal Surat Berharga, Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(16, null, "Premium/Diskonto", sv(M, 1, 20, numeric)));
		fs.add(sf(17, null, "Saldo Surat, Dalam Mata Uang Asal", sv(M, 1, 23, numericDot)));
		fs.add(sf(18, null, "Saldo Surat, Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(19, null, "Status Keterkaitan",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R014.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(20, null, "Tanggal Terdaftar pada LPP", sv(M, 8, 8, date)));
		fs.add(sf(21, null, "Nomor Pendaftaran pada LPP", sv(M, 1, 100, all)));
		fs.add(sf(22, null, "Nama Wali Amanat", sv(M, 1, 100, all)));
		fs.add(sf(23, null, "Lembaga Pemeringkat",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R025.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(24, null, "Peringkat Surat Berharga",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R026.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(25, null, "Tanggal Pemeringkatan", sv(M, 8, 8, date)));
		fs.add(sf(26, null, "Ketersediaan Sinking Fund",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R059.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		return res;
	}
}
