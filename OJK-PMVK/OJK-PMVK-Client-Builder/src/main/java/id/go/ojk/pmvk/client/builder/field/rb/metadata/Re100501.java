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
import id.go.ojk.pmvk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pmvk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvk.client.builder.field.rb.reference.ER2267PosRePmvk100501;

public class Re100501 extends BaseMetadata {

	public Re100501(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_100501;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 31, 31, ER2267PosRePmvk100501.genFieldSave(), ER2267PosRePmvk100501.genFieldSave(),
				ER2267PosRePmvk100501.getRequiredPos());
		res.addSegmentValidations(ER2267PosRePmvk100501.genValidationFasilitasPinjamanBelumDitarik());
		res.addSegmentValidations(ER2267PosRePmvk100501.genValidationFasilitasPinjamanBelumDitarikDalamNegeri());
		res.addSegmentValidations(ER2267PosRePmvk100501.genValidationFasilitasPinjamanBelumDitarikLuarNegeri());
		res.addSegmentValidations(ER2267PosRePmvk100501.genValidationPenerbitanSuratSanggupBayar());
		res.addSegmentValidations(ER2267PosRePmvk100501.genValidationPenyaluranPembiayaanBersamaPorsiPihakKetiga());
		res.addSegmentValidations(ER2267PosRePmvk100501.genValidationInstrumenDerivatifUntukLindungNilai());
		res.addSegmentValidations(ER2267PosRePmvk100501.genValidationRekeningAdministratifLainnya());
		res.addSegmentValidations(ER2267PosRePmvk100501.genValidationJumlah());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2267_RE100501.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2267PosRePmvk100501.genValidationSum()));
		return res;
	}
}
