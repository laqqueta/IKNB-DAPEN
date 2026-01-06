package id.go.ojk.pnjk.client.builder.field.lb.metadata;

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
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjk.client.builder.field.lb.reference.ER3006PosLbPnjk1300;

public class Lb1300 extends BaseMetadata {

	public Lb1300(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_1300;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 31, 31, ER3006PosLbPnjk1300.genFieldSave(), null, ER3006PosLbPnjk1300.getRequiredPos());
		res.addSegmentValidations(ER3006PosLbPnjk1300.genValidationNumericNegative());
		res.addSegmentValidations(ER3006PosLbPnjk1300.genValidation07());
		res.addSegmentValidations(ER3006PosLbPnjk1300.genValidation12());
		res.addSegmentValidations(ER3006PosLbPnjk1300.genValidation13());
		res.addSegmentValidations(ER3006PosLbPnjk1300.genValidation17());
		res.addSegmentValidations(ER3006PosLbPnjk1300.genValidation20());
		res.addSegmentValidations(ER3006PosLbPnjk1300.genValidation21());
		res.addSegmentValidations(ER3006PosLbPnjk1300.genValidation26());
		res.addSegmentValidations(ER3006PosLbPnjk1300.genValidation29());
		res.addSegmentValidations(ER3006PosLbPnjk1300.genValidation30());
		res.addSegmentValidations(ER3006PosLbPnjk1300.genValidation31());
		res.addSegmentValidations(ER3006PosLbPnjk1300.genValidation33());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataLb.R3006_LB1300.getObject())).confUnique(U));
		fs.add(sf(2, null, "Jumlah", sv(M, 1, 16, all)));
		return res;
	}
}
