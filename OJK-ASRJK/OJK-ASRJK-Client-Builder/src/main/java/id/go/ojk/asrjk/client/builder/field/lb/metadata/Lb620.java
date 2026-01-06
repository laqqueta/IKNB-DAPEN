package id.go.ojk.asrjk.client.builder.field.lb.metadata;

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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3067PosLbAsrjk620;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb620 extends BaseMetadata {

	public Lb620(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_620;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3067PosLbAsrjk620.genFieldSave(), null,
				ER3067PosLbAsrjk620.getRequiredPos());
		res.addSegmentValidations(ER3067PosLbAsrjk620.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3067_LB620.getObject())));
		fs.add(sf(2, null, "Kelompok",
				sv(C, 1, 6, numeric).confConditionalRequired(ER3067PosLbAsrjk620.genConditionField2())));
		fs.add(sf(3, null, "Tingkat Derajat Kepemilikan",
				sv(C, 1, 6, numeric).confConditionalRequired(ER3067PosLbAsrjk620.genConditionField3())));
		fs.add(sf(4, null, "Nama Pemegang Saham",
				sv(C, 1, 50, all).confConditionalRequired(ER3067PosLbAsrjk620.genConditionField4())));
		fs.add(sf(5, null, "Jenis Pemegang Saham",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R043.getObject())
						.confConditionalRequired(ER3067PosLbAsrjk620.genConditionField5())));
		fs.add(sf(6, null, "Persentase Kepemilikan Saham",
				sv(C, 1, 16, numericDot).confConditionalRequired(ER3067PosLbAsrjk620.genConditionField6())));
		return res;
	}
}
