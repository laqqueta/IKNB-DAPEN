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
import id.go.ojk.ppk.client.builder.field.rb.uus.reference.ER2769PosRePpu100302;

public class Re100302 extends BaseMetadata {

	public Re100302(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_100302;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 74, 74, ER2769PosRePpu100302.genFieldSave(), null, ER2769PosRePpu100302.getRequiredPos());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationPendapatan());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationPendapatanOperasional());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationPendapatanKegiatanPembiayaan());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationPendapatanMarginPembiayaanJualBeli());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationPendapatanBagiHasilPembiayaanInvestasi());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationPendapatanImbalJasaPembiayaanJasa());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationPendapatanOperasionalLainTerkaitPembiayaan());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationPendapatanNonOperasional());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationBeban());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationBebanOperasional());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationBebanMargin());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationBebanTenagaKerja());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationBebanPemasaran());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationBebanPenyisihan());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationBebanPenyisihanPiutang());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationLabaSebelumPajak());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationKeuntunganPendapatanKomprehensifLainnya());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationLabaBersihKomprehensifPeriodeBerjalan());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationFormLabaSetelahPajak());
		res.addSegmentValidations(ER2769PosRePpu100302.genValidationFormKeuntunganPendapatanKomprehensifLainnya());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 20, 20, refTable).confReference(EHeaderMetadataRbUus.R2769_RE100302.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi Juni XX", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi Juni XX", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2769PosRePpu100302.genValidationSum()));
		return res;
	}
}
