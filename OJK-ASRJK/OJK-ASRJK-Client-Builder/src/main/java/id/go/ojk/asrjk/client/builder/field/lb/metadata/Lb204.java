package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.O;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3035PosLbAsrjk204;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb204 extends BaseMetadata {

	public Lb204(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_204;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 49, 49, ER3035PosLbAsrjk204.genFieldSave(),
				ER3035PosLbAsrjk204.genFieldSave(), ER3035PosLbAsrjk204.getRequiredPos());
		res.addSegmentValidations(ER3035PosLbAsrjk204.genValidationPenempatanInvestasiPadaBukanAfiliasi());
		res.addSegmentValidations(ER3035PosLbAsrjk204.genValidationPenempatanInvestasiPadaAfiliasi());
		res.addSegmentValidations(ER3035PosLbAsrjk204.genValidationHasilInvestasiBruto());
		res.addSegmentValidations(ER3035PosLbAsrjk204.genValidationHasilInvestasiNeto());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3035_LB204.getObject())).confUnique(U));
		fs.add(sf(2, null, "Pendapatan Setelah Pajak - Diterima Kas", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Pendapatan Setelah Pajak - Piutang", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Unrealized Gain (Loss)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Total Hasil Investasi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3035PosLbAsrjk204.genFieldValidation5()));
		fs.add(sf(6, null, "Keterangan (Jenis Hasil)", sv(O, 1, 50, all)));
		return res;
	}
}
