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
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.ER2764PosRePmvu100202;

public class Re100202 extends BaseMetadata {

	public Re100202(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_100202;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 41, 41, ER2764PosRePmvu100202.genFieldSave(), ER2764PosRePmvu100202.genFieldSave(),
				ER2764PosRePmvu100202.getRequiredPos());
		res.addSegmentValidations(ER2764PosRePmvu100202.genValidationJumlahAset());
		res.addSegmentValidations(ER2764PosRePmvu100202.genValidationJumlahAsetJumlahLiabilitasDanEkuitas());
		res.addSegmentValidations(ER2764PosRePmvu100202.genValidationJumlahLiabilitas());
		res.addSegmentValidations(ER2764PosRePmvu100202.genValidationModal());
		res.addSegmentValidations(ER2764PosRePmvu100202.genValidationTambahanModalDisetor());
		res.addSegmentValidations(ER2764PosRePmvu100202.genValidationCadangan());
		res.addSegmentValidations(ER2764PosRePmvu100202.genValidationKomponenEkuitasLainnya());
		res.addSegmentValidations(ER2764PosRePmvu100202.genValidationJumlahEkuitas());
		res.addSegmentValidations(ER2764PosRePmvu100202.genValidationJumlahLiabilitasDanEkuitas());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2764_RE100202.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2764PosRePmvu100202.genValidationSum()));
		return res;
	}
}
