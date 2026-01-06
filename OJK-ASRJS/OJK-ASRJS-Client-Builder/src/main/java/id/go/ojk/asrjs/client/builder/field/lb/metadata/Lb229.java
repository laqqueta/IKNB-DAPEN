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
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3038PosLbAsrjs229;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb229 extends BaseMetadata {

	public Lb229(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_229;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 6, 6, ER3038PosLbAsrjs229.genFieldSave(), null,
				ER3038PosLbAsrjs229.getRequiredPos());
		res.addSegmentValidations(ER3038PosLbAsrjs229.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3038_LB229.getObject())).confUnique(U));
		fs.add(sf(2, null, "Penyisihan Klaim dalam Proses - Total", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Penyisihan Klaim dalam Proses - Retensi Sendiri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Penyisihan Klaim IBNR - Total", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Penyisihan Klaim IBNR - Retensi Sendiri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Penyisihan Pembayaran Klaim Berkala - Total", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Penyisihan Pembayaran Klaim Berkala - Retensi Sendiri", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Total Penyisihan Klaim", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3038PosLbAsrjs229.genFieldValidation8()));
		fs.add(sf(9, null, "Cad. Klaim < 1 tahun", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Periode Sebelumnya", sv(M, 1, 16, numericNegatif)));
		return res;
	}
}
