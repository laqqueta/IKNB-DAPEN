package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternCompanyName;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.reference.EHeaderMetadataShared;

public class Lb002 extends BaseMetadata {

	public Lb002(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_002;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3002_LB002.getObject())));
		fs.add(sf(2, null, "Nama Direksi/Komisaris", sv(M, 1, 50, all).confRegex(patternCompanyName.c())));
		fs.add(sf(3, null, "Jabatan", sv(M, 1, 150, all).confRegex(patternCompanyName.c())));
		fs.add(sf(4, null, "Flag Direksi/Komisaris",
				sv(M, 1, 6, refTable).confReference(EHeaderMetadataShared.R006.getObject())));
		return res;
	}
}
