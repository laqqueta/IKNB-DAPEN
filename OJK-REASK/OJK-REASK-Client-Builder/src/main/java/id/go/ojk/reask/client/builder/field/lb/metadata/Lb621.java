package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
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
import id.go.ojk.reask.client.builder.field.lb.reference.ER3063PosLbReask621;
import id.go.ojk.reask.client.builder.field.reference.EHeaderMetadataShared;

public class Lb621 extends BaseMetadata {

	public Lb621(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_621;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER3063PosLbReask621.genFieldSave(), null, ER3063PosLbReask621.getRequiredPos());
		res.addSegmentValidations(ER3063PosLbReask621.genValidationTotalInvestasi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3063_LB621.getObject())));
		fs.add(sf(2, null, "Nama Produk",
				sv(C, 1, 50, all).confConditionalRequired(ER3063PosLbReask621.genConditionField2())));
		fs.add(sf(3, null, "Jenis Polis (Kumpulan/Individu)",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R017.getObject())
						.confConditionalRequired(ER3063PosLbReask621.genConditionField3())));
		fs.add(sf(4, null, "Lini Usaha", sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R018.getObject())
				.confConditionalRequired(ER3063PosLbReask621.genConditionField4())));
		fs.add(sf(5, null, "Jumlah Peserta Aktif pada Awal Periode Laporan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField5())));
		fs.add(sf(6, null, "Jumlah Peserta Baru Dalam Periode Laporan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField6())));
		fs.add(sf(7, null, "Jumlah Kepesertaan yang Diperpanjang pada Periode Laporan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField7())));
		fs.add(sf(8, null, "Jumlah Kepesertaan yang Berakhir Karena Jatuh Tempo",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField8())));
		fs.add(sf(9, null, "Jumlah Kepesertaan yang Dibatalkan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField9())));
		fs.add(sf(10, null, "Jumlah Kepesertaan yang Berakhir Karena Klaim",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField10())));
		fs.add(sf(11, null, "Jumlah Peserta Aktif pada Akhir Periode Laporan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField11())));
		fs.add(sf(12, null, "Premi / Kontribusi Bruto (Rp)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField12())));
		fs.add(sf(13, null, "Klaim Bruto (Rp)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField13())));
		fs.add(sf(14, null, "Jumlah Peserta Aktif pada Awal Periode Laporan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField14())));
		fs.add(sf(15, null, "Jumlah Peserta Baru Dalam Periode Laporan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField15())));
		fs.add(sf(16, null, "Jumlah Kepesertaan yang Diperpanjang pada Periode Laporan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField16())));
		fs.add(sf(17, null, "Jumlah Kepesertaan yang Berakhir Karena Jatuh Tempo",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField17())));
		fs.add(sf(18, null, "Jumlah Kepesertaan yang Dibatalkan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField18())));
		fs.add(sf(19, null, "Jumlah Kepesertaan yang Berakhir Karena Klaim",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField19())));
		fs.add(sf(20, null, "Jumlah Peserta Aktif pada Akhir Periode Laporan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField20())));
		fs.add(sf(21, null, "Premi / Kontribusi Bruto (Rp)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField21())));
		fs.add(sf(22, null, "Klaim Bruto (Rp)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3063PosLbReask621.genConditionField22())));
		return res;
	}
}
