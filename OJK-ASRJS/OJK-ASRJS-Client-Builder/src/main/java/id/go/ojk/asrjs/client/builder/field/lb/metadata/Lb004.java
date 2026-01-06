package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3004PosLbAsrjs004;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb004 extends BaseMetadata {

	public Lb004(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_004;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 8, 8, ER3004PosLbAsrjs004.genFieldSave(), null, 
				ER3004PosLbAsrjs004.getRequiredPos());
		res.addSegmentValidations(ER3004PosLbAsrjs004.genValidationNumeric());
		res.addSegmentValidations(ER3004PosLbAsrjs004.genValidationNumericDot());
		res.addSegmentValidations(ER3004PosLbAsrjs004.genValidationTotalBiayaDiklat());
		res.addSegmentValidations(ER3004PosLbAsrjs004.genValidationRasioBiayaDiklatDanBiayaPegawaiDanPengurus());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3004_LB004.getObject())).confUnique(U));
		fs.add(sf(2, null, "Anggaran", sv(M, 1, 16, all)));
		fs.add(sf(3, null, "Realisasi", sv(M, 1, 16, all)));
		return res;
	}
}
