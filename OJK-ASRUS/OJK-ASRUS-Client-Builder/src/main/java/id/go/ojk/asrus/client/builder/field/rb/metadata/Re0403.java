package id.go.ojk.asrus.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.asrus.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrus.client.builder.field.rb.reference.ER2048PosReAsrus0403;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Re0403 extends BaseMetadata {

	public Re0403(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0403;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 10, 10, ER2048PosReAsrus0403.genFieldSave(), null,
				ER2048PosReAsrus0403.getRequiredPos());
		res.addSegmentValidations(ER2048PosReAsrus0403.genValidationNumeric());
		res.addSegmentValidations(ER2048PosReAsrus0403.genValidationNumericDot());
		res.addSegmentValidations(ER2048PosReAsrus0403.genValidationRasioLikuiditas());
		res.addSegmentValidations(ER2048PosReAsrus0403.genValidationRasioPendapatanInvestasiNeto());
		res.addSegmentValidations(ER2048PosReAsrus0403.genValidationPerubahanDanaPerusahaan());
		res.addSegmentValidations(ER2048PosReAsrus0403.genValidationRasioPerubahanDana());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataRb.R2048_RE0403.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Deviasi Rupiah", sv(M, 1, 16, all))
				.addFieldValidations(ER2048PosReAsrus0403.genValidationField4()));
		return res;
	}
}
