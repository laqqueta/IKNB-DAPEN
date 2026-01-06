package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumericNegatif;
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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3025PosLbAsrjk108;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
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
				new ArrayList<>(), extension, 1, null, ER3025PosLbAsrjk108.genFieldSave(),
				ER3025PosLbAsrjk108.genFieldSave(), ER3025PosLbAsrjk108.getRequiredPos());
		res.addSegmentValidations(ER3025PosLbAsrjk108.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3025_LB108.getObject())));
		fs.add(sf(2, null, "Jenis Investasi",
				sv(C, 0, 50, refTable).confReference(EHeaderMetadataShared.R002.getObject())
						.confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField2())));
		fs.add(sf(3, null, "Dalam Negeri/Luar Negeri",
				sv(C, 0, 6, refTable).confReference(EHeaderMetadataShared.R008.getObject())
						.confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField3())));
		fs.add(sf(4, null, "Kode",
				sv(C, 0, 50, all).confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField4()))
						.addFieldValidations(ER3025PosLbAsrjk108.genFieldValidation4a())
						.addFieldValidations(ER3025PosLbAsrjk108.genFieldValidation4b())
						.addFieldValidations(ER3025PosLbAsrjk108.genFieldValidation4c()));
		fs.add(sf(5, null, "Nama",
				sv(C, 0, 100, all).confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField5())));
		fs.add(sf(6, null, "Nomor Seri",
				sv(C, 0, 50, all).confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField6())));
		fs.add(sf(7, null, "Kategori",
				sv(C, 0, 50, refTable).confReference(EHeaderMetadataShared.R001.getObject())
						.confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField7()))
								.addFieldValidations(ER3025PosLbAsrjk108.genFieldValidation7()));
		fs.add(sf(8, null, "Sektor Ekonomi",
				sv(C, 0, 50, refTable).confReference(EHeaderMetadataShared.R011.getObject())
						.confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField8()))
								.addFieldValidations(ER3025PosLbAsrjk108.genFieldValidation8()));
		fs.add(sf(9, null, "Nama Manager Investasi",
				sv(C, 0, 100, all).confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField9())));
		fs.add(sf(10, null, "Peringkat",
				sv(C, 0, 50, all).confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField10())));
		fs.add(sf(11, null, "Klaster", sv(C, 0, 1, refTable).confReference(EHeaderMetadataShared.R009.getObject())
				.confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField11())));
		fs.add(sf(12, null, "Jenis Jaminan",
				sv(C, 0, 6, refTable).confReference(EHeaderMetadataShared.R010.getObject())
						.confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField12())));
		fs.add(sf(13, null, "Jangka Waktu",
				sv(C, 0, 15, all).confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField13())));
		fs.add(sf(14, null, "Nilai Pasar Jaminan Saat Penempatan",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField14())));
		fs.add(sf(15, null, "Saldo Saat Penempatan",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField15())));
		fs.add(sf(16, null, "Jumlah",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField16())));
		fs.add(sf(17, null, "Saldo SAK", sv(C, 0, 16, all).confRegex(patternNumericNegatif.c())
				.confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField17())));
		fs.add(sf(18, null, "AYD", sv(C, 0, 16, all).confRegex(patternNumericNegatif.c())
				.confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField18())));
		fs.add(sf(19, null, "Selisih Penilaian SAK dan SAP",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField19())));
		fs.add(sf(20, null, "Saldo SAK Lancar (Kurang dari satu tahun)",
				sv(C, 0, 16, all).confRegex(patternNumericNegatif.c())
						.confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField20())));
		fs.add(sf(21, null, "Keterangan",
				sv(C, 0, 100, all).confConditionalRequired(ER3025PosLbAsrjk108.genConditionalField21())));
		return res;
	}
}
