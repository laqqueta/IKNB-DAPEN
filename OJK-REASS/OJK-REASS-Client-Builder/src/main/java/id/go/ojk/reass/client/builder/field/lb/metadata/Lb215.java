package id.go.ojk.reass.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
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
import id.go.ojk.reass.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reass.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reass.client.builder.field.lb.reference.ER3023PosLbReass215;

public class Lb215 extends BaseMetadata {

	public Lb215(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_215;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 34, 34, ER3023PosLbReass215.genFieldSave(), null, ER3023PosLbReass215.getRequiredPos());
		res.addSegmentValidations(ER3023PosLbReass215.genValidationInvestasi());
		res.addSegmentValidations(ER3023PosLbReass215.genValidationSahamSyariah());
		res.addSegmentValidations(ER3023PosLbReass215.genValidationReksaDanaSyariah());
		res.addSegmentValidations(ER3023PosLbReass215.genValidationReksaDanaSyariahCampuran());
		res.addSegmentValidations(ER3023PosLbReass215.genValidationEfekBeragunAsetSyariah());
		res.addSegmentValidations(ER3023PosLbReass215.genValidationPenyertaanLangsung());
		res.addSegmentValidations(ER3023PosLbReass215.genValidationPropertyInvestasi());
		res.addSegmentValidations(ER3023PosLbReass215.genValidationBukanInvestasi());
		res.addSegmentValidations(ER3023PosLbReass215.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3023_LB215.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Perusahaan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Jumlah AYD Dana Tabarru' dan Dana Tanahud", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "PAYDI (digaransi)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Faktor",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3023PosLbReass215.genConditional5()))
				.addFieldValidations(ER3023PosLbReass215.genValidation5()));
		fs.add(sf(6, null, "Dana Perusahaan", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3023PosLbReass215.genValidation6()));
		fs.add(sf(7, null, "Jumlah Deviasi Dana Tabarru'", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3023PosLbReass215.genValidation7()));
		fs.add(sf(8, null, "PAYDI (digaransi)", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3023PosLbReass215.genValidation8()));
		return res;
	}
}
