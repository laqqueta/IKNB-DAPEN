package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3037PosLbAsruk206;
import id.go.ojk.asruk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb206 extends BaseMetadata {

	public Lb206(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_206;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3037PosLbAsruk206.genFieldSave(), null,
				ER3037PosLbAsruk206.getRequiredPos());
		res.addSegmentValidations(ER3037PosLbAsruk206.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3037_LB206.getObject())));
		fs.add(sf(2, null, "Uraian",
				sv(C, 1, 50, all).confConditionalRequired(ER3037PosLbAsruk206.genConditionalField2())));
		fs.add(sf(3, null, "Jenis Beban", sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R047.getObject())
				.confConditionalRequired(ER3037PosLbAsruk206.genConditionalField3())));
		fs.add(sf(4, null, "Jumlah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3037PosLbAsruk206.genConditionalField4())));
		return res;
	}
}
