package id.go.ojk.pnmk.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME_1;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NOMOR_SURAT;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternAlfaNumericSpace;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.phone;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnmk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnmk.client.builder.field.lb.reference.ER3001PosLbPnmk0020;
import id.go.ojk.pnmk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb0020 extends BaseMetadata {

	public Lb0020(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0020;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null, null, ER3001PosLbPnmk0020.genFieldSave());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R3001_LB0020.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Jenis kantor", sv(M, 1, 15, refTable).confReference(EHeaderMetadataShared.R000.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(3, null, "Nomor Surat Pencatatan", sv(M, 1, 30, all).confRegex(PATTERN_NOMOR_SURAT.c())));
		fs.add(sf(4, null, "Tanggal Surat Pencatatan", sv(M, 8, 8, date)));
		fs.add(sf(5, null, "Alamat", sv(M, 1, 200, all)));
		fs.add(sf(6, null, "Kecamatan", sv(M, 1, 50, all).confRegex(patternAlfaNumericSpace.c())));
		fs.add(sf(7, null, "Kabupaten/Kota", sv(M, 1, 15, refTable)
				.confReference(EHeaderMetadataShared.R008.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(8, null, "Kode Pos", sv(M, 1, 6, numeric)));
		fs.add(sf(9, null, "Nomor Telepon", sv(M, 1, 20, phone)));
		fs.add(sf(10, null, "Jumlah Tenaga Kerja", sv(M, 1, 5, numeric)));
		fs.add(sf(11, null, "Nama Penanggung Jawab Kantor", sv(M, 1, 100, all).confRegex(PATTERN_NAME_1.c())));
		fs.add(sf(12, null, "Tanggal Mulai Operasional ", sv(M, 8, 8, date)));
		fs.add(sf(13, null, "Kepemilikan Gedung Kantor", sv(M, 1, 15, refTable)
				.confReference(EHeaderMetadataShared.R010.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		return res;
	}
}
