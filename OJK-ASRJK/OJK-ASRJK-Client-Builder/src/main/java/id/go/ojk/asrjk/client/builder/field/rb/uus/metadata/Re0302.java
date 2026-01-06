package id.go.ojk.asrjk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.asrjk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.asrjk.client.builder.field.rb.uus.reference.ER2144PosReAsrju0302;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Re0302 extends BaseMetadata {

	public Re0302(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_0302;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 33, 33, ER2144PosReAsrju0302.genFieldSave(), null,
				ER2144PosReAsrju0302.getRequiredPos());
		res.addSegmentValidations(ER2144PosReAsrju0302.genValidationPeningkatanSaldoKas());
		res.addSegmentValidations(ER2144PosReAsrju0302.genValidationSaldoAkhirKas());
		res.addSegmentValidations(ER2144PosReAsrju0302.genValidationArusKasDariAktifitasOperasi());
		res.addSegmentValidations(ER2144PosReAsrju0302.genValidationArusKasMasukOperasi());
		res.addSegmentValidations(ER2144PosReAsrju0302.genValidationArusKasKeluarOperasi());
		res.addSegmentValidations(ER2144PosReAsrju0302.genValidationArusKasDariAktifitasInvestasi());
		res.addSegmentValidations(ER2144PosReAsrju0302.genValidationArusKasMasukInvestasi());
		res.addSegmentValidations(ER2144PosReAsrju0302.genValidationArusKasKeluarInvestasi());
		res.addSegmentValidations(ER2144PosReAsrju0302.genValidationArusKasDariAktifitasPendanaan());
		res.addSegmentValidations(ER2144PosReAsrju0302.genValidationArusKasMasukPendanaan());
		res.addSegmentValidations(ER2144PosReAsrju0302.genValidationArusKasKeluarPendanaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2144_RE0302.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi-Rupiah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER2144PosReAsrju0302.genValidationField4()));
		fs.add(sf(5, null, "Deviasi-%", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2144PosReAsrju0302.genValidationField5()));
		return res;
	}
}
