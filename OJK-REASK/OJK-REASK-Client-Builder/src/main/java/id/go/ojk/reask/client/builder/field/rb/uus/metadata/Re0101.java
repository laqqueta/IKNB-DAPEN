package id.go.ojk.reask.client.builder.field.rb.uus.metadata;

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
import id.go.ojk.reask.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.ER2128PosReReasu0101;

public class Re0101 extends BaseMetadata {

	public Re0101(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_0101;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 46, 46, ER2128PosReReasu0101.genFieldSave(), null, ER2128PosReReasu0101.getRequiredPos());
		res.addSegmentValidations(ER2128PosReReasu0101.genValidationAsetA());
		res.addSegmentValidations(ER2128PosReReasu0101.genValidationInvestasi());
		res.addSegmentValidations(ER2128PosReReasu0101.genValidationBukanInvestasi());
		res.addSegmentValidations(ER2128PosReReasu0101.genValidationLiabilitasDanEkuitas());
		res.addSegmentValidations(ER2128PosReReasu0101.genValidationLiabilitas());
		res.addSegmentValidations(ER2128PosReReasu0101.genValidationPenyisihanTeknis());
		res.addSegmentValidations(ER2128PosReReasu0101.genValidationEkuitasDana());
		res.addSegmentValidations(ER2128PosReReasu0101.genValidationAsetB());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2128_RE0101.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi-Rupiah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2128PosReReasu0101.genValidationField4()));
		fs.add(sf(5, null, "Deviasi-%", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2128PosReReasu0101.genValidationField5()));
		return res;
	}
}
