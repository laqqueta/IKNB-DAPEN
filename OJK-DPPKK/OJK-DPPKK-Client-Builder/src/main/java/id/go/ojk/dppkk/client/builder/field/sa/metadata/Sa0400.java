package id.go.ojk.dppkk.client.builder.field.sa.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.FooterField;
import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.dppkk.client.builder.field.EFormSelfAssessment;
import id.go.ojk.dppkk.client.builder.field.sa.reference.EHeaderMetadataSa;
import id.go.ojk.dppkk.client.builder.field.sa.reference.ER4005PosSaDppk0400;

public class Sa0400 extends BaseMetadata {

	public Sa0400(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormSelfAssessment eEnum = EFormSelfAssessment.SA_0400;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 2, 2, ER4005PosSaDppk0400.getRequiredPos(), true);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataSa.R4005_SA0400.getObject())).confUnique(U));
		fs.add(sf(2, null, "Peringkat - Individu", sv(M, 1, 1, numeric))
				.addFieldValidations(ER4005PosSaDppk0400.genValidationPeringkat()));
		fs.add(sf(3, null, "Peringkat - Konsolidasi", sv(O, 1, 1, numeric))
				.addFieldValidations(ER4005PosSaDppk0400.genValidationPeringkat()));
		res.setFooter01(getFooter01Field());
		return res;
	}

	private List<FooterField> getFooter01Field() {
		List<FooterField> res = new ArrayList<>();
		res.add(new FooterField(0, null, "Flag Footer",
				new SimpleValidation(M, 3, 3, alfaNumeric).confConstant("F01")));
		res.add(new FooterField(1, null, "Analisis", new SimpleValidation(O, 0, 4000, all)));
		return res;
	}
}
