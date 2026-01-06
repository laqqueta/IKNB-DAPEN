package id.go.ojk.reass.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reass.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.reass.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.reass.client.builder.field.rb.reference.ER2032PosReReass0301;

public class Re0301 extends BaseMetadata {

	public Re0301(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0301;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 39, 39, ER2032PosReReass0301.genFieldSave(), null, ER2032PosReReass0301.getRequiredPos());
		res.addSegmentValidations(ER2032PosReReass0301.genValidationPeningkatanSaldoKas());
		res.addSegmentValidations(ER2032PosReReass0301.genValidationSaldoAkhirKas());
		res.addSegmentValidations(ER2032PosReReass0301.genValidationArusKasDariAktifitasOperasi());
		res.addSegmentValidations(ER2032PosReReass0301.genValidationArusKasMasukOperasi());
		res.addSegmentValidations(ER2032PosReReass0301.genValidationArusKasKeluarOperasi());
		res.addSegmentValidations(ER2032PosReReass0301.genValidationArusKasDariAktifitasInvestasi());
		res.addSegmentValidations(ER2032PosReReass0301.genValidationArusKasMasukInvestasi());
		res.addSegmentValidations(ER2032PosReReass0301.genValidationArusKasKeluarInvestasi());
		res.addSegmentValidations(ER2032PosReReass0301.genValidationArusKasDariAktifitasPendanaan());
		res.addSegmentValidations(ER2032PosReReass0301.genValidationArusKasMasukPendanaan());
		res.addSegmentValidations(ER2032PosReReass0301.genValidationArusKasKeluarPendanaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2032_RE0301.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi-Rupiah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2032PosReReass0301.genValidationField4()));
		fs.add(sf(5, null, "Deviasi-%", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2032PosReReass0301.genValidationField5()));
		return res;
	}
}
