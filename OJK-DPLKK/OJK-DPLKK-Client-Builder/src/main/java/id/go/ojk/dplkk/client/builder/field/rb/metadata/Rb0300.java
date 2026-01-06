package id.go.ojk.dplkk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
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
import id.go.ojk.dplkk.client.builder.field.rb.reference.ER2002PosRbDplkk0300;

public class Rb0300 extends BaseMetadata {

	public Rb0300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 8, 8, null, null, ER2002PosRbDplkk0300.getRequiredPos());
		res.addSegmentValidations(ER2002PosRbDplkk0300.genValidationNumericNegatif());
		res.addSegmentValidations(ER2002PosRbDplkk0300.genValidationNumericDotNegatif());
		res.addSegmentValidations(ER2002PosRbDplkk0300.genValidationMaxLengthNumeric());
		res.addSegmentValidations(ER2002PosRbDplkk0300.genValidationMaxLengthDecimal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2002_RB0300.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 0, 20, all)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 20, all)));
		fs.add(sf(4, null, "Pencapaian (%)", sv(M, 1, 10, numericDotNegatif))
				.addFieldValidations(ER2002PosRbDplkk0300.genValidationRatio()));
		return res;
	}
}
