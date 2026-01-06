package id.go.ojk.ppik.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.ER3117PosLbPpiu2380;
import id.go.ojk.ppik.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2380 extends BaseMetadata {

	public Lb2380(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2380;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R3118_LB2380.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Penerima", sv(M, 1, 100, all).confRegex(PATTERN_NAME.c())));
		fs.add(sf(3, null, "Status Usaha", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R031.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Bidang Usaha", sv(O, 1, 10, refTable).confReference(EHeaderMetadataShared.R022.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Jenis Valuta", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Jangka Waktu, Tanggal Mulai", sv(M, 8, 8, date))
				.addFieldValidations(ER3117PosLbPpiu2380.genFieldValidation6()));
		fs.add(sf(7, null, "Jangka Waktu, Tanggal Jatuh Tempo", sv(M, 8, 8, date)));
		fs.add(sf(8, null, "Akad yang Digunakan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R044.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(9, null, "Margin/Bagi Hasil, Jenis", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R015.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(10, null, "Margin/Bagi Hasil, Nilai", sv(M, 1, 16, numeric)));
		fs.add(sf(11, null, "Margin/Bagi Hasil, Tingkat",
				sv(C, 1, 6, numericDot).confConditionalRequired(ER3117PosLbPpiu2380.genFieldCondition11())));
		fs.add(sf(12, null, "Nominal Investasi, Dalam Nilai Mata Uang Asal",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3117PosLbPpiu2380.genFieldCondition())));
		fs.add(sf(13, null, "Nominal Investasi, Dalam Ekuivalen Rupiah", sv(M, 1, 16, numeric)));
		fs.add(sf(14, null, "Nilai Outstanding, Dalam Nilai Mata Uang Asal",
				sv(C, 1, 16, numeric).confConditionalRequired(ER3117PosLbPpiu2380.genFieldCondition())));
		fs.add(sf(15, null, "Nilai Outstanding, Dalam Ekuivalen Rupiah", sv(M, 1, 16, numeric)));
		fs.add(sf(16, null, "Cadangan", sv(M, 1, 16, numeric)));
		fs.add(sf(17, null, "Sumber Dana Investasi", sv(M, 1, 30, all).confRegex(PATTERN_NAME.c())));
		fs.add(sf(18, null, "Lokasi Kabupaten/Kota Proyek", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R033.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		return res;
	}
}
