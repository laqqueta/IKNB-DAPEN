package id.go.ojk.reass.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
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
import id.go.ojk.reass.client.builder.field.lb.reference.ER3024PosLbReass216;

public class Lb216 extends BaseMetadata {

	public Lb216(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_216;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 52, 52, ER3024PosLbReass216.genFieldSave(), null, ER3024PosLbReass216.getRequiredPos());
		res.addSegmentValidations(ER3024PosLbReass216.genValidationNumericNegative());
		res.addSegmentValidations(ER3024PosLbReass216.genValidationNumericDotNegative());
		res.addSegmentValidations(ER3024PosLbReass216.genValidationJumlahAsetYangDiperkenankan());
		res.addSegmentValidations(ER3024PosLbReass216.genValidationJumlahLiabilitas());
		res.addSegmentValidations(ER3024PosLbReass216.genValidationJumlahAsetYangDiperkenankanDalamRupiah());
		res.addSegmentValidations(ER3024PosLbReass216.genValidationJumlahLiabilitasDalamRupiah());
		res.addSegmentValidations(ER3024PosLbReass216.genValidationSelisihAsetYangDiperkenankanAtasLiabilitas());
		res.addSegmentValidations(ER3024PosLbReass216.genValidationFactorA());
		res.addSegmentValidations(ER3024PosLbReass216.genValidationFactorB());
		res.addSegmentValidations(ER3024PosLbReass216.genValidationJumlahDeviasi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3024_LB216.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Perusahaan-USD", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Dana Perusahaan-JPY", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Dana Perusahaan-AUD", sv(M, 1, 16, all)));
		fs.add(sf(5, null, "Dana Perusahaan-EUR", sv(M, 1, 16, all)));
		fs.add(sf(6, null, "Dana Perusahaan-SGD", sv(M, 1, 16, all)));
		fs.add(sf(7, null, "Dana Perusahaan-GBP", sv(M, 1, 16, all)));
		fs.add(sf(8, null, "Dana Perusahaan-Lainnya", sv(M, 1, 16, all)));
		fs.add(sf(9, null, "Dana Perusahaan-IDR", sv(M, 1, 16, all)));
		fs.add(sf(10, null, "Dana Perusahaan-Jumlah",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbReass216.genConditional10()))
				.addFieldValidations(ER3024PosLbReass216.genValidation10()));
		fs.add(sf(11, null, "Dana Tabarru'-USD", sv(M, 1, 16, all)));
		fs.add(sf(12, null, "Dana Tabarru'-JPY", sv(M, 1, 16, all)));
		fs.add(sf(13, null, "Dana Tabarru'-AUD", sv(M, 1, 16, all)));
		fs.add(sf(14, null, "Dana Tabarru'-EUR", sv(M, 1, 16, all)));
		fs.add(sf(15, null, "Dana Tabarru'-SGD", sv(M, 1, 16, all)));
		fs.add(sf(16, null, "Dana Tabarru'-GBP", sv(M, 1, 16, all)));
		fs.add(sf(17, null, "Dana Tabarru'-Lainnya", sv(M, 1, 16, all)));
		fs.add(sf(18, null, "Dana Tabarru'-IDR", sv(M, 1, 16, all)));
		fs.add(sf(19, null, "Dana Tabarru'-Jumlah", sv(M, 1, 16, all))
				.addFieldValidations(ER3024PosLbReass216.genValidation19()));
		fs.add(sf(20, null, "PAYDI (digaransi)-USD", sv(M, 1, 16, all)));
		fs.add(sf(21, null, "PAYDI (digaransi)-JPY", sv(M, 1, 16, all)));
		fs.add(sf(22, null, "PAYDI (digaransi)-AUD", sv(M, 1, 16, all)));
		fs.add(sf(23, null, "PAYDI (digaransi)-EUR", sv(M, 1, 16, all)));
		fs.add(sf(24, null, "PAYDI (digaransi)-SGD", sv(M, 1, 16, all)));
		fs.add(sf(25, null, "PAYDI (digaransi)-GBP", sv(M, 1, 16, all)));
		fs.add(sf(26, null, "PAYDI (digaransi)-Lainnya", sv(M, 1, 16, all)));
		fs.add(sf(27, null, "PAYDI (digaransi)-IDR", sv(M, 1, 16, all)));
		fs.add(sf(28, null, "PAYDI (digaransi)-Jumlah", sv(M, 1, 16, all))
				.addFieldValidations(ER3024PosLbReass216.genValidation28()));
		return res;
	}
}
