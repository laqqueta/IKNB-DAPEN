package id.go.ojk.fink.client.builder.field.lb.metadata;

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
import id.go.ojk.fink.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.fink.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.fink.client.builder.field.lb.reference.ER3000PosLbFink0000;

public class Lb0000 extends BaseMetadata {

	public Lb0000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 25, 25, ER3000PosLbFink0000.genFieldSave(), null, ER3000PosLbFink0000.getRequiredPos());
		res.addSegmentValidations(ER3000PosLbFink0000.genRowValidation20A());
		res.addSegmentValidations(ER3000PosLbFink0000.genRowValidation20B());
		res.addSegmentValidations(ER3000PosLbFink0000.genRowValidation21A());
		res.addSegmentValidations(ER3000PosLbFink0000.genRowValidation21B());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationAlfaNumeric());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationAlfaNumericSpace());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationDate());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationDecimal());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationEmail());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationLen1());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationLen100());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationLen150());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationLen16());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationLen200());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationLen25());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationLen4());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationLen6());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationLen75());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationLen8());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationLjkAddress());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationLjkName());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationName2());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationName4());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationNumeric());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationPhone());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationReferenceAvailable());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationReferenceDati1());
		res.addSegmentValidations(ER3000PosLbFink0000.genValidationReferenceDati2());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R3000_LB0000.getObject()).confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Informasi Umum", sv(C, 1, 1000, all).confRegex(PATTERN_ALL_1)
				.confConditionalRequired(ER3000PosLbFink0000.genConditional())));
		return res;
	}
}
