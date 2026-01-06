package id.go.ojk.dppks.client.builder.field.rb.metadata;

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
import id.go.ojk.dppks.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dppks.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppks.client.builder.field.rb.reference.ER2009PosRbDppks0801;

public class Rb0801 extends BaseMetadata {

	public Rb0801(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0801;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 7, 7, null, null, ER2009PosRbDppks0801.getRequiredPos());
//		res.addSegmentValidations(ER2009PosRbDppks0801.genValidationNumeric()); --//dicomment karena harusnya bisa negatif 
		res.addSegmentValidations(ER2009PosRbDppks0801.genValidationNumericNegative());
		res.addSegmentValidations(ER2009PosRbDppks0801.genValidationDecimal());
		res.addSegmentValidations(ER2009PosRbDppks0801.genValidationMaxLengthKualitasPendanaan());
		res.addSegmentValidations(ER2009PosRbDppks0801.genValidationKualitasPendanaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2009_RB0801.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept XX-1", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Proyeksi per 31 Desember XX-1", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Proyeksi per 30 Juni XX", sv(M, 1, 16, all)));
		fs.add(sf(5, null, "Proyeksi per 31 Desember XX", sv(M, 1, 16, all)));
		return res;
	}
}
