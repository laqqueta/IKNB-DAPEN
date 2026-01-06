package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3045PosLbAsrjk220;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb220 extends BaseMetadata {

	public Lb220(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_220;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3045PosLbAsrjk220.genFieldSave(), null,
				ER3045PosLbAsrjk220.getRequiredPos());
		res.addSegmentValidations(ER3045PosLbAsrjk220.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3045_LB220.getObject())));
		fs.add(sf(2, null, "Nama Produk",
				sv(C, 1, 100, all).confConditionalRequired(ER3045PosLbAsrjk220.genConditionField2())));
		fs.add(sf(3, null, "Kode Produk",
				sv(C, 1, 100, all).confConditionalRequired(ER3045PosLbAsrjk220.genConditionField3456789())));
		fs.add(sf(4, null, "Status Produk",
				sv(C, 1, 100, refTable).confReference(EHeaderMetadataShared.R028.getObject())
						.confConditionalRequired(ER3045PosLbAsrjk220.genConditionField3456789())));
		fs.add(sf(5, null, "Kanal Distribusi",
				sv(C, 1, 100, refTable).confReference(EHeaderMetadataShared.R029.getObject())
						.confConditionalRequired(ER3045PosLbAsrjk220.genConditionField3456789())));
		fs.add(sf(6, null, "Tanggal Izin Produk",
				sv(C, 1, 100, date).confConditionalRequired(ER3045PosLbAsrjk220.genConditionField3456789())));
		fs.add(sf(7, null, "Cabang Asuransi",
				sv(C, 1, 100, refTable).confReference(EHeaderMetadataShared.R025.getObject())
						.confConditionalRequired(ER3045PosLbAsrjk220.genConditionField3456789())));
		fs.add(sf(8, null, "Estimasi Profit/Loss*",
				sv(C, 1, 100, refTable).confReference(EHeaderMetadataShared.R030.getObject())
						.confConditionalRequired(ER3045PosLbAsrjk220.genConditionField3456789())));
		fs.add(sf(9, null, "Metode Perhitungan Estimasi*",
				sv(C, 1, 100, refTable).confReference(EHeaderMetadataShared.R031.getObject())
						.confConditionalRequired(ER3045PosLbAsrjk220.genConditionField3456789())));
		fs.add(sf(10, null, "Premi Baru (Rp) ",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3045PosLbAsrjk220.genConditionField())));
		fs.add(sf(11, null, "Jumlah Polis ",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3045PosLbAsrjk220.genConditionField())));
		fs.add(sf(12, null, "Premi Lanjutan (Rp) ",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3045PosLbAsrjk220.genConditionField())));
		fs.add(sf(13, null, "Jumlah Polis ",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3045PosLbAsrjk220.genConditionField())));
		fs.add(sf(14, null, "Jumlah Klaim (Rp)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3045PosLbAsrjk220.genConditionField())));
		fs.add(sf(15, null, "Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3045PosLbAsrjk220.genConditionField())));
		fs.add(sf(16, null, "Cadangan Premi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3045PosLbAsrjk220.genConditionField())));
		fs.add(sf(17, null, "CAPYBMP",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3045PosLbAsrjk220.genConditionField())));
		fs.add(sf(18, null, "Cadangan Klaim Dalam Proses",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3045PosLbAsrjk220.genConditionField())));
		fs.add(sf(19, null, "Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3045PosLbAsrjk220.genConditionField())));
		fs.add(sf(20, null, "Keterangan", sv(O, 1, 1000, all)));
		return res;
	}
}
