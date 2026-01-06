package id.go.ojk.asruk.client.builder.field.rb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormRealisasiBisnisUus;
import id.go.ojk.asruk.client.builder.field.rb.uus.reference.EHeaderMetadataRbUus;
import id.go.ojk.asruk.client.builder.field.rb.uus.reference.ER2148PosReAsruu0403;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Re0403 extends BaseMetadata {

	public Re0403(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnisUus eEnum = EFormRealisasiBisnisUus.RE_0403;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 10, 10, ER2148PosReAsruu0403.genFieldSave(), null,
				ER2148PosReAsruu0403.getRequiredPos());
		res.addSegmentValidations(ER2148PosReAsruu0403.genValidationNumeric());
		res.addSegmentValidations(ER2148PosReAsruu0403.genValidationNumericDot());
		res.addSegmentValidations(ER2148PosReAsruu0403.genValidationRasioLikuiditas());
		res.addSegmentValidations(ER2148PosReAsruu0403.genValidationRasioPendapatanInvestasiNeto());
		res.addSegmentValidations(ER2148PosReAsruu0403.genValidationPerubahanDanaPerusahaan());
		res.addSegmentValidations(ER2148PosReAsruu0403.genValidationRasioPerubahanDana());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRbUus.R2148_RE0403.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Deviasi Rupiah", sv(M, 1, 16, all))
				.addFieldValidations(ER2148PosReAsruu0403.genValidationField4()));
		return res;
	}
}
