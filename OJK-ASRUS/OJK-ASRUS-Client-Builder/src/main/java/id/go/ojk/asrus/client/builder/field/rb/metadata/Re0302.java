package id.go.ojk.asrus.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.asrus.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrus.client.builder.field.rb.reference.ER2044PosReAsrus0302;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Re0302 extends BaseMetadata {

	public Re0302(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0302;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 33, 33, ER2044PosReAsrus0302.genFieldSave(), null,
				ER2044PosReAsrus0302.getRequiredPos());
		res.addSegmentValidations(ER2044PosReAsrus0302.genValidationPeningkatanSaldoKas());
		res.addSegmentValidations(ER2044PosReAsrus0302.genValidationSaldoAkhirKas());
		res.addSegmentValidations(ER2044PosReAsrus0302.genValidationArusKasDariAktifitasOperasi());
		res.addSegmentValidations(ER2044PosReAsrus0302.genValidationArusKasMasukOperasi());
		res.addSegmentValidations(ER2044PosReAsrus0302.genValidationArusKasKeluarOperasi());
		res.addSegmentValidations(ER2044PosReAsrus0302.genValidationArusKasDariAktifitasInvestasi());
		res.addSegmentValidations(ER2044PosReAsrus0302.genValidationArusKasMasukInvestasi());
		res.addSegmentValidations(ER2044PosReAsrus0302.genValidationArusKasKeluarInvestasi());
		res.addSegmentValidations(ER2044PosReAsrus0302.genValidationArusKasDariAktifitasPendanaan());
		res.addSegmentValidations(ER2044PosReAsrus0302.genValidationArusKasMasukPendanaan());
		res.addSegmentValidations(ER2044PosReAsrus0302.genValidationArusKasKeluarPendanaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2044_RE0302.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi-Rupiah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2044PosReAsrus0302.genValidationField4()));
		fs.add(sf(5, null, "Deviasi-%", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2044PosReAsrus0302.genValidationField5()));
		return res;
	}
}
