package id.go.ojk.reass.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.reass.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.reass.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.reass.client.builder.field.lb.reference.ER3037PosLbReass229;

public class Lb229 extends BaseMetadata {

	public Lb229(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_229;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 17, 17, ER3037PosLbReass229.genFieldSave(), null, ER3037PosLbReass229.getRequiredPos());
		res.addSegmentValidations(ER3037PosLbReass229.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3037_LB229.getObject())).confUnique(U));
		fs.add(sf(2, null, "Penyisihan Klaim Dalam Proses", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Penyisihan Klaim IBNR", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Penyisihan Klaim Pembayaran Berkala", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(5, null, "Jumlah Penyisihan Klaim", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3037PosLbReass229.genFieldValidation5()));
		return res;
	}
}
