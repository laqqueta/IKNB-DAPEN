package id.go.ojk.lpei.client.builder.field.lb.metadata;

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
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5000PosLbLpeig0000;

public class Lb0000 extends BaseMetadata {

	public Lb0000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 24, 24);

		res.setRequiredPos(ER5000PosLbLpeig0000.getRequiredPos());
		res.setUniquePos(ER5000PosLbLpeig0000.getUniquePos());

		/*
		 * Length validation
		 */
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationLength5());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationLength8());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationLength10());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationLength12());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationLength15to16());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationLength50());

		/*
		 * Pattern validation
		 */
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationNumeric());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationAlfa());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationAlfanumeric());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationDate());
		//		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationNpwp());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationWebAddress());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationReference1());

		/*
		 * Reference validation
		 */
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationDati2());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationStatusKepemilikanGedung());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genValidationJabatan());

		/*
		 * Form validation
		 */
		res.addSegmentValidations(ER5000PosLbLpeig0000.genRowValidation15());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genRowValidation16());
		res.addSegmentValidations(ER5000PosLbLpeig0000.genRowValidation17());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 12, 12, refTable)
				.confReference(EHeaderMetadataLb.R5000_LB0000.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Informasi", sv(M, 1, 100, all).confRegex(PATTERN_ALL_1)));
		return res;
	}
}
