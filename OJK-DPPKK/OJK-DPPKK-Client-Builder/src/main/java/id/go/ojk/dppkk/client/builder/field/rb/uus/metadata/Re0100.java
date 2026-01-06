package id.go.ojk.dppkk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.reference.ER2119PosReDppu0100;

public class Re0100 extends BaseMetadata {

	public Re0100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_0100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 8, null, null, null, ER2119PosReDppu0100.getUniquePos());
		res.setRequiredPos(ER2119PosReDppu0100.getRequiredPos());
		res.addSegmentValidations(ER2119PosReDppu0100.genValidationProgramA());
		res.addSegmentValidations(ER2119PosReDppu0100.genValidationProgramB());
		res.addSegmentValidations(ER2119PosReDppu0100.genValidationTahunRencanaBisnisA());
		res.addSegmentValidations(ER2119PosReDppu0100.genValidationTahunRencanaBisnisB());
		res.addSegmentValidations(ER2119PosReDppu0100.genValidationMaxLength4());
		res.addSegmentValidations(ER2119PosReDppu0100.genValidationMaxLength80());
		res.addSegmentValidations(ER2119PosReDppu0100.genValidationMaxLength100());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRbUus.R2119_RE0100.getObject())));
		fs.add(sf(2, null, "Uraian", sv(M, 1, 500, all)));
		return res;
	}
}
