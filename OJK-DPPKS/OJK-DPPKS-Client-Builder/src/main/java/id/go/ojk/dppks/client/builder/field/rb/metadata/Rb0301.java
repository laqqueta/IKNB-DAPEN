package id.go.ojk.dppks.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppks.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dppks.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppks.client.builder.field.rb.reference.ER2003PosRbDppks0301;

public class Rb0301 extends BaseMetadata {

	public Rb0301(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0301;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 17, 17, null, null, ER2003PosRbDppks0301.getRequiredPos());
		res.addSegmentValidations(ER2003PosRbDppks0301.genValidationNumericNegatif());
		res.addSegmentValidations(ER2003PosRbDppks0301.genValidationNumericDotNegatif());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2003_RB0301.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi - Rencana Bisnis", sv(M, 0, 16, all)));
		fs.add(sf(3, null, "Proyeksi - Realisasi", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "%", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2003PosRbDppks0301.genValidationRatio()));
		return res;
	}
}
