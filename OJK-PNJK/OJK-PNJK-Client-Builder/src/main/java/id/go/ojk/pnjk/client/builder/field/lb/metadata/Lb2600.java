package id.go.ojk.pnjk.client.builder.field.lb.metadata;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjk.client.builder.field.lb.reference.ER3020PosLbPnjk2600;
import id.go.ojk.pnjk.client.builder.field.reference.EHeaderMetadataShared;

import java.util.ArrayList;
import java.util.List;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.lib.client.model.config.DataType.*;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

public class Lb2600 extends BaseMetadata {

	public Lb2600(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2600;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, ER3020PosLbPnjk2600.genFieldSave(), null, ER3020PosLbPnjk2600.getRequiredPos());

        res.addSegmentValidations(ER3020PosLbPnjk2600.genValidation1());
        res.addSegmentValidations(ER3020PosLbPnjk2600.genValidation2());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3020_LB2600.getObject())));
		fs.add(sf(2, null, "Nama Penerima Jaminan", sv(C, 1, 100, all)
                .confConditionalRequired(ER3020PosLbPnjk2600.genConditionForTotal())));
		fs.add(sf(3, null, "Jenis Penjaminan", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R042.getObject())
                .confConditionalRequired(ER3020PosLbPnjk2600.genConditionForTotal())));
		fs.add(sf(4, null, "Produk Penjaminan", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R043.getObject())
                .confConditionalRequired(ER3020PosLbPnjk2600.genConditionForTotal())));
		fs.add(sf(5, null, "Nama Agen", sv(C, 1, 100, all)
                .confConditionalRequired(ER3020PosLbPnjk2600.genConditionForTotal())));
		fs.add(sf(6, null, "Utang Komisi (Rp)", sv(M, 1, 16, numeric)));
		fs.add(sf(7, null, "Jumlah Hari Menunggak (Satuan)", sv(C, 1, 8, numeric)
                .confConditionalRequired(ER3020PosLbPnjk2600.genConditionForTotal())));
		return res;
	}
}
