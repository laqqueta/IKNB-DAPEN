package id.go.ojk.asrjs.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrjs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjs.client.builder.field.rb.reference.ER2008PosRbAsrjs0203;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb0203 extends BaseMetadata {

	public Rb0203(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0203;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 5, null, null, null,
				ER2008PosRbAsrjs0203.getRequiredPos());
		res.addSegmentValidations(ER2008PosRbAsrjs0203.genValidationNumeric());
		res.addSegmentValidations(ER2008PosRbAsrjs0203.genValidationNumericDot());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2008_RB0203.getObject())));
		fs.add(sf(2, null, "Indikator Lain", sv(C, 0, 200, all)
				.confConditionalRequired(ER2008PosRbAsrjs0203.genConditionalField())));
		fs.add(sf(3, null, "Proyeksi - Rencana Bisnis", sv(M, 0, 16, all)));
		fs.add(sf(4, null, "Proyeksi - Realisasi", sv(M, 0, 16, all)));
		fs.add(sf(5, null, "%", sv(M, 0, 16, numericDotNegatif))
				.addFieldValidations(ER2008PosRbAsrjs0203.genValidationRatioField()));
		return res;
	}
}
