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
import id.go.ojk.ppis.client.builder.field.lb.reference.ER3015PosLbPpis2200;
import id.go.ojk.ppis.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2200 extends BaseMetadata {

	public Lb2200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		res.setSavePosForm(ER3015PosLbPpis2200.genFieldSave());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R3015_LB2200.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Informasi Surat Berharga yang Dimiliki, Nomor Surat Berharga", sv(M, 1, 35, all)));
		fs.add(sf(3, null, "Informasi Surat Berharga yang Dimiliki, Jenis Surat Berharga", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R019.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Informasi Surat Berharga yang Dimiliki, Jangka Waktu, Tanggal Mulai", sv(M, 8, 8, date))
				.addFieldValidations(ER3015PosLbPpis2200.genFieldValidation4()));
		fs.add(sf(5, null, "Informasi Surat Berharga yang Dimiliki, Jangka Waktu, Tanggal Jatuh Tempo",
				sv(C, 8, 8, date).confConditionalRequired(ER3015PosLbPpis2200.genFieldConditionA())));
		fs.add(sf(6, null, "Informasi Surat Berharga yang Dimiliki, Akad yang Digunakan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R042.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(7, null, "Informasi Surat Berharga yang Dimiliki, Jenis Valuta", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R020.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(8, null, "Informasi Surat Berharga yang Dimiliki, Tujuan Kepemilikan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R023.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(9, null, "Informasi Surat Berharga yang Dimiliki, Jenis Imbal Hasil", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R015.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(10, null, "Informasi Surat Berharga yang Dimiliki, Nilai Imbal Hasil", sv(M, 1, 6, numeric)));
		fs.add(sf(11, null, "Informasi Surat Berharga yang Dimiliki Tingkat Imbal Hasil", sv(M, 1, 6, numericDot)));
		fs.add(sf(12, null, "Saldo Akhir, Dalam Mata Uang Asal", sv(M, 1, 16, numeric)));
		fs.add(sf(13, null, "Saldo Akhir, Dalam Ekuivalen Rupiah", sv(M, 1, 30, numeric)));
		fs.add(sf(14, null, "Informasi Perusahaan Penerbit, Nama Penerbit",
				sv(M, 1, 100, all).confRegex(PATTERN_NAME.c())));
		fs.add(sf(15, null, "Informasi Perusahaan Penerbit, Lokasi Negara Penerbit", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R024.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(16, null, "Informasi Perusahaan Penerbit, Golongan Penerbit", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R031.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(17, null, "Informasi Perusahaan Penerbit, Status Keterkaitan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R014.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(18, null, "Lembaga Pemeringkat",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3015PosLbPpis2200.genFieldConditionB())
						.confReference(EHeaderMetadataShared.R025.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(19, null, "Peringkat Surat Berharga",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3015PosLbPpis2200.genFieldConditionB())
						.confReference(EHeaderMetadataShared.R026.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(20, null, "Tanggal Pemeringkatan",
				sv(C, 8, 8, date).confConditionalRequired(ER3015PosLbPpis2200.genFieldConditionB())));
		return res;
	}
}
