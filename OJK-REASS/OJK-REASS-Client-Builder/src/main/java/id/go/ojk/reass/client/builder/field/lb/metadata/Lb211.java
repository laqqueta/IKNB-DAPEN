package id.go.ojk.reass.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericDotNegatif;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reass.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reass.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reass.client.builder.field.lb.reference.ER3019PosLbReass211;

public class Lb211 extends BaseMetadata {

	public Lb211(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_211;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 84, 84, ER3019PosLbReass211.genFieldSave(), null, ER3019PosLbReass211.getRequiredPos());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationInvestasi());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationKategoriLainSesuaiPeringkatBank());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationSukukObligasiKorporasiSyariah());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationMTNSyariah());
		res.addSegmentValidations(
				ER3019PosLbReass211.genValidationSuratBerhargaYangDiterbitkanOlehNegaraSelainNegaraRI());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationPembiayaanMelaluiKerjasamaDenganPihakLain());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationPinjamanYangDijaminDenganHakTanggungan());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationPropertiResidensial());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationPropertiKomersialLainnya());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationSukukDaerah());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationBukanInvestasi());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationAsetReasuransi());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationTagihanKlaimKoasuransi());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationTagihanKlaimKoasuransiLuarNegeri());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationTagihanKontribusiReasuransi());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationTagihanKontribusiReasuransiLuarNegeri());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationTagihanKlaimReasuransi());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationTagihanKlaimReasuransiLuarNegeri());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationTagihanInvestasi());
		res.addSegmentValidations(ER3019PosLbReass211.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3019_LB211.getObject())).confUnique(U));
		fs.add(sf(2, null, "Jumlah AYD - Dana Tabarru", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Jumlah AYD - Dana Perusahaan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Jumlah AYD - PAYDI (digaransi)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Faktor",
				sv(C, 1, 10, numericDotNegatif).confConditionalRequired(ER3019PosLbReass211.genConditional5()))
				.addFieldValidations(ER3019PosLbReass211.genValidation5()));
		fs.add(sf(6, null, "Jumlah Deviasi - Dana Tabarru", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3019PosLbReass211.genValidation6()));
		fs.add(sf(7, null, "Jumlah Deviasi - Dana Perusahaan", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3019PosLbReass211.genValidation7()));
		fs.add(sf(8, null, "Jumlah Deviasi - PAYDI (digaransi)", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3019PosLbReass211.genValidation8()));
		return res;
	}
}
