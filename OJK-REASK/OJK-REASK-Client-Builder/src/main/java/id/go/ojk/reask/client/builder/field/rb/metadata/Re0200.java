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
import id.go.ojk.reask.client.builder.field.rb.reference.ER2251PosReReask0200;

public class Re0200 extends BaseMetadata {

	public Re0200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 38, 38, ER2251PosReReask0200.genFieldSave(), null, ER2251PosReReask0200.getRequiredPos());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationPendapatanPremi());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationPremiBruto());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationPremiReasuransi());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationPremiNeto());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationPenurunanCadanganPremiCapybmp());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationPendapatanPremiNeto());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationPendapatanUnderWriting());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationBebanKlaimNetto());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationBebanUnderWriting());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationHasilUnderWriting());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationBebanUsaha());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationLabaUsahaAsuransi());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationLabaSebelumPajak());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER2251PosReReask0200.genValidationLabaKomprehensif());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2251_RE0200.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Rupiah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2251PosReReask0200.genValidationField4()));
		fs.add(sf(5, null, "%", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2251PosReReask0200.genValidationField5()));
		return res;
	}
}
