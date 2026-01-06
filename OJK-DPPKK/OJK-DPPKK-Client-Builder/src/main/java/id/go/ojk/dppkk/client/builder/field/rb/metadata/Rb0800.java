package id.go.ojk.dppkk.client.builder.field.rb.metadata;

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
import id.go.ojk.dppkk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dppkk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppkk.client.builder.field.rb.reference.ER2007PosRbDppkk0800;

public class Rb0800 extends BaseMetadata {

	public Rb0800(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_0800;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 51, 51, ER2007PosRbDppkk0800.genFieldSave(), null, ER2007PosRbDppkk0800.getRequiredPos());
		res.addSegmentValidations(ER2007PosRbDppkk0800.genValidationInvestasi());
		res.addSegmentValidations(ER2007PosRbDppkk0800.genValidationPiutangIuran());
		res.addSegmentValidations(ER2007PosRbDppkk0800.genValidationAsetLancarDiluarInvestasi());
		res.addSegmentValidations(ER2007PosRbDppkk0800.genValidationAsetOperasional());
		res.addSegmentValidations(ER2007PosRbDppkk0800.genValidationAsetTersedia());
		res.addSegmentValidations(
				ER2007PosRbDppkk0800.genValidationLiabilitasDiLuarNilaiKiniAktuarialLiabilitasManfaatPensiun());
		res.addSegmentValidations(ER2007PosRbDppkk0800.genValidationLiabilitas());
		res.addSegmentValidations(ER2007PosRbDppkk0800.genValidationAsetNeto());
		res.addSegmentValidations(ER2007PosRbDppkk0800.genValidationFormTotalAsetNeto());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2007_RB0800.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept XX-1", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi per 31 Desember XX-1", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi per 30 Juni XX", sv(M, 1, 20, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Desember XX", sv(M, 1, 20, numericNegatif)));
		return res;
	}
}
