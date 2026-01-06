package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3036PosLbAsrjk205;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb205 extends BaseMetadata {

	public Lb205(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_205;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3036PosLbAsrjk205.genFieldSave(), null,
				ER3036PosLbAsrjk205.getRequiredPos());
		res.addSegmentValidations(ER3036PosLbAsrjk205.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3036_LB205.getObject())));
		fs.add(sf(2, null, "Jenis Pendapatan",
				sv(C, 1, 50, refTable).confReference(EHeaderMetadataShared.R017.getObject())
						.confConditionalRequired(ER3036PosLbAsrjk205.genConditional2())));
		fs.add(sf(3, null, "Uraian",
				sv(C, 1, 50, all).confConditionalRequired(ER3036PosLbAsrjk205.genConditionField())));
		fs.add(sf(4, null, "Jenis Imbalan",
				sv(C, 1, 16, refTable).confReference(EHeaderMetadataShared.R024.getObject())
						.confConditionalRequired(ER3036PosLbAsrjk205.genConditionField())));
		fs.add(sf(5, null, "Jumlah", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
