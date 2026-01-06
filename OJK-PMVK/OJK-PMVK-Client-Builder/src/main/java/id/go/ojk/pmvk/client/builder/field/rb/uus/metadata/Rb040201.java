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
import id.go.ojk.pmvk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.ER2502PosRbPmvu040201;

public class Rb040201 extends BaseMetadata {

	public Rb040201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_040201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 52, 52, ER2502PosRbPmvu040201.genFieldSave(), null, ER2502PosRbPmvu040201.getRequiredPos());
		res.addSegmentValidations(ER2502PosRbPmvu040201.genValidationSektorEkonomiLapanganUsahaA());
		res.addSegmentValidations(ER2502PosRbPmvu040201.genValidationSektorEkonomiBukanLapanganUsahaA());
		res.addSegmentValidations(ER2502PosRbPmvu040201.genValidationTotalRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2502PosRbPmvu040201.genValidationSektorEkonomiLapanganUsahaB());
		res.addSegmentValidations(ER2502PosRbPmvu040201.genValidationSektorEkonomiBukanLapanganUsahaB());
		res.addSegmentValidations(ER2502PosRbPmvu040201.genValidationTotalSaldoPosisi());
		res.addSegmentValidations(ER2502PosRbPmvu040201.genValidationFormTotalRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2502PosRbPmvu040201.genValidationFormTotalSaldoPosisi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2502_RB040201.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
