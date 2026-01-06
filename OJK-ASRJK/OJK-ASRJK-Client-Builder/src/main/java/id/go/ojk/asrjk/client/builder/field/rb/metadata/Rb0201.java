package id.go.ojk.asrjk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrjk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjk.client.builder.field.rb.reference.ER2002PosRbAsrjk0201;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb0201 extends BaseMetadata {

	public Rb0201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 9, null, null, null,
				ER2002PosRbAsrjk0201.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2002_RB0201.getObject())));
		fs.add(sf(2, null, "Nama Indikator Lain",
				sv(C, 0, 200, all).confConditionalRequired(ER2002PosRbAsrjk0201.genConditionalField())));
		fs.add(sf(3, null, "Proyeksi - Rencana Bisnis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "%", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2002PosRbAsrjk0201.genFieldValidationRatio()));
		return res;
	}
}
