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
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3008PosLbAsruk400;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb400 extends BaseMetadata {

	public Lb400(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_400;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 12, null, ER3008PosLbAsruk400.genFieldSave(),
				ER3008PosLbAsruk400.genFieldSave(), ER3008PosLbAsruk400.getRequiredPos());
		res.addSegmentValidations(ER3008PosLbAsruk400.genValidationPenambahan());
		res.addSegmentValidations(ER3008PosLbAsruk400.genValidationPengurangan());
		res.addSegmentValidations(ER3008PosLbAsruk400.genValidationSaldoAkhirSAK());
		res.addSegmentValidations(ER3008PosLbAsruk400.genValidationSaldoAkhirSAP());
		res.addSegmentValidations(ER3008PosLbAsruk400.genValidationPerubahanEkuitasSAK());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3008_LB400.getObject())));
		fs.add(sf(2, null, "Rincian",
				sv(C, 1, 100, all).confConditionalRequired(ER3008PosLbAsruk400.genConditionalExistPos2())));
		fs.add(sf(3, null, "Tahun Berjalan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Tahun Sebelumnya", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
