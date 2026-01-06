package id.go.ojk.pmvs.client.builder.field.rb.metadata;

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
import id.go.ojk.pmvs.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.pmvs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.pmvs.client.builder.field.rb.reference.ER2267PosRePmvs100502;

public class Re100502 extends BaseMetadata {

	public Re100502(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_100502;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 24, 24, ER2267PosRePmvs100502.genFieldSave(), ER2267PosRePmvs100502.genFieldSave(),
				ER2267PosRePmvs100502.getRequiredPos());
		res.addSegmentValidations(ER2267PosRePmvs100502.genValidationFasilitasPendanaanBelumDitarik());
		res.addSegmentValidations(ER2267PosRePmvs100502.genValidationFasilitasPendanaanBelumDitarikDalamNegeri());
		res.addSegmentValidations(ER2267PosRePmvs100502.genValidationFasilitasPendanaanBelumDitarikLuarNegeri());
		res.addSegmentValidations(ER2267PosRePmvs100502.genValidationPenerbitanSuratSanggupBayar());
		res.addSegmentValidations(ER2267PosRePmvs100502.genValidationInstrumenDerivatifUntukLindungNilai());
		res.addSegmentValidations(ER2267PosRePmvs100502.genValidationRekeningAdministratifLainnya());
		res.addSegmentValidations(ER2267PosRePmvs100502.genValidationJumlah());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2267_RE100502.getObject())).confUnique(U));
		fs.add(sf(2, null, "Proyeksi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi - Juni xx", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2267PosRePmvs100502.genValidationSum()));
		return res;
	}
}
