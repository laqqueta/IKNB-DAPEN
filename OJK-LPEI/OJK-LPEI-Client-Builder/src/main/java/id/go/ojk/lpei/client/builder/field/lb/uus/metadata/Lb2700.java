package id.go.ojk.lpei.client.builder.field.lb.uus.metadata;

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
import id.go.ojk.lpei.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.lpei.client.builder.field.lb.uus.reference.ER7023PosLbLpeiu2700;
import id.go.ojk.lpei.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2700 extends BaseMetadata {

	public Lb2700(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2700;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);

		res.setSavePosForm(ER7023PosLbLpeiu2700.genFieldSave());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R7023_LB2700.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Referensi Transaksi (Deal Number)", sv(M, 1, 100, all)));
		fs.add(sf(3, null, "Jenis Transaksi Derivatif",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R029.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Jenis Valuta", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(5, null, "Variabel yang Mendasari", sv(M, 1, 100, all)));
		fs.add(sf(6, null, "Counterparty - Nama", sv(M, 1, 100, all)));
		fs.add(sf(7, null, "Counterparty - Negara",
				sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R024.getObject())
						.confRegex(SimpleValidation.PATTERN_REFERENCE_3.c())));
		fs.add(sf(8, null, "Counterparty - Golongan", sv(M, 1, 100, all)));
		fs.add(sf(9, null, "Jumlah Liabilitas Derivatif", sv(M, 1, 20, numeric)));
		return res;
	}
}
