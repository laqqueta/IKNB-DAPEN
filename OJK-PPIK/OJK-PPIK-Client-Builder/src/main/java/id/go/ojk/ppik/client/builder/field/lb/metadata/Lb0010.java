package id.go.ojk.ppik.client.builder.field.lb.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.PATTERN_REFERENCE_1;
import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.date;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.ppik.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.ppik.client.builder.field.lb.reference.ER3001PosLbPpik0010;
import id.go.ojk.ppik.client.builder.field.reference.EHeaderMetadataShared;

public class Lb0010 extends BaseMetadata {

	public Lb0010(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_0010;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 1, null);
		res.setRequiredPos(ER3001PosLbPpik0010.getRequiredPos());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris", sv(M, 10, 10, refTable)
				.confReference(EHeaderMetadataLb.R3001_LB0010.getObject()).confRegex(patternNumeric)));
		fs.add(sf(2, null, "Nomor Izin Usaha", sv(O, 1, 35, all)));
		fs.add(sf(3, null, "Tanggal Izin Usaha",
				sv(C, 8, 8, date).confConditionalRequired(ER3001PosLbPpik0010.genFieldConditionA())));
		fs.add(sf(4, null, "Jenis Perizinan",
				sv(C, 1, 10, refTable).confConditionalRequired(ER3001PosLbPpik0010.genFieldConditionA())
						.confReference(EHeaderMetadataShared.R005.getObject()).confRegex(PATTERN_REFERENCE_1.c())));
		fs.add(sf(5, null, "Keterangan",
				sv(C, 1, 2000, all).confConditionalRequired(ER3001PosLbPpik0010.genFieldConditionalB())));
		return res;
	}
}
