package id.go.ojk.ppk.client.builder.field.rb.metadata;

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
import id.go.ojk.ppk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.ppk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.ppk.client.builder.field.rb.reference.ER2254PosRePpk040401;

public class Re040401 extends BaseMetadata {

	public Re040401(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_040401;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 52, 52, ER2254PosRePpk040401.genFieldSave(), null, ER2254PosRePpk040401.getRequiredPos());
		res.addSegmentValidations(ER2254PosRePpk040401.genValidationTotalSektorEkonomiBukanLapanganUsahaA());
		res.addSegmentValidations(ER2254PosRePpk040401.genValidationTotalSektorEkonomiLapanganUsahaA());
		res.addSegmentValidations(ER2254PosRePpk040401.genValidationTotalRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2254PosRePpk040401.genValidationTotalSektorEkonomiBukanLapanganUsahaB());
		res.addSegmentValidations(ER2254PosRePpk040401.genValidationTotalSektorEkonomiLapanganUsahaB());
		res.addSegmentValidations(ER2254PosRePpk040401.genValidationTotalSaldoPiutangPembiayaan());
		res.addSegmentValidations(ER2254PosRePpk040401.genValidationFormRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2254PosRePpk040401.genValidationFormSaldoPiutangPembiayaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2254_RE040401.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2254PosRePpk040401.genValidationSum()));
		return res;
	}
}
