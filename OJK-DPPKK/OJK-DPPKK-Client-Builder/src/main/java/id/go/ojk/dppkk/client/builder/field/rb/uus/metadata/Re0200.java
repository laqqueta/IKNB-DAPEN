package id.go.ojk.dppkk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.dppkk.client.builder.field.rb.uus.reference.ER2120PosReDppu0200;

public class Re0200 extends BaseMetadata {

	public Re0200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_0200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 52, 52, ER2120PosReDppu0200.genFieldSave(), null, ER2120PosReDppu0200.getRequiredPos());
		res.addSegmentValidations(ER2120PosReDppu0200.genValidationInvestasi());
		res.addSegmentValidations(ER2120PosReDppu0200.genValidationPiutangIuran());
		res.addSegmentValidations(ER2120PosReDppu0200.genValidationAsetLancarDiluarInvestasi());
		res.addSegmentValidations(ER2120PosReDppu0200.genValidationAsetOperasional());
		res.addSegmentValidations(ER2120PosReDppu0200.genValidationAsetTersedia());
		res.addSegmentValidations(ER2120PosReDppu0200.genValidationLiabilitasDiLuarNilaiKiniAktuarial());
		res.addSegmentValidations(ER2120PosReDppu0200.genValidationLiabilitas());
		res.addSegmentValidations(ER2120PosReDppu0200.genValidationAsetNeto());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRbUus.R2120_RE0200.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi Rupiah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2120PosReDppu0200.genValidation4()));
		fs.add(sf(5, null, "Deviasi Persentase (%)", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2120PosReDppu0200.genValidation5()));
		return res;
	}
}
