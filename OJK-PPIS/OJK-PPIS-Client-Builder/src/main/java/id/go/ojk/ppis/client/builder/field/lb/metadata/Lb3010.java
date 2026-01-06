package id.go.ojk.ppis.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
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
import id.go.ojk.ppis.client.builder.field.lb.reference.ER3023PosLbPpis3010;
import id.go.ojk.ppis.client.builder.field.reference.EHeaderMetadataShared;

public class Lb3010 extends BaseMetadata {

	public Lb3010(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_3010;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		res.setSavePosForm(ER3023PosLbPpis3010.genFieldSave());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3023_LB3010.getObject())
						.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Kontrak Underlying Transaksi Pinjaman/ Pendanaan", sv(M, 1, 35, all)));
		fs.add(sf(3, null, "Nominal Underlying Transaksi Pinjaman/ Pendanaan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3023PosLbPpis3010.genFieldConditionA())));
		fs.add(sf(4, null, "Nomor Kontrak Instrumen Derivatif",
				sv(C, 1, 35, all).confConditionalRequired(ER3023PosLbPpis3010.genFieldConditionA())));
		fs.add(sf(5, null, "Jenis Instrumen Derivatif",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3023PosLbPpis3010.genFieldConditionA())
						.confReference(EHeaderMetadataShared.R047.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Jenis Valuta",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3023PosLbPpis3010.genFieldConditionA())
						.confReference(EHeaderMetadataShared.R020.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(7, null, "Tanggal Mulai",
				sv(C, 8, 8, date).confConditionalRequired(ER3023PosLbPpis3010.genFieldConditionA()))
						.addFieldValidations(ER3023PosLbPpis3010.genFieldValidation7()));
		fs.add(sf(8, null, "Tanggal Jatuh Tempo",
				sv(C, 8, 8, date).confConditionalRequired(ER3023PosLbPpis3010.genFieldConditionA())));
		fs.add(sf(9, null, "Nominal Instrumen Derivatif untuk Lindung Nilai (Dalam Mata Uang Asal)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3023PosLbPpis3010.genFieldConditionB())));
		fs.add(sf(10, null, "Nominal Instrumen Derivatif untuk Lindung Nilai (Dalam Ekuivalen Rupiah)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3023PosLbPpis3010.genFieldConditionA())));
		fs.add(sf(11, null, "Nama Counterparty", sv(C, 1, 100, all)
				.confConditionalRequired(ER3023PosLbPpis3010.genFieldConditionA())));
		fs.add(sf(12, null, "Negara Counterparty",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3023PosLbPpis3010.genFieldConditionA())
						.confReference(EHeaderMetadataShared.R024.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(13, null, "Golongan Counterparty",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3023PosLbPpis3010.genFieldConditionA())
						.confReference(EHeaderMetadataShared.R031.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		return res;
	}
}
