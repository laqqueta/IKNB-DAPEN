package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7013PosLbLpeiu2100;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2100 extends BaseMetadata {

	public Lb2100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null);
		res.setRequiredPos(ER7013PosLbLpeiu2100.getRequiredPos());
		res.setUniquePos(ER7013PosLbLpeiu2100.getUniquePos());
		res.setSavePos(ER7013PosLbLpeiu2100.genFieldSave());
		res.setSavePosForm(ER7013PosLbLpeiu2100.genFieldSave());
		res.addSegmentValidations(ER7013PosLbLpeiu2100.genRowValidation02());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R7013_LB2100.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Kontrak",
				sv(C, 1, 100, all).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(3, null, "Nomor Rekening",
				sv(C, 1, 100, all).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(4, null, "Jumlah Rekening",
				sv(C, 1, 10, numeric).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(5, null, "Nama Peminjam",
				sv(C, 1, 100, all).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(6, null, "Nama Kelompok Usaha Peminjam",
				sv(C, 1, 100, all).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(7, null, "Kategori Usaha Keuangan Berkelanjutan",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R052.getObject())
						.confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(8, null, "Golongan Peminjam",
				sv(C, 1, 100, all).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(9, null, "Status Keterkaitan",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R014.getObject())
						.confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(10, null, "Kategori Usaha Peminjam",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R012.getObject())
						.confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(11, null, "Jenis Pembiayaan",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R053.getObject())
						.confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(12, null, "Jenis Penggunaan",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R054.getObject())
						.confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(13, null, "Akad yang Digunakan",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R041.getObject())
						.confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(14, null, "Jenis Valuta",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R020.getObject())
						.confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(15, null, "Sektor Ekonomi Lapangan Usaha",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R022.getObject())
						.confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(16, null, "Jangka Waktu, Tanggal Mulai",
				sv(C, 1, 8, date).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(17, null, "Jangka Waktu, Tanggal Jatuh Tempo",
				sv(C, 1, 8, date).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(18, null, "Kualitas Aset",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R017.getObject())
						.confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(19, null, "Suku Bunga Bagi Hasil, Jenis",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R015.getObject())
						.confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(20, null, "Suku Bunga Bagi Hasil, Nilai",
				sv(C, 1, 20, numeric).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(21, null, "Suku Bunga Bagi Hasil, Tingkat",
				sv(C, 1, 10, numericDot).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(22, null, "Nilai Awal Pembiayaan",
				sv(C, 1, 20, numeric).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(23, null, "Persentase terhadap Modal",
				sv(C, 1, 10, numericDot).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(24, null, "Kategori Pengukuran",
				sv(C, 1, 100, all).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(25, null, "Kategori Piutang",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R016.getObject())
						.confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(26, null, "Lokasi Kabupaten/ Kota Proyek",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R033.getObject())
						.confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(27, null, "Outstanding Pembiayaan, Dalam Mata Uang Asal",
				sv(C, 1, 23, numericDot).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(28, null, "Outstanding Pembiayaan, Dalam Ekuivalen Rupiah", sv(M, 1, 20, numeric)));
		fs.add(sf(29, null, "Tunggakan Bunga/Margin/Ujrah/Bagi Hasil, Dalam Mata Uang Asal",
				sv(C, 1, 23, numericDot).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(30, null, "Tunggakan Bunga/Margin/Ujrah/Bagi Hasil, Dalam Ekuivalen Rupiah",
				sv(C, 1, 20, numeric).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(31, null, "Tunggakan Denda, Dalam Mata Uang Asal",
				sv(C, 1, 23, numericDot).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(32, null, "Tunggakan Denda, Dalam Ekuivalen Rupiah",
				sv(C, 1, 20, numeric).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(33, null, "Bunga/Margin/Ujrah/Bagi Hasil yang Ditangguhkan, Dalam Mata Uang Asal",
				sv(C, 1, 23, numericDot).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(34, null, "Bunga/Margin/Ujrah/Bagi Hasil yang Ditangguhkan, Dalam Ekuivalen Rupiah",
				sv(C, 1, 20, numeric).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(35, null, "Pendapatan Administrasi",
				sv(C, 1, 20, numeric).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(36, null, "Pendapatan Provisi",
				sv(C, 1, 20, numeric).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(37, null, "PPKA",
				sv(C, 1, 20, numeric).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(38, null, "Proporsi Penjaminan Kredit atau Asuransi Kredit",
				sv(C, 1, 10, numericDot).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(39, null, "Nama Perusahaan Asuransi/ Penjaminan",
				sv(C, 1, 100, all).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(40, null, "Jangka Waktu Asuransi/ Penjaminan",
				sv(C, 1, 10, numeric).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		fs.add(sf(41, null, "Informasi Agunan, Jenis Agunan",
				sv(C, 1, 10, refTable).confReference(EHeaderMetadataShared.R034.getObject())
						.confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(42, null, "Informasi Agunan, Nilai Agunan",
				sv(C, 1, 20, numeric).confConditionalRequired(ER7013PosLbLpeiu2100.genConditionalExist())));
		return res;
	}
}
