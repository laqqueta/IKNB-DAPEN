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
import id.go.ojk.pnjs.client.builder.field.lb.reference.ER3038PosLbPnjs8100;

public class Lb8100 extends BaseMetadata {

	public Lb8100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_8100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 8, 8, ER3038PosLbPnjs8100.genFieldSave(), null, ER3038PosLbPnjs8100.getRequiredPos());
		res.addSegmentValidations(ER3038PosLbPnjs8100.genValidationNumeric());
		res.addSegmentValidations(ER3038PosLbPnjs8100.genValidationNumericDot());
		res.addSegmentValidations(ER3038PosLbPnjs8100.genValidation7());
		res.addSegmentValidations(ER3038PosLbPnjs8100.genValidation8());
		res.addSegmentValidations(ER3038PosLbPnjs8100.genValidation9());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3038_LB8100.getObject())).confUnique(U));
		fs.add(sf(2, null, "Usaha Produktif", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Usaha Non-Produktif", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Jumlah", sv(M, 1, 16, all)).addFieldValidations(ER3038PosLbPnjs8100.genFieldValidation4()));
		return res;
	}
}
