package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7001PosLbLpeiu0020;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb0020 extends BaseMetadata {

	public Lb0020(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_0020;

		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(), extension, 0, null);
		res.setSavePosForm(ER7001PosLbLpeiu0020.genFieldSave());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, DataType.refTable)
				.confReference(EHeaderMetadataLbUus.R7001_LB0020.getObject())
				.confRegex(SimpleValidation.patternNumeric)));
		fs.add(sf(2, null, "Nama Kantor Diluar Kantor Pusat", sv(M, 1, 100, DataType.all)
				.confRegex(SimpleValidation.patternAlfaNumericDotHypen)));
		fs.add(sf(3, null, "Alamat", sv(M, 1, 100, DataType.all)));
		fs.add(sf(4, null, "Kecamatan", sv(M, 1, 100, DataType.alfaNumericSpace)));
		fs.add(sf(5, null, "Kabupaten/Kota",
				sv(M, 1, 10, DataType.refTable).confReference(EHeaderMetadataShared.R033.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Kode Pos", sv(M, 1, 5, DataType.numeric)));
		fs.add(sf(7, null, "Nomor Telepon", sv(M, 1, 15, DataType.numeric)));
		fs.add(sf(8, null, "Jumlah Tenaga Kerja", sv(M, 1, 5, DataType.numeric)));
		fs.add(sf(9, null, "Nama Kepala Kantor Diluar Kantor Pusat", sv(M, 1, 100, DataType.all)
				.confRegex(SimpleValidation.patternAlfaDotComma)));
		return res;
	}
}
