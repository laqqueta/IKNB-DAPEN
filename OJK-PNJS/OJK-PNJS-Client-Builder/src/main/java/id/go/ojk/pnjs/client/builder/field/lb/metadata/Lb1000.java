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
import id.go.ojk.pnjs.client.builder.field.lb.reference.ER3003PosLbPnjs1000;

public class Lb1000 extends BaseMetadata {

	public Lb1000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 21, 21, ER3003PosLbPnjs1000.genFieldSave(), ER3003PosLbPnjs1000.genFieldSave(),
				ER3003PosLbPnjs1000.getRequiredPos());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidationNumeric());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidationNumericNegative());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidationNumericDot());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation02());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation03());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation04());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation05());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation06());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation07A());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation07B());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation12());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation14());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation15());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation16());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation17());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation18A());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation18B());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation22());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation23());
		res.addSegmentValidations(ER3003PosLbPnjs1000.genValidation24());

        res.addSegmentValidations(ER3003PosLbPnjs1000.genValidationR1000100000());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3003_LB1000.getObject())).confUnique(U));
		fs.add(sf(2, null, "Jumlah", sv(M, 1, 16, all)));
		return res;
	}
}
