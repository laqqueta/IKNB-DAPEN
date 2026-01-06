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
import id.go.ojk.pnmk.client.builder.field.lb.uus.reference.ER3112PosLbPnmu2600;
import id.go.ojk.pnmk.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2600 extends BaseMetadata {

	public Lb2600(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2600;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		res.setSavePosForm(ER3112PosLbPnmu2600.genFieldSave());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLbUus.R3112_LB2600.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Surat Berharga ", sv(M, 1, 50, all)));
		fs.add(sf(3, null, "Jenis Surat Berharga ", sv(M, 1, 15, refTable)
				.confReference(EHeaderMetadataShared.R015.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Jangka Waktu, Tanggal Mulai", sv(M, 8, 8, date))
				.addFieldValidations(ER3112PosLbPnmu2600.genValidation4()));
		fs.add(sf(5, null, "Jangka Waktu, Tanggal Jatuh Tempo", sv(M, 8, 8, date))
				.addFieldValidations(ER3112PosLbPnmu2600.genValidation5()));
		fs.add(sf(6, null, "Ujrah/Imbal Hasil", sv(M, 1, 6, numericDotNegatif)));
		fs.add(sf(7, null, "Nominal", sv(M, 1, 16, numeric)));
		return res;
	}
}
