package id.go.ojk.asrjk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3018PosLbAsrjk101;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb101 extends BaseMetadata {

	public Lb101(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_101;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 43, 43, ER3018PosLbAsrjk101.genFieldSave(),
				ER3018PosLbAsrjk101.genFieldSave(), ER3018PosLbAsrjk101.getRequiredPos());
		res.addSegmentValidations(ER3018PosLbAsrjk101.genValidationJumlahInvestasi());
		res.addSegmentValidations(ER3018PosLbAsrjk101.genValidationJumlahBukanInvestasi());
		res.addSegmentValidations(ER3018PosLbAsrjk101.genValidationJumlahAset());
		res.addSegmentValidations(ER3018PosLbAsrjk101.genValidationJumlahLiabilitas());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3018_LB101.getObject())).confUnique(U));
		fs.add(sf(2, null, "Saldo SAK", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Penilaian Berdasarkan SAP",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3018PosLbAsrjk101.genConditionalMustEmpty3())));
		fs.add(sf(4, null, "Selisih Penilaian SAK dan SAP", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Aset Yang Tidak Diperkenankan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3018PosLbAsrjk101.genConditionalMustEmpty5())));
		fs.add(sf(6, null, "Aset Yang Diperkenankan (Saldo SAP)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3018PosLbAsrjk101.genConditionalMustEmpty6())));
		return res;
	}
}
