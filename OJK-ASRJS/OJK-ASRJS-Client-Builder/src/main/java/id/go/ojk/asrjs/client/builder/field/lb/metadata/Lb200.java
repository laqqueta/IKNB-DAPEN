package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3007PosLbAsrjs200;
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
				new ArrayList<>(), extension, 41, 41, ER3007PosLbAsrjs200.genFieldSave(), null,
				ER3007PosLbAsrjs200.getRequiredPos());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationJumlahHasilInvestasiA());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationJumlahHasilInvestasiB());
		res.addSegmentValidations(
				ER3007PosLbAsrjs200.genValidationJumlahPendapatanHasilInvestasiDanUjrohPengelolaanInvestasi());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationKontribusiNeto());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationJumlahPendapatanKontribusiNeto());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationPendapatanUnderwriting());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationJumlahBebanKlaimNetto());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationJumlahBebanUnderwriting());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationJumlahSurplusDefisitUnderwriting());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationBebanUmumDanAdministrasi());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationJumlahBebanUsaha());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationLabaRugiUsahaAsuransiA());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationLabaRugiUsahaAsuransiB());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationLabaRugiUsahaAsuransiC());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationLabaRugiSebelumPajak());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationLabaSetelahPajak());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationJumlahKinerjaSeluruhDanaA());
		res.addSegmentValidations(ER3007PosLbAsrjs200.genValidationJumlahKinerjaSeluruhDanaB());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3007_LB200.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Perusahaan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3007PosLbAsrjs200.genConditional2())));
		fs.add(sf(3, null, "Dana Tabarru'",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3007PosLbAsrjs200.genConditional3())));
		fs.add(sf(4, null, "Dana Tanahud",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3007PosLbAsrjs200.genConditional4())));
		fs.add(sf(5, null, "Akad Wakalah Bil Ujrah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3007PosLbAsrjs200.genConditional5())));
		fs.add(sf(6, null, "Akad Mudharabah",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3007PosLbAsrjs200.genConditional6())));
		fs.add(sf(7, null, "Penyesuaian",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3007PosLbAsrjs200.genConditional7())));
		fs.add(sf(8, null, "Gabungan", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3007PosLbAsrjs200.genValidation8()));
		return res;
	}
}
