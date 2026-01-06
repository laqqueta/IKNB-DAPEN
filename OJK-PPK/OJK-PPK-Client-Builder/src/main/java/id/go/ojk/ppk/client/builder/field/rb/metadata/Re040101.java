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
import id.go.ojk.ppk.client.builder.field.rb.reference.ER2251PosRePpk040101;

public class Re040101 extends BaseMetadata {

	public Re040101(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_040101;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 46, 46, ER2251PosRePpk040101.genFieldSave(), ER2251PosRePpk040101.genFieldSave(),
				ER2251PosRePpk040101.getRequiredPos());
		res.addSegmentValidations(ER2251PosRePpk040101.genValidationPembiayaanInvestasiA());
		res.addSegmentValidations(ER2251PosRePpk040101.genValidationPembiayaanModalKerjaA());
		res.addSegmentValidations(ER2251PosRePpk040101.genValidationPembiayaanMultigunaA());
		res.addSegmentValidations(ER2251PosRePpk040101.genValidationTotalRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2251PosRePpk040101.genValidationPembiayaanInvestasiB());
		res.addSegmentValidations(ER2251PosRePpk040101.genValidationPembiayaanModalKerjaB());
		res.addSegmentValidations(ER2251PosRePpk040101.genValidationPembiayaanMultigunaB());
		res.addSegmentValidations(ER2251PosRePpk040101.genValidationTotalSaldoPiutangPembiayaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2251_RE040101.getObject())).confUnique(U));
		fs.add(sf(2, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2251PosRePpk040101.genValidationSum()));
		return res;
	}
}
