package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.lb.reference.ER3015PosLbReask506;

public class Lb506 extends BaseMetadata {

	public Lb506(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_506;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 5, 5, ER3015PosLbReask506.genFieldSave(), null, ER3015PosLbReask506.getRequiredPos());
		res.addSegmentValidations(ER3015PosLbReask506.genValidationNumericNegatif());
		res.addSegmentValidations(ER3015PosLbReask506.genValidationNumericDot());
		res.addSegmentValidations(ER3015PosLbReask506.genValidationMax());
		res.addSegmentValidations(ER3015PosLbReask506.genValidationFaktorPerubahanTingkatBunga());
		res.addSegmentValidations(ER3015PosLbReask506.genValidationPerubahanTingkatBunga());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3015_LB506.getObject())).confUnique(U));
		fs.add(sf(2, null, "Jumlah", sv(M, 1, 16, all)));
		return res;
	}
}
