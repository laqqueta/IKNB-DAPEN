package id.go.ojk.reask.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reask.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reask.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reask.client.builder.field.lb.reference.ER3041PosLbReask116;

public class Lb116 extends BaseMetadata {

	public Lb116(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_116;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 3, 3, ER3041PosLbReask116.genFieldSave(), null, ER3041PosLbReask116.getRequiredPos());
		res.addSegmentValidations(ER3041PosLbReask116.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3041_LB116.getObject())).confUnique(U));
		fs.add(sf(2, null, "Cadangan Premi Polis-Polis Premi Tunggal - Cadangan Risiko", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null,
				"Cadangan Premi Polis-Polis Premi Tunggal - Cadangan Akumulasi Dana untuk PAYDI yang digaransi",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null,
				"Cadangan Premi Polis-Polis Premi Tunggal - Cadangan Akumulasi Dana untuk PAYDI yang TIDAK digaransi",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Cadangan Premi Polis-Polis Paid-Up - Cadangan Risiko", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Cadangan Premi Polis-Polis Paid-Up - Cadangan Akumulasi Dana untuk PAYDI yang digaransi",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null,
				"Cadangan Premi Polis-Polis Paid-Up - Cadangan Akumulasi Dana untuk PAYDI yang TIDAK digaransi",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Cadangan Premi Polis-Polis Reguler (Cicilan) - Cadangan Risiko",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null,
				"Cadangan Premi Polis-Polis Reguler (Cicilan) - Cadangan Akumulasi Dana untuk PAYDI yang digaransi",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null,
				"Cadangan Premi Polis-Polis Reguler (Cicilan) - Cadangan Akumulasi Dana untuk PAYDI yang TIDAK digaransi",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Total", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3041PosLbReask116.genFieldValidation11()));
		fs.add(sf(12, null, "Cadangan Premi Polis-polis Yang Akan Jatuh Tempo  1 tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "Triwulan Tahun Periode Sebelumnya", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
