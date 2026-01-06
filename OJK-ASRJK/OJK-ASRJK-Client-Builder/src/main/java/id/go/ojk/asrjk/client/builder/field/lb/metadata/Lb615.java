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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3058PosLbAsrjk615;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb615 extends BaseMetadata {

	public Lb615(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_615;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3058PosLbAsrjk615.genFieldSave(), null,
				ER3058PosLbAsrjk615.getRequiredPos());
		res.addSegmentValidations(ER3058PosLbAsrjk615.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3058_LB615.getObject())));
		fs.add(sf(2, null, "Produk Investasi",
				sv(C, 1, 50, all).confConditionalRequired(ER3058PosLbAsrjk615.genConditionField2())));
		fs.add(sf(3, null, "Jenis Pertanggungan",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R020.getObject())
						.confConditionalRequired(ER3058PosLbAsrjk615.genConditionFieldA())));
		fs.add(sf(4, null, "Mata Uang", sv(C, 1, 3, refTable).confReference(EHeaderMetadataShared.R019.getObject())
				.confConditionalRequired(ER3058PosLbAsrjk615.genConditionFieldA())));
		fs.add(sf(5, null, "Jumlah Polis",
				sv(C, 1, 15, numericNegatif).confConditionalRequired(ER3058PosLbAsrjk615.genConditionFieldB())));
		fs.add(sf(6, null, "Jumlah Peserta",
				sv(C, 1, 15, numericNegatif).confConditionalRequired(ER3058PosLbAsrjk615.genConditionFieldB())));
		fs.add(sf(7, null, "Jumlah UP",
				sv(C, 1, 15, numericNegatif).confConditionalRequired(ER3058PosLbAsrjk615.genConditionFieldB())));
		fs.add(sf(8, null, "Cadangan Premi - Term",
				sv(C, 1, 15, numericNegatif).confConditionalRequired(ER3058PosLbAsrjk615.genConditionFieldB())));
		fs.add(sf(9, null, "Cadangan Premi - P.A.",
				sv(C, 1, 15, numericNegatif).confConditionalRequired(ER3058PosLbAsrjk615.genConditionFieldB())));
		fs.add(sf(10, null, "Cadangan Premi - Health",
				sv(C, 1, 15, numericNegatif).confConditionalRequired(ER3058PosLbAsrjk615.genConditionFieldB())));
		fs.add(sf(11, null, "Akumulasi Dana",
				sv(C, 1, 15, numericNegatif).confConditionalRequired(ER3058PosLbAsrjk615.genConditionFieldB())));
		return res;
	}
}
