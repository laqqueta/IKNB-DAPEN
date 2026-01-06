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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3031PosLbAsrjk114;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb114 extends BaseMetadata {

	public Lb114(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_114;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 9, 9, ER3031PosLbAsrjk114.genFieldSave(),
				ER3031PosLbAsrjk114.genFieldSave(), ER3031PosLbAsrjk114.getRequiredPos());
		res.addSegmentValidations(ER3031PosLbAsrjk114.genValidationAsuransiJiwa());
		res.addSegmentValidations(ER3031PosLbAsrjk114.genValidationCadanganAtasRisikoBencana());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3031_LB114.getObject())).confUnique(U));
		fs.add(sf(2, null, "Cadangan Atas Risiko Bencana - Retensi Sendiri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Cadangan Atas Risiko Bencana - Reasuransi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Cadangan Premi Polis-Polis Yang Akan Jatuh Tempo < 1 tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Periode Sebelumnya", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
