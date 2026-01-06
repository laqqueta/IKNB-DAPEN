package id.go.ojk.pnjk.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjk.client.builder.field.lb.reference.ER3021PosLbPnjk2700;
import id.go.ojk.pnjk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2700 extends BaseMetadata {

	public Lb2700(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2700;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, ER3021PosLbPnjk2700.genFieldSave(), ER3021PosLbPnjk2700.genFieldSave(), ER3021PosLbPnjk2700.getRequiredPos());

        res.addSegmentValidations(ER3021PosLbPnjk2700.genValidation1());
        res.addSegmentValidations(ER3021PosLbPnjk2700.genValidation2());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable)
                        .confReference(EHeaderMetadataLb.R3021_LB2700.getObject())));
		fs.add(sf(2, null, "Nama Terjamin", sv(C, 1, 100, all)
                .confConditionalRequired(ER3021PosLbPnjk2700.genConditionTotal())));
		fs.add(sf(3, null, "Jenis Penjaminan", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R042.getObject())
                .confConditionalRequired(ER3021PosLbPnjk2700.genConditionTotal())));
		fs.add(sf(4, null, "Produk Penjaminan", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R043.getObject())
                .confConditionalRequired(ER3021PosLbPnjk2700.genConditionTotal())));
		fs.add(sf(5, null, "Nama Perusahaan Mitra", sv(C, 1, 100, all)
                .confConditionalRequired(ER3021PosLbPnjk2700.genConditionTotal())));
		fs.add(sf(6, null, "Utang Klaim (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(7, null, "Jumlah Hari Menunggak (Satuan)", sv(C, 1, 8, numeric)
                .confConditionalRequired(ER3021PosLbPnjk2700.genConditionTotal())));
		return res;
	}
}
