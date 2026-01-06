package id.go.ojk.reask.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.reask.client.builder.field.rb.uus.reference.ER2134PosReReasu0401;

public class Re0401 extends BaseMetadata {

	public Re0401(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_0401;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 25, 25, ER2134PosReReasu0401.genFieldSave(), null, ER2134PosReReasu0401.getRequiredPos());
		res.addSegmentValidations(ER2134PosReReasu0401.genValidationNumeric());
		res.addSegmentValidations(ER2134PosReReasu0401.genValidationNumericDot());
		res.addSegmentValidations(ER2134PosReReasu0401.genValidationTingkatSolvabilitas());
		res.addSegmentValidations(ER2134PosReReasu0401
				.genValidationRasioTingkatSolvabilitasSebelumMemperhitungkanAsetYangTersediaUntukQardh());
		res.addSegmentValidations(ER2134PosReReasu0401.genValidationRasioLikuiditas());
		res.addSegmentValidations(ER2134PosReReasu0401.genValidationRasioPendapatanInvestasiNeto());
		res.addSegmentValidations(ER2134PosReReasu0401.genValidationPerubahanDanaPerusahaan());
		res.addSegmentValidations(ER2134PosReReasu0401.genValidationRasioPerubahanDana());
		res.addSegmentValidations(ER2134PosReReasu0401.genValidationRasioAsetUnitSyariah());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2134_RE0401.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Deviasi", sv(M, 1, 16, all))
				.addFieldValidations(ER2134PosReReasu0401.genValidationField4()));
		return res;
	}
}
