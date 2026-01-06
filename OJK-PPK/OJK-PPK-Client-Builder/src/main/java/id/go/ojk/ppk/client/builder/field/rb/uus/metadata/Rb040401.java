package id.go.ojk.ppk.client.builder.field.rb.uus.metadata;

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
import id.go.ojk.ppk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.ER2504PosRbPpu040401;

public class Rb040401 extends BaseMetadata {

	public Rb040401(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_040401;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 52, 52, ER2504PosRbPpu040401.genFieldSave(), null, ER2504PosRbPpu040401.getRequiredPos());
		res.addSegmentValidations(ER2504PosRbPpu040401.genValidationTotalSektorEkonomiBukanLapanganUsahaA());
		res.addSegmentValidations(ER2504PosRbPpu040401.genValidationTotalSektorEkonomiLapanganUsahaA());
		res.addSegmentValidations(ER2504PosRbPpu040401.genValidationTotalRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2504PosRbPpu040401.genValidationTotalSektorEkonomiBukanLapanganUsahaB());
		res.addSegmentValidations(ER2504PosRbPpu040401.genValidationTotalSektorEkonomiLapanganUsahaB());
		res.addSegmentValidations(ER2504PosRbPpu040401.genValidationTotalSaldoPiutangPembiayaan());
		res.addSegmentValidations(ER2504PosRbPpu040401.genValidationFormRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2504PosRbPpu040401.genValidationFormSaldoPiutangPembiayaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2504_RB040401.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 0, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 0, 16, numericNegatif)));
		return res;
	}
}
