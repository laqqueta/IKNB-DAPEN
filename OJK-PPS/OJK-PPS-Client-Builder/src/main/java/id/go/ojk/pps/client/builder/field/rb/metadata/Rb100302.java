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
import id.go.ojk.pps.client.builder.field.rb.reference.ER2019PosRbPps100302;

public class Rb100302 extends BaseMetadata {

	public Rb100302(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_100302;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 74, 74, ER2019PosRbPps100302.genFieldSave(), null, ER2019PosRbPps100302.getRequiredPos());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationPendapatan());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationPendapatanOperasional());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationPendapatanKegiatanPembiayaan());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationPendapatanMarginDariKegiatanPembiayaanJualBeli());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationPendapatanBagiHasilPembiayaanInvestasi());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationPendapatanImbalJasaPembiayaanJasa());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationPendapatanOperasionalLainTerkaitPembiayaan());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationPendapatanNonOperasional());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationBeban());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationBebanOperasional());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationBebanMargin());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationBebanTenagaKerja());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationBebanPemasaran());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationBebanPenyisihan());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationBebanPenyisihanPiutang());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationLabaSebelumPajak());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationKeuntunganPendapatanKomprehensifLainnya());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationLabaBersihKomprehensifPeriodeBerjalan());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationFormLabaSetelahPajak());
		res.addSegmentValidations(ER2019PosRbPps100302.genValidationFormKeuntunganPendapatanKomprehensifLainnya());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 20, 20, refTable).confReference(EHeaderMetadataRb.R2019_RB100302.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Juni xx - 1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
