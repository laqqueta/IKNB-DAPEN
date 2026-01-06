package id.go.ojk.asrus.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrus.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrus.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrus.client.builder.field.lb.reference.ER3007PosLbAsrus200;
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
				new ArrayList<>(), extension, 42, 42, ER3007PosLbAsrus200.genFieldSave(), null,
				ER3007PosLbAsrus200.getRequiredPos());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationJumlahHasilInvestasiA());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationJumlahHasilInvestasiB());
		res.addSegmentValidations(
				ER3007PosLbAsrus200.genValidationJumlahPendapatanHasilInvestasiDanUjrohPengelolaanInvestasi());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationKontribusiNeto());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationJumlahKontribusiBruto());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationJumlahBebanKlaimNettoA());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationJumlahBebanKlaimNettoB());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationJumlahBebanUnderwriting());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationJumlahSurplusDefisitUnderwriting());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationBebanUmumDanAdministrasi());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationJumlahBebanUsaha());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationLabaRugiUsahaAsuransiA());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationLabaRugiUsahaAsuransiB());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationLabaRugiUsahaAsuransiC());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationLabaRugiSebelumPajakA());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationLabaRugiSebelumPajakB());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationJumlahKinerjaSeluruhDanaA());
		res.addSegmentValidations(ER3007PosLbAsrus200.genValidationJumlahKinerjaSeluruhDanaB());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3007_LB200.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Perusahaan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3007PosLbAsrus200.genConditional2())));
		fs.add(sf(3, null, "Dana Tabarru'",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3007PosLbAsrus200.genConditional3())));
		fs.add(sf(4, null, "Akad Wakalah Bil Ujrah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3007PosLbAsrus200.genConditional4())));
		fs.add(sf(5, null, "Akad Mudharabah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3007PosLbAsrus200.genConditional5())));
		fs.add(sf(6, null, "Penyesuaian", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Gabungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3007PosLbAsrus200.genConditional7()))
						.addFieldValidations(ER3007PosLbAsrus200.genValidation7()));
		return res;
	}
}
