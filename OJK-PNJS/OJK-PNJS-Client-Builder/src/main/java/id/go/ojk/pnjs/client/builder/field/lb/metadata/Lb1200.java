package id.go.ojk.pnjs.client.builder.field.lb.metadata;

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
import id.go.ojk.pnjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjs.client.builder.field.lb.reference.ER3005PosLbPnjs1200;

public class Lb1200 extends BaseMetadata {

	public Lb1200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 39, 39, ER3005PosLbPnjs1200.genFieldSave(), ER3005PosLbPnjs1200.genFieldSave(), 
				ER3005PosLbPnjs1200.getRequiredPos());
		res.addSegmentValidations(ER3005PosLbPnjs1200.genValidationNumeric());
		res.addSegmentValidations(ER3005PosLbPnjs1200.genValidationNumericNegative());
		res.addSegmentValidations(ER3005PosLbPnjs1200.genValidation07());
		res.addSegmentValidations(ER3005PosLbPnjs1200.genValidation15());
		res.addSegmentValidations(ER3005PosLbPnjs1200.genValidation16());
		res.addSegmentValidations(ER3005PosLbPnjs1200.genValidation18());
		res.addSegmentValidations(ER3005PosLbPnjs1200.genValidation21());
		res.addSegmentValidations(ER3005PosLbPnjs1200.genValidation32());
		res.addSegmentValidations(ER3005PosLbPnjs1200.genValidation33());
		res.addSegmentValidations(ER3005PosLbPnjs1200.genValidation35());
		res.addSegmentValidations(ER3005PosLbPnjs1200.genValidation36());
		res.addSegmentValidations(ER3005PosLbPnjs1200.genValidation38());
		res.addSegmentValidations(ER3005PosLbPnjs1200.genValidation40());
        res.addSegmentValidations(ER3005PosLbPnjs1200.genValidation41());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataLb.R3005_LB1200.getObject())).confUnique(U));
		fs.add(sf(2, null, "Jumlah", sv(M, 1, 16, all)));
		return res;
	}
}
