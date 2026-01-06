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
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.ER2501PosRbPpu040102;

public class Rb040102 extends BaseMetadata {

	public Rb040102(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_040102;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 42, 42, ER2501PosRbPpu040102.genFieldSave(), ER2501PosRbPpu040102.genFieldSave(),
				ER2501PosRbPpu040102.getRequiredPos());
		res.addSegmentValidations(ER2501PosRbPpu040102.genValidationPembiayaanJualBeliA());
		res.addSegmentValidations(ER2501PosRbPpu040102.genValidationPembiayaanInvestasiA());
		res.addSegmentValidations(ER2501PosRbPpu040102.genValidationPembiayaanJasaA());
		res.addSegmentValidations(ER2501PosRbPpu040102.genValidationTotalRencanaPenyaluranPembiayaanBaru());
		res.addSegmentValidations(ER2501PosRbPpu040102.genValidationPembiayaanJualBeliB());
		res.addSegmentValidations(ER2501PosRbPpu040102.genValidationPembiayaanInvestasiB());
		res.addSegmentValidations(ER2501PosRbPpu040102.genValidationPembiayaanJasaB());
		res.addSegmentValidations(ER2501PosRbPpu040102.genValidationTotalSaldoPiutangPembiayaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2501_RB040102.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi Juni XX", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi Desember XX", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
