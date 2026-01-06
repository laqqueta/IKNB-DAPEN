package id.go.ojk.reass.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reass.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reass.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reass.client.builder.field.lb.reference.ER3028PosLbReass220;

public class Lb220 extends BaseMetadata {

	public Lb220(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_220;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 15, 15, ER3028PosLbReass220.genFieldSave(), null, ER3028PosLbReass220.getRequiredPos());
		res.addSegmentValidations(ER3028PosLbReass220.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3028_LB220.getObject())).confUnique(U));
		fs.add(sf(2, null, "PAKYBMP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "AR", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "fpk",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3028PosLbReass220.genConditional4()))
				.addFieldValidations(ER3028PosLbReass220.genValidation4()));
		fs.add(sf(5, null, "Jumlah Deviasi PAKYBMP ((2) - (3)) x (4)", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3028PosLbReass220.genValidation5()));
		return res;
	}
}
