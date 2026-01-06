package id.go.ojk.dppkk.client.builder.field.rb.uus.metadata;

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
import id.go.ojk.dppkk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.reference.ER2122PosReDppu0400;

public class Re0400 extends BaseMetadata {

	public Re0400(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_0400;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 4, null, null, null, ER2122PosReDppu0400.getRequiredPos());
		res.addSegmentValidations(ER2122PosReDppu0400.genValidationDecimalDotNegatif());
		res.addSegmentValidations(ER2122PosReDppu0400.genValidationMaxLenght10());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRbUus.R2122_RE0400.getObject())));
		fs.add(sf(2, null, "Asumsi Lain yang Relevan",
				sv(C, 0, 200, all).confConditionalRequired(ER2122PosReDppu0400.genConditionMustNotEmpty())));
		fs.add(sf(3, null, "Rencana Bisnis", sv(M, 1, 200, all)));
		fs.add(sf(4, null, "Realisasi", sv(M, 1, 200, all)));
		fs.add(sf(5, null, "Deviasi Rupiah", sv(M, 1, 200, all)));
		fs.add(sf(6, null, "Deviasi Persentase (%)", sv(M, 1, 200, all)));
		return res;
	}
}
