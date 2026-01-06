package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
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
import id.go.ojk.reask.client.builder.field.lb.reference.ER3039PosLbReask208;

public class Lb208 extends BaseMetadata {

	public Lb208(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_208;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER3039PosLbReask208.genFieldSave(), null, ER3039PosLbReask208.getRequiredPos());
		res.addSegmentValidations(ER3039PosLbReask208.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3039_LB208.getObject())));
		fs.add(sf(2, null, "Uraian",
				sv(C, 1, 100, all).confConditionalRequired(ER3039PosLbReask208.genConditionalField2())));
		fs.add(sf(3, null, "Jumlah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3039PosLbReask208.genConditionalField())));
		return res;
	}
}
