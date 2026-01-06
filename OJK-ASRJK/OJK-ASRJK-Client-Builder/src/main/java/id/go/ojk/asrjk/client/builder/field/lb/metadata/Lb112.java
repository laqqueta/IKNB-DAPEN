package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3029PosLbAsrjk112;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb112 extends BaseMetadata {

	public Lb112(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_112;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 9, 9, ER3029PosLbAsrjk112.genFieldSave(),
				ER3029PosLbAsrjk112.genFieldSave(), ER3029PosLbAsrjk112.getRequiredPos());
		res.addSegmentValidations(ER3029PosLbAsrjk112.genValidationCapybmp());
		res.addSegmentValidations(ER3029PosLbAsrjk112.genValidationCarybd());
		res.addSegmentValidations(ER3029PosLbAsrjk112.genValidationMax());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3029_LB112.getObject())).confUnique(U));
		fs.add(sf(2, null, "Periode Ini - Cadangan Premi Polis-Polis Premi Tunggal",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3029PosLbAsrjk112.genCondition2346())));
		fs.add(sf(3, null, "Periode Ini - Cadangan Premi Polis-Polis Premi Paid-Up",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3029PosLbAsrjk112.genCondition2346())));
		fs.add(sf(4, null, "Periode Ini - Cadangan Premi Polis-Polis Reguler (cicilan)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3029PosLbAsrjk112.genCondition2346())));
		fs.add(sf(5, null, "Periode Ini - Total", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3029PosLbAsrjk112.genFieldValidation5()));
		fs.add(sf(6, null, "CAPYBMP Polis-polis Yang Akan Jatuh Tempo < 1 tahun",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3029PosLbAsrjk112.genCondition2346())));
		fs.add(sf(7, null, "Periode sebelumnya", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
