package id.go.ojk.dppks.client.builder.field.rb.metadata;

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
import id.go.ojk.dppks.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.dppks.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.dppks.client.builder.field.rb.reference.ER2016PosRbDppks1201;

public class Rb1201 extends BaseMetadata {

	public Rb1201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 52, 52, ER2016PosRbDppks1201.genFieldSave(), null, ER2016PosRbDppks1201.getRequiredPos());
		res.addSegmentValidations(ER2016PosRbDppks1201.genValidationTotalInvestasi());
		res.addSegmentValidations(ER2016PosRbDppks1201.genValidationPiutangIuran());
		res.addSegmentValidations(ER2016PosRbDppks1201.genValidationTotalAsetLancarDiluarInvestasi());
		res.addSegmentValidations(ER2016PosRbDppks1201.genValidationTotalAsetOperasional());
		res.addSegmentValidations(ER2016PosRbDppks1201.genValidationTotalAsetTersedia());
		res.addSegmentValidations(ER2016PosRbDppks1201.genValidationTotalLiabilitasDiluarNilaiKiniAktuarial());
		res.addSegmentValidations(ER2016PosRbDppks1201.genValidationTotalLiabilitas());
		res.addSegmentValidations(ER2016PosRbDppks1201.genValidationAsetNeto());
		res.addSegmentValidations(ER2016PosRbDppks1201.genValidationFormAsetNeto());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2016_RB1201.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept 20XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
