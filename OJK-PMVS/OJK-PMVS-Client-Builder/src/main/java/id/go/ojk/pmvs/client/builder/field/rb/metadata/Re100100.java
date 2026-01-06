package id.go.ojk.pmvs.client.builder.field.rb.metadata;

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
import id.go.ojk.pmvs.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pmvs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvs.client.builder.field.rb.reference.ER2263PosRePmvs100100;

public class Re100100 extends BaseMetadata {

	public Re100100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_100100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 10, null, null, null, ER2263PosRePmvs100100.getRequiredPos());
		res.addSegmentValidations(ER2263PosRePmvs100100.genValidationNumeric());
		res.addSegmentValidations(ER2263PosRePmvs100100.genValidationNumericDot());
		res.addSegmentValidations(ER2263PosRePmvs100100.genValidationMaxLengthNumeric());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2263_RE100100.getObject())));
		fs.add(sf(2, null, "Asumsi Lainnya",
				sv(C, 0, 200, all).confConditionalRequired(ER2263PosRePmvs100100.genConditionalMustEmpty())));
		fs.add(sf(3, null, "Proyeksi - Juni xx", sv(M, 1, 200, all)));
		fs.add(sf(4, null, "Realisasi - Juni xx", sv(M, 1, 200, all)));
		fs.add(sf(5, null, "Deviasi", sv(M, 1, 200, all))
				.addFieldValidations(ER2263PosRePmvs100100.genValidationSum()));
		return res;
	}
}
