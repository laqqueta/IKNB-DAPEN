package id.go.ojk.asrjs.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.asrjs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjs.client.builder.field.rb.reference.ER2041PosReAsrjs0202;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Re0202 extends BaseMetadata {

	public Re0202(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0202;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 28, 28, ER2041PosReAsrjs0202.genFieldSave(), null,
				ER2041PosReAsrjs0202.getRequiredPos());
		res.addSegmentValidations(ER2041PosReAsrjs0202.genValidationHasilInvestasi());
		res.addSegmentValidations(ER2041PosReAsrjs0202.genValidationKontribusiNeto());
		res.addSegmentValidations(ER2041PosReAsrjs0202.genValidationPendapatanKontribusiNeto());
		res.addSegmentValidations(ER2041PosReAsrjs0202.genValidationPendapatanUnderwriting());
		res.addSegmentValidations(ER2041PosReAsrjs0202.genValidationBebanKlaimNetto());
		res.addSegmentValidations(ER2041PosReAsrjs0202.genValidationBebanUnderwriting());
		res.addSegmentValidations(ER2041PosReAsrjs0202.genValidationSurplusUnderwriting());
		res.addSegmentValidations(ER2041PosReAsrjs0202.genValidationLabaUsahaAsuransi());
		res.addSegmentValidations(ER2041PosReAsrjs0202.genValidationLabaSebelumPajak());
		res.addSegmentValidations(ER2041PosReAsrjs0202.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER2041PosReAsrjs0202.genValidationKinerjaSeluruhDana());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2041_RE0202.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi-Rupiah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2041PosReAsrjs0202.genValidationField4()));
		fs.add(sf(5, null, "Deviasi-%", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2041PosReAsrjs0202.genValidationField5()));
		return res;
	}
}
