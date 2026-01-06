package id.go.ojk.asruk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asruk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asruk.client.builder.field.rb.reference.ER2015PosRbAsruk1304;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb1304 extends BaseMetadata {

	public Rb1304(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1304;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 38, 38, ER2015PosRbAsruk1304.genFieldSave(), null,
				ER2015PosRbAsruk1304.getRequiredPos());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationPendapatanPremi());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationPremiBruto());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationPremiReasuransi());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationPremiNeto());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationPenurunanCadanganPremiCapybmp());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationPendapatanPremiNeto());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationPendapatanUnderWriting());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationBebanKlaimNetto());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationBebanUnderWriting());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationHasilUnderWriting());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationBebanUsaha());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationLabaUsahaAsuransi());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationLabaSebelumPajak());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER2015PosRbAsruk1304.genValidationLabaKomprehensif());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2015_RB1304.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept 20XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
