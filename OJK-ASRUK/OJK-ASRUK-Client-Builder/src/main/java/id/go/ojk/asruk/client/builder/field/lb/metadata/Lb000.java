package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3000PosLbAsruk000;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb000 extends BaseMetadata {

	public Lb000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 14, 14, ER3000PosLbAsruk000.genFieldSave(), null, ER3000PosLbAsruk000.getRequiredPos());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationMaxLen10());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationMaxLen15());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationMaxLen25());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationMaxLen50());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationMaxLen8());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationCompanyAddress());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationCompanyName());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationDati1());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationDati2());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationEmail());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationName());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationNiu());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationNpwp());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationDate());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationNumeric());
		res.addSegmentValidations(ER3000PosLbAsruk000.genValidationPhone());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3000_LB000.getObject())).confUnique(U));
		fs.add(sf(2, null, "Informasi", sv(M, 1, 250, all)));
		return res;
	}
}
