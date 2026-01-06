package id.go.ojk.reass.client.builder.field.rb.metadata;

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
import id.go.ojk.reass.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.reass.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.reass.client.builder.field.rb.reference.ER2029PosReReass0102;

public class Re0102 extends BaseMetadata {

	public Re0102(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0102;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 45, 45, ER2029PosReReass0102.genFieldSave(), null, ER2029PosReReass0102.getRequiredPos());
		res.addSegmentValidations(ER2029PosReReass0102.genValidationAsetA());
		res.addSegmentValidations(ER2029PosReReass0102.genValidationInvestasi());
		res.addSegmentValidations(ER2029PosReReass0102.genValidationBukanInvestasi());
		res.addSegmentValidations(ER2029PosReReass0102.genValidationLiabilitasDanEkuitas());
		res.addSegmentValidations(ER2029PosReReass0102.genValidationLiabilitas());
		res.addSegmentValidations(ER2029PosReReass0102.genValidationPenyisihanTeknis());
		res.addSegmentValidations(ER2029PosReReass0102.genValidationEkuitasDana());
		res.addSegmentValidations(ER2029PosReReass0102.genValidationAsetB());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2029_RE0102.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi-Rupiah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2029PosReReass0102.genValidationField4()));
		fs.add(sf(5, null, "Deviasi-%", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2029PosReReass0102.genValidationField5()));
		return res;
	}
}
