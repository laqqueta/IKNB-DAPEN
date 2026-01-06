package id.go.ojk.reass.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reass.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reass.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reass.client.builder.field.lb.reference.ER3021PosLbReass213;

public class Lb213 extends BaseMetadata {

	public Lb213(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_213;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 55, 55, ER3021PosLbReass213.genFieldSave(), null, ER3021PosLbReass213.getRequiredPos());
		res.addSegmentValidations(ER3021PosLbReass213.genValidationAset());
		res.addSegmentValidations(ER3021PosLbReass213.genValidationInvestasi());
		res.addSegmentValidations(ER3021PosLbReass213.genValidationBukanInvestasi());
		res.addSegmentValidations(ER3021PosLbReass213.genValidationLiabilitas());
		res.addSegmentValidations(ER3021PosLbReass213.genValidationUtang());
		res.addSegmentValidations(ER3021PosLbReass213.genValidationPenyisihanTeknis());
		res.addSegmentValidations(ER3021PosLbReass213.genValidationSelisihLiabilitasDanAset());
		res.addSegmentValidations(ER3021PosLbReass213.genValidationDeviasi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3021_LB213.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Perusahaan Sampai dengan 1  tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Dana Perusahaan Lebih dari 1 tahun sampai dengan 3 tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Dana Perusahaan Lebih dari 3 tahun sampai dengan 5 tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Dana Perusahaan Lebih dari 5 tahun sampai dengan 10 tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Dana Perusahaan Lebih dari 10 tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Jumlah Dana Perusahaan", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3021PosLbReass213.genValidation7()));
		fs.add(sf(8, null, "Dana Tabarru' Sampai dengan 1  tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Dana Tabarru' Lebih dari 1 tahun sampai dengan 3 tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Dana Tabarru' Lebih dari 3 tahun sampai dengan 5 tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Dana Tabarru' Lebih dari 5 tahun sampai dengan 10 tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(12, null, "Dana Tabarru' Lebih dari 10 tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "Jumlah Dana Tabarru'", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3021PosLbReass213.genValidation13()));
		fs.add(sf(14, null, "PAYDI (digaransi) Sampai dengan 1  tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(15, null, "PAYDI (digaransi) Lebih dari 1 tahun sampai dengan 3 tahun",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(16, null, "PAYDI (digaransi) Lebih dari 3 tahun sampai dengan 5 tahun",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(17, null, "PAYDI (digaransi) Lebih dari 5 tahun sampai dengan 10 tahun",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(18, null, "PAYDI (digaransi) Lebih dari 10 tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(19, null, "Jumlah PAYDI (digaransi)", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3021PosLbReass213.genValidation19()));
		return res;
	}
}
