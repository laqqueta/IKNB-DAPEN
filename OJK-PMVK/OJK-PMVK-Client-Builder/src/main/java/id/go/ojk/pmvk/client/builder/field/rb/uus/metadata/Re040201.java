package id.go.ojk.pmvk.client.builder.field.rb.uus.metadata;

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
import id.go.ojk.pmvk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.ER2752PosRePmvu040201;

public class Re040201 extends BaseMetadata {

	public Re040201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_040201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 52, 52, ER2752PosRePmvu040201.genFieldSave(), null, ER2752PosRePmvu040201.getRequiredPos());
		res.addSegmentValidations(ER2752PosRePmvu040201.genValidationSektorEkonomiLapanganUsahaA());
		res.addSegmentValidations(ER2752PosRePmvu040201.genValidationSektorEkonomiBukanLapanganUsahaA());
		res.addSegmentValidations(ER2752PosRePmvu040201.genValidationTotalRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2752PosRePmvu040201.genValidationSektorEkonomiLapanganUsahaB());
		res.addSegmentValidations(ER2752PosRePmvu040201.genValidationSektorEkonomiBukanLapanganUsahaB());
		res.addSegmentValidations(ER2752PosRePmvu040201.genValidationTotalSaldoPosisi());
		res.addSegmentValidations(ER2752PosRePmvu040201.genValidationFormTotalRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2752PosRePmvu040201.genValidationFormTotalSaldoPosisi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2752_RE040201.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi - Juni xx", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi - Juni xx", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 0, 16, numericNegatif))
				.addFieldValidations(ER2752PosRePmvu040201.genValidationSum()));
		return res;
	}
}
