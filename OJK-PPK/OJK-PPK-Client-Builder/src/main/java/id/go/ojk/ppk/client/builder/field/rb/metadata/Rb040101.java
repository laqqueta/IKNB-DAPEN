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
import id.go.ojk.ppk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.ppk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.ppk.client.builder.field.rb.reference.ER2001PosRbPpk040101;

public class Rb040101 extends BaseMetadata {

	public Rb040101(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_040101;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 46, 46, ER2001PosRbPpk040101.genFieldSave(), ER2001PosRbPpk040101.genFieldSave(),
				ER2001PosRbPpk040101.getRequiredPos());
		res.addSegmentValidations(ER2001PosRbPpk040101.genValidationPembiayaanInvestasiA());
		res.addSegmentValidations(ER2001PosRbPpk040101.genValidationPembiayaanModalKerjaA());
		res.addSegmentValidations(ER2001PosRbPpk040101.genValidationPembiayaanMultigunaA());
		res.addSegmentValidations(ER2001PosRbPpk040101.genValidationTotalRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2001PosRbPpk040101.genValidationPembiayaanInvestasiB());
		res.addSegmentValidations(ER2001PosRbPpk040101.genValidationPembiayaanModalKerjaB());
		res.addSegmentValidations(ER2001PosRbPpk040101.genValidationPembiayaanMultigunaB());
		res.addSegmentValidations(ER2001PosRbPpk040101.genValidationTotalSaldoPiutangPembiayaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2001_RB040101.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi Juni XX", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi Desember XX", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
