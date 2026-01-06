package id.go.ojk.ppk.client.builder.field.rb.uus.metadata;

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
import id.go.ojk.ppk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.ER2767PosRePpu100100;

public class Re100100 extends BaseMetadata {

	public Re100100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_100100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 8, null, null, null, ER2767PosRePpu100100.getRequiredPos());
		res.addSegmentValidations(ER2767PosRePpu100100.genValidationNumeric());
		res.addSegmentValidations(ER2767PosRePpu100100.genValidationNumericDot());
		res.addSegmentValidations(ER2767PosRePpu100100.genValidationMaxLengthNumeric());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2767_RE100100.getObject())));
		fs.add(sf(2, null, "Asumsi Lainnya",
				sv(C, 0, 200, all).confConditionalRequired(ER2767PosRePpu100100.genConditionalMustEmpty())));
		fs.add(sf(3, null, "Proyeksi - Juni XX", sv(M, 1, 200, all)));
		fs.add(sf(4, null, "Realisasi - Juni XX", sv(M, 1, 200, all)));
		fs.add(sf(5, null, "Deviasi", sv(M, 1, 200, all)).addFieldValidations(ER2767PosRePpu100100.genValidationSum()));
		return res;
	}
}
