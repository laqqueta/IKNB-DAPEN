package id.go.ojk.pnjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjs.client.builder.field.lb.reference.ER3000PosLbPnjs0000;
import id.go.ojk.pnjs.client.builder.field.reference.EHeaderMetadataShared;

public class Lb0000 extends BaseMetadata {

	public Lb0000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 29, null, ER3000PosLbPnjs0000.genFieldSave(), null, ER3000PosLbPnjs0000.getRequiredPos());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidationLen10());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidationLen100());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidationLen15());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidationLen40());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidationLen5());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidationLen50());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidationLen8());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidationLenNpwp());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidationNumeric());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidationPhone());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidationDate());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidationReference1());
		res.addSegmentValidations(
				ER3000PosLbPnjs0000.genValidationReference(3, EHeaderMetadataShared.R033.getNumber()));
		res.addSegmentValidations(
				ER3000PosLbPnjs0000.genValidationReference(5, EHeaderMetadataShared.R000.getNumber()));
		res.addSegmentValidations(
				ER3000PosLbPnjs0000.genValidationReference(6, EHeaderMetadataShared.R001.getNumber()));
		res.addSegmentValidations(
				ER3000PosLbPnjs0000.genValidationReference(8, EHeaderMetadataShared.R006.getNumber()));
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidation10());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidation17());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidation18A());
		res.addSegmentValidations(ER3000PosLbPnjs0000.genValidation18B());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 12, 12, refTable).confReference(EHeaderMetadataLb.R3000_LB0000.getObject())));
		fs.add(sf(2, null, "Keterangan", sv(C, 1, 200, all).confConditionalRequired(ER3000PosLbPnjs0000.genCondition())));
		return res;
	}
}
