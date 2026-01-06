package id.go.ojk.dppkk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dppkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppkk.client.builder.field.rb.reference.ER2009PosRbDppkk1000;

public class Rb1000 extends BaseMetadata {

	public Rb1000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 4, null, null, null, ER2009PosRbDppkk1000.getRequiredPos());
		res.addSegmentValidations(ER2009PosRbDppkk1000.genValidationNumericDotNegatif());
		res.addSegmentValidations(ER2009PosRbDppkk1000.genValidationDecimalMaxLength());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2009_RB1000.getObject())));
		fs.add(sf(2, null, "Asumsi Lain yang Relevan",
				sv(C, 0, 200, all).confConditionalRequired(ER2009PosRbDppkk1000.genConditionalMustNotEmpty())));
		fs.add(sf(3, null, "Aktual 30 Sep YYYY-1",
				sv(C, 1, 200, all).confConditionalRequired(ER2009PosRbDppkk1000.genConditionalOptional())));
		fs.add(sf(4, null, "Proyeksi 31 Des YYYY-1",
				sv(C, 1, 200, all).confConditionalRequired(ER2009PosRbDppkk1000.genConditionalOptional())));
		fs.add(sf(5, null, "Proyeksi 30 Jun YYYY",
				sv(C, 1, 200, all).confConditionalRequired(ER2009PosRbDppkk1000.genConditionalOptional())));
		fs.add(sf(6, null, "Proyeksi 31 Des YYYY",
				sv(C, 1, 200, all).confConditionalRequired(ER2009PosRbDppkk1000.genConditionalOptional())));
		return res;
	}
}
