package id.go.ojk.pnmk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternGroupDebitur;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDot;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnmk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.ER3108PosLbPnmu2200;

public class Lb2200 extends BaseMetadata {

	public Lb2200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		res.setSavePosForm(ER3108PosLbPnmu2200.genFieldSave());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R3108_LB2200.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Bank Syariah", sv(M, 1, 50, all).confRegex(patternGroupDebitur.c())));
		fs.add(sf(3, null, "Jenis", sv(M, 1, 50, all)));
		fs.add(sf(4, null, "Jangka Waktu, Tanggal Mulai", sv(M, 8, 8, date))
				.addFieldValidations(ER3108PosLbPnmu2200.genValidation4()));
		fs.add(sf(5, null, "Jangka Waktu, Tanggal Jatuh Tempo", sv(M, 8, 8, date))
				.addFieldValidations(ER3108PosLbPnmu2200.genValidation5()));
		fs.add(sf(6, null, "Nisbah Bagi Hasil (%)", sv(M, 1, 6, numericDot)));
		fs.add(sf(7, null, "Jumlah", sv(M, 1, 16, numeric)));
		return res;
	}
}
