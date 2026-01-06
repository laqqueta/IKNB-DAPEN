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
import id.go.ojk.pmvk.client.builder.field.rb.reference.ER2252PosRePmvk040201;

public class Re040201 extends BaseMetadata {

	public Re040201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_040201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 52, 52, ER2252PosRePmvk040201.genFieldSave(), null, ER2252PosRePmvk040201.getRequiredPos());
		res.addSegmentValidations(ER2252PosRePmvk040201.genValidationSektorEkonomiLapanganUsahaA());
		res.addSegmentValidations(ER2252PosRePmvk040201.genValidationSektorEkonomiBukanLapanganUsahaA());
		res.addSegmentValidations(ER2252PosRePmvk040201.genValidationTotalRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2252PosRePmvk040201.genValidationSektorEkonomiLapanganUsahaB());
		res.addSegmentValidations(ER2252PosRePmvk040201.genValidationSektorEkonomiBukanLapanganUsahaB());
		res.addSegmentValidations(ER2252PosRePmvk040201.genValidationTotalSaldoPosisi());
		res.addSegmentValidations(ER2252PosRePmvk040201.genValidationFormTotalRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2252PosRePmvk040201.genValidationFormTotalSaldoPosisi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2252_RE040201.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi - Juni xx", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi - Juni xx", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 0, 16, numericNegatif))
				.addFieldValidations(ER2252PosRePmvk040201.genValidationSum()));
		return res;
	}
}
