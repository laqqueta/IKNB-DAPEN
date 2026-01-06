package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

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
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2760 extends BaseMetadata {

	public Lb2760(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2760;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R7025_LB2760.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Pihak", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Jenis Asuransi/Penjamin", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R057.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Nomor Polis/Sertifikat Penjaminan", sv(M, 1, 100, all)));
		fs.add(sf(5, null, "Tanggal Penutupan", sv(M, 1, 8, date)));
		fs.add(sf(6, null, "Total Nilai Pertanggungan/Penjaminan", sv(M, 1, 20, numeric)));
		fs.add(sf(7, null, "Retensi Sendiri", sv(M, 1, 20, numeric)));
		fs.add(sf(8, null, "Tanggal Klaim", sv(M, 1, 8, date)));
		fs.add(sf(9, null, "Total Klaim", sv(M, 1, 20, numeric)));
		fs.add(sf(10, null, "Tanggal Persetujuan Klaim", sv(M, 1, 8, date)));
		fs.add(sf(11, null, "Klaim Retensi Sendiri", sv(M, 1, 20, numeric)));
		fs.add(sf(12, null, "Klaim yang Telah Dibayar", sv(M, 1, 20, numeric)));
		fs.add(sf(13, null, "Utang Klaim", sv(M, 1, 20, numeric)));
		return res;
	}
}
