package id.go.ojk.pnjk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
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
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3113PosLbPnju2100C2;
import id.go.ojk.pnjk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2100C2 extends BaseMetadata {

	public Lb2100C2(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2100C2;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, ER3113PosLbPnju2100C2.genFieldSave(), ER3113PosLbPnju2100C2.genFieldSaveForm(), ER3113PosLbPnju2100C2.getRequiredPos());
		res.addSegmentValidations(ER3113PosLbPnju2100C2.genValidation1());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3113_LB2100C2.getObject())));
		fs.add(sf(2, null, "Jenis Investasi",
				sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
						.confReference(EHeaderMetadataShared.R039.getObject())
						.confConditionalRequired(ER3113PosLbPnju2100C2.genConditionA())));
		fs.add(sf(3, null, "Alamat",
				sv(C, 1, 200, all).confConditionalRequired(ER3113PosLbPnju2100C2.genConditionA())));
		fs.add(sf(4, null, "Status Legalitas",
				sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
						.confReference(EHeaderMetadataShared.R040.getObject())
						.confConditionalRequired(ER3113PosLbPnju2100C2.genConditionA())));
		fs.add(sf(5, null, "Nilai Perolehan", sv(M, 1, 16, numeric)));
		fs.add(sf(6, null, "Nilai Pasar", sv(M, 1, 16, numeric)));
		fs.add(sf(7, null, "CKPN-Individual",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3113PosLbPnju2100C2.genConditionB("8"))));
		fs.add(sf(8, null, "CKPN-Kolektif",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3113PosLbPnju2100C2.genConditionB("7"))));
		fs.add(sf(9, null, "Jumlah Neto", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3113PosLbPnju2100C2.genFieldValidation9()));
		return res;
	}
}
