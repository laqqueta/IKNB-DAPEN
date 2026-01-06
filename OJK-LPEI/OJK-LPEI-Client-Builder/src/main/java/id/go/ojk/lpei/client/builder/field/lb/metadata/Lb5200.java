package id.go.ojk.lpei.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.*;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5027PosLbLpeig5200;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb5200 extends BaseMetadata {

	public Lb5200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_5200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 1, null);

		res.setRequiredPos(ER5027PosLbLpeig5200.getRequiredPos());
		res.setSavePos(ER5027PosLbLpeig5200.genFieldSave());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R5027_LB5200.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Individu/Anggota Kelompok/Total Kelompok", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R060.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Nama Grup/Kelompok", sv(M, 1, 100, all)));
		fs.add(sf(5, null, "Status Keterkaitan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R014.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Jenis Asuransi", sv(O, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R061.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(7, null, "Jenis Penjaminan", sv(C, 1, 10, refTable)
				.confConditionalRequired(ER5027PosLbLpeig5200.genConditionalValidation7())
				.confReference(EHeaderMetadataShared.R062.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(8, null, "Jangka Waktu - Tanggal Mulai", sv(M, 8, 8, date)));
		fs.add(sf(9, null, "Jangka Waktu - Tanggal Selesai", sv(M, 8, 8, date)));
		fs.add(sf(10, null, "Jumlah Retensi Sendiri - Dalam Mata Uang Asal", sv(M, 1, 20, numeric)
			.confRegex(SimpleValidation.patternNumericDotOpt)));
		fs.add(sf(11, null, "Jumlah Retensi Sendiri - Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(12, null, "Persentase Terhadap Modal", sv(M, 1, 10, DataType.numericDot)));
		fs.add(sf(13, null, "Modal", sv(M, 1, 20, numeric)));
		fs.add(sf(14, null, "Pelampauan - Nominal", sv(M, 1, 20, numeric)));
		fs.add(sf(15, null, "Pelampauan - Persentase", sv(M, 1, 10, DataType.numericDot)));
		fs.add(sf(16, null, "Reasuransi - Jumlah", sv(M, 1, 20, numeric)));
		fs.add(sf(17, null, "Reasuransi - Nama Perusahaan", sv(M, 1, 100, all)));
		fs.add(sf(18, null, "Keterangan", sv(M, 1, 100, all)));
		return res;
	}
}
