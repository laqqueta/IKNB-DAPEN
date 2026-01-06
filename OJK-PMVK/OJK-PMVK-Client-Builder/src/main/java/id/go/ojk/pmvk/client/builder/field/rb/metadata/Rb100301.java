package id.go.ojk.pmvk.client.builder.field.rb.metadata;

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
import id.go.ojk.pmvk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.pmvk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvk.client.builder.field.rb.reference.ER2015PosRbPmvk100301;

public class Rb100301 extends BaseMetadata {

	public Rb100301(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_100301;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 62, 62, ER2015PosRbPmvk100301.genFieldSave(), null, ER2015PosRbPmvk100301.getRequiredPos());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationPendapatanOperasional());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationPendapatanKegiatanOperasi());
		res.addSegmentValidations(
				ER2015PosRbPmvk100301.genValidationPendapatanKegiatanOperasiBerdasarkanPrinsipSyariah());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationPendapatanDariKegiatanUsahaLain());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationPendapatanOperasionalLainTerkaitPembiayaan());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationPendapatanNonOperasional());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationTotalPendapatan());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationBebanOperasional());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationBebanBunga());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationBebanTenagaKerja());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationBebanPenyisihan());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationTotalBeban());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationLabaSebelumPajak());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationKeuntunganPendapatanKomprehensifLainnya());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationLabaBersihKomprehensifPeriodeBerjalan());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationFormLabaSetelahPajak());
		res.addSegmentValidations(ER2015PosRbPmvk100301.genValidationFormKeuntunganPendapatanKomprehensifLainnya());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 20, 20, refTable).confReference(EHeaderMetadataRb.R2015_RB100301.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
