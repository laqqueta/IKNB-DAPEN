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
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3138PosLbPnju8100;

public class Lb8100 extends BaseMetadata {

	public Lb8100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_8100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 8, 8, ER3138PosLbPnju8100.genFieldSave(), null, ER3138PosLbPnju8100.getRequiredPos());
		res.addSegmentValidations(ER3138PosLbPnju8100.genValidationNumeric());
		res.addSegmentValidations(ER3138PosLbPnju8100.genValidationNumericDot());
		res.addSegmentValidations(ER3138PosLbPnju8100.genValidation7());
		res.addSegmentValidations(ER3138PosLbPnju8100.genValidation8());
		res.addSegmentValidations(ER3138PosLbPnju8100.genValidation9());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3138_LB8100.getObject())).confUnique(U));
		fs.add(sf(2, null, "Usaha Produktif", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Usaha Non-Produktif", sv(M, 1, 16, all)));
		fs.add(sf(4, null, "Jumlah", sv(M, 1, 16, all)).addFieldValidations(ER3138PosLbPnju8100.genFieldValidation4()));
		return res;
	}
}
