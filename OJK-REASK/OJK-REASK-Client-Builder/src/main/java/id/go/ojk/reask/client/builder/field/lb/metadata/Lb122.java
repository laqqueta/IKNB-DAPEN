package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.lb.reference.ER3062PosLbReask122;

public class Lb122 extends BaseMetadata {

	public Lb122(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_122;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 5, 5, ER3062PosLbReask122.genFieldSave(), null, ER3062PosLbReask122.getRequiredPos());
		res.addSegmentValidations(ER3062PosLbReask122.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3062_LB122.getObject())));
		fs.add(sf(2, null, "Aset - Rupiah", sv(M, 1, 16, numeric)));
		fs.add(sf(3, null, "Aset - Valas", sv(M, 1, 16, numeric)));
		fs.add(sf(4, null, "Aset - Total", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3062PosLbReask122.genFieldValidation4()));
		fs.add(sf(5, null, "Liabilitas - Rupiah", sv(M, 1, 16, numeric)));
		fs.add(sf(6, null, "Liabilitas - Valas", sv(M, 1, 16, numeric)));
		fs.add(sf(7, null, "Liabilitas - Total", sv(M, 1, 16, numeric))
				.addFieldValidations(ER3062PosLbReask122.genFieldValidation7()));
		return res;
	}
}
