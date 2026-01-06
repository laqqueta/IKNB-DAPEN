package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3043PosLbAsrjk209;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb209 extends BaseMetadata {

	public Lb209(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_209;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 24, 24, ER3043PosLbAsrjk209.genFieldSave(), null,
				ER3043PosLbAsrjk209.getRequiredPos());
		res.addSegmentValidations(ER3043PosLbAsrjk209.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3043_LB209.getObject())).confUnique(U));
		fs.add(sf(2, null, "Premi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Jumlah Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Klaim", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Jumlah Polis", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
