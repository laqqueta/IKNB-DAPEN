package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_ALL_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7000PosLbLpeiu0000;

public class Lb0000 extends BaseMetadata {

	public Lb0000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_0000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 22, 22);

		res.setRequiredPos(ER7000PosLbLpeiu0000.getRequiredPos());
		res.setUniquePos(ER7000PosLbLpeiu0000.getUniquePos());

		/*
		 * Length validation
		 */
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genValidationLength5());
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genValidationLength8());
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genValidationLength10());
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genValidationLength15());
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genValidationLength25());

		/*
		 * Pattern validation
		 */
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genValidationNumeric());
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genValidationDate());
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genValidationWebAddress());
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genValidationReference1());
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genValidationEmailAddress());

		/*
		 * Reference validation
		 */
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genValidationDati2());
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genValidationStatusKepemilikanGedung());
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genValidationJabatan());

		/*
		 * Form validation
		 */
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genRowValidation15());
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genRowValidation16());
		res.addSegmentValidations(ER7000PosLbLpeiu0000.genRowValidation17());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLbUus.R7000_LB0000.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Informasi", sv(M, 1, 100, all).confRegex(PATTERN_ALL_1)));
		return res;
	}
}
