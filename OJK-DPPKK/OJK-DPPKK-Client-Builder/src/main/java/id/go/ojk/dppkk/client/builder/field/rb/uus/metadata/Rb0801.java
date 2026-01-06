package id.go.ojk.dppkk.client.builder.field.rb.uus.metadata;

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
import id.go.ojk.dppkk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.reference.ER2109PosRbDppu0801;

public class Rb0801 extends BaseMetadata {

	public Rb0801(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_0801;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, null, null, null);
		res.setUniquePos(ER2109PosRbDppu0801.getRequiredPos());
		res.addSegmentValidations(ER2109PosRbDppu0801.genValidationNumeric());
		res.addSegmentValidations(ER2109PosRbDppu0801.genValidationDecimal());
		res.addSegmentValidations(ER2109PosRbDppu0801.genValidationMaxLengthKualitasPendanaan());
		res.addSegmentValidations(ER2109PosRbDppu0801.genValidationKualitasPendanaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRbUus.R2109_RB0801.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual Per 30 Sept 20XX-1", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Proyeksi Per 31 Des 20XX-1", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Proyeksi Per 30 Jun 20XX", sv(M, 1, 16, all)));
		fs.add(sf(5, null, "Proyeksi Per 31 Des 20XX", sv(M, 1, 16, all)));
		return res;
	}
}
