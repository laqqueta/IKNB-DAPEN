package id.go.ojk.dplks.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dplks.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.dplks.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dplks.client.builder.field.rb.reference.ER2020PosReDplks0100;

public class Re0100 extends BaseMetadata {

	public Re0100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 5, null, null, null, ER2020PosReDplks0100.getRequiredPos());
		res.addSegmentValidations(ER2020PosReDplks0100.genValidationProgramA());
		res.addSegmentValidations(ER2020PosReDplks0100.genValidationProgramB());
		res.addSegmentValidations(ER2020PosReDplks0100.genValidationTahunRencanaBisnisA());
		res.addSegmentValidations(ER2020PosReDplks0100.genValidationTahunRencanaBisnisB());
		res.addSegmentValidations(ER2020PosReDplks0100.genValidationMaxLength4());
		res.addSegmentValidations(ER2020PosReDplks0100.genValidationMaxLength80());
		res.addSegmentValidations(ER2020PosReDplks0100.genValidationMaxLength100());
		res.addSegmentValidations(ER2020PosReDplks0100.genValidationMaxLength300());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2020_RE0100.getObject())));
		fs.add(sf(2, null, "Uraian", sv(M, 1, 500, all)));
		return res;
	}
}
