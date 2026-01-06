package id.go.ojk.ppik.client.builder.field.lb.metadata;

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
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.ppik.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.ppik.client.builder.field.lb.reference.ER3016PosLbPpik2300;
import id.go.ojk.ppik.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2300 extends BaseMetadata {

	public Lb2300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		res.setSavePosForm(ER3016PosLbPpik2300.genFieldSave());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R3016_LB2300.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Perusahaan", sv(M, 1, 100, all).confRegex(PATTERN_NAME.c())));
		fs.add(sf(3, null, "Golongan Perusahaan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R031.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Status Keterkaitan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R014.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Negara", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R024.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Tanggal Mulai", sv(M, 8, 8, date)));
		fs.add(sf(7, null, "Persentase Bagian Penyertaan", sv(M, 1, 6, numericDot))
				.addFieldValidations(ER3016PosLbPpik2300.genFieldValidation7()));
		fs.add(sf(8, null, "Jenis Valuta", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(9, null, "Nilai Penyertaan Awal, Dalam Nilai Mata Uang Asal",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3016PosLbPpik2300.genFieldCondition())));
		fs.add(sf(10, null, "Nilai Penyertaan Awal, Dalam Ekuivalen Rupiah", sv(M, 1, 16, numeric)));
		fs.add(sf(11, null, "Nilai Penyertaan Modal, Dalam Nilai Mata Uang Asal", sv(M, 1, 16, numeric)));
		fs.add(sf(12, null, "Nilai Penyertaan Modal, Dalam Ekuivalen Rupiah", sv(M, 1, 16, numeric)));
		return res;
	}
}
