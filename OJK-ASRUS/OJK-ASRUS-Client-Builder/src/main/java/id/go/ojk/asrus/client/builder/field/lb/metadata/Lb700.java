package id.go.ojk.asrus.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrus.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrus.client.builder.field.lb.reference.ER3014PosLbAsrus700;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb700 extends BaseMetadata {

	public Lb700(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_700;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 25, 25, ER3014PosLbAsrus700.genFieldSave(), null,
				ER3014PosLbAsrus700.getRequiredPos());
		res.addSegmentValidations(ER3014PosLbAsrus700.genValidationJumlahInvestasi());
		res.addSegmentValidations(ER3014PosLbAsrus700.genValidationJumlahBukanInvestasi());
		res.addSegmentValidations(ER3014PosLbAsrus700.genValidationJumlahKekayaan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3014_LB700.getObject())).confUnique(U));
		fs.add(sf(2, null, "Saldo Buku Besar (SAK)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Penilaian Berdasarkan SAP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Selisih Penilaian Berdasarkan SAK dan SAP", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3014PosLbAsrus700.genValidation4()));
		fs.add(sf(5, null, "Aset PAYDI Digaransi", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
