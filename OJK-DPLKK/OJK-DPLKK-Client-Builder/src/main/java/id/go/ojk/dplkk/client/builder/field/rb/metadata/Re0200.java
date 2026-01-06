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
import id.go.ojk.dplkk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.dplkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dplkk.client.builder.field.rb.reference.ER2018PosReDplkk0200;

public class Re0200 extends BaseMetadata {

	public Re0200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 38, 38, ER2018PosReDplkk0200.genFieldSave(), null,
				ER2018PosReDplkk0200.getRequiredPos());
		res.addSegmentValidations(ER2018PosReDplkk0200.genValidationInvestasi());
		res.addSegmentValidations(ER2018PosReDplkk0200.genValidationAsetLancarDiluarInvestasi());
		res.addSegmentValidations(ER2018PosReDplkk0200.genValidationAsetTersedia());
		res.addSegmentValidations(ER2018PosReDplkk0200.genValidationLiabilitasDiluarLiabilitasManfaatPensiun());
		res.addSegmentValidations(ER2018PosReDplkk0200.genValidationLiabilitas());
		res.addSegmentValidations(ER2018PosReDplkk0200.genValidationAsetNeto());
		res.addSegmentValidations(ER2018PosReDplkk0200.genValidationFormAsetNeto());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2018_RE0200.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "Pencapaian", sv(M, 1, 10, numericDotNegatif))
				.addFieldValidations(ER2018PosReDplkk0200.genValidation4()));
		fs.add(sf(5, null, "Deviasi (nominal)", sv(M, 1, 20, numericNegatif))
				.addFieldValidations(ER2018PosReDplkk0200.genValidation5()));
		return res;
	}
}
