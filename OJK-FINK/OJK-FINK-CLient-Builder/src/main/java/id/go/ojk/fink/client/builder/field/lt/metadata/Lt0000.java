package id.go.ojk.fink.client.builder.field.lt.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_ALL_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
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
import id.go.ojk.fink.client.builder.field.EFormLaporanTahunan;
import id.go.ojk.fink.client.builder.field.lt.reference.EHeaderMetadataLt;
import id.go.ojk.fink.client.builder.field.lt.reference.ER6000PosLtFink0000;

public class Lt0000 extends BaseMetadata {

	public Lt0000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanTahunan eEnum = EFormLaporanTahunan.LT_0000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 28, 28, ER6000PosLtFink0000.genFieldSave(), null, ER6000PosLtFink0000.getRequiredPos());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationAlfaNumeric());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationAlfaNumericSpace());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationDate());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationDecimal());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationEmail());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationLen1());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationLen100());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationLen150());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationLen16());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationLen200());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationLen25());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationLen4());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationLen6());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationLen75());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationLen8());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationLjkAddress());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationLjkName());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationName2());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationName4());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationNumeric());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationPhone());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationReferenceAvailable());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationReferenceDati1());
		res.addSegmentValidations(ER6000PosLtFink0000.genValidationReferenceDati2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLt.R6000_LT0000.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Informasi Umum", sv(C, 1, 1000, all).confRegex(PATTERN_ALL_1)
				.confConditionalRequired(ER6000PosLtFink0000.genConditional())));
		return res;
	}
}
