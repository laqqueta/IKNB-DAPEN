package id.go.ojk.ppik.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.ppik.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.ppik.client.builder.field.lb.reference.ER3022PosLbPpik2790;
import id.go.ojk.ppik.client.builder.field.reference.EHeaderMetadataShared;

public class Lb2790 extends BaseMetadata {

	public Lb2790(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_2790;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		res.setSavePosForm(ER3022PosLbPpik2790.genFieldSave());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3022_LB2790.getObject())
						.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Jenis", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R028.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(3, null, "Jenis Valuta", sv(M, 1, 10, refTable).confReference(EHeaderMetadataShared.R020.getObject())
				.confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Nominal", sv(M, 1, 16, numeric)));
		fs.add(sf(5, null, "Jangka Waktu, Tanggal Mulai", sv(O, 8, 8, date))
				.addFieldValidations(ER3022PosLbPpik2790.genFieldValidation5()));
		fs.add(sf(6, null, "Jangka Waktu, Tanggal Jatuh Tempo", sv(O, 8, 8, date)));
		fs.add(sf(7, null, "Status Keterkaitan", sv(M, 1, 10, refTable)
				.confReference(EHeaderMetadataShared.R014.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		return res;
	}
}
