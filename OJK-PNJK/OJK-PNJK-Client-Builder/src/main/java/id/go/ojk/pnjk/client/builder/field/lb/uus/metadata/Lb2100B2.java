package id.go.ojk.pnjk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumericSpace;
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
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3110PosLbPnju2100B2;
import id.go.ojk.pnjk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2100B2 extends BaseMetadata {

	public Lb2100B2(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2100B2;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, ER3110PosLbPnju2100B2.genFieldSave(), null, ER3110PosLbPnju2100B2.getRequiredPos());

        res.addSegmentValidations(ER3110PosLbPnju2100B2.genValidation1());
        res.addSegmentValidations(ER3110PosLbPnju2100B2.genValidationTotal());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3110_LB2100B2.getObject())));
		fs.add(sf(2, null, "Jenis Surat Berharga", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R019.getObject())
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal())));
		fs.add(sf(3, null, "Nama Surat Berharga", sv(C, 1, 100, all)
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal())));
		fs.add(sf(4, null, "Nama Penerbit", sv(C, 1, 100, all)
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal())));
		fs.add(sf(5, null, "Nama Manajer Investasi/ Broker", sv(C, 1, 100, alfaNumericSpace)
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal())));
		fs.add(sf(6, null, "Kode Penerbit", sv(C, 1, 20, alfaNumeric)
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal())));
		fs.add(sf(7, null, "Peringkat", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R026.getObject())
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal())));
		fs.add(sf(8, null, "Lembaga Pemeringkat", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R025.getObject())
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal())));
		fs.add(sf(9, null, "Kategori Pengukuran", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R038.getObject())
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal())));
		fs.add(sf(10, null, "Jangka Waktu-Tanggal Penerbitan", sv(C, 8, 8, date)
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal()))
				.addFieldValidations(ER3110PosLbPnju2100B2.genFieldValidation10()));
		fs.add(sf(11, null, "Jangka Waktu-Tanggal Jatuh Tempo", sv(C, 8, 8, date)
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal()))
				.addFieldValidations(ER3110PosLbPnju2100B2.genFieldValidation11()));
		fs.add(sf(12, null, "Suku Bunga atau Kupon-Tingkat Suku Bunga atau Kupon", sv(C, 3, 6, numericDot)
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal()))
				.addFieldValidations(ER3110PosLbPnju2100B2.genFieldValidationGreater("0.00")));
		fs.add(sf(13, null, "Suku Bunga atau Kupon-Jenis Suku Bunga atau Kupon", sv(C, 1, 10, all)
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal())));
		fs.add(sf(14, null, "Nilai Aktiva Bersih (NAB) atau Harga Saham", sv(C, 1, 16, numeric)
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal())));
		fs.add(sf(15, null, "Unit Penyertaan (UP) atau Share", sv(C, 1, 16, numeric)
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal())));
		fs.add(sf(16, null, "Nominal-Bulan Lalu", sv(C, 1, 16, numeric)
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal())));
		fs.add(sf(17, null, "Nominal-Bulan Laporan", sv(C, 1, 16, numeric)
                .confConditionalRequired(ER3110PosLbPnju2100B2.genConditionTotal())));
		fs.add(sf(18, null, "CKPN-Individual",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3110PosLbPnju2100B2.genCondition("19"))));
		fs.add(sf(19, null, "CKPN-Kolektif",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3110PosLbPnju2100B2.genCondition("18"))));
		fs.add(sf(20, null, "Jumlah Neto", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3110PosLbPnju2100B2.genFieldValidation20()));
		return res;
	}
}
