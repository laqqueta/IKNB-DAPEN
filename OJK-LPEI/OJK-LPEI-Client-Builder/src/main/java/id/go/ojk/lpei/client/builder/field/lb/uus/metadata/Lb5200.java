package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb5200 extends BaseMetadata {

	public Lb5200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_5200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R7027_LB5200.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Individu/ Anggota Kelompok/ Total Kelompok", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R060.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Nama Grup/Kelompok", sv(M, 1, 100, all)));
		fs.add(sf(5, null, "Status Keterkaitan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R014.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Jenis Asuransi", sv(O, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R061.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(7, null, "Jenis Penjaminan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R062.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(8, null, "Jangka Waktu, Tanggal Mulai", sv(M, 1, 8, date)));
		fs.add(sf(9, null, "Jangka Waktu, Tanggal Selesai", sv(M, 1, 8, date)));
		fs.add(sf(10, null, "Jumlah Retensi Sendiri, Dalam Mata Uang Asal", sv(M, 1, 23, numericDot)));
		fs.add(sf(11, null, "Jumlah Retensi Sendiri, Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(12, null, "Persentase Terhadap Modal", sv(M, 1, 10, numericDot)));
		fs.add(sf(13, null, "Modal", sv(M, 1, 20, numeric)));
		fs.add(sf(14, null, "Pelampauan, Nominal", sv(M, 1, 20, numeric)));
		fs.add(sf(15, null, "Pelampauan, Persentase", sv(M, 1, 10, numericDot)));
		fs.add(sf(16, null, "Reasuransi, Jumlah", sv(M, 1, 20, numeric)));
		fs.add(sf(17, null, "Reasuransi, Nama Perusahaan", sv(M, 1, 100, all)));
		fs.add(sf(18, null, "Keterangan", sv(M, 1, 100, all)));
		return res;
	}
}
