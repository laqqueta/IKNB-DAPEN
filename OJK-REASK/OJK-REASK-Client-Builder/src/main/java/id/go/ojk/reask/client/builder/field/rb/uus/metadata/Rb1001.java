package id.go.ojk.reask.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.ER2114PosRbReasu1001;

public class Rb1001 extends BaseMetadata {

	public Rb1001(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_1001;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER2114PosRbReasu1001.genFieldSave(), null, ER2114PosRbReasu1001.getRequiredPos());
		res.addSegmentValidations(ER2114PosRbReasu1001.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRbUus.R2114_RB1001.getObject())));
		fs.add(sf(2, null, "Level Jabatan",
				sv(C, 1, 1000, all).confConditionalRequired(ER2114PosRbReasu1001.genConditionalMustEmpty())));
		fs.add(sf(3, null, "Jumlah SDM per 30 Sept 20XX-1",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2114PosRbReasu1001.genConditionalField())));
		fs.add(sf(4, null, "Desember 20xx - 1 (+)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2114PosRbReasu1001.genConditionalField())));
		fs.add(sf(5, null, "Desember 20xx - 1 (-)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2114PosRbReasu1001.genConditionalField())));
		fs.add(sf(6, null, "Juni 20xx (+)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2114PosRbReasu1001.genConditionalField())));
		fs.add(sf(7, null, "Juni 20xx (-)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2114PosRbReasu1001.genConditionalField())));
		fs.add(sf(8, null, "Desember 20xx (+)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2114PosRbReasu1001.genConditionalField())));
		fs.add(sf(9, null, "Desember 20xx (-)",
				sv(C, 1, 16, numeric).confConditionalRequired(ER2114PosRbReasu1001.genConditionalField())));
		return res;
	}
}
