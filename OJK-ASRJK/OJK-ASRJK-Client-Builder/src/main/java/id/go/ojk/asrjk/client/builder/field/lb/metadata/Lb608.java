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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3056PosLbAsrjk608;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb608 extends BaseMetadata {

	public Lb608(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_608;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3056PosLbAsrjk608.genFieldSave(), null,
				ER3056PosLbAsrjk608.getRequiredPos());
		res.addSegmentValidations(ER3056PosLbAsrjk608.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3056_LB608.getObject())));
		fs.add(sf(2, null, "Jenis Pertanggungan",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R020.getObject())
						.confConditionalRequired(ER3056PosLbAsrjk608.genConditionField2())));
		fs.add(sf(3, null, "Mata Uang", sv(C, 1, 3, refTable).confReference(EHeaderMetadataShared.R019.getObject())
				.confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldA())));
		fs.add(sf(4, null, "Nama Produk",
				sv(C, 1, 150, all).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldA())));
		fs.add(sf(5, null, "Cabang Asuransi",
				sv(C, 1, 50, refTable).confReference(EHeaderMetadataShared.R023.getObject())
						.confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldA())));
		fs.add(sf(6, null, "S.P",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldB())));
		fs.add(sf(7, null, "P.U",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldB())));
		fs.add(sf(8, null, "P.R",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldB())));
		fs.add(sf(9, null, "S.P",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldB())));
		fs.add(sf(10, null, "P.U",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldB())));
		fs.add(sf(11, null, "P.R",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldB())));
		fs.add(sf(12, null, "Tahun Berjalan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldB())));
		fs.add(sf(13, null, "Tahun Lalu",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldB())));
		fs.add(sf(14, null, "Tahun Berjalan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldB())));
		fs.add(sf(15, null, "Tahun Lalu",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldB())));
		fs.add(sf(16, null, "Premi Murni",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldB())));
		fs.add(sf(17, null, "Premi Bruto",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldB())));
		fs.add(sf(18, null, "Rata-rata Masa Kontrak",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldA())));
		fs.add(sf(19, null, "Rata-rata Usia Tertanggung",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldA())));
		fs.add(sf(20, null, "Rata-rata Usia Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldA())));
		fs.add(sf(21, null, "Tabel Mortalita",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldA())));
		fs.add(sf(22, null, "Bunga Aktuaria",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldA())));
		fs.add(sf(23, null, "Metoda Perhitungan",
				sv(C, 1, 250, all).confConditionalRequired(ER3056PosLbAsrjk608.genConditionFieldA())));
		return res;
	}
}
