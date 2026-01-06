package id.go.ojk.lpei.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
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
import id.go.ojk.lpei.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5018PosLbLpeig2400;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2400 extends BaseMetadata {

	public Lb2400(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2400;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 0, null);

		res.setSavePosForm(ER5018PosLbLpeig2400.genFieldSave());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R5018_LB2400.getObject())
				.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Referensi Transaksi (Deal Number)", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Jenis", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R029.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Jenis Valuta", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(5, null, "Variabel yang Mendasari", sv(M, 1, 100, all)));
		fs.add(sf(6, null, "Counterparty - Nama", sv(M, 1, 100, all)));
		fs.add(sf(7, null, "Counterparty - Negara", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R024.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(8, null, "Counterparty - Golongan", sv(M, 1, 100, all)));
		fs.add(sf(9, null, "Kualitas Aset", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R017.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(10, null, "Jumlah Tagihan", sv(M, 1, 20, numeric)));
		fs.add(sf(11, null, "Cadangan Kerugian Penurunan Nilai - Metode Secara Individual", sv(M, 1, 20, numeric)));
		fs.add(sf(12, null, "Cadangan Kerugian Penurunan Nilai - Metode Secara Kolektif", sv(M, 1, 20, numeric)));
		fs.add(sf(13, null, "Cadangan Kerugian Penurunan Nilai - Aset Baik", sv(M, 1, 20, numeric)));
		fs.add(sf(14, null, "Cadangan Kerugian Penurunan Nilai - Aset Kurang Baik", sv(M, 1, 20, numeric)));
		fs.add(sf(15, null, "Cadangan Kerugian Penurunan Nilai - Aset Tidak Baik", sv(M, 1, 20, numeric)));
		return res;
	}
}
