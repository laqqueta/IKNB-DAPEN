package id.go.ojk.asrjk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrjk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjk.client.builder.field.rb.reference.ER2016PosRbAsrjk1308;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb1308 extends BaseMetadata {

	public Rb1308(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1308;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 35, 35, ER2016PosRbAsrjk1308.genFieldSave(), null,
				ER2016PosRbAsrjk1308.getRequiredPos());
		res.addSegmentValidations(ER2016PosRbAsrjk1308.genValidationArusKasOperasiMasuk());
		res.addSegmentValidations(ER2016PosRbAsrjk1308.genValidationArusKasOperasiKeluar());
		res.addSegmentValidations(ER2016PosRbAsrjk1308.genValidationArusKasOperasi());
		res.addSegmentValidations(ER2016PosRbAsrjk1308.genValidationArusKasInvestasiMasuk());
		res.addSegmentValidations(ER2016PosRbAsrjk1308.genValidationArusKasInvestasiKeluar());
		res.addSegmentValidations(ER2016PosRbAsrjk1308.genValidationArusKasInvestasi());
		res.addSegmentValidations(ER2016PosRbAsrjk1308.genValidationArusKasPendanaanMasuk());
		res.addSegmentValidations(ER2016PosRbAsrjk1308.genValidationArusKasPendanaanKeluar());
		res.addSegmentValidations(ER2016PosRbAsrjk1308.genValidationArusKasPendanaan());
		res.addSegmentValidations(ER2016PosRbAsrjk1308.genValidationSaldoAkhir());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2016_RB1308.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept 20XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
