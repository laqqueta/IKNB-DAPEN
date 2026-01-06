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
import id.go.ojk.asrus.client.builder.field.lb.reference.ER3012PosLbAsrus600;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb600 extends BaseMetadata {

	public Lb600(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_600;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 31, 31, ER3012PosLbAsrus600.genFieldSave(), null,
				ER3012PosLbAsrus600.getRequiredPos());
		res.addSegmentValidations(ER3012PosLbAsrus600.genValidationJumlahInvestasi());
		res.addSegmentValidations(ER3012PosLbAsrus600.genValidationJumlahBukanInvestasi());
		res.addSegmentValidations(ER3012PosLbAsrus600.genValidationJumlahAset());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3012_LB600.getObject())).confUnique(U));
		fs.add(sf(2, null, "Saldo Buku Besar (SAK)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Penilaian Berdasarkan SAP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Selisih Berdasarkan Penilaian Berdasarkan SAK dan SAP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "AYD Setelah Batasan Per Perusahaan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "AYD Setelah Batasan Per Jenis Aset", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "AYD Setelah Batasan Afiliasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "AYD Setelah Batasan Luar Negeri (Saldo SAP)", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
