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
import id.go.ojk.reask.client.builder.field.rb.uus.reference.ER2122PosRbReasu1204;

public class Rb1204 extends BaseMetadata {

	public Rb1204(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_1204;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 28, 28, ER2122PosRbReasu1204.genFieldSave(), null, ER2122PosRbReasu1204.getRequiredPos());
		res.addSegmentValidations(ER2122PosRbReasu1204.genValidationHasilInvestasi());
		res.addSegmentValidations(ER2122PosRbReasu1204.genValidationKontribusiNeto());
		res.addSegmentValidations(ER2122PosRbReasu1204.genValidationPendapatanKontribusiNeto());
		res.addSegmentValidations(ER2122PosRbReasu1204.genValidationPendapatanUnderwriting());
		res.addSegmentValidations(ER2122PosRbReasu1204.genValidationBebanKlaimNetto());
		res.addSegmentValidations(ER2122PosRbReasu1204.genValidationBebanUnderwriting());
		res.addSegmentValidations(ER2122PosRbReasu1204.genValidationSurplusUnderwriting());
		res.addSegmentValidations(ER2122PosRbReasu1204.genValidationLabaUsahaAsuransi());
		res.addSegmentValidations(ER2122PosRbReasu1204.genValidationLabaSebelumPajak());
		res.addSegmentValidations(ER2122PosRbReasu1204.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER2122PosRbReasu1204.genValidationKinerjaSeluruhDana());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2122_RB1204.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept 20XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
