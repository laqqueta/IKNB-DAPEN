package id.go.ojk.pnmk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.ER3113PosLbPnmu2700;
import id.go.ojk.pnmk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2700 extends BaseMetadata {

	public Lb2700(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2700;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		res.setSavePosForm(ER3113PosLbPnmu2700.genFieldSave());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R3113_LB2700.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Perjanjian Kredit", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Akad Pendanaan", sv(M, 1, 15, refTable)
				.confReference(EHeaderMetadataShared.R013.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Jenis Pendanaan", sv(M, 1, 15, refTable)
				.confReference(EHeaderMetadataShared.R014.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Nama Pendanaan", sv(M, 1, 100, all)));
		fs.add(sf(6, null, "Nominal", sv(M, 1, 16, numeric)));
		fs.add(sf(7, null, "Outstanding Bulan Lalu", sv(M, 1, 16, numeric)));
		fs.add(sf(8, null, "Jumlah Bulan Laporan", sv(M, 1, 16, numeric)));
		fs.add(sf(9, null, "Tingkat Bagi Hasil/Imbal Hasil (%)", sv(M, 1, 6, numericDotNegatif)));
		fs.add(sf(10, null, "Jangka Waktu, Tanggal Mulai", sv(M, 8, 8, date))
				.addFieldValidations(ER3113PosLbPnmu2700.genValidation10()));
		fs.add(sf(11, null, "Jangka Waktu, Tanggal Jatuh Tempo", sv(M, 8, 8, date))
				.addFieldValidations(ER3113PosLbPnmu2700.genValidation11()));
		return res;
	}
}
