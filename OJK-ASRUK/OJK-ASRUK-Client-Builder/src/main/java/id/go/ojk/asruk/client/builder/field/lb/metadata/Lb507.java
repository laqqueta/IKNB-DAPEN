package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3016PosLbAsruk507;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb507 extends BaseMetadata {

	public Lb507(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_507;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 22, 22, ER3016PosLbAsruk507.genFieldSave(), null,
				ER3016PosLbAsruk507.getRequiredPos());
		res.addSegmentValidations(ER3016PosLbAsruk507.genValidationJumlah());
		res.addSegmentValidations(ER3016PosLbAsruk507.genValidationTotalCadanganPremi());
		res.addSegmentValidations(ER3016PosLbAsruk507.genValidationTotalCAPYBMP());
		res.addSegmentValidations(ER3016PosLbAsruk507.genValidationTotalCadanganKlaim());
		res.addSegmentValidations(ER3016PosLbAsruk507.genValidationTotalCadanganAtasRisikoBencana());
		res.addSegmentValidations(ER3016PosLbAsruk507.genValidationTotalDeviasiUntukRisikoAsuransi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3016_LB507.getObject())).confUnique(U));
		fs.add(sf(2, null, "Cadangan Premi-CP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Cadangan Premi-CP*",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty())));
		fs.add(sf(4, null, "Cadangan Premi-Jumlah Deviasi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty()))
						.addFieldValidations(ER3016PosLbAsruk507.genFieldValidation4()));
		fs.add(sf(5, null, "CAPYBMP -CAPYBMP",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty())));
		fs.add(sf(6, null, "CAPYBMP -AR",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty())));
		fs.add(sf(7, null, "CAPYBMP -fcp",
				sv(C, 1, 6, numericDotNegatif)
						.confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty7_11_15()))
								.addFieldValidations(ER3016PosLbAsruk507.genFieldValidation7()));
		fs.add(sf(8, null, "CAPYBMP -Jumlah Deviasi CAPYBMP",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty()))
						.addFieldValidations(ER3016PosLbAsruk507.genFieldValidation8()));
		fs.add(sf(9, null, "Cadangan Klaim -CK",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty())));
		fs.add(sf(10, null, "Cadangan Klaim -AR",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty())));
		fs.add(sf(11, null, "Cadangan Klaim -fck",
				sv(C, 1, 16, numericDotNegatif)
						.confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty7_11_15()))
								.addFieldValidations(ER3016PosLbAsruk507.genFieldValidation11()));
		fs.add(sf(12, null, "Cadangan Klaim -Jumlah Deviasi CK",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty()))
						.addFieldValidations(ER3016PosLbAsruk507.genFieldValidation12()));
		fs.add(sf(13, null, "Cadangan atas Risiko Bencana (Catastrophic)-CARB (Gross)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty())));
		fs.add(sf(14, null, "Cadangan atas Risiko Bencana (Catastrophic)-AR",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty())));
		fs.add(sf(15, null, "Cadangan atas Risiko Bencana (Catastrophic)-fcb",
				sv(C, 1, 16, numericDotNegatif)
						.confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty7_11_15()))
								.addFieldValidations(ER3016PosLbAsruk507.genFieldValidation15()));
		fs.add(sf(16, null, "Cadangan atas Risiko Bencana (Catastrophic)-Jumlah Deviasi Cadangan Atas Risiko Bencana",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3016PosLbAsruk507.genConditionalMustEmpty()))
						.addFieldValidations(ER3016PosLbAsruk507.genFieldValidation16()));
		return res;
	}
}
