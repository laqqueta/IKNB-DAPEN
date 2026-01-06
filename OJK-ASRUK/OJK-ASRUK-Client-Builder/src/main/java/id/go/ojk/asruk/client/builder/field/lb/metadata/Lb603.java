package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3055PosLbAsruk603;
import id.go.ojk.asruk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb603 extends BaseMetadata {

	public Lb603(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_603;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3055PosLbAsruk603.genFieldSave(), null,
				ER3055PosLbAsruk603.getRequiredPos());
		res.addSegmentValidations(ER3055PosLbAsruk603.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3055_LB603.getObject())));
		fs.add(sf(2, null, "Dana Jaminan", sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R028.getObject())
				.confConditionalRequired(ER3055PosLbAsruk603.genConditionField2())));
		fs.add(sf(3, null, "Nama Bank Kustodian",
				sv(C, 1, 50, all).confConditionalRequired(ER3055PosLbAsruk603.genConditionFieldA())));
		fs.add(sf(4, null, "Nomor Seri",
				sv(C, 1, 50, all).confConditionalRequired(ER3055PosLbAsruk603.genConditionFieldA())));
		fs.add(sf(5, null, "Mata Uang", sv(C, 1, 3, refTable).confReference(EHeaderMetadataShared.R029.getObject())
				.confConditionalRequired(ER3055PosLbAsruk603.genConditionFieldA())));
		fs.add(sf(6, null, "Nilai Nominal",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3055PosLbAsruk603.genConditionFieldA())));
		fs.add(sf(7, null, "Kurs",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3055PosLbAsruk603.genConditionFieldA())));
		fs.add(sf(8, null, "Nilai Nominal Dalam Rupiah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3055PosLbAsruk603.genConditionFieldB()))
						.addFieldValidations(ER3055PosLbAsruk603.genFieldValidation8()));
		fs.add(sf(9, null, "Tanggal Jatuh Tempo",
				sv(C, 1, 8, date).confConditionalRequired(ER3055PosLbAsruk603.genConditionFieldA())));
		return res;
	}
}
