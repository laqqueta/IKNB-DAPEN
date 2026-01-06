package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3061PosLbAsrjk617;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb617 extends BaseMetadata {

	public Lb617(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_617;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3061_LB617.getObject())));
		fs.add(sf(2, null, "Nama Subdana", sv(O, 1, 50, all)));
		fs.add(sf(3, null, "Mata Uang", sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R019.getObject())
				.confConditionalRequired(ER3061PosLbAsrjk617.genConditionField())));
		fs.add(sf(4, null, "Kurs",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3061PosLbAsrjk617.genConditionField())));
		fs.add(sf(5, null, "NAB",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3061PosLbAsrjk617.genConditionField())));
		fs.add(sf(6, null, "NAB/Unit",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3061PosLbAsrjk617.genConditionField())));
		fs.add(sf(7, null, "Hasil Investasi Tahunan",
				sv(C, 1, 16, numericDot).confConditionalRequired(ER3061PosLbAsrjk617.genConditionField())));
		fs.add(sf(8, null, "Hasil Investasi Benchmark",
				sv(C, 1, 16, numericDot).confConditionalRequired(ER3061PosLbAsrjk617.genConditionField())));
		fs.add(sf(9, null, "SHARPE Ratio",
				sv(C, 1, 16, numericDot).confConditionalRequired(ER3061PosLbAsrjk617.genConditionField())));
		return res;
	}
}
