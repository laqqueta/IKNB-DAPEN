package id.go.ojk.pmvs.client.builder.field.rb.metadata;

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
import id.go.ojk.pmvs.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.pmvs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvs.client.builder.field.rb.reference.ER2014PosRbPmvs100202;

public class Rb100202 extends BaseMetadata {

	public Rb100202(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_100202;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 41, 41, ER2014PosRbPmvs100202.genFieldSave(), ER2014PosRbPmvs100202.genFieldSave(),
				ER2014PosRbPmvs100202.getRequiredPos());
		res.addSegmentValidations(ER2014PosRbPmvs100202.genValidationJumlahAset());
		res.addSegmentValidations(ER2014PosRbPmvs100202.genValidationJumlahAsetJumlahLiabilitasDanEkuitas());
		res.addSegmentValidations(ER2014PosRbPmvs100202.genValidationJumlahLiabilitas());
		res.addSegmentValidations(ER2014PosRbPmvs100202.genValidationModal());
		res.addSegmentValidations(ER2014PosRbPmvs100202.genValidationTambahanModalDisetor());
		res.addSegmentValidations(ER2014PosRbPmvs100202.genValidationCadangan());
		res.addSegmentValidations(ER2014PosRbPmvs100202.genValidationKomponenEkuitasLainnya());
		res.addSegmentValidations(ER2014PosRbPmvs100202.genValidationJumlahEkuitas());
		res.addSegmentValidations(ER2014PosRbPmvs100202.genValidationJumlahLiabilitasDanEkuitas());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2014_RB100202.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
