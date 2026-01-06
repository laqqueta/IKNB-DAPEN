package id.go.ojk.asrus.client.builder.field.pls.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME_5;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME_6;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfa;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormLaporanPolis;
import id.go.ojk.asrus.client.builder.field.pls.reference.EHeaderMetadataPls;
import id.go.ojk.asrus.client.builder.field.pls.reference.ER6001PosPlsAsrus0100;
import id.go.ojk.asrus.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Pls0100 extends BaseMetadata {

	public Pls0100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanPolis eEnum = EFormLaporanPolis.PLS_0100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 2, null, ER6001PosPlsAsrus0100.genFieldSave(), null);
		res.setRequiredPos(ER6001PosPlsAsrus0100.getRequiredPos());
		res.setUniquePos(ER6001PosPlsAsrus0100.getUniquePos());
		res.setSavePosFormDb(ER6001PosPlsAsrus0100.genFieldSaveForm());
		res.addSegmentValidations(ER6001PosPlsAsrus0100.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataPls.R6001_PLS001.getObject())));
		fs.add(sf(2, null, "Nomor Polis", sv(C, 1, 50, all).confRegex(PATTERN_NAME_5)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorHasValueA())));
		fs.add(sf(3, null, "Nama Pemegang Polis", sv(C, 1, 255, all).confRegex(PATTERN_NAME_6)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyA())));
		fs.add(sf(4, null, "Jenis Polis",
				sv(C, 3, 3, refTable).confRegex(patternNumeric).confReference(EHeaderMetadataShared.R028.getObject())
						.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPos())));
		fs.add(sf(5, null, "Tanggal Mulai Polis",
				sv(C, 8, 8, date)
						.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorHasValueC()))
				.addFieldValidations(ER6001PosPlsAsrus0100.genValidationPeriodeLaporan()));
		fs.add(sf(6, null, "Tanggal Berakhir Polis",
				sv(C, 8, 8, date)
						.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorHasValueC()))
				.addFieldValidations(ER6001PosPlsAsrus0100.genValidationField06()));
		fs.add(sf(7, null, "NIK/NPWP",
				sv(C, 1, 22, alfaNumeric)
						.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyA()))
				.addFieldValidations(ER6001PosPlsAsrus0100.genValidationNIK())
				.addFieldValidations(ER6001PosPlsAsrus0100.genValidationNIK2()));
		fs.add(sf(8, null, "Tanggal Lahir Pemegang Polis", sv(C, 8, 8, date)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorHasValueB())));
		fs.add(sf(9, null, "Jenis Kelamin",
				sv(C, 1, 1, refTable).confRegex(patternAlfa).confReference(EHeaderMetadataShared.R029.getObject())
						.confConditionalRequired(
								ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorHasValueB())));
		fs.add(sf(10, null, "Lokasi Pemegang Polis",
				sv(C, 4, 4, refTable).confRegex(patternNumeric).confReference(EHeaderMetadataShared.R030.getObject())
						.confConditionalRequired(
								ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyA())));
		fs.add(sf(11, null, "Lini Usaha",
				sv(C, 3, 4, refTable).confRegex(patternNumeric).confReference(EHeaderMetadataShared.R032.getObject())
						.confConditionalRequired(
								ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyA())));
		fs.add(sf(12, null, "Cara bayar premi",
				sv(C, 3, 3, refTable).confRegex(patternNumeric).confReference(EHeaderMetadataShared.R033.getObject())
						.confConditionalRequired(
								ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyA())));
		fs.add(sf(13, null, "Jumlah Kontribusi - Ujrah", sv(C, 1, 20, numericNegatif)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(14, null, "Jumlah Kontribusi - Dana Tabarru'", sv(C, 1, 20, numericNegatif)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(15, null, "Jumlah Kontribusi - Dana Tanahud", sv(C, 1, 20, numericNegatif)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(16, null, "Jumlah Kontribusi - DIP", sv(C, 1, 20, numericNegatif)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(17, null, "Uang Pertanggungan - Dana Tabarru'", sv(C, 1, 20, numeric)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(18, null, "Uang Pertanggungan - Dana Tanahud", sv(C, 1, 20, numeric)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(19, null, "Penyisihan Kontribusi - Ujrah", sv(C, 1, 20, numeric)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(20, null, "Penyisihan Kontribusi - Dana Tabarru'", sv(C, 1, 20, numeric)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(21, null, "Penyisihan Kontribusi - Dana Tanahud", sv(C, 1, 20, numeric)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(22, null, "Penyisihan Kontribusi - DIP", sv(C, 1, 20, numeric)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(23, null, "PAKTYBMP - Ujrah", sv(C, 1, 20, numeric)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(24, null, "PAKTYBMP - Dana Tabarru'", sv(C, 1, 20, numeric)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(25, null, "PAKTYBMP - Dana Tanahud", sv(C, 1, 20, numeric)
				.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(26, null, "Jumlah tertanggung",
				sv(C, 1, 12, numeric)
						.confConditionalRequired(ER6001PosPlsAsrus0100.genConditionalExistPosAndComparatorHasValueD()))
				.addFieldValidations(ER6001PosPlsAsrus0100.genValidationField26A())
				.addFieldValidations(ER6001PosPlsAsrus0100.genValidationField26B()));
		return res;
	}
}
