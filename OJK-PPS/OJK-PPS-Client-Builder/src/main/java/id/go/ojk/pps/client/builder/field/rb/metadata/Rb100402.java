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
import id.go.ojk.pps.client.builder.field.rb.reference.ER2020PosRbPps100402;

public class Rb100402 extends BaseMetadata {

	public Rb100402(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_100402;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 105, 105, ER2020PosRbPps100402.genFieldSave(), null, ER2020PosRbPps100402.getRequiredPos());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationArusKasBersihDariKegiatanOperasi());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPenerimaanKasDariKegiatanOperasi());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPenerimaanDariPembiayaanJualBeli());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPenerimaanDariPembiayaanInvestasi());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPenerimaanDariPembiayaanJasa());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPembayaranKasUntukKegiatanOperasi());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPembayaranUntukKegiatanPembiayaanJualBeli());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPembayaranUntukKegiatanPembiayaanInvestasi());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPembayaranUntukKegiatanPembiayaanJasa());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationArusKasBersihDariKegiatanInvestasi());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPenerimaanKasDariKegiatanInvestasi());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPembayaranKasUntukKegiatanInvestasi());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationArusKasBersihDariAktivitasPendanaan());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPenerimaanKasDariKegiatanPendanaan());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPenerimaanDariPendanaanBank());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPenerimaanDariPendanaanNonbank());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPembayaranKasUntukKegiatanPendanaan());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPengeluaranDariPendanaanBank());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationPengeluaranDariPendanaanNonbank());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationKenaikanBersihKasDanSetaraKas());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationKasDanSetaraKasPadaAkhirPeriode());
		res.addSegmentValidations(ER2020PosRbPps100402.genValidationFormKasDanSetaraKasPadaAkhirPeriode());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2020_RB100402.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
