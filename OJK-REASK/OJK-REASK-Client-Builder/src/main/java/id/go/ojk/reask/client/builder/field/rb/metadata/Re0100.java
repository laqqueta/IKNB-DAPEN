package id.go.ojk.reask.client.builder.field.rb.metadata;

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
import id.go.ojk.reask.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.reask.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.reask.client.builder.field.rb.reference.ER2250PosReReask0100;

public class Re0100 extends BaseMetadata {

	public Re0100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 60, 60, ER2250PosReReask0100.genFieldSave(), null, ER2250PosReReask0100.getRequiredPos());
		res.addSegmentValidations(ER2250PosReReask0100.genValidationInvestasi());
		res.addSegmentValidations(ER2250PosReReask0100.genValidationBukanInvestasi());
		res.addSegmentValidations(ER2250PosReReask0100.genValidationAset());
		res.addSegmentValidations(ER2250PosReReask0100.genValidationHutang());
		res.addSegmentValidations(ER2250PosReReask0100.genValidationCadangan());
		res.addSegmentValidations(ER2250PosReReask0100.genValidationLiabilitas());
		res.addSegmentValidations(ER2250PosReReask0100.genValidationEkuitas());
		res.addSegmentValidations(ER2250PosReReask0100.genValidationLiabilitasEkuitas());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2250_RE0100.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Rupiah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2250PosReReask0100.genValidationField4()));
		fs.add(sf(5, null, "%", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2250PosReReask0100.genValidationField5()));
		return res;
	}
}
