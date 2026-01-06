package id.go.ojk.asrjk.client.builder.field.rb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormRencanaBisnis;
import id.go.ojk.asrjk.client.builder.field.rb.reference.EHeaderMetadataRb;
import id.go.ojk.asrjk.client.builder.field.rb.reference.ER2017PosRbAsrjk1311;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Rb1311 extends BaseMetadata {

	public Rb1311(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormRencanaBisnis eEnum = EFormRencanaBisnis.RB_1311;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 30, 30, ER2017PosRbAsrjk1311.genFieldSave(), null, 
				ER2017PosRbAsrjk1311.getRequiredPos());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationNumeric());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationNumericDot());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationTingkatSolvabilitas());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationKelebihanTingkatSolvabilitas());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationRasioPencapaianSolvabilitas());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationRasioLikuiditas());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationRasioKecukupanInvestasi());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationRasioPerimbangan());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationRasioAD());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationRasioBD());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationRasioCD());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationTotalRasioABC());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationRasioROI());
		res.addSegmentValidations(ER2017PosRbAsrjk1311.genValidationRasioROE());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataRb.R2017_RB1311.getObject())).confUnique(U));
		fs.add(sf(2, null, "Aktual per 30 Sept 20XX - 1", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Proyeksi per 31 Des 20xx - 1", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Proyeksi per 30 Jun 20xx", sv(M, 1, 16, all)));
		fs.add(sf(5, null, "Proyeksi per 31 Des 20xx", sv(M, 1, 16, all)));
		return res;
	}
}
