package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3047PosLbAsrjk211;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb211 extends BaseMetadata {

	public Lb211(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_211;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3047PosLbAsrjk211.genFieldSave(), null,
				ER3047PosLbAsrjk211.getRequiredPos());
		res.addSegmentValidations(ER3047PosLbAsrjk211.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3047_LB211.getObject())));
		fs.add(sf(2, null, "Uraian",
				sv(C, 1, 100, all).confConditionalRequired(ER3047PosLbAsrjk211.genConditionField2())));
		fs.add(sf(3, null, "Anggaran",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3047PosLbAsrjk211.genConditionField())));
		fs.add(sf(4, null, "Realisasi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3047PosLbAsrjk211.genConditionField())));
		fs.add(sf(5, null, "Persentase",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3047PosLbAsrjk211.genConditionField()))
						.addFieldValidations(ER3047PosLbAsrjk211.genFieldValidation5()));
		return res;
	}
}
