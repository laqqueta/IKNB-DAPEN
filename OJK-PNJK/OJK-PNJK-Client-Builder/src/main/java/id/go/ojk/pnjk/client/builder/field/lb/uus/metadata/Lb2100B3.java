package id.go.ojk.pnjk.client.builder.field.lb.uus.metadata;

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
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3111PosLbPnju2100B3;

public class Lb2100B3 extends BaseMetadata {

	public Lb2100B3(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_2100B3;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 6, 6, ER3111PosLbPnju2100B3.genFieldSave(), null, ER3111PosLbPnju2100B3.getRequiredPos());
		res.addSegmentValidations(ER3111PosLbPnju2100B3.genValidationNumeric());
		res.addSegmentValidations(ER3111PosLbPnju2100B3.genValidationNumericDot());
		res.addSegmentValidations(ER3111PosLbPnju2100B3.genValidation5());
		res.addSegmentValidations(ER3111PosLbPnju2100B3.genValidation6());
		res.addSegmentValidations(ER3111PosLbPnju2100B3.genValidation7());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3111_LB2100B3.getObject())).confUnique(U));
		fs.add(sf(2, null, "Nominal", sv(M, 1, 16, all)));
		return res;
	}
}
