package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3044PosLbAsrjk210;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb210 extends BaseMetadata {

	public Lb210(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_210;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 7, 7, ER3044PosLbAsrjk210.genFieldSave(), null,
				ER3044PosLbAsrjk210.getRequiredPos());
		res.addSegmentValidations(ER3044PosLbAsrjk210.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3044_LB210.getObject())).confUnique(U));
		fs.add(sf(2, null, "Tradisional-Premi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Tradisional-Jumlah Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Tradisional-Klaim", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Tradisional-Jumlah Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Tradisional-Cadangan Teknis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Tradisional-Jumlah Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "PAYDI-Premi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "PAYDI-Jumlah Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "PAYDI-Klaim", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "PAYDI-Jumlah Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(12, null, "PAYDI-Cadangan Teknis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "PAYDI-Jumlah Polis", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
