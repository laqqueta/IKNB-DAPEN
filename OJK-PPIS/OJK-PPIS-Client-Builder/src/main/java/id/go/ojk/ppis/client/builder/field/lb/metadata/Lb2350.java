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
import id.go.ojk.ppis.client.builder.field.lb.reference.ER3017PosLbPpis2350;
import id.go.ojk.ppis.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2350 extends BaseMetadata {

	public Lb2350(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2350;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		res.setSavePosForm(ER3017PosLbPpis2350.genFieldSave());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3017_LB2350.getObject())
						.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Penerima", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Status Usaha",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3017PosLbPpis2350.genFieldCondition())
						.confReference(EHeaderMetadataShared.R031.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Bidang Usaha",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3017PosLbPpis2350.genFieldCondition())
						.confReference(EHeaderMetadataShared.R022.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Jenis Proyek",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3017PosLbPpis2350.genFieldCondition())
						.confReference(EHeaderMetadataShared.R021.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Jenis Valuta",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3017PosLbPpis2350.genFieldCondition())
						.confReference(EHeaderMetadataShared.R020.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(7, null, "Nilai Proyek Awal, Dalam Nilai Mata Uang Asal",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3017PosLbPpis2350.genFieldCondition())));
		fs.add(sf(8, null, "Nilai Proyek Awal, Dalam Ekuivalen Rupiah",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3017PosLbPpis2350.genFieldCondition())));
		fs.add(sf(9, null, "Nilai Proyek Berdasarkan Tagihan, Dalam Nilai Mata Uang Asal",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3017PosLbPpis2350.genFieldCondition())));
		fs.add(sf(10, null, "Nilai Proyek Berdasarkan Tagihan, Dalam Ekuivalen Rupiah",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3017PosLbPpis2350.genFieldCondition())));
		fs.add(sf(11, null, "Jangka Waktu, Tanggal Mulai",
				sv(C, 8, 8, date).confConditionalRequired(ER3017PosLbPpis2350.genFieldCondition()))
						.addFieldValidations(ER3017PosLbPpis2350.genFieldValidation11()));
		fs.add(sf(12, null, "Jangka Waktu, Tanggal Selesai",
				sv(C, 8, 8, date).confConditionalRequired(ER3017PosLbPpis2350.genFieldCondition())));
		return res;
	}
}
