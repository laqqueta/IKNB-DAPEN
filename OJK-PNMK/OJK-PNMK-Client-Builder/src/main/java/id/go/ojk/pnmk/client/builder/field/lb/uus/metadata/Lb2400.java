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
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.ER3110PosLbPnmu2400;
import id.go.ojk.pnmk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2400 extends BaseMetadata {

	public Lb2400(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2400;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R3110_LB2400.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Provinsi", sv(M, 1, 15, refTable).confReference(EHeaderMetadataShared.R007.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(3, null, "Kabupaten/Kota", sv(M, 1, 15, refTable)
				.confReference(EHeaderMetadataShared.R008.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Nama Kantor Cabang", sv(M, 1, 100, all)));
		fs.add(sf(5, null, "Nama Kantor Unit", sv(M, 1, 100, all)));
		fs.add(sf(6, null, "Sektor Ekonomi", sv(M, 1, 15, refTable)
				.confReference(EHeaderMetadataShared.R009.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(7, null, "Nama Konsumen", sv(M, 1, 100, all)));
		fs.add(sf(8, null, "Nomor Induk Kependudukan (NIK)", sv(M, 1, 20, numeric)));
		fs.add(sf(9, null, "Nomor Perjanjian Kredit (PK)", sv(M, 1, 100, all)));
		fs.add(sf(10, null, "Nama Produk", sv(M, 1, 50, all)));
		fs.add(sf(11, null, "Jangka Waktu, Tanggal Mulai", sv(M, 8, 8, date))
				.addFieldValidations(ER3110PosLbPnmu2400.genValidation11()));
		fs.add(sf(12, null, "Jangka Waktu, Tanggal Jatuh Tempo", sv(M, 8, 8, date))
				.addFieldValidations(ER3110PosLbPnmu2400.genValidation12()));
		fs.add(sf(13, null, "Plafon Pembiayaan/Pinjaman", sv(M, 1, 16, numeric)));
		fs.add(sf(14, null, "Outstanding Pembiayaan/Pinjaman", sv(M, 1, 16, numeric)));
		fs.add(sf(15, null, "Imbal Hasil (%)", sv(M, 1, 6, numericDotNegatif)));
		fs.add(sf(16, null, "Margin Ditangguhkan", sv(M, 1, 16, numeric)));
		fs.add(sf(17, null, "Pembayaran Bagi Hasil/Ujrah", sv(M, 1, 16, numeric)));
		fs.add(sf(18, null, "Kualitas", sv(M, 1, 1, refTable).confReference(EHeaderMetadataShared.R006.getObject())
				.confRegex(patternNumeric.c())));
		fs.add(sf(19, null, "Informasi Nilai Agunan", sv(M, 1, 16, numeric)));
		fs.add(sf(20, null, "Dana Cadangan Nasabah", sv(M, 1, 16, numeric)));
		return res;
	}
}
