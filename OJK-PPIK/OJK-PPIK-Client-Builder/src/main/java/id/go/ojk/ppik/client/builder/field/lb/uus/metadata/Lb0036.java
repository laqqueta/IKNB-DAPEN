package id.go.ojk.ppik.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_NAME;
import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.ER3104PosLbPpiu0036;
import id.go.ojk.ppik.client.builder.field.reference.EHeaderMetadataShared;

public class Lb0036 extends BaseMetadata {

	public Lb0036(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_0036;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3105_LB0036.getObject())
						.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nama Pihak Terkait", sv(M, 1, 100, all).confRegex(PATTERN_NAME.c())));
		fs.add(sf(3, null, "Golongan",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3104PosLbPpiu0036.genFieldCondition())
						.confReference(EHeaderMetadataShared.R031.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(4, null, "Lokasi Negara",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3104PosLbPpiu0036.genFieldCondition())
						.confReference(EHeaderMetadataShared.R024.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Hubungan Pihak Terkait",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3104PosLbPpiu0036.genFieldCondition())
						.confReference(EHeaderMetadataShared.R007.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		return res;
	}
}
