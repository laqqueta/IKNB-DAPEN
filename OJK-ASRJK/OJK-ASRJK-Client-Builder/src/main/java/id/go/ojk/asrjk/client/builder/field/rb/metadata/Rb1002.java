package id.go.ojk.asrjk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrjk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjk.client.builder.field.rb.reference.ER2009PosRbAsrjk1002;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb1002 extends BaseMetadata {

	public Rb1002(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1002;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER2009PosRbAsrjk1002.genFieldSave(), null,
				ER2009PosRbAsrjk1002.getRequiredPos());
		res.addSegmentValidations(ER2009PosRbAsrjk1002.genValidationRencanaSDM());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2009_RB1002.getObject())));
		fs.add(sf(2, null, "Level Jabatan",
				sv(C, 0, 1000, all).confConditionalRequired(ER2009PosRbAsrjk1002.genConditionalMustEmpty())));
		fs.add(sf(3, null, "Jumlah SDM per 30 Sept 20XX-1",
				sv(C, 0, 16, numeric).confConditionalRequired(ER2009PosRbAsrjk1002.genConditionalField())));
		fs.add(sf(4, null, "Desember 20xx - 1 (+)",
				sv(C, 0, 16, numeric).confConditionalRequired(ER2009PosRbAsrjk1002.genConditionalField())));
		fs.add(sf(5, null, "Desember 20xx - 1 (-)",
				sv(C, 0, 16, numeric).confConditionalRequired(ER2009PosRbAsrjk1002.genConditionalField())));
		fs.add(sf(6, null, "Juni 20xx (+)",
				sv(C, 0, 16, numeric).confConditionalRequired(ER2009PosRbAsrjk1002.genConditionalField())));
		fs.add(sf(7, null, "Juni 20xx (-)",
				sv(C, 0, 16, numeric).confConditionalRequired(ER2009PosRbAsrjk1002.genConditionalField())));
		fs.add(sf(8, null, "Desember 20xx (+)",
				sv(C, 0, 16, numeric).confConditionalRequired(ER2009PosRbAsrjk1002.genConditionalField())));
		fs.add(sf(9, null, "Desember20xx (-)",
				sv(C, 0, 16, numeric).confConditionalRequired(ER2009PosRbAsrjk1002.genConditionalField())));
		return res;
	}
}
