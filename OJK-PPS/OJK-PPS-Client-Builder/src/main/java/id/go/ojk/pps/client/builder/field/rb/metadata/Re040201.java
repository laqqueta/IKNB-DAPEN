package id.go.ojk.pps.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pps.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pps.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pps.client.builder.field.rb.reference.ER2252PosRePps040201;

public class Re040201 extends BaseMetadata {

	public Re040201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_040201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER2252PosRePps040201.genFieldSave(), null, ER2252PosRePps040201.getRequiredPos());
		res.addSegmentValidations(ER2252PosRePps040201.genValidationTotalPenyaluranPembiayaanKepadaDebiturInti());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2252_RE040201.getObject())));
		fs.add(sf(2, null, "Nama Debitur",
				sv(C, 0, 1000, all).confConditionalRequired(ER2252PosRePps040201.genConditionalMustEmpty())));
		fs.add(sf(3, null, "Proyeksi",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2252PosRePps040201.genConditionalField())));
		fs.add(sf(4, null, "Realisasi",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2252PosRePps040201.genConditionalField())));
		fs.add(sf(5, null, "Deviasi",
				sv(C, 0, 16, numericNegatif).confConditionalRequired(ER2252PosRePps040201.genConditionalField()))
				.addFieldValidations(ER2252PosRePps040201.genValidationSum()));
		return res;
	}
}
