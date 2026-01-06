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
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5021PosLbLpeig2550;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2550 extends BaseMetadata {

	public Lb2550(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2550;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 1, null);

		res.setRequiredPos(ER5021PosLbLpeig2550.getRequiredPos());
		res.setSavePosForm(ER5021PosLbLpeig2550.genFieldSave());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R5021_LB2550.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Sumber", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Nomor Kontrak", sv(M, 1, 100, all)));
		fs.add(sf(4, null, "Jenis Pendanaan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R030.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Jenis Valuta", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(6, null, "Kategori Pengukuran", sv(M, 1, 100, all)));
		fs.add(sf(7, null, "Kreditur - Nama", sv(M, 1, 100, all)));
		fs.add(sf(8, null, "Kreditur - Negara", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R024.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(9, null, "Kreditur - Golongan", sv(M, 1, 100, all)));
		fs.add(sf(10, null, "Jangka Waktu - Tanggal Mulai", sv(M, 8, 8, date)));
		fs.add(sf(11, null, "Jangka Waktu - Tanggal Selesai", sv(M, 8, 8, date)));
		fs.add(sf(12, null, "Suku Bunga/Bagi Hasil/Imbal Hasil- Jenis", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R015.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(13, null, "Suku Bunga/Bagi Hasil/Imbal Hasil - Nilai", sv(M, 1, 20, numeric)));
		fs.add(sf(14, null, "Suku Bunga/Bagi Hasil/Imbal Hasil - Tingkat", sv(M, 1, 10, DataType.numericDot)));
		fs.add(sf(15, null, "Status Keterkaitan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R014.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(16, null, "Plafon Pendanaan - Dalam Mata Uang Asal", sv(M, 1, 20, DataType.numericDot)));
		fs.add(sf(17, null, "Plafon Pendanaan - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(18, null, "Pendanaan Awal - Dalam Mata Uang Asal", sv(M, 1, 20, DataType.numericDot)));
		fs.add(sf(19, null, "Pendanaan Awal - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(20, null, "Saldo Pendanaan - Dalam Mata Uang Asal", sv(M, 1, 20, DataType.numericDot)));
		fs.add(sf(21, null, "Saldo Pendanaan - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		return res;
	}
}
