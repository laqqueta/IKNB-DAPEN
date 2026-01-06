package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3032PosLbAsruk123;
import id.go.ojk.asruk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb123 extends BaseMetadata {

	public Lb123(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_123;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3032PosLbAsruk123.genFieldSave(), null,
				ER3032PosLbAsruk123.getRequiredPos());
		res.addSegmentValidations(ER3032PosLbAsruk123.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3032_LB123.getObject())));
		fs.add(sf(2, null, "Provinsi", sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R015.getObject())
				.confConditionalRequired(ER3032PosLbAsruk123.genConditionField2())));
		fs.add(sf(3, null, "Lini Usaha", sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R045.getObject())
				.confConditionalRequired(ER3032PosLbAsruk123.genConditionField3())));
		fs.add(sf(4, null, "Jenis Okupasi",
				sv(C, 1, 50, all).confConditionalRequired(ER3032PosLbAsruk123.genConditionField4())));
		fs.add(sf(5, null, "Jumlah Risiko",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3032PosLbAsruk123.genConditionField5())));
		fs.add(sf(6, null, "Total Premi",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3032PosLbAsruk123.genConditionField6())));
		fs.add(sf(7, null, "Building",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3032PosLbAsruk123.genConditionField7())));
		fs.add(sf(8, null, "Machinery",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3032PosLbAsruk123.genConditionField8())));
		fs.add(sf(9, null, "Stock",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3032PosLbAsruk123.genConditionField9())));
		fs.add(sf(10, null, "Others",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3032PosLbAsruk123.genConditionField10())));
		fs.add(sf(11, null, "Business Interuption",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3032PosLbAsruk123.genConditionField11())));
		fs.add(sf(12, null, "TOTAL",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3032PosLbAsruk123.genConditionField12())));
		return res;
	}
}
