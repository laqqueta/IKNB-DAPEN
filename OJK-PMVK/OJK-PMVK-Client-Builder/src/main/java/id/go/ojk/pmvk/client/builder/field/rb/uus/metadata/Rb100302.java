package id.go.ojk.pmvk.client.builder.field.rb.uus.metadata;

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
import id.go.ojk.pmvk.client.builder.field.EFormRencanaBisnisUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.pmvk.client.builder.field.rb.uus.reference.ER2515PosRbPmvu100302;

public class Rb100302 extends BaseMetadata {

	public Rb100302(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnisUus eEnum = EFormRencanaBisnisUus.RB_100302;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 53, 53, ER2515PosRbPmvu100302.genFieldSave(), null, ER2515PosRbPmvu100302.getRequiredPos());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationPendapatanOperasional());
		res.addSegmentValidations(
				ER2515PosRbPmvu100302.genValidationPendapatanDariKegiatanOperasiBerdasarkanPrinsipSyariah());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationPendapatanDariKegiatanUsahaLain());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationPendapatanOperasionalLainTerkaitPembiayaan());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationPendapatanNonOperasional());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationTotalPendapatan());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationBebanOperasional());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationBebanImbalHasil());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationBebanTenagaKerja());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationBebanPenyisihan());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationTotalBeban());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationLabaSebelumPajak());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationKeuntunganPendapatanKomprehensifLainnya());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationLabaBersihKomprehensifPeriodeBerjalan());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationFormLabaSetelahPajak());
		res.addSegmentValidations(ER2515PosRbPmvu100302.genValidationFormKeuntunganPendapatanKomprehensifLainnya());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 20, 20, refTable).confReference(EHeaderMetadataRbUus.R2515_RB100302.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
