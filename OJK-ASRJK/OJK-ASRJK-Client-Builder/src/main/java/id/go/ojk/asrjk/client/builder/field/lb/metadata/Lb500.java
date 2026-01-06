package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3009PosLbAsrjk500;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb500 extends BaseMetadata {

	public Lb500(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_500;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 22, 22, ER3009PosLbAsrjk500.genFieldSave(),
				ER3009PosLbAsrjk500.genFieldSave(), ER3009PosLbAsrjk500.getRequiredPos());
		res.addSegmentValidations(ER3009PosLbAsrjk500.genValidationNumericDotNegative1());
//		res.addSegmentValidations(ER3009PosLbAsrjk500.genValidationNumericDotNegativeLength1());
		res.addSegmentValidations(ER3009PosLbAsrjk500.genValidationNumericNegative1());
		res.addSegmentValidations(ER3009PosLbAsrjk500.genValidationNumericNegative2());
		res.addSegmentValidations(ER3009PosLbAsrjk500.genValidationNumericDotNegative3());
		res.addSegmentValidations(ER3009PosLbAsrjk500.genValidationNumericDotNegativeLength3());
		res.addSegmentValidations(ER3009PosLbAsrjk500.genValidationTingkatSovabilitas());
		res.addSegmentValidations(ER3009PosLbAsrjk500.genValidationResikoKredit());
		res.addSegmentValidations(ER3009PosLbAsrjk500.genValidationResikoPasar());
		res.addSegmentValidations(ER3009PosLbAsrjk500.genValidationMbbr());
		res.addSegmentValidations(ER3009PosLbAsrjk500.genValidationBatasTingkatSolvabilitas());
		res.addSegmentValidations(ER3009PosLbAsrjk500.genValidationPencapaianSolvabilitas());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3009_LB500.getObject())).confUnique(U));
		fs.add(sf(2, null, "Keterangan",
				sv(C, 1, 500, all).confConditionalRequired(ER3009PosLbAsrjk500.genConditionalExistPos2())));
		fs.add(sf(3, null, "Isian 1",
				sv(C, 1, 16, all).confConditionalRequired(ER3009PosLbAsrjk500.genConditionalExistPos3())));
		fs.add(sf(4, null, "Isian 2",
				sv(C, 1, 16, all).confConditionalRequired(ER3009PosLbAsrjk500.genConditionalExistPos4())));
		fs.add(sf(5, null, "Isian 3",
				sv(C, 1, 16, all).confConditionalRequired(ER3009PosLbAsrjk500.genConditionalExistPos5()))
						.addFieldValidations(ER3009PosLbAsrjk500.genValidationField5a())
						.addFieldValidations(ER3009PosLbAsrjk500.genValidationField5b()));
		fs.add(sf(6, null, "Isian 4",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3009PosLbAsrjk500.genConditionalExistPos6())));
		fs.add(sf(7, null, "Isian 5",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3009PosLbAsrjk500.genConditionalExistPos7())));
		return res;
	}
}
