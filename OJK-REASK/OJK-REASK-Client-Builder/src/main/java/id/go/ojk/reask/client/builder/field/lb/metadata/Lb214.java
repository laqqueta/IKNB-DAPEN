package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
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
import id.go.ojk.reask.client.builder.field.lb.reference.ER3051PosLbReask214;

public class Lb214 extends BaseMetadata {

	public Lb214(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_214;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER3051PosLbReask214.genFieldSave(), null, ER3051PosLbReask214.getRequiredPos());
		res.addSegmentValidations(ER3051PosLbReask214.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3051_LB214.getObject())));
		fs.add(sf(2, null, "Uraian",
				sv(C, 1, 100, all).confConditionalRequired(ER3051PosLbReask214.genConditionalField2())));
		fs.add(sf(3, null, "Anggaran",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3051PosLbReask214.genConditionalField())));
		fs.add(sf(4, null, "Realisasi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3051PosLbReask214.genConditionalField())));
		fs.add(sf(5, null, "Persentase",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3051PosLbReask214.genConditionalField()))
				.addFieldValidations(ER3051PosLbReask214.genFieldValidation5()));
		return res;
	}
}
