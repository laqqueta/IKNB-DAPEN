package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3009PosLbAsrjs400;
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
				new ArrayList<>(), extension, 12, 12, ER3009PosLbAsrjs400.genFieldSave(), null,
				ER3009PosLbAsrjs400.getRequiredPos());
		res.addSegmentValidations(ER3009PosLbAsrjs400.genValidationPenambahan());
		res.addSegmentValidations(ER3009PosLbAsrjs400.genValidationPengurangan());
		res.addSegmentValidations(ER3009PosLbAsrjs400.genValidationSaldoAkhirDana());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3009_LB400.getObject())).confUnique(U));
		fs.add(sf(2, null, "Dana Perusahaan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3009PosLbAsrjs400.genConditional2())));
		fs.add(sf(3, null, "Dana Tabarru'",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3009PosLbAsrjs400.genConditional3())));
		fs.add(sf(4, null, "Dana Tanahud",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3009PosLbAsrjs400.genConditional4())));
		fs.add(sf(5, null, "Dana Investasi Peserta",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3009PosLbAsrjs400.genConditional5())));
		fs.add(sf(6, null, "Gabungan", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3009PosLbAsrjs400.genValidation6()));
		return res;
	}
}
