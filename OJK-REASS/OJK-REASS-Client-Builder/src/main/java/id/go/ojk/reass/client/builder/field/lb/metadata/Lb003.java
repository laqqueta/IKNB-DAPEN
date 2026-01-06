package id.go.ojk.reass.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternCompanyName;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reass.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reass.client.builder.field.lb.reference.EHeaderMetadataLb;

public class Lb003 extends BaseMetadata {

	public Lb003(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_003;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3003_LB003.getObject())));
		fs.add(sf(2, null, "Uraian", sv(M, 1, 50, all).confRegex(patternCompanyName.c())));
		fs.add(sf(3, null, "Anggaran", sv(M, 1, 15, numeric)));
		fs.add(sf(4, null, "Realisasi", sv(M, 1, 15, numeric)));
		fs.add(sf(5, null, "Persentase", sv(M, 1, 6, numericDot)));
		return res;
	}
}
