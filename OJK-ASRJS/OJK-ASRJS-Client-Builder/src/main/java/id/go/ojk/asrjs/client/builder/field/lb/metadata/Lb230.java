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
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3039PosLbAsrjs230;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb230 extends BaseMetadata {

	public Lb230(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_230;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 10, 10, ER3039PosLbAsrjs230.genFieldSave(), null,
				ER3039PosLbAsrjs230.getRequiredPos());
		res.addSegmentValidations(ER3039PosLbAsrjs230.genValidationSubJumlahA());
		res.addSegmentValidations(ER3039PosLbAsrjs230.genValidationSubJumlahB());
		res.addSegmentValidations(ER3039PosLbAsrjs230.genValidationTotalPenyisihanAtasRisikoBencana());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3039_LB230.getObject())).confUnique(U));
		fs.add(sf(2, null, "Tradisional", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "PAYDI", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Total", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3039PosLbAsrjs230.genValidation4()));
		fs.add(sf(5, null, "Penyisihan Atas Risiko Bencana untuk polis-polis yang Akan Jatuh Tempo < 1 tahun",
				sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Periode Sebelumnya", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
