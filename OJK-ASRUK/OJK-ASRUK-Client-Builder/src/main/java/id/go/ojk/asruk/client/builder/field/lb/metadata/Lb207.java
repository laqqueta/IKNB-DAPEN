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
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3038PosLbAsruk207;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb207 extends BaseMetadata {

	public Lb207(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_207;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3038PosLbAsruk207.genFieldSave(), null,
				ER3038PosLbAsruk207.getRequiredPos());
		res.addSegmentValidations(ER3038PosLbAsruk207.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3038_LB207.getObject())));
		fs.add(sf(2, null, "Uraian",
				sv(C, 1, 50, all).confConditionalRequired(ER3038PosLbAsruk207.genConditionalField2())));
		fs.add(sf(3, null, "Hasil Lain - Kegiatan Usaha Berbasis Imbalan Jasa (Fee Based) - Jasa Administrasi (ASO)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3038PosLbAsruk207.genConditionalField())));
		fs.add(sf(4, null, "Hasil Lain - Kegiatan Usaha Berbasis Imbalan Jasa (Fee Based) - Fee Penjualan Reksa Dana",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3038PosLbAsruk207.genConditionalField())));
		fs.add(sf(5, null, "Hasil Lain - Kegiatan Usaha Berbasis Imbalan Jasa (Fee Based) - Fee Based Lainnya",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3038PosLbAsruk207.genConditionalField())));
		fs.add(sf(6, null, "Hasil Lainnya",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3038PosLbAsruk207.genConditionalField())));
		fs.add(sf(7, null, "Total Hasil Lain",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3038PosLbAsruk207.genConditionalField()))
						.addFieldValidations(ER3038PosLbAsruk207.genFieldValidation7()));
		fs.add(sf(8, null, "Beban Lain",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3038PosLbAsruk207.genConditionalField())));
		fs.add(sf(9, null, "Jumlah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3038PosLbAsruk207.genConditionalField()))
						.addFieldValidations(ER3038PosLbAsruk207.genFieldValidation9()));
		return res;
	}
}
