package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.lb.reference.ER3010PosLbReask501;

public class Lb501 extends BaseMetadata {

	public Lb501(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_501;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 72, 72, ER3010PosLbReask501.genFieldSave(), null, ER3010PosLbReask501.getRequiredPos());
		res.addSegmentValidations(ER3010PosLbReask501.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3010_LB501.getObject())).confUnique(U));
		fs.add(sf(2, null, "Faktor",
				sv(C, 1, 6, all).confConditionalRequired(ER3010PosLbReask501.genConditionalMustEmpty2()))
				.addFieldValidations(ER3010PosLbReask501.genFieldValidation2()));
		fs.add(sf(3, null, "Tradisional - Jumlah AYD", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Tradisional - Jumlah Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3010PosLbReask501.genFieldValidation4()));
		fs.add(sf(5, null, "PAYDI (Guaranteed) - Jumlah AYD",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3010PosLbReask501.genConditionalMustEmpty56())));
		fs.add(sf(6, null, "PAYDI (Guaranteed) - Jumlah Deviasi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3010PosLbReask501.genConditionalMustEmpty56()))
				.addFieldValidations(ER3010PosLbReask501.genFieldValidation6()));
		fs.add(sf(7, null, "Total Deviasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3010PosLbReask501.genFieldValidation7a())
				.addFieldValidations(ER3010PosLbReask501.genFieldValidation7b()));
		return res;
	}
}
