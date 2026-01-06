package id.go.ojk.asruk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.asruk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.asruk.client.builder.field.rb.uus.reference.ER2106PosRbAsruu0201;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb0201 extends BaseMetadata {

	public Rb0201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_0201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 9, null, null, null,
				ER2106PosRbAsruu0201.getRequiredPos());
		res.addSegmentValidations(ER2106PosRbAsruu0201.genValidationNumeric());
		res.addSegmentValidations(ER2106PosRbAsruu0201.genValidationNumericDot());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRbUus.R2106_RB0201.getObject())));
		fs.add(sf(2, null, "Indikator Lain",
				sv(C, 0, 200, all).confConditionalRequired(ER2106PosRbAsruu0201.genConditionalField2())));
		fs.add(sf(3, null, "Proyeksi - Rencana Bisnis", sv(M, 0, 16, all)));
		fs.add(sf(4, null, "Proyeksi - Realisasi", sv(M, 0, 16, all)));
		fs.add(sf(5, null, "%", sv(M, 0, 16, numericDotNegatif))
				.addFieldValidations(ER2106PosRbAsruu0201.genValidationRatioField()));
		return res;
	}
}
