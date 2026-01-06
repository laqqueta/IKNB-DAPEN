package id.go.ojk.pnmk.client.builder.field.lb.metadata;

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
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnmk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnmk.client.builder.field.lb.reference.ER3011PosLbPnmk2500;
import id.go.ojk.pnmk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2500 extends BaseMetadata {

	public Lb2500(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2500;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R3011_LB2500.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Provinsi", sv(M, 1, 15, refTable).confReference(EHeaderMetadataShared.R007.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(3, null, "Kabupaten/Kota", sv(M, 1, 15, refTable)
				.confReference(EHeaderMetadataShared.R008.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Nama Kantor Cabang", sv(M, 1, 100, all)));
		fs.add(sf(5, null, "Sektor Ekonomi", sv(M, 1, 15, refTable)
				.confReference(EHeaderMetadataShared.R009.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Nama Debitur", sv(M, 1, 100, all)));
		fs.add(sf(7, null, "Nomor Induk Kependudukan (NIK)", sv(M, 1, 20, numeric)));
		fs.add(sf(8, null, "Nomor Perjanjian Kredit (PK)", sv(M, 1, 100, all)));
		fs.add(sf(9, null, "Nama Produk", sv(M, 1, 50, all)));
		fs.add(sf(10, null, "Jangka Waktu, Tanggal Mulai", sv(M, 8, 8, date))
				.addFieldValidations(ER3011PosLbPnmk2500.genValidation10()));
		fs.add(sf(11, null, "Jangka Waktu, Tanggal Jatuh Tempo", sv(M, 8, 8, date))
				.addFieldValidations(ER3011PosLbPnmk2500.genValidation11()));
		fs.add(sf(12, null, "Plafon Pembiayaan/Pinjaman", sv(M, 1, 16, numeric)));
		fs.add(sf(13, null, "Suku Bunga/Imbal Hasil (%)", sv(M, 1, 6, numericDotNegatif)));
		fs.add(sf(14, null, "Outstanding Pembiayaan/Pinjaman", sv(M, 1, 16, numeric)));
		fs.add(sf(15, null, "Kualitas", sv(M, 1, 1, refTable).confReference(EHeaderMetadataShared.R006.getObject())
				.confRegex(patternNumeric.c())));
		fs.add(sf(16, null, "Uang Pertanggungjawaban", sv(M, 1, 16, numeric)));
		fs.add(sf(17, null, "Margin Ditangguhkan", sv(M, 1, 16, numeric)));
		return res;
	}
}
