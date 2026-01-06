package id.go.ojk.asrus.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrus.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrus.client.builder.field.rb.reference.ER2033PosRbAsrus1210;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb1210 extends BaseMetadata {

	public Rb1210(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1210;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 7, null, null, null,
				ER2033PosRbAsrus1210.getRequiredPos());
		res.addSegmentValidations(ER2033PosRbAsrus1210.genValidationNumericNegative());
		res.addSegmentValidations(ER2033PosRbAsrus1210.genValidationNumeric1());
		res.addSegmentValidations(ER2033PosRbAsrus1210.genValidationNumeric2());
		res.addSegmentValidations(ER2033PosRbAsrus1210.genValidationNumericDot());
		res.addSegmentValidations(ER2033PosRbAsrus1210.genValidationNumericMaxLength());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2033_RB1210.getObject())));
		fs.add(sf(2, null, "Asumsi Lain",
				sv(C, 0, 200, all).confConditionalRequired(ER2033PosRbAsrus1210.genConditionField())));
		fs.add(sf(3, null, "Aktual per 30 Sept 20XX-1", sv(M, 1, 200, all)));
		fs.add(sf(4, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 200, all)));
		fs.add(sf(5, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 200, all)));
		fs.add(sf(6, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 200, all)));
		return res;
	}
}
