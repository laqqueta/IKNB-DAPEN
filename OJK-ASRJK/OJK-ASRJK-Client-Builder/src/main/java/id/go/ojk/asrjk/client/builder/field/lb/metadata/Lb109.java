package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3026PosLbAsrjk109;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb109 extends BaseMetadata {

	public Lb109(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_109;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3026PosLbAsrjk109.genFieldSave(),
				ER3026PosLbAsrjk109.genFieldSave(), ER3026PosLbAsrjk109.getRequiredPos());
		res.addSegmentValidations(ER3026PosLbAsrjk109.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3026_LB109.getObject())));
		fs.add(sf(2, null, "Tradisional/PAYDI",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R026.getObject())
						.confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField2())));
		fs.add(sf(3, null, "Jenis Non Investasi",
				sv(C, 0, 30, refTable).confReference(EHeaderMetadataShared.R012.getObject())
						.confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField3())));
		fs.add(sf(4, null, "Nama",
				sv(C, 0, 100, all).confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField4())));
		fs.add(sf(5, null, "Kategori",
				sv(C, 0, 25, refTable).confReference(EHeaderMetadataShared.R013.getObject())
						.confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField5()))
								.addFieldValidations(ER3026PosLbAsrjk109.genFieldValidation5()));
		fs.add(sf(6, null, "Sumber Aset Reasuransi",
				sv(C, 0, 100, refTable).confReference(EHeaderMetadataShared.R014.getObject())
						.confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField6())));
		fs.add(sf(7, null, "Kota/Kabupaten",
				sv(C, 0, 20, refTable).confReference(EHeaderMetadataShared.R006.getObject())
						.confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField7())));
		fs.add(sf(8, null, "Tanggal Persetujuan OJK",
				sv(C, 0, 8, date).confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField8())));
		fs.add(sf(9, null, "Peringkat",
				sv(C, 0, 10, all).confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField9())));
		fs.add(sf(10, null, "Klaster", sv(C, 0, 15, refTable).confReference(EHeaderMetadataShared.R009.getObject())
				.confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField10())));
		fs.add(sf(11, null, "Kurang dari atau sama dengan 1 bulan",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField11())));
		fs.add(sf(12, null, "Lebih dari 1 sampai dengan 2 bulan",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField12())));
		fs.add(sf(13, null, "Lebih dari 2 bulan sampai dengan 3 bulan",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField13())));
		fs.add(sf(14, null, "Lebih dari 3 bulan sampai dengan 1 tahun",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField14())));
		fs.add(sf(15, null, "Saldo SAK Lancar (Kurang dari satu tahun)",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField15())));
		fs.add(sf(16, null, "Lebih dari 1 tahun",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField16())));
		fs.add(sf(17, null, "Saldo SAK",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField17())));
		fs.add(sf(18, null, "AYD",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField18())));
		fs.add(sf(19, null, "Selisih penilaian SAK dan SAP",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3026PosLbAsrjk109.genConditionalField19())));
		return res;
	}
}
