package id.go.ojk.lpei.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SimpleValidation;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.conf.client.UtilFieldValidation;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.lpei.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.lpei.client.builder.field.lb.reference.ER5002PosLbLpeig0035;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb0035 extends BaseMetadata {

	public Lb0035(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0035;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null);
		res.setRequiredPos(ER5002PosLbLpeig0035.getRequiredPos());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, DataType.refTable)
				.confReference(EHeaderMetadataLb.R5002_LB0035.getObject())
				.confRegex(SimpleValidation.patternNumeric)));
		fs.add(sf(2, null, "Nama", sv(M, 1, 100, DataType.all)));
		fs.add(sf(3, null, "Nomor Identitas", sv(M, 1, 20, DataType.alfaNumeric)));
		fs.add(sf(4, null, "Kewarganegaraan", sv(M, 1, 10, DataType.refTable)
				.confReference(EHeaderMetadataShared.R024.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(5, null, "Jabatan", sv(M, 1, 10, DataType.refTable)
				.confReference(EHeaderMetadataShared.R003.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(6, null, "Domisili", sv(M, 1, 100, DataType.all)));
		fs.add(sf(7, null, "Nomor Surat Keputusan Pengangkatan", sv(M, 1, 100, DataType.all)));
		fs.add(sf(8, null, "Tanggal Surat Keputusan Pengangkatan", sv(M, 8, 8, DataType.date)));
		fs.add(sf(9, null, "Tanggal Mulai Menjabat", sv(M, 8, 8, DataType.date))
				.addFieldValidations(UtilFieldValidation.genDateGreaterEquals("8")));
		return res;
	}
}
