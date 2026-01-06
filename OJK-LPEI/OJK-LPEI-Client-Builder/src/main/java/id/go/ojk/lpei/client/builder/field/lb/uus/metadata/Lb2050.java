package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7007PosLbLpeiu1100;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7012PosLbLpeiu2050;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2050 extends BaseMetadata {

	public Lb2050(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2050;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 0, null);

		res.setSavePosForm(ER7012PosLbLpeiu2050.genFieldSave());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R7012_LB2050.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Bank", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Negara", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R024.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(4, null, "Jenis", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R051.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Jenis Valuta", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(6, null, "Jangka Waktu - Tanggal Mulai", sv(M, 8, 8, date)));
		fs.add(sf(7, null, "Jangka Waktu - Tanggal Jatuh Tempo", sv(M, 8, 8, date)));
		fs.add(sf(8, null, "Kategori Pengukur", sv(M, 1, 100, all)));
		fs.add(sf(9, null, "Kualitas Aset", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R017.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(10, null, "Bagi Hasil - Nilai", sv(M, 1, 20, numeric)));
		fs.add(sf(11, null, "Bagi Hasil - Tingkat", sv(M, 1, 10, DataType.numericDot)));
		fs.add(sf(12, null, "Nominal Simpanan - Dalam Mata Uang Asal", sv(M, 1, 23, numericDot)));
		fs.add(sf(13, null, "Nominal Simpanan - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(14, null, "Persentase Terhadap Modal", sv(M, 1, 10, DataType.numericDot))
				.addFieldValidations(UtilFieldValidation.genEqualsDivisionForm("13","14", EFormLaporanBulananUus.LB_1100.getCode(),
						ER7007PosLbLpeiu1100.R_11000600000000.getKey(),"4",
						"Kolom Nominal Simpanan Dalam Ekuivalen Rupiah di form 2050 dibagi Total Ekuitas (11000600000000) Pada Kolom Jumlah di Form 1100")));
		fs.add(sf(15, null, "Pendapatan Bunga/Bagi Hasil yang Akan Diterima", sv(M, 1, 20, numeric)));
		fs.add(sf(16, null, "PPKA", sv(M, 1, 20, numeric)));
		return res;
	}
}
