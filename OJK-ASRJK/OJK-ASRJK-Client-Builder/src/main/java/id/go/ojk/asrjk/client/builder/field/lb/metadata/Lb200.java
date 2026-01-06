package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3006PosLbAsrjk200;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb200 extends BaseMetadata {

	public Lb200(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_200;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 36, 36, ER3006PosLbAsrjk200.genFieldSave(), null,
				ER3006PosLbAsrjk200.getRequiredPos());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genValidationPendapatanPremiNeto());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genValidationPendapatan());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genValidationBebanKlaimDanManfaat());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genValidationBiayaAkuisisi());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genValidationBebanAsuransi());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genValidationBebanUsaha());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genValidationBeban());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genValidationKenaikanNilaiAset());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genValidationLabaSebelumPajak());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genValidationLabaKomprehensif());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genFormValidationHasilInvestasiTradisional());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genFormValidationHasilInvestasiPaydi());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genFormValidationPendapatanPremiTradisional());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genFormValidationPendapatanPremiNetoTradisional());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genFormValidationKlaimPenebusanUnit());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genFormValidationPendapatanPremiNetoPaydi());
		res.addSegmentValidations(ER3006PosLbAsrjk200.genFormValidationPendapatanPremiPaydi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3006_LB200.getObject())).confUnique(U));
		fs.add(sf(2, null, "Tradisional",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3006PosLbAsrjk200.genConditionalExistPos2())));
		fs.add(sf(3, null, "PAYDI",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3006PosLbAsrjk200.genConditionalExistPos3())));
		fs.add(sf(4, null, "Jurnal Eliminasi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3006PosLbAsrjk200.genConditionalExistPos4())));
		fs.add(sf(5, null, "Gabungan", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3006PosLbAsrjk200.genValidation5()));
		return res;
	}
}
