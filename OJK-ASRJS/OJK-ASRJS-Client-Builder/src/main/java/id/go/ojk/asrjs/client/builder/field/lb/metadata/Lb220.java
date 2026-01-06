package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3028PosLbAsrjs220;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb220 extends BaseMetadata {

	public Lb220(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_220;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 9, 9, ER3028PosLbAsrjs220.genFieldSave(), null,
				ER3028PosLbAsrjs220.getRequiredPos());
		res.addSegmentValidations(ER3028PosLbAsrjs220.genValidationTotalA());
		res.addSegmentValidations(ER3028PosLbAsrjs220.genValidationTotalB());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3028_LB220.getObject())).confUnique(U));
		fs.add(sf(2, null, "PAKYMBPi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "ARi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "fpki",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3028PosLbAsrjs220.genConditional4())));
		fs.add(sf(5, null, "Jumlah Deviasi PAKYBMPi", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER3028PosLbAsrjs220.genValidation5()));
		return res;
	}
}
