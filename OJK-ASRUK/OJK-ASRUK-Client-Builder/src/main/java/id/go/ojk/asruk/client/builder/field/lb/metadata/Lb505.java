package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfa;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3014PosLbAsruk505;
import id.go.ojk.asruk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.conf.client.field.reference.ER1029MataUang;

public class Lb505 extends BaseMetadata {

	public Lb505(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_505;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 50, 50, ER3014PosLbAsruk505.genFieldSave(), null,
				ER3014PosLbAsruk505.getRequiredPos());
		res.addSegmentValidations(ER3014PosLbAsruk505.genValidationNumericNegatif());
		res.addSegmentValidations(ER3014PosLbAsruk505.genValidationNumericDotNegatif());
		res.addSegmentValidations(ER3014PosLbAsruk505.genValidationJumlahAsetYangDiperkenankan());
		res.addSegmentValidations(ER3014PosLbAsruk505.genValidationJumlahLiabilitas());
		res.addSegmentValidations(ER3014PosLbAsruk505.genValidationJumlahAsetYangDiperkenankanDalamRupiah());
		res.addSegmentValidations(ER3014PosLbAsruk505.genValidationJumlahLiabilitasDalamRupiah());
		res.addSegmentValidations(ER3014PosLbAsruk505.genValidationSelisihAsetYangDiperkenankanAtasLiabilitas());
		res.addSegmentValidations(ER3014PosLbAsruk505.genValidationFaktorSeMmbr2017());
		res.addSegmentValidations(ER3014PosLbAsruk505.genValidationDeviationFaktorSeMmbr2017());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3014_LB505.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kode Mata Uang", sv(M, 1, 3, alfa).confConstant(ER1029MataUang.R_USD.getKey())));
		fs.add(sf(3, null, "USD-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "USD-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(5, null, "Kode Mata Uang", sv(M, 1, 3, alfa).confConstant(ER1029MataUang.R_JPY.getKey())));
		fs.add(sf(6, null, "JPY-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(7, null, "JPY-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(8, null, "Kode Mata Uang", sv(M, 1, 3, alfa).confConstant(ER1029MataUang.R_EUR.getKey())));
		fs.add(sf(9, null, "EUR-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(10, null, "EUR-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(11, null, "Kode Mata Uang", sv(M, 1, 3, alfa).confConstant(ER1029MataUang.R_GBP.getKey())));
		fs.add(sf(12, null, "GBP-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(13, null, "GBP-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(14, null, "Kode Mata Uang", sv(M, 1, 3, alfa).confConstant(ER1029MataUang.R_SGD.getKey())));
		fs.add(sf(15, null, "SGD-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(16, null, "SGD-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(17, null, "Kode Mata Uang", sv(M, 1, 3, alfa).confConstant(ER1029MataUang.R_AUD.getKey())));
		fs.add(sf(18, null, "AUD-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(19, null, "AUD-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(20, null, "Kode Mata Uang", sv(M, 1, 3, alfa).confConstant(ER1029MataUang.R_CNY.getKey())));
		fs.add(sf(21, null, "CNY-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(22, null, "CNY-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(23, null, "Kode Mata Uang", sv(M, 1, 3, alfa).confConstant(ER1029MataUang.R_HKD.getKey())));
		fs.add(sf(24, null, "HKD-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(25, null, "HKD-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(26, null, "Kode Mata Uang", sv(M, 1, 3, alfa).confConstant(ER1029MataUang.R_MYR.getKey())));
		fs.add(sf(27, null, "MYR-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(28, null, "MYR-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(29, null, "Kode Mata Uang",
				sv(M, 1, 3, refTable).confReference(EHeaderMetadataShared.R029.getObject())).addFieldValidations(
						ER3014PosLbAsruk505.genFieldValidationUniqueToOther("2|5|8|11|14|17|20|23|26")));
		fs.add(sf(30, null, "Lainnya 1-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(31, null, "Lainnya 1-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(32, null, "Kode Mata Uang",
				sv(M, 1, 3, refTable).confReference(EHeaderMetadataShared.R029.getObject())).addFieldValidations(
						ER3014PosLbAsruk505.genFieldValidationUniqueToOther("2|5|8|11|14|17|20|23|26|29")));
		fs.add(sf(33, null, "Lainnya 2-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(34, null, "Lainnya 2-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(35, null, "Kode Mata Uang",
				sv(M, 1, 3, refTable).confReference(EHeaderMetadataShared.R029.getObject())).addFieldValidations(
						ER3014PosLbAsruk505.genFieldValidationUniqueToOther("2|5|8|11|14|17|20|23|26|29|32")));
		fs.add(sf(36, null, "Lainnya 3-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(37, null, "Lainnya 3-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(38, null, "Kode Mata Uang",
				sv(M, 1, 3, refTable).confReference(EHeaderMetadataShared.R029.getObject())).addFieldValidations(
						ER3014PosLbAsruk505.genFieldValidationUniqueToOther("2|5|8|11|14|17|20|23|26|29|32|35")));
		fs.add(sf(39, null, "Lainnya 4-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(40, null, "Lainnya 4-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(41, null, "Kode Mata Uang",
				sv(M, 1, 3, refTable).confReference(EHeaderMetadataShared.R029.getObject())).addFieldValidations(
						ER3014PosLbAsruk505.genFieldValidationUniqueToOther("2|5|8|11|14|17|20|23|26|29|32|35|38")));
		fs.add(sf(42, null, "Lainnya 5-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(43, null, "Lainnya 5-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(44, null, "Kode Mata Uang",
				sv(M, 1, 3, refTable).confReference(EHeaderMetadataShared.R029.getObject())).addFieldValidations(
						ER3014PosLbAsruk505.genFieldValidationUniqueToOther("2|5|8|11|14|17|20|23|26|29|32|35|38|41")));
		fs.add(sf(45, null, "Lainnya 6-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(46, null, "Lainnya 6-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(47, null, "Kode Mata Uang",
				sv(M, 1, 3, refTable).confReference(EHeaderMetadataShared.R029.getObject()))
						.addFieldValidations(ER3014PosLbAsruk505
								.genFieldValidationUniqueToOther("2|5|8|11|14|17|20|23|26|29|32|35|38|41|44")));
		fs.add(sf(48, null, "Lainnya 7-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(49, null, "Lainnya 7-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(50, null, "Kode Mata Uang",
				sv(M, 1, 3, refTable).confReference(EHeaderMetadataShared.R029.getObject()))
						.addFieldValidations(ER3014PosLbAsruk505
								.genFieldValidationUniqueToOther("2|5|8|11|14|17|20|23|26|29|32|35|38|41|44|47")));
		fs.add(sf(51, null, "Lainnya 8-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(52, null, "Lainnya 8-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(53, null, "Kode Mata Uang",
				sv(M, 1, 3, refTable).confReference(EHeaderMetadataShared.R029.getObject()))
						.addFieldValidations(ER3014PosLbAsruk505
								.genFieldValidationUniqueToOther("2|5|8|11|14|17|20|23|26|29|32|35|38|41|44|47|50")));
		fs.add(sf(54, null, "Lainnya 9-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(55, null, "Lainnya 9-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(56, null, "Kode Mata Uang",
				sv(M, 1, 3, refTable).confReference(EHeaderMetadataShared.R029.getObject()))
						.addFieldValidations(ER3014PosLbAsruk505.genFieldValidationUniqueToOther(
								"2|5|8|11|14|17|20|23|26|29|32|35|38|41|44|47|50|53")));
		fs.add(sf(57, null, "Lainnya 10-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(58, null, "Lainnya 10-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(59, null, "Kode Mata Uang", sv(M, 1, 3, alfa).confConstant(ER1029MataUang.R_IDR.getKey())));
		fs.add(sf(60, null, "IDR-Tradisional", sv(M, 1, 16, all)));
		fs.add(sf(61, null, "IDR-PAYDI", sv(M, 1, 16, all)));
		fs.add(sf(62, null, "Jumlah-Tradisional",
				sv(C, 1, 16, all).confConditionalRequired(ER3014PosLbAsruk505.genConditionMustEmpty62_63()))
						.addFieldValidations(ER3014PosLbAsruk505.genFieldValidation62()));
		fs.add(sf(63, null, "Jumlah-PAYDI",
				sv(C, 1, 16, all).confConditionalRequired(ER3014PosLbAsruk505.genConditionMustEmpty62_63()))
						.addFieldValidations(ER3014PosLbAsruk505.genFieldValidation63()));
		return res;
	}
}
