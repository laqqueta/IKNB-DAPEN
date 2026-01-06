package id.go.ojk.asrjk.client.builder.field.lb.metadata;

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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3027PosLbAsrjk110;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb110 extends BaseMetadata {

	public Lb110(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_110;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3027PosLbAsrjk110.genFieldSave(),
				ER3027PosLbAsrjk110.genFieldSave(), ER3027PosLbAsrjk110.getRequiredPos());
		res.addSegmentValidations(ER3027PosLbAsrjk110.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3027_LB110.getObject())));
		fs.add(sf(2, null, "Tradisional/PAYDI",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R026.getObject())
						.confConditionalRequired(ER3027PosLbAsrjk110.genConditionalField2())));
		fs.add(sf(3, null, "Liabilitas", sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R015.getObject())
				.confConditionalRequired(ER3027PosLbAsrjk110.genConditionalField3())));
		fs.add(sf(4, null, "Nama",
				sv(C, 1, 100, all).confConditionalRequired(ER3027PosLbAsrjk110.genConditionalField4())));
		fs.add(sf(5, null, "Kategori",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R016.getObject())
						.confConditionalRequired(ER3027PosLbAsrjk110.genConditionalField5()))
								.addFieldValidations(ER3027PosLbAsrjk110.genValidationField5()));
		fs.add(sf(6, null, "Peringkat",
				sv(C, 1, 10, all).confConditionalRequired(ER3027PosLbAsrjk110.genConditionalField6())));
		fs.add(sf(7, null, "Retensi Sendiri",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3027PosLbAsrjk110.genConditionalField7())));
		fs.add(sf(8, null, "Beban Penanggung Ulang",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3027PosLbAsrjk110.genConditionalField8())));
		fs.add(sf(9, null, "Kurang dari sama dengan 30 hari",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3027PosLbAsrjk110.genConditionalField9())));
		fs.add(sf(10, null, "30 hari",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3027PosLbAsrjk110.genConditionalField10())));
		fs.add(sf(11, null, "Total",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3027PosLbAsrjk110.genConditionalField11())));
		fs.add(sf(12, null, "Saldo SAK Lancar (Kurang dari satu tahun)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3027PosLbAsrjk110.genConditionalField12())));
		return res;
	}
}
