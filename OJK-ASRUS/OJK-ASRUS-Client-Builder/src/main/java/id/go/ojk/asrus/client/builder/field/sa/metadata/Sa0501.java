package id.go.ojk.asrus.client.builder.field.sa.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormSelfAssessment;
import id.go.ojk.asrus.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.asrus.client.builder.field.sa.reference.ER4014PosSaAsrus0501;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Sa0501 extends BaseMetadata {

	public Sa0501(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0501;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 5, 5, null, null, ER4014PosSaAsrus0501.getRequiredPos());
		res.addSegmentValidations(ER4014PosSaAsrus0501.genValidationPermodalan2());
		res.addSegmentValidations(ER4014PosSaAsrus0501.genValidationPermodalan3());
		res.addSegmentValidations(ER4014PosSaAsrus0501.genValidationPermodalan4());
		res.addSegmentValidations(ER4014PosSaAsrus0501.genValidationProfilRisiko2());
		res.addSegmentValidations(ER4014PosSaAsrus0501.genValidationProfilRisiko3());
		res.addSegmentValidations(ER4014PosSaAsrus0501.genValidationProfilRisiko4());
		res.addSegmentValidations(ER4014PosSaAsrus0501.genValidationRentabilitas2());
		res.addSegmentValidations(ER4014PosSaAsrus0501.genValidationRentabilitas3());
		res.addSegmentValidations(ER4014PosSaAsrus0501.genValidationRentabilitas4());
		res.addSegmentValidations(ER4014PosSaAsrus0501.genValidationTataKelolaPerusahaanYangBaikBagiPerusahaan2());
		res.addSegmentValidations(ER4014PosSaAsrus0501.genValidationTataKelolaPerusahaanYangBaikBagiPerusahaan3());
		res.addSegmentValidations(ER4014PosSaAsrus0501.genValidationTataKelolaPerusahaanYangBaikBagiPerusahaan4());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataSa.R4014_SA0501.getObject())).confUnique(U));
		fs.add(sf(2, null, "Peringkat - Individu", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4014PosSaAsrus0501.genValidationPeringkat2()));
		fs.add(sf(3, null, "Peringkat - Konsolidasi", sv(O, 0, 1, numeric))
				.addFieldValidations(ER4014PosSaAsrus0501.genValidationPeringkat3()));
		fs.add(sf(4, null, "Analisis", sv(M, 1, 5000, all)));
		return res;
	}
}
