package id.go.ojk.reass.client.builder.field.lb.metadata;

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
import id.go.ojk.reass.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reass.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reass.client.builder.field.lb.reference.ER3042PosLbReass234;

public class Lb234 extends BaseMetadata {

	public Lb234(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_234;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 17, 17, ER3042PosLbReass234.genFieldSave(), null, ER3042PosLbReass234.getRequiredPos());
		res.addSegmentValidations(ER3042PosLbReass234.genValidationTotalPenempatanDanaJaminanBaru());
		res.addSegmentValidations(ER3042PosLbReass234.genValidationTotalPencairanDanaJaminan());
		res.addSegmentValidations(ER3042PosLbReass234.genValidationSaldoAkhirDanaJaminan());
		res.addSegmentValidations(ER3042PosLbReass234.genValidationBatasMinimumDanaJaminanI());
		res.addSegmentValidations(ER3042PosLbReass234.genValidationBatasMinimumDanaJaminanII());
		res.addSegmentValidations(ER3042PosLbReass234.genValidationBatasMinimumDanaJaminanYangDigunakan());
		res.addSegmentValidations(ER3042PosLbReass234.genValidationDanaJaminanYangDimiliki());
		res.addSegmentValidations(ER3042PosLbReass234.genValidationKelebihanDanaJaminan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3042_LB234.getObject())).confUnique(U));
		fs.add(sf(2, null, "Jumlah", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
