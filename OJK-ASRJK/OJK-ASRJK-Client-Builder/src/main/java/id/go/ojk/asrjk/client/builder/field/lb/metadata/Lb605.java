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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3053PosLbAsrjk605;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb605 extends BaseMetadata {

	public Lb605(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_605;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3053PosLbAsrjk605.genFieldSave(), null,
				ER3053PosLbAsrjk605.getRequiredPos());
		res.addSegmentValidations(ER3053PosLbAsrjk605.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3053_LB605.getObject())));
		fs.add(sf(2, null, "Produk Asuransi",
				sv(C, 1, 50, all).confConditionalRequired(ER3053PosLbAsrjk605.genConditionField2())));
		fs.add(sf(3, null, "Jenis Pertanggungan",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R020.getObject())
						.confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldA())));
		fs.add(sf(4, null, "Mata Uang", sv(C, 1, 3, refTable).confReference(EHeaderMetadataShared.R019.getObject())
				.confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldA())));
		fs.add(sf(5, null, "Cara Bayar", sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R022.getObject())
				.confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldA())));
		fs.add(sf(6, null, "Premi Pertanggungan Baru",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldB())));
		fs.add(sf(7, null, "Premi Lanjutan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldB())));
		fs.add(sf(8, null, "Premi Top Up",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldB())));
		fs.add(sf(9, null, "Premi Risiko",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldB())));
		fs.add(sf(10, null, "Premi Investasi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldB())));
		fs.add(sf(11, null, "Total Premi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldB()))
						.addFieldValidations(ER3053PosLbAsrjk605.genFieldValidation11()));
		fs.add(sf(12, null, "Komisi Pertanggungan Baru",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldB())));
		fs.add(sf(13, null, "Komisi Lanjutan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldB())));
		fs.add(sf(14, null, "Biaya Akuisisi Lainnya",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldB())));
		fs.add(sf(15, null, "Biaya Pemeliharaan Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldB())));
		fs.add(sf(16, null, "Biaya Lainnya",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldB())));
		fs.add(sf(17, null, "Biaya Pengelolaan Investasi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldB())));
		fs.add(sf(18, null, "Total Biaya",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3053PosLbAsrjk605.genConditionFieldB()))
						.addFieldValidations(ER3053PosLbAsrjk605.genFieldValidation18()));
		return res;
	}
}
