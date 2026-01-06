package id.go.ojk.asrjs.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.asrjs.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjs.client.builder.field.rb.reference.ER2045PosReAsrjs0303;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Re0303 extends BaseMetadata {

	public Re0303(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0303;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 22, 22, ER2045PosReAsrjs0303.genFieldSave(), null,
				ER2045PosReAsrjs0303.getRequiredPos());
		res.addSegmentValidations(ER2045PosReAsrjs0303.genValidationPeningkatanSaldoKas());
		res.addSegmentValidations(ER2045PosReAsrjs0303.genValidationSaldoAkhirKas());
		res.addSegmentValidations(ER2045PosReAsrjs0303.genValidationArusKasDariAktifitasOperasi());
		res.addSegmentValidations(ER2045PosReAsrjs0303.genValidationArusKasMasukOperasi());
		res.addSegmentValidations(ER2045PosReAsrjs0303.genValidationArusKasKeluarOperasi());
		res.addSegmentValidations(ER2045PosReAsrjs0303.genValidationArusKasDariAktifitasInvestasi());
		res.addSegmentValidations(ER2045PosReAsrjs0303.genValidationArusKasMasukInvestasi());
		res.addSegmentValidations(ER2045PosReAsrjs0303.genValidationArusKasKeluarInvestasi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2045_RE0303.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Deviasi-%", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER2045PosReAsrjs0303.genValidationField5()));
		return res;
	}
}
