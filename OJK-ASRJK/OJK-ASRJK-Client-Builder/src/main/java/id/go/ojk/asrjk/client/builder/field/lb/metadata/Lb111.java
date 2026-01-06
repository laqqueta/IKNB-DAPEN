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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3028PosLbAsrjk111;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb111 extends BaseMetadata {

	public Lb111(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_111;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 18, 18, ER3028PosLbAsrjk111.genFieldSave(),
				ER3028PosLbAsrjk111.genFieldSave(), ER3028PosLbAsrjk111.getRequiredPos());
		res.addSegmentValidations(ER3028PosLbAsrjk111.genValidationAsuransiJiwaTradisional());
		res.addSegmentValidations(ER3028PosLbAsrjk111.genValidationCadanganPremiTradisional());
		res.addSegmentValidations(ER3028PosLbAsrjk111.genValidationAsuransiJiwaPaydi());
		res.addSegmentValidations(ER3028PosLbAsrjk111.genValidationCadanganPremiPaydi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3028_LB111.getObject())).confUnique(U));
		fs.add(sf(2, null, "Cadangan Premi Polis-Polis Premi Tunggal-Cadangan  Risiko", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Cadangan Premi Polis-Polis Premi Tunggal-Cadangan Risiko atas PAYDI",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Cadangan Premi Polis-Polis Premi Tunggal-Cadangan Akumulasi Dana",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Cadangan Premi Polis-Polis Paid-Up-Cadangan  Risiko", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Cadangan Premi Polis-Polis Paid-Up-Cadangan Risiko atas PAYDI",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Cadangan Premi Polis-Polis Paid-Up-Cadangan Akumulasi Dana", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Cadangan Premi Polis-Polis Reguler (Cicilan)-Cadangan  Risiko",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Cadangan Premi Polis-Polis Reguler (Cicilan)-Cadangan Risiko atas PAYDI",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Cadangan Premi Polis-Polis Reguler (Cicilan)-Cadangan Akumulasi Dana",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Total", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3028PosLbAsrjk111.genFieldValidation11A())
				.addFieldValidations(ER3028PosLbAsrjk111.genFieldValidation11B()));
		fs.add(sf(12, null, "Cadangan Premi Polis-Polis Yang Akan Jatuh Tempo < 1 tahun",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "Periode Sebelumnya", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
