package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3015PosLbAsrjs701;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb701 extends BaseMetadata {

	public Lb701(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_701;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 4, 4, ER3015PosLbAsrjs701.genFieldSave(), null,
				ER3015PosLbAsrjs701.getRequiredPos());
		res.addSegmentValidations(ER3015PosLbAsrjs701.genValidationJumlahLiabilitas());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3015_LB701.getObject())).confUnique(U));
		fs.add(sf(2, null, "Saldo Buku Besar (SAK)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Penilaian Berdasarkan SAP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Selisih Penilaian SAK dan SAP", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3015PosLbAsrjs701.genFieldValidation4()));
		return res;
	}
}
