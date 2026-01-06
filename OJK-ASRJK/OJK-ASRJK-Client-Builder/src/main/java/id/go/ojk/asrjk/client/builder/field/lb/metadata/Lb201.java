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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3032PosLbAsrjk201;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb201 extends BaseMetadata {

	public Lb201(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_201;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 19, 19, ER3032PosLbAsrjk201.genFieldSave(),
				ER3032PosLbAsrjk201.genFieldSave(), ER3032PosLbAsrjk201.getRequiredPos());
		res.addSegmentValidations(ER3032PosLbAsrjk201.genValidationPremiProduksiBaruPerorangan());
		res.addSegmentValidations(ER3032PosLbAsrjk201.genValidationPremiProduksiBaru());
		res.addSegmentValidations(ER3032PosLbAsrjk201.genValidationPremiLanjutan());
		res.addSegmentValidations(ER3032PosLbAsrjk201.genValidationPremiTopup());
		res.addSegmentValidations(ER3032PosLbAsrjk201.genValidationPendapatanPremi());
		res.addSegmentValidations(ER3032PosLbAsrjk201.genValidationPenurunanCapybmp());
		res.addSegmentValidations(ER3032PosLbAsrjk201.genValidationPendapatanPremiNeto());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3032_LB201.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kematian Jangka Warsa", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Endowment dan/atau Kombinasinya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Seumur Hidup", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Anuitas", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Kematian Ekawarsa", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Kecelakaan Diri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Kesehatan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Lainnya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Jumlah Tradisional", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3032PosLbAsrjk201.genFieldValidation10()));
		fs.add(sf(11, null, "Premi PAYDI Digaransi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(12, null, "Premi PAYDI Tidak Digaransi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "Jumlah PAYDI", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3032PosLbAsrjk201.genFieldValidation13()));
		return res;
	}
}
