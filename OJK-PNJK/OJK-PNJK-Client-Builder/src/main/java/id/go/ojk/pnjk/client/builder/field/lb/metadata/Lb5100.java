package id.go.ojk.pnjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjk.client.builder.field.lb.reference.ER3035PosLbPnjk5100;

public class Lb5100 extends BaseMetadata {

	public Lb5100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_5100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 9, 9, ER3035PosLbPnjk5100.genFieldSave(), null, ER3035PosLbPnjk5100.getRequiredPos());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidationAlpha2());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidationAlpha5());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidationNumericDot2());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidationNumericDot5());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidation02());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidation03());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidation04());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidation05());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidation06());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidation07A());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidation07B());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidation08A());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidation08B());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidation09());
		res.addSegmentValidations(ER3035PosLbPnjk5100.genValidation10());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3035_LB5100.getObject())).confUnique(U));
		fs.add(sf(2, null, "Analisis", sv(C, 1, 20, all).confConditionalRequired(ER3035PosLbPnjk5100.genConditionA())));
		fs.add(sf(3, null, "Kriteria Nilai",
				sv(C, 1, 6, numeric).confConditionalRequired(ER3035PosLbPnjk5100.genConditionA())));
		fs.add(sf(4, null, "Bobot",
				sv(C, 3, 6, numericDot).confConditionalRequired(ER3035PosLbPnjk5100.genConditionA()))
				.addFieldValidations(ER3035PosLbPnjk5100.genFieldValidation4()));
		fs.add(sf(5, null, "Komposit", sv(M, 1, 20, all))
				.addFieldValidations(ER3035PosLbPnjk5100.genFieldValidation5()));
		return res;
	}
}
