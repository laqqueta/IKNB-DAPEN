package id.go.ojk.dplkk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dplkk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.dplkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dplkk.client.builder.field.rb.reference.ER1020PosReDplkk0400;

public class Re0400 extends BaseMetadata {

	public Re0400(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0400;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 3, null, null, null,
				ER1020PosReDplkk0400.getRequiredPos());
		res.addSegmentValidations(ER1020PosReDplkk0400.genValidationDecimal1());
		res.addSegmentValidations(ER1020PosReDplkk0400.genValidationDecimal2());
		res.addSegmentValidations(ER1020PosReDplkk0400.genValidationDecimalLength());
		res.addSegmentValidations(ER1020PosReDplkk0400.genValidationNumeric());
		res.addSegmentValidations(ER1020PosReDplkk0400.genValidationNumericLength());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2020_RE0400.getObject())));
		fs.add(sf(2, null, "Asumsi Lain yang Relevan",
				sv(C, 0, 200, all).confConditionalRequired(ER1020PosReDplkk0400.genConditionMustNotEmpty())));
		fs.add(sf(3, null, "Rencana Bisnis", sv(M, 1, 200, all)));
		fs.add(sf(4, null, "Realisasi", sv(M, 1, 200, all)));
		fs.add(sf(5, null, "Deviasi", sv(M, 1, 200, all))
				.addFieldValidations(ER1020PosReDplkk0400.genValidation5()));
		fs.add(sf(6, null, "Deviasi (2)/(1)", sv(M, 1, 200, all))
				.addFieldValidations(ER1020PosReDplkk0400.genValidation6()));
		return res;
	}
}
