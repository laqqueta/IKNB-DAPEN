package id.go.ojk.asrjk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrjk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjk.client.builder.field.rb.reference.ER2007PosRbAsrjk0702;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb0702 extends BaseMetadata {

	public Rb0702(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0702;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 5, null, ER2007PosRbAsrjk0702.genFieldSave(), null,
				ER2007PosRbAsrjk0702.getRequiredPos());
		res.addSegmentValidations(ER2007PosRbAsrjk0702.genValidationModalDisetor());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2007_RB0702.getObject())));
		fs.add(sf(2, null, "Nama Pemegang Saham",
				sv(C, 0, 1000, all).confConditionalRequired(ER2007PosRbAsrjk0702.genConditionalFieldMustEmpty())));
		fs.add(sf(3, null, "Kinerja per 30 Sept 20XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Per 31 Des", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Per 30 Jun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Per 31 Des", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
