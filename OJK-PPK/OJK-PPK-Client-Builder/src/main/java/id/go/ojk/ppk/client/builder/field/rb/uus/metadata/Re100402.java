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
import id.go.ojk.ppk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.ER2770PosRePpu100402;

public class Re100402 extends BaseMetadata {

	public Re100402(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_100402;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 105, 105, ER2770PosRePpu100402.genFieldSave(), null, ER2770PosRePpu100402.getRequiredPos());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationArusKasBersihDariKegiatanOperasi());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPenerimaanKasDariKegiatanOperasi());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPenerimaanDariPembiayaanJualBeli());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPenerimaanDariPembiayaanInvestasi());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPenerimaanDariPembiayaanJasa());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPembayaranKasUntukKegiatanOperasi());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPembayaranUntukKegiatanPembiayaanJualBeli());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPembayaranUntukKegiatanPembiayaanInvestasi());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPembayaranUntukKegiatanPembiayaanJasa());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationArusKasBersihDariKegiatanInvestasi());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPenerimaanKasDariKegiatanInvestasi());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPembayaranKasUntukKegiatanInvestasi());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationArusKasBersihDariAktivitasPendanaan());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPenerimaanKasDariKegiatanPendanaan());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPenerimaanDariPendanaanBank());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPenerimaanDariPendanaanNonbank());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPembayaranKasUntukKegiatanPendanaan());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPengeluaranDariPendanaanBank());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationPengeluaranDariPendanaanNonbank());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationKenaikanBersihKasDanSetarKas());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationKasDanSetaraKasPadaAkhirPeriode());
		res.addSegmentValidations(ER2770PosRePpu100402.genValidationFormKasDanSetaraKasPadaAkhirPeriode());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2770_RE100402.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi Juni XX", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi Juni XX", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2770PosRePpu100402.genValidationSum()));
		return res;
	}
}
