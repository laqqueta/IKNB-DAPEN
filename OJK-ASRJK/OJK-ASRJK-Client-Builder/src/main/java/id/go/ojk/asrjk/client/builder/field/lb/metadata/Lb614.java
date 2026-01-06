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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3057PosLbAsrjk614;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb614 extends BaseMetadata {

	public Lb614(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_614;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3057PosLbAsrjk614.genFieldSave(), null,
				ER3057PosLbAsrjk614.getRequiredPos());
		res.addSegmentValidations(ER3057PosLbAsrjk614.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3057_LB614.getObject())));
		fs.add(sf(2, null, "Nama Produk",
				sv(C, 1, 50, all).confConditionalRequired(ER3057PosLbAsrjk614.genConditionField2())));
		fs.add(sf(3, null, "Cabang Asuransi",
				sv(C, 1, 25, refTable).confReference(EHeaderMetadataShared.R025.getObject())
						.confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldA())));
		fs.add(sf(4, null, "Jenis Pertanggungan",
				sv(C, 1, 25, refTable).confReference(EHeaderMetadataShared.R020.getObject())
						.confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldA())));
		fs.add(sf(5, null, "Masa Pertanggungan",
				sv(C, 1, 5, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldA())));
		fs.add(sf(6, null, "Jumlah Polis/Peserta",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldB())));
		fs.add(sf(7, null, "Jumlah UP",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldB())));
		fs.add(sf(8, null, "Total Premi - Premi Neto",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldB())));
		fs.add(sf(9, null, "Total Premi - Premi Reasuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldB())));
		fs.add(sf(10, null, "Premi yang Belum Merupakan Pendapatan - US $ dan Valas Lain",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldB())));
		fs.add(sf(11, null, "Premi yang Belum Merupakan Pendapatan - Rupiah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldB())));
		fs.add(sf(12, null, "Premi yang Belum Merupakan Pendapatan - Jumlah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldB()))
						.addFieldValidations(ER3057PosLbAsrjk614.genFieldValidation12()));
		fs.add(sf(13, null, "Cadangan Klaim - Klaim Dalam Proses - US $ dan Valas Lain",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldB())));
		fs.add(sf(14, null, "Cadangan Klaim - Klaim Dalam Proses - Rupiah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldB())));
		fs.add(sf(15, null, "Cadangan Klaim - Klaim Dalam Proses - Jumlah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldB()))
						.addFieldValidations(ER3057PosLbAsrjk614.genFieldValidation15()));
		fs.add(sf(16, null, "Cadangan Klaim - IBNR - US $ dan Valas Lain",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldB())));
		fs.add(sf(17, null, "Cadangan Klaim - IBNR - Rupiah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldB())));
		fs.add(sf(18, null, "Cadangan Klaim - IBNR - Jumlah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3057PosLbAsrjk614.genConditionFieldB()))
						.addFieldValidations(ER3057PosLbAsrjk614.genFieldValidation18()));
		return res;
	}
}
