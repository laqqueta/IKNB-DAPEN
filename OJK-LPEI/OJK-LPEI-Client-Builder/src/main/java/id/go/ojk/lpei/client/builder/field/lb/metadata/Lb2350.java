package id.go.ojk.lpei.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5017PosLbLpeig2350;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2350 extends BaseMetadata {

	public Lb2350(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2350;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null);

		res.setRequiredPos(ER5017PosLbLpeig2350.getRequiredPos());
		res.setSavePosForm(ER5017PosLbLpeig2350.genFieldSave());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R7017_LB2350.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Pihak", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Jenis Reasuransi", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R057.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Tanggal Penutupan", sv(M, 8, 8, date)));
		fs.add(sf(5, null, "Total Nilai Reasuransi", sv(M, 1, 100, numeric)));
		fs.add(sf(6, null, "Pengajuan Klaim - Tanggal Klaim", sv(M, 8, 8, date)));
		fs.add(sf(7, null, "Pengajuan Klaim - Total Klaim", sv(M, 1, 20, numeric)));
		fs.add(sf(8, null, "Pembayaran Klaim - Tanggal Pembayaran", sv(M, 8, 8, date)));
		fs.add(sf(9, null, "Pembayaran Klaim - Total Klaim yang Telah Dibayar", sv(M, 1, 20, numeric)));
		fs.add(sf(10, null, "Cadangan Kerugian Penurunan Nilai - Metode Secara Individual", sv(M, 1, 20, numeric)));
		fs.add(sf(11, null, "Cadangan Kerugian Penurunan Nilai - Metode Secara Kolektif", sv(M, 1, 20, numeric)));
		fs.add(sf(12, null, "Cadangan Kerugian Penurunan Nilai - Aset Baik", sv(M, 1, 20, numeric)));
		fs.add(sf(13, null, "Cadangan Kerugian Penurunan Nilai - Aset Kurang Baik", sv(M, 1, 20, numeric)));
		fs.add(sf(14, null, "Cadangan Kerugian Penurunan Nilai - Aset Tidak Baik", sv(M, 1, 20, numeric)));
		fs.add(sf(15, null, "Cadangan Klaim", sv(M, 1, 20, numeric)));
		return res;
	}
}
