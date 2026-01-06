package id.go.ojk.reass.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reass.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reass.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reass.client.builder.field.lb.reference.ER3043PosLbReass235;
import id.go.ojk.reass.client.builder.field.reference.EHeaderMetadataShared;

public class Lb235 extends BaseMetadata {

	public Lb235(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_235;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3043_LB235.getObject())));
		fs.add(sf(2, null, "Nama Produk", sv(O, 1, 100, all)));
		fs.add(sf(3, null, "Jenis Polis (Kumpulan/Individual)",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R023.getObject())
						.confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(4, null, "Lini Usaha", sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R025.getObject())
				.confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(5, null, "Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Jumlah Peserta Aktif pada Awal Periode Laporan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(6, null, "Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Jumlah Peserta Baru Dalam Periode Laporan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(7, null,
				"Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Jumlah Kepesertaan yang Diperpanjang pada Periode Laporan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(8, null,
				"Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Jumlah Kepesertaan yang Berakhir Karena Jatuh Tempo",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(9, null, "Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Jumlah Kepesertaan yang Dibatalkan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(10, null, "Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Jumlah Kepesertaan yang Berakhir Karena Klaim",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(11, null,
				"Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Jumlah Peserta Aktif pada Akhir Periode Laporan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(12, null, "Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Premi / Kontribusi Bruto (Rp)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(13, null, "Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Klaim Bruto (Rp)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(14, null, "Sesuai dengan SE OJK NO. 9/SEOJK.05/2017-Peserta yang Klaim",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(15, null,
				"Tidak Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Jumlah Peserta Aktif pada Awal Periode Laporan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(16, null,
				"Tidak Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Jumlah Peserta Baru Dalam Periode Laporan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(17, null,
				"Tidak Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Jumlah Kepesertaan yang Diperpanjang pada Periode Laporan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(18, null,
				"Tidak Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Jumlah Kepesertaan yang Berakhir Karena Jatuh Tempo",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(19, null,
				"Tidak Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Jumlah Kepesertaan yang Berakhir Karena Klaim",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(20, null,
				"Tidak Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Jumlah Peserta Aktif pada Akhir Periode Laporan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(21, null, "Tidak Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Premi / Kontribusi Bruto (Rp)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(22, null, "Tidak Sesuai dengan SE OJK NO. 9/SEOJK.05/2017 - Klaim Bruto (Rp)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		fs.add(sf(23, null, "Tidak Sesuai dengan SE OJK NO. 9/SEOJK.05/2017-Peserta yang Klaim",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3043PosLbReass235.genConditional())));
		return res;
	}
}
