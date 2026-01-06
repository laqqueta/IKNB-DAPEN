package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3013PosLbAsrjk504;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb504 extends BaseMetadata {

	public Lb504(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_504;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 24, 24, ER3013PosLbAsrjk504.genFieldSave(), null,
				ER3013PosLbAsrjk504.getRequiredPos());
		res.addSegmentValidations(ER3013PosLbAsrjk504.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3013_LB504.getObject())).confUnique(U));
		fs.add(sf(2, null, "Faktor",
				sv(C, 1, 6, all).confConditionalRequired(ER3013PosLbAsrjk504.genConditionMustEmpty2()))
						.addFieldValidations(ER3013PosLbAsrjk504.genFieldValidation2()));
		fs.add(sf(3, null, "Tradisional - Jumlah AYD", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Tradisional - Jumlah Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3013PosLbAsrjk504.genFieldValidation4()));
		fs.add(sf(5, null, "PAYDI (Guaranteed) - Jumlah AYD",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3013PosLbAsrjk504.genConditionMustEmpty56())));
		fs.add(sf(6, null, "PAYDI (Guaranteed) - Jumlah Deviasi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3013PosLbAsrjk504.genConditionMustEmpty56()))
						.addFieldValidations(ER3013PosLbAsrjk504.genFieldValidation6()));
		fs.add(sf(7, null, "Total Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3013PosLbAsrjk504.genFieldValidation7a())
				.addFieldValidations(ER3013PosLbAsrjk504.genFieldValidation7b()));
		return res;
	}
}
