package id.go.ojk.pnjs.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjs.client.builder.field.lb.reference.ER3025PosLbPnjs3100;
import id.go.ojk.pnjs.client.builder.field.reference.EHeaderMetadataShared;

public class Lb3100 extends BaseMetadata {

	public Lb3100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_3100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, ER3025PosLbPnjs3100.genFieldSave(), ER3025PosLbPnjs3100.genFieldSave(), ER3025PosLbPnjs3100.getRequiredPos());

        res.addSegmentValidations(ER3025PosLbPnjs3100.genValidation());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3025_LB3100.getObject())));
		fs.add(sf(2, null, "Nomor Sertifikat Kafalah", sv(C, 1, 35, all)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(3, null, "Tanggal Sertifikat Kafalah", sv(C, 8, 8, date)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(4, null, "Nama Terjamin (Makfuul 'Anhu)", sv(C, 1, 100, all)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(5, null, "NIK", sv(C, 1, 20, numeric)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(6, null, "Sektor Ekonomi", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R022.getObject())
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(7, null, "Jenis Kafalah", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R042.getObject())
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(8, null, "Produk Kafalah", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R043.getObject())
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(9, null, "Nama Penerima Jaminan (Makfuul Lahu)", sv(C, 1, 100, all)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(10, null, "Jenis Penerima Jaminan (Makfuul Lahu)", sv(C, 1, 10, refTable)
				.confRegex(PATTERN_REFERENCE_1).confReference(EHeaderMetadataShared.R053.getObject())
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(11, null, "Lokasi", sv(C, 1, 10, refTable).confRegex(PATTERN_REFERENCE_1)
				.confReference(EHeaderMetadataShared.R033.getObject())
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(12, null, "Tanggal Awal Kafalah", sv(C, 8, 8, date)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(13, null, "Tanggal Akhir Kafalah", sv(C, 8, 8, date)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(14, null, "Nilai Pembiayaan/Fasilitas", sv(C, 1, 16, numeric)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(15, null, "Nilai Kafalah", sv(C, 1, 16, numeric)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(16, null, "Nilai IJK", sv(C, 1, 16, numeric)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(17, null, "Nilai IJK Porsi Unit Usaha Syariah", sv(C, 1, 16, numeric)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(18, null, "Nilai IJK Penjaminan Ulang/Kontribusi Reasuransi", sv(C, 1, 16, numeric)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(19, null, "Biaya Akuisisi", sv(C, 1, 16, numeric)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		fs.add(sf(20, null, "Nilai Kafalah Ditanggung Sendiri", sv(M, 1, 16, numeric)));
		fs.add(sf(21, null, "Nilai Kafalah Porsi Mitra Penjaminan Ulang/Reasuransi", sv(C, 1, 16, numeric)
                .confConditionalRequired(ER3025PosLbPnjs3100.genConditionForTotal())));
		return res;
	}
}
