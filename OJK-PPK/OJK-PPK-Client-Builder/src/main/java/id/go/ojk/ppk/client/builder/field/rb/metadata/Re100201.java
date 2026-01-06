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
import id.go.ojk.ppk.client.builder.field.rb.reference.ER2267PosRePpk100201;

public class Re100201 extends BaseMetadata {

	public Re100201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_100201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 40, 40, ER2267PosRePpk100201.genFieldSave(), ER2267PosRePpk100201.genFieldSave(),
				ER2267PosRePpk100201.getRequiredPos());
		res.addSegmentValidations(ER2267PosRePpk100201.genValidationJumlahAset());
		res.addSegmentValidations(ER2267PosRePpk100201.genValidationJumlahLiabilitas());
		res.addSegmentValidations(ER2267PosRePpk100201.genValidationModal());
		res.addSegmentValidations(ER2267PosRePpk100201.genValidationTambahanModalDisetor());
		res.addSegmentValidations(ER2267PosRePpk100201.genValidationCadangan());
		res.addSegmentValidations(ER2267PosRePpk100201.genValidationKomponenEkuitasLainnya());
		res.addSegmentValidations(ER2267PosRePpk100201.genValidationJumlahEkuitas());
		res.addSegmentValidations(ER2267PosRePpk100201.genValidationJumlahLiabilitasDanEkuitas());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2267_RE100201.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2267PosRePpk100201.genValidationSum()));
		return res;
	}
}
