package id.go.ojk.pnjk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3108PosLbPnju2100A2;
import id.go.ojk.pnjk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2100A2 extends BaseMetadata {

	public Lb2100A2(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2100A2;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, ER3108PosLbPnju2100A2.genFieldSave(), ER3108PosLbPnju2100A2.genFieldSaveForm(), ER3108PosLbPnju2100A2.getRequiredPos());
		res.addSegmentValidations(ER3108PosLbPnju2100A2.genValidation1());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3108_LB2100A2.getObject())));
		fs.add(sf(2, null, "Sandi Counterparty",
				sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
						.confReference(EHeaderMetadataShared.R051.getObject())
						.confConditionalRequired(ER3108PosLbPnju2100A2.genConditionA()))
				.addFieldValidations(ER3108PosLbPnju2100A2.genFieldValidation02()));
		fs.add(sf(3, null, "Penerbit-Sandi Bank",
				sv(C, 1, 100, refTable).confRegex(patternAlfaNumeric)
						.confReference(EHeaderMetadataShared.R049.getObject())
						.confConditionalRequired(ER3108PosLbPnju2100A2.genConditionA())));
		fs.add(sf(4, null, "Penerbit-Cabang Bank",
				sv(C, 1, 100, all).confConditionalRequired(ER3108PosLbPnju2100A2.genConditionA())));
		fs.add(sf(5, null, "Nomor Bilyet",
				sv(C, 1, 35, all).confConditionalRequired(ER3108PosLbPnju2100A2.genConditionA())));
		fs.add(sf(6, null, "Nilai", sv(M, 1, 16, numeric)));
		fs.add(sf(7, null, "Tingkat Suku Bunga",
				sv(C, 3, 6, numericDot).confConditionalRequired(ER3108PosLbPnju2100A2.genConditionA()))
				.addFieldValidations(ER3108PosLbPnju2100A2.genFieldValidationGreater("0.00")));
		fs.add(sf(8, null, "Jangka Waktu-Mulai",
				sv(C, 8, 8, date).confConditionalRequired(ER3108PosLbPnju2100A2.genConditionA()))
				.addFieldValidations(ER3108PosLbPnju2100A2.genFieldValidation08()));
		fs.add(sf(9, null, "Jangka Waktu-Jatuh Tempo",
				sv(C, 8, 8, date).confConditionalRequired(ER3108PosLbPnju2100A2.genConditionA()))
				.addFieldValidations(ER3108PosLbPnju2100A2.genFieldValidation09()));
		fs.add(sf(10, null, "Jangka Waktu-Tenor",
				sv(C, 1, 8, numeric).confConditionalRequired(ER3108PosLbPnju2100A2.genConditionA()))
				.addFieldValidations(ER3108PosLbPnju2100A2.genFieldValidationGreater("1")));
		fs.add(sf(11, null, "Keterangan Automatic Roll Over (ARO)",
				sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
						.confReference(EHeaderMetadataShared.R047.getObject())
						.confConditionalRequired(ER3108PosLbPnju2100A2.genConditionA())));
		fs.add(sf(12, null, "CKPN-Individual",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3108PosLbPnju2100A2.genConditionB("13"))));
		fs.add(sf(13, null, "CKPN-Kolektif",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3108PosLbPnju2100A2.genConditionB("12"))));
		fs.add(sf(14, null, "Jumlah Neto", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3108PosLbPnju2100A2.genFieldValidation14()));
		return res;
	}
}
