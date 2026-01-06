package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3058PosLbAsruk119;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb119 extends BaseMetadata {

	public Lb119(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_119;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 7, null, ER3058PosLbAsruk119.genFieldSave(), null,
				ER3058PosLbAsruk119.getRequiredPos());
		res.addSegmentValidations(ER3058PosLbAsruk119.genValidationSbn());
		res.addSegmentValidations(ER3058PosLbAsruk119.genValidationObligasiSukukInfrastruktur());
		res.addSegmentValidations(ER3058PosLbAsruk119.genValidationReksadanaUnderlyingSbn());
		res.addSegmentValidations(ER3058PosLbAsruk119.genValidationReksadanaPenyertaanTerbatas());
		res.addSegmentValidations(ER3058PosLbAsruk119.genValidationEfekBeragunAset());
		res.addSegmentValidations(ER3058PosLbAsruk119.genValidationInvestasiLain());
		res.addSegmentValidations(ER3058PosLbAsruk119.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3058_LB119.getObject())));
		fs.add(sf(2, null, "Uraian Jenis Investasi",
				sv(C, 1, 100, all).confConditionalRequired(ER3058PosLbAsruk119.genConditionField2())));
		fs.add(sf(3, null, "Seri Efek", sv(C, 1, 100, all)
				.confConditionalRequired(ER3058PosLbAsruk119.genConditionField345())));
		fs.add(sf(4, null, "Jenis Kepemilikan", sv(C, 1, 100, all)
				.confConditionalRequired(ER3058PosLbAsruk119.genConditionField345())));
		fs.add(sf(5, null, "Rating", sv(C, 1, 100, all)
				.confConditionalRequired(ER3058PosLbAsruk119.genConditionField345())));
		fs.add(sf(6, null, "Nama Manajer Investasi", sv(C, 1, 100, all)
				.confConditionalRequired(ER3058PosLbAsruk119.genConditionField6())));
		fs.add(sf(7, null, "Emiten Penerima Dana/Project", sv(C, 1, 100, all)
				.confConditionalRequired(ER3058PosLbAsruk119.genConditionField7())));
		fs.add(sf(8, null, "Saldo SAK", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
