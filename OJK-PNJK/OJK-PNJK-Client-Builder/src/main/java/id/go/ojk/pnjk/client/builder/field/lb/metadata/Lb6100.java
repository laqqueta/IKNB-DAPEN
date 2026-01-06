package id.go.ojk.pnjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.pnjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.pnjk.client.builder.field.lb.reference.ER3036PosLbPnjk6100;

public class Lb6100 extends BaseMetadata {

	public Lb6100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_6100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 4, 4, ER3036PosLbPnjk6100.genFieldSave(), ER3036PosLbPnjk6100.genFieldSave(),
				ER3036PosLbPnjk6100.getRequiredPos());
		res.addSegmentValidations(ER3036PosLbPnjk6100.genValidation6());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3036_LB6100.getObject())).confUnique(U));
		fs.add(sf(2, null, "Nilai", sv(M, 1, 16, numeric)));
		return res;
	}
}
