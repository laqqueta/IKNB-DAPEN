package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaSpace;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3032PosLbAsrjs224;
import id.go.ojk.asrjs.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb224 extends BaseMetadata {

	public Lb224(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_224;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3032_LB224.getObject())));
		fs.add(sf(2, null, "Identitas Instrumen Investasi", sv(O, 1, 100, alfaSpace)));
		fs.add(sf(3, null, "Dana Jaminan", sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R003.getObject())
				.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(4, null, "Investasi Dalam Rangka Pembiayaan Infrastruktur",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R004.getObject())
						.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(5, null, "Nama Penerbit / Pihak",
				sv(C, 1, 100, all).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(6, null, "Nama Group",
				sv(C, 1, 100, all).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(7, null, "Golongan Perusahaan / Penerbit",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R005.getObject())
						.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(8, null, "Jenis Dana", sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R006.getObject())
				.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(9, null, "Pengawas", sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R007.getObject())
				.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(10, null, "Jenis Investasi",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R008.getObject())
						.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(11, null, "Tanggal Mulai",
				sv(C, 1, 8, date).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(12, null, "Tanggal Jatuh tempo",
				sv(C, 1, 8, date).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(13, null, "Peringkat", sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R009.getObject())
				.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(14, null, "Nama Pemeringkat",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R010.getObject())
						.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(15, null, "Kategori Usaha",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R011.getObject())
						.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(16, null, "Sektor Ekonomi",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R012.getObject())
						.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(17, null, "Lokasi", sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R013.getObject())
				.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(18, null, "Hubungan Istimewa",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R015.getObject())
						.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(19, null, "Tujuan Kepemilikan",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R016.getObject())
						.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(20, null, "Bagian Kepemilikan (%)",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(21, null, "Mata Uang", sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R017.getObject())
				.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(22, null, "Jenis Tingkat Pengembalian",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R018.getObject())
						.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(23, null, "Tingkat Pengembalian (%)",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(24, null, "Kolektibilitas",
				sv(C, 1, 4, refTable).confReference(EHeaderMetadataShared.R019.getObject())
						.confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(25, null, "Saldo Buku",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(26, null, "Saldo Penilaian SAP",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(27, null, "AYD",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(28, null, "Hasil Investasi Berjalan Diterima Kas",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(29, null, "Piutang Hasil Investasi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(30, null, "Piutang Hasil Investasi Periode Sebelumnya Diterima  Kas Periode Berjalan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(31, null, "Total Hasil Investasi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		fs.add(sf(32, null, "Hasil Investasi Yang Siap Didistribusi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3032PosLbAsrjs224.genConditional())));
		return res;
	}
}
