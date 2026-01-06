package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3036PosLbAsrjs228;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb228 extends BaseMetadata {

	public Lb228(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_228;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 10, 10, ER3036PosLbAsrjs228.genFieldSave(), null,
				ER3036PosLbAsrjs228.getRequiredPos());
		res.addSegmentValidations(ER3036PosLbAsrjs228.genValidationSubJumlahA());
		res.addSegmentValidations(ER3036PosLbAsrjs228.genValidationSubJumlahB());
		res.addSegmentValidations(ER3036PosLbAsrjs228.genValidationTotalPenyisihanKontribusi());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3036_LB228.getObject())).confUnique(U));
		fs.add(sf(2, null, "Penyisihan Kontribusi Polis-polis Kontribusi Tunggal - Penyisihan Risiko",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Penyisihan Kontribusi Polis-polis Kontribusi Tunggal - Penyisihan Risiko atas PAYDI",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Penyisihan Kontribusi Polis-polis Kontribusi Tunggal - Penyisihan Akumulasi Dana",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Penyisihan Kontribusi Polis-polis Paid-up - Penyisihan Risiko",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Penyisihan Kontribusi Polis-polis Paid-up - Penyisihan Risiko atas PAYDI",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Penyisihan Kontribusi Polis-polis Paid-up - Penyisihan Akumulasi Dana",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Penyisihan Kontribusi Polis-polis Reguler (Cicilan) - Penyisihan Risiko",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Penyisihan Kontribusi Polis-polis Reguler (Cicilan) - Penyisihan Risiko atas PAYDI",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Penyisihan Kontribusi Polis-polis Reguler (Cicilan) - Penyisihan Akumulasi Dana",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "TOTAL", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3036PosLbAsrjs228.genFieldValidation11()));
		fs.add(sf(12, null, "Penyisihan Kontribusi Polis-polis Yang Akan Jatuh Tempo < 1 tahun",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "Periode......... Sebelumnya", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
