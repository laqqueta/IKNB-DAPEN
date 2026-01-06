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
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5016PosLbLpeig2300;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2300 extends BaseMetadata {

	public Lb2300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 0, null);

		res.setSavePos(ER5016PosLbLpeig2300.genFieldSave());
		res.setSavePosForm(ER5016PosLbLpeig2300.genFieldSave());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R5016_LB2300.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Perusahaan", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Golongan Perusahaan", sv(M, 1, 100, all)));
		fs.add(sf(4, null, "Metode Penyertaan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R055.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Negara", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R024.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(6, null, "Jenis Valuta", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(7, null, "Kualitas Aset", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R017.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(8, null, "Tujuan Penyertaan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R056.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(9, null, "Status Keterkaitan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R014.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(10, null, "Tanggal Mulai", sv(M, 8, 8, date)));
		fs.add(sf(11, null, "Persentase Bagian Penyertaan", sv(M, 1, 10, DataType.numericDot)));
		fs.add(sf(12, null, "Nilai Penyertaan Awal - Dalam Mata Uang Asal", sv(M, 1, 20, DataType.numericDot)));
		fs.add(sf(13, null, "Nilai Penyertaan Awal - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(14, null, "Nilai Penyertaan Akhir - Dalam Mata Uang Asal", sv(M, 1, 20, DataType.numericDot)));
		fs.add(sf(15, null, "Nilai Penyertaan Akhir - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(16, null, "Cadangan Kerugian Penurunan Nilai - Metode Secara Individual", sv(M, 1, 20, numeric)));
		fs.add(sf(17, null, "Cadangan Kerugian Penurunan Nilai - Metode Secara Kolektif", sv(M, 1, 20, numeric)));
		fs.add(sf(18, null, "Cadangan Kerugian Penurunan Nilai - Aset Baik", sv(M, 1, 20, numeric)));
		fs.add(sf(19, null, "Cadangan Kerugian Penurunan Nilai - Aset Kurang Baik", sv(M, 1, 20, numeric)));
		fs.add(sf(20, null, "Cadangan Kerugian Penurunan Nilai - Aset Tidak Baik", sv(M, 1, 20, numeric)));
		return res;
	}
}
