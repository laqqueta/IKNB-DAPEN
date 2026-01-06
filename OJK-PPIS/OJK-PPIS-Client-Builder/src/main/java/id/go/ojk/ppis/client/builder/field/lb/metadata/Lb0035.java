package id.go.ojk.ppis.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
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
import id.go.ojk.ppis.client.builder.field.lb.reference.ER3004PosLbPpis0035;
import id.go.ojk.ppis.client.builder.field.reference.EHeaderMetadataShared;

public class Lb0035 extends BaseMetadata {

	public Lb0035(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0035;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R3004_LB0035.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Nomor Identitas", sv(M, 1, 20, alfaNumeric)));
		fs.add(sf(4, null, "Kewarganegaraan",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R024.getObject())
						.confRegex(PATTERN_REFERENCE_1.c()))
								.addFieldValidations(ER3004PosLbPpis0035.genFieldValidation4()));
		fs.add(sf(5, null, "Jabatan", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R003.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Domisili", sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R033.getObject())
				.confRegex(PATTERN_REFERENCE_1.c()).confConditionalRequired(ER3004PosLbPpis0035.genFieldCondition())));
		fs.add(sf(7, null, "Nomor Akta Pengangkatan", sv(M, 1, 50, all)));
		fs.add(sf(8, null, "Tanggal Akta", sv(M, 8, 8, date))
				.addFieldValidations(ER3004PosLbPpis0035.genFieldValidation9()));
		fs.add(sf(9, null, "Tanggal Mulai Menjabat", sv(M, 8, 8, date)));
		fs.add(sf(10, null, "Nomor Surat Keputusan Persetujuan Penilaian Kemampuan dan Kepatutan", sv(M, 1, 35, all)));
		fs.add(sf(11, null, "Tanggal Surat Keputusan Persetujuan Penilaian Kemampuan dan Kepatutan",
				sv(M, 8, 8, date)));
		return res;
	}
}
