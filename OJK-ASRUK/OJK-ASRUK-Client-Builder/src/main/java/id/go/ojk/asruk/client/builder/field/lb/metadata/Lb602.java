package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3054PosLbAsruk602;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb602 extends BaseMetadata {

	public Lb602(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_602;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 17, 17, ER3054PosLbAsruk602.genFieldSave(), null,
				ER3054PosLbAsruk602.getRequiredPos());
		res.addSegmentValidations(ER3054PosLbAsruk602.genValidationTotalPenempatanDanaJaminanBaru());
		res.addSegmentValidations(ER3054PosLbAsruk602.genValidationTotalPencairanDanaJaminan());
		res.addSegmentValidations(ER3054PosLbAsruk602.genValidationSaldoAkhirDanaJaminan());
		res.addSegmentValidations(ER3054PosLbAsruk602.genValidationBatasMinimumDanaJaminanI());
		res.addSegmentValidations(ER3054PosLbAsruk602.genValidationBatasMinimumDanaJaminanII());
		res.addSegmentValidations(ER3054PosLbAsruk602.genValidationBatasMinimumDanaJaminanYangDigunakan());
		res.addSegmentValidations(ER3054PosLbAsruk602.genValidationKelebihanDanaJaminan());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3054_LB602.getObject())).confUnique(U));
		fs.add(sf(2, null, "Jumlah", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
