package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternCompanyName;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3001PosLbAsrjk001;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb001 extends BaseMetadata {

	public Lb001(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_001;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3001PosLbAsrjk001.genFieldSave(), null,
				ER3001PosLbAsrjk001.getRequiredPos());
		res.addSegmentValidations(ER3001PosLbAsrjk001.genValidationFixedValue());
		res.addSegmentValidations(ER3001PosLbAsrjk001.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3001_LB001.getObject())));
		fs.add(sf(2, null, "Nama Pemegang Saham", sv(C, 1, 50, all).confRegex(patternCompanyName.c())
				.confConditionalRequired(ER3001PosLbAsrjk001.genConditionalExistPos())));
		fs.add(sf(3, null, "Kepemilikan Saham - Rupiah", sv(M, 1, 15, numeric)));
		fs.add(sf(4, null, "Kepemilikan Saham - Persentase", sv(M, 1, 6, numericDot)));
		return res;
	}
}
