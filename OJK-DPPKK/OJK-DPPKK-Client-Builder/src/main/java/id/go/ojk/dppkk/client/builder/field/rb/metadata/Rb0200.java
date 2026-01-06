package id.go.ojk.dppkk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dppkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppkk.client.builder.field.rb.reference.ER2001PosRbDppkk0200;

public class Rb0200 extends BaseMetadata {

	public Rb0200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 11, 11, null, null, ER2001PosRbDppkk0200.getRequiredPos());
		res.addSegmentValidations(ER2001PosRbDppkk0200.genValidationNumericNegatif());
		res.addSegmentValidations(ER2001PosRbDppkk0200.genValidationNumericDotNegatif());
		res.addSegmentValidations(ER2001PosRbDppkk0200.genValidationMaxLengthDecimal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2001_RB0200.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 20, all)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 20, all)));
		fs.add(sf(4, null, "Proyeksi Juni XX", sv(M, 1, 20, all)));
		fs.add(sf(5, null, "Proyeksi Desember XX", sv(M, 1, 20, all)));
		return res;
	}
}
