package id.go.ojk.fink.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternLJKAddress;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fink.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fink.client.builder.field.lb.reference.EHeaderMetadataLb;

public class Lb6909 extends BaseMetadata {

	public Lb6909(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_6909;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3015_LB6909.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Tanggal Kegiatan", sv(M, 1, 8, date)));
		fs.add(sf(3, null, "Nama Kegiatan", sv(M, 1, 1000, all).confRegex(patternLJKAddress)));
		fs.add(sf(4, null, "Tempat Kegiatan", sv(M, 1, 100, all).confRegex(patternLJKAddress)));
		fs.add(sf(5, null, "Estimasi Jumlah Orang yang Terlibat", sv(M, 1, 10, numeric)));
		return res;
	}
}
