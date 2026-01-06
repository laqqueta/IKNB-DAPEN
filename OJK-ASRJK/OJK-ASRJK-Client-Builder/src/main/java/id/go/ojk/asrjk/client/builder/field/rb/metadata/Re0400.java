package id.go.ojk.asrjk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormRealisasiBisnis;
import id.go.ojk.asrjk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjk.client.builder.field.rb.reference.ER2022PosReAsrjk0400;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Re0400 extends BaseMetadata {

	public Re0400(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRealisasiBisnis eEnum = EFormRealisasiBisnis.RE_0400;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 30, 30, ER2022PosReAsrjk0400.genFieldSave(), null,
				ER2022PosReAsrjk0400.getRequiredPos());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationNumeric());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationNumericDot());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationTingkatSolvabilitas());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationKelebihanTingkatSolvabilitas());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationRasioPencapaianSolvabilitas());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationRasioLikuiditas());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationRasioInvestasi());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationPerimbangan());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationRasioAD());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationRasioBD());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationRasioCD());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationJumlatRasioABCD());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationRasioRoi());
		res.addSegmentValidations(ER2022PosReAsrjk0400.genValidationRasioRoe());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2022_RE0400.getObject())).confUnique(U));
		fs.add(sf(2, null, "Rencana Bisnis", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Rupiah", sv(M, 1, 16, all))
				.addFieldValidations(ER2022PosReAsrjk0400.genValidationField4()));
		return res;
	}
}
