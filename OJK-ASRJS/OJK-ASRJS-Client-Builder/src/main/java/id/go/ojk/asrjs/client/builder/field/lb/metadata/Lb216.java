package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3024PosLbAsrjs216;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb216 extends BaseMetadata {

	public Lb216(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_216;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 51, 51, ER3024PosLbAsrjs216.genFieldSave(), null,
				ER3024PosLbAsrjs216.getRequiredPos());
		res.addSegmentValidations(ER3024PosLbAsrjs216.genValidationNumericNegative());
		res.addSegmentValidations(ER3024PosLbAsrjs216.genValidationNumericDotNegative());
		res.addSegmentValidations(ER3024PosLbAsrjs216.genValidationLiabilitas());
		res.addSegmentValidations(ER3024PosLbAsrjs216.genValidationJumlahLiabilitasA());
		res.addSegmentValidations(ER3024PosLbAsrjs216.genValidationJumlahLiabilitasB());
		res.addSegmentValidations(ER3024PosLbAsrjs216.genValidationJumlahLiabilitasC());
		res.addSegmentValidations(ER3024PosLbAsrjs216.genValidationJumlahAsetYangDiperkenankanDalamRupiah());
		res.addSegmentValidations(ER3024PosLbAsrjs216.genValidationJumlahLiabilitasDalamRupiah());
		res.addSegmentValidations(ER3024PosLbAsrjs216.genValidationSelisihAsetYangDiperkenankanAtasLiabilitas());
		res.addSegmentValidations(ER3024PosLbAsrjs216.genValidationFactorA());
		res.addSegmentValidations(ER3024PosLbAsrjs216.genValidationFactorB());
		res.addSegmentValidations(ER3024PosLbAsrjs216.genValidationJumlahDeviasi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3024_LB216.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Perusahaan-USD",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional2())));
		fs.add(sf(3, null, "Dana Perusahaan-JPY",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional3())));
		fs.add(sf(4, null, "Dana Perusahaan-AUD",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional4())));
		fs.add(sf(5, null, "Dana Perusahaan-EUR",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional5())));
		fs.add(sf(6, null, "Dana Perusahaan-SGD",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional6())));
		fs.add(sf(7, null, "Dana Perusahaan-GBP",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional7())));
		fs.add(sf(8, null, "Dana Perusahaan-Lainnya",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional8())));
		fs.add(sf(9, null, "Dana Perusahaan-IDR",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional9())));
		fs.add(sf(10, null, "Dana Perusahaan-Jumlah",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional10()))
						.addFieldValidations(ER3024PosLbAsrjs216.genValidation10()));
		fs.add(sf(11, null, "Dana Tabarru'-USD",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional11())));
		fs.add(sf(12, null, "Dana Tabarru'-JPY",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional12())));
		fs.add(sf(13, null, "Dana Tabarru'-AUD",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional13())));
		fs.add(sf(14, null, "Dana Tabarru'-EUR",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional14())));
		fs.add(sf(15, null, "Dana Tabarru'-SGD",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional15())));
		fs.add(sf(16, null, "Dana Tabarru'-GBP",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional16())));
		fs.add(sf(17, null, "Dana Tabarru'-Lainnya",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional17())));
		fs.add(sf(18, null, "Dana Tabarru'-IDR",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional18())));
		fs.add(sf(19, null, "Dana Tabarru'-Jumlah",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional19()))
						.addFieldValidations(ER3024PosLbAsrjs216.genValidation19()));
		fs.add(sf(20, null, "PAYDI (digaransi)-USD",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional20())));
		fs.add(sf(21, null, "PAYDI (digaransi)-JPY",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional21())));
		fs.add(sf(22, null, "PAYDI (digaransi)-AUD",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional22())));
		fs.add(sf(23, null, "PAYDI (digaransi)-EUR",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional23())));
		fs.add(sf(24, null, "PAYDI (digaransi)-SGD",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional24())));
		fs.add(sf(25, null, "PAYDI (digaransi)-GBP",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional25())));
		fs.add(sf(26, null, "PAYDI (digaransi)-Lainnya",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional26())));
		fs.add(sf(27, null, "PAYDI (digaransi)-IDR",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional27())));
		fs.add(sf(28, null, "PAYDI (digaransi)-Jumlah",
				sv(C, 1, 16, all).confConditionalRequired(ER3024PosLbAsrjs216.genConditional28()))
						.addFieldValidations(ER3024PosLbAsrjs216.genValidation28()));
		return res;
	}
}
