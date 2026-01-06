package id.go.ojk.dplks.client.builder.field.rb.metadata;

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
import id.go.ojk.dplks.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.dplks.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dplks.client.builder.field.rb.reference.ER2023PosReDplks0400;

public class Re0400 extends BaseMetadata {

	public Re0400(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0400;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 3, null, null, null, ER2023PosReDplks0400.getRequiredPos());
		res.addSegmentValidations(ER2023PosReDplks0400.genValidationDecimalNegatif());
		res.addSegmentValidations(ER2023PosReDplks0400.genValidationDecimalDotNegatifA());
		res.addSegmentValidations(ER2023PosReDplks0400.genValidationDecimalDotNegatifB());
		res.addSegmentValidations(ER2023PosReDplks0400.genValidationMaxLenght10A());
		res.addSegmentValidations(ER2023PosReDplks0400.genValidationMaxLenght10B());
		res.addSegmentValidations(ER2023PosReDplks0400.genValidationMaxLenght16());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2023_RE0400.getObject())));
		fs.add(sf(2, null, "Asumsi Lain yang Relevan",
				sv(C, 0, 200, all).confConditionalRequired(ER2023PosReDplks0400.genConditionMustNotEmpty())));
		fs.add(sf(3, null, "Rencana Bisnis", sv(M, 1, 200, all)));
		fs.add(sf(4, null, "Realisasi", sv(M, 1, 200, all)));
		fs.add(sf(5, null, "Deviasi Rupiah", sv(M, 1, 200, all))
				.addFieldValidations(ER2023PosReDplks0400.genValidationField5()));
		fs.add(sf(6, null, "Deviasi Persentase (%)", sv(M, 1, 200, all))
				.addFieldValidations(ER2023PosReDplks0400.genValidationField6()));
		return res;
	}
}
