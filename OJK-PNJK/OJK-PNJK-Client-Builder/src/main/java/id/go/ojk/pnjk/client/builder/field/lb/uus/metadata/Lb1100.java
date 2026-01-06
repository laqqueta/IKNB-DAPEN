package id.go.ojk.pnjk.client.builder.field.lb.uus.metadata;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3104PosLbPnju1100;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Lb1100 extends BaseMetadata {

	public Lb1100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_1100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 100, 100, ER3104PosLbPnju1100.genFieldSave(), ER3104PosLbPnju1100.genFieldSave(), 
				ER3104PosLbPnju1100.getRequiredPos());
		res.addSegmentValidations(ER3104PosLbPnju1100.genValidationNumeric());
		res.addSegmentValidations(ER3104PosLbPnju1100.genValidationNumericNegative());
		res.addSegmentValidations(ER3104PosLbPnju1100.genValidation003());
		res.addSegmentValidations(ER3104PosLbPnju1100.genValidation030());
		res.addSegmentValidations(ER3104PosLbPnju1100.genValidation031());
		res.addSegmentValidations(ER3104PosLbPnju1100.genValidation057());
		res.addSegmentValidations(ER3104PosLbPnju1100.genValidation058());
        res.addSegmentValidations(ER3104PosLbPnju1100.genValidation059());
		res.addSegmentValidations(ER3104PosLbPnju1100.genValidation073());
		res.addSegmentValidations(ER3104PosLbPnju1100.genValidation088());
		res.addSegmentValidations(ER3104PosLbPnju1100.genValidation089());
		res.addSegmentValidations(ER3104PosLbPnju1100.genValidation090());
		res.addSegmentValidations(ER3104PosLbPnju1100.genValidation093());
		res.addSegmentValidations(ER3104PosLbPnju1100.genValidation101());

        res.addSegmentValidations(ER3104PosLbPnju1100.genValidationR11000202140000());
        res.addSegmentValidations(ER3104PosLbPnju1100.genValidationR11000201140000());
        res.addSegmentValidations(ER3104PosLbPnju1100.genValidationR11000101130000());
        res.addSegmentValidations(ER3104PosLbPnju1100.genValidationR11000102110000());
        res.addSegmentValidations(ER3104PosLbPnju1100.genValidationR11000102011200());
        res.addSegmentValidations(ER3104PosLbPnju1100.genValidationR11000101021200());
        res.addSegmentValidations(ER3104PosLbPnju1100.genValidationR11000101021100());
        res.addSegmentValidations(ER3104PosLbPnju1100.genValidationR11000102011100());
        res.addSegmentValidations(ER3104PosLbPnju1100.genValidationR11000101020100());
        res.addSegmentValidations(ER3104PosLbPnju1100.genValidationR11000102010100());
        res.addSegmentValidations(ER3104PosLbPnju1100.genRowValidationMulti1());
        res.addSegmentValidations(ER3104PosLbPnju1100.genRowValidationMulti2());
        res.addSegmentValidations(ER3104PosLbPnju1100.genRowValidationMulti3());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataLbUus.R3104_LB1100.getObject())).confUnique(U));
		fs.add(sf(2, null, "Jumlah", sv(M, 1, 16, all)));
		return res;
	}
}
