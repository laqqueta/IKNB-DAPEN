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
import id.go.ojk.ppk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.ppk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.ppk.client.builder.field.rb.reference.ER2020PosRbPpk100501;

public class Rb100501 extends BaseMetadata {

	public Rb100501(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_100501;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 27, 27, ER2020PosRbPpk100501.genFieldSave(), ER2020PosRbPpk100501.genFieldSave(),
				ER2020PosRbPpk100501.getRequiredPos());
		res.addSegmentValidations(ER2020PosRbPpk100501.genValidationFasilitasPinjamanBelumDitarik());
		res.addSegmentValidations(ER2020PosRbPpk100501.genValidationFasilitasPinjamanBelumDitarikDalamNegeri());
		res.addSegmentValidations(ER2020PosRbPpk100501.genValidationFasilitasPinjamanBelumDitarikLuarNegeri());
		res.addSegmentValidations(ER2020PosRbPpk100501.genValidationPenyaluranPembiayaanBersamaPorsiPihakKetiga());
		res.addSegmentValidations(ER2020PosRbPpk100501.genValidationInstrumenDerivatifUntukLindungNilai());
		res.addSegmentValidations(ER2020PosRbPpk100501.genValidationRekeningAdministratifLainnya());
		res.addSegmentValidations(ER2020PosRbPpk100501.genValidationJumlah());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2020_RB100501.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kinerja Sept XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Proyeksi - Desember XX-1", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Proyeksi - Desember xx", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
