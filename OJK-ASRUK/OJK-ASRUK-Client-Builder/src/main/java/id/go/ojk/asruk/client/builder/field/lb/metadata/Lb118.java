package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3044PosLbAsruk118;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb118 extends BaseMetadata {

	public Lb118(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_118;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 5, 5, ER3044PosLbAsruk118.genFieldSave(), null,
				ER3044PosLbAsruk118.getRequiredPos());
		res.addSegmentValidations(ER3044PosLbAsruk118.genValidationKlaimPenebusanUnit());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3044_LB118.getObject())).confUnique(U));
		fs.add(sf(2, null, "Klaim Risiko", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Klaim PAYDI Digaransi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Klaim PAYDI Tidak Digaransi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Jumlah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3044PosLbAsruk118.genFieldValidation5()));
		return res;
	}
}
