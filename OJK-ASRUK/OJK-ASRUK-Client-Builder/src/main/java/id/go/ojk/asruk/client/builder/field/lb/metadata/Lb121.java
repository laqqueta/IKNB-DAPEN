package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3061PosLbAsruk121;
import id.go.ojk.asruk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb121 extends BaseMetadata {

	public Lb121(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_121;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3061_LB121.getObject())));
		fs.add(sf(2, null, "Nama Subdana", sv(O, 1, 50, all)));
		fs.add(sf(3, null, "Karakteristik Garansi yang Diberikan - Jenis Garansi yang Diberikan",
				sv(C, 1, 50, all).confConditionalRequired(ER3061PosLbAsruk121.genConditionField())));
		fs.add(sf(4, null, "Karakteristik Garansi yang Diberikan - Mata Uang",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R029.getObject())
						.confConditionalRequired(ER3061PosLbAsruk121.genConditionField())));
		fs.add(sf(5, null, "Karakteristik Garansi yang Diberikan - Kurs",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3061PosLbAsruk121.genConditionField())));
		fs.add(sf(6, null, "Karakteristik Garansi yang Diberikan - Asumsi / Target Tingkat Hasil Investasi",
				sv(C, 1, 16, numericDot).confConditionalRequired(ER3061PosLbAsruk121.genConditionField())));
		fs.add(sf(7, null, "Karakteristik Garansi yang Diberikan - Jumlah Pemegang Polis",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3061PosLbAsruk121.genConditionField())));
		fs.add(sf(8, null, "Karakteristik Garansi yang Diberikan - Jumlah Tertanggung", sv(M, 1, 16, numeric)));
		fs.add(sf(9, null, "Perkembangan Dana - Aset", sv(M, 1, 16, numeric)));
		fs.add(sf(10, null, "Perkembangan Dana - Liabilitas atas Subdana yang Digaransi", sv(M, 1, 16, numeric)));
		fs.add(sf(11, null, "Perkembangan Dana - Rata-rata Penambahan Subdana PAYDI Garansi Bulanan",
				sv(M, 1, 16, numeric)));
		fs.add(sf(12, null, "Estimasi Kebutuhan Aset Back-Up Subdana PAYDI Digaransi 1 Bulan Kedepan",
				sv(M, 1, 16, numeric)));
		return res;
	}
}
