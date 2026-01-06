package id.go.ojk.ppk.client.builder.field.rb.metadata;

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
import id.go.ojk.ppk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.ppk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.ppk.client.builder.field.rb.reference.ER2268PosRePpk100301;

public class Re100301 extends BaseMetadata {

	public Re100301(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_100301;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 87, 87, ER2268PosRePpk100301.genFieldSave(), null, ER2268PosRePpk100301.getRequiredPos());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationPendapatan());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationPendapatanOperasional());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationPendapatanKegiatanOperasi());
		res.addSegmentValidations(
				ER2268PosRePpk100301.genValidationPendapatanBungaDariKegiatanPembiayaanKonvensional());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationPembiayaanInvestasi());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationPembiayaanModalKerja());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationPembiayaanMultiguna());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationPembiayaanBerdasarkanPrinsipSyariah());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationPendapatanOperasionalLainTerkaitPembiayaan());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationPendapatanOperasionalTidakTerkaitPembiayaan());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationPendapatanDariKegiatanBerbasisFee());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationPendapatanNonOperasional());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationBeban());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationBebanOperasional());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationBebanBunga());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationBebanTenagaKerja());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationBebanPemasaran());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationBebanPenyisihan());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationBebanPenyisihanPiutang());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationLabaSebelumPajak());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationKeuntunganPendapatanKomprehensifLainnya());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationLabaBersihKomprehensifPeriodeBerjalan());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationFormLabaSetelahPajak());
		res.addSegmentValidations(ER2268PosRePpk100301.genValidationFormKeuntunganPendapatanKomprehensifLainnya());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 20, 20, refTable).confReference(EHeaderMetadataRb.R2268_RE100301.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2268PosRePpk100301.genValidationSum()));
		return res;
	}
}
