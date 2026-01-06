package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.lb.reference.ER3005PosLbReask100;

public class Lb100 extends BaseMetadata {

	public Lb100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 60, 60, ER3005PosLbReask100.genFieldSave(), null, ER3005PosLbReask100.getRequiredPos());
		res.addSegmentValidations(ER3005PosLbReask100.genValidationSumAset());
		res.addSegmentValidations(ER3005PosLbReask100.genValidationSumInvestasi());
		res.addSegmentValidations(ER3005PosLbReask100.genValidationSumBukanInvestasi());
		res.addSegmentValidations(ER3005PosLbReask100.genValidationSumLiabilitas());
		res.addSegmentValidations(ER3005PosLbReask100.genValidationSumUtang());
		res.addSegmentValidations(ER3005PosLbReask100.genValidationSumCadanganTeknis());
		res.addSegmentValidations(ER3005PosLbReask100.genValidationSumEkuitas());
		res.addSegmentValidations(ER3005PosLbReask100.genValidationSumLiabilitasEkuitasA());
		res.addSegmentValidations(ER3005PosLbReask100.genValidationSumLiabilitasEkuitasB());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationTradisionalSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationPaydiSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationPaydiSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationDepositoTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationSertifikatDepositoTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationSahamTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationObligasiTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationMtnTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationSuratBerhargaNegaraRiTradisionalSak());
		res.addSegmentValidations(
				ER3005PosLbReask100.genFormValidationSuratBerhargaNegaraSelainNegaraRiTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationSuratBerhargaBankIndonesiaTradisionalSak());
		res.addSegmentValidations(
				ER3005PosLbReask100.genFormValidationSuratBerhargaLembagaMultinasionalTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationReksaDanaTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationEfekBeragunAsetTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationDanaInvestasiRealEstatTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationRepoTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationPenyertaanLangsungTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationTanahBangunanTradisionalSak());
		res.addSegmentValidations(
				ER3005PosLbReask100.genFormValidationPembiayaanMelaluiKerjasamaDenganPihakLainTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationEmasMurniTradisionalSak());
		res.addSegmentValidations(
				ER3005PosLbReask100.genFormValidationPinjamanYangDijaminDenganHakTanggunganTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationPinjamanPolisTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationObligasiDaerahTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100
				.genFormValidationDanaInvestasiInfrastrukturBerbentukKontrakInvestasiKolektifTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationInvestasiLainTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationDepositoBerjangkaPaydiSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationSertifikatDepositoPaydiSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationSahamPaydiSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationObligasiKorporasiPaydiSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationMtnPaydiSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationSuratBerhargaNegaraRiPaydiSak());
		res.addSegmentValidations(
				ER3005PosLbReask100.genFormValidationSuratBerhargaNegaraSelainNegaraRiPaydiSaldoSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationSuratBerhargaBankIndonesiaPaydiSak());
		res.addSegmentValidations(
				ER3005PosLbReask100.genFormValidationSuratBerhargaLembagaMultinasionalPaydiSaldoSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationReksaDanaPaydiSaldoSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationEfekBeragunAsetPaydiSaldoSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationRepoPaydiSaldoSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationEmasMurniPaydiSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationKasDanBankSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationBukanInvestasiTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationBukanInvestasiPaydiSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationBukanInvestasiTradisionalSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationBukanInvestasiPaydiSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationUtangTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationUtangPaydiSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationCadanganPremiTradisionalSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationCadanganPremiPaydiSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationCapybmpTradisionalSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationCadanganKlaimTradisionalSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationCadanganAtasRisikoBencanaTradisionalSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationEkuitasTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationEkuitasTradisionalSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationInvestasiTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationBukanInvestasiTradisionalSak2());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationJumlahAsetTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationJumlahUtangTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationCadanganPremiTradisionalSak());
		res.addSegmentValidations(
				ER3005PosLbReask100.genFormValidationCadanganAtasPremiYangBelumMerupakanPendapatanTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationCadanganKlaimTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationCadanganAtasRisikoBencanaTradisionalSak());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationJumlahInvestasiTradisionalSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationJumlahBukanInvestasiTradisionalSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationJumlahAsetTradisionalSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationJumlahAsetTradisionalSap2());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationJumlahLiabilitasTradisionalSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationJumlahAsetPaydiSap());
		res.addSegmentValidations(ER3005PosLbReask100.genFormValidationJumlahLiabilitasPaydiSap());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3005_LB100.getObject())).confUnique(U));
		fs.add(sf(2, null, "Tradisional - Saldo SAK",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3005PosLbReask100.genConditionalExistPos2())));
		fs.add(sf(3, null, "Tradisional - Saldo SAP",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3005PosLbReask100.genConditionalExistPos3())));
		fs.add(sf(4, null, "PAYDI - Saldo SAK",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3005PosLbReask100.genConditionalExistPos4())));
		fs.add(sf(5, null, "PAYDI - Saldo SAP",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3005PosLbReask100.genConditionalExistPos5())));
		fs.add(sf(6, null, "Jurnal Eliminasi - Saldo SAK", sv(O, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Jurnal Eliminasi - Saldo SAP", sv(O, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Gabungan - Saldo SAK", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3005PosLbReask100.genValidation8a())
				.addFieldValidations(ER3005PosLbReask100.genValidation8b()));
		fs.add(sf(9, null, "Gabungan - Saldo SAP", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3005PosLbReask100.genValidation9()));
		fs.add(sf(10, null, "Dana Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3005PosLbReask100.genConditionalExistPos10())));
		fs.add(sf(11, null, "Dana Perusahaan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3005PosLbReask100.genConditionalExistPos11())));
		fs.add(sf(12, null, "Total", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3005PosLbReask100.genValidation12()));
		return res;
	}
}
