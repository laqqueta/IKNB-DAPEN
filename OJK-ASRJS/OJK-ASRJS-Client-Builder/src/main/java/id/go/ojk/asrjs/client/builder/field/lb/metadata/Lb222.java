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
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3030PosLbAsrjs222;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb222 extends BaseMetadata {

	public Lb222(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_222;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 9, 9, ER3030PosLbAsrjs222.genFieldSave(), null,
				ER3030PosLbAsrjs222.getRequiredPos());
		res.addSegmentValidations(ER3030PosLbAsrjs222.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3030_LB222.getObject())).confUnique(U));
		fs.add(sf(2, null, "PRBi (Gross)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "ARi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "fcbi",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3030PosLbAsrjs222.genConditional4())));
		fs.add(sf(5, null, "Jumlah Deviasi PRBi", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER3030PosLbAsrjs222.genValidation5()));
		return res;
	}
}
