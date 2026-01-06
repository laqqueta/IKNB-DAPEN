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
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3067PosLbAsruk625;
import id.go.ojk.asruk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb625 extends BaseMetadata {

	public Lb625(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_625;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3067PosLbAsruk625.genFieldSave(), null,
				ER3067PosLbAsruk625.getRequiredPos());
		res.addSegmentValidations(ER3067PosLbAsruk625.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3067_LB625.getObject())));
		fs.add(sf(2, null, "Kategori Saluran Pemasaran",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R039.getObject())
						.confConditionalRequired(ER3067PosLbAsruk625.genConditionField2())));
		fs.add(sf(3, null, "Jumlah Pihak yang Diseleksi",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3067PosLbAsruk625.genConditionField3())));
		fs.add(sf(4, null, "Jumlah Pihak Baru",
				sv(C, 1, 16, all).confConditionalRequired(ER3067PosLbAsruk625.genConditionField4())));
		fs.add(sf(5, null, "Jumlah Pihak yang Mengikuti Pelatihan",
				sv(C, 1, 16, all).confConditionalRequired(ER3067PosLbAsruk625.genConditionField5())));
		fs.add(sf(6, null, "Jumlah Pihak yang Lulus Pelatihan",
				sv(C, 1, 16, all).confConditionalRequired(ER3067PosLbAsruk625.genConditionField6())));
		fs.add(sf(7, null, "Jumlah Pihak yang Mengikuti Ujian Sertifikasi Pemasar",
				sv(C, 1, 16, all).confConditionalRequired(ER3067PosLbAsruk625.genConditionField7())));
		fs.add(sf(8, null, "Jumlah Pihak yang Lulus Sertifikasi Pemasar",
				sv(C, 1, 16, all).confConditionalRequired(ER3067PosLbAsruk625.genConditionField8())));
		fs.add(sf(9, null, "Jumlah Materi Pemasaran dan Ringkasan Informasi Produk yang Dievaluasi (RIPLAY)",
				sv(C, 1, 16, all).confConditionalRequired(ER3067PosLbAsruk625.genConditionField9())));
		fs.add(sf(10, null, "Jumlah Materi Pemasaran dan Ringkasan Informasi Produk yang Diperbaiki",
				sv(C, 1, 16, all).confConditionalRequired(ER3067PosLbAsruk625.genConditionField10())));
		fs.add(sf(11, null, "Jumlah Pemasar yang Dilakukan Evaluasi",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3067PosLbAsruk625.genConditionField11())));
		fs.add(sf(12, null, "Jumlah Pemasar yang Diberhentikan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3067PosLbAsruk625.genConditionField12())));
		return res;
	}
}
