package id.go.ojk.ppis.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppis.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.ppis.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.ppis.client.builder.field.lb.reference.ER3008PosLbPpis0046;
import id.go.ojk.ppis.client.builder.field.reference.EHeaderMetadataShared;

public class Lb0046 extends BaseMetadata {

	public Lb0046(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0046;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3008_LB0046.getObject())
						.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama", sv(C, 1, 100, all).confConditionalRequired(ER3008PosLbPpis0046.genFieldCondition())
				.confRegex(PATTERN_NAME.c())));
		fs.add(sf(3, null, "Nomor Identitas",
				sv(C, 1, 20, alfaNumeric).confConditionalRequired(ER3008PosLbPpis0046.genFieldCondition())));
		fs.add(sf(4, null, "Kewarganegaraan",
				sv(O, 1, 10, refTable).confReference(EHeaderMetadataShared.R024.getObject())
						.confRegex(PATTERN_REFERENCE_1.c()))
								.addFieldValidations(ER3008PosLbPpis0046.genFieldValidation4()));
		fs.add(sf(5, null, "Jabatan",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3008PosLbPpis0046.genFieldCondition())
						.confReference(EHeaderMetadataShared.R036.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Bidang Spesialisasi",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3008PosLbPpis0046.genFieldCondition())
						.confReference(EHeaderMetadataShared.R008.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(7, null, "Domisili",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3008PosLbPpis0046.genFieldCondition())
						.confReference(EHeaderMetadataShared.R033.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(8, null, "Nomor Izin Kerja",
				sv(C, 1, 25, all).confConditionalRequired(ER3008PosLbPpis0046.genFieldCondition())));
		fs.add(sf(9, null, "Tanggal Izin Kerja",
				sv(C, 8, 8, date).confConditionalRequired(ER3008PosLbPpis0046.genFieldCondition())));
		fs.add(sf(10, null, "Awal Masa Laku Izin Kerja",
				sv(C, 8, 8, date).confConditionalRequired(ER3008PosLbPpis0046.genFieldCondition()))
						.addFieldValidations(ER3008PosLbPpis0046.genFieldValidation10()));
		fs.add(sf(11, null, "Akhir Masa Laku Izin Kerja",
				sv(C, 8, 8, date).confConditionalRequired(ER3008PosLbPpis0046.genFieldCondition())));
		return res;
	}
}
