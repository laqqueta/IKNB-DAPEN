package id.go.ojk.pps.client.builder.field.rb.metadata;

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
import id.go.ojk.pps.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pps.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pps.client.builder.field.rb.reference.ER2268PosRePps100202;

public class Re100202 extends BaseMetadata {

	public Re100202(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_100202;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 40, 40, ER2268PosRePps100202.genFieldSave(), ER2268PosRePps100202.genFieldSave(),
				ER2268PosRePps100202.getRequiredPos());
		res.addSegmentValidations(ER2268PosRePps100202.genValidationJumlahAset());
		res.addSegmentValidations(ER2268PosRePps100202.genValidationJumlahLiabilitas());
		res.addSegmentValidations(ER2268PosRePps100202.genValidationModal());
		res.addSegmentValidations(ER2268PosRePps100202.genValidationTambahanModalDisetor());
		res.addSegmentValidations(ER2268PosRePps100202.genValidationCadangan());
		res.addSegmentValidations(ER2268PosRePps100202.genValidationKomponenEkuitasLainnya());
		res.addSegmentValidations(ER2268PosRePps100202.genValidationJumlahEkuitas());
		res.addSegmentValidations(ER2268PosRePps100202.genValidationJumlahLiabilitasDanEkuitas());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2268_RE100202.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi - Juni XX", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi - Juni XX", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2268PosRePps100202.genValidationSum()));
		return res;
	}
}
