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
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3034PosLbAsruk203;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb203 extends BaseMetadata {

	public Lb203(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_203;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 17, 17, ER3034PosLbAsruk203.genFieldSave(), null,
				ER3034PosLbAsruk203.getRequiredPos());
		res.addSegmentValidations(ER3034PosLbAsruk203.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3034_LB203.getObject())).confUnique(U));
		fs.add(sf(2, null, "Premi Reasuransi-Dalam Negeri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Premi Reasuransi-ASEAN", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Premi Reasuransi-Lainnya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Premi Reasuransi-Total", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3034PosLbAsruk203.genFieldValidation5()));
		fs.add(sf(6, null, "Komisi Reasuransi-Dalam Negeri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Komisi Reasuransi-ASEAN", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Komisi Reasuransi-Lainnya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Komisi Reasuransi-Total", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3034PosLbAsruk203.genFieldValidation9()));
		return res;
	}
}
