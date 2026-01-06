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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3033PosLbAsrjk202;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb202 extends BaseMetadata {

	public Lb202(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_202;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 33, 33, ER3033PosLbAsrjk202.genFieldSave(), null,
				ER3033PosLbAsrjk202.getRequiredPos());
		res.addSegmentValidations(ER3033PosLbAsrjk202.genValidationPremiProduksiBaruSetelahKlaim());
		res.addSegmentValidations(ER3033PosLbAsrjk202.genValidationPremiLanjutanSetelahKlaim());
		res.addSegmentValidations(ER3033PosLbAsrjk202.genValidationPremiBaruDanLanjutanSetelahKlaim());
		res.addSegmentValidations(ER3033PosLbAsrjk202.genValidationKlaimDanManfaatDibayar());
		res.addSegmentValidations(ER3033PosLbAsrjk202.genValidationKlaimReasuransi());
		res.addSegmentValidations(ER3033PosLbAsrjk202.genValidationBiayaAkuisisi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3033_LB202.getObject())).confUnique(U));
		fs.add(sf(2, null, "Kematian Jangka Warsa", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Endowment dan/atau Kombinasinya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Seumur Hidup", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Anuitas", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Kematian Ekawarsa", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Kecelakaan Diri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Kesehatan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Lainnya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Jumlah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3033PosLbAsrjk202.genFieldValidation10()));
		return res;
	}
}
