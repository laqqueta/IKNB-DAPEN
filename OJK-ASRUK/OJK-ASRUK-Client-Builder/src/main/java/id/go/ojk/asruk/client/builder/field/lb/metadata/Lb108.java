package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3025PosLbAsruk108;
import id.go.ojk.asruk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb108 extends BaseMetadata {

	public Lb108(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_108;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3025PosLbAsruk108.genFieldSave(),
				ER3025PosLbAsruk108.genFieldSave(), ER3025PosLbAsruk108.getRequiredPos());
		res.addSegmentValidations(ER3025PosLbAsruk108.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3025_LB108.getObject())));
		fs.add(sf(2, null, "Jenis Investasi",
				sv(C, 0, 6, refTable).confReference(EHeaderMetadataShared.R002.getObject())
						.confConditionalRequired(ER3025PosLbAsruk108.genConditionalField2())));
		fs.add(sf(3, null, "Dalam Negeri/Luar Negeri",
				sv(C, 0, 6, refTable).confReference(EHeaderMetadataShared.R018.getObject())
						.confConditionalRequired(ER3025PosLbAsruk108.genConditionalField3())));
		fs.add(sf(4, null, "Kode (counterparty)",
				sv(C, 0, 30, all).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField4()))
						.addFieldValidations(ER3025PosLbAsruk108.genFieldValidation4a())
						.addFieldValidations(ER3025PosLbAsruk108.genFieldValidation4b()));
		fs.add(sf(5, null, "Nama (counterparty)",
				sv(C, 0, 100, all).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField5())));
		fs.add(sf(6, null, "Nomor Seri",
				sv(C, 0, 50, all).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField6())));
		fs.add(sf(7, null, "Kategori",
				sv(C, 0, 6, refTable).confReference(EHeaderMetadataShared.R001.getObject())
						.confConditionalRequired(ER3025PosLbAsruk108.genConditionalField7()))
								.addFieldValidations(ER3025PosLbAsruk108.genFieldValidation7()));
		fs.add(sf(8, null, "Sektor Ekonomi",
				sv(C, 0, 6, refTable).confReference(EHeaderMetadataShared.R021.getObject())
						.confConditionalRequired(ER3025PosLbAsruk108.genConditionalField8()))
								.addFieldValidations(ER3025PosLbAsruk108.genFieldValidation8()));
		fs.add(sf(9, null, "Nama Manager Investasi",
				sv(C, 0, 100, all).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField9())));
		fs.add(sf(10, null, "Peringkat",
				sv(C, 0, 50, all).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField10())));
		fs.add(sf(11, null, "Klaster", sv(C, 0, 2, refTable).confReference(EHeaderMetadataShared.R019.getObject())
				.confConditionalRequired(ER3025PosLbAsruk108.genConditionalField11())));
		fs.add(sf(12, null, "Jenis Jaminan",
				sv(C, 0, 6, refTable).confReference(EHeaderMetadataShared.R020.getObject())
						.confConditionalRequired(ER3025PosLbAsruk108.genConditionalField12())));
		fs.add(sf(13, null, "Jangka Waktu",
				sv(C, 0, 10, all).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField13())));
		fs.add(sf(14, null, "Nilai Pasar Jaminan Saat Penempatan",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField14())));
		fs.add(sf(15, null, "Saldo Saat Penempatan",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField15())));
		fs.add(sf(16, null, "Jumlah",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField16())));
		fs.add(sf(17, null, "Saldo SAK",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField17())));
		fs.add(sf(18, null, "AYD",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField18())));
		fs.add(sf(19, null, "Selisih Penilaian SAK dan SAP",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField19())));
		fs.add(sf(20, null, "Saldo SAK Lancar (Kurang dari satu tahun)",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField20())));
		fs.add(sf(21, null, "Keterangan",
				sv(C, 0, 100, all).confConditionalRequired(ER3025PosLbAsruk108.genConditionalField21())));
		return res;
	}
}
