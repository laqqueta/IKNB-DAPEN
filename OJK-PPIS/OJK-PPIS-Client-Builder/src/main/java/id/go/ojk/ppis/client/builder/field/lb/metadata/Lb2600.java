package id.go.ojk.ppis.client.builder.field.lb.metadata;

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
import id.go.ojk.ppis.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.ppis.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.ppis.client.builder.field.lb.reference.ER3021PosLbPpis2600;
import id.go.ojk.ppis.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2600 extends BaseMetadata {

	public Lb2600(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2600;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		res.setSavePosForm(ER3021PosLbPpis2600.genFieldSave());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3021_LB2600.getObject())
						.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Surat Berharga", sv(M, 1, 35, all)));
		fs.add(sf(3, null, "Jenis Surat Berharga", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R019.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Jenis Akad yang Digunakan", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R046.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Jenis Valuta", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Jangka Waktu, Tanggal Mulai", sv(M, 8, 8, date))
				.addFieldValidations(ER3021PosLbPpis2600.genFieldValidation6()));
		fs.add(sf(7, null, "Jangka Waktu, Tanggal Jatuh Tempo",
				sv(M, 8, 8, date).confConditionalRequired(ER3021PosLbPpis2600.genFieldConditionA())));
		fs.add(sf(8, null, "Jenis Ujrah/Imbal Hasil", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R015.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(9, null, "Nilai Ujrah/Imbal Hasil", sv(M, 1, 16, numeric)));
		fs.add(sf(10, null, "Tingkat Ujrah/Imbal Hasil", sv(M, 1, 6, numericDot)));
		fs.add(sf(11, null, "Nilai Nominal Surat Berharga, Dalam Mata Uang Asal",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3021PosLbPpis2600.genFieldConditionB())));
		fs.add(sf(12, null, "Nilai Nominal Surat Berharga, Dalam Ekuivalen Rupiah", sv(M, 1, 16, numeric)));
		fs.add(sf(13, null, "Saldo Surat Berharga yang Diterbitkan, Dalam Mata Uang Asal",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3021PosLbPpis2600.genFieldConditionB())));
		fs.add(sf(14, null, "Saldo Surat Berharga yang Diterbitkan, Dalam Ekuivalen Rupiah", sv(M, 1, 16, numeric)));
		fs.add(sf(15, null, "Nama Investor", sv(M, 1, 30, all)));
		fs.add(sf(16, null, "Status Keterkaitan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R014.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(17, null, "Golongan Investor", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R031.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(18, null, "Negara Asal Kreditur", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R024.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(19, null, "Tanggal Terdaftar LPP", sv(M, 8, 8, date)));
		fs.add(sf(20, null, "Nomor Pendaftaran LPP", sv(M, 1, 35, all)));
		fs.add(sf(21, null, "Nama Wali Amanat", sv(M, 1, 100, all).confRegex(PATTERN_NAME.c())));
		fs.add(sf(22, null, "Lembaga Pemeringkat",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3021PosLbPpis2600.genFieldConditionC())
						.confReference(EHeaderMetadataShared.R025.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(23, null, "Peringkat Surat Berharga",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3021PosLbPpis2600.genFieldConditionC())
						.confReference(EHeaderMetadataShared.R026.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(24, null, "Tanggal Pemeringkatan",
				sv(C, 8, 8, date).confConditionalRequired(ER3021PosLbPpis2600.genFieldConditionC())));
		return res;
	}
}
