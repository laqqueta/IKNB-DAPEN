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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3038PosLbAsrjk115;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb115 extends BaseMetadata {

	public Lb115(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_115;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 51, 51, ER3038PosLbAsrjk115.genFieldSave(), null,
				ER3038PosLbAsrjk115.getRequiredPos());
		res.addSegmentValidations(ER3038PosLbAsrjk115.genValidationInvestasi());
		res.addSegmentValidations(ER3038PosLbAsrjk115.genValidationBukanInvestasi());
		res.addSegmentValidations(ER3038PosLbAsrjk115.genValidationAsetLancar());
		res.addSegmentValidations(ER3038PosLbAsrjk115.genValidationCadanganTeknis());
		res.addSegmentValidations(ER3038PosLbAsrjk115.genValidationUtang());
		res.addSegmentValidations(ER3038PosLbAsrjk115.genValidationLiabilitasLancar());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3038_LB115.getObject())).confUnique(U));
		fs.add(sf(2, null, "Per  Triwulan Berjalan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Per  Triwulan Sama Tahun Sebelumnya", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
