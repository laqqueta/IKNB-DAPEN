package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumericSpace;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb608 extends BaseMetadata {

	public Lb608(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_608;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3047_LB608.getObject())));
		fs.add(sf(2, null, "Jenis Pertanggungan",
				sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R025.getObject())));
		fs.add(sf(3, null, "Mata Uang", sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R017.getObject())));
		fs.add(sf(4, null, "Lini Usaha", sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R023.getObject())));
		fs.add(sf(5, null, "Uraian Nama Produk", sv(M, 1, 100, alfaNumericSpace)));
		fs.add(sf(6, null, "Penyisihan Kontribusi Tahun Berjalan - S.P", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Penyisihan Kontribusi Tahun Berjalan - P.U", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Penyisihan Kontribusi Tahun Berjalan - P.R", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Penyisihan Kontribusi Tahun Sebelumnya - S.P", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Penyisihan Kontribusi Tahun Sebelumnya - P.U", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Penyisihan Kontribusi Tahun Sebelumnya - P.R", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(12, null, "Jumlah Peserta - Tahun Berjalan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "Jumlah Peserta - Tahun Lalu", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(14, null, "Jumlah UP - Tahun Berjalan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(15, null, "Jumlah UP - Tahun Lalu", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(16, null, "Kontribusi Murni", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(17, null, "Kontribusi Bruto", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(18, null, "Rata-rata Masa Kontrak", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(19, null, "Rata-Rata Usia Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(20, null, "Rata-Rata Usia Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(21, null, "Tabel Mortalita", sv(M, 1, 100, alfaNumericSpace)));
		fs.add(sf(22, null, "Tingkat Diskonto", sv(M, 1, 6, numericDotNegatif)));
		fs.add(sf(23, null, "Metoda Perhitungan", sv(M, 1, 100, alfaNumericSpace)));
		return res;
	}
}
