package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.lb.reference.ER3065PosLbReask623;
import id.go.ojk.reask.client.builder.field.reference.EHeaderMetadataShared;

public class Lb623 extends BaseMetadata {

	public Lb623(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_623;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER3065PosLbReask623.genFieldSave(), null, ER3065PosLbReask623.getRequiredPos());
		res.addSegmentValidations(ER3065PosLbReask623.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3065_LB623.getObject())));
		fs.add(sf(2, null, "Kelompok",
				sv(C, 1, 6, numeric).confConditionalRequired(ER3065PosLbReask623.genConditionField2())));
		fs.add(sf(3, null, "Tingkat Derajat Kepemilikan",
				sv(C, 1, 6, numeric).confConditionalRequired(ER3065PosLbReask623.genConditionField3())));
		fs.add(sf(4, null, "Nama Pemegang Saham",
				sv(C, 1, 50, all).confConditionalRequired(ER3065PosLbReask623.genConditionField4())));
		fs.add(sf(5, null, "Jenis Pemegang Saham",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R040.getObject())
						.confConditionalRequired(ER3065PosLbReask623.genConditionField5())));
		fs.add(sf(6, null, "Persentase Kepemilikan Saham",
				sv(C, 1, 16, numericDot).confConditionalRequired(ER3065PosLbReask623.genConditionField6())));
		return res;
	}
}
