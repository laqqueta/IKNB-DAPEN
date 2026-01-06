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
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3023PosLbAsrjs215;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb215 extends BaseMetadata {

	public Lb215(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_215;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 33, 33, ER3023PosLbAsrjs215.genFieldSave(), null,
				ER3023PosLbAsrjs215.getRequiredPos());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationSahamSyariahA());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationSahamSyariahB());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationReksaDanaSyariahA());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationReksaDanaSyariahB());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationReksaDanaSyariahCampuranA());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationReksaDanaSyariahCampuranB());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationEfekBeragunAsetSyariahA());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationEfekBeragunAsetSyariahB());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationPenyertaanLangsungA());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationPenyertaanLangsungB());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationPropertyInvestasiA());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationPropertyInvestasiB());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationTotalA());
		res.addSegmentValidations(ER3023PosLbAsrjs215.genValidationTotalB());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3023_LB215.getObject())).confUnique(U));
		fs.add(sf(2, null, "Jumlah AYD Dana Perusahaan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Jumlah AYD Dana Tabarru' dan Dana Tanahud", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Jumlah AYD PAYDI (digaransi)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Faktor",
				sv(C, 1, 6, numericDotNegatif).confConditionalRequired(ER3023PosLbAsrjs215.genConditional5()))
						.addFieldValidations(ER3023PosLbAsrjs215.genValidation5()));
		fs.add(sf(6, null, "Jumlah Deviasi Dana Perusahaan", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER3023PosLbAsrjs215.genValidation6()));
		fs.add(sf(7, null, "Jumlah Deviasi Dana Tabarru' dan Dana Tanahud", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER3023PosLbAsrjs215.genValidation7()));
		fs.add(sf(8, null, "Jumlah Deviasi PAYDI (digaransi)", sv(M, 1, 16, numericDotNegatif))
				.addFieldValidations(ER3023PosLbAsrjs215.genValidation8()));
		return res;
	}
}
