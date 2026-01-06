package id.go.ojk.ppis.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
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
import id.go.ojk.ppis.client.builder.field.lb.reference.ER3003PosLbPpis0030;
import id.go.ojk.ppis.client.builder.field.reference.EHeaderMetadataShared;

public class Lb0030 extends BaseMetadata {

	public Lb0030(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0030;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER3003PosLbPpis0030.genFieldSave(), ER3003PosLbPpis0030.genFieldSave());
		res.addSegmentValidations(ER3003PosLbPpis0030.genRowValidation10());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3003_LB0030.getObject())
						.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Pemegang Saham", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Golongan Pemegang Saham", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R031.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Negara Asal", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R024.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Bentuk Badan Hukum Pemegang Saham", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R001.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Status Pemegang Saham", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R002.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(7, null, "Ekuitas Pemegang Saham (dalam Rp)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3003PosLbPpis0030.genFieldConditionB())));
		fs.add(sf(8, null, "Persentase Kepemilikan Asing secara Langsung/Tidak Langsung", sv(M, 1, 6, numericDot))
				.addFieldValidations(ER3003PosLbPpis0030.genFieldValidation08()));
		fs.add(sf(9, null, "Nilai Kepemilikan Saham (dalam Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(10, null, "Persentase Kepemilikan Saham (%)", sv(M, 1, 6, numericDot)));
		fs.add(sf(11, null, "Nama Pengurus Pemegang Saham", sv(C, 1, 100, all)
				.confConditionalRequired(ER3003PosLbPpis0030.genFieldConditionA()).confRegex(PATTERN_NAME.c())));
		fs.add(sf(12, null, "Jabatan Pengurus Pemegang Saham",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3003PosLbPpis0030.genFieldConditionA())
						.confReference(EHeaderMetadataShared.R003.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(13, null, "Negara Pengurus Asal Pemegang Saham",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3003PosLbPpis0030.genFieldConditionA())
						.confReference(EHeaderMetadataShared.R024.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(14, null, "Nama Pemegang Saham Derajat Kedua", sv(C, 1, 100, all)
				.confConditionalRequired(ER3003PosLbPpis0030.genFieldConditionA()).confRegex(PATTERN_NAME.c())));
		fs.add(sf(15, null, "Golongan Pemegang Saham Derajat Kedua",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3003PosLbPpis0030.genFieldConditionA())
						.confReference(EHeaderMetadataShared.R031.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(16, null, "Negara Asal Pemegang Saham Derajat Kedua",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3003PosLbPpis0030.genFieldConditionA())
						.confReference(EHeaderMetadataShared.R024.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(17, null, "Nilai Kepemilikan Saham Derajat Kedua",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3003PosLbPpis0030.genFieldConditionA())));
		return res;
	}
}
