package id.go.ojk.asrjk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.asrjk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.asrjk.client.builder.field.rb.uus.reference.ER2139PosReAsrju0103;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Re0103 extends BaseMetadata {

	public Re0103(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_0103;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 34, 34, ER2139PosReAsrju0103.genFieldSave(), null,
				ER2139PosReAsrju0103.getRequiredPos());
		res.addSegmentValidations(ER2139PosReAsrju0103.genValidationAset());
		res.addSegmentValidations(ER2139PosReAsrju0103.genValidationInvestasi());
		res.addSegmentValidations(ER2139PosReAsrju0103.genValidationBukanInvestasi());
		res.addSegmentValidations(ER2139PosReAsrju0103.genValidationLiabilitasDanEkuitas());
		res.addSegmentValidations(ER2139PosReAsrju0103.genValidationLiabilitas());
		res.addSegmentValidations(ER2139PosReAsrju0103.genValidationEkuitasDana());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2139_RE0103.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi-Rupiah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2139PosReAsrju0103.genValidationField4()));
		fs.add(sf(5, null, "Deviasi-%", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2139PosReAsrju0103.genValidationField5()));
		return res;
	}
}
