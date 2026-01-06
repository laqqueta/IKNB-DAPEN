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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3037PosLbAsrjk206;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb206 extends BaseMetadata {

	public Lb206(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_206;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 30, 30, ER3037PosLbAsrjk206.genFieldSave(), null,
				ER3037PosLbAsrjk206.getRequiredPos());
		res.addSegmentValidations(ER3037PosLbAsrjk206.genValidationKlaimDanManfaatDibayar());
		res.addSegmentValidations(ER3037PosLbAsrjk206.genValidationKenaikanCadanganPremiGross());
		res.addSegmentValidations(ER3037PosLbAsrjk206.genValidationKenaikanAsetReasuransiAtasCadanganPremi());
		res.addSegmentValidations(ER3037PosLbAsrjk206.genValidationKenaikanCadanganPremi());
		res.addSegmentValidations(ER3037PosLbAsrjk206.genValidationKenaikanCadanganKlaimGross());
		res.addSegmentValidations(ER3037PosLbAsrjk206.genValidationKenaikanAsetReasuransiAtasCadanganKlaim());
		res.addSegmentValidations(ER3037PosLbAsrjk206.genValidationKenaikanCadanganKlaim());
		res.addSegmentValidations(ER3037PosLbAsrjk206.genValidationKenaikanCadanganAtasRisikoBencana());
		res.addSegmentValidations(ER3037PosLbAsrjk206.genValidationBebanKlaimDanManfaat());
		res.addSegmentValidations(ER3037PosLbAsrjk206.genValidationKenaikanBiayaAkuisisi());
		res.addSegmentValidations(ER3037PosLbAsrjk206.genValidationBebanAsuransi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3037_LB206.getObject())).confUnique(U));
		fs.add(sf(2, null, "Cabang Asuransi Jiwa - Kematian Jangka Warsa", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Cabang Asuransi Jiwa - Endowment dan/atau Kombinasinya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Cabang Asuransi Jiwa - Seumur Hidup", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Cabang Asuransi Jiwa - Anuitas", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Cabang Asuransi Jiwa - Kematian Ekawarsa", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Cabang Asuransi Jiwa - Kecelakaan Diri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Cabang Asuransi Jiwa - Kesehatan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Cabang Asuransi Jiwa - Lainnya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Jumlah", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3037PosLbAsrjk206.genFieldValidation10()));
		return res;
	}
}
