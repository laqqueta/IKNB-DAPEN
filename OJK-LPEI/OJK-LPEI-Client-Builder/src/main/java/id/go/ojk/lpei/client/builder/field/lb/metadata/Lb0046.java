package id.go.ojk.lpei.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5005PosLbLpeig0046;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb0046 extends BaseMetadata {

	public Lb0046(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0046;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 0, null);

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, DataType.refTable)
				.confReference(EHeaderMetadataLb.R5005_LB0046.getObject())
				.confRegex(SimpleValidation.patternNumeric)));
		fs.add(sf(2, null, "Nama", sv(M, 1, 100, DataType.all)
				.confRegex(SimpleValidation.patternAlfaNumericDotComma)));
		fs.add(sf(3, null, "Nomor Identitas", sv(M, 1, 20, DataType.all)));
		fs.add(sf(4, null, "Kewarganegaraan", sv(M, 1, 10, DataType.refTable)
				.confReference(EHeaderMetadataShared.R024.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(5, null, "Jabatan", sv(M, 1, 10, DataType.refTable)
				.confReference(EHeaderMetadataShared.R003.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Bidang Spesialisasi", sv(M, 1, 10, DataType.refTable)
				.confReference(EHeaderMetadataShared.R008.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(7, null, "Domisili", sv(M, 1, 1000, DataType.all)));
		fs.add(sf(8, null, "Nomor Izin Kerja", sv(M, 1, 10, DataType.alfaNumeric)));
		fs.add(sf(9, null, "Tanggal Izin Kerja", sv(M, 8, 8, DataType.date)));
		fs.add(sf(10, null, "Awal Masa Laku Izin Kerja", sv(M, 8, 8, DataType.date))
				.addFieldValidations(ER5005PosLbLpeig0046.genFieldValidation10()));
		fs.add(sf(11, null, "Akhir Masa Laku Izin Kerja", sv(M, 8, 8, DataType.date)));
		return res;
	}
}
