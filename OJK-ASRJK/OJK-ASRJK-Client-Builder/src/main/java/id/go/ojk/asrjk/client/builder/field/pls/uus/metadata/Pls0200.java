package id.go.ojk.asrjk.client.builder.field.pls.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME_5;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME_6;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanPolisUus;
import id.go.ojk.asrjk.client.builder.field.pls.uus.reference.EHeaderMetadataPlsUus;
import id.go.ojk.asrjk.client.builder.field.pls.uus.reference.ER6102PosPlsAsrju0200;
import id.go.ojk.asrjk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Pls0200 extends BaseMetadata {

	public Pls0200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanPolisUus eEnum = EFormLaporanPolisUus.PLS_0200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null, ER6102PosPlsAsrju0200.genFieldSave(), null, ER6102PosPlsAsrju0200.getRequiredPos());
		res.setSavePosFormDb(ER6102PosPlsAsrju0200.genFieldSaveForm());
		res.addSegmentValidations(ER6102PosPlsAsrju0200.genValidation2());
		res.addSegmentValidations(ER6102PosPlsAsrju0200.genValidation3());
		res.addSegmentValidations(ER6102PosPlsAsrju0200.genValidation4());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataPlsUus.R6102_PLS002.getObject())));
		fs.add(sf(2, null, "Status Pertanggungan",
				sv(C, 3, 3, refTable).confRegex(patternNumeric).confReference(EHeaderMetadataShared.R053.getObject())
						.confConditionalRequired(ER6102PosPlsAsrju0200.genConditionalExistPos())));
		fs.add(sf(3, null, "Nomor Polis", sv(C, 1, 50, all).confRegex(PATTERN_NAME_5)
				.confConditionalRequired(ER6102PosPlsAsrju0200.genConditionalExistPosAndComparatorNotEmptyA())));
		fs.add(sf(4, null, "Nama Pemegang Polis", sv(C, 1, 255, all).confRegex(PATTERN_NAME_6)
				.confConditionalRequired(ER6102PosPlsAsrju0200.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(5, null, "NIK/NPWP",
				sv(C, 1, 22, alfaNumeric)
						.confConditionalRequired(ER6102PosPlsAsrju0200.genConditionalExistPosAndComparatorNotEmptyB()))
				.addFieldValidations(ER6102PosPlsAsrju0200.genValidationNIK())
				.addFieldValidations(ER6102PosPlsAsrju0200.genValidationNIK3()));
		fs.add(sf(6, null, "Lini Usaha",
				sv(C, 4, 4, refTable).confRegex(patternNumeric).confReference(EHeaderMetadataShared.R050.getObject())
						.confConditionalRequired(
								ER6102PosPlsAsrju0200.genConditionalExistPosAndComparatorNotEmptyB())));
		fs.add(sf(7, null, "Jenis Klaim",
				sv(C, 3, 3, refTable).confRegex(patternNumeric).confReference(EHeaderMetadataShared.R054.getObject())
						.confConditionalRequired(
								ER6102PosPlsAsrju0200.genConditionalExistPosAndComparatorHasValueB())));
		fs.add(sf(8, null, "Nilai Klaim Disetujui - Dana Tabarru'",
				sv(C, 1, 20, numericNegatif)
						.confConditionalRequired(ER6102PosPlsAsrju0200.genConditionalExistPosAndComparatorHasValueA())));
		fs.add(sf(9, null, "Nilai Klaim Disetujui - Dana Tanahud", sv(C, 1, 20, numericNegatif)
				.confConditionalRequired(ER6102PosPlsAsrju0200.genConditionalExistPosAndComparatorHasValueA())));
		fs.add(sf(10, null, "Nilai Klaim Disetujui - DIP'", sv(C, 1, 20, numericNegatif)
				.confConditionalRequired(ER6102PosPlsAsrju0200.genConditionalExistPosAndComparatorHasValueA())));
		return res;
	}
}
