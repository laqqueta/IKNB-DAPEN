package id.go.ojk.lpei.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5019PosLbLpeig2450;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2450 extends BaseMetadata {

	public Lb2450(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2450;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 1, null);

		res.setRequiredPos(ER5019PosLbLpeig2450.getRequiredPos());
		res.setSavePosForm(ER5019PosLbLpeig2450.genFieldSave());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R5019_LB2450.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Jenis", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R058.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(3, null, "Jenis Valuta", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(4, null, "Pihak Tertagih - Nama", sv(M, 1, 100, all)));
		fs.add(sf(5, null, "Pihak Tertagih - Negara", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R024.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(6, null, "Pihak Tertagih - Golongan", sv(M, 1, 100, all)));
		fs.add(sf(7, null, "Kategori Pengukuran", sv(M, 1, 100, all)));
		fs.add(sf(8, null, "Jangka Waktu - Tanggal Mulai", sv(M, 8, 8, date)));
		fs.add(sf(9, null, "Jangka Waktu - Tanggal Selesai", sv(M, 8, 8, date)));
		fs.add(sf(10, null, "Kualitas Aset", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R017.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(11, null, "Nominal - Dalam Mata Uang Asal", sv(M, 1, 20, DataType.numericDot)));
		fs.add(sf(12, null, "Nominal - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(13, null, "Persentage Terhadap Modal", sv(M, 1, 10, DataType.numericDot)));
		fs.add(sf(14, null, "Cadangan Kerugian Penurunan Nilai - Metode Secara Individual", sv(M, 1, 20, numeric)));
		fs.add(sf(15, null, "Cadangan Kerugian Penurunan Nilai - Metode Secara Kolektif", sv(M, 1, 20, numeric)));
		fs.add(sf(16, null, "Cadangan Kerugian Penurunan Nilai - Aset Baik", sv(M, 1, 20, numeric)));
		fs.add(sf(17, null, "Cadangan Kerugian Penurunan Nilai - Aset Kurang Baik", sv(M, 1, 20, numeric)));
		fs.add(sf(18, null, "Cadangan Kerugian Penurunan Nilai - Aset Tidak Baik", sv(M, 1, 20, numeric)));
		return res;
	}
}
