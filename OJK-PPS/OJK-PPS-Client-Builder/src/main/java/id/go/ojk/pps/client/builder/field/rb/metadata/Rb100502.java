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
import id.go.ojk.pps.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.pps.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pps.client.builder.field.rb.reference.ER2021PosRbPps100502;

public class Rb100502 extends BaseMetadata {

	public Rb100502(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_100502;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 24, 24, ER2021PosRbPps100502.genFieldSave(), ER2021PosRbPps100502.genFieldSave(),
				ER2021PosRbPps100502.getRequiredPos());
		res.addSegmentValidations(ER2021PosRbPps100502.genValidationFasilitasPinjamanBelumDitarik());
		res.addSegmentValidations(ER2021PosRbPps100502.genValidationFasilitasPinjamanBelumDitarikDalamNegeri());
		res.addSegmentValidations(ER2021PosRbPps100502.genValidationFasilitasPinjamanBelumDitarikLuarNegeri());
		res.addSegmentValidations(ER2021PosRbPps100502.genValidationPenerbitanSuratSanggupBayarDenganPrinsipSyariah());
		res.addSegmentValidations(ER2021PosRbPps100502.genValidationPenyaluranPembiayaanBersamaPorsiPihakKetiga());
		res.addSegmentValidations(ER2021PosRbPps100502.genValidationInstrumenDerivatifUntukLindungNilaiSyariah());
		res.addSegmentValidations(ER2021PosRbPps100502.genValidationRekeningAdministratifLainnya());
		res.addSegmentValidations(ER2021PosRbPps100502.genValidationJumlah());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2021_RB100502.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
