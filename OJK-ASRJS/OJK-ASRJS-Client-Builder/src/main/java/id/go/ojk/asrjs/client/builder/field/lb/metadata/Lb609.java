package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3048PosLbAsrjs609;
import id.go.ojk.asrjs.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb609 extends BaseMetadata {

	public Lb609(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_609;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3048_LB609.getObject())));
		fs.add(sf(2, null, "Masa Pertanggungan",
				sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R027.getObject())));
		fs.add(sf(3, null, "Jenis Polis",
				sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R025.getObject())));
		fs.add(sf(4, null, "Lini Usaha", sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R023.getObject())));
		fs.add(sf(5, null, "Jumlah Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(6, null, "Jumlah Peserta", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Jumlah Uang Pertanggungan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Kontribusi Neto", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Kontribusi Reasuransi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "US $ & Valas Lain", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Rupiah", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(12, null, "Jumlah KYBMP", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3048PosLbAsrjs609.genValidation12()));
		fs.add(sf(13, null, "US & Valas Lain Klaim Dalam Proses", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(14, null, "Rupiah Klaim Dalam Proses", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(15, null, "Jumlah Klaim Dalam Proses", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3048PosLbAsrjs609.genValidation15()));
		fs.add(sf(16, null, "US & Valas Lain IBNR", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(17, null, "Rupiah IBNR", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(18, null, "Jumlah IBNR", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3048PosLbAsrjs609.genValidation18()));
		return res;
	}
}
