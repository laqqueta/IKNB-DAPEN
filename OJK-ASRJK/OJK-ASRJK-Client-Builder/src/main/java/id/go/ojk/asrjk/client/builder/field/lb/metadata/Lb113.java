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
import id.go.ojk.asrjk.client.builder.field.lb.reference.ER3030PosLbAsrjk113;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb113 extends BaseMetadata {

	public Lb113(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_113;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 6, 6, ER3030PosLbAsrjk113.genFieldSave(),
				ER3030PosLbAsrjk113.genFieldSave(), ER3030PosLbAsrjk113.getRequiredPos());
		res.addSegmentValidations(ER3030PosLbAsrjk113.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3030_LB113.getObject())).confUnique(U));
		fs.add(sf(2, null, "Cadangan Klaim Dalam Proses Penyelesaian-Total", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Cadangan Klaim Dalam Proses Penyelesaian-Retensi Sendiri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Cadangan Klaim IBNR-Total", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Cadangan Klaim IBNR-Retensi Sendiri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Cadangan Klaim Pembayaran Klaim Berkala-Total",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3030PosLbAsrjk113.genConditionalMustEmpty())));
		fs.add(sf(7, null, "Cadangan Klaim Pembayaran Klaim Berkala-Retensi Sendiri",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3030PosLbAsrjk113.genConditionalMustEmpty())));
		fs.add(sf(8, null, "Total Cadangan Klaim", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3030PosLbAsrjk113.genFieldValidation8A())
				.addFieldValidations(ER3030PosLbAsrjk113.genFieldValidation8B()));
		fs.add(sf(9, null, "Cad.Klaim<1 Tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Per Triwulan Yang Sama Tahun Sebelumnya", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
