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
import id.go.ojk.reass.client.builder.field.lb.reference.ER3029PosLbReass221;

public class Lb221 extends BaseMetadata {

	public Lb221(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_221;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 15, 15, ER3029PosLbReass221.genFieldSave(), null, ER3029PosLbReass221.getRequiredPos());
		res.addSegmentValidations(ER3029PosLbReass221.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3029_LB221.getObject())).confUnique(U));
		fs.add(sf(2, null, "Penyisihan Klaim", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "AR", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "fpk",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3029PosLbReass221.genConditional4()))
				.addFieldValidations(ER3029PosLbReass221.genValidation4()));
		fs.add(sf(5, null, "Jumlah Deviasi Penyisihan Klaim ((2) - (3)) x (4)", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3029PosLbReass221.genValidation5()));
		return res;
	}
}
