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
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3037PosLbAsrjs232;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb232 extends BaseMetadata {

	public Lb232(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_232;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 10, 10, ER3037PosLbAsrjs232.genFieldSave(), null,
				ER3037PosLbAsrjs232.getRequiredPos());
		res.addSegmentValidations(ER3037PosLbAsrjs232.genValidationTotalPARYBD());
		res.addSegmentValidations(ER3037PosLbAsrjs232.genValidationTotalPAKYBMP());
		res.addSegmentValidations(ER3037PosLbAsrjs232.genValidationMaks());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3037_LB232.getObject())).confUnique(U));
		fs.add(sf(2, null, "Penyisihan Kontribusi Polis-polis Kontribusi Tunggal", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Penyisihan Kontribusi Polis-polis Paid-up", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Penyisihan Kontribusi (Polis-polis Reguler (CIcilan))", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Total", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3037PosLbAsrjs232.genValidation5()));
		fs.add(sf(6, null, "Penyisihan Kontribusi Polis-polis Yang Akan Jatuh Tempo", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Total PAKYBMP Periode Sebelumnya", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
