package id.go.ojk.pnjk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
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
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3115PosLbPnju2100D2;
import id.go.ojk.pnjk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2100D2 extends BaseMetadata {

	public Lb2100D2(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2100D2;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, ER3115PosLbPnju2100D2.genFieldSave(), ER3115PosLbPnju2100D2.genFieldSaveForm(), ER3115PosLbPnju2100D2.getRequiredPos());
		res.addSegmentValidations(ER3115PosLbPnju2100D2.genValidation1());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3115_LB2100D2.getObject())));
		fs.add(sf(2, null, "Nama Investee",
				sv(C, 1, 100, all).confConditionalRequired(ER3115PosLbPnju2100D2.genConditionA())));
		fs.add(sf(3, null, "Metode Penyertaan",
				sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
						.confReference(EHeaderMetadataShared.R041.getObject())
						.confConditionalRequired(ER3115PosLbPnju2100D2.genConditionA())));
		fs.add(sf(4, null, "Tanggal Mulai Penyertaan",
				sv(C, 8, 8, date).confConditionalRequired(ER3115PosLbPnju2100D2.genConditionA())));
		fs.add(sf(5, null, "Persentase Kepemilikan",
				sv(C, 1, 6, numericDot).confConditionalRequired(ER3115PosLbPnju2100D2.genConditionA()))
				.addFieldValidations(ER3115PosLbPnju2100D2.genFieldValidation05()));
		fs.add(sf(6, null, "Nilai Perolehan", sv(M, 1, 16, numeric)));
		fs.add(sf(7, null, "Jumlah Bulan Laporan",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3115PosLbPnju2100D2.genConditionA())));
		fs.add(sf(8, null, "CKPN-Individual",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3115PosLbPnju2100D2.genConditionB("9"))));
		fs.add(sf(9, null, "CKPN-Kolektif",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3115PosLbPnju2100D2.genConditionB("8"))));
		fs.add(sf(10, null, "Jumlah Neto", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3115PosLbPnju2100D2.genFieldValidation10()));
		return res;
	}
}
