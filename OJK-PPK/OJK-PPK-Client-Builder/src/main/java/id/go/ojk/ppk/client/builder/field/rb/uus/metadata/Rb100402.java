package id.go.ojk.ppk.client.builder.field.rb.uus.metadata;

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
import id.go.ojk.ppk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.ER2520PosRbPpu100402;

public class Rb100402 extends BaseMetadata {

	public Rb100402(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_100402;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 105, 105, ER2520PosRbPpu100402.genFieldSave(), null, ER2520PosRbPpu100402.getRequiredPos());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationArusKasBersihDariKegiatanOperasi());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPenerimaanKasDariKegiatanOperasi());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPenerimaanDariPembiayaanJualBeli());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPenerimaanDariPembiayaanInvestasi());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPenerimaanDariPembiayaanJasa());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPembayaranKasUntukKegiatanOperasi());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPembayaranUntukKegiatanPembiayaanJualBeli());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPembayaranUntukKegiatanPembiayaanInvestasi());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPembayaranUntukKegiatanPembiayaanJasa());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationArusKasBersihDariKegiatanInvestasi());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPenerimaanKasDariKegiatanInvestasi());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPembayaranKasUntukKegiatanInvestasi());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationArusKasBersihDariAktivitasPendanaan());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPenerimaanKasDariKegiatanPendanaan());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPenerimaanDariPendanaanBank());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPenerimaanDariPendanaanNonbank());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPembayaranKasUntukKegiatanPendanaan());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPengeluaranDariPendanaanBank());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationPengeluaranDariPendanaanNonbank());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationKenaikanBersihKasDanSetaraKas());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationKasDanSetaraKasPadaAkhirPeriode());
		res.addSegmentValidations(ER2520PosRbPpu100402.genValidationFormKasDanSetaraKasPadaAkhirPeriode());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2520_RB100402.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
