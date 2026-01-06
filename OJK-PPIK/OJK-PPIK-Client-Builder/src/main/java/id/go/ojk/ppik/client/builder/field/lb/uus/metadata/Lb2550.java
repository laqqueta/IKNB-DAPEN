package id.go.ojk.ppik.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.ER3119PosLbPpiu2550;
import id.go.ojk.ppik.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2550 extends BaseMetadata {

	public Lb2550(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2550;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		res.setSavePosForm(ER3119PosLbPpiu2550.genFieldSave());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3120_LB2550.getObject())
						.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Kontrak", sv(M, 1, 30, all)));
		fs.add(sf(3, null, "Jenis Pendanaan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R048.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Tujuan Penerima Pendanaan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R035.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Akad yang Digunakan", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R045.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Jenis Valuta", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(7, null, "Golongan Investor", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R038.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(8, null, "Tanggal Mulai", sv(M, 8, 8, date))
				.addFieldValidations(ER3119PosLbPpiu2550.genFieldValidation8()));
		fs.add(sf(9, null, "Tanggal Jatuh Tempo", sv(M, 8, 8, date)));
		fs.add(sf(10, null, "Jenis Bagi Hasil/Imbal Hasil", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R043.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(11, null, "Nilai Bagi Hasil/Imbal Hasil", sv(M, 1, 16, numeric)));
		fs.add(sf(12, null, "Tingkat Bagi Hasil/Imbal Hasil", sv(M, 1, 6, numericDot)));
		fs.add(sf(13, null, "Plafon Pinjaman/Pendanaan, Dalam Mata Uang Asal",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3119PosLbPpiu2550.genFieldCondition())));
		fs.add(sf(14, null, "Plafon Pinjaman/Pendanaan, Dalam Ekuivalen Rupiah", sv(M, 1, 16, numeric)));
		fs.add(sf(15, null, "Pinjaman/Pendanaan Awal, Dalam Mata Uang Asal",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3119PosLbPpiu2550.genFieldCondition()))
						.addFieldValidations(ER3119PosLbPpiu2550.genFieldValidation15()));
		fs.add(sf(16, null, "Pinjaman/Pendanaan Awal, Dalam Ekuivalen Rupiah", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3119PosLbPpiu2550.genFieldValidation16()));
		fs.add(sf(17, null, "Saldo Pendanaan/Pendanaan, Dalam Mata Uang Asal",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3119PosLbPpiu2550.genFieldCondition())));
		fs.add(sf(18, null, "Saldo Pendanaan/Pendanaan, Dalam Ekuivalen Rupiah", sv(M, 1, 16, numeric)));
		fs.add(sf(19, null, "Nama Investor", sv(M, 1, 50, all).confRegex(PATTERN_NAME.c())));
		fs.add(sf(20, null, "Negara Investor", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R024.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(21, null, "Status Keterkaitan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R014.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		return res;
	}
}
