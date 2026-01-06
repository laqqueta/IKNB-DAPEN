package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
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
import id.go.ojk.reask.client.builder.field.lb.reference.ER3047PosLbReask220;
import id.go.ojk.reask.client.builder.field.reference.EHeaderMetadataShared;

public class Lb220 extends BaseMetadata {

	public Lb220(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_220;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER3047PosLbReask220.genFieldSave(), null, ER3047PosLbReask220.getRequiredPos());
		res.addSegmentValidations(ER3047PosLbReask220.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3047_LB220.getObject())));
		fs.add(sf(2, null, "Nama Produk",
				sv(C, 1, 100, all).confConditionalRequired(ER3047PosLbReask220.genConditionField2())));
		fs.add(sf(3, null, "Kode Produk",
				sv(C, 1, 100, all).confConditionalRequired(ER3047PosLbReask220.genConditionFieldA())));
		fs.add(sf(4, null, "Status Produk", sv(C, 1, 3, refTable).confReference(EHeaderMetadataShared.R020.getObject())
				.confConditionalRequired(ER3047PosLbReask220.genConditionFieldA())));
		fs.add(sf(5, null, "Kanal Distribusi",
				sv(C, 1, 3, refTable).confReference(EHeaderMetadataShared.R021.getObject())
						.confConditionalRequired(ER3047PosLbReask220.genConditionFieldA())));
		fs.add(sf(6, null, "Tanggal Izin Produk",
				sv(C, 1, 8, date).confConditionalRequired(ER3047PosLbReask220.genConditionFieldA())));
		fs.add(sf(7, null, "Lini Usaha", sv(C, 1, 3, refTable).confReference(EHeaderMetadataShared.R027.getObject())
				.confConditionalRequired(ER3047PosLbReask220.genConditionFieldA())));
		fs.add(sf(8, null, " Estimasi Profit/Loss*",
				sv(C, 1, 3, refTable).confReference(EHeaderMetadataShared.R022.getObject())
						.confConditionalRequired(ER3047PosLbReask220.genConditionFieldA())));
		fs.add(sf(9, null, " Metode Perhitungan Estimasi*",
				sv(C, 1, 3, refTable).confReference(EHeaderMetadataShared.R023.getObject())
						.confConditionalRequired(ER3047PosLbReask220.genConditionFieldA())));
		fs.add(sf(10, null, "Premi - Jumlah Premi (Rp)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3047PosLbReask220.genConditionFieldB())));
		fs.add(sf(11, null, "Premi - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3047PosLbReask220.genConditionFieldB())));
		fs.add(sf(12, null, "Klaim - Jumlah Klaim (Rp)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3047PosLbReask220.genConditionFieldB())));
		fs.add(sf(13, null, "Klaim - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3047PosLbReask220.genConditionFieldB())));
		fs.add(sf(14, null, "Cadangan Teknis* - Cadangan Premi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3047PosLbReask220.genConditionFieldB())));
		fs.add(sf(15, null, "Cadangan Teknis* - CAPYBMP",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3047PosLbReask220.genConditionFieldB())));
		fs.add(sf(16, null, "Cadangan Teknis* - Cadangan Klaim Dalam Proses",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3047PosLbReask220.genConditionFieldB())));
		fs.add(sf(17, null, "Keterangan",
				sv(C, 1, 100, all).confConditionalRequired(ER3047PosLbReask220.genConditionFieldA())));
		return res;
	}
}
