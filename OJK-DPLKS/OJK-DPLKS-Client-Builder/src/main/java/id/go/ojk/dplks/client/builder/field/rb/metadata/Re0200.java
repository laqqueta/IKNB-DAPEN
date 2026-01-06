package id.go.ojk.dplks.client.builder.field.rb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumericDotNegatif;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.decimal;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dplks.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.dplks.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dplks.client.builder.field.rb.reference.ER2021PosReDplks0200;

public class Re0200 extends BaseMetadata {

	public Re0200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 37, 37, ER2021PosReDplks0200.genFieldSave(), null, ER2021PosReDplks0200.getRequiredPos());
		res.addSegmentValidations(ER2021PosReDplks0200.genValidationInvestasi());
		res.addSegmentValidations(ER2021PosReDplks0200.genValidationAsetLancarDiluarInvestasi());
		res.addSegmentValidations(ER2021PosReDplks0200.genValidationAsetTersedia());
		res.addSegmentValidations(ER2021PosReDplks0200.genValidationLiabilitasDiLuarLiabilitasManfaatPensiun());
		res.addSegmentValidations(ER2021PosReDplks0200.genValidationLiabilitas());
		res.addSegmentValidations(ER2021PosReDplks0200.genValidationAsetNeto());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2021_RE0200.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, numeric).confRegex(patternNumericNegatif.c())));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numeric).confRegex(patternNumericNegatif.c())));
		fs.add(sf(4, null, "Deviasi Rupiah", sv(M, 1, 16, numeric).confRegex(patternNumericNegatif.c()))
				.addFieldValidations(ER2021PosReDplks0200.genValidation4()));
		fs.add(sf(5, null, "Deviasi Persentase (%)", sv(M, 1, 16, decimal).confRegex(patternNumericDotNegatif.c()))
				.addFieldValidations(ER2021PosReDplks0200.genValidation5()));
		return res;
	}
}
