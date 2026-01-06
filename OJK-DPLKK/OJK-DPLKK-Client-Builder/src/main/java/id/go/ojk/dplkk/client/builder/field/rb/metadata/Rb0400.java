package id.go.ojk.dplkk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dplkk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dplkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dplkk.client.builder.field.rb.reference.ER2003PosRbDplkk0400;

public class Rb0400 extends BaseMetadata {

	public Rb0400(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0400;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 44, 44, ER2003PosRbDplkk0400.genFieldSave(), null,
				ER2003PosRbDplkk0400.getRequiredPos());
		res.addSegmentValidations(ER2003PosRbDplkk0400.genValidationFixedValue());
		res.addSegmentValidations(ER2003PosRbDplkk0400.genValidationBerdasarkanNilaiPerolehan());
		res.addSegmentValidations(ER2003PosRbDplkk0400.genValidationRatioBerdasarkanNilaiPerolehan());
		res.addSegmentValidations(ER2003PosRbDplkk0400.genValidationRatioNilaiPerolehan3());
		res.addSegmentValidations(ER2003PosRbDplkk0400.genValidationRatioNilaiPerolehan5());
		res.addSegmentValidations(ER2003PosRbDplkk0400.genValidationRatioNilaiPerolehan7());
		res.addSegmentValidations(ER2003PosRbDplkk0400.genValidationRatioNilaiPerolehan9());
		res.addSegmentValidations(ER2003PosRbDplkk0400.genValidationBerdasarkanNilaiWajar());
		res.addSegmentValidations(ER2003PosRbDplkk0400.genValidationRatioBerdasarkanNilaiWajar());
		res.addSegmentValidations(ER2003PosRbDplkk0400.genValidationRatioNilaiWajar3());
		res.addSegmentValidations(ER2003PosRbDplkk0400.genValidationRatioNilaiWajar5());
		res.addSegmentValidations(ER2003PosRbDplkk0400.genValidationRatioNilaiWajar7());
		res.addSegmentValidations(ER2003PosRbDplkk0400.genValidationRatioNilaiWajar9());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2003_RB0400.getObject())).confUnique(U));
		fs.add(sf(2, null, "Nominal", sv(M, 0, 20, numericNegatif)));
		fs.add(sf(3, null, "Persentase", sv(M, 0, 10, numericDotNegatif)));
		fs.add(sf(4, null, "Nominal", sv(M, 0, 20, numericNegatif)));
		fs.add(sf(5, null, "Persentase", sv(M, 0, 10, numericDotNegatif)));
		fs.add(sf(6, null, "Nominal", sv(M, 0, 20, numericNegatif)));
		fs.add(sf(7, null, "Persentase", sv(M, 0, 10, numericDotNegatif)));
		fs.add(sf(8, null, "Nominal", sv(M, 0, 20, numericNegatif)));
		fs.add(sf(9, null, "Persentase", sv(M, 0, 10, numericDotNegatif)));
		return res;
	}
}
