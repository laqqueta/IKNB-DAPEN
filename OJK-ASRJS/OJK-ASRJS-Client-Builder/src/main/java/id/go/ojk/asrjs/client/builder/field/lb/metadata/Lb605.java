package id.go.ojk.asrjs.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaSpace;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asrjs.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asrjs.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asrjs.client.builder.field.lb.reference.ER3044PosLbAsrjs605;
import id.go.ojk.asrjs.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb605 extends BaseMetadata {

	public Lb605(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_605;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 0, null);
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3044_LB605.getObject())));
		fs.add(sf(2, null, "Jenis Pertanggungan",
				sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R025.getObject())));
		fs.add(sf(3, null, "Nama Produk Investasi", sv(M, 1, 100, alfaSpace)));
		fs.add(sf(4, null, "Mata Uang", sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R017.getObject())));
		fs.add(sf(5, null, "Cara Bayar", sv(M, 1, 4, refTable).confReference(EHeaderMetadataShared.R026.getObject())));
		fs.add(sf(6, null, "Kontribusi Pertanggungan Baru", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(7, null, "Kontribusi Lanjutan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(8, null, "Kontribusi Top Up", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(9, null, "Kontribusi Risiko", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(10, null, "Kontribusi Investasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(11, null, "Ujroh Pertanggungan Baru", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(12, null, "Ujroh Lanjutan", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(13, null, "Biaya Akuisisi Lainnya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(14, null, "Biaya Pemeliharaan Polis", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(15, null, "Biaya Lainnya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(16, null, "Biaya Pengelolaan Investasi", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(17, null, "Total Biaya", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(18, null, "Total Kontribusi", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3044PosLbAsrjs605.genValidation18()));
		return res;
	}
}
