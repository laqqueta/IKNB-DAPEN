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
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3022PosLbAsrjs214;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb214 extends BaseMetadata {

	public Lb214(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_214;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 4, 4, ER3022PosLbAsrjs214.genFieldSave(), null,
				ER3022PosLbAsrjs214.getRequiredPos());
		res.addSegmentValidations(ER3022PosLbAsrjs214.genValidationTotalRisikoPasar());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3022_LB214.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Perusahaan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Dana Tabarru dan Dana Tanahud", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "PAYDI (digaransi)", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Total", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3022PosLbAsrjs214.genValidation5()));
		return res;
	}
}
