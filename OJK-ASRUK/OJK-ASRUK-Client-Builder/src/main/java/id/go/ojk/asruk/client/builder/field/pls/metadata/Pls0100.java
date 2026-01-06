package id.go.ojk.asruk.client.builder.field.pls.metadata;

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

import id.go.ojk.asruk.client.builder.field.EFormLaporanPolis;
import id.go.ojk.asruk.client.builder.field.pls.reference.EHeaderMetadataPls;
import id.go.ojk.asruk.client.builder.field.pls.reference.ER6001PosPlsAsruk0100;
import id.go.ojk.asruk.client.builder.field.reference.EHeaderMetadataShared;
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
				extension, 2, null, ER6001PosPlsAsruk0100.genFieldSave(), null);
		res.setRequiredPos(ER6001PosPlsAsruk0100.getRequiredPos());
		res.setUniquePos(ER6001PosPlsAsruk0100.getUniquePos());
		res.setSavePosFormDb(ER6001PosPlsAsruk0100.genFieldSaveForm());
		res.addSegmentValidations(ER6001PosPlsAsruk0100.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataPls.R6001_PLS001.getObject())));
		fs.add(sf(2, null, "Nomor Polis", sv(C, 1, 50, all).confRegex(PATTERN_NAME_5)
				.confConditionalRequired(ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorHasValueA())));
		fs.add(sf(3, null, "Nama Pemegang Polis", sv(C, 1, 255, all).confRegex(PATTERN_NAME_6)
				.confConditionalRequired(ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorNotEmptyA())));
		fs.add(sf(4, null, "Jenis Polis",
				sv(C, 3, 3, refTable).confRegex(patternNumeric).confReference(EHeaderMetadataShared.R060.getObject())
						.confConditionalRequired(ER6001PosPlsAsruk0100.genConditionalExistPos())));
		fs.add(sf(5, null, "Tanggal Mulai Polis",
				sv(C, 8, 8, date)
						.confConditionalRequired(ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorHasValueC()))
				.addFieldValidations(ER6001PosPlsAsruk0100.genValidationPeriodeLaporan()));
		fs.add(sf(6, null, "Tanggal Berakhir Polis",
				sv(C, 8, 8, date)
						.confConditionalRequired(ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorHasValueC()))
				.addFieldValidations(ER6001PosPlsAsruk0100.genValidationField06()));
		fs.add(sf(7, null, "NIK/NPWP",
				sv(C, 1, 22, alfaNumeric)
						.confConditionalRequired(ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorNotEmptyA()))
				.addFieldValidations(ER6001PosPlsAsruk0100.genValidationNIK())
				.addFieldValidations(ER6001PosPlsAsruk0100.genValidationNIK2()));
		fs.add(sf(8, null, "Tanggal Lahir Pemegang Polis", sv(C, 8, 8, date)
				.confConditionalRequired(ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorHasValueB())));
		fs.add(sf(9, null, "Jenis Kelamin",
				sv(C, 1, 1, refTable).confRegex(patternAlfa).confReference(EHeaderMetadataShared.R061.getObject())
						.confConditionalRequired(
								ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorHasValueB())));
		fs.add(sf(10, null, "Lokasi Pemegang Polis",
				sv(C, 4, 4, refTable).confRegex(patternNumeric).confReference(EHeaderMetadataShared.R062.getObject())
						.confConditionalRequired(
								ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorNotEmptyA())));
		fs.add(sf(11, null, "Lini Usaha",
				sv(C, 3, 4, refTable).confRegex(patternNumeric).confReference(EHeaderMetadataShared.R064.getObject())
						.confConditionalRequired(
								ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorNotEmptyA())));
		fs.add(sf(12, null, "Cara bayar premi",
				sv(C, 3, 3, refTable).confRegex(patternNumeric).confReference(EHeaderMetadataShared.R065.getObject())
						.confConditionalRequired(
								ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorNotEmptyA())));
		fs.add(sf(13, null, "Jumlah Premi", sv(C, 1, 20, numericNegatif)
				.confConditionalRequired(ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(14, null, "Uang Pertanggungan",
				sv(C, 1, 20, numeric)
						.confConditionalRequired(ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(15, null, "Cadangan Premi", sv(C, 1, 20, numeric)
				.confConditionalRequired(ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(16, null, "CAPYBMP", sv(C, 1, 20, numeric)
				.confConditionalRequired(ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(17, null, "Jumlah tertanggung",
				sv(C, 1, 12, numeric)
						.confConditionalRequired(ER6001PosPlsAsruk0100.genConditionalExistPosAndComparatorHasValueD()))
				.addFieldValidations(ER6001PosPlsAsruk0100.genValidationField17A())
				.addFieldValidations(ER6001PosPlsAsruk0100.genValidationField17B()));
		return res;
	}
}
