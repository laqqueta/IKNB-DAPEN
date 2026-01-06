package id.go.ojk.reask.client.builder.field.rb.uus.metadata;

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
import id.go.ojk.reask.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.ER2121PosRbReasu1203;

public class Rb1203 extends BaseMetadata {

	public Rb1203(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_1203;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 25, 25, ER2121PosRbReasu1203.genFieldSave(), null, ER2121PosRbReasu1203.getRequiredPos());
		res.addSegmentValidations(ER2121PosRbReasu1203.genValidationHasilInvestasi());
		res.addSegmentValidations(
				ER2121PosRbReasu1203.genValidationPendapatanHasilInvestasiDanUjrohPengelolaanInvestasi());
		res.addSegmentValidations(ER2121PosRbReasu1203.genValidationKontribusiNeto());
		res.addSegmentValidations(ER2121PosRbReasu1203.genValidationBebanUmumDanAdministrasi());
		res.addSegmentValidations(ER2121PosRbReasu1203.genValidationBebanUsaha());
		res.addSegmentValidations(ER2121PosRbReasu1203.genValidationLabaUsahaAsuransi());
		res.addSegmentValidations(ER2121PosRbReasu1203.genValidationLabaSebelumPajak());
		res.addSegmentValidations(ER2121PosRbReasu1203.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER2121PosRbReasu1203.genValidationKinerjaSeluruhDana());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2121_RB1203.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept 20XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
