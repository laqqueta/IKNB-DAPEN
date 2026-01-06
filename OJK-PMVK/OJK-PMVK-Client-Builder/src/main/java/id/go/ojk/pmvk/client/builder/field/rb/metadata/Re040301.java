package id.go.ojk.pmvk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pmvk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pmvk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvk.client.builder.field.rb.reference.ER2253PosRePmvk040301;

public class Re040301 extends BaseMetadata {

	public Re040301(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_040301;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 72, 72, ER2253PosRePmvk040301.genFieldSave(), null, ER2253PosRePmvk040301.getRequiredPos());
		res.addSegmentValidations(ER2253PosRePmvk040301.genValidationTotalRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2253PosRePmvk040301.genValidationTotalSaldoPosisi());
		res.addSegmentValidations(ER2253PosRePmvk040301.genValidationFormTotalRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2253PosRePmvk040301.genValidationFormTotalSaldoPosisi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2253_RE040301.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi - Juni xx", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi - Juni xx", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 0, 16, numericNegatif))
				.addFieldValidations(ER2253PosRePmvk040301.genValidationSum()));
		return res;
	}
}
